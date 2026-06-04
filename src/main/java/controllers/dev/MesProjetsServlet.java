package controllers.dev;

import dao.AffectationDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.Affectation;
import models.Utilisateur;

import java.io.IOException;
import java.util.List;

@WebServlet("/dev/mes-projets")
public class MesProjetsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private AffectationDAO affectationDAO;

    @Override
    public void init() throws ServletException {
        this.affectationDAO = new AffectationDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        // 1. Récupération de l'utilisateur connecté
        HttpSession session = request.getSession(false);
        Utilisateur currentUser = (Utilisateur) session.getAttribute("user");

        // 2. On cherche UNIQUEMENT les projets de CE développeur
        List<Affectation> mesAffectations = affectationDAO.findByUtilisateur(currentUser.getIdUser());
        
        request.setAttribute("mesAffectations", mesAffectations);

        // 3. Transfert vers le wrapper JSP
        request.getRequestDispatcher("/dev/mes-projets.jsp").forward(request, response);
    }
}