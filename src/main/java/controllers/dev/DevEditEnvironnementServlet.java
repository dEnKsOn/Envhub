package controllers.dev;

import dao.AffectationDAO;
import dao.EnvironnementDAO;
import dao.VersionTechnoDAO;
import dao.ProjetDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.Environnement;
import models.RoleProjet;
import models.Serveur;
import models.Technologie;
import models.TypeEnvironnement;
import models.Utilisateur;
import models.VersionTechno;

import java.io.IOException;
import java.sql.Connection;
import java.util.UUID;

@WebServlet("/dev/mes-projets/environnements/edit")
public class DevEditEnvironnementServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private EnvironnementDAO environnementDAO;
    private AffectationDAO affectationDAO;
    private VersionTechnoDAO versionTechnoDAO;

    @Override
    public void init() throws ServletException {
        this.environnementDAO = new EnvironnementDAO();
        this.affectationDAO = new AffectationDAO();
        this.versionTechnoDAO = new VersionTechnoDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        Utilisateur currentUser = (Utilisateur) session.getAttribute("user");

        String envIdStr = request.getParameter("envId");
        if (envIdStr == null || envIdStr.trim().isEmpty()) {
            response.sendRedirect(request.getContextPath() + "/dev/mes-projets");
            return;
        }

        UUID idProjetPourRedirection = null;

        try {
            UUID idEnv = UUID.fromString(envIdStr);
            Environnement env = environnementDAO.findById(idEnv);
            
            if (env == null) {
                response.sendRedirect(request.getContextPath() + "/dev/mes-projets");
                return;
            }

            idProjetPourRedirection = env.getIdProjet() != null ? env.getIdProjet() : env.getProjet().getIdProjet();

            // SÉCURITÉ : Chef OU Créateur
            RoleProjet monRole = affectationDAO.findRoleOnProjet(idProjetPourRedirection, currentUser.getIdUser());
            boolean isChef = (monRole == RoleProjet.CHEF_PROJET);
            boolean isCreateur = (env.getIdCreator() != null && env.getIdCreator().equals(currentUser.getIdUser())) || 
                                 (env.getCreateur() != null && env.getCreateur().getIdUser().equals(currentUser.getIdUser()));

            if (!isChef && !isCreateur) {
                response.sendRedirect(request.getContextPath() + "/dev/mes-projets/details?id=" + idProjetPourRedirection + "&error=Droits insuffisants");
                return;
            }

            // 1. Mise à jour des informations de base
            env.setTypeEnv(TypeEnvironnement.valueOf(request.getParameter("typeEnv")));
            env.setUrlFront(request.getParameter("urlFront"));
            env.setUrlBack(request.getParameter("urlBack"));
            env.setNomBaseDeDonnees(request.getParameter("dbName"));
            
            String idServeurStr = request.getParameter("serveurId");
            if (idServeurStr != null && !idServeurStr.trim().isEmpty()) {
                UUID idServ = UUID.fromString(idServeurStr);
                env.setIdServ(idServ);
                Serveur s = new Serveur(); s.setIdServ(idServ);
                env.setServeur(s);
            } else {
                env.setIdServ(null);
                env.setServeur(null);
            }

            environnementDAO.update(env);

            // 2. Gestion des Technologies (On efface tout et on recrée)
            Connection conn = utils.DbConnection.getConnection();
            java.sql.PreparedStatement stmt = conn.prepareStatement("DELETE FROM VersionTechno WHERE idEnv = ?");
            stmt.setString(1, env.getIdEnv().toString());
            stmt.executeUpdate();

            // 3. Réinsertion des nouvelles technologies
            String[] technoIds = request.getParameterValues("technoIds[]");
            String[] technoVersions = request.getParameterValues("technoVersions[]");

            if (technoIds != null && technoVersions != null) {
                for (int i = 0; i < technoIds.length; i++) {
                    String tIdStr = technoIds[i];
                    String tVersion = (i < technoVersions.length) ? technoVersions[i] : "";

                    if (tIdStr != null && !tIdStr.trim().isEmpty()) {
                        VersionTechno vt = new VersionTechno();
                        vt.setEnvironnement(env);
                        Technologie techno = new Technologie();
                        techno.setIdTechno(UUID.fromString(tIdStr));
                        vt.setTechnologie(techno);
                        vt.setVersion(tVersion);
                        
                        versionTechnoDAO.save(vt);
                    }
                }
            }

            // =========================================================
            // DÉCLENCHEUR EVENT-DRIVEN : Recalcul de la progression
            // =========================================================
            ProjetDAO projetDAO = new ProjetDAO();
            projetDAO.evaluerProgression(idProjetPourRedirection);

            response.sendRedirect(request.getContextPath() + "/dev/mes-projets/details?id=" + idProjetPourRedirection + "&success=1");

        } catch (Exception e) {
            System.err.println("Erreur POST DevEditEnvironnement : " + e.getMessage());
            if (idProjetPourRedirection != null) {
                response.sendRedirect(request.getContextPath() + "/dev/mes-projets/details?id=" + idProjetPourRedirection + "&error=1");
            } else {
                response.sendRedirect(request.getContextPath() + "/dev/mes-projets?error=1");
            }
        }
    }
}