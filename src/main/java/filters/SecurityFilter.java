package filters;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.Utilisateur;

import java.io.IOException;

@WebFilter("/*")
public class SecurityFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
            
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        
        // Récupération de l'URL demandée (sans le nom du projet/contexte)
        String path = req.getRequestURI().substring(req.getContextPath().length());

        // 1. Laisser passer les ressources publiques (CSS, JS, Images, page de Login, etc.)
        if (path.startsWith("/assets/") || path.equals("/login") || path.equals("/")) {
            chain.doFilter(request, response);
            return;
        }

        // 2. Vérifier si l'utilisateur est connecté
        HttpSession session = req.getSession(false);
        Utilisateur user = (session != null) ? (Utilisateur) session.getAttribute("user") : null;

        if (user == null) {
            // Non connecté -> Redirection vers la page de connexion
            res.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        // 3. Routage et contrôle des accès selon le profil
        String role = user.getProfil().getLibelle();

        // RÈGLE A : Espace Administrateur
        if (path.startsWith("/admin") || path.equals("/dashboard") || path.equals("/projets")) {
            if (!"Administrateur".equals(role)) {
                // Tentative d'accès illégal par un développeur
                res.sendError(HttpServletResponse.SC_FORBIDDEN, "Accès refusé : Espace réservé aux administrateurs.");
                return;
            }
        }
        
        // RÈGLE B : Espace Développeur
        if (path.startsWith("/dev")) {
            // On peut décider de laisser l'Admin voir l'espace Dev si besoin, 
            // sinon on restreint strictement au Développeur.
            if (!"Développeur".equals(role) && !"Administrateur".equals(role)) {
                res.sendError(HttpServletResponse.SC_FORBIDDEN, "Accès refusé : Espace réservé aux développeurs.");
                return;
            }
        }

        // 4. Si toutes les vérifications sont OK, on laisse passer la requête
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {}
}