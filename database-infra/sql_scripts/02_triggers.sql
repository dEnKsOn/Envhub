/* ---------------------------------------------------- */
/* Projet      : EnvHub - Script des Triggers           */
/* Auteur      : Kossi Jubilee DENOU                   */
/* SGBD        : MySQL (Docker Compatible)              */
/* ---------------------------------------------------- */

USE `EnvHub`;

/* ==================================================== */
/* 0. PRÉPARATION : TABLE D'AUDIT                       */
/* ==================================================== */

CREATE TABLE IF NOT EXISTS `Audit_Environnement` (
    `idAudit` INT AUTO_INCREMENT PRIMARY KEY,
    `idEnv` CHAR(36) NOT NULL,
    `action` VARCHAR(10) NOT NULL, -- UPDATE, DELETE
    `dateModif` DATETIME DEFAULT CURRENT_TIMESTAMP,
    `ancienne_urlFront` VARCHAR(255),
    `nouvelle_urlFront` VARCHAR(255),
    `ancienne_urlBack` VARCHAR(255),
    `nouvelle_urlBack` VARCHAR(255),
    `idUserModif` CHAR(36) -- Optionnel : pour tracer qui a fait quoi
);

-- On ouvre le délimiteur spécial UNE SEULE FOIS ici
DELIMITER $$

/* ==================================================== */
/* 1. RÈGLES MÉTIER (INTÉGRITÉ)                         */
/* ==================================================== */

-- Unicité de l'environnement de Production (Insertion)
CREATE TRIGGER trg_check_single_production_insert
BEFORE INSERT ON `Environnement`
FOR EACH ROW
BEGIN
    DECLARE prod_count INT;
    IF NEW.typeEnv = 'PRODUCTION' THEN
        SELECT COUNT(*) INTO prod_count FROM `Environnement` 
        WHERE idProjet = NEW.idProjet AND typeEnv = 'PRODUCTION';
        IF prod_count > 0 THEN
            SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Erreur : Un projet ne peut avoir qu''un seul environnement de PRODUCTION.';
        END IF;
    END IF;
END$$

-- Unicité de l'environnement de Production (Mise à jour)
CREATE TRIGGER trg_check_single_production_update
BEFORE UPDATE ON `Environnement`
FOR EACH ROW
BEGIN
    DECLARE prod_count INT;
    IF NEW.typeEnv = 'PRODUCTION' AND OLD.typeEnv != 'PRODUCTION' THEN
        SELECT COUNT(*) INTO prod_count FROM `Environnement` 
        WHERE idProjet = NEW.idProjet AND typeEnv = 'PRODUCTION';
        IF prod_count > 0 THEN
            SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Erreur : Ce projet possède déjà un environnement de PRODUCTION.';
        END IF;
    END IF;
END$$

-- Cohérence chronologique des dates
CREATE TRIGGER trg_check_dates_projet
BEFORE INSERT ON `Projet`
FOR EACH ROW
BEGIN
    IF NEW.dateLivraisonEstimee IS NOT NULL AND NEW.dateLivraisonEstimee < NEW.dateLancement THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Erreur : La date de livraison ne peut pas précéder la date de lancement.';
    END IF;
END$$

-- Limite d'un seul Chef de Projet
CREATE TRIGGER trg_limite_chef_projet_insert
BEFORE INSERT ON `Affectation`
FOR EACH ROW
BEGIN
    DECLARE chef_count INT;
    
    IF NEW.roleProjet = 'CHEF_PROJET' THEN
        SELECT COUNT(*) INTO chef_count 
        FROM `Affectation` 
        WHERE idProjet = NEW.idProjet AND roleProjet = 'CHEF_PROJET';
        
        IF chef_count >= 1 THEN
            SIGNAL SQLSTATE '45000' 
            SET MESSAGE_TEXT = 'Règle métier bloquante : Ce projet possède déjà un Chef de Projet. Un seul est autorisé.';
        END IF;
        
    END IF;
END$$

/* ==================================================== */
/* 2. AUTOMATISATION (CYCLE DE VIE)                    */
/* ==================================================== */

-- Livraison automatique à 100% d'avancement
CREATE TRIGGER trg_auto_livraison
BEFORE UPDATE ON `Projet`
FOR EACH ROW
BEGIN
    IF NEW.pourcentageAvancement = 100 AND OLD.pourcentageAvancement < 100 THEN
        SET NEW.statutProjet = 'LIVRE';
    END IF;
END$$

-- Bloquer les affectations sur projet clôturé
CREATE TRIGGER trg_bloquer_affectation_projet_termine
BEFORE INSERT ON `Affectation`
FOR EACH ROW
BEGIN
    DECLARE v_statut VARCHAR(20);
    SELECT statutProjet INTO v_statut FROM `Projet` WHERE idProjet = NEW.idProjet;
    IF v_statut IN ('LIVRE', 'ANNULE') THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Modification impossible : Le projet est clôturé (Livré ou Annulé).';
    END IF;
END$$

/* ==================================================== */
/* 3. SÉCURITÉ ET AUDIT                                 */
/* ==================================================== */

-- Interdire la suppression physique (Soft Delete)
CREATE TRIGGER trg_interdire_suppression_projet
BEFORE DELETE ON `Projet`
FOR EACH ROW
BEGIN
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Sécurité : La suppression d''un projet est interdite. Veuillez changer son statut en ANNULE.';
END$$

-- Journalisation des modifications techniques
CREATE TRIGGER trg_audit_env_update
AFTER UPDATE ON `Environnement`
FOR EACH ROW
BEGIN
    IF (OLD.urlFront != NEW.urlFront) OR (OLD.urlBack != NEW.urlBack) THEN
        INSERT INTO `Audit_Environnement` 
        (idEnv, action, ancienne_urlFront, nouvelle_urlFront, ancienne_urlBack, nouvelle_urlBack)
        VALUES 
        (NEW.idEnv, 'UPDATE', OLD.urlFront, NEW.urlFront, OLD.urlBack, NEW.urlBack);
    END IF;
END$$

/* ==================================================== */
/* 4. VALIDATION DE FORMAT                             */
/* ==================================================== */

-- Validation du format des URLs
CREATE TRIGGER trg_format_url
BEFORE INSERT ON `Environnement`
FOR EACH ROW
BEGIN
    IF NEW.urlFront IS NOT NULL AND NEW.urlFront NOT LIKE 'http%' THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Erreur de format : L''URL Front doit commencer par http:// ou https://';
    END IF;
    IF NEW.urlBack IS NOT NULL AND NEW.urlBack NOT LIKE 'http%' THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Erreur de format : L''URL Back doit commencer par http:// ou https://';
    END IF;
END$$

DELIMITER ;