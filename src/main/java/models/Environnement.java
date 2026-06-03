package models;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Environnement {

    private UUID idEnv;
    private TypeEnvironnement typeEnv;
    private String nomBaseDeDonnees;
    private String urlFront;
    private String urlBack;
    private String notes;
    private Date dateCreation;
    
    // Les clés étrangères (ID bruts)
    private UUID idCreator;
    private UUID idProjet;
    private UUID idServ;
    
    // Les objets associés (Très utiles pour l'affichage JSP)
    private Serveur serveur;
    private Projet projet;
    private Utilisateur createur; 

    private List<VersionTechno> versions;

    public Environnement() {
    }

    // --- GETTERS & SETTERS (IDs et champs simples) ---
    public UUID getIdEnv() { return idEnv; }
    public void setIdEnv(UUID idEnv) { this.idEnv = idEnv; }

    public TypeEnvironnement getTypeEnv() { return typeEnv; }
    public void setTypeEnv(TypeEnvironnement typeEnv) { this.typeEnv = typeEnv; }

    public String getNomBaseDeDonnees() { return nomBaseDeDonnees; }
    public void setNomBaseDeDonnees(String nomBaseDeDonnees) { this.nomBaseDeDonnees = nomBaseDeDonnees; }

    public String getUrlFront() { return urlFront; }
    public void setUrlFront(String urlFront) { this.urlFront = urlFront; }

    public String getUrlBack() { return urlBack; }
    public void setUrlBack(String urlBack) { this.urlBack = urlBack; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public Date getDateCreation() { return dateCreation; }
    public void setDateCreation(Date dateCreation) { this.dateCreation = dateCreation; }

    public UUID getIdCreator() { return idCreator; }
    public void setIdCreator(UUID idCreator) { this.idCreator = idCreator; }

    public UUID getIdProjet() { return idProjet; }
    public void setIdProjet(UUID idProjet) { this.idProjet = idProjet; }

    public UUID getIdServ() { return idServ; }
    public void setIdServ(UUID idServ) { this.idServ = idServ; }

    // --- GETTERS & SETTERS (Objets liés) ---
    public Serveur getServeur() { return serveur; }
    public void setServeur(Serveur serveur) { this.serveur = serveur; }

    public Projet getProjet() { return projet; }
    public void setProjet(Projet projet) { this.projet = projet; }

    public Utilisateur getCreateur() { return createur; }
    public void setCreateur(Utilisateur createur) { this.createur = createur; }

    public List<VersionTechno> getVersions() { return versions; }
    public void setVersions(List<VersionTechno> versions) { this.versions = versions; }
}