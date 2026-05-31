package controllers.admin;

import dao.DemandeProjetDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.DemandeProjet;
import models.StatutDemande;
import utils.DbConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

@WebServlet("/admin/demandes")
public class DemandesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DemandeProjetDAO demandeDAO;

    @Override
    public void init() throws ServletException {
        this.demandeDAO = new DemandeProjetDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!isAuthenticated(request)) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        // Récupération et affichage de toutes les demandes
        request.setAttribute("listeDemandes", demandeDAO.findAll());
        
        // CORRECTION : Une seule redirection vers le wrapper qui gère lui-même le layout
        request.getRequestDispatcher("/admin/demandes.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!isAuthenticated(request)) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("formAction");
        String idDemandeStr = request.getParameter("idDemande");

        // Cas 1 : Suppression d'une demande
        if ("delete".equals(action) && idDemandeStr != null) {
            if (demandeDAO.delete(UUID.fromString(idDemandeStr))) {
                response.sendRedirect(request.getContextPath() + "/admin/demandes?success=true");
            } else {
                forwardWithError(request, response, "Impossible de supprimer la demande.");
            }
            return;
        }

        // Cas 2 : Rejet d'une demande
        if ("rejeter".equals(action) && idDemandeStr != null) {
            DemandeProjet demande = demandeDAO.findById(UUID.fromString(idDemandeStr));
            if (demande != null) {
                demande.setStatutDemande(StatutDemande.REJETE);
                demandeDAO.update(demande);

                // --- AJOUT : Envoi de l'email de rejet ---
                String subject = "Mise à jour concernant votre demande : " + demande.getTitreProjet();
                String messageHtml = "<h3>Bonjour " + demande.getNomClient() + ",</h3>"
                    + "<p>Nous vous remercions de l'intérêt que vous portez à nos services.</p>"
                    + "<p>Après étude attentive de votre cahier des charges concernant le projet <strong>" + demande.getTitreProjet() + "</strong>, "
                    + "nous sommes au regret de vous informer que nous ne pouvons pas y donner suite actuellement (contraintes de faisabilité ou de planning).</p>"
                    + "<p>Nous restons à votre disposition pour de futurs besoins.</p>"
                    + "<p>Cordialement,<br><strong>L'équipe Technique EnvHub</strong></p>";
                    
                utils.EmailUtil.sendEmail(demande.getEmailClient(), subject, messageHtml);
                // -----------------------------------------

                response.sendRedirect(request.getContextPath() + "/admin/demandes?success=true");
            } else {
                forwardWithError(request, response, "Demande introuvable.");
            }
            return;
        }

        // Cas 3 : Acceptation d'une demande
        if ("accepter".equals(action) && idDemandeStr != null) {
            handleAcceptation(UUID.fromString(idDemandeStr), request, response);
            return;
        }

        // Cas 4 : Création manuelle
        if ("create".equals(action)) {
            handleCreationManuelle(request, response);
            return;
        }

        response.sendRedirect(request.getContextPath() + "/admin/demandes");
    }

    private void handleAcceptation(UUID idDemande, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        DemandeProjet demande = demandeDAO.findById(idDemande);
        if (demande == null) {
            forwardWithError(request, response, "Demande introuvable.");
            return;
        }

        UUID idClient = UUID.randomUUID();
        UUID idProjet = UUID.randomUUID();

        // Les requêtes SQL
        String sqlUpdateDemande = "UPDATE DemandeProjet SET statutDemande = 'ACCEPTE', dateTraitement = CURRENT_TIMESTAMP WHERE idDemande = ?";
        
        // CORRECTION ICI : Ajout du champ emailClient
        String sqlInsertClient = "INSERT INTO Client (idClient, nomClient, prenomClient, entrepriseClient, emailClient) VALUES (?, ?, '', ?, ?)";
        
        String sqlInsertProjet = "INSERT INTO Projet (idProjet, nomProjet, descriptionTech, dateLancement, statutProjet, pourcentageAvancement, idClient) VALUES (?, ?, ?, CURRENT_DATE(), 'EN_COURS', 0, ?)";

        try (Connection conn = DbConnection.getConnection()) {
            conn.setAutoCommit(false); 

            try (PreparedStatement stmtDemande = conn.prepareStatement(sqlUpdateDemande);
                 PreparedStatement stmtClient = conn.prepareStatement(sqlInsertClient);
                 PreparedStatement stmtProjet = conn.prepareStatement(sqlInsertProjet)) {

                // 1. Mise à jour de la demande
                stmtDemande.setString(1, idDemande.toString());
                stmtDemande.executeUpdate();

                // 2. Création du client avec l'email !
                stmtClient.setString(1, idClient.toString());
                stmtClient.setString(2, demande.getNomClient());
                stmtClient.setString(3, demande.getEntrepriseClient() != null && !demande.getEntrepriseClient().trim().isEmpty() ? demande.getEntrepriseClient() : "Particulier");
                stmtClient.setString(4, demande.getEmailClient()); // Injection de l'email
                stmtClient.executeUpdate();

                // 3. Création du projet
                stmtProjet.setString(1, idProjet.toString());
                stmtProjet.setString(2, demande.getTitreProjet());
                stmtProjet.setString(3, demande.getDescriptionBesoin());
                stmtProjet.setString(4, idClient.toString());
                stmtProjet.executeUpdate();

                conn.commit(); 

                // --- AJOUT : Envoi de l'email d'acceptation ---
                String subject = "Bonne nouvelle ! Votre projet est validé : " + demande.getTitreProjet();
                String messageHtml = "<h3 style='color: #2563eb;'>Bonjour " + demande.getNomClient() + ",</h3>"
                    + "<p>Nous avons d'excellentes nouvelles !</p>"
                    + "<p>Suite à l'analyse de votre demande, notre équipe a validé le cahier des charges de votre projet : <strong>" + demande.getTitreProjet() + "</strong>.</p>"
                    + "<p>Votre profil Client a été créé dans nos systèmes et un Chef de Projet a été assigné pour préparer votre infrastructure d'hébergement.</p>"
                    + "<p>Nous reviendrons vers vous très prochainement pour lancer les travaux.</p>"
                    + "<p>Cordialement,<br><strong>L'équipe Technique EnvHub</strong></p>";
                    
                utils.EmailUtil.sendEmail(demande.getEmailClient(), subject, messageHtml);
                // ----------------------------------------------

                response.sendRedirect(request.getContextPath() + "/admin/demandes?success=true");

            } catch (SQLException e) {
                conn.rollback(); 
                throw e;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            forwardWithError(request, response, "Erreur lors de la conversion de la demande en projet actif : " + e.getMessage());
        }
    }

    private void handleCreationManuelle(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String nom = request.getParameter("nomClient");
        String email = request.getParameter("emailClient");
        String entreprise = request.getParameter("entrepriseClient");
        String titre = request.getParameter("titreProjet");
        String description = request.getParameter("descriptionBesoin");
        String budgetStr = request.getParameter("budgetEstime");

        if (nom == null || nom.trim().isEmpty() || email == null || email.trim().isEmpty() || 
            titre == null || titre.trim().isEmpty() || description == null || description.trim().isEmpty()) {
            forwardWithError(request, response, "Tous les champs obligatoires (*) doivent être remplis.");
            return;
        }

        DemandeProjet demande = new DemandeProjet();
        demande.setNomClient(nom.trim());
        demande.setEmailClient(email.trim());
        demande.setEntrepriseClient(entreprise != null ? entreprise.trim() : "");
        demande.setTitreProjet(titre.trim());
        demande.setDescriptionBesoin(description.trim());
        demande.setStatutDemande(StatutDemande.EN_ATTENTE);

        if (budgetStr != null && !budgetStr.trim().isEmpty()) {
            try { demande.setBudgetEstime(Double.parseDouble(budgetStr.trim())); } catch (Exception e) {}
        }

        if (demandeDAO.save(demande)) {
            response.sendRedirect(request.getContextPath() + "/admin/demandes?success=true");
        } else {
            forwardWithError(request, response, "Échec de l'enregistrement de la demande.");
        }
    }

    private boolean isAuthenticated(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        return session != null && session.getAttribute("user") != null;
    }

    private void forwardWithError(HttpServletRequest request, HttpServletResponse response, String errorMsg) throws ServletException, IOException {
        request.setAttribute("erreur", errorMsg);
        request.setAttribute("listeDemandes", demandeDAO.findAll());
        // CORRECTION : Plus besoin de configurer le layout ici, on renvoie vers le wrapper
        request.getRequestDispatcher("/admin/demandes.jsp").forward(request, response);
    }
}