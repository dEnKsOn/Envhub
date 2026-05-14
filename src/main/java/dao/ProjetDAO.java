package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import models.Projet;
import models.StatutProjet;
import utils.DbConnection;

public class ProjetDAO implements IGenericDAO<Projet, UUID> {

    @Override
    public Projet findById(UUID id) {
        String sql = "SELECT p.*, c.nomClient FROM Projet p " +
                     "LEFT JOIN Client c ON p.idClient = c.idClient " +
                     "WHERE p.idProjet = ?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id.toString());

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Projet projet = mapProjet(rs);
                    projet.setNomClient(rs.getString("nomClient"));
                    return projet;
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
        List<Projet> listProjets = new ArrayList<>();
        String sql = "SELECT p.*, c.nomClient FROM Projet p " +
                     "LEFT JOIN Client c ON p.idClient = c.idClient " +
                     "ORDER BY p.dateLancement DESC";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Projet projet = mapProjet(rs);
                projet.setNomClient(rs.getString("nomClient"));
                listProjets.add(projet);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des projets : " + e.getMessage());
            e.printStackTrace();
        }
        return listProjets;
    }

    @Override
    public boolean save(Projet entity) {
        String sql = "INSERT INTO Projet (idProjet, nomProjet, descriptionTech, dateLancement, dateLivraisonEstimee, statutProjet, idClient) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, entity.getIdProjet().toString());
            stmt.setString(2, entity.getNomProjet());
            stmt.setString(3, entity.getDescriptionTech());
            stmt.setDate(4, new Date(entity.getDateLancement().getTime()));

            if (entity.getDateLivraisonEstimee() != null) {
                stmt.setDate(5, new Date(entity.getDateLivraisonEstimee().getTime()));
            } else {
                stmt.setNull(5, Types.DATE);
            }

            stmt.setString(6, entity.getStatutProjet() != null ? entity.getStatutProjet().name() : StatutProjet.EN_COURS.name());

            if (entity.getIdClient() != null) {
                stmt.setString(7, entity.getIdClient().toString());
            } else {
                stmt.setNull(7, Types.CHAR);
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
        String sql = "UPDATE Projet SET nomProjet = ?, descriptionTech = ?, dateLancement = ?, dateLivraisonEstimee = ?, statutProjet = ?, idClient = ? " +
                     "WHERE idProjet = ?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, entity.getNomProjet());
            stmt.setString(2, entity.getDescriptionTech());
            stmt.setDate(3, new Date(entity.getDateLancement().getTime()));

            if (entity.getDateLivraisonEstimee() != null) {
                stmt.setDate(4, new Date(entity.getDateLivraisonEstimee().getTime()));
            } else {
                stmt.setNull(4, Types.DATE);
            }

            stmt.setString(5, entity.getStatutProjet() != null ? entity.getStatutProjet().name() : StatutProjet.EN_COURS.name());

            if (entity.getIdClient() != null) {
                stmt.setString(6, entity.getIdClient().toString());
            } else {
                stmt.setNull(6, Types.CHAR);
            }

            stmt.setString(7, entity.getIdProjet().toString());
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

    private Projet mapProjet(ResultSet rs) throws SQLException {
        Projet projet = new Projet();
        projet.setIdProjet(UUID.fromString(rs.getString("idProjet")));
        projet.setNomProjet(rs.getString("nomProjet"));
        projet.setDescriptionTech(rs.getString("descriptionTech"));
        projet.setDateLancement(rs.getDate("dateLancement"));
        projet.setDateLivraisonEstimee(rs.getDate("dateLivraisonEstimee"));

        String statut = rs.getString("statutProjet");
        if (statut != null) {
            projet.setStatutProjet(StatutProjet.valueOf(statut));
        }
        projet.setIdClient(UUID.fromString(rs.getString("idClient")));
        return projet;
    }
}
