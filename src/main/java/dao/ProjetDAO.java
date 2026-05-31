package dao;

import models.Projet;
import models.StatutProjet;
import utils.DbConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProjetDAO implements IGenericDAO<Projet, UUID> {

    private Projet mapProjet(ResultSet rs) throws SQLException {
        Projet projet = new Projet();
        projet.setIdProjet(UUID.fromString(rs.getString("idProjet")));
        projet.setNomProjet(rs.getString("nomProjet"));
        projet.setDescriptionTech(rs.getString("descriptionTech"));
        projet.setDateLancement(rs.getDate("dateLancement"));
        
        Date dateLivraison = rs.getDate("dateLivraisonEstimee");
        if (dateLivraison != null) {
            projet.setDateLivraisonEstimee(dateLivraison);
        }
        
        String statutStr = rs.getString("statutProjet");
        if (statutStr != null) {
            projet.setStatutProjet(StatutProjet.valueOf(statutStr));
        }
        
        projet.setPourcentageAvancement(rs.getInt("pourcentageAvancement"));
        
        String idClientStr = rs.getString("idClient");
        if (idClientStr != null) {
            projet.setIdClient(UUID.fromString(idClientStr));
        }

        try {
            projet.setEntrepriseClient(rs.getString("entrepriseClient"));
        } catch (SQLException e) {
            // Le champ peut ne pas être dans le ResultSet selon la requête
        }

        try {
            projet.setNombreEnvironnements(rs.getInt("nombreEnvironnements"));
        } catch (SQLException e) {
            projet.setNombreEnvironnements(0);
        }

        return projet;
    }

    @Override
    public Projet findById(UUID id) {
        String sql = "SELECT p.*, c.entrepriseClient, " +
                     "COALESCE((SELECT COUNT(*) FROM Environnement e WHERE e.idProjet = p.idProjet), 0) as nombreEnvironnements " +
                     "FROM Projet p " +
                     "LEFT JOIN Client c ON p.idClient = c.idClient " +
                     "WHERE p.idProjet = ?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id.toString());

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapProjet(rs);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération du projet : " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Projet> findAll() {
        List<Projet> projets = new ArrayList<>();
        String sql = "SELECT p.*, c.entrepriseClient, " +
                     "COALESCE((SELECT COUNT(*) FROM Environnement e WHERE e.idProjet = p.idProjet), 0) as nombreEnvironnements " +
                     "FROM Projet p " +
                     "LEFT JOIN Client c ON p.idClient = c.idClient " +
                     "ORDER BY p.dateLancement DESC, p.nomProjet ASC";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                projets.add(mapProjet(rs));
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des projets : " + e.getMessage());
        }
        return projets;
    }

    public List<Projet> search(String query) {
        List<Projet> projets = new ArrayList<>();
        String sql = "SELECT p.*, c.entrepriseClient, " +
                     "COALESCE((SELECT COUNT(*) FROM Environnement e WHERE e.idProjet = p.idProjet), 0) as nombreEnvironnements " +
                     "FROM Projet p " +
                     "LEFT JOIN Client c ON p.idClient = c.idClient " +
                     "WHERE LOWER(p.nomProjet) LIKE ? OR LOWER(c.entrepriseClient) LIKE ? " +
                     "ORDER BY p.dateLancement DESC, p.nomProjet ASC";

        String searchTerm = "%" + query.toLowerCase() + "%";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, searchTerm);
            stmt.setString(2, searchTerm);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    projets.add(mapProjet(rs));
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la recherche des projets : " + e.getMessage());
        }
        return projets;
    }

    @Override
    public boolean save(Projet entity) {
        String sql = "INSERT INTO Projet (idProjet, nomProjet, descriptionTech, dateLancement, dateLivraisonEstimee, statutProjet, pourcentageAvancement, idClient) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            if (entity.getIdProjet() == null) {
                entity.setIdProjet(UUID.randomUUID());
            }

            stmt.setString(1, entity.getIdProjet().toString());
            stmt.setString(2, entity.getNomProjet());
            
            if (entity.getDescriptionTech() != null && !entity.getDescriptionTech().trim().isEmpty()) {
                stmt.setString(3, entity.getDescriptionTech());
            } else {
                stmt.setNull(3, Types.VARCHAR);
            }
            
            stmt.setDate(4, new Date(entity.getDateLancement().getTime()));
            
            if (entity.getDateLivraisonEstimee() != null) {
                stmt.setDate(5, new Date(entity.getDateLivraisonEstimee().getTime()));
            } else {
                stmt.setNull(5, Types.DATE);
            }
            
            stmt.setString(6, entity.getStatutProjet().name());
            stmt.setInt(7, entity.getPourcentageAvancement());
            
            if (entity.getIdClient() != null) {
                stmt.setString(8, entity.getIdClient().toString());
            } else {
                stmt.setNull(8, Types.VARCHAR);
            }

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'enregistrement du projet : " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(Projet entity) {
        String sql = "UPDATE Projet SET nomProjet = ?, descriptionTech = ?, dateLancement = ?, dateLivraisonEstimee = ?, statutProjet = ?, pourcentageAvancement = ?, idClient = ? WHERE idProjet = ?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, entity.getNomProjet());
            
            if (entity.getDescriptionTech() != null && !entity.getDescriptionTech().trim().isEmpty()) {
                stmt.setString(2, entity.getDescriptionTech());
            } else {
                stmt.setNull(2, Types.VARCHAR);
            }
            
            stmt.setDate(3, new Date(entity.getDateLancement().getTime()));
            
            if (entity.getDateLivraisonEstimee() != null) {
                stmt.setDate(4, new Date(entity.getDateLivraisonEstimee().getTime()));
            } else {
                stmt.setNull(4, Types.DATE);
            }
            
            stmt.setString(5, entity.getStatutProjet().name());
            stmt.setInt(6, entity.getPourcentageAvancement());
            
            if (entity.getIdClient() != null) {
                stmt.setString(7, entity.getIdClient().toString());
            } else {
                stmt.setNull(7, Types.VARCHAR);
            }
            
            stmt.setString(8, entity.getIdProjet().toString());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erreur lors de la mise à jour du projet : " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(UUID id) {
        String sql = "DELETE FROM Projet WHERE idProjet = ?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id.toString());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression du projet : " + e.getMessage());
        }
        return false;
    }

    /**
     * ===================================================================================
     * 🚀 MOTEUR DE PROGRESSION AUTOMATISÉ (EVENT-DRIVEN)
     * ===================================================================================
     */
    public void evaluerProgression(UUID idProjet) {
        try (Connection conn = DbConnection.getConnection()) {
            
            int avancementActuel = 0;
            String sqlProjet = "SELECT pourcentageAvancement FROM Projet WHERE idProjet = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sqlProjet)) {
                stmt.setString(1, idProjet.toString());
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) avancementActuel = rs.getInt("pourcentageAvancement");
                }
            }

            int nouvelAvancement = 0;

            String sqlAffect = "SELECT roleProjet FROM Affectation WHERE idProjet = ?";
            boolean hasChef = false, hasDev = false;
            try (PreparedStatement stmt = conn.prepareStatement(sqlAffect)) {
                stmt.setString(1, idProjet.toString());
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        if ("CHEF_PROJET".equals(rs.getString("roleProjet"))) hasChef = true;
                        if ("DEVELOPPEUR".equals(rs.getString("roleProjet"))) hasDev = true;
                    }
                }
            }
            if (hasChef) nouvelAvancement += 10;
            if (hasDev) nouvelAvancement += 10;

            String sqlEnv = "SELECT typeEnv FROM Environnement WHERE idProjet = ?";
            boolean hasLocalOrDev = false, hasStaging = false, hasProd = false;
            try (PreparedStatement stmt = conn.prepareStatement(sqlEnv)) {
                stmt.setString(1, idProjet.toString());
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        String type = rs.getString("typeEnv");
                        if ("LOCAL".equals(type) || "DEVELOPPEMENT".equals(type)) hasLocalOrDev = true;
                        if ("STAGING".equals(type)) hasStaging = true;
                        if ("PRODUCTION".equals(type)) hasProd = true;
                    }
                }
            }
            if (hasLocalOrDev) nouvelAvancement += 20;
            if (hasStaging) nouvelAvancement += 20;

            String sqlTech = "SELECT count(*) AS total FROM VersionTechno vt JOIN Environnement e ON vt.idEnv = e.idEnv WHERE e.idProjet = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sqlTech)) {
                stmt.setString(1, idProjet.toString());
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next() && rs.getInt("total") > 0) {
                        nouvelAvancement += 15;
                    }
                }
            }

            if (hasProd) {
                nouvelAvancement = 100;
            }

            if (nouvelAvancement > avancementActuel) {
                String sqlUpdate = "UPDATE Projet SET pourcentageAvancement = ? ";
                
                if (nouvelAvancement >= 100) {
                    nouvelAvancement = 100;
                    sqlUpdate += ", statutProjet = 'LIVRE' ";
                }
                
                sqlUpdate += "WHERE idProjet = ?";
                
                try (PreparedStatement stmt = conn.prepareStatement(sqlUpdate)) {
                    stmt.setInt(1, nouvelAvancement);
                    stmt.setString(2, idProjet.toString());
                    stmt.executeUpdate();
                }
            }

        } catch (SQLException e) {
            System.err.println("Erreur (evaluerProgression) : " + e.getMessage());
        }
    }
}