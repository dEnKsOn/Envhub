/* ---------------------------------------------------- */
/* Projet      : EnvHub - Système de Gestion            */
/* Auteur      : Kossi Jubilee DENOU                    */
/* SGBD        : MySQL / MariaDB                        */
/* Description : Création complète (Table)              */
/* ---------------------------------------------------- */

SET FOREIGN_KEY_CHECKS=0; 

CREATE DATABASE IF NOT EXISTS `EnvHub` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci; 

SET NAMES utf8mb4;
USE `EnvHub`;

/* ==================================================== */
/* 1. SUPPRESSION DES TABLES EXISTANTES                 */
/* ==================================================== */

DROP TABLE IF EXISTS `Audit_Environnement` CASCADE;
DROP TABLE IF EXISTS `VersionTechno` CASCADE;
DROP TABLE IF EXISTS `Affectation` CASCADE;
DROP TABLE IF EXISTS `Environnement` CASCADE;
DROP TABLE IF EXISTS `Technologie` CASCADE;
DROP TABLE IF EXISTS `Serveur` CASCADE;
DROP TABLE IF EXISTS `Projet` CASCADE;
DROP TABLE IF EXISTS `Client` CASCADE;
DROP TABLE IF EXISTS `Utilisateur` CASCADE;
DROP TABLE IF EXISTS `Profil` CASCADE;
DROP TABLE IF EXISTS `DemandeProjet` CASCADE;

/* ==================================================== */
/* 2. CRÉATION DES TABLES                               */
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
    `genre` VARCHAR(10) NULL,
    `email` VARCHAR(100) NOT NULL UNIQUE,
    `password` VARCHAR(255) NOT NULL,
    `idProfil` INT NOT NULL,
    CONSTRAINT `PK_Utilisateur` PRIMARY KEY (`idUser`)
);

CREATE TABLE `Client`
(
    `idClient` CHAR(36) NOT NULL,
    `nomClient` VARCHAR(100) NOT NULL,
    `prenomClient` VARCHAR(100) NULL,
    `entrepriseClient` VARCHAR(100) NOT NULL,
    `emailClient` VARCHAR(100) NULL,
    CONSTRAINT `PK_Client` PRIMARY KEY (`idClient`)
);

CREATE TABLE `Projet`
(
    `idProjet` CHAR(36) NOT NULL,
    `nomProjet` VARCHAR(100) NOT NULL,
    `descriptionTech` TEXT NOT NULL,
    `dateLancement` DATE NOT NULL,
    `dateLivraisonEstimee` DATE NULL,
    `statutProjet` ENUM('EN_COURS', 'EN_PAUSE', 'LIVRE', 'ANNULE') NOT NULL DEFAULT 'EN_COURS',
    `pourcentageAvancement` INT DEFAULT 0,
    `idClient` CHAR(36) NOT NULL,
    CONSTRAINT `PK_Projet` PRIMARY KEY (`idProjet`),
    CONSTRAINT `UQ_NomProjet_Client` UNIQUE (`nomProjet`, `idClient`)
);

CREATE TABLE `Serveur`
(
    `idServ` CHAR(36) NOT NULL,
    `adressIP` VARCHAR(50) NOT NULL UNIQUE, 
    `os` VARCHAR(50) NOT NULL,
    `cpu_cores` INT NULL,                   
    `ram_gb` INT NULL,                      
    `fournisseur` VARCHAR(100) NULL,        
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
    `idCreator` CHAR(36) NOT NULL,
    `dateCreation` DATETIME DEFAULT CURRENT_TIMESTAMP,
    `idProjet` CHAR(36) NOT NULL,
    `idServ` CHAR(36) NULL, 
    CONSTRAINT `PK_Environnement` PRIMARY KEY (`idEnv`)
);

CREATE TABLE `Technologie`
(
    `idTechno` CHAR(36) NOT NULL,
    `nomTechno` VARCHAR(50) NOT NULL,
    `typeTechno` ENUM('LANGAGE', 'FRAMEWORK', 'SGBD') NOT NULL,
    CONSTRAINT `PK_Technologie` PRIMARY KEY (`idTechno`)
);

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

CREATE TABLE `DemandeProjet`
(
    `idDemande` CHAR(36) NOT NULL,
    `nomClient` VARCHAR(100) NOT NULL,
    `emailClient` VARCHAR(100) NOT NULL,
    `entrepriseClient` VARCHAR(100) NULL,
    `titreProjet` VARCHAR(150) NOT NULL,
    `descriptionBesoin` TEXT NOT NULL,
    `budgetEstime` DECIMAL(10,2) NULL,
    `dateSoumission` DATETIME DEFAULT CURRENT_TIMESTAMP,
    `statutDemande` ENUM('EN_ATTENTE', 'ACCEPTE', 'REJETE') NOT NULL DEFAULT 'EN_ATTENTE',
    `dateTraitement` DATETIME NULL,
    CONSTRAINT `PK_DemandeProjet` PRIMARY KEY (`idDemande`)
);

CREATE TABLE `Audit_Environnement` 
(
    `idAudit` INT AUTO_INCREMENT PRIMARY KEY,
    `idEnv` CHAR(36) NOT NULL,
    `action` VARCHAR(10) NOT NULL,
    `dateModif` DATETIME DEFAULT CURRENT_TIMESTAMP,
    `ancienne_urlFront` VARCHAR(255),
    `nouvelle_urlFront` VARCHAR(255),
    `ancienne_urlBack` VARCHAR(255),
    `nouvelle_urlBack` VARCHAR(255),
    `idUserModif` CHAR(36) 
);


/* ==================================================== */
/* 3. CONTRAINTES DE CLÉS ÉTRANGÈRES                    */
/* ==================================================== */

ALTER TABLE `Utilisateur` 
 ADD CONSTRAINT `FK_Utilisateur_Profil` FOREIGN KEY (`idProfil`) REFERENCES `Profil` (`idProfil`) ON DELETE RESTRICT ON UPDATE CASCADE;

ALTER TABLE `Projet` 
 ADD CONSTRAINT `FK_Projet_Client` FOREIGN KEY (`idClient`) REFERENCES `Client` (`idClient`) ON DELETE RESTRICT ON UPDATE CASCADE;

/* Cles étrangères pour l'Environnement (Corrigées) */
ALTER TABLE `Environnement` 
 ADD CONSTRAINT `FK_Environnement_Utilisateur` FOREIGN KEY (`idCreator`) REFERENCES `Utilisateur` (`idUser`) ON DELETE CASCADE ON UPDATE CASCADE,
 ADD CONSTRAINT `FK_Environnement_Projet` FOREIGN KEY (`idProjet`) REFERENCES `Projet` (`idProjet`) ON DELETE CASCADE ON UPDATE CASCADE,
 ADD CONSTRAINT `FK_Environnement_Serveur` FOREIGN KEY (`idServ`) REFERENCES `Serveur` (`idServ`) ON DELETE SET NULL ON UPDATE CASCADE;

ALTER TABLE `Affectation` 
 ADD CONSTRAINT `FK_Affectation_Projet` FOREIGN KEY (`idProjet`) REFERENCES `Projet` (`idProjet`) ON DELETE CASCADE ON UPDATE CASCADE,
 ADD CONSTRAINT `FK_Affectation_Utilisateur` FOREIGN KEY (`idUser`) REFERENCES `Utilisateur` (`idUser`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `VersionTechno` 
 ADD CONSTRAINT `FK_VersionTechno_Environnement` FOREIGN KEY (`idEnv`) REFERENCES `Environnement` (`idEnv`) ON DELETE CASCADE ON UPDATE CASCADE,
 ADD CONSTRAINT `FK_VersionTechno_Technologie` FOREIGN KEY (`idTechno`) REFERENCES `Technologie` (`idTechno`) ON DELETE RESTRICT ON UPDATE CASCADE;

SET FOREIGN_KEY_CHECKS=1;

/* ==================================================== */
/* 4. INSERTION INITIALE (JEU DE DONNÉES DE DÉPART)     */
/* ==================================================== */

START TRANSACTION;

INSERT INTO `Profil` (libelle) VALUES ('Développeur');
INSERT INTO `Profil` (libelle) VALUES ('Administrateur');

SET @adminProfilId = LAST_INSERT_ID();

INSERT INTO `Utilisateur` (idUser, nomUser, prenomUser, genre, email, password, idProfil)
VALUES (
    UUID(),                                                      
    'DENOU',
    'Jubilee',
    'Masculin',
    'jub@envhub.ma',                                          
    '$2a$10$Cvc7n4QJ0wHPbqMNxbzmSujbW4qOwrZkR4iW/QDS3XFO0fsxasgCK',  
    @adminProfilId                                               
);

COMMIT;