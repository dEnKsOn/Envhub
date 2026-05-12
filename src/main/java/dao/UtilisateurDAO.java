package dao;

import models.Profil;
import models.Utilisateur;
import utils.DbConnection;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class UtilisateurDAO {

    public Utilisateur authenticate(String email, String passwordSaisi) {
        String query = "SELECT u.idUser, u.nomUser, u.prenomUser, u.email, u.password, u.idProfil, p.libelle " +
                "FROM Utilisateur u " +
                "JOIN Profil p ON u.idProfil = p.idProfil " +
                "WHERE u.email = ?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, email);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String storedHash = rs.getString("password");

                    // Vérification sécurisée du mot de passe
                    if (BCrypt.checkpw(passwordSaisi, storedHash)) {
                        Utilisateur user = new Utilisateur();
                        user.setIdUser(UUID.fromString(rs.getString("idUser")));
                        user.setNomUser(rs.getString("nomUser"));
                        user.setPrenomUser(rs.getString("prenomUser"));
                        user.setEmail(rs.getString("email"));
                        
                        Profil profil = new Profil();
                        profil.setIdProfil(rs.getInt("idProfil"));
                        profil.setLibelle(rs.getString("libelle"));
                        user.setProfil(profil);

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
}