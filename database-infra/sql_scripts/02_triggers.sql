/* ---------------------------------------------------- */
/* Projet      : EnvHub - Script isolé des Triggers     */
/* SGBD        : MySQL / MariaDB                        */
/* ---------------------------------------------------- */

USE `EnvHub`;

-- On change le délimiteur pour pouvoir écrire des blocs d'instructions (BEGIN ... END)
DELIMITER $$

/* ==================================================== */
/* 1. RÈGLES MÉTIER (INTÉGRITÉ & SÉCURITÉ)              */
/* ==================================================== */

-- 1.1 Unicité de l'environnement de Production (Insertion)
DROP TRIGGER IF EXISTS trg_check_single_production_insert$$
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

-- 1.2 Unicité de l'environnement de Production (Mise à jour)
DROP TRIGGER IF EXISTS trg_check_single_production_update$$
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

-- 1.3 Cohérence chronologique des dates
DROP TRIGGER IF EXISTS trg_check_dates_projet$$
CREATE TRIGGER trg_check_dates_projet
BEFORE INSERT ON `Projet`
FOR EACH ROW
BEGIN
    IF NEW.dateLivraisonEstimee IS NOT NULL AND NEW.dateLivraisonEstimee < NEW.dateLancement THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Erreur : La date de livraison ne peut pas précéder la date de lancement.';
    END IF;
END$$

-- 1.4 Limite d'un seul Chef de Projet
DROP TRIGGER IF EXISTS trg_limite_chef_projet_insert$$
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

-- 1.5 Sécurité Infrastructure : Pas de production sur un serveur avec moins de 4Go de RAM
DROP TRIGGER IF EXISTS trg_check_capacite_serveur_prod$$
CREATE TRIGGER trg_check_capacite_serveur_prod
BEFORE INSERT ON `Environnement`
FOR EACH ROW
BEGIN
    DECLARE v_ram INT;
    
    IF NEW.idServ IS NOT NULL AND NEW.typeEnv = 'PRODUCTION' THEN
        SELECT ram_gb INTO v_ram FROM `Serveur` WHERE idServ = NEW.idServ;
        
        IF v_ram IS NOT NULL AND v_ram < 4 THEN
            SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Erreur d''infrastructure : Impossible d''affecter un environnement de PRODUCTION sur un serveur possédant moins de 4 Go de RAM.';
        END IF;
    END IF;
END$$

-- 1.6 Validation du format des URLs
DROP TRIGGER IF EXISTS trg_format_url$$
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


/* ==================================================== */
/* 2. AUTOMATISATION (CYCLE DE VIE)                     */
/* ==================================================== */

-- 2.1 Livraison automatique à 100% d'avancement
DROP TRIGGER IF EXISTS trg_auto_livraison$$
CREATE TRIGGER trg_auto_livraison
BEFORE UPDATE ON `Projet`
FOR EACH ROW
BEGIN
    IF NEW.pourcentageAvancement = 100 AND OLD.pourcentageAvancement < 100 THEN
        SET NEW.statutProjet = 'LIVRE';
    END IF;
END$$

-- 2.2 Bloquer les affectations sur projet clôturé
DROP TRIGGER IF EXISTS trg_bloquer_affectation_projet_termine$$
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

-- 2.3 Suivi Commercial : Mettre à jour automatiquement la date de traitement d'une demande
DROP TRIGGER IF EXISTS trg_auto_date_traitement_demande$$
CREATE TRIGGER trg_auto_date_traitement_demande
BEFORE UPDATE ON `DemandeProjet`
FOR EACH ROW
BEGIN
    IF NEW.statutDemande != OLD.statutDemande AND NEW.statutDemande IN ('ACCEPTE', 'REJETE') THEN
        SET NEW.dateTraitement = CURRENT_TIMESTAMP;
    END IF;
END$$


/* ==================================================== */
/* 3. SÉCURITÉ ET AUDIT (TRAÇABILITÉ)                   */
/* ==================================================== */

-- 3.1 Interdire la suppression physique (Soft Delete)
DROP TRIGGER IF EXISTS trg_interdire_suppression_projet$$
CREATE TRIGGER trg_interdire_suppression_projet
BEFORE DELETE ON `Projet`
FOR EACH ROW
BEGIN
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Sécurité : La suppression d''un projet est interdite. Veuillez changer son statut en ANNULE.';
END$$

-- 3.2 Journalisation des modifications techniques
DROP TRIGGER IF EXISTS trg_audit_env_update$$
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

-- 3.3 Intégrité Commerciale : Empêcher la modification d'une demande clôturée
DROP TRIGGER IF EXISTS trg_bloquer_modif_demande_cloturee$$
CREATE TRIGGER trg_bloquer_modif_demande_cloturee
BEFORE UPDATE ON `DemandeProjet`
FOR EACH ROW
BEGIN
    IF OLD.statutDemande IN ('ACCEPTE', 'REJETE') THEN
        IF OLD.descriptionBesoin != NEW.descriptionBesoin OR OLD.titreProjet != NEW.titreProjet OR OLD.budgetEstime != NEW.budgetEstime THEN
            SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Sécurité : Impossible de modifier les détails d''une demande qui a déjà été traitée (Acceptée ou Rejetée).';
        END IF;
    END IF;
END$$

-- Rétablissement du délimiteur classique
DELIMITER ;