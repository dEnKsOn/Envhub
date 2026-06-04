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
import models.Projet;
import models.Serveur;
import models.TypeEnvironnement;
import models.Utilisateur;
import models.Technologie;
import models.VersionTechno;
import utils.DbConnection;

public class EnvironnementDAO implements IGenericDAO<Environnement, UUID> {

    // Requête de base centralisée pour éviter la duplication et faciliter la maintenance
    private static final String BASE_SELECT_QUERY = 
        "SELECT e.*, " +
        "s.adressIP, s.os, " +
        "u.nomUser AS nomCreateur, u.prenomUser AS prenomCreateur, " +
        "p.nomProjet, p.statutProjet, p.idClient " +
        "FROM Environnement e " +
        "LEFT JOIN Serveur s ON e.idServ = s.idServ " +
        "INNER JOIN Utilisateur u ON e.idCreator = u.idUser " + 
        "INNER JOIN Projet p ON e.idProjet = p.idProjet";       

    @Override
    public Environnement findById(UUID id) {
        String sql = BASE_SELECT_QUERY + " WHERE e.idEnv = ?";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id.toString());
            try (ResultSet rs = stmt.executeQuery()) {
                // Ajout de la connexion en paramètre pour charger les technologies
                if (rs.next()) return mapEnvironnement(rs, conn);
            }
        } catch (SQLException e) {
            System.err.println("Erreur (findById) Environnement : " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Environnement> findAll() {
        List<Environnement> environnements = new ArrayList<>();
        String sql = BASE_SELECT_QUERY + " ORDER BY e.dateCreation DESC"; 
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                environnements.add(mapEnvironnement(rs, conn));
            }
        } catch (SQLException e) {
            System.err.println("Erreur (findAll) Environnements : " + e.getMessage());
        }
        return environnements;
    }

    // --- FONCTIONNALITÉS MÉTIER ---
    public List<Environnement> findByClient(UUID idClient) {
        List<Environnement> environnements = new ArrayList<>();
        String sql = BASE_SELECT_QUERY + " WHERE p.idClient = ? ORDER BY p.nomProjet ASC, e.dateCreation DESC";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, idClient.toString());
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) environnements.add(mapEnvironnement(rs, conn));
            }
        } catch (SQLException e) {
            System.err.println("Erreur (findByClient) : " + e.getMessage());
        }
        return environnements;
    }

    public List<Environnement> findByProjet(UUID idProjet) {
        List<Environnement> environnements = new ArrayList<>();
        String sql = BASE_SELECT_QUERY + " WHERE e.idProjet = ? ORDER BY e.typeEnv ASC, e.dateCreation DESC";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, idProjet.toString());
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) environnements.add(mapEnvironnement(rs, conn));
            }
        } catch (SQLException e) {
            System.err.println("Erreur (findByProjet) : " + e.getMessage());
        }
        return environnements;
    }

    @Override
    public boolean save(Environnement entity) {
        String sql = "INSERT INTO Environnement (idEnv, typeEnv, nomBaseDeDonnees, urlFront, urlBack, notes, idProjet, idServ, idCreator) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, entity.getIdEnv().toString());
            stmt.setString(2, entity.getTypeEnv().name());
            stmt.setString(3, entity.getNomBaseDeDonnees());
            stmt.setString(4, entity.getUrlFront());
            stmt.setString(5, entity.getUrlBack());
            stmt.setString(6, entity.getNotes());
            stmt.setString(7, entity.getIdProjet().toString());

            // Gestion propre du LOCAL (Serveur NULL)
            if (entity.getIdServ() != null && !entity.getIdServ().toString().isEmpty()) {
                stmt.setString(8, entity.getIdServ().toString());
            } else {
                stmt.setNull(8, Types.CHAR);
            }
            
            stmt.setString(9, entity.getIdCreator().toString()); 
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erreur (save) Environnement : " + e.getMessage());
            return false;
        }
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

            if (entity.getIdServ() != null && !entity.getIdServ().toString().isEmpty()) {
                stmt.setString(7, entity.getIdServ().toString());
            } else {
                stmt.setNull(7, Types.CHAR);
            }
            stmt.setString(8, entity.getIdEnv().toString());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erreur (update) Environnement : " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(UUID id) {
        String sql = "DELETE FROM Environnement WHERE idEnv = ?";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id.toString());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erreur (delete) Environnement : " + e.getMessage());
            return false;
        }
    }

    /**
     * MAPPING PRINCIPAL : Hydrate l'objet Environnement depuis le ResultSet
     */
    private Environnement mapEnvironnement(ResultSet rs, Connection conn) throws SQLException {
        Environnement environnement = new Environnement();
        
        environnement.setIdEnv(UUID.fromString(rs.getString("idEnv")));
        environnement.setTypeEnv(TypeEnvironnement.valueOf(rs.getString("typeEnv")));
        environnement.setNomBaseDeDonnees(rs.getString("nomBaseDeDonnees"));
        environnement.setUrlFront(rs.getString("urlFront"));
        environnement.setUrlBack(rs.getString("urlBack"));
        environnement.setNotes(rs.getString("notes"));
        environnement.setIdProjet(UUID.fromString(rs.getString("idProjet")));
        environnement.setIdCreator(UUID.fromString(rs.getString("idCreator")));
        
        if (rs.getTimestamp("dateCreation") != null) {
            environnement.setDateCreation(new java.util.Date(rs.getTimestamp("dateCreation").getTime()));
        }

        String idServ = rs.getString("idServ");
        if (idServ != null) {
            environnement.setIdServ(UUID.fromString(idServ));
            Serveur serveur = new Serveur();
            serveur.setIdServ(UUID.fromString(idServ)); 
            serveur.setAdressIP(rs.getString("adressIP"));
            serveur.setOs(rs.getString("os"));
            environnement.setServeur(serveur);
        }
        
        Projet projet = new Projet();
        projet.setIdProjet(environnement.getIdProjet());
        projet.setNomProjet(rs.getString("nomProjet")); 
        projet.setIdClient(UUID.fromString(rs.getString("idClient")));
        environnement.setProjet(projet);
        
        Utilisateur createur = new Utilisateur();
        createur.setIdUser(environnement.getIdCreator()); 
        createur.setNomUser(rs.getString("nomCreateur"));
        createur.setPrenomUser(rs.getString("prenomCreateur"));
        environnement.setCreateur(createur);

        // HYDRATATION DES TECHNOLOGIES
        loadVersions(environnement, conn);

        return environnement;
    }

    /**
     * Récupère et injecte la liste des technologies/versions pour un environnement
     * Adapté strictement aux entités VersionTechno et Technologie.
     */
    private void loadVersions(Environnement env, Connection conn) {
        List<VersionTechno> versions = new ArrayList<>();
        
        String sql = "SELECT vt.version, t.idTechno, t.nomTechno " +
                     "FROM VersionTechno vt " +
                     "INNER JOIN Technologie t ON vt.idTechno = t.idTechno " +
                     "WHERE vt.idEnv = ?";
                     
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, env.getIdEnv().toString());
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Technologie tech = new Technologie();
                    tech.setIdTechno(UUID.fromString(rs.getString("idTechno")));
                    tech.setNomTechno(rs.getString("nomTechno"));
                    
                    VersionTechno vt = new VersionTechno();
                    vt.setTechnologie(tech);
                    vt.setVersion(rs.getString("version"));
                    
                    versions.add(vt);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors du chargement des technologies associées : " + e.getMessage());
        }
        
        env.setVersions(versions);
    }

    /**
     * Récupère tous les environnements liés aux projets d'un utilisateur spécifique.
     * Idéal pour le tableau de bord "Mes Environnements" du Développeur.
     */
    public List<Environnement> findByUtilisateur(UUID idUser) {
        List<Environnement> environnements = new ArrayList<>();
        // On récupère l'environnement, le nom du projet associé, et les infos du serveur
        String sql = "SELECT e.*, p.nomProjet, s.nomServeur, s.adressIP "
                   + "FROM Environnement e "
                   + "JOIN Projet p ON e.idProjet = p.idProjet "
                   + "JOIN Affectation a ON p.idProjet = a.idProjet "
                   + "LEFT JOIN Serveur s ON e.idServ = s.idServ "
                   + "WHERE a.idUser = ? "
                   + "ORDER BY p.nomProjet ASC, e.typeEnv ASC";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, idUser.toString());
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Environnement env = mapEnvironnement(rs, conn); 
                    
                    // On enrichit manuellement le nom du projet car on l'a récupéré dans le SELECT
                    Projet p = env.getProjet();
                    if (p == null) { p = new Projet(); }
                    p.setNomProjet(rs.getString("nomProjet"));
                    env.setProjet(p);
                    
                    environnements.add(env);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des environnements du dev : " + e.getMessage());
        }
        return environnements;
    }
}