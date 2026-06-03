# Documentation - Modèles et DAOs - EnvHub

## Table des matières
1. [Modèles (Models)](#modèles-models)
2. [Data Access Objects (DAOs)](#data-access-objects-daos)
3. [Architecture](#architecture)

---

## Modèles (Models)

Les modèles représentent les entités métier de l'application EnvHub. Ils sont situés dans le package `models`.

### 1. **Utilisateur**
**Fichier:** `Utilisateur.java`

**Description:** Représente un utilisateur de l'application.

**Attributs:**
- `idUser` (UUID) - Identifiant unique
- `nomUser` (String) - Nom de l'utilisateur
- `prenomUser` (String) - Prénom de l'utilisateur
- `email` (String) - Adresse email
- `genre` (String) - Genre de l'utilisateur
- `password` (String) - Mot de passe hashé (BCrypt)
- `profil` (Profil) - Profil associé (référence à Profil)

**Méthodes principales:**
- Getters/Setters pour tous les attributs

---

### 2. **Projet**
**Fichier:** `Projet.java`

**Description:** Représente un projet dans l'application.

**Attributs:**
- `idProjet` (UUID) - Identifiant unique
- `idClient` (UUID) - Référence au client
- `nomProjet` (String) - Nom du projet
- `descriptionTech` (String) - Description technique
- `dateLancement` (Date) - Date de lancement
- `dateLivraisonEstimee` (Date) - Date de livraison estimée
- `statutProjet` (StatutProjet) - Enum du statut
- `pourcentageAvancement` (int) - Pourcentage d'avancement
- `nomClient` (String) - Nom du client (dénormalisation)
- `entrepriseClient` (String) - Entreprise du client
- `nombreEnvironnements` (int) - Nombre d'environnements
- `environnements` (List<Environnement>) - Liste des environnements
- `environnement` (Environnement) - Environnement associé

**Méthodes principales:**
- Getters/Setters pour tous les attributs

---

### 3. **Environnement**
**Fichier:** `Environnement.java`

**Description:** Représente un environnement pour un projet (LOCAL, DÉVELOPPEMENT, STAGING, PRODUCTION).

**Attributs:**
- `idEnv` (UUID) - Identifiant unique
- `typeEnv` (TypeEnvironnement) - Type d'environnement (Enum)
- `nomBaseDeDonnees` (String) - Nom de la base de données
- `urlFront` (String) - URL du frontend
- `urlBack` (String) - URL du backend
- `notes` (String) - Notes supplémentaires
- `dateCreation` (Date) - Date de création
- `idCreator` (UUID) - ID du créateur
- `idProjet` (UUID) - ID du projet associé
- `idServ` (UUID) - ID du serveur associé
- `serveur` (Serveur) - Référence à l'objet Serveur
- `projet` (Projet) - Référence à l'objet Projet
- `createur` (Utilisateur) - Référence à l'utilisateur créateur

**Méthodes principales:**
- Getters/Setters pour tous les attributs

---

### 4. **Client**
**Fichier:** `Client.java`

**Description:** Représente un client de l'application.

**Attributs:**
- `idClient` (UUID) - Identifiant unique
- `nomClient` (String) - Nom du client
- `prenomClient` (String) - Prénom du client
- `entrepriseClient` (String) - Entreprise du client
- `emailClient` (String) - Email du client
- `nombreProjets` (int) - Nombre de projets associés

**Méthodes principales:**
- Getters/Setters pour tous les attributs

---

### 5. **Serveur**
**Fichier:** `Serveur.java`

**Description:** Représente un serveur physique ou virtuel.

**Attributs:**
- `idServ` (UUID) - Identifiant unique
- `nomServeur` (String) - Nom du serveur
- `adresseIP` (String) - Adresse IP
- `systemeExploitation` (String) - OS du serveur
- `ressourcesDisponibles` (String) - Ressources disponibles
- `etatServeur` (String) - État du serveur

---

### 6. **Technologie**
**Fichier:** `Technologie.java`

**Description:** Représente une technologie utilisée dans les projets.

**Attributs:**
- `idTechno` (UUID) - Identifiant unique
- `nomTechno` (String) - Nom de la technologie
- `typeTechno` (TypeTechno) - Type de technologie (Enum)
- `descriptionTechno` (String) - Description

---

### 7. **VersionTechno**
**Fichier:** `VersionTechno.java`

**Description:** Représente une version spécifique d'une technologie dans un environnement.

**Attributs:**
- `idVersionTechno` (UUID) - Identifiant unique
- `technologie` (Technologie) - Référence à la technologie
- `environnement` (Environnement) - Référence à l'environnement
- `version` (String) - Numéro de version

---

### 8. **Affectation**
**Fichier:** `Affectation.java`

**Description:** Représente l'affectation d'un utilisateur à un projet avec un rôle spécifique.

**Attributs:**
- `idAffectation` (UUID) - Identifiant unique
- `idUser` (UUID) - ID de l'utilisateur
- `idProjet` (UUID) - ID du projet
- `role` (RoleProjet) - Rôle dans le projet
- `dateAffectation` (Date) - Date d'affectation
- `utilisateur` (Utilisateur) - Référence à l'utilisateur
- `projet` (Projet) - Référence au projet

---

### 9. **DemandeProjet**
**Fichier:** `DemandeProjet.java`

**Description:** Représente une demande de création de nouveau projet.

**Attributs:**
- `idDemande` (UUID) - Identifiant unique
- `titreProjet` (String) - Titre de la demande
- `descriptionDemande` (String) - Description de la demande
- `dateDemande` (Date) - Date de la demande
- `statut` (StatutDemande) - Statut de la demande
- `idDemandeur` (UUID) - ID de celui qui demande
- `demandeur` (Utilisateur) - Référence au demandeur

---

### 10. **Profil**
**Fichier:** `Profil.java`

**Description:** Représente un profil/rôle utilisateur dans l'application.

**Attributs:**
- `idProfil` (int) - Identifiant unique
- `libelle` (String) - Libellé du profil (ADMIN, DEV, USER, etc.)

---

### 11. **RoleProjet**
**Fichier:** `RoleProjet.java`

**Description:** Énumération des rôles possibles dans un projet.

**Valeurs:**
- `CHEF_PROJET` - Chef de projet
- `DEVELOPPEUR` - Développeur
- `TESTEUR` - Testeur
- `DEVOPS` - DevOps
- `OBSERVATEUR` - Observateur

---

### 12. **Affectation (Relation)**
**Fichier:** `Affectation.java`

**Description:** Représente l'affectation d'un utilisateur à un projet avec un rôle.

---

### 13. **TypeEnvironnement**
**Fichier:** `TypeEnvironnement.java`

**Description:** Énumération des types d'environnement possibles.

**Valeurs:**
- `LOCAL` - Environnement local
- `DEVELOPPEMENT` - Environnement de développement
- `STAGING` - Environnement de staging
- `PRODUCTION` - Environnement de production

---

### 14. **TypeTechno**
**Fichier:** `TypeTechno.java`

**Description:** Énumération des types de technologies.

**Valeurs:**
- `LANGAGE` - Langage de programmation
- `FRAMEWORK` - Framework
- `LIBRAIRIE` - Librairie
- `BASE_DONNEES` - Base de données
- `OUTIL` - Outil

---

### 15. **StatutProjet**
**Fichier:** `StatutProjet.java`

**Description:** Énumération des statuts possibles pour un projet.

**Valeurs:**
- `EN_ATTENTE` - En attente
- `EN_COURS` - En cours
- `SUSPENDU` - Suspendu
- `TERMINE` - Terminé
- `ANNULE` - Annulé

---

### 16. **StatutDemande**
**Fichier:** `StatutDemande.java`

**Description:** Énumération des statuts possibles pour une demande.

**Valeurs:**
- `EN_ATTENTE` - En attente
- `APPROUVEE` - Approuvée
- `REJETEE` - Rejetée
- `EN_COURS` - En cours

---

### 17. **ActiviteDTO**
**Fichier:** `ActiviteDTO.java`

**Description:** Data Transfer Object pour les activités (logs d'utilisation).

**Attributs:**
- `idActivite` (UUID) - Identifiant unique
- `idUser` (UUID) - ID de l'utilisateur
- `action` (String) - Action effectuée
- `dateActivite` (Date) - Date et heure de l'activité
- `details` (String) - Détails supplémentaires

---

## Data Access Objects (DAOs)

Les DAOs gèrent l'accès aux données dans la base de données. Ils implémentent le pattern DAO et hérient de l'interface générique `IGenericDAO<T, ID>`.

### Interface Générique

#### **IGenericDAO<T, ID>**
**Fichier:** `IGenericDAO.java`

**Description:** Interface générique définissant les opérations CRUD standards pour tous les DAOs.

**Code Source:**
```java
package dao;

import java.util.List;

// T = L'entité (ex: Technologie), ID = Le type de la clé primaire (ex: Integer)
public interface IGenericDAO<T, ID> {
    
    /**
     * Trouve une entité par son ID unique
     * @param id L'identifiant unique de l'entité
     * @return L'entité trouvée ou null
     */
    T findById(ID id);
    
    /**
     * Récupère toutes les entités du type T
     * @return List contenant toutes les entités
     */
    List<T> findAll();
    
    /**
     * Crée une nouvelle entité en base de données
     * @param entity L'entité à créer
     * @return true si la création a réussi, false sinon
     */
    boolean save(T entity);
    
    /**
     * Met à jour une entité existante en base de données
     * @param entity L'entité avec les modifications
     * @return true si la mise à jour a réussi, false sinon
     */
    boolean update(T entity);
    
    /**
     * Supprime une entité par son ID
     * @param id L'identifiant de l'entité à supprimer
     * @return true si la suppression a réussi, false sinon
     */
    boolean delete(ID id);
}
```

**Utilisation en héritage:**
```java
public class UtilisateurDAO implements IGenericDAO<Utilisateur, UUID> {
    // Implémentation des 5 méthodes CRUD
}

public class ProfilDAO implements IGenericDAO<Profil, Integer> {
    // Implémentation des 5 méthodes CRUD
}
```

---

### DAOs Implémentés

#### 1. **UtilisateurDAO**
**Fichier:** `UtilisateurDAO.java`

**Implémente:** `IGenericDAO<Utilisateur, UUID>`

**Code Source:**
```java
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
        }
        return utilisateurs;
    }

    public List<Utilisateur> search(String query) {
        List<Utilisateur> utilisateurs = new ArrayList<>();
        String sql = "SELECT u.*, p.libelle FROM Utilisateur u " +
                     "JOIN Profil p ON u.idProfil = p.idProfil " +
                     "WHERE LOWER(u.nomUser) LIKE ? OR LOWER(u.prenomUser) LIKE ? OR LOWER(u.email) LIKE ? " +
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
```

---

#### 2. **ProfilDAO**
**Fichier:** `ProfilDAO.java`

**Implémente:** `IGenericDAO<Profil, Integer>`

**Code Source:**
```java
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Profil;
import utils.DbConnection;

public class ProfilDAO implements IGenericDAO<Profil, Integer> {

    @Override
    public Profil findById(Integer id) {
        String sql = "SELECT * FROM Profil WHERE idProfil = ?";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapProfil(rs);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération du profil : " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Profil> findAll() {
        List<Profil> profils = new ArrayList<>();
        String sql = "SELECT * FROM Profil ORDER BY libelle ASC";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                profils.add(mapProfil(rs));
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des profils : " + e.getMessage());
        }
        return profils;
    }

    @Override
    public boolean save(Profil entity) {
        String sql = "INSERT INTO Profil (libelle) VALUES (?)";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, entity.getLibelle());
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        entity.setIdProfil(generatedKeys.getInt(1));
                    }
                }
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'enregistrement du profil : " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(Profil entity) {
        String sql = "UPDATE Profil SET libelle = ? WHERE idProfil = ?";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, entity.getLibelle());
            stmt.setInt(2, entity.getIdProfil());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erreur lors de la mise à jour du profil : " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        String sql = "DELETE FROM Profil WHERE idProfil = ?";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression du profil : " + e.getMessage());
        }
        return false;
    }

    private Profil mapProfil(ResultSet rs) throws SQLException {
        Profil profil = new Profil();
        profil.setIdProfil(rs.getInt("idProfil"));
        profil.setLibelle(rs.getString("libelle"));
        return profil;
    }
}
```

---

#### 3. **ProjetDAO**
**Fichier:** `ProjetDAO.java`

**Implémente:** `IGenericDAO<Projet, UUID>`

**Code Source (Résumé - Fichier complet disponible dans le projet):**
```java
// Utilise pattern Builder pour les requêtes complexes
// Méthodes principales:
// - findById(UUID id) - Récupère un projet avec les stats
// - findAll() - Récupère tous les projets triés
// - search(String query) - Recherche par nom ou entreprise
// - save(Projet entity) - Crée un nouveau projet
// - update(Projet entity) - Met à jour un projet
// - delete(UUID id) - Supprime un projet
// - evaluerProgression(UUID idProjet) - Évalue la progression automatiquement

// MOTEUR DE PROGRESSION AUTOMATISÉ (EVENT-DRIVEN):
// Recalcule le pourcentage d'avancement basé sur:
// - Présence d'un chef de projet (+10%)
// - Présence de développeurs (+10%)
// - Présence d'environnements LOCAL/DEV (+20%)
// - Présence d'environnement STAGING (+20%)
// - Nombre de technologies configurées (+15%)
// - Présence d'environnement PRODUCTION = 100%
```

---

#### 4. **ClientDAO**
**Fichier:** `ClientDAO.java`

**Implémente:** `IGenericDAO<Client, UUID>`

**Code Source (Résumé):**
```java
// Gère les clients avec count des projets associés
// Méthodes principales:
// - findById(UUID id) - Récupère un client avec count projets
// - findAll() - Récupère tous les clients triés par entreprise
// - search(String query) - Recherche par nom, prénom, entreprise, email
// - save(Client entity) - Crée un nouveau client
// - update(Client entity) - Met à jour un client
// - delete(UUID id) - Supprime un client

// Utilise LEFT JOIN sur Projet pour compter les projets
// Agrégation avec GROUP BY pour la performance
```

---

#### 5. **EnvironnementDAO**
**Fichier:** `EnvironnementDAO.java`

**Implémente:** `IGenericDAO<Environnement, UUID>`

**Code Source (Résumé):**
```java
// Gère les environnements avec jointures optimisées
// Base de requête centralisée pour éviter duplication:
// LEFT JOIN Serveur, INNER JOIN Utilisateur, INNER JOIN Projet

// Méthodes principales:
// - findById(UUID id) - Récupère un environnement
// - findAll() - Récupère tous les environnements
// - findByProjet(UUID idProjet) - Par projet
// - findByClient(UUID idClient) - Tous les envs du client (via ses projets)
// - findByUtilisateur(UUID idUser) - Mes environnements (dev)
// - save(Environnement entity) - Crée
// - update(Environnement entity) - Met à jour
// - delete(UUID id) - Supprime

// Gestion intelligente du LOCAL (Serveur NULL)
// Enrichissement automatique des objets Serveur, Projet, Utilisateur
```

---

#### 6. **ServeurDAO**
**Fichier:** `ServeurDAO.java`

**Implémente:** `IGenericDAO<Serveur, UUID>`

**Code Source (Résumé):**
```java
// Gère les serveurs physiques/virtuels
// Méthodes principales:
// - findById(UUID id) - Récupère un serveur
// - findAll() - Récupère tous les serveurs
// - search(String query) - Recherche par IP, OS, fournisseur
// - save(Serveur entity) - Crée
// - update(Serveur entity) - Met à jour
// - delete(UUID id) - Supprime
// - isIpExists(String ip, UUID excludeId) - Validation unicité IP

// Comptes les environnements deployés sur chaque serveur
// Gestion des ressources: CPU cores, RAM GB
// Fournisseur du serveur (AWS, Azure, On-Premise, etc.)
```

---

#### 7. **TechnologieDAO**
**Fichier:** `TechnologieDAO.java`

**Implémente:** `IGenericDAO<Technologie, UUID>`

**Code Source (Résumé):**
```java
// Gère le catalogue des technologies
// Méthodes principales:
// - findById(UUID id) - Récupère une technologie
// - findAll() - Récupère toutes les technologies
// - search(String query) - Recherche par nom ou type
// - save(Technologie entity) - Crée
// - update(Technologie entity) - Met à jour
// - delete(UUID id) - Supprime
// - isNomTechnoExists(String nomTechno, UUID excludeId) - Validation unicité

// Compte le nombre d'utilisations (dans VersionTechno)
// Types: LANGAGE, FRAMEWORK, LIBRAIRIE, BASE_DONNEES, OUTIL
```

---

#### 8. **VersionTechnoDAO**
**Fichier:** `VersionTechnoDAO.java`

**Fonctionnalité:** Gère les versions de technologies dans les environnements.

**Code Source:**
```java
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import models.Environnement;
import models.Technologie;
import models.VersionTechno;
import utils.DbConnection;

public class VersionTechnoDAO {

    public VersionTechno findById(UUID idEnv, UUID idTechno) {
        String sql = "SELECT * FROM VersionTechno WHERE idEnv = ? AND idTechno = ?";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, idEnv.toString());
            stmt.setString(2, idTechno.toString());
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapVersionTechno(rs);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération de la version techno : " + e.getMessage());
        }
        return null;
    }

    public List<VersionTechno> findByEnvironnement(UUID idEnv) {
        List<VersionTechno> result = new ArrayList<>();
        String sql = "SELECT * FROM VersionTechno WHERE idEnv = ?";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, idEnv.toString());
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    result.add(mapVersionTechno(rs));
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des versions techno : " + e.getMessage());
        }
        return result;
    }

    public boolean save(VersionTechno vt) {
        return save(vt.getEnvironnement().getIdEnv(), vt.getTechnologie().getIdTechno(), vt.getVersion());
    }

    public boolean save(UUID idEnv, UUID idTechno, String version) {
        String sql = "INSERT INTO VersionTechno (idEnv, idTechno, version) VALUES (?, ?, ?)";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, idEnv.toString());
            stmt.setString(2, idTechno.toString());
            stmt.setString(3, version != null ? version : "");
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'enregistrement de la version techno : " + e.getMessage());
        }
        return false;
    }

    public boolean delete(UUID idEnv, UUID idTechno) {
        String sql = "DELETE FROM VersionTechno WHERE idEnv = ? AND idTechno = ?";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, idEnv.toString());
            stmt.setString(2, idTechno.toString());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression de la version techno : " + e.getMessage());
        }
        return false;
    }

    private VersionTechno mapVersionTechno(ResultSet rs) throws SQLException {
        VersionTechno versionTechno = new VersionTechno();
        versionTechno.setVersion(rs.getString("version"));

        Environnement environnement = new Environnement();
        environnement.setIdEnv(UUID.fromString(rs.getString("idEnv")));
        versionTechno.setEnvironnement(environnement);

        Technologie technologie = new Technologie();
        technologie.setIdTechno(UUID.fromString(rs.getString("idTechno")));
        versionTechno.setTechnologie(technologie);

        return versionTechno;
    }
}
```

---

#### 9. **AffectationDAO**
**Fichier:** `AffectationDAO.java`

**Code Source:**
```java
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
        String sql = "SELECT a.idProjet, a.idUser, a.roleProjet, " +
                "u.nomUser, u.prenomUser, u.email, u.idProfil, p.libelle " +
                "FROM Affectation a " +
                "JOIN Utilisateur u ON a.idUser = u.idUser " +
                "JOIN Profil p ON u.idProfil = p.idProfil " +
                "WHERE a.idProjet = ? " +
                "ORDER BY FIELD(a.roleProjet, 'CHEF_PROJET', 'DEVELOPPEUR'), u.prenomUser, u.nomUser";
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
        }
        return affectations;
    }

    public List<Affectation> findByUtilisateur(UUID idUser) {
        List<Affectation> affectations = new ArrayList<>();
        String sql = "SELECT a.idProjet, a.idUser, a.roleProjet, " +
                   "p.nomProjet, p.descriptionTech, p.dateLancement, p.statutProjet, p.pourcentageAvancement, " +
                   "u.nomUser, u.prenomUser, u.email, u.idProfil, prof.libelle " +
                   "FROM Affectation a " +
                   "JOIN Projet p ON a.idProjet = p.idProjet " +
                   "JOIN Utilisateur u ON a.idUser = u.idUser " +
                   "JOIN Profil prof ON u.idProfil = prof.idProfil " +
                   "WHERE a.idUser = ? " +
                   "ORDER BY p.dateLancement DESC";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, idUser.toString());
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Affectation affectation = mapAffectation(rs);
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
            // Si la requête ne joint pas la table Profil, on l'ignore
        }

        affectation.setUtilisateur(utilisateur);
        return affectation;
    }
}
```

---

#### 10. **DemandeProjetDAO**
**Fichier:** `DemandeProjetDAO.java`

**Implémente:** `IGenericDAO<DemandeProjet, UUID>`

**Code Source (Résumé):**
```java
// Gère les demandes de création de projets
// Méthodes principales:
// - findById(UUID id) - Récupère une demande
// - findAll() - Récupère toutes les demandes
// - findByStatut(StatutDemande statut) - Filtre par statut
// - countByStatut(StatutDemande statut) - Compte les demandes par statut (KPI)
// - save(DemandeProjet entity) - Crée
// - update(DemandeProjet entity) - Met à jour
// - delete(UUID id) - Supprime

// Attributs gérés:
// - idDemande, nomClient, emailClient, entrepriseClient
// - titreProjet, descriptionBesoin, budgetEstime
// - dateSoumission, dateTraitement, statutDemande

// Statuts: EN_ATTENTE, APPROUVEE, REJETEE, EN_COURS
```

---

#### 11. **DashboardDAO**
**Fichier:** `DashboardDAO.java`

**Code Source:**
```java
package dao;

import models.ActiviteDTO;
import utils.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DashboardDAO {

    /**
     * Récupère les 5 dernières activités globales du système en combinant 
     * les tables Projet, DemandeProjet et Audit_Environnement.
     */
    public List<ActiviteDTO> getTimelineActivites() {
        List<ActiviteDTO> liste = new ArrayList<>();
        
        String sql = 
            "(SELECT CONCAT('Nouveau projet créé : ', nomProjet) AS description, dateLancement AS dateAction " +
            " FROM Projet) " +
            "UNION ALL " +
            "(SELECT CONCAT('Demande reçue de : ', COALESCE(entrepriseClient, nomClient)) AS description, dateSoumission AS dateAction " +
            " FROM DemandeProjet) " +
            "UNION ALL " +
            "(SELECT CONCAT('Modification (', action, ') sur un environnement') AS description, dateModif AS dateAction " +
            " FROM Audit_Environnement) " +
            "ORDER BY dateAction DESC LIMIT 5";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
             
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy à HH:mm");
             
            while (rs.next()) {
                String description = rs.getString("description");
                java.sql.Timestamp date = rs.getTimestamp("dateAction");
                String dateFormatee = (date != null) ? sdf.format(date) : "Date inconnue";
                liste.add(new ActiviteDTO(description, dateFormatee));
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors du chargement de la timeline du Dashboard : " + e.getMessage());
        }
        
        return liste;
    }
}
```

---

## Architecture

### Pattern DAO
L'application utilise le pattern **Data Access Object (DAO)** pour abstraire et encapsuler l'accès aux données.

```
┌─────────────────────────────────────────────────┐
│          Couche Présentation (JSP/Servlets)   │
└────────────────────┬────────────────────────────┘
                     │
┌────────────────────▼────────────────────────────┐
│     Couche Métier (Controllers/Services)       │
└────────────────────┬────────────────────────────┘
                     │
┌────────────────────▼────────────────────────────┐
│  Couche DAO (IGenericDAO et implémentations)   │
└────────────────────┬────────────────────────────┘
                     │
┌────────────────────▼────────────────────────────┐
│     Couche Modèles (Entités métier)            │
└─────────────────────────────────────────────────┘
                     │
┌────────────────────▼────────────────────────────┐
│         Couche Données (Base de données)        │
└─────────────────────────────────────────────────┘
```

### Connexion à la Base de Données
- **Classe:** `DbConnection` (dans `utils`)
- **Type:** PostgreSQL
- **Configuration:** Via fichier `db.env`

### Sécurité
- **Authentification:** Hashage des mots de passe avec **BCrypt**
- **Autorisation:** Vérification des rôles par affectation projet
- **Filtre:** `SecurityFilter` pour les contrôles d'accès

---

## Flux Typique d'Utilisation

### Exemple : Création d'un environnement

```java
// 1. Récupération de l'utilisateur (via UtilisateurDAO)
Utilisateur user = utilisateurDAO.findById(userId);

// 2. Vérification du rôle (via AffectationDAO)
RoleProjet role = affectationDAO.findRoleOnProjet(projetId, userId);

// 3. Vérification des permissions
if (role != RoleProjet.DEVELOPPEUR) {
    // Accès refusé
}

// 4. Création de l'environnement (via EnvironnementDAO)
Environnement env = new Environnement();
env.setIdEnv(UUID.randomUUID());
env.setTypeEnv(TypeEnvironnement.DEVELOPPEMENT);
// ... population d'autres champs

environnementDAO.save(env);

// 5. Association des technologies (via VersionTechnoDAO)
VersionTechno vt = new VersionTechno();
vt.setEnvironnement(env);
vt.setTechnologie(techno);
vt.setVersion("1.0.0");

versionTechnoDAO.save(vt);
```

---

## Résumé

| Entité | DAO | Responsabilité |
|--------|-----|-----------------|
| Utilisateur | UtilisateurDAO | Gestion des utilisateurs et authentification |
| Profil | ProfilDAO | Gestion des rôles/profils |
| Projet | ProjetDAO | Gestion des projets |
| Client | ClientDAO | Gestion des clients |
| Environnement | EnvironnementDAO | Gestion des environnements |
| Serveur | ServeurDAO | Gestion des serveurs |
| Technologie | TechnologieDAO | Gestion des technologies |
| VersionTechno | VersionTechnoDAO | Gestion des versions technos |
| Affectation | AffectationDAO | Gestion des affectations utilisateur-projet |
| DemandeProjet | DemandeProjetDAO | Gestion des demandes de projets |
| Dashboard | DashboardDAO | Statistiques et reporting |

---

**Document généré le:** 1 juin 2026  
**Projet:** EnvHub  
**Version:** 1.0
