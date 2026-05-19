package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author jub-ubuntu
 * @version 1.0
 * @created 26-avr.-2026 01:04:48
 */
public class Projet {

	private UUID idProjet;
	private UUID idClient;
	private String nomProjet;
	private String descriptionTech;
	private Date dateLancement;
	private Date dateLivraisonEstimee;
	private StatutProjet statutProjet;
	private int pourcentageAvancement;
	private String nomClient;
	private String entrepriseClient;
	private int nombreEnvironnements;
	private List<Environnement> environnements = new ArrayList<>();
	public Environnement environnement;

	public Projet(){

	}

	
	public UUID getIdProjet() {
		return idProjet;
	}


	public void setIdProjet(UUID idProjet) {
		this.idProjet = idProjet;
	}


	public String getNomProjet() {
		return nomProjet;
	}


	public void setNomProjet(String nomProjet) {
		this.nomProjet = nomProjet;
	}


	public String getDescriptionTech() {
		return descriptionTech;
	}


	public void setDescriptionTech(String descriptionTech) {
		this.descriptionTech = descriptionTech;
	}


	public Date getDateLancement() {
		return dateLancement;
	}


	public void setDateLancement(Date dateLancement) {
		this.dateLancement = dateLancement;
	}


	public Date getDateLivraisonEstimee() {
		return dateLivraisonEstimee;
	}


	public void setDateLivraisonEstimee(Date dateLivraisonEstimee) {
		this.dateLivraisonEstimee = dateLivraisonEstimee;
	}


	public StatutProjet getStatutProjet() {
		return statutProjet;
	}


	public void setStatutProjet(StatutProjet statutProjet) {
		this.statutProjet = statutProjet;
	}

	public int getPourcentageAvancement() {
		return pourcentageAvancement;
	}

	public void setPourcentageAvancement(int pourcentageAvancement) {
		this.pourcentageAvancement = pourcentageAvancement;
	}


	public Environnement getEnvironnement() {
		return environnement;
	}


	public void setEnvironnement(Environnement environnement) {
		this.environnement = environnement;
	}

	public UUID getIdClient() {
		return idClient;
	}

	public void setIdClient(UUID idClient) {
		this.idClient = idClient;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getEntrepriseClient() {
		return entrepriseClient;
	}

	public void setEntrepriseClient(String entrepriseClient) {
		this.entrepriseClient = entrepriseClient;
	}

	public int getNombreEnvironnements() {
		return nombreEnvironnements;
	}

	public void setNombreEnvironnements(int nombreEnvironnements) {
		this.nombreEnvironnements = nombreEnvironnements;
	}

	public List<Environnement> getEnvironnements() {
		return environnements;
	}

	public void setEnvironnements(List<Environnement> environnements) {
		this.environnements = environnements;
	}

	public void addEnvironnement(Environnement environnement) {
		if (environnement != null) {
			this.environnements.add(environnement);
		}
	}

	public void finalize() throws Throwable {

	}
}//end Projet