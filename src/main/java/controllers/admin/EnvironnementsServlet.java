package controllers.admin;

import dao.ClientDAO;
import dao.EnvironnementDAO;
import dao.TechnologieDAO;
import models.Environnement;
import models.TypeEnvironnement;
import models.Utilisateur;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.UUID;

@WebServlet("/admin/environnements")
public class EnvironnementsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private EnvironnementDAO environnementDAO;
    private ClientDAO clientDAO;
    private TechnologieDAO technologieDAO;

    @Override
    public void init() throws ServletException {
        this.environnementDAO = new EnvironnementDAO();
        this.clientDAO = new ClientDAO();
        this.technologieDAO = new TechnologieDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        String action = request.getParameter("action");
        if ("delete".equals(action)) {
            traiterSuppression(request, response);
            return; 
        }

        request.setAttribute("environnements", environnementDAO.findAll());
        request.setAttribute("clients", clientDAO.findAll());
        request.setAttribute("technologies", technologieDAO.findAll());
        
        request.getRequestDispatcher("/admin/environnements.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        String action = request.getParameter("action");

        if ("save".equals(action) || "update".equals(action)) {
            traiterSauvegardeOuMiseAJour(request, response, session, action);
        } else {
            response.sendRedirect(request.getContextPath() + "/admin/environnements");
        }
    }

    private void traiterSauvegardeOuMiseAJour(HttpServletRequest request, HttpServletResponse response, HttpSession session, String action) throws IOException {
        try {
            Environnement env = new Environnement();
            
            if ("update".equals(action)) {
                env.setIdEnv(UUID.fromString(request.getParameter("idEnv")));
            } else {
                env.setIdEnv(UUID.randomUUID());
            }

            env.setTypeEnv(TypeEnvironnement.valueOf(request.getParameter("typeEnv")));
            env.setUrlFront(request.getParameter("urlFront"));
            env.setUrlBack(request.getParameter("urlBack"));
            env.setNomBaseDeDonnees(request.getParameter("nomBaseDeDonnees"));
            env.setNotes(request.getParameter("notes"));

            String idProjetStr = request.getParameter("idProjet");
            if (idProjetStr != null && !idProjetStr.isEmpty()) {
                env.setIdProjet(UUID.fromString(idProjetStr));
            } else {
                throw new IllegalArgumentException("L'ID du projet est obligatoire.");
            }

            String idServStr = request.getParameter("idServ");
            if (idServStr != null && !idServStr.isEmpty()) {
                env.setIdServ(UUID.fromString(idServStr));
            } else {
                env.setIdServ(null);
            }

            Utilisateur currentUser = (Utilisateur) session.getAttribute("user");
            env.setIdCreator(currentUser.getIdUser());

            boolean success = false;
            if ("update".equals(action)) {
                success = environnementDAO.update(env);
            } else {
                success = environnementDAO.save(env);
            }

            if (success) {
                // 🚀 DÉCLENCHEMENT DE L'AUTOMATISATION
                new dao.ProjetDAO().evaluerProgression(env.getIdProjet());
                
                response.sendRedirect(request.getContextPath() + "/admin/environnements?msg=" + action + "_success");
            } else {
                response.sendRedirect(request.getContextPath() + "/admin/environnements?error=db_error");
            }

        } catch (Exception e) {
            System.err.println("Erreur lors de la sauvegarde/mise à jour : " + e.getMessage());
            response.sendRedirect(request.getContextPath() + "/admin/environnements?error=invalid_data");
        }
    }

    private void traiterSuppression(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idEnvStr = request.getParameter("id");
        
        try {
            if (idEnvStr != null && !idEnvStr.isEmpty()) {
                boolean success = environnementDAO.delete(UUID.fromString(idEnvStr));
                
                if (success) {
                    response.sendRedirect(request.getContextPath() + "/admin/environnements?msg=delete_success");
                } else {
                    response.sendRedirect(request.getContextPath() + "/admin/environnements?error=delete_failed");
                }
            } else {
                response.sendRedirect(request.getContextPath() + "/admin/environnements?error=missing_id");
            }
        } catch (Exception e) {
            System.err.println("Erreur lors de la suppression de l'environnement : " + e.getMessage());
            response.sendRedirect(request.getContextPath() + "/admin/environnements?error=invalid_id");
        }
    }
}