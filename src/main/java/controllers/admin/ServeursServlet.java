package controllers.admin;

import dao.ServeurDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.Serveur;

import java.io.IOException;
import java.util.UUID;

@WebServlet("/admin/serveurs")
public class ServeursServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ServeurDAO serveurDAO;

    @Override
    public void init() throws ServletException {
        this.serveurDAO = new ServeurDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!isAuthenticated(request)) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        String searchQuery = request.getParameter("search");
        if (searchQuery != null && !searchQuery.trim().isEmpty()) {
            request.setAttribute("searchQuery", searchQuery.trim());
            java.util.List<Serveur> resultats = serveurDAO.search(searchQuery.trim());
            request.setAttribute("listeServeurs", resultats != null ? resultats : java.util.Collections.emptyList());
            if (resultats == null || resultats.isEmpty()) request.setAttribute("searchNotFound", true);
        } else {
            request.setAttribute("listeServeurs", serveurDAO.findAll());
        }

        request.getRequestDispatcher("/admin/serveurs.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!isAuthenticated(request)) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("formAction");
        String serveurId = request.getParameter("serveurId");

        if ("delete".equals(action)) {
            handleDelete(request, response, serveurId);
            return;
        }

        String adressIP = request.getParameter("adressIP");
        String os = request.getParameter("os");

        if (adressIP == null || adressIP.trim().isEmpty() || os == null || os.trim().isEmpty()) {
            request.setAttribute("erreur", "Les champs Adresse IP et OS sont obligatoires.");
            loadData(request);
            request.getRequestDispatcher("/admin/serveurs.jsp").forward(request, response);
            return;
        }

        String ip = adressIP.trim();
        UUID uuidToExclude = null;
        if ("update".equals(action) && serveurId != null && !serveurId.trim().isEmpty()) {
            try { uuidToExclude = UUID.fromString(serveurId); } catch (Exception e) {}
        }

        if (serveurDAO.isIpExists(ip, uuidToExclude)) {
            request.setAttribute("erreur", "Cette adresse IP est déjà attribuée à un autre serveur.");
            loadData(request);
            request.getRequestDispatcher("/admin/serveurs.jsp").forward(request, response);
            return;
        }

        Serveur serveur = new Serveur();
        serveur.setAdressIP(ip);
        serveur.setOs(os.trim());

        // Nouvelles données matérielles
        String fournisseur = request.getParameter("fournisseur");
        if (fournisseur != null && !fournisseur.trim().isEmpty()) serveur.setFournisseur(fournisseur.trim());

        String cpuCores = request.getParameter("cpuCores");
        if (cpuCores != null && !cpuCores.trim().isEmpty()) {
            try { serveur.setCpuCores(Integer.parseInt(cpuCores.trim())); } catch (NumberFormatException e) {}
        }

        String ramGb = request.getParameter("ramGb");
        if (ramGb != null && !ramGb.trim().isEmpty()) {
            try { serveur.setRamGb(Integer.parseInt(ramGb.trim())); } catch (NumberFormatException e) {}
        }

        if ("update".equals(action)) {
            try {
                serveur.setIdServ(UUID.fromString(serveurId));
                if (serveurDAO.update(serveur)) {
                    response.sendRedirect(request.getContextPath() + "/admin/serveurs?success=true");
                    return;
                }
            } catch (Exception e) {}
            request.setAttribute("erreur", "Impossible de mettre à jour le serveur.");
        } else {
            if (serveurDAO.save(serveur)) {
                response.sendRedirect(request.getContextPath() + "/admin/serveurs?success=true");
                return;
            }
            request.setAttribute("erreur", "Impossible d'enregistrer le serveur.");
        }

        loadData(request);
        request.getRequestDispatcher("/admin/serveurs.jsp").forward(request, response);
    }

    private void handleDelete(HttpServletRequest request, HttpServletResponse response, String serveurId) throws IOException, ServletException {
        try {
            if (serveurDAO.delete(UUID.fromString(serveurId))) {
                response.sendRedirect(request.getContextPath() + "/admin/serveurs?success=true");
                return;
            }
            request.setAttribute("erreur", "Impossible de supprimer le serveur (Contrainte de clé étrangère).");
        } catch (Exception e) {
            request.setAttribute("erreur", "Serveur introuvable ou identifiant invalide.");
        }
        loadData(request);
        request.getRequestDispatcher("/admin/serveurs.jsp").forward(request, response);
    }

    private boolean isAuthenticated(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        return session != null && session.getAttribute("user") != null;
    }

    private void loadData(HttpServletRequest request) {
        request.setAttribute("listeServeurs", serveurDAO.findAll());
    }
}