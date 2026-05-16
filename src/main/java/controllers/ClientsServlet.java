package controllers;

import dao.ClientDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.Client;

import java.io.IOException;
import java.util.UUID;

@WebServlet("/clients")
public class ClientsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ClientDAO clientDAO;

    @Override
    public void init() throws ServletException {
        this.clientDAO = new ClientDAO();
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
            java.util.List<Client> resultats = clientDAO.search(searchQuery);
            if (resultats == null) {
                resultats = java.util.Collections.emptyList();
            }
            request.setAttribute("listeClients", resultats);
            if (resultats.isEmpty()) {
                request.setAttribute("searchNotFound", true);
            }
        } else {
            request.setAttribute("listeClients", clientDAO.findAll());
        }

        request.getRequestDispatcher("/clients.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!isAuthenticated(request)) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("formAction");
        String clientId = request.getParameter("clientId");

        if ("delete".equals(action)) {
            handleDelete(request, response, clientId);
            return;
        }

        // Récupération des paramètres du formulaire
        String entreprise = request.getParameter("entreprise");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");

        if (entreprise == null || entreprise.trim().isEmpty() || nom == null || nom.trim().isEmpty()) {
            request.setAttribute("erreur", "Les champs Entreprise et Nom du représentant sont obligatoires.");
            loadData(request);
            request.getRequestDispatcher("/clients.jsp").forward(request, response);
            return;
        }

        Client client = new Client();
        client.setEntrepriseClient(entreprise.trim());
        client.setNomClient(nom.trim());
        client.setPrenomClient(prenom != null && !prenom.trim().isEmpty() ? prenom.trim() : null);

        // MODE UPDATE
        if ("update".equals(action) && clientId != null && !clientId.trim().isEmpty()) {
            try {
                client.setIdClient(UUID.fromString(clientId));
            } catch (IllegalArgumentException e) {
                request.setAttribute("erreur", "Identifiant de client invalide.");
                loadData(request);
                request.getRequestDispatcher("/clients.jsp").forward(request, response);
                return;
            }

            boolean updated = clientDAO.update(client);
            if (updated) {
                response.sendRedirect(request.getContextPath() + "/clients?success=true");
            } else {
                request.setAttribute("erreur", "Impossible de mettre à jour le client.");
                loadData(request);
                request.getRequestDispatcher("/clients.jsp").forward(request, response);
            }
            return;
        }

        // MODE CREATE
        if ("create".equals(action) || action == null) {
            boolean saved = clientDAO.save(client);
            if (saved) {
                response.sendRedirect(request.getContextPath() + "/clients?success=true");
            } else {
                request.setAttribute("erreur", "Impossible d'enregistrer le client.");
                loadData(request);
                request.getRequestDispatcher("/clients.jsp").forward(request, response);
            }
            return;
        }

        request.setAttribute("erreur", "Action non reconnue.");
        loadData(request);
        request.getRequestDispatcher("/clients.jsp").forward(request, response);
    }

    private void handleDelete(HttpServletRequest request, HttpServletResponse response, String clientId) throws IOException, ServletException {
        if (clientId == null || clientId.trim().isEmpty()) {
            request.setAttribute("erreur", "Client introuvable pour suppression.");
            loadData(request);
            request.getRequestDispatcher("/clients.jsp").forward(request, response);
            return;
        }

        try {
            UUID uuid = UUID.fromString(clientId);
            boolean deleted = clientDAO.delete(uuid);
            if (deleted) {
                response.sendRedirect(request.getContextPath() + "/clients?success=true");
            } else {
                request.setAttribute("erreur", "Impossible de supprimer le client. Des projets y sont probablement rattachés (Contrainte de clé étrangère).");
                loadData(request);
                request.getRequestDispatcher("/clients.jsp").forward(request, response);
            }
        } catch (IllegalArgumentException e) {
            request.setAttribute("erreur", "Identifiant de client invalide pour suppression.");
            loadData(request);
            request.getRequestDispatcher("/clients.jsp").forward(request, response);
        }
    }

    private boolean isAuthenticated(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        return session != null && session.getAttribute("user") != null;
    }

    private void loadData(HttpServletRequest request) {
        request.setAttribute("listeClients", clientDAO.findAll());
    }
}