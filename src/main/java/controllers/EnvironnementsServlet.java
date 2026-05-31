package controllers;

import dao.ClientDAO;
import dao.EnvironnementDAO;
import dao.TechnologieDAO;
import models.Environnement;
import models.TypeEnvironnement;
import models.Utilisateur;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.UUID;

@WebServlet("/admin/environnements")
public class EnvironnementsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private EnvironnementDAO environnementDAO;
    private ClientDAO clientDAO;
    private TechnologieDAO technologieDAO;

    @Override
    public void init() throws ServletException {
        this.environnementDAO = new EnvironnementDAO();
        this.clientDAO = new ClientDAO();
        this.technologieDAO = new TechnologieDAO();
    }

    /**
     * Gère l'affichage de la page et la suppression (requêtes GET)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        // 1. Vérification de la session
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        // 2. Interception de l'action de suppression si le paramètre action=delete est présent dans l'URL
        String action = request.getParameter("action");
        if ("delete".equals(action)) {
            traiterSuppression(request, response);
            return; // On arrête l'exécution ici pour ne pas charger la JSP en double
        }

        // 3. Affichage normal de la page : chargement des données
        request.setAttribute("environnements", environnementDAO.findAll());
        request.setAttribute("clients", clientDAO.findAll());
        request.setAttribute("technologies", technologieDAO.findAll());
        
        // TA REDIRECTION EXACTE (qui fonctionne)
        request.getRequestDispatcher("/environnements.jsp").forward(request, response);
    }

    /**
     * Gère les soumissions de formulaire (Ajout ou Modification via requêtes POST)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        // Vérification de la session
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        String action = request.getParameter("action");

        // Traitement du formulaire d'ajout ou de mise à jour
        if ("save".equals(action) || "update".equals(action)) {
            traiterSauvegardeOuMiseAJour(request, response, session, action);
        } else {
            response.sendRedirect(request.getContextPath() + "/admin/environnements");
        }
    }

    /**
     * Logique métier d'insertion (save) et de mise à jour (update)
     */
    private void traiterSauvegardeOuMiseAJour(HttpServletRequest request, HttpServletResponse response, HttpSession session, String action) throws IOException {
        try {
            Environnement env = new Environnement();
            
            // Gestion de l'ID (Nouveau pour save, Existant pour update)
            if ("update".equals(action)) {
                env.setIdEnv(UUID.fromString(request.getParameter("idEnv")));
            } else {
                env.setIdEnv(UUID.randomUUID());
            }

            // Récupération des données du formulaire
            env.setTypeEnv(TypeEnvironnement.valueOf(request.getParameter("typeEnv")));
            env.setUrlFront(request.getParameter("urlFront"));
            env.setUrlBack(request.getParameter("urlBack"));
            env.setNomBaseDeDonnees(request.getParameter("nomBaseDeDonnees"));
            env.setNotes(request.getParameter("notes"));

            // Validation de l'ID du projet
            String idProjetStr = request.getParameter("idProjet");
            if (idProjetStr != null && !idProjetStr.isEmpty()) {
                env.setIdProjet(UUID.fromString(idProjetStr));
            } else {
                throw new IllegalArgumentException("L'ID du projet est obligatoire.");
            }

            // Gestion du serveur (Peut être NULL pour les environnements LOCAUX)
            String idServStr = request.getParameter("idServ");
            if (idServStr != null && !idServStr.isEmpty()) {
                env.setIdServ(UUID.fromString(idServStr));
            } else {
                env.setIdServ(null);
            }

            // Traçabilité : Attribution de l'environnement à l'utilisateur connecté
            Utilisateur currentUser = (Utilisateur) session.getAttribute("user");
            env.setIdCreator(currentUser.getIdUser());

            // Exécution de la requête en BD
            boolean success = false;
            if ("update".equals(action)) {
                success = environnementDAO.update(env);
            } else {
                success = environnementDAO.save(env);
            }

            // Redirection après traitement
            if (success) {
                response.sendRedirect(request.getContextPath() + "/admin/environnements?msg=" + action + "_success");
            } else {
                response.sendRedirect(request.getContextPath() + "/admin/environnements?error=db_error");
            }

        } catch (Exception e) {
            System.err.println("Erreur lors de la sauvegarde/mise à jour : " + e.getMessage());
            response.sendRedirect(request.getContextPath() + "/admin/environnements?error=invalid_data");
        }
    }

    /**
     * Logique métier de suppression d'un environnement
     */
    private void traiterSuppression(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idEnvStr = request.getParameter("id");
        
        try {
            if (idEnvStr != null && !idEnvStr.isEmpty()) {
                boolean success = environnementDAO.delete(UUID.fromString(idEnvStr));
                
                if (success) {
                    response.sendRedirect(request.getContextPath() + "/admin/environnements?msg=delete_success");
                } else {
                    response.sendRedirect(request.getContextPath() + "/admin/environnements?error=delete_failed");
                }
            } else {
                response.sendRedirect(request.getContextPath() + "/admin/environnements?error=missing_id");
            }
        } catch (Exception e) {
            System.err.println("Erreur lors de la suppression de l'environnement : " + e.getMessage());
            response.sendRedirect(request.getContextPath() + "/admin/environnements?error=invalid_id");
        }
    }
}