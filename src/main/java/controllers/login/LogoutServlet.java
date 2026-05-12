package controllers.login;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // 1. Récupérer la session actuelle sans en créer une nouvelle (false)
        HttpSession session = request.getSession(false);
        
        // 2. Si une session existe, on la détruit (Invalidation)
        if (session != null) {
            session.invalidate();
        }
        
        // 3. Redirection HTTP 302 vers la page de login
        response.sendRedirect(request.getContextPath() + "/login");
    }
}