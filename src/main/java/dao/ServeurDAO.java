package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import models.Serveur;
import utils.DbConnection;

public class ServeurDAO implements IGenericDAO<Serveur, UUID> {

    @Override
    public Serveur findById(UUID id) {
        String sql = "SELECT * FROM Serveur WHERE idServ = ?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id.toString());
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapServeur(rs);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération du serveur : " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Serveur> findAll() {
        List<Serveur> serveurs = new ArrayList<>();
        String sql = "SELECT * FROM Serveur ORDER BY adressIP ASC";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                serveurs.add(mapServeur(rs));
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des serveurs : " + e.getMessage());
            e.printStackTrace();
        }
        return serveurs;
    }

    @Override
    public boolean save(Serveur entity) {
        String sql = "INSERT INTO Serveur (idServ, adressIP, os) VALUES (?, ?, ?)";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, entity.getIdServ().toString());
            stmt.setString(2, entity.getAdressIP());
            stmt.setString(3, entity.getOs());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'enregistrement du serveur : " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Serveur entity) {
        String sql = "UPDATE Serveur SET adressIP = ?, os = ? WHERE idServ = ?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, entity.getAdressIP());
            stmt.setString(2, entity.getOs());
            stmt.setString(3, entity.getIdServ().toString());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erreur lors de la mise à jour du serveur : " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(UUID id) {
        String sql = "DELETE FROM Serveur WHERE idServ = ?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id.toString());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression du serveur : " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    private Serveur mapServeur(ResultSet rs) throws SQLException {
        Serveur serveur = new Serveur();
        serveur.setIdServ(UUID.fromString(rs.getString("idServ")));
        serveur.setAdressIP(rs.getString("adressIP"));
        serveur.setOs(rs.getString("os"));
        return serveur;
    }
}
