package controllers.dev;

import dao.AffectationDAO;
import dao.EnvironnementDAO;
import dao.VersionTechnoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.Environnement;
import models.Projet;
import models.RoleProjet;
import models.Technologie;
import models.TypeEnvironnement;
import models.Serveur;
import models.Utilisateur;
import models.VersionTechno;

import java.io.IOException;
import java.util.UUID;

@WebServlet("/dev/mes-projets/environnements/add")
public class DevAddEnvironnementServlet extends HttpServlet {
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

        String projetIdStr = request.getParameter("projetId");

        if (projetIdStr == null || projetIdStr.trim().isEmpty()) {
            response.sendRedirect(request.getContextPath() + "/dev/mes-projets");
            return;
        }

        try {
            UUID idProjet = UUID.fromString(projetIdStr);

            // 1. SÉCURITÉ : Vérification du rôle sur ce projet
            RoleProjet monRole = affectationDAO.findRoleOnProjet(idProjet, currentUser.getIdUser());
            if (monRole == null) {
                response.sendError(HttpServletResponse.SC_FORBIDDEN, "Accès refusé.");
                return;
            }

            TypeEnvironnement requestedType = TypeEnvironnement.valueOf(request.getParameter("typeEnv"));
            
            // 2. RÈGLE MÉTIER : Un développeur ne peut créer que LOCAL ou DEVELOPPEMENT
            if (monRole == RoleProjet.DEVELOPPEUR && 
               (requestedType == TypeEnvironnement.PRODUCTION || requestedType == TypeEnvironnement.STAGING)) {
                response.sendRedirect(request.getContextPath() + "/dev/mes-projets/details?id=" + projetIdStr + "&error=Type non autorisé pour votre rôle.");
                return;
            }

            // 3. Création de l'Environnement (BLINDAGE DES IDs)
            Environnement env = new Environnement();
            env.setIdEnv(UUID.randomUUID()); 
            
            // --- Projet ---
            env.setIdProjet(idProjet); // Pour le DAO (si nécessaire)
            Projet pEnv = new Projet(); 
            pEnv.setIdProjet(idProjet);
            env.setProjet(pEnv);       // Pour le DAO (objet complet)
            
            env.setTypeEnv(requestedType);
            
            // --- Créateur ---
            env.setIdCreator(currentUser.getIdUser()); // Pour éviter le NullPointerException
            env.setCreateur(currentUser);              // Objet complet
            
            // --- Serveur ---
            String idServeurStr = request.getParameter("serveurId");
            if (idServeurStr != null && !idServeurStr.trim().isEmpty()) {
                UUID idServ = UUID.fromString(idServeurStr);
                env.setIdServ(idServ); // Pour éviter le NullPointerException
                
                Serveur s = new Serveur(); 
                s.setIdServ(idServ);
                env.setServeur(s);
            } else {
                env.setIdServ(null);
                env.setServeur(null);
            }
            
            env.setUrlFront(request.getParameter("urlFront"));
            env.setUrlBack(request.getParameter("urlBack"));
            env.setNomBaseDeDonnees(request.getParameter("dbName"));
            
            // SAUVEGARDE ENVIRONNEMENT
            environnementDAO.save(env);

            // 4. Traitement dynamique des Technologies et Versions
            String[] technoIds = request.getParameterValues("technoIds[]");
            String[] technoVersions = request.getParameterValues("technoVersions[]");

            if (technoIds != null && technoVersions != null) {
                for (int i = 0; i < technoIds.length; i++) {
                    String tIdStr = technoIds[i];
                    String tVersion = (i < technoVersions.length) ? technoVersions[i] : "";

                    if (tIdStr != null && !tIdStr.trim().isEmpty()) {
                        VersionTechno vt = new VersionTechno();
                        
                        // L'environnement lié
                        vt.setEnvironnement(env);
                        
                        // La technologie liée
                        Technologie techno = new Technologie();
                        techno.setIdTechno(UUID.fromString(tIdStr));
                        vt.setTechnologie(techno);
                        
                        // La version
                        vt.setVersion(tVersion);
                        
                        // SAUVEGARDE LIAISON
                        versionTechnoDAO.save(vt);
                    }
                }
            }

            // 5. Redirection avec succès
            response.sendRedirect(request.getContextPath() + "/dev/mes-projets/details?id=" + idProjet.toString() + "&success=1");

        } catch (Exception e) {
            System.err.println("Erreur POST DevAddEnvironnement : " + e.getMessage());
            response.sendRedirect(request.getContextPath() + "/dev/mes-projets/details?id=" + projetIdStr + "&error=1");
        }
    }
}