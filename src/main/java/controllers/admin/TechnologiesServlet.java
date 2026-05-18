package controllers.admin;

import dao.TechnologieDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.Technologie;
import models.TypeTechno;

import java.io.IOException;
import java.util.UUID;

@WebServlet("/admin/technologies")
public class TechnologiesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private TechnologieDAO technologieDAO;

    @Override
    public void init() throws ServletException {
        this.technologieDAO = new TechnologieDAO();
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
            java.util.List<Technologie> resultats = technologieDAO.search(searchQuery);
            if (resultats == null) {
                resultats = java.util.Collections.emptyList();
            }
            request.setAttribute("listeTechnologies", resultats);
            if (resultats.isEmpty()) {
                request.setAttribute("searchNotFound", true);
            }
        } else {
            request.setAttribute("listeTechnologies", technologieDAO.findAll());
        }

        request.setAttribute("typesTechno", TypeTechno.values());
        request.getRequestDispatcher("/admin/technologies.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!isAuthenticated(request)) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("formAction");
        String technoId = request.getParameter("technoId");

        if ("delete".equals(action)) {
            handleDelete(request, response, technoId);
            return;
        }

        // Récupération des paramètres du formulaire
        String nomTechno = request.getParameter("nomTechno");
        String typeTechnoStr = request.getParameter("typeTechno");

        if (nomTechno == null || nomTechno.trim().isEmpty() || typeTechnoStr == null || typeTechnoStr.trim().isEmpty()) {
            request.setAttribute("erreur", "Les champs Nom de la Technologie et Catégorie sont obligatoires.");
            loadData(request);
            request.getRequestDispatcher("/admin/technologies.jsp").forward(request, response);
            return;
        }

        String nom = nomTechno.trim();
        UUID uuidToExclude = null;
        if ("update".equals(action) && technoId != null && !technoId.trim().isEmpty()) {
            try {
                uuidToExclude = UUID.fromString(technoId);
            } catch (IllegalArgumentException e) {
                // Sera géré dans le bloc d'update
            }
        }

        // Règle métier : Un nom de technologie ne peut pas être dupliqué
        if (technologieDAO.isNomTechnoExists(nom, uuidToExclude)) {
            request.setAttribute("erreur", "Ce nom de technologie existe déjà.");
            loadData(request);
            request.getRequestDispatcher("/admin/technologies.jsp").forward(request, response);
            return;
        }

        TypeTechno typeTechno;
        try {
            typeTechno = TypeTechno.valueOf(typeTechnoStr);
        } catch (IllegalArgumentException e) {
            request.setAttribute("erreur", "Type de technologie invalide.");
            loadData(request);
            request.getRequestDispatcher("/admin/technologies.jsp").forward(request, response);
            return;
        }

        Technologie technologie = new Technologie();
        technologie.setNomTechno(nom);
        technologie.setTypeTechno(typeTechno);

        // MODE UPDATE
        if ("update".equals(action) && technoId != null && !technoId.trim().isEmpty()) {
            try {
                technologie.setIdTechno(UUID.fromString(technoId));
            } catch (IllegalArgumentException e) {
                request.setAttribute("erreur", "Identifiant de technologie invalide.");
                loadData(request);
                request.getRequestDispatcher("/admin/technologies.jsp").forward(request, response);
                return;
            }

            boolean updated = technologieDAO.update(technologie);
            if (updated) {
                response.sendRedirect(request.getContextPath() + "/admin/technologies?success=true");
            } else {
                request.setAttribute("erreur", "Impossible de mettre à jour la technologie.");
                loadData(request);
                request.getRequestDispatcher("/admin/technologies.jsp").forward(request, response);
            }
            return;
        }

        // MODE CREATE
        if ("create".equals(action) || action == null) {
            boolean saved = technologieDAO.save(technologie);
            if (saved) {
                response.sendRedirect(request.getContextPath() + "/admin/technologies?success=true");
            } else {
                request.setAttribute("erreur", "Impossible d'enregistrer la technologie.");
                loadData(request);
                request.getRequestDispatcher("/admin/technologies.jsp").forward(request, response);
            }
            return;
        }

        request.setAttribute("erreur", "Action non reconnue.");
        loadData(request);
        request.getRequestDispatcher("/admin/technologies.jsp").forward(request, response);
    }

    private void handleDelete(HttpServletRequest request, HttpServletResponse response, String technoId) throws IOException, ServletException {
        if (technoId == null || technoId.trim().isEmpty()) {
            request.setAttribute("erreur", "Technologie introuvable pour suppression.");
            loadData(request);
            request.getRequestDispatcher("/admin/technologies.jsp").forward(request, response);
            return;
        }

        try {
            UUID uuid = UUID.fromString(technoId);
            boolean deleted = technologieDAO.delete(uuid);
            if (deleted) {
                response.sendRedirect(request.getContextPath() + "/admin/technologies?success=true");
            } else {
                request.setAttribute("erreur", "Impossible de supprimer la technologie. Des environnements l'utilisent probablement (Contrainte de clé étrangère).");
                loadData(request);
                request.getRequestDispatcher("/admin/technologies.jsp").forward(request, response);
            }
        } catch (IllegalArgumentException e) {
            request.setAttribute("erreur", "Identifiant de technologie invalide pour suppression.");
            loadData(request);
            request.getRequestDispatcher("/admin/technologies.jsp").forward(request, response);
        }
    }

    private boolean isAuthenticated(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        return session != null && session.getAttribute("user") != null;
    }

    private void loadData(HttpServletRequest request) {
        request.setAttribute("listeTechnologies", technologieDAO.findAll());
        request.setAttribute("typesTechno", TypeTechno.values());
    }
}