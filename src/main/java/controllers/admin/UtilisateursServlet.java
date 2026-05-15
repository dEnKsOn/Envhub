package controllers.admin;

import dao.ProfilDAO;
import dao.UtilisateurDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.Profil;
import models.Utilisateur;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;
import java.util.UUID;

@WebServlet("/admin/utilisateurs")
public class UtilisateursServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UtilisateurDAO utilisateurDAO;
    private ProfilDAO profilDAO;

    @Override
    public void init() throws ServletException {
        this.utilisateurDAO = new UtilisateurDAO();
        this.profilDAO = new ProfilDAO();
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
            java.util.List<Utilisateur> resultats = utilisateurDAO.search(searchQuery);
            if (resultats == null) {
                resultats = java.util.Collections.emptyList();
            }
            request.setAttribute("listeUtilisateurs", resultats);
            if (resultats.isEmpty()) {
                request.setAttribute("searchNotFound", true);
            }
        } else {
            request.setAttribute("listeUtilisateurs", utilisateurDAO.findAll());
        }

        request.setAttribute("listeProfils", profilDAO.findAll());
        
        // Si tu utilises le base_layout.jsp, n'oublie pas d'utiliser les attributs pageContent et de forward vers le layout
        // request.setAttribute("pageContent", "/WEB-INF/views/admin/utilisateurs.jsp");
        // request.getRequestDispatcher("/WEB-INF/views/base_layout.jsp").forward(request, response);
        
        request.getRequestDispatcher("/admin/utilisateurs.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!isAuthenticated(request)) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("formAction");
        String userId = request.getParameter("userId");

        if ("delete".equals(action)) {
            handleDelete(request, response, userId);
            return;
        }

        // Récupération des paramètres du formulaire
        String prenom = request.getParameter("prenom");
        String nom = request.getParameter("nom");
        String email = request.getParameter("email");
        String genre = request.getParameter("genre"); // CORRECTION : Récupération du genre
        String password = request.getParameter("password");
        String idProfilStr = request.getParameter("idProfil");

        if (prenom == null || prenom.trim().isEmpty()
                || nom == null || nom.trim().isEmpty()
                || email == null || email.trim().isEmpty()
                || idProfilStr == null || idProfilStr.trim().isEmpty()) {
            request.setAttribute("erreur", "Tous les champs obligatoires doivent être remplis.");
            loadData(request);
            request.getRequestDispatcher("/admin/utilisateurs.jsp").forward(request, response);
            return;
        }

        int idProfil;
        try {
            idProfil = Integer.parseInt(idProfilStr);
        } catch (NumberFormatException e) {
            request.setAttribute("erreur", "Profil invalide.");
            loadData(request);
            request.getRequestDispatcher("/admin/utilisateurs.jsp").forward(request, response);
            return;
        }

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setPrenomUser(prenom.trim());
        utilisateur.setNomUser(nom.trim());
        utilisateur.setEmail(email.trim());
        
        // CORRECTION : Affectation du genre (peut être null en base)
        if (genre != null && !genre.trim().isEmpty()) {
            utilisateur.setGenre(genre.trim());
        } else {
            utilisateur.setGenre(null);
        }

        // Hashage du mot de passe uniquement s'il est fourni
        if (password != null && !password.trim().isEmpty()) {
            utilisateur.setPassword(BCrypt.hashpw(password.trim(), BCrypt.gensalt()));
        }

        Profil profil = new Profil();
        profil.setIdProfil(idProfil);
        utilisateur.setProfil(profil);

        // MODE UPDATE
        if ("update".equals(action) && userId != null && !userId.trim().isEmpty()) {
            try {
                utilisateur.setIdUser(UUID.fromString(userId));
            } catch (IllegalArgumentException e) {
                request.setAttribute("erreur", "Identifiant d'utilisateur invalide.");
                loadData(request);
                request.getRequestDispatcher("/admin/utilisateurs.jsp").forward(request, response);
                return;
            }

            boolean updated = utilisateurDAO.update(utilisateur);
            if (updated) {
                response.sendRedirect(request.getContextPath() + "/admin/utilisateurs?success=true");
            } else {
                request.setAttribute("erreur", "Impossible de mettre à jour l'utilisateur.");
                loadData(request);
                request.getRequestDispatcher("/admin/utilisateurs.jsp").forward(request, response);
            }
            return;
        }

        // MODE CREATE
        if ("create".equals(action) || action == null) {
            if (password == null || password.trim().isEmpty()) {
                request.setAttribute("erreur", "Le mot de passe est obligatoire pour un nouvel utilisateur.");
                loadData(request);
                request.getRequestDispatcher("/admin/utilisateurs.jsp").forward(request, response);
                return;
            }

            // Pour la création, on s'assure que le mot de passe est bien hashé s'il n'a pas été capturé plus haut
            if (utilisateur.getPassword() == null) {
                utilisateur.setPassword(BCrypt.hashpw(password.trim(), BCrypt.gensalt()));
            }
            
            boolean saved = utilisateurDAO.save(utilisateur);
            if (saved) {
                response.sendRedirect(request.getContextPath() + "/admin/utilisateurs?success=true");
            } else {
                request.setAttribute("erreur", "Impossible d'enregistrer l'utilisateur. Vérifiez la saisie (l'email existe peut-être déjà).");
                loadData(request);
                request.getRequestDispatcher("/admin/utilisateurs.jsp").forward(request, response);
            }
            return;
        }

        request.setAttribute("erreur", "Action non reconnue.");
        loadData(request);
        request.getRequestDispatcher("/admin/utilisateurs.jsp").forward(request, response);
    }

    private void handleDelete(HttpServletRequest request, HttpServletResponse response, String userId) throws IOException, ServletException {
        if (userId == null || userId.trim().isEmpty()) {
            request.setAttribute("erreur", "Utilisateur introuvable pour suppression.");
            loadData(request);
            request.getRequestDispatcher("/admin/utilisateurs.jsp").forward(request, response);
            return;
        }

        try {
            UUID uuid = UUID.fromString(userId);
            boolean deleted = utilisateurDAO.delete(uuid);
            if (deleted) {
                response.sendRedirect(request.getContextPath() + "/admin/utilisateurs?success=true");
            } else {
                request.setAttribute("erreur", "Impossible de supprimer l'utilisateur.");
                loadData(request);
                request.getRequestDispatcher("/admin/utilisateurs.jsp").forward(request, response);
            }
        } catch (IllegalArgumentException e) {
            request.setAttribute("erreur", "Identifiant d'utilisateur invalide pour suppression.");
            loadData(request);
            request.getRequestDispatcher("/admin/utilisateurs.jsp").forward(request, response);
        }
    }

    private boolean isAuthenticated(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        return session != null && session.getAttribute("user") != null;
    }

    private void loadData(HttpServletRequest request) {
        request.setAttribute("listeUtilisateurs", utilisateurDAO.findAll());
        request.setAttribute("listeProfils", profilDAO.findAll());
    }
}