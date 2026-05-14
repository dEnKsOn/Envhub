package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import models.Affectation;
import models.Projet;
import models.RoleProjet;
import models.Utilisateur;
import utils.DbConnection;

public class AffectationDAO {

    public Affectation findByKeys(UUID idProjet, UUID idUser) {
        String sql = "SELECT * FROM Affectation WHERE idProjet = ? AND idUser = ?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, idProjet.toString());
            stmt.setString(2, idUser.toString());

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapAffectation(rs);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération de l'affectation : " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public List<Affectation> findByProjet(UUID idProjet) {
        List<Affectation> result = new ArrayList<>();
        String sql = "SELECT * FROM Affectation WHERE idProjet = ?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, idProjet.toString());
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    result.add(mapAffectation(rs));
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des affectations du projet : " + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public List<Affectation> findByUtilisateur(UUID idUser) {
        List<Affectation> result = new ArrayList<>();
        String sql = "SELECT * FROM Affectation WHERE idUser = ?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, idUser.toString());
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    result.add(mapAffectation(rs));
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des affectations de l'utilisateur : " + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public List<Affectation> findAll() {
        List<Affectation> result = new ArrayList<>();
        String sql = "SELECT * FROM Affectation";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                result.add(mapAffectation(rs));
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des affectations : " + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public boolean save(UUID idProjet, UUID idUser, RoleProjet roleProjet) {
        String sql = "INSERT INTO Affectation (idProjet, idUser, roleProjet) VALUES (?, ?, ?)";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, idProjet.toString());
            stmt.setString(2, idUser.toString());
            stmt.setString(3, roleProjet.name());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'enregistrement de l'affectation : " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(UUID idProjet, UUID idUser) {
        String sql = "DELETE FROM Affectation WHERE idProjet = ? AND idUser = ?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, idProjet.toString());
            stmt.setString(2, idUser.toString());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression de l'affectation : " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    private Affectation mapAffectation(ResultSet rs) throws SQLException {
        Affectation affectation = new Affectation();
        affectation.setRoleProjet(RoleProjet.valueOf(rs.getString("roleProjet")));

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setIdUser(UUID.fromString(rs.getString("idUser")));
        affectation.setUtilisateur(utilisateur);

        Projet projet = new Projet();
        projet.setIdProjet(UUID.fromString(rs.getString("idProjet")));
        affectation.setProjet(projet);

        return affectation;
    }
}
