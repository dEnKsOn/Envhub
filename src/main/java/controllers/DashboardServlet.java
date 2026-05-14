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

        // 2. Redirection vers la page dashboard
        request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
    }
}