package controllers.dev;

import dao.AffectationDAO;
import dao.EnvironnementDAO;
import dao.ProjetDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.Affectation;
import models.Environnement;
import models.Projet;
import models.RoleProjet;
import models.StatutProjet;
import models.Utilisateur;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@WebServlet("/dev/dashboard")
public class DevDashboardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private AffectationDAO affectationDAO;
    private ProjetDAO projetDAO;
    private EnvironnementDAO environnementDAO;

    @Override
    public void init() throws ServletException {
        this.affectationDAO = new AffectationDAO();
        this.projetDAO = new ProjetDAO();
        this.environnementDAO = new EnvironnementDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        Utilisateur currentUser = (Utilisateur) session.getAttribute("user");

        // 1. Récupérer toutes les affectations de ce développeur
        List<Affectation> mesAffectations = affectationDAO.findByUtilisateur(currentUser.getIdUser());

        // 2. Extraire la liste des Projets
        List<Projet> mesProjets = new ArrayList<>();
        int countChefDeProjet = 0;
        
        for (Affectation aff : mesAffectations) {
            mesProjets.add(aff.getProjet());
            if (aff.getRoleProjet() == RoleProjet.CHEF_PROJET) {
                countChefDeProjet++;
            }
        }

        // 3. Calcul des KPIs
        long countProjetsEnCours = mesProjets.stream().filter(p -> p.getStatutProjet() == StatutProjet.EN_COURS).count();
        long countProjetsLivres = mesProjets.stream().filter(p -> p.getStatutProjet() == StatutProjet.LIVRE).count();

        // Pour les environnements, on cherche ceux qui appartiennent aux projets du dev
        List<Environnement> mesEnvs = new ArrayList<>();
        for (Projet p : mesProjets) {
            mesEnvs.addAll(environnementDAO.findByProjet(p.getIdProjet()));
        }

        request.setAttribute("kpiMesProjets", countProjetsEnCours);
        request.setAttribute("kpiMesEnvs", mesEnvs.size());
        request.setAttribute("kpiChefDeProjet", countChefDeProjet);
        request.setAttribute("kpiProjetsLivres", countProjetsLivres);

        // 4. Préparation du tableau (Projet + Rôle)
        List<Map<String, Object>> listeMesProjetsRecents = new ArrayList<>();
        List<Affectation> affectationsEnCours = mesAffectations.stream()
            .filter(a -> a.getProjet().getStatutProjet() == StatutProjet.EN_COURS)
            .limit(5)
            .collect(Collectors.toList());

        for (Affectation aff : affectationsEnCours) {
            Map<String, Object> map = new HashMap<>();
            map.put("projet", aff.getProjet());
            map.put("role", aff.getRoleProjet().name().replace("_", " "));
            listeMesProjetsRecents.add(map);
        }
        request.setAttribute("listeMesProjetsRecents", listeMesProjetsRecents);

        // 5. Statistiques Graphique
        request.setAttribute("statDev", mesEnvs.stream().filter(e -> "DEVELOPPEMENT".equals(e.getTypeEnv().name())).count());
        request.setAttribute("statStaging", mesEnvs.stream().filter(e -> "STAGING".equals(e.getTypeEnv().name())).count());
        request.setAttribute("statProd", mesEnvs.stream().filter(e -> "PRODUCTION".equals(e.getTypeEnv().name())).count());
        request.setAttribute("statLocal", mesEnvs.stream().filter(e -> "LOCAL".equals(e.getTypeEnv().name())).count());
       
        request.getRequestDispatcher("/dev/dashboard-stats.jsp").forward(request, response);
    }
}