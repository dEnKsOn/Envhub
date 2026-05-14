package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Profil;
import utils.DbConnection;

public class ProfilDAO implements IGenericDAO<Profil, Integer> {

    @Override
    public Profil findById(Integer id) {
        String sql = "SELECT * FROM Profil WHERE idProfil = ?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapProfil(rs);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération du profil : " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Profil> findAll() {
        List<Profil> profils = new ArrayList<>();
        String sql = "SELECT * FROM Profil ORDER BY libelle ASC";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                profils.add(mapProfil(rs));
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des profils : " + e.getMessage());
            e.printStackTrace();
        }
        return profils;
    }

    @Override
    public boolean save(Profil entity) {
        String sql = "INSERT INTO Profil (libelle) VALUES (?)";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, entity.getLibelle());
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        entity.setIdProfil(generatedKeys.getInt(1));
                    }
                }
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'enregistrement du profil : " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Profil entity) {
        String sql = "UPDATE Profil SET libelle = ? WHERE idProfil = ?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, entity.getLibelle());
            stmt.setInt(2, entity.getIdProfil());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erreur lors de la mise à jour du profil : " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        String sql = "DELETE FROM Profil WHERE idProfil = ?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression du profil : " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    private Profil mapProfil(ResultSet rs) throws SQLException {
        Profil profil = new Profil();
        profil.setIdProfil(rs.getInt("idProfil"));
        profil.setLibelle(rs.getString("libelle"));
        return profil;
    }
}
