package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        // 1. Vérification de la session (Sécurité)
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            // Pas connecté ? Retour à la page de login
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        // 2. Préparation des variables pour le Layout (base_layout.jsp)
        // Le titre qui s'affichera dans le Header et l'onglet du navigateur
        request.setAttribute("pageTitle", "Tableau de bord - EnvHub");
        
        // Le chemin vers le contenu spécifique à inclure
        request.setAttribute("pageContent", "/WEB-INF/views/admin/dashboard-stats.jsp");

        // 3. Redirection vers le squelette principal (Layout)
        request.getRequestDispatcher("/WEB-INF/views/base_layout.jsp").forward(request, response);
    }
}