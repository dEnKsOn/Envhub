package controllers.dev;

import dao.AffectationDAO;
import dao.EnvironnementDAO;
import dao.ProjetDAO;
import dao.ServeurDAO;
import dao.TechnologieDAO;
import dao.UtilisateurDAO;
import dao.VersionTechnoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.Affectation;
import models.Environnement;
import models.Projet;
import models.RoleProjet;
import models.StatutProjet;
import models.Utilisateur;

import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@WebServlet("/dev/mes-projets/details")
public class DevProjetDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ProjetDAO projetDAO;
    private EnvironnementDAO environnementDAO;
    private AffectationDAO affectationDAO;
    private UtilisateurDAO utilisateurDAO;
    private ServeurDAO serveurDAO;
    private TechnologieDAO technologieDAO;
    private VersionTechnoDAO versionTechnoDAO;

    @Override
    public void init() throws ServletException {
        this.projetDAO = new ProjetDAO();
        this.environnementDAO = new EnvironnementDAO();
        this.affectationDAO = new AffectationDAO();
        this.utilisateurDAO = new UtilisateurDAO();
        this.serveurDAO = new ServeurDAO();
        this.technologieDAO = new TechnologieDAO();
        this.versionTechnoDAO = new VersionTechnoDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        Utilisateur currentUser = (Utilisateur) session.getAttribute("user");

        String idParam = request.getParameter("id");
        if (idParam == null || idParam.trim().isEmpty()) {
            response.sendRedirect(request.getContextPath() + "/dev/mes-projets");
            return;
        }

        try {
            UUID idProjet = UUID.fromString(idParam);

            // Vérification de sécurité
            RoleProjet monRole = affectationDAO.findRoleOnProjet(idProjet, currentUser.getIdUser());
            if (monRole == null) {
                response.sendError(HttpServletResponse.SC_FORBIDDEN, "Accès refusé : Vous n'êtes pas affecté à ce projet.");
                return;
            }

            Projet projet = projetDAO.findById(idProjet);
            if (projet == null) {
                response.sendRedirect(request.getContextPath() + "/dev/mes-projets");
                return;
            }

            // Récupération des données
            List<Environnement> environnements = environnementDAO.findByProjet(idProjet);
            List<Affectation> equipe = affectationDAO.findByProjet(idProjet);

            // Remplissage des technologies pour la modale "Voir"
            for (Environnement env : environnements) {
                env.setVersions(versionTechnoDAO.findByEnvironnement(env.getIdEnv()));
            }

            request.setAttribute("projet", projet);
            request.setAttribute("environnements", environnements);
            request.setAttribute("equipe", equipe);
            request.setAttribute("monRole", monRole.name());
            
            boolean isChef = (monRole == RoleProjet.CHEF_PROJET);
            request.setAttribute("canEditProjet", isChef);
            request.setAttribute("canManageTeam", isChef);

            // Listes pour la modale Environnement
            request.setAttribute("listeServeurs", serveurDAO.findAll());
            request.setAttribute("listeTechnologies", technologieDAO.findAll());

            // Liste pour la modale Ajout Membre (Chef)
            if (isChef) {
                List<Utilisateur> tousLesUsers = utilisateurDAO.findAll();
                List<Utilisateur> utilisateursDisponibles = tousLesUsers.stream()
                    .filter(u -> "Développeur".equals(u.getProfil().getLibelle()))
                    .filter(u -> equipe.stream().noneMatch(aff -> aff.getUtilisateur().getIdUser().equals(u.getIdUser())))
                    .collect(Collectors.toList());
                request.setAttribute("utilisateursDisponibles", utilisateursDisponibles);
            }

            request.getRequestDispatcher("/dev/projet-details.jsp").forward(request, response);

        } catch (IllegalArgumentException e) {
            response.sendRedirect(request.getContextPath() + "/dev/mes-projets");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        Utilisateur currentUser = (Utilisateur) session.getAttribute("user");

        String formAction = request.getParameter("formAction");
        String projetIdStr = request.getParameter("projetId");

        if (projetIdStr == null || formAction == null) {
            response.sendRedirect(request.getContextPath() + "/dev/mes-projets");
            return;
        }

        try {
            UUID idProjet = UUID.fromString(projetIdStr);

            // Action réservée au CHEF_PROJET
            RoleProjet monRole = affectationDAO.findRoleOnProjet(idProjet, currentUser.getIdUser());
            if (monRole != RoleProjet.CHEF_PROJET) {
                response.sendError(HttpServletResponse.SC_FORBIDDEN, "Action réservée au Chef de Projet.");
                return;
            }

            switch (formAction) {
                case "update":
                    Projet projet = projetDAO.findById(idProjet);
                    if (projet != null) {
                        projet.setNomProjet(request.getParameter("nom"));
                        projet.setStatutProjet(StatutProjet.valueOf(request.getParameter("statut")));
                        projet.setPourcentageAvancement(Integer.parseInt(request.getParameter("avancement")));
                        projet.setDescriptionTech(request.getParameter("description"));
                        
                        String dateLancementStr = request.getParameter("dateLancement");
                        if (dateLancementStr != null && !dateLancementStr.isEmpty()) {
                            projet.setDateLancement(Date.valueOf(dateLancementStr));
                        }
                        
                        String dateLivraisonStr = request.getParameter("dateLivraison");
                        if (dateLivraisonStr != null && !dateLivraisonStr.isEmpty()) {
                            projet.setDateLivraisonEstimee(Date.valueOf(dateLivraisonStr));
                        } else {
                            projet.setDateLivraisonEstimee(null);
                        }
                        projetDAO.update(projet);
                    }
                    break;

                case "addMember":
                    String newMemberIdStr = request.getParameter("memberUserId");
                    String newMemberRole = request.getParameter("memberRole"); 
                    if (newMemberIdStr != null && !newMemberIdStr.isEmpty()) {
                        Affectation nouvelleAffectation = new Affectation();
                        Projet p = new Projet(); p.setIdProjet(idProjet);
                        nouvelleAffectation.setProjet(p);
                        Utilisateur u = new Utilisateur(); u.setIdUser(UUID.fromString(newMemberIdStr));
                        nouvelleAffectation.setUtilisateur(u);
                        nouvelleAffectation.setRoleProjet(RoleProjet.valueOf(newMemberRole));
                        affectationDAO.save(nouvelleAffectation);
                    }
                    break;

                case "removeMember":
                    String memberToRemoveStr = request.getParameter("memberUserId");
                    if (memberToRemoveStr != null && !memberToRemoveStr.isEmpty()) {
                        UUID memberToRemoveId = UUID.fromString(memberToRemoveStr);
                        if (!memberToRemoveId.equals(currentUser.getIdUser())) {
                            affectationDAO.delete(idProjet, memberToRemoveId);
                        }
                    }
                    break;
            }
            response.sendRedirect(request.getContextPath() + "/dev/mes-projets/details?id=" + idProjet.toString() + "&success=1");

        } catch (Exception e) {
            response.sendRedirect(request.getContextPath() + "/dev/mes-projets/details?id=" + projetIdStr + "&error=1");
        }
    }
}