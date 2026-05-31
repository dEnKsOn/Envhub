package controllers.admin;

import dao.ClientDAO;
import dao.EnvironnementDAO;
import dao.ProjetDAO;
import dao.DemandeProjetDAO; // <-- Le bon nom du fichier
import dao.DashboardDAO; 

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.Projet;
import models.StatutProjet;
import models.Environnement;
import models.StatutDemande; // <-- Pour l'enum EN_ATTENTE

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ProjetDAO projetDAO;
    private ClientDAO clientDAO;
    private EnvironnementDAO environnementDAO;
    private DemandeProjetDAO demandeProjetDAO; // <-- Utilisation du bon DAO
    private DashboardDAO dashboardDAO;

    @Override
    public void init() throws ServletException {
        this.projetDAO = new ProjetDAO();
        this.clientDAO = new ClientDAO();
        this.environnementDAO = new EnvironnementDAO();
        this.demandeProjetDAO = new DemandeProjetDAO();
        this.dashboardDAO = new DashboardDAO(); 
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        List<Projet> tousLesProjets = projetDAO.findAll();
        List<Environnement> tousLesEnvs = environnementDAO.findAll();

        // --------------------------------------------------------
        // ZONE 1 : KPIs
        // --------------------------------------------------------
        
        // C'est ici que l'on compte les demandes EN_ATTENTE
        int countDemandes = demandeProjetDAO.countByStatut(StatutDemande.EN_ATTENTE);
        request.setAttribute("kpiDemandes", countDemandes);
        
        long countProjetsActifs = tousLesProjets.stream().filter(p -> p.getStatutProjet() == StatutProjet.EN_COURS).count();
        request.setAttribute("kpiProjets", countProjetsActifs);
        
        request.setAttribute("kpiClients", clientDAO.findAll().size());
        
        long countProd = tousLesEnvs.stream().filter(e -> "PRODUCTION".equals(e.getTypeEnv().name())).count();
        request.setAttribute("kpiProd", countProd);


        // --------------------------------------------------------
        // ZONE 2 : Projets Récents
        // --------------------------------------------------------
        List<Projet> projetsRecents = tousLesProjets.stream()
            .filter(p -> p.getStatutProjet() == StatutProjet.EN_COURS)
            .limit(5)
            .collect(Collectors.toList());
        request.setAttribute("listeProjetsRecents", projetsRecents);


        // --------------------------------------------------------
        // ZONE 3 : Graphique Chart.js
        // --------------------------------------------------------
        request.setAttribute("statDev", tousLesEnvs.stream().filter(e -> "DEVELOPPEMENT".equals(e.getTypeEnv().name())).count());
        request.setAttribute("statStaging", tousLesEnvs.stream().filter(e -> "STAGING".equals(e.getTypeEnv().name())).count());
        request.setAttribute("statProd", countProd);
        request.setAttribute("statLocal", tousLesEnvs.stream().filter(e -> "LOCAL".equals(e.getTypeEnv().name())).count());


        // --------------------------------------------------------
        // ZONE 4 : TIMELINE (La Magie du UNION)
        // --------------------------------------------------------
        request.setAttribute("activitesRecentes", dashboardDAO.getTimelineActivites());


        request.getRequestDispatcher("/admin/dashboard.jsp").forward(request, response);
    }
}