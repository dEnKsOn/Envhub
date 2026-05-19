package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import models.Environnement;
import models.Serveur;
import models.TypeEnvironnement;
import utils.DbConnection;

public class EnvironnementDAO implements IGenericDAO<Environnement, UUID> {

    @Override
    public Environnement findById(UUID id) {
        String sql = "SELECT e.*, s.adressIP, s.os FROM Environnement e " +
                     "LEFT JOIN Serveur s ON e.idServ = s.idServ " +
                     "WHERE e.idEnv = ?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id.toString());
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapEnvironnement(rs);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération de l'environnement : " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Environnement> findAll() {
        List<Environnement> environnements = new ArrayList<>();
        String sql = "SELECT e.*, s.adressIP, s.os FROM Environnement e " +
                     "LEFT JOIN Serveur s ON e.idServ = s.idServ ORDER BY e.nomBaseDeDonnees ASC";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                environnements.add(mapEnvironnement(rs));
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des environnements : " + e.getMessage());
            e.printStackTrace();
        }
        return environnements;
    }

    @Override
    public boolean save(Environnement entity) {
        String sql = "INSERT INTO Environnement (idEnv, typeEnv, nomBaseDeDonnees, urlFront, urlBack, notes, idProjet, idServ) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, entity.getIdEnv().toString());
            stmt.setString(2, entity.getTypeEnv().name());
            stmt.setString(3, entity.getNomBaseDeDonnees());
            stmt.setString(4, entity.getUrlFront());
            stmt.setString(5, entity.getUrlBack());
            stmt.setString(6, entity.getNotes());
            stmt.setString(7, entity.getIdProjet().toString());

            if (entity.getIdServ() != null) {
                stmt.setString(8, entity.getIdServ().toString());
            } else {
                stmt.setNull(8, Types.CHAR);
            }
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'enregistrement de l'environnement : " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Environnement entity) {
        String sql = "UPDATE Environnement SET typeEnv = ?, nomBaseDeDonnees = ?, urlFront = ?, urlBack = ?, notes = ?, idProjet = ?, idServ = ? " +
                     "WHERE idEnv = ?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, entity.getTypeEnv().name());
            stmt.setString(2, entity.getNomBaseDeDonnees());
            stmt.setString(3, entity.getUrlFront());
            stmt.setString(4, entity.getUrlBack());
            stmt.setString(5, entity.getNotes());
            stmt.setString(6, entity.getIdProjet().toString());

            if (entity.getIdServ() != null) {
                stmt.setString(7, entity.getIdServ().toString());
            } else {
                stmt.setNull(7, Types.CHAR);
            }
            stmt.setString(8, entity.getIdEnv().toString());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erreur lors de la mise à jour de l'environnement : " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(UUID id) {
        String sql = "DELETE FROM Environnement WHERE idEnv = ?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id.toString());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression de l'environnement : " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    public List<Environnement> findByProjet(UUID idProjet) {
        List<Environnement> environnements = new ArrayList<>();
        String sql = "SELECT e.*, s.adressIP, s.os FROM Environnement e " +
                     "LEFT JOIN Serveur s ON e.idServ = s.idServ " +
                     "WHERE e.idProjet = ? ORDER BY e.typeEnv ASC, e.nomBaseDeDonnees ASC";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, idProjet.toString());
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    environnements.add(mapEnvironnement(rs));
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des environnements du projet : " + e.getMessage());
            e.printStackTrace();
        }
        return environnements;
    }

    private Environnement mapEnvironnement(ResultSet rs) throws SQLException {
        Environnement environnement = new Environnement();
        environnement.setIdEnv(UUID.fromString(rs.getString("idEnv")));
        environnement.setTypeEnv(TypeEnvironnement.valueOf(rs.getString("typeEnv")));
        environnement.setNomBaseDeDonnees(rs.getString("nomBaseDeDonnees"));
        environnement.setUrlFront(rs.getString("urlFront"));
        environnement.setUrlBack(rs.getString("urlBack"));
        environnement.setNotes(rs.getString("notes"));
        environnement.setIdProjet(UUID.fromString(rs.getString("idProjet")));

        String idServ = rs.getString("idServ");
        if (idServ != null) {
            environnement.setIdServ(UUID.fromString(idServ));
            Serveur serveur = new Serveur();
            serveur.setIdServ(UUID.fromString(idServ));
            serveur.setAdressIP(rs.getString("adressIP"));
            serveur.setOs(rs.getString("os"));
            environnement.setServeur(serveur);
        }
        return environnement;
    }
}
