package controllers.dev;

import dao.AffectationDAO;
import dao.EnvironnementDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.Environnement;
import models.RoleProjet;
import models.Utilisateur;

import java.io.IOException;
import java.util.UUID;

@WebServlet("/dev/mes-projets/environnements/delete")
public class DevDeleteEnvironnementServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private EnvironnementDAO environnementDAO;
    private AffectationDAO affectationDAO;

    @Override
    public void init() throws ServletException {
        this.environnementDAO = new EnvironnementDAO();
        this.affectationDAO = new AffectationDAO();
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

            // 1. Récupérer l'environnement cible depuis la BDD
            Environnement env = environnementDAO.findById(idEnv); // Assure-toi d'avoir cette méthode dans ton DAO
            
            if (env == null) {
                response.sendRedirect(request.getContextPath() + "/dev/mes-projets?error=Introuvable");
                return;
            }

            // On garde l'ID du projet pour la redirection finale
            idProjetPourRedirection = env.getIdProjet() != null ? env.getIdProjet() : env.getProjet().getIdProjet();

            // 2. Vérifier le rôle de l'utilisateur sur le projet
            RoleProjet monRole = affectationDAO.findRoleOnProjet(idProjetPourRedirection, currentUser.getIdUser());
            if (monRole == null) {
                response.sendError(HttpServletResponse.SC_FORBIDDEN, "Accès refusé.");
                return;
            }

            // 3. LA RÈGLE DE SÉCURITÉ STRICTE (Chef OU Créateur)
            boolean isChef = (monRole == RoleProjet.CHEF_PROJET);
            
            // On vérifie si l'utilisateur actuel est bien le créateur de cet environnement
            boolean isCreateur = false;
            if (env.getIdCreator() != null) {
                isCreateur = env.getIdCreator().equals(currentUser.getIdUser());
            } else if (env.getCreateur() != null && env.getCreateur().getIdUser() != null) {
                isCreateur = env.getCreateur().getIdUser().equals(currentUser.getIdUser());
            }

            if (!isChef && !isCreateur) {
                // Tentative de fraude détectée : le développeur essaie de supprimer l'environnement d'un autre
                response.sendRedirect(request.getContextPath() + "/dev/mes-projets/details?id=" + idProjetPourRedirection.toString() + "&error=Droits insuffisants");
                return;
            }

            // 4. Exécution de la suppression
            // Note: La suppression en cascade (ON DELETE CASCADE) dans la BDD s'occupera d'effacer les VersionTechno liées !
            environnementDAO.delete(idEnv); 

            // 5. Redirection avec succès
            response.sendRedirect(request.getContextPath() + "/dev/mes-projets/details?id=" + idProjetPourRedirection.toString() + "&success=1");

        } catch (Exception e) {
            System.err.println("Erreur POST DevDeleteEnvironnement : " + e.getMessage());
            if (idProjetPourRedirection != null) {
                response.sendRedirect(request.getContextPath() + "/dev/mes-projets/details?id=" + idProjetPourRedirection.toString() + "&error=1");
            } else {
                response.sendRedirect(request.getContextPath() + "/dev/mes-projets?error=1");
            }
        }
    }
}