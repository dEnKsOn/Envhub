package controllers.admin;

import dao.ClientDAO;
import dao.ProjetDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.Projet;
import models.StatutProjet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.UUID;

@WebServlet("/projets")
public class ProjetsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ProjetDAO projetDAO;
    private ClientDAO clientDAO;

    @Override
    public void init() throws ServletException {
        this.projetDAO = new ProjetDAO();
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
            java.util.List<Projet> resultats = projetDAO.search(searchQuery);
            if (resultats == null) {
                resultats = java.util.Collections.emptyList();
            }
            request.setAttribute("listeProjets", resultats);
            if (resultats.isEmpty()) {
                request.setAttribute("searchNotFound", true);
            }
        } else {
            request.setAttribute("listeProjets", projetDAO.findAll());
        }

        request.setAttribute("listeClients", clientDAO.findAll());
        request.getRequestDispatcher("/projets.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!isAuthenticated(request)) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("formAction");
        String projetId = request.getParameter("projetId");

        if ("delete".equals(action)) {
            handleDelete(request, response, projetId);
            return;
        }

        // Récupération des paramètres
        String nom = request.getParameter("nom");
        String clientStr = request.getParameter("client");
        String statutStr = request.getParameter("statut");
        String avancementStr = request.getParameter("avancement");
        String dateLancementStr = request.getParameter("dateLancement");
        String dateLivraisonStr = request.getParameter("dateLivraison");
        String description = request.getParameter("description");

        if (nom == null || nom.trim().isEmpty() || clientStr == null || clientStr.trim().isEmpty()) {
            request.setAttribute("erreur", "Veuillez remplir les champs obligatoires (Nom, Client).");
            loadData(request);
            request.getRequestDispatcher("/projets.jsp").forward(request, response);
            return;
        }

        Projet projet = new Projet();
        projet.setNomProjet(nom.trim());
        try {
            projet.setIdClient(UUID.fromString(clientStr));
        } catch (IllegalArgumentException e) {
            request.setAttribute("erreur", "Client invalide.");
            loadData(request);
            request.getRequestDispatcher("/projets.jsp").forward(request, response);
            return;
        }
        
        try {
            if (statutStr == null || statutStr.trim().isEmpty()) {
                projet.setStatutProjet(StatutProjet.EN_COURS);
            } else {
                projet.setStatutProjet(StatutProjet.valueOf(statutStr));
            }
        } catch (IllegalArgumentException e) {
            projet.setStatutProjet(StatutProjet.EN_COURS);
        }

        int avancement = 0;
        if (avancementStr != null && !avancementStr.trim().isEmpty()) {
            try {
                avancement = Integer.parseInt(avancementStr);
                if (avancement < 0) avancement = 0;
                if (avancement > 100) avancement = 100;
            } catch (NumberFormatException e) {
                avancement = 0;
            }
        }
        projet.setPourcentageAvancement(avancement);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (dateLancementStr == null || dateLancementStr.trim().isEmpty()) {
            projet.setDateLancement(new java.util.Date());
        } else {
            try {
                projet.setDateLancement(sdf.parse(dateLancementStr));
            } catch (ParseException e) {
                request.setAttribute("erreur", "Format de date de lancement invalide.");
                loadData(request);
                request.getRequestDispatcher("/projets.jsp").forward(request, response);
                return;
            }
        }

        if (dateLivraisonStr != null && !dateLivraisonStr.trim().isEmpty()) {
            try {
                projet.setDateLivraisonEstimee(sdf.parse(dateLivraisonStr));
            } catch (ParseException e) {
                request.setAttribute("erreur", "Format de date de livraison invalide.");
                loadData(request);
                request.getRequestDispatcher("/projets.jsp").forward(request, response);
                return;
            }
        }
        
        projet.setDescriptionTech(description != null ? description.trim() : null);

        // MODE UPDATE
        if ("update".equals(action) && projetId != null && !projetId.trim().isEmpty()) {
            try {
                projet.setIdProjet(UUID.fromString(projetId));
            } catch (IllegalArgumentException e) {
                request.setAttribute("erreur", "Identifiant de projet invalide.");
                loadData(request);
                request.getRequestDispatcher("/projets.jsp").forward(request, response);
                return;
            }

            boolean updated = projetDAO.update(projet);
            if (updated) {
                response.sendRedirect(request.getContextPath() + "/projets?success=true");
            } else {
                request.setAttribute("erreur", "Impossible de mettre à jour le projet.");
                loadData(request);
                request.getRequestDispatcher("/projets.jsp").forward(request, response);
            }
            return;
        }

        // MODE CREATE
        if ("create".equals(action) || action == null) {
            boolean saved = projetDAO.save(projet);
            if (saved) {
                response.sendRedirect(request.getContextPath() + "/projets?success=true");
            } else {
                request.setAttribute("erreur", "Impossible d'enregistrer le projet.");
                loadData(request);
                request.getRequestDispatcher("/projets.jsp").forward(request, response);
            }
            return;
        }

        request.setAttribute("erreur", "Action non reconnue.");
        loadData(request);
        request.getRequestDispatcher("/projets.jsp").forward(request, response);
    }

    private void handleDelete(HttpServletRequest request, HttpServletResponse response, String projetId) throws IOException, ServletException {
        if (projetId == null || projetId.trim().isEmpty()) {
            request.setAttribute("erreur", "Projet introuvable pour suppression.");
            loadData(request);
            request.getRequestDispatcher("/projets.jsp").forward(request, response);
            return;
        }

        try {
            UUID uuid = UUID.fromString(projetId);
            boolean deleted = projetDAO.delete(uuid);
            if (deleted) {
                response.sendRedirect(request.getContextPath() + "/projets?success=true");
            } else {
                request.setAttribute("erreur", "Impossible de supprimer le projet. Des éléments y sont rattachés.");
                loadData(request);
                request.getRequestDispatcher("/projets.jsp").forward(request, response);
            }
        } catch (IllegalArgumentException e) {
            request.setAttribute("erreur", "Identifiant de projet invalide pour suppression.");
            loadData(request);
            request.getRequestDispatcher("/projets.jsp").forward(request, response);
        }
    }

    private boolean isAuthenticated(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        return session != null && session.getAttribute("user") != null;
    }

    private void loadData(HttpServletRequest request) {
        request.setAttribute("listeProjets", projetDAO.findAll());
        request.setAttribute("listeClients", clientDAO.findAll());
    }
}