package controllers.login;

import java.io.IOException;

import dao.UtilisateurDAO;
import models.Utilisateur;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String VUE_LOGIN = "/WEB-INF/views/login.jsp";

    private UtilisateurDAO utilisateurDAO;

    @Override
    public void init() throws ServletException {
        // Bonne pratique : initialiser les dépendances au démarrage de la Servlet
        this.utilisateurDAO = new UtilisateurDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Si l'utilisateur est déjà connecté, on l'empêche de revoir la page de login
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            response.sendRedirect(request.getContextPath() + "/dashboard");
            return;
        }
        
        // Sinon, on affiche la page
        request.getRequestDispatcher(VUE_LOGIN).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // 1. Validation basique des champs
        if (email == null || email.trim().isEmpty() || password == null || password.trim().isEmpty()) {
            request.setAttribute("error", "Veuillez remplir tous les champs.");
            request.getRequestDispatcher(VUE_LOGIN).forward(request, response);
            return;
        }

        // 2. Authentification en base de données
        Utilisateur user = utilisateurDAO.authenticate(email, password);
        
        if (user != null) {
            // 3. Prévention contre la fixation ide session
            HttpSession oldSession = request.getSession(false);
            if (oldSession != null) {
                oldSession.invalidate();
            }

            // 4. Création de la nouvelle session sécurisée
            HttpSession newSession = request.getSession(true);
            newSession.setAttribute("user", user);
            
            // 5. Redirection post-connexion
            response.sendRedirect(request.getContextPath() + "/dashboard");
        } else {
            // Échec (Identifiants faux)
            request.setAttribute("error", "Email/Mot de passe incorrect.");
            request.getRequestDispatcher(VUE_LOGIN).forward(request, response);
        }
    }
}