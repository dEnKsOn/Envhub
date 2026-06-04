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
import models.TypeTechno; // <-- IMPORT DE TON ENUM AJOUTÉ ICI
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
        }
        return null;
    }

    // =========================================================================
    // CORRECTION : Conversion du String SQL vers l'Enum TypeTechno
    // =========================================================================
    public List<VersionTechno> findByEnvironnement(UUID idEnv) {
        List<VersionTechno> result = new ArrayList<>();
        String sql = "SELECT vt.idEnv, vt.idTechno, vt.version, t.nomTechno, t.typeTechno " +
                     "FROM VersionTechno vt " +
                     "JOIN Technologie t ON vt.idTechno = t.idTechno " +
                     "WHERE vt.idEnv = ?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, idEnv.toString());
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    VersionTechno vt = new VersionTechno();
                    vt.setVersion(rs.getString("version"));

                    Environnement environnement = new Environnement();
                    environnement.setIdEnv(UUID.fromString(rs.getString("idEnv")));
                    vt.setEnvironnement(environnement);

                    // On charge l'objet Technologie complet avec son nom
                    Technologie technologie = new Technologie();
                    technologie.setIdTechno(UUID.fromString(rs.getString("idTechno")));
                    technologie.setNomTechno(rs.getString("nomTechno"));
                    
                    // CORRECTION LIGNE 65 : Conversion String -> Enum
                    String typeStr = rs.getString("typeTechno");
                    if (typeStr != null && !typeStr.trim().isEmpty()) {
                        technologie.setTypeTechno(TypeTechno.valueOf(typeStr));
                    }
                    
                    vt.setTechnologie(technologie);

                    result.add(vt);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des versions techno : " + e.getMessage());
        }
        return result;
    }

    // Méthode orientée objet
    public boolean save(VersionTechno vt) {
        return save(vt.getEnvironnement().getIdEnv(), vt.getTechnologie().getIdTechno(), vt.getVersion());
    }

    // Méthode avec les paramètres natifs
    public boolean save(UUID idEnv, UUID idTechno, String version) {
        String sql = "INSERT INTO VersionTechno (idEnv, idTechno, version) VALUES (?, ?, ?)";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, idEnv.toString());
            stmt.setString(2, idTechno.toString());
            stmt.setString(3, version != null ? version : "");
            
            return stmt.executeUpdate() > 0;
            
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'enregistrement de la version techno : " + e.getMessage());
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
        }
        return false;
    }

    // Fonction utilitaire pour le findById classique
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