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
            // Field not in result set
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
            e.printStackTrace();
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
            e.printStackTrace();
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
            e.printStackTrace();
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
            e.printStackTrace();
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
            e.printStackTrace();
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
            e.printStackTrace();
        }
        return false;
    }
}