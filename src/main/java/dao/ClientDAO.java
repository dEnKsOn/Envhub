package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import models.Client;
import utils.DbConnection;

public class ClientDAO implements IGenericDAO<Client, UUID> {

    @Override
    public Client findById(UUID id) {
        String sql = "SELECT * FROM Client WHERE idClient = ?";

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
        String sql = "SELECT * FROM Client ORDER BY nomClient ASC";

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

    @Override
    public boolean save(Client entity) {
        String sql = "INSERT INTO Client (idClient, nomClient, prenomClient, entrepriseClient) VALUES (?, ?, ?, ?)";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, entity.getIdClient().toString());
            stmt.setString(2, entity.getNomClient());

            if (entity.getPrenomClient() != null) {
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

            if (entity.getPrenomClient() != null) {
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

    private Client mapClient(ResultSet rs) throws SQLException {
        Client client = new Client();
        client.setIdClient(UUID.fromString(rs.getString("idClient")));
        client.setNomClient(rs.getString("nomClient"));
        client.setPrenomClient(rs.getString("prenomClient"));
        client.setEntrepriseClient(rs.getString("entrepriseClient"));
        return client;
    }
}
