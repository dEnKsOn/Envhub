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
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@WebServlet("/admin/projets")
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
        if (searchQuery != null && !searchQuery.trim().isEmpty()) {
            searchQuery = searchQuery.trim();
            request.setAttribute("searchQuery", searchQuery);
            List<Projet> resultats = projetDAO.search(searchQuery);
            
            if (resultats == null) resultats = Collections.emptyList();
            
            request.setAttribute("listeProjets", resultats);
            if (resultats.isEmpty()) {
                request.setAttribute("searchNotFound", true);
            }
        } else {
            request.setAttribute("listeProjets", projetDAO.findAll());
        }

        request.setAttribute("listeClients", clientDAO.findAll());
        // Ici, on forward bien vers le WRAPPER !
        request.getRequestDispatcher("/admin/projets.jsp").forward(request, response);
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

        Projet projet = new Projet();
        String nom = request.getParameter("nom");
        String clientStr = request.getParameter("client");
        String statutStr = request.getParameter("statut");
        String avancementStr = request.getParameter("avancement");
        String dateLancementStr = request.getParameter("dateLancement");
        String dateLivraisonStr = request.getParameter("dateLivraison");
        String description = request.getParameter("description");

        if (nom == null || nom.trim().isEmpty() || clientStr == null || clientStr.trim().isEmpty()) {
            forwardWithError(request, response, "Veuillez remplir les champs obligatoires (Nom, Client).", projet);
            return;
        }

        projet.setNomProjet(nom.trim());
        projet.setDescriptionTech(description != null ? description.trim() : null);

        try {
            projet.setIdClient(UUID.fromString(clientStr));
        } catch (IllegalArgumentException e) {
            forwardWithError(request, response, "Client invalide.", projet);
            return;
        }
        
        try {
            projet.setStatutProjet(statutStr != null && !statutStr.trim().isEmpty() ? StatutProjet.valueOf(statutStr) : StatutProjet.EN_COURS);
        } catch (IllegalArgumentException e) {
            projet.setStatutProjet(StatutProjet.EN_COURS);
        }

        int avancement = 0;
        if (avancementStr != null && !avancementStr.trim().isEmpty()) {
            try {
                avancement = Math.max(0, Math.min(100, Integer.parseInt(avancementStr))); 
            } catch (NumberFormatException e) {
                avancement = 0;
            }
        }
        projet.setPourcentageAvancement(avancement);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            if (dateLancementStr == null || dateLancementStr.trim().isEmpty()) {
                projet.setDateLancement(new Date());
            } else {
                projet.setDateLancement(sdf.parse(dateLancementStr));
            }

            if (dateLivraisonStr != null && !dateLivraisonStr.trim().isEmpty()) {
                projet.setDateLivraisonEstimee(sdf.parse(dateLivraisonStr));
            }
        } catch (ParseException e) {
            forwardWithError(request, response, "Format de date invalide.", projet);
            return;
        }

        if ("update".equals(action)) {
            if (projetId == null || projetId.trim().isEmpty()) {
                forwardWithError(request, response, "Identifiant de projet manquant pour la mise à jour.", projet);
                return;
            }
            try {
                projet.setIdProjet(UUID.fromString(projetId));
            } catch (IllegalArgumentException e) {
                forwardWithError(request, response, "Identifiant de projet invalide.", projet);
                return;
            }

            if (projetDAO.update(projet)) {
                response.sendRedirect(request.getContextPath() + "/admin/projets?success=true");
            } else {
                forwardWithError(request, response, "Impossible de mettre à jour le projet.", projet);
            }
            
        } else if ("create".equals(action) || action == null) {
            if (projetDAO.save(projet)) {
                response.sendRedirect(request.getContextPath() + "/admin/projets?success=true");
            } else {
                forwardWithError(request, response, "Impossible d'enregistrer le projet.", projet);
            }
            
        } else {
            forwardWithError(request, response, "Action non reconnue.", projet);
        }
    }

    private void handleDelete(HttpServletRequest request, HttpServletResponse response, String projetId) throws IOException, ServletException {
        if (projetId == null || projetId.trim().isEmpty()) {
            forwardWithError(request, response, "Projet introuvable pour suppression.", null);
            return;
        }

        try {
            if (projetDAO.delete(UUID.fromString(projetId))) {
                response.sendRedirect(request.getContextPath() + "/admin/projets?success=true");
            } else {
                forwardWithError(request, response, "Impossible de supprimer le projet. Des éléments y sont rattachés.", null);
            }
        } catch (IllegalArgumentException e) {
            forwardWithError(request, response, "Identifiant de projet invalide pour suppression.", null);
        }
    }

    private void forwardWithError(HttpServletRequest request, HttpServletResponse response, String message, Projet projetEnCours) throws ServletException, IOException {
        request.setAttribute("erreur", message);
        if (projetEnCours != null) {
            request.setAttribute("projetSaisi", projetEnCours); 
        }
        loadData(request);
        // Ici aussi, on forward bien vers le WRAPPER !
        request.getRequestDispatcher("/admin/projets.jsp").forward(request, response);
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