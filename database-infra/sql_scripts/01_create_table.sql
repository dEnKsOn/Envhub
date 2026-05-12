/* ---------------------------------------------------- */
/* Projet      : EnvHub - Système de Gestion           */
/* Auteur      : Kossi Jubilee DENOU                   */
/* SGBD        : MySQL                                  */
/* ---------------------------------------------------- */

SET FOREIGN_KEY_CHECKS=0; 

CREATE DATABASE IF NOT EXISTS `EnvHub` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

SET NAMES 'utf8mb4';
USE `EnvHub`;

/* ==================================================== */
/* SUPPRESSION DES TABLES EXISTANTES                    */
/* ==================================================== */

DROP TABLE IF EXISTS `VersionTechno` CASCADE;
DROP TABLE IF EXISTS `Affectation` CASCADE;
DROP TABLE IF EXISTS `Environnement` CASCADE;
DROP TABLE IF EXISTS `Technologie` CASCADE;
DROP TABLE IF EXISTS `Serveur` CASCADE;
DROP TABLE IF EXISTS `Projet` CASCADE;
DROP TABLE IF EXISTS `Client` CASCADE;
DROP TABLE IF EXISTS `Utilisateur` CASCADE;
DROP TABLE IF EXISTS `Profil` CASCADE;

/* ==================================================== */
/* CRÉATION DES TABLES (AVEC TYPES OPTIMISÉS)           */
/* ==================================================== */

CREATE TABLE `Profil`
(
    `idProfil` INT NOT NULL AUTO_INCREMENT,
    `libelle` VARCHAR(50) NOT NULL,
    CONSTRAINT `PK_Profil` PRIMARY KEY (`idProfil`)
);

CREATE TABLE `Utilisateur`
(
    `idUser` CHAR(36) NOT NULL,
    `nomUser` VARCHAR(50) NOT NULL,
    `prenomUser` VARCHAR(50) NOT NULL,
    `genre` VARCHAR(10) NULL, /* Ajout de l'attribut manquant */
    `email` VARCHAR(100) NOT NULL UNIQUE,
    `password` VARCHAR(255) NOT NULL,
    `idProfil` INT NOT NULL,
    CONSTRAINT `PK_Utilisateur` PRIMARY KEY (`idUser`)
);

CREATE TABLE `Client`
(
    `idClient` CHAR(36) NOT NULL,
    `nomClient` VARCHAR(100) NOT NULL,
    `prenomClient` VARCHAR(100) NULL, /* Ajout de l'attribut manquant */
    `entrepriseClient` VARCHAR(100) NOT NULL,
    CONSTRAINT `PK_Client` PRIMARY KEY (`idClient`)
);

CREATE TABLE `Projet`
(
    `idProjet` CHAR(36) NOT NULL,
    `nomProjet` VARCHAR(100) NOT NULL,
    `descriptionTech` TEXT NOT NULL, /* TEXT pour les longues descriptions */
    `dateLancement` DATE NOT NULL,
    `dateLivraisonEstimee` DATE NULL,
    `statutProjet` ENUM('EN_COURS', 'EN_PAUSE', 'LIVRE', 'ANNULE') NOT NULL DEFAULT 'EN_COURS',
    `pourcentageAvancement` INT DEFAULT 0, /* Ajout de l'attribut manquant */
    `idClient` CHAR(36) NOT NULL,
    CONSTRAINT `PK_Projet` PRIMARY KEY (`idProjet`),
    CONSTRAINT `UQ_NomProjet_Client` UNIQUE (`nomProjet`, `idClient`) /* Empêche les doublons pour un même client */
);

CREATE TABLE `Serveur`
(
    `idServ` CHAR(36) NOT NULL,
    `adressIP` VARCHAR(50) NOT NULL,
    `os` VARCHAR(50) NOT NULL,
    CONSTRAINT `PK_Serveur` PRIMARY KEY (`idServ`)
);

CREATE TABLE `Environnement`
(
    `idEnv` CHAR(36) NOT NULL,
    `typeEnv` ENUM('DEVELOPPEMENT', 'LOCAL', 'PRODUCTION', 'STAGING') NOT NULL,
    `nomBaseDeDonnees` VARCHAR(100) NULL,
    `urlFront` VARCHAR(255) NULL,
    `urlBack` VARCHAR(255) NULL,
    `notes` TEXT NULL,
    `idProjet` CHAR(36) NOT NULL,
    `idServ` CHAR(36) NULL, /* NULL autorisé au cas où on prépare l'environnement avant d'avoir le serveur */
    CONSTRAINT `PK_Environnement` PRIMARY KEY (`idEnv`)
);

CREATE TABLE `Technologie`
(
    `idTechno` CHAR(36) NOT NULL,
    `nomTechno` VARCHAR(50) NOT NULL,
    `typeTechno` ENUM('LANGAGE', 'FRAMEWORK', 'SGBD') NOT NULL,
    CONSTRAINT `PK_Technologie` PRIMARY KEY (`idTechno`)
);

/* --- Tables de jointure (avec Clés Primaires Composites) --- */

CREATE TABLE `Affectation`
(
    `idProjet` CHAR(36) NOT NULL,
    `idUser` CHAR(36) NOT NULL,
    `roleProjet` ENUM('DEVELOPPEUR', 'CHEF_PROJET') NOT NULL,
    CONSTRAINT `PK_Affectation` PRIMARY KEY (`idProjet`, `idUser`)
);

CREATE TABLE `VersionTechno`
(
    `idEnv` CHAR(36) NOT NULL,
    `idTechno` CHAR(36) NOT NULL,
    `version` VARCHAR(50) NOT NULL,
    CONSTRAINT `PK_VersionTechno` PRIMARY KEY (`idEnv`, `idTechno`)
);


/* ==================================================== */
/* CONTRAINTES DE CLÉS ÉTRANGÈRES ET CYCLE DE VIE       */
/* ==================================================== */

/* Utilisateur -> Profil */
ALTER TABLE `Utilisateur` 
 ADD CONSTRAINT `FK_Utilisateur_Profil`
    FOREIGN KEY (`idProfil`) REFERENCES `Profil` (`idProfil`) 
    ON DELETE RESTRICT ON UPDATE CASCADE;

/* Projet -> Client */
ALTER TABLE `Projet` 
 ADD CONSTRAINT `FK_Projet_Client`
    FOREIGN KEY (`idClient`) REFERENCES `Client` (`idClient`) 
    ON DELETE RESTRICT ON UPDATE CASCADE;

/* Environnement -> Projet (COMPOSITION : Suppression en cascade) */
ALTER TABLE `Environnement` 
 ADD CONSTRAINT `FK_Environnement_Projet`
    FOREIGN KEY (`idProjet`) REFERENCES `Projet` (`idProjet`) 
    ON DELETE CASCADE ON UPDATE CASCADE;

/* Environnement -> Serveur (ASSOCIATION SIMPLE / AGRÉGATION : Protection) */
ALTER TABLE `Environnement` 
 ADD CONSTRAINT `FK_Environnement_Serveur`
    FOREIGN KEY (`idServ`) REFERENCES `Serveur` (`idServ`) 
    ON DELETE RESTRICT ON UPDATE CASCADE;

/* Affectation (Projet + Utilisateur) */
ALTER TABLE `Affectation` 
 ADD CONSTRAINT `FK_Affectation_Projet`
    FOREIGN KEY (`idProjet`) REFERENCES `Projet` (`idProjet`) 
    ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `Affectation` 
 ADD CONSTRAINT `FK_Affectation_Utilisateur`
    FOREIGN KEY (`idUser`) REFERENCES `Utilisateur` (`idUser`) 
    ON DELETE CASCADE ON UPDATE CASCADE;

/* VersionTechno (Environnement + Technologie) */
ALTER TABLE `VersionTechno` 
 ADD CONSTRAINT `FK_VersionTechno_Environnement`
    FOREIGN KEY (`idEnv`) REFERENCES `Environnement` (`idEnv`) 
    ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `VersionTechno` 
 ADD CONSTRAINT `FK_VersionTechno_Technologie`
    FOREIGN KEY (`idTechno`) REFERENCES `Technologie` (`idTechno`) 
    ON DELETE RESTRICT ON UPDATE CASCADE;

SET FOREIGN_KEY_CHECKS=1;

-- Démarrage d'une transaction pour garantir l'atomicité de l'opération
START TRANSACTION;

-- 1. Insertion du rôle Administrateur dans la table Profil
INSERT INTO `Profil` (libelle) VALUES ('Développeur');
INSERT INTO `Profil` (libelle) VALUES ('Administrateur');

-- 2. Récupération de l'ID auto-incrémenté généré pour ce profil
SET @adminProfilId = LAST_INSERT_ID();

-- 3. Insertion de l'utilisateur Administrateur
INSERT INTO Utilisateur (idUser, nomUser, prenomUser, email, password, idProfil)
VALUES (
    UUID(),                                                      -- Génération native de l'UUID
    'DENOU',
    'Jubilee',
    'jub@envhub.ma',                                          -- Email d'authentification
    '$2a$10$Cvc7n4QJ0wHPbqMNxbzmSujbW4qOwrZkR4iW/QDS3XFO0fsxasgCK',  -- Remplacer par un vrai hash BCrypt/Argon2
    @adminProfilId                                               -- Liaison avec la table Profil
);

COMMIT;