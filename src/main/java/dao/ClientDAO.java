package dao;

import models.Client;
import utils.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ClientDAO implements IGenericDAO<Client, UUID> {

    private Client mapClient(ResultSet rs) throws SQLException {
        Client client = new Client();
        client.setIdClient(UUID.fromString(rs.getString("idClient")));
        client.setNomClient(rs.getString("nomClient"));
        client.setPrenomClient(rs.getString("prenomClient"));
        client.setEntrepriseClient(rs.getString("entrepriseClient"));
        
        try {
            client.setNombreProjets(rs.getInt("nombreProjets"));
        } catch (SQLException e) {
            client.setNombreProjets(0);
        }
        return client;
    }

    @Override
    public Client findById(UUID id) {
        String sql = "SELECT c.idClient, c.nomClient, c.prenomClient, c.entrepriseClient, COUNT(p.idProjet) as nombreProjets " +
                     "FROM Client c " +
                     "LEFT JOIN Projet p ON c.idClient = p.idClient " +
                     "WHERE c.idClient = ? " +
                     "GROUP BY c.idClient, c.nomClient, c.prenomClient, c.entrepriseClient";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id.toString());

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapClient(rs);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération du client : " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Client> findAll() {
        List<Client> clients = new ArrayList<>();
        String sql = "SELECT c.idClient, c.nomClient, c.prenomClient, c.entrepriseClient, COUNT(p.idProjet) as nombreProjets " +
                     "FROM Client c " +
                     "LEFT JOIN Projet p ON c.idClient = p.idClient " +
                     "GROUP BY c.idClient, c.nomClient, c.prenomClient, c.entrepriseClient " +
                     "ORDER BY c.entrepriseClient ASC, c.nomClient ASC";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                clients.add(mapClient(rs));
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des clients : " + e.getMessage());
            e.printStackTrace();
        }
        return clients;
    }

    public List<Client> search(String query) {
        List<Client> clients = new ArrayList<>();
        String sql = "SELECT c.idClient, c.nomClient, c.prenomClient, c.entrepriseClient, COUNT(p.idProjet) as nombreProjets " +
                     "FROM Client c " +
                     "LEFT JOIN Projet p ON c.idClient = p.idClient " +
                     "WHERE LOWER(c.nomClient) LIKE ? " +
                     "OR LOWER(c.prenomClient) LIKE ? " +
                     "OR LOWER(c.entrepriseClient) LIKE ? " +
                     "GROUP BY c.idClient, c.nomClient, c.prenomClient, c.entrepriseClient " +
                     "ORDER BY c.entrepriseClient ASC, c.nomClient ASC";

        String searchTerm = "%" + query.toLowerCase() + "%";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, searchTerm);
            stmt.setString(2, searchTerm);
            stmt.setString(3, searchTerm);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    clients.add(mapClient(rs));
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la recherche des clients : " + e.getMessage());
            e.printStackTrace();
        }
        return clients;
    }

    @Override
    public boolean save(Client entity) {
        String sql = "INSERT INTO Client (idClient, nomClient, prenomClient, entrepriseClient) VALUES (?, ?, ?, ?)";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            if (entity.getIdClient() == null) {
                entity.setIdClient(UUID.randomUUID());
            }

            stmt.setString(1, entity.getIdClient().toString());
            stmt.setString(2, entity.getNomClient());

            if (entity.getPrenomClient() != null && !entity.getPrenomClient().trim().isEmpty()) {
                stmt.setString(3, entity.getPrenomClient());
            } else {
                stmt.setNull(3, Types.VARCHAR);
            }

            stmt.setString(4, entity.getEntrepriseClient());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'enregistrement du client : " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Client entity) {
        String sql = "UPDATE Client SET nomClient = ?, prenomClient = ?, entrepriseClient = ? WHERE idClient = ?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, entity.getNomClient());

            if (entity.getPrenomClient() != null && !entity.getPrenomClient().trim().isEmpty()) {
                stmt.setString(2, entity.getPrenomClient());
            } else {
                stmt.setNull(2, Types.VARCHAR);
            }

            stmt.setString(3, entity.getEntrepriseClient());
            stmt.setString(4, entity.getIdClient().toString());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erreur lors de la mise à jour du client : " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(UUID id) {
        String sql = "DELETE FROM Client WHERE idClient = ?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id.toString());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression du client : " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }
}