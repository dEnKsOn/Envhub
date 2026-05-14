package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/clients")
public class ClientsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Vérification de la session (sécurité)
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            // Pas connecté ? Retour à la page de login
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }
        // Redirection vers la page clients
        request.getRequestDispatcher("/clients.jsp").forward(request, response);
    }
}