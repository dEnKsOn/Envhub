package controllers.admin;

import dao.EnvironnementDAO;
import dao.ProjetDAO;
import dao.ServeurDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.Environnement;
import models.TypeEnvironnement;
import models.Utilisateur;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * Servlet du module transversal « Environnements » : liste, recherche et CRUD sur tous les environnements.
 * Réservé aux utilisateurs ayant le profil système Administrateur.
 */
@WebServlet("/admin/environnements")
public class EnvironnementsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String PROFIL_ADMIN = "Administrateur";

    private EnvironnementDAO environnementDAO;
    private ProjetDAO projetDAO;
    private ServeurDAO serveurDAO;

    @Override
    public void init() throws ServletException {
        this.environnementDAO = new EnvironnementDAO();
        this.projetDAO = new ProjetDAO();
        this.serveurDAO = new ServeurDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!isAuthenticated(request)) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }
        if (!isAdministrateur(getCurrentUser(request))) {
            response.sendRedirect(request.getContextPath() + "/dashboard");
            return;
        }

        String searchQuery = request.getParameter("search");
        if (searchQuery != null) {
            searchQuery = searchQuery.trim();
        }

        if (searchQuery != null && !searchQuery.isEmpty()) {
            request.setAttribute("searchQuery", searchQuery);
            List<Environnement> resultats = environnementDAO.search(searchQuery);
            if (resultats == null) {
                resultats = Collections.emptyList();
            }
            request.setAttribute("listeEnvironnements", resultats);
            if (resultats.isEmpty()) {
                request.setAttribute("searchNotFound", true);
            }
        } else {
            request.setAttribute("listeEnvironnements", environnementDAO.findAllOrdered());
        }

        loadFormData(request);
        request.getRequestDispatcher("/admin/environnements.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!isAuthenticated(request)) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }
        if (!isAdministrateur(getCurrentUser(request))) {
            response.sendRedirect(request.getContextPath() + "/dashboard");
            return;
        }

        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("formAction");
        String envId = request.getParameter("envId");

        if ("delete".equals(action)) {
            handleDelete(request, response, envId);
            return;
        }

        String projetStr = request.getParameter("projet");
        String typeStr = request.getParameter("typeEnv");
        String serveurStr = request.getParameter("serveur");
        String nomBase = request.getParameter("nomBaseDeDonnees");
        String urlFront = request.getParameter("urlFront");
        String urlBack = request.getParameter("urlBack");
        String notes = request.getParameter("notes");

        if (projetStr == null || projetStr.trim().isEmpty()
                || typeStr == null || typeStr.trim().isEmpty()) {
            request.setAttribute("erreur", "Le projet et le type d'environnement sont obligatoires.");
            loadData(request);
            request.getRequestDispatcher("/admin/environnements.jsp").forward(request, response);
            return;
        }

        Environnement env = new Environnement();
        TypeEnvironnement typeEnv;
        try {
            typeEnv = TypeEnvironnement.valueOf(typeStr);
        } catch (IllegalArgumentException e) {
            request.setAttribute("erreur", "Type d'environnement invalide.");
            loadData(request);
            request.getRequestDispatcher("/admin/environnements.jsp").forward(request, response);
            return;
        }
        env.setTypeEnv(typeEnv);

        try {
            env.setIdProjet(UUID.fromString(projetStr));
        } catch (IllegalArgumentException e) {
            request.setAttribute("erreur", "Projet invalide.");
            loadData(request);
            request.getRequestDispatcher("/admin/environnements.jsp").forward(request, response);
            return;
        }

        if (serveurStr != null && !serveurStr.trim().isEmpty()) {
            try {
                env.setIdServ(UUID.fromString(serveurStr));
            } catch (IllegalArgumentException e) {
                request.setAttribute("erreur", "Serveur invalide.");
                loadData(request);
                request.getRequestDispatcher("/admin/environnements.jsp").forward(request, response);
                return;
            }
        }

        env.setNomBaseDeDonnees(emptyToNull(nomBase));
        env.setUrlFront(emptyToNull(urlFront));
        env.setUrlBack(emptyToNull(urlBack));
        env.setNotes(emptyToNull(notes));

        if ("update".equals(action) && envId != null && !envId.trim().isEmpty()) {
            try {
                env.setIdEnv(UUID.fromString(envId));
            } catch (IllegalArgumentException e) {
                request.setAttribute("erreur", "Identifiant d'environnement invalide.");
                loadData(request);
                request.getRequestDispatcher("/admin/environnements.jsp").forward(request, response);
                return;
            }

            if (environnementDAO.update(env)) {
                response.sendRedirect(request.getContextPath() + "/admin/environnements?success=true");
            } else {
                request.setAttribute("erreur", "Impossible de mettre à jour l'environnement.");
                loadData(request);
                request.getRequestDispatcher("/admin/environnements.jsp").forward(request, response);
            }
            return;
        }

        if ("create".equals(action) || action == null) {
            if (environnementDAO.save(env)) {
                response.sendRedirect(request.getContextPath() + "/admin/environnements?success=true");
            } else {
                request.setAttribute("erreur", "Impossible d'enregistrer l'environnement.");
                loadData(request);
                request.getRequestDispatcher("/admin/environnements.jsp").forward(request, response);
            }
            return;
        }

        request.setAttribute("erreur", "Action non reconnue.");
        loadData(request);
        request.getRequestDispatcher("/admin/environnements.jsp").forward(request, response);
    }

    private void handleDelete(HttpServletRequest request, HttpServletResponse response, String envId)
            throws IOException, ServletException {
        if (envId == null || envId.trim().isEmpty()) {
            request.setAttribute("erreur", "Environnement introuvable pour suppression.");
            loadData(request);
            request.getRequestDispatcher("/admin/environnements.jsp").forward(request, response);
            return;
        }

        try {
            UUID uuid = UUID.fromString(envId);
            if (environnementDAO.delete(uuid)) {
                response.sendRedirect(request.getContextPath() + "/admin/environnements?success=true");
            } else {
                request.setAttribute("erreur", "Impossible de supprimer l'environnement.");
                loadData(request);
                request.getRequestDispatcher("/admin/environnements.jsp").forward(request, response);
            }
        } catch (IllegalArgumentException e) {
            request.setAttribute("erreur", "Identifiant d'environnement invalide pour suppression.");
            loadData(request);
            request.getRequestDispatcher("/admin/environnements.jsp").forward(request, response);
        }
    }

    private void loadData(HttpServletRequest request) {
        String searchQuery = request.getParameter("search");
        if (searchQuery != null) {
            searchQuery = searchQuery.trim();
        }

        if (searchQuery != null && !searchQuery.isEmpty()) {
            request.setAttribute("searchQuery", searchQuery);
            request.setAttribute("listeEnvironnements", environnementDAO.search(searchQuery));
        } else {
            request.setAttribute("listeEnvironnements", environnementDAO.findAllOrdered());
        }
        loadFormData(request);
    }

    private void loadFormData(HttpServletRequest request) {
        request.setAttribute("listeProjets", projetDAO.findAll());
        request.setAttribute("listeServeurs", serveurDAO.findAll());
    }

    private String emptyToNull(String value) {
        if (value == null || value.trim().isEmpty()) {
            return null;
        }
        return value.trim();
    }

    private boolean isAdministrateur(Utilisateur user) {
        return user != null && user.getProfil() != null
                && PROFIL_ADMIN.equals(user.getProfil().getLibelle());
    }

    private Utilisateur getCurrentUser(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return null;
        }
        return (Utilisateur) session.getAttribute("user");
    }

    private boolean isAuthenticated(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        return session != null && session.getAttribute("user") != null;
    }
}
