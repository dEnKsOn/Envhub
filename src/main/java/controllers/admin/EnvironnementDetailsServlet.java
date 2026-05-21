package controllers.admin;

import dao.EnvironnementDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.Environnement;
import models.Utilisateur;

import java.io.IOException;
import java.util.UUID;

/**
 * Page de détails d'un environnement (gestion de la stack technologique).
 * Point d'entrée depuis le bouton « Gérer la stack » de la liste globale.
 */
@WebServlet("/admin/environnements/details")
public class EnvironnementDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String PROFIL_ADMIN = "Administrateur";

    private EnvironnementDAO environnementDAO;

    @Override
    public void init() throws ServletException {
        this.environnementDAO = new EnvironnementDAO();
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

        String idParam = request.getParameter("id");
        if (idParam == null || idParam.trim().isEmpty()) {
            response.sendRedirect(request.getContextPath() + "/admin/environnements");
            return;
        }

        UUID idEnv;
        try {
            idEnv = UUID.fromString(idParam.trim());
        } catch (IllegalArgumentException e) {
            response.sendRedirect(request.getContextPath() + "/admin/environnements");
            return;
        }

        Environnement environnement = environnementDAO.findById(idEnv);
        if (environnement == null) {
            response.sendRedirect(request.getContextPath() + "/admin/environnements");
            return;
        }

        request.setAttribute("environnement", environnement);
        request.getRequestDispatcher("/admin/environnements/details.jsp").forward(request, response);
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
