package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import models.DemandeProjet;
import models.StatutDemande;
import utils.DbConnection;

public class DemandeProjetDAO implements IGenericDAO<DemandeProjet, UUID> {

    private DemandeProjet mapDemandeProjet(ResultSet rs) throws SQLException {
        DemandeProjet demande = new DemandeProjet();
        demande.setIdDemande(UUID.fromString(rs.getString("idDemande")));
        demande.setNomClient(rs.getString("nomClient"));
        demande.setEmailClient(rs.getString("emailClient"));
        demande.setEntrepriseClient(rs.getString("entrepriseClient"));
        demande.setTitreProjet(rs.getString("titreProjet"));
        demande.setDescriptionBesoin(rs.getString("descriptionBesoin"));

        double budget = rs.getDouble("budgetEstime");
        demande.setBudgetEstime(rs.wasNull() ? null : budget);

        Timestamp tsSoumission = rs.getTimestamp("dateSoumission");
        if (tsSoumission != null) {
            demande.setDateSoumission(tsSoumission.toLocalDateTime());
        }

        String statutStr = rs.getString("statutDemande");
        if (statutStr != null) {
            demande.setStatutDemande(StatutDemande.valueOf(statutStr));
        }

        Timestamp tsTraitement = rs.getTimestamp("dateTraitement");
        if (tsTraitement != null) {
            demande.setDateTraitement(tsTraitement.toLocalDateTime());
        }

        return demande;
    }

    @Override
    public DemandeProjet findById(UUID id) {
        String sql = "SELECT * FROM DemandeProjet WHERE idDemande = ?";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setString(1, id.toString());
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapDemandeProjet(rs);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération de la demande : " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<DemandeProjet> findAll() {
        List<DemandeProjet> demandes = new ArrayList<>();
        String sql = "SELECT * FROM DemandeProjet ORDER BY dateSoumission DESC";
        
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
             
            while (rs.next()) {
                demandes.add(mapDemandeProjet(rs));
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des demandes : " + e.getMessage());
        }
        return demandes;
    }

    public List<DemandeProjet> findByStatut(StatutDemande statut) {
        List<DemandeProjet> demandes = new ArrayList<>();
        String sql = "SELECT * FROM DemandeProjet WHERE statutDemande = ? ORDER BY dateSoumission DESC";
        
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setString(1, statut.name());
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    demandes.add(mapDemandeProjet(rs));
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur filtrage statut : " + e.getMessage());
        }
        return demandes;
    }

    /**
     * =========================================================
     * NOUVELLE MÉTHODE : Compter les demandes par statut pour le KPI
     * =========================================================
     */
    public int countByStatut(StatutDemande statut) {
        int count = 0;
        String sql = "SELECT COUNT(*) FROM DemandeProjet WHERE statutDemande = ?";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setString(1, statut.name());
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    count = rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur comptage statut : " + e.getMessage());
        }
        return count;
    }

    @Override
    public boolean save(DemandeProjet entity) {
        String sql = "INSERT INTO DemandeProjet (idDemande, nomClient, emailClient, entrepriseClient, titreProjet, descriptionBesoin, budgetEstime, statutDemande) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            if (entity.getIdDemande() == null) {
                entity.setIdDemande(UUID.randomUUID());
            }
            
            stmt.setString(1, entity.getIdDemande().toString());
            stmt.setString(2, entity.getNomClient());
            stmt.setString(3, entity.getEmailClient());
            stmt.setString(4, entity.getEntrepriseClient());
            stmt.setString(5, entity.getTitreProjet());
            stmt.setString(6, entity.getDescriptionBesoin());
            
            if (entity.getBudgetEstime() != null) {
                stmt.setDouble(7, entity.getBudgetEstime());
            } else {
                stmt.setNull(7, Types.DECIMAL);
            }
            
            stmt.setString(8, entity.getStatutDemande().name());
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'enregistrement de la demande : " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(DemandeProjet entity) {
        String sql = "UPDATE DemandeProjet SET nomClient = ?, emailClient = ?, entrepriseClient = ?, titreProjet = ?, descriptionBesoin = ?, budgetEstime = ?, statutDemande = ? WHERE idDemande = ?";
        
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setString(1, entity.getNomClient());
            stmt.setString(2, entity.getEmailClient());
            stmt.setString(3, entity.getEntrepriseClient());
            stmt.setString(4, entity.getTitreProjet());
            stmt.setString(5, entity.getDescriptionBesoin());
            
            if (entity.getBudgetEstime() != null) {
                stmt.setDouble(6, entity.getBudgetEstime());
            } else {
                stmt.setNull(6, Types.DECIMAL);
            }
            
            stmt.setString(7, entity.getStatutDemande().name());
            stmt.setString(8, entity.getIdDemande().toString());
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erreur lors de la mise à jour de la demande : " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(UUID id) {
        String sql = "DELETE FROM DemandeProjet WHERE idDemande = ?";
        
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setString(1, id.toString());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression de la demande : " + e.getMessage());
        }
        return false;
    }
}