package models;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Modèle représentant une demande de projet soumise par un client.
 */
public class DemandeProjet {

    private UUID idDemande;
    private String nomClient;
    private String emailClient;
    private String entrepriseClient;
    private String titreProjet;
    private String descriptionBesoin;
    private Double budgetEstime;
    private LocalDateTime dateSoumission;
    private StatutDemande statutDemande; // 'EN_ATTENTE', 'ACCEPTE', 'REJETE'
    private LocalDateTime dateTraitement;

    // Constructeur par défaut
    public DemandeProjet() {
        // Par défaut, toute nouvelle demande est en attente
        this.statutDemande = StatutDemande.EN_ATTENTE;
    }

    // --- Getters et Setters ---

    public UUID getIdDemande() {
        return idDemande;
    }

    public void setIdDemande(UUID idDemande) {
        this.idDemande = idDemande;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getEmailClient() {
        return emailClient;
    }

    public void setEmailClient(String emailClient) {
        this.emailClient = emailClient;
    }

    public String getEntrepriseClient() {
        return entrepriseClient;
    }

    public void setEntrepriseClient(String entrepriseClient) {
        this.entrepriseClient = entrepriseClient;
    }

    public String getTitreProjet() {
        return titreProjet;
    }

    public void setTitreProjet(String titreProjet) {
        this.titreProjet = titreProjet;
    }

    public String getDescriptionBesoin() {
        return descriptionBesoin;
    }

    public void setDescriptionBesoin(String descriptionBesoin) {
        this.descriptionBesoin = descriptionBesoin;
    }

    public Double getBudgetEstime() {
        return budgetEstime;
    }

    public void setBudgetEstime(Double budgetEstime) {
        this.budgetEstime = budgetEstime;
    }

    public LocalDateTime getDateSoumission() {
        return dateSoumission;
    }

    public void setDateSoumission(LocalDateTime dateSoumission) {
        this.dateSoumission = dateSoumission;
    }

    public StatutDemande getStatutDemande() {
        return statutDemande;
    }

    public void setStatutDemande(StatutDemande statutDemande) {
        this.statutDemande = statutDemande;
    }

    public LocalDateTime getDateTraitement() {
        return dateTraitement;
    }

    public void setDateTraitement(LocalDateTime dateTraitement) {
        this.dateTraitement = dateTraitement;
    }
}