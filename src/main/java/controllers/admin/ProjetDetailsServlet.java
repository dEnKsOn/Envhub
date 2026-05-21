package controllers.admin;

import dao.AffectationDAO;
import dao.ClientDAO;
import dao.EnvironnementDAO;
import dao.ProjetDAO;
import dao.UtilisateurDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.Affectation;
import models.Projet;
import models.RoleProjet;
import models.StatutProjet;
import models.Utilisateur;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Servlet de la page « Détails du projet » : fiche projet, environnements et gestion de l'équipe (affectations).
 * Applique les droits IAM (administrateur, chef de projet, lecture seule) et le pattern Post-Redirect-Get.
 */
@WebServlet("/admin/projets/details")
public class ProjetDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String PROFIL_ADMIN = "Administrateur";

    private ProjetDAO projetDAO;
    private ClientDAO clientDAO;
    private EnvironnementDAO environnementDAO;
    private AffectationDAO affectationDAO;
    private UtilisateurDAO utilisateurDAO;

    /**
     * Initialise les DAO utilisés pour les projets, clients, environnements, affectations et utilisateurs.
     */
    @Override
    public void init() throws ServletException {
        this.projetDAO = new ProjetDAO();
        this.clientDAO = new ClientDAO();
        this.environnementDAO = new EnvironnementDAO();
        this.affectationDAO = new AffectationDAO();
        this.utilisateurDAO = new UtilisateurDAO();
    }

    /**
     * Affiche la page de détails : charge le projet par son id, prépare les données (équipe, environnements, droits)
     * puis transmet la requête à la vue JSP.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!isAuthenticated(request)) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        UUID projetId = parseProjetId(request.getParameter("id"));
        if (projetId == null) {
            response.sendRedirect(request.getContextPath() + "/projets");
            return;
        }

        Projet projet = projetDAO.findById(projetId);
        if (projet == null) {
            response.sendRedirect(request.getContextPath() + "/projets");
            return;
        }

        loadPageData(request, projet);
        request.getRequestDispatcher("/admin/projets/details.jsp").forward(request, response);
    }

    /**
     * Traite les actions du formulaire (formAction) : ajout/retrait de membre ou mise à jour du projet.
     * Vérifie les droits de l'utilisateur connecté avant de déléguer au handler approprié.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!isAuthenticated(request)) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        request.setCharacterEncoding("UTF-8");
        UUID projetId = parseProjetId(request.getParameter("projetId"));
        if (projetId == null) {
            projetId = parseProjetId(request.getParameter("id"));
        }
        if (projetId == null) {
            response.sendRedirect(request.getContextPath() + "/projets");
            return;
        }

        Projet projet = projetDAO.findById(projetId);
        if (projet == null) {
            response.sendRedirect(request.getContextPath() + "/projets");
            return;
        }

        Utilisateur currentUser = getCurrentUser(request);
        boolean isAdmin = isAdministrateur(currentUser);
        RoleProjet roleOnProjet = affectationDAO.findRoleOnProjet(projetId, currentUser.getIdUser());
        boolean isChefProjet = roleOnProjet == RoleProjet.CHEF_PROJET;
        boolean canManageTeam = isAdmin || isChefProjet;
        boolean canEditProjet = isAdmin || isChefProjet;

        String action = request.getParameter("formAction");
        String redirectUrl = request.getContextPath() + "/admin/projets/details?id=" + projetId;

        if ("removeMember".equals(action)) {
            if (!canManageTeam) {
                forwardWithError(request, response, projet, "Vous n'avez pas les droits pour gérer l'équipe.");
                return;
            }
            handleRemoveMember(request, response, projetId, redirectUrl);
            return;
        }

        if ("addMember".equals(action)) {
            if (!canManageTeam) {
                forwardWithError(request, response, projet, "Vous n'avez pas les droits pour gérer l'équipe.");
                return;
            }
            handleAddMember(request, response, projetId, isAdmin, redirectUrl);
            return;
        }

        if ("update".equals(action)) {
            if (!canEditProjet) {
                forwardWithError(request, response, projet, "Vous n'avez pas les droits pour modifier ce projet.");
                return;
            }
            handleUpdateProjet(request, response, projet, redirectUrl);
            return;
        }

        forwardWithError(request, response, projet, "Action non reconnue.");
    }

    /**
     * Ajoute un membre à l'équipe du projet (affectation en base).
     * Valide le rôle (seul l'admin peut nommer un chef), exclut les administrateurs et gère les erreurs SQL métier.
     */
    private void handleAddMember(HttpServletRequest request, HttpServletResponse response, UUID projetId,
                                 boolean isAdmin, String redirectUrl) throws IOException, ServletException {
        String userIdStr = request.getParameter("memberUserId");
        String roleStr = request.getParameter("memberRole");

        if (userIdStr == null || userIdStr.trim().isEmpty() || roleStr == null || roleStr.trim().isEmpty()) {
            Projet projet = projetDAO.findById(projetId);
            forwardWithError(request, response, projet, "Veuillez sélectionner un utilisateur et un rôle.");
            return;
        }

        RoleProjet role;
        try {
            role = RoleProjet.valueOf(roleStr);
        } catch (IllegalArgumentException e) {
            Projet projet = projetDAO.findById(projetId);
            forwardWithError(request, response, projet, "Rôle invalide.");
            return;
        }

        if (role == RoleProjet.CHEF_PROJET && !isAdmin) {
            Projet projet = projetDAO.findById(projetId);
            forwardWithError(request, response, projet, "Seul un administrateur peut affecter un Chef de Projet.");
            return;
        }

        UUID userId;
        try {
            userId = UUID.fromString(userIdStr);
        } catch (IllegalArgumentException e) {
            Projet projet = projetDAO.findById(projetId);
            forwardWithError(request, response, projet, "Utilisateur invalide.");
            return;
        }

        if (affectationDAO.exists(projetId, userId)) {
            Projet projet = projetDAO.findById(projetId);
            forwardWithError(request, response, projet, "Cet utilisateur fait déjà partie de l'équipe.");
            return;
        }

        Utilisateur membre = utilisateurDAO.findById(userId);
        if (membre == null) {
            Projet projet = projetDAO.findById(projetId);
            forwardWithError(request, response, projet, "Utilisateur introuvable.");
            return;
        }

        if (isAdministrateur(membre)) {
            Projet projet = projetDAO.findById(projetId);
            forwardWithError(request, response, projet,
                    "Un administrateur ne peut pas être affecté à l'équipe d'un projet.");
            return;
        }

        Affectation affectation = new Affectation();
        Projet projetRef = new Projet();
        projetRef.setIdProjet(projetId);
        affectation.setProjet(projetRef);
        affectation.setUtilisateur(membre);
        affectation.setRoleProjet(role);

        try {
            if (affectationDAO.save(affectation)) {
                response.sendRedirect(redirectUrl + "&success=true");
            } else {
                Projet projet = projetDAO.findById(projetId);
                forwardWithError(request, response, projet, "Impossible d'ajouter le membre à l'équipe.");
            }
        } catch (SQLException e) {
            Projet projet = projetDAO.findById(projetId);
            forwardWithError(request, response, projet, mapSqlError(e));
        }
    }

    /**
     * Retire un membre de l'équipe en supprimant son affectation pour ce projet.
     * Redirige en cas de succès (PRG), sinon réaffiche la page avec un message d'erreur.
     */
    private void handleRemoveMember(HttpServletRequest request, HttpServletResponse response, UUID projetId,
                                    String redirectUrl) throws IOException, ServletException {
        String userIdStr = request.getParameter("memberUserId");
        if (userIdStr == null || userIdStr.trim().isEmpty()) {
            Projet projet = projetDAO.findById(projetId);
            forwardWithError(request, response, projet, "Membre introuvable pour retrait.");
            return;
        }

        UUID userId;
        try {
            userId = UUID.fromString(userIdStr);
        } catch (IllegalArgumentException e) {
            Projet projet = projetDAO.findById(projetId);
            forwardWithError(request, response, projet, "Identifiant de membre invalide.");
            return;
        }

        if (!affectationDAO.exists(projetId, userId)) {
            Projet projet = projetDAO.findById(projetId);
            forwardWithError(request, response, projet, "Ce membre ne fait pas partie de l'équipe.");
            return;
        }

        if (affectationDAO.delete(projetId, userId)) {
            response.sendRedirect(redirectUrl + "&success=true");
        } else {
            Projet projet = projetDAO.findById(projetId);
            forwardWithError(request, response, projet, "Impossible de retirer le membre de l'équipe.");
        }
    }

    /**
     * Met à jour les informations du projet (nom, client, statut, avancement, dates, description).
     * Parse et valide les champs du formulaire avant d'appeler le DAO.
     */
    private void handleUpdateProjet(HttpServletRequest request, HttpServletResponse response, Projet existing,
                                    String redirectUrl) throws IOException, ServletException {
        String nom = request.getParameter("nom");
        String clientStr = request.getParameter("client");
        String statutStr = request.getParameter("statut");
        String avancementStr = request.getParameter("avancement");
        String dateLancementStr = request.getParameter("dateLancement");
        String dateLivraisonStr = request.getParameter("dateLivraison");
        String description = request.getParameter("description");

        if (nom == null || nom.trim().isEmpty() || clientStr == null || clientStr.trim().isEmpty()) {
            forwardWithError(request, response, existing, "Veuillez remplir les champs obligatoires (Nom, Client).");
            return;
        }

        Projet projet = new Projet();
        projet.setIdProjet(existing.getIdProjet());
        projet.setNomProjet(nom.trim());

        try {
            projet.setIdClient(UUID.fromString(clientStr));
        } catch (IllegalArgumentException e) {
            forwardWithError(request, response, existing, "Client invalide.");
            return;
        }

        try {
            projet.setStatutProjet(statutStr != null && !statutStr.trim().isEmpty()
                    ? StatutProjet.valueOf(statutStr) : StatutProjet.EN_COURS);
        } catch (IllegalArgumentException e) {
            projet.setStatutProjet(StatutProjet.EN_COURS);
        }

        int avancement = 0;
        if (avancementStr != null && !avancementStr.trim().isEmpty()) {
            try {
                avancement = Integer.parseInt(avancementStr);
                avancement = Math.max(0, Math.min(100, avancement));
            } catch (NumberFormatException e) {
                avancement = existing.getPourcentageAvancement();
            }
        }
        projet.setPourcentageAvancement(avancement);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (dateLancementStr != null && !dateLancementStr.trim().isEmpty()) {
            try {
                projet.setDateLancement(sdf.parse(dateLancementStr));
            } catch (ParseException e) {
                forwardWithError(request, response, existing, "Format de date de lancement invalide.");
                return;
            }
        } else {
            projet.setDateLancement(existing.getDateLancement());
        }

        if (dateLivraisonStr != null && !dateLivraisonStr.trim().isEmpty()) {
            try {
                projet.setDateLivraisonEstimee(sdf.parse(dateLivraisonStr));
            } catch (ParseException e) {
                forwardWithError(request, response, existing, "Format de date de livraison invalide.");
                return;
            }
        }

        projet.setDescriptionTech(description != null ? description.trim() : null);

        if (projetDAO.update(projet)) {
            response.sendRedirect(redirectUrl + "&success=true");
        } else {
            forwardWithError(request, response, existing, "Impossible de mettre à jour le projet.");
        }
    }

    /**
     * Charge toutes les données nécessaires à la vue : projet, équipe, environnements, clients,
     * droits IAM de l'utilisateur connecté et liste des utilisateurs éligibles à une affectation.
     */
    private void loadPageData(HttpServletRequest request, Projet projet) {
        UUID projetId = projet.getIdProjet();
        Utilisateur currentUser = getCurrentUser(request);

        List<Affectation> equipe = affectationDAO.findByProjet(projetId);
        List<models.Environnement> environnements = environnementDAO.findByProjet(projetId);

        boolean isAdmin = isAdministrateur(currentUser);
        RoleProjet roleOnProjet = affectationDAO.findRoleOnProjet(projetId, currentUser.getIdUser());
        boolean isChefProjet = roleOnProjet == RoleProjet.CHEF_PROJET;

        request.setAttribute("projet", projet);
        request.setAttribute("equipe", equipe);
        request.setAttribute("environnements", environnements);
        request.setAttribute("listeClients", clientDAO.findAll());

        request.setAttribute("isAdmin", isAdmin);
        request.setAttribute("isChefProjet", isChefProjet);
        request.setAttribute("canManageTeam", isAdmin || isChefProjet);
        request.setAttribute("canEditProjet", isAdmin || isChefProjet);
        request.setAttribute("canAssignChef", isAdmin);

        List<Utilisateur> tousUtilisateurs = utilisateurDAO.findAll();
        List<UUID> membresIds = equipe.stream()
                .map(a -> a.getUtilisateur().getIdUser())
                .collect(Collectors.toList());

        List<Utilisateur> utilisateursDisponibles = tousUtilisateurs.stream()
                .filter(u -> !membresIds.contains(u.getIdUser()))
                .filter(u -> !isAdministrateur(u))
                .collect(Collectors.toList());
        request.setAttribute("utilisateursDisponibles", utilisateursDisponibles);
    }

    /**
     * Réaffiche la page de détails avec un message d'erreur (sans redirection), après rechargement des données.
     */
    private void forwardWithError(HttpServletRequest request, HttpServletResponse response, Projet projet,
                                  String message) throws ServletException, IOException {
        request.setAttribute("erreur", message);
        loadPageData(request, projet);
        request.getRequestDispatcher("/admin/projets/details.jsp").forward(request, response);
    }

    /**
     * Traduit les messages d'erreur SQL des triggers (chef unique, projet clôturé) en messages lisibles pour l'utilisateur.
     */
    private String mapSqlError(SQLException e) {
        String msg = e.getMessage();
        if (msg != null) {
            if (msg.contains("Chef de Projet")) {
                return "Ce projet possède déjà un Chef de Projet.";
            }
            if (msg.contains("clôturé")) {
                return "Modification impossible : le projet est clôturé (Livré ou Annulé).";
            }
        }
        return "Impossible d'effectuer l'affectation. Vérifiez les règles métier.";
    }

    /**
     * Indique si l'utilisateur possède le profil système « Administrateur » (droits globaux sur l'application).
     */
    private boolean isAdministrateur(Utilisateur user) {
        return user != null && user.getProfil() != null
                && PROFIL_ADMIN.equals(user.getProfil().getLibelle());
    }

    /**
     * Récupère l'utilisateur connecté stocké en session (attribut « user »).
     */
    private Utilisateur getCurrentUser(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return null;
        }
        return (Utilisateur) session.getAttribute("user");
    }

    /**
     * Convertit le paramètre id de la requête en UUID ; retourne null si absent ou invalide.
     */
    private UUID parseProjetId(String idParam) {
        if (idParam == null || idParam.trim().isEmpty()) {
            return null;
        }
        try {
            return UUID.fromString(idParam.trim());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    /**
     * Vérifie qu'une session active contient un utilisateur connecté.
     */
    private boolean isAuthenticated(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        return session != null && session.getAttribute("user") != null;
    }
}
