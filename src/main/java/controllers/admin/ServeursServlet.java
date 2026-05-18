package controllers.admin;

import dao.ServeurDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.Serveur;

import java.io.IOException;
import java.util.UUID;

@WebServlet("/admin/serveurs")
public class ServeursServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ServeurDAO serveurDAO;

    @Override
    public void init() throws ServletException {
        this.serveurDAO = new ServeurDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!isAuthenticated(request)) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        String searchQuery = request.getParameter("search");
        if (searchQuery != null) {
            searchQuery = searchQuery.trim();
        }

        if (searchQuery != null && !searchQuery.isEmpty()) {
            request.setAttribute("searchQuery", searchQuery);
            java.util.List<Serveur> resultats = serveurDAO.search(searchQuery);
            if (resultats == null) {
                resultats = java.util.Collections.emptyList();
            }
            request.setAttribute("listeServeurs", resultats);
            if (resultats.isEmpty()) {
                request.setAttribute("searchNotFound", true);
            }
        } else {
            request.setAttribute("listeServeurs", serveurDAO.findAll());
        }

        request.getRequestDispatcher("/admin/serveurs.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!isAuthenticated(request)) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("formAction");
        String serveurId = request.getParameter("serveurId");

        if ("delete".equals(action)) {
            handleDelete(request, response, serveurId);
            return;
        }

        // Récupération des paramètres du formulaire
        String adressIP = request.getParameter("adressIP");
        String os = request.getParameter("os");

        if (adressIP == null || adressIP.trim().isEmpty() || os == null || os.trim().isEmpty()) {
            request.setAttribute("erreur", "Les champs Adresse IP et OS sont obligatoires.");
            loadData(request);
            request.getRequestDispatcher("/admin/serveurs.jsp").forward(request, response);
            return;
        }

        String ip = adressIP.trim();
        UUID uuidToExclude = null;
        if ("update".equals(action) && serveurId != null && !serveurId.trim().isEmpty()) {
            try {
                uuidToExclude = UUID.fromString(serveurId);
            } catch (IllegalArgumentException e) {
                // Sera géré dans le bloc d'update
            }
        }

        // Règle métier : Une adresse IP ne peut pas être dupliquée
        if (serveurDAO.isIpExists(ip, uuidToExclude)) {
            request.setAttribute("erreur", "Cette adresse IP est déjà attribuée à un autre serveur.");
            loadData(request);
            request.getRequestDispatcher("/admin/serveurs.jsp").forward(request, response);
            return;
        }

        Serveur serveur = new Serveur();
        serveur.setAdressIP(ip);
        serveur.setOs(os.trim());

        // MODE UPDATE
        if ("update".equals(action) && serveurId != null && !serveurId.trim().isEmpty()) {
            try {
                serveur.setIdServ(UUID.fromString(serveurId));
            } catch (IllegalArgumentException e) {
                request.setAttribute("erreur", "Identifiant de serveur invalide.");
                loadData(request);
                request.getRequestDispatcher("/admin/serveurs.jsp").forward(request, response);
                return;
            }

            boolean updated = serveurDAO.update(serveur);
            if (updated) {
                response.sendRedirect(request.getContextPath() + "/admin/serveurs?success=true");
            } else {
                request.setAttribute("erreur", "Impossible de mettre à jour le serveur.");
                loadData(request);
                request.getRequestDispatcher("/admin/serveurs.jsp").forward(request, response);
            }
            return;
        }

        // MODE CREATE
        if ("create".equals(action) || action == null) {
            boolean saved = serveurDAO.save(serveur);
            if (saved) {
                response.sendRedirect(request.getContextPath() + "/admin/serveurs?success=true");
            } else {
                request.setAttribute("erreur", "Impossible d'enregistrer le serveur.");
                loadData(request);
                request.getRequestDispatcher("/admin/serveurs.jsp").forward(request, response);
            }
            return;
        }

        request.setAttribute("erreur", "Action non reconnue.");
        loadData(request);
        request.getRequestDispatcher("/admin/serveurs.jsp").forward(request, response);
    }

    private void handleDelete(HttpServletRequest request, HttpServletResponse response, String serveurId) throws IOException, ServletException {
        if (serveurId == null || serveurId.trim().isEmpty()) {
            request.setAttribute("erreur", "Serveur introuvable pour suppression.");
            loadData(request);
            request.getRequestDispatcher("/admin/serveurs.jsp").forward(request, response);
            return;
        }

        try {
            UUID uuid = UUID.fromString(serveurId);
            boolean deleted = serveurDAO.delete(uuid);
            if (deleted) {
                response.sendRedirect(request.getContextPath() + "/admin/serveurs?success=true");
            } else {
                request.setAttribute("erreur", "Impossible de supprimer le serveur. Des environnements y sont probablement rattachés (Contrainte de clé étrangère).");
                loadData(request);
                request.getRequestDispatcher("/admin/serveurs.jsp").forward(request, response);
            }
        } catch (IllegalArgumentException e) {
            request.setAttribute("erreur", "Identifiant de serveur invalide pour suppression.");
            loadData(request);
            request.getRequestDispatcher("/admin/serveurs.jsp").forward(request, response);
        }
    }

    private boolean isAuthenticated(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        return session != null && session.getAttribute("user") != null;
    }

    private void loadData(HttpServletRequest request) {
        request.setAttribute("listeServeurs", serveurDAO.findAll());
    }
}