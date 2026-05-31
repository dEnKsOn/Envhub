package controllers.publics;

import dao.DemandeProjetDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.DemandeProjet;
import utils.EmailUtil; // N'oublie pas cet import !

import java.io.IOException;

@WebServlet("/soumission")
public class SoumissionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private DemandeProjetDAO demandeDAO;

    @Override
    public void init() throws ServletException {
        // Instanciation du DAO au démarrage de la Servlet
        this.demandeDAO = new DemandeProjetDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // En méthode GET, on se contente d'afficher le formulaire public
        request.getRequestDispatcher("/WEB-INF/views/public/soumission.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Indispensable pour gérer correctement les accents (é, à, ç) saisis par le client
        request.setCharacterEncoding("UTF-8");

        // 1. Récupération des paramètres envoyés par le formulaire
        String nomClient = request.getParameter("nomClient");
        String emailClient = request.getParameter("emailClient");
        String entrepriseClient = request.getParameter("entrepriseClient");
        String titreProjet = request.getParameter("titreProjet");
        String descriptionBesoin = request.getParameter("descriptionBesoin");
        String budgetStr = request.getParameter("budgetEstime");

        // 2. Validation côté serveur (Sécurité)
        if (nomClient == null || nomClient.trim().isEmpty() ||
            emailClient == null || emailClient.trim().isEmpty() ||
            titreProjet == null || titreProjet.trim().isEmpty() ||
            descriptionBesoin == null || descriptionBesoin.trim().isEmpty()) {

            request.setAttribute("erreur", "Veuillez remplir tous les champs obligatoires (*).");
            request.getRequestDispatcher("/WEB-INF/views/public/soumission.jsp").forward(request, response);
            return;
        }

        // 3. Peuplement du Modèle
        DemandeProjet demande = new DemandeProjet();
        demande.setNomClient(nomClient.trim());
        demande.setEmailClient(emailClient.trim());
        demande.setEntrepriseClient(entrepriseClient != null ? entrepriseClient.trim() : "");
        demande.setTitreProjet(titreProjet.trim());
        demande.setDescriptionBesoin(descriptionBesoin.trim());

        // Gestion sécurisée du parsing pour le budget
        if (budgetStr != null && !budgetStr.trim().isEmpty()) {
            try {
                demande.setBudgetEstime(Double.parseDouble(budgetStr.trim()));
            } catch (NumberFormatException e) {
                request.setAttribute("erreur", "Le format du budget estimé est invalide. Veuillez saisir un nombre.");
                request.getRequestDispatcher("/WEB-INF/views/public/soumission.jsp").forward(request, response);
                return;
            }
        }

        // 4. Sauvegarde en Base de Données via le DAO
        boolean isSaved = demandeDAO.save(demande);

        // 5. Redirection et Notification
        if (isSaved) {
            
            // --- AJOUT : Envoi de l'accusé de réception automatique ---
            String subject = "Accusé de réception - Projet : " + demande.getTitreProjet();
            String messageHtml = "<div style=\"font-family: Arial, sans-serif; color: #333;\">"
                + "<h2 style=\"color: #2563eb;\">Bonjour " + demande.getNomClient() + ",</h2>"
                + "<p>Nous vous confirmons la bonne réception de votre demande concernant le projet : <strong>" + demande.getTitreProjet() + "</strong>.</p>"
                + "<p>Notre équipe technique est en train d'analyser votre cahier des charges afin d'évaluer la faisabilité et les ressources nécessaires pour votre infrastructure.</p>"
                + "<p style=\"padding: 10px; background-color: #f0fdf4; border-left: 4px solid #166534; margin: 20px 0;\">"
                + "<strong>Délai de traitement :</strong> Nous reviendrons vers vous avec une réponse détaillée sous <strong>48 heures</strong>."
                + "</p>"
                + "<p>Nous vous remercions de l'intérêt que vous portez à nos services.</p>"
                + "<p>Cordialement,<br><strong>L'équipe EnvHub</strong></p>"
                + "</div>";
                
            // On envoie le mail en arrière-plan
            EmailUtil.sendEmail(demande.getEmailClient(), subject, messageHtml);
            // ----------------------------------------------------------

            // Succès : On redirige vers l'URL en GET avec un paramètre "success"
            response.sendRedirect(request.getContextPath() + "/soumission?success=true");
        } else {
            // Échec
            request.setAttribute("erreur", "Une erreur technique est survenue lors de l'envoi. Veuillez réessayer.");
            request.getRequestDispatcher("/WEB-INF/views/public/soumission.jsp").forward(request, response);
        }
    }
}