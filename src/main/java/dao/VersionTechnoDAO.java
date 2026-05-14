package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import models.Environnement;
import models.Technologie;
import models.VersionTechno;
import utils.DbConnection;

public class VersionTechnoDAO {

    public VersionTechno findById(UUID idEnv, UUID idTechno) {
        String sql = "SELECT * FROM VersionTechno WHERE idEnv = ? AND idTechno = ?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, idEnv.toString());
            stmt.setString(2, idTechno.toString());

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapVersionTechno(rs);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération de la version techno : " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public List<VersionTechno> findByEnvironnement(UUID idEnv) {
        List<VersionTechno> result = new ArrayList<>();
        String sql = "SELECT * FROM VersionTechno WHERE idEnv = ?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, idEnv.toString());
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    result.add(mapVersionTechno(rs));
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des versions techno de l'environnement : " + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public boolean save(UUID idEnv, UUID idTechno, String version) {
        String sql = "INSERT INTO VersionTechno (idEnv, idTechno, version) VALUES (?, ?, ?)";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, idEnv.toString());
            stmt.setString(2, idTechno.toString());
            stmt.setString(3, version);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'enregistrement de la version techno : " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(UUID idEnv, UUID idTechno) {
        String sql = "DELETE FROM VersionTechno WHERE idEnv = ? AND idTechno = ?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, idEnv.toString());
            stmt.setString(2, idTechno.toString());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression de la version techno : " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    private VersionTechno mapVersionTechno(ResultSet rs) throws SQLException {
        VersionTechno versionTechno = new VersionTechno();
        versionTechno.setVersion(rs.getString("version"));

        Environnement environnement = new Environnement();
        environnement.setIdEnv(UUID.fromString(rs.getString("idEnv")));
        versionTechno.setEnvironnement(environnement);

        Technologie technologie = new Technologie();
        technologie.setIdTechno(UUID.fromString(rs.getString("idTechno")));
        versionTechno.setTechnologie(technologie);

        return versionTechno;
    }
}
