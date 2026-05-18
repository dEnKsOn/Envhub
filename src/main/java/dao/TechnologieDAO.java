package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import models.Technologie;
import models.TypeTechno;
import utils.DbConnection;

public class TechnologieDAO implements IGenericDAO<Technologie, UUID> {

    private Technologie mapTechnologie(ResultSet rs) throws SQLException {
        Technologie technologie = new Technologie();
        technologie.setIdTechno(UUID.fromString(rs.getString("idTechno")));
        technologie.setNomTechno(rs.getString("nomTechno"));
        technologie.setTypeTechno(TypeTechno.valueOf(rs.getString("typeTechno")));
        try {
            technologie.setUtilisations(rs.getInt("utilisations"));
        } catch (SQLException e) {
            technologie.setUtilisations(0);
        }
        return technologie;
    }

    @Override
    public Technologie findById(UUID id) {
        String sql = "SELECT t.idTechno, t.nomTechno, t.typeTechno, COUNT(vt.idEnv) as utilisations " +
                     "FROM Technologie t " +
                     "LEFT JOIN VersionTechno vt ON t.idTechno = vt.idTechno " +
                     "WHERE t.idTechno = ? " +
                     "GROUP BY t.idTechno, t.nomTechno, t.typeTechno";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id.toString());
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapTechnologie(rs);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération de la technologie : " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Technologie> findAll() {
        List<Technologie> technologies = new ArrayList<>();
        String sql = "SELECT t.idTechno, t.nomTechno, t.typeTechno, COUNT(vt.idEnv) as utilisations " +
                     "FROM Technologie t " +
                     "LEFT JOIN VersionTechno vt ON t.idTechno = vt.idTechno " +
                     "GROUP BY t.idTechno, t.nomTechno, t.typeTechno " +
                     "ORDER BY t.nomTechno ASC";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                technologies.add(mapTechnologie(rs));
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des technologies : " + e.getMessage());
            e.printStackTrace();
        }
        return technologies;
    }

    public List<Technologie> search(String query) {
        List<Technologie> technologies = new ArrayList<>();
        String sql = "SELECT t.idTechno, t.nomTechno, t.typeTechno, COUNT(vt.idEnv) as utilisations " +
                     "FROM Technologie t " +
                     "LEFT JOIN VersionTechno vt ON t.idTechno = vt.idTechno " +
                     "WHERE LOWER(t.nomTechno) LIKE ? " +
                     "OR LOWER(t.typeTechno) LIKE ? " +
                     "GROUP BY t.idTechno, t.nomTechno, t.typeTechno " +
                     "ORDER BY t.nomTechno ASC";

        String searchTerm = "%" + query.toLowerCase() + "%";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, searchTerm);
            stmt.setString(2, searchTerm);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    technologies.add(mapTechnologie(rs));
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la recherche des technologies : " + e.getMessage());
            e.printStackTrace();
        }
        return technologies;
    }

    public boolean isNomTechnoExists(String nomTechno, UUID excludeId) {
        String sql = "SELECT COUNT(*) FROM Technologie WHERE LOWER(nomTechno) = LOWER(?)";
        if (excludeId != null) {
            sql += " AND idTechno != ?";
        }

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nomTechno);
            if (excludeId != null) {
                stmt.setString(2, excludeId.toString());
            }

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la vérification du nom de technologie : " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean save(Technologie entity) {
        String sql = "INSERT INTO Technologie (idTechno, nomTechno, typeTechno) VALUES (?, ?, ?)";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            if (entity.getIdTechno() == null) {
                entity.setIdTechno(UUID.randomUUID());
            }
            
            stmt.setString(1, entity.getIdTechno().toString());
            stmt.setString(2, entity.getNomTechno());
            stmt.setString(3, entity.getTypeTechno().name());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'enregistrement de la technologie : " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Technologie entity) {
        String sql = "UPDATE Technologie SET nomTechno = ?, typeTechno = ? WHERE idTechno = ?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, entity.getNomTechno());
            stmt.setString(2, entity.getTypeTechno().name());
            stmt.setString(3, entity.getIdTechno().toString());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erreur lors de la mise à jour de la technologie : " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(UUID id) {
        String sql = "DELETE FROM Technologie WHERE idTechno = ?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id.toString());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression de la technologie : " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }
}