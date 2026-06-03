package controllers.dev;

import dao.EnvironnementDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.Environnement;
import models.Utilisateur;

import java.io.IOException;
import java.util.List;

@WebServlet("/dev/mes-environnements")
public class DevEnvironnementsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private EnvironnementDAO environnementDAO;

    @Override
    public void init() throws ServletException {
        this.environnementDAO = new EnvironnementDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        Utilisateur currentUser = (Utilisateur) session.getAttribute("user");

        // On récupère uniquement les environnements auxquels ce dev a accès
        List<Environnement> mesEnvs = environnementDAO.findByUtilisateur(currentUser.getIdUser());
        
        request.setAttribute("mesEnvironnements", mesEnvs);

        // Transfert au wrapper
        request.getRequestDispatcher("/dev/mes-environnements.jsp").forward(request, response);
    }
}