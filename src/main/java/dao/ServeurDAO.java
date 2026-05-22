package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import models.Serveur;
import utils.DbConnection;

public class ServeurDAO implements IGenericDAO<Serveur, UUID> {

    private Serveur mapServeur(ResultSet rs) throws SQLException {
        Serveur serveur = new Serveur();
        serveur.setIdServ(UUID.fromString(rs.getString("idServ")));
        serveur.setAdressIP(rs.getString("adressIP"));
        serveur.setOs(rs.getString("os"));
        serveur.setFournisseur(rs.getString("fournisseur"));
        
        int cpu = rs.getInt("cpu_cores");
        serveur.setCpuCores(rs.wasNull() ? null : cpu);
        
        int ram = rs.getInt("ram_gb");
        serveur.setRamGb(rs.wasNull() ? null : ram);
        
        try {
            serveur.setNombreEnvironnements(rs.getInt("nombreEnvironnements"));
        } catch (SQLException e) {
            serveur.setNombreEnvironnements(0);
        }
        return serveur;
    }

    @Override
    public Serveur findById(UUID id) {
        String sql = "SELECT s.idServ, s.adressIP, s.os, s.cpu_cores, s.ram_gb, s.fournisseur, COUNT(e.idEnv) as nombreEnvironnements " +
                     "FROM Serveur s " +
                     "LEFT JOIN Environnement e ON s.idServ = e.idServ " +
                     "WHERE s.idServ = ? " +
                     "GROUP BY s.idServ, s.adressIP, s.os, s.cpu_cores, s.ram_gb, s.fournisseur";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id.toString());
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) return mapServeur(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Serveur> findAll() {
        List<Serveur> serveurs = new ArrayList<>();
        String sql = "SELECT s.idServ, s.adressIP, s.os, s.cpu_cores, s.ram_gb, s.fournisseur, COUNT(e.idEnv) as nombreEnvironnements " +
                     "FROM Serveur s " +
                     "LEFT JOIN Environnement e ON s.idServ = e.idServ " +
                     "GROUP BY s.idServ, s.adressIP, s.os, s.cpu_cores, s.ram_gb, s.fournisseur " +
                     "ORDER BY s.adressIP ASC";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) serveurs.add(mapServeur(rs));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return serveurs;
    }

    public List<Serveur> search(String query) {
        List<Serveur> serveurs = new ArrayList<>();
        String sql = "SELECT s.idServ, s.adressIP, s.os, s.cpu_cores, s.ram_gb, s.fournisseur, COUNT(e.idEnv) as nombreEnvironnements " +
                     "FROM Serveur s " +
                     "LEFT JOIN Environnement e ON s.idServ = e.idServ " +
                     "WHERE LOWER(s.adressIP) LIKE ? OR LOWER(s.os) LIKE ? OR LOWER(s.fournisseur) LIKE ? " +
                     "GROUP BY s.idServ, s.adressIP, s.os, s.cpu_cores, s.ram_gb, s.fournisseur " +
                     "ORDER BY s.adressIP ASC";

        String searchTerm = "%" + query.toLowerCase() + "%";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, searchTerm);
            stmt.setString(2, searchTerm);
            stmt.setString(3, searchTerm);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) serveurs.add(mapServeur(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return serveurs;
    }

    public boolean isIpExists(String ip, UUID excludeId) {
        String sql = "SELECT COUNT(*) FROM Serveur WHERE adressIP = ?";
        if (excludeId != null) sql += " AND idServ != ?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, ip);
            if (excludeId != null) stmt.setString(2, excludeId.toString());
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean save(Serveur entity) {
        String sql = "INSERT INTO Serveur (idServ, adressIP, os, cpu_cores, ram_gb, fournisseur) VALUES (?, ?, ?, ?, ?, ?)";
        return executeUpdate(sql, entity);
    }

    @Override
    public boolean update(Serveur entity) {
        String sql = "UPDATE Serveur SET adressIP = ?, os = ?, cpu_cores = ?, ram_gb = ?, fournisseur = ? WHERE idServ = ?";
        return executeUpdate(sql, entity);
    }

    private boolean executeUpdate(String sql, Serveur entity) {
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            if (entity.getIdServ() == null) entity.setIdServ(UUID.randomUUID());
            
            stmt.setString(1, entity.getAdressIP());
            stmt.setString(2, entity.getOs());
            
            if (entity.getCpuCores() != null) stmt.setInt(3, entity.getCpuCores());
            else stmt.setNull(3, Types.INTEGER);
            
            if (entity.getRamGb() != null) stmt.setInt(4, entity.getRamGb());
            else stmt.setNull(4, Types.INTEGER);
            
            stmt.setString(5, entity.getFournisseur());
            
            // Pour l'UPDATE, l'ID est en 6ème position. Pour le SAVE, il est en 1ère position, 
            // donc on ajuste selon la requête.
            if (sql.startsWith("UPDATE")) {
                stmt.setString(6, entity.getIdServ().toString());
            } else {
                // Réorganisation pour l'INSERT
                stmt.setString(1, entity.getIdServ().toString());
                stmt.setString(2, entity.getAdressIP());
                stmt.setString(3, entity.getOs());
                if (entity.getCpuCores() != null) stmt.setInt(4, entity.getCpuCores());
                else stmt.setNull(4, Types.INTEGER);
                if (entity.getRamGb() != null) stmt.setInt(5, entity.getRamGb());
                else stmt.setNull(5, Types.INTEGER);
                stmt.setString(6, entity.getFournisseur());
            }
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
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
            e.printStackTrace();
        }
        return false;
    }
}