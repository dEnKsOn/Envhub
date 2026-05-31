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

        // --- DÉTECTION DE L'ADMINISTRATEUR ACTUEL ---
        int adminProfilId = getAdminProfilId();
        Utilisateur currentAdmin = getCurrentAdmin(adminProfilId);

        // --- GESTION DE LA SUPPRESSION ---
        if ("delete".equals(action)) {
            // Règle 1 : Interdiction formelle de supprimer l'Admin
            if (currentAdmin != null && currentAdmin.getIdUser().toString().equals(userId)) {
                request.setAttribute("erreur", "Opération interdite : Vous ne pouvez pas supprimer l'Administrateur unique du système.");
                loadData(request);
                request.getRequestDispatcher("/admin/utilisateurs.jsp").forward(request, response);
                return;
            }
            handleDelete(request, response, userId);
            return;
        }

        // Récupération des paramètres du formulaire
        String prenom = request.getParameter("prenom");
        String nom = request.getParameter("nom");
        String email = request.getParameter("email");
        String genre = request.getParameter("genre"); 
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
        
        if (genre != null && !genre.trim().isEmpty()) {
            utilisateur.setGenre(genre.trim());
        } else {
            utilisateur.setGenre(null);
        }

        if (password != null && !password.trim().isEmpty()) {
            utilisateur.setPassword(BCrypt.hashpw(password.trim(), BCrypt.gensalt()));
        }

        Profil profil = new Profil();
        profil.setIdProfil(idProfil);
        utilisateur.setProfil(profil);

        // --- MODE UPDATE ---
        if ("update".equals(action) && userId != null && !userId.trim().isEmpty()) {
            
            // Règles strictes pour l'unicité de l'Administrateur
            if (currentAdmin != null) {
                if (currentAdmin.getIdUser().toString().equals(userId)) {
                    // Si on modifie l'Admin actuel, on vérifie qu'il garde son rôle
                    if (idProfil != adminProfilId) {
                        request.setAttribute("erreur", "Opération interdite : L'Administrateur ne peut pas perdre ses droits. Il doit y avoir un Admin.");
                        loadData(request);
                        request.getRequestDispatcher("/admin/utilisateurs.jsp").forward(request, response);
                        return;
                    }
                } else {
                    // Si on modifie un autre utilisateur, on vérifie qu'on ne le transforme pas en Admin
                    if (idProfil == adminProfilId) {
                        request.setAttribute("erreur", "Opération interdite : Un Administrateur existe déjà. Impossible d'en nommer un deuxième.");
                        loadData(request);
                        request.getRequestDispatcher("/admin/utilisateurs.jsp").forward(request, response);
                        return;
                    }
                }
            }

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

        // --- MODE CREATE ---
        if ("create".equals(action) || action == null) {
            
            // Règle 3 : Interdiction de créer un deuxième Admin
            if (idProfil == adminProfilId && currentAdmin != null) {
                request.setAttribute("erreur", "Opération interdite : Un Administrateur existe déjà. Impossible d'en créer un deuxième.");
                loadData(request);
                request.getRequestDispatcher("/admin/utilisateurs.jsp").forward(request, response);
                return;
            }

            if (password == null || password.trim().isEmpty()) {
                request.setAttribute("erreur", "Le mot de passe est obligatoire pour un nouvel utilisateur.");
                loadData(request);
                request.getRequestDispatcher("/admin/utilisateurs.jsp").forward(request, response);
                return;
            }

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
        // Le code de handleDelete reste identique
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

    // ==============================================================
    // MÉTHODES UTILITAIRES POUR GÉRER L'UNICITÉ DE L'ADMINISTRATEUR
    // ==============================================================
    
    /**
     * Recherche dynamiquement l'ID du profil "Administrateur" dans la BD
     */
    private int getAdminProfilId() {
        for (Profil p : profilDAO.findAll()) {
            if ("Administrateur".equalsIgnoreCase(p.getLibelle())) {
                return p.getIdProfil();
            }
        }
        return -1; // En cas d'erreur de base de données
    }

    /**
     * Retourne l'utilisateur actuel qui possède le profil "Administrateur" (s'il y en a un)
     */
    private Utilisateur getCurrentAdmin(int adminProfilId) {
        if (adminProfilId == -1) return null;
        
        for (Utilisateur u : utilisateurDAO.findAll()) {
            if (u.getProfil() != null && u.getProfil().getIdProfil() == adminProfilId) {
                return u; // L'Admin a été trouvé !
            }
        }
        return null;
    }
}