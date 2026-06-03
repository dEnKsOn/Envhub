package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import models.Affectation;
import models.Profil;
import models.Projet;
import models.RoleProjet;
import models.StatutProjet;
import models.Utilisateur;
import utils.DbConnection;

public class AffectationDAO {

    public List<Affectation> findByProjet(UUID idProjet) {
        List<Affectation> affectations = new ArrayList<>();
        String sql = "SELECT a.idProjet, a.idUser, a.roleProjet, "
                + "u.nomUser, u.prenomUser, u.email, u.idProfil, p.libelle "
                + "FROM Affectation a "
                + "JOIN Utilisateur u ON a.idUser = u.idUser "
                + "JOIN Profil p ON u.idProfil = p.idProfil "
                + "WHERE a.idProjet = ? "
                + "ORDER BY FIELD(a.roleProjet, 'CHEF_PROJET', 'DEVELOPPEUR'), u.prenomUser, u.nomUser";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, idProjet.toString());
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    affectations.add(mapAffectation(rs));
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des affectations : " + e.getMessage());
            e.printStackTrace();
        }
        return affectations;
    }

    /**
     * =================================================================================
     * NOUVELLE MÉTHODE POUR L'ESPACE DÉVELOPPEUR
     * Récupère toutes les affectations d'un utilisateur avec les détails du projet
     * =================================================================================
     */
    public List<Affectation> findByUtilisateur(UUID idUser) {
        List<Affectation> affectations = new ArrayList<>();
        String sql = "SELECT a.idProjet, a.idUser, a.roleProjet, "
                   + "p.nomProjet, p.descriptionTech, p.dateLancement, p.statutProjet, p.pourcentageAvancement, "
                   + "u.nomUser, u.prenomUser, u.email, u.idProfil, prof.libelle "
                   + "FROM Affectation a "
                   + "JOIN Projet p ON a.idProjet = p.idProjet "
                   + "JOIN Utilisateur u ON a.idUser = u.idUser "
                   + "JOIN Profil prof ON u.idProfil = prof.idProfil "
                   + "WHERE a.idUser = ? "
                   + "ORDER BY p.dateLancement DESC";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, idUser.toString());
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Affectation affectation = mapAffectation(rs);
                    
                    // On enrichit l'objet Projet avec les données de la jointure
                    Projet projet = affectation.getProjet();
                    projet.setNomProjet(rs.getString("nomProjet"));
                    projet.setDescriptionTech(rs.getString("descriptionTech"));
                    projet.setDateLancement(rs.getDate("dateLancement"));
                    projet.setStatutProjet(StatutProjet.valueOf(rs.getString("statutProjet")));
                    projet.setPourcentageAvancement(rs.getInt("pourcentageAvancement"));
                    
                    affectations.add(affectation);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des affectations de l'utilisateur : " + e.getMessage());
            e.printStackTrace();
        }
        return affectations;
    }

    public RoleProjet findRoleOnProjet(UUID idProjet, UUID idUser) {
        String sql = "SELECT roleProjet FROM Affectation WHERE idProjet = ? AND idUser = ?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, idProjet.toString());
            stmt.setString(2, idUser.toString());
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return RoleProjet.valueOf(rs.getString("roleProjet"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération du rôle projet : " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public boolean exists(UUID idProjet, UUID idUser) {
        String sql = "SELECT 1 FROM Affectation WHERE idProjet = ? AND idUser = ?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, idProjet.toString());
            stmt.setString(2, idUser.toString());
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la vérification d'affectation : " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    public boolean save(Affectation affectation) throws SQLException {
        String sql = "INSERT INTO Affectation (idProjet, idUser, roleProjet) VALUES (?, ?, ?)";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, affectation.getProjet().getIdProjet().toString());
            stmt.setString(2, affectation.getUtilisateur().getIdUser().toString());
            stmt.setString(3, affectation.getRoleProjet().name());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean delete(UUID idProjet, UUID idUser) {
        String sql = "DELETE FROM Affectation WHERE idProjet = ? AND idUser = ?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, idProjet.toString());
            stmt.setString(2, idUser.toString());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression de l'affectation : " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    private Affectation mapAffectation(ResultSet rs) throws SQLException {
        Affectation affectation = new Affectation();
        affectation.setRoleProjet(RoleProjet.valueOf(rs.getString("roleProjet")));

        Projet projet = new Projet();
        projet.setIdProjet(UUID.fromString(rs.getString("idProjet")));
        affectation.setProjet(projet);

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setIdUser(UUID.fromString(rs.getString("idUser")));
        utilisateur.setNomUser(rs.getString("nomUser"));
        utilisateur.setPrenomUser(rs.getString("prenomUser"));
        utilisateur.setEmail(rs.getString("email"));

        try {
            Profil profil = new Profil();
            profil.setIdProfil(rs.getInt("idProfil"));
            profil.setLibelle(rs.getString("libelle"));
            utilisateur.setProfil(profil);
        } catch (SQLException ex) {
            // Si la requête ne joint pas la table Profil, on l'ignore silencieusement
        }

        affectation.setUtilisateur(utilisateur);
        return affectation;
    }
}