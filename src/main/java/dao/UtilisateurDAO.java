package dao;

import models.Profil;
import models.Utilisateur;
import utils.DbConnection;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UtilisateurDAO implements IGenericDAO<Utilisateur, UUID> {

    public Utilisateur authenticate(String email, String passwordSaisi) {
        // CORRECTION ICI : Ajout de u.genre dans le SELECT
        String query = "SELECT u.idUser, u.nomUser, u.prenomUser, u.genre, u.email, u.password, u.idProfil, p.libelle " +
                "FROM Utilisateur u " +
                "JOIN Profil p ON u.idProfil = p.idProfil " +
                "WHERE u.email = ?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, email);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String storedHash = rs.getString("password");

                    if (BCrypt.checkpw(passwordSaisi, storedHash)) {
                        Utilisateur user = mapUtilisateur(rs);
                        user.setPassword(null);
                        return user;
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'authentification : " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Utilisateur findById(UUID id) {
        String sql = "SELECT u.*, p.libelle FROM Utilisateur u " +
                     "JOIN Profil p ON u.idProfil = p.idProfil " +
                     "WHERE u.idUser = ?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id.toString());

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Utilisateur user = mapUtilisateur(rs);
                    user.setPassword(null);
                    return user;
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération de l'utilisateur : " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Utilisateur> findAll() {
        List<Utilisateur> utilisateurs = new ArrayList<>();
        String sql = "SELECT u.*, p.libelle FROM Utilisateur u " +
                     "JOIN Profil p ON u.idProfil = p.idProfil " +
                     "ORDER BY u.prenomUser, u.nomUser";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Utilisateur user = mapUtilisateur(rs);
                user.setPassword(null);
                utilisateurs.add(user);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des utilisateurs : " + e.getMessage());
            e.printStackTrace();
        }
        return utilisateurs;
    }

    public List<Utilisateur> search(String query) {
        List<Utilisateur> utilisateurs = new ArrayList<>();
        String sql = "SELECT u.*, p.libelle FROM Utilisateur u " +
                     "JOIN Profil p ON u.idProfil = p.idProfil " +
                     "WHERE LOWER(u.nomUser) LIKE ? " +
                     "OR LOWER(u.prenomUser) LIKE ? " +
                     "OR LOWER(u.email) LIKE ? " +
                     "ORDER BY u.prenomUser, u.nomUser";

        String searchTerm = "%" + query.toLowerCase() + "%";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, searchTerm);
            stmt.setString(2, searchTerm);
            stmt.setString(3, searchTerm);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Utilisateur user = mapUtilisateur(rs);
                    user.setPassword(null);
                    utilisateurs.add(user);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la recherche des utilisateurs : " + e.getMessage());
            e.printStackTrace();
        }
        return utilisateurs;
    }

    @Override
    public boolean save(Utilisateur entity) {
        String sql = "INSERT INTO Utilisateur (idUser, nomUser, prenomUser, genre, email, password, idProfil) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            if (entity.getIdUser() == null) {
                entity.setIdUser(UUID.randomUUID());
            }

            stmt.setString(1, entity.getIdUser().toString());
            stmt.setString(2, entity.getNomUser());
            stmt.setString(3, entity.getPrenomUser());
            stmt.setString(4, entity.getGenre());
            stmt.setString(5, entity.getEmail());
            stmt.setString(6, entity.getPassword());
            stmt.setInt(7, entity.getProfil().getIdProfil());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'enregistrement de l'utilisateur : " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Utilisateur entity) {
        boolean updatePassword = entity.getPassword() != null && !entity.getPassword().isEmpty();
        String sql = updatePassword
                ? "UPDATE Utilisateur SET nomUser = ?, prenomUser = ?, genre = ?, email = ?, password = ?, idProfil = ? WHERE idUser = ?"
                : "UPDATE Utilisateur SET nomUser = ?, prenomUser = ?, genre = ?, email = ?, idProfil = ? WHERE idUser = ?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, entity.getNomUser());
            stmt.setString(2, entity.getPrenomUser());
            stmt.setString(3, entity.getGenre());
            stmt.setString(4, entity.getEmail());

            if (updatePassword) {
                stmt.setString(5, entity.getPassword());
                stmt.setInt(6, entity.getProfil().getIdProfil());
                stmt.setString(7, entity.getIdUser().toString());
            } else {
                stmt.setInt(5, entity.getProfil().getIdProfil());
                stmt.setString(6, entity.getIdUser().toString());
            }

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erreur lors de la mise à jour de l'utilisateur : " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(UUID id) {
        String sql = "DELETE FROM Utilisateur WHERE idUser = ?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id.toString());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression de l'utilisateur : " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    private Utilisateur mapUtilisateur(ResultSet rs) throws SQLException {
        Utilisateur user = new Utilisateur();
        user.setIdUser(UUID.fromString(rs.getString("idUser")));
        user.setNomUser(rs.getString("nomUser"));
        user.setPrenomUser(rs.getString("prenomUser"));
        user.setGenre(rs.getString("genre"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));

        Profil profil = new Profil();
        profil.setIdProfil(rs.getInt("idProfil"));
        profil.setLibelle(rs.getString("libelle"));
        user.setProfil(profil);

        return user;
    }
}