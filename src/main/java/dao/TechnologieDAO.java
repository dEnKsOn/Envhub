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

    @Override
    public Technologie findById(UUID id) {
        String sql = "SELECT * FROM Technologie WHERE idTechno = ?";

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
        String sql = "SELECT * FROM Technologie ORDER BY nomTechno ASC";

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

    @Override
    public boolean save(Technologie entity) {
        String sql = "INSERT INTO Technologie (idTechno, nomTechno, typeTechno) VALUES (?, ?, ?)";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

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

    private Technologie mapTechnologie(ResultSet rs) throws SQLException {
        Technologie technologie = new Technologie();
        technologie.setIdTechno(UUID.fromString(rs.getString("idTechno")));
        technologie.setNomTechno(rs.getString("nomTechno"));
        technologie.setTypeTechno(TypeTechno.valueOf(rs.getString("typeTechno")));
        return technologie;
    }
}
