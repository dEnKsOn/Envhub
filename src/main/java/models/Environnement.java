package models;
import java.util.UUID;

/**
 * @author jub-ubuntu
 * @version 1.0
 * @created 26-avr.-2026 01:04:47
 */
public class Environnement {

	private UUID idEnv;
	private TypeEnvironnement typeEnv;
	private String nomBaseDeDonnees;
	private String urlFront;
	private String urlBack;
	private String notes;
	private UUID idProjet;
	private UUID idServ;
	private String nomProjet;
	public Serveur serveur;

	public Environnement(){

	}

	

	public UUID getIdEnv() {
		return idEnv;
	}



	public void setIdEnv(UUID idEnv) {
		this.idEnv = idEnv;
	}



	public TypeEnvironnement getTypeEnv() {
		return typeEnv;
	}



	public void setTypeEnv(TypeEnvironnement typeEnv) {
		this.typeEnv = typeEnv;
	}



	public String getNomBaseDeDonnees() {
		return nomBaseDeDonnees;
	}



	public void setNomBaseDeDonnees(String nomBaseDeDonnees) {
		this.nomBaseDeDonnees = nomBaseDeDonnees;
	}



	public String getUrlFront() {
		return urlFront;
	}



	public void setUrlFront(String urlFront) {
		this.urlFront = urlFront;
	}



	public String getUrlBack() {
		return urlBack;
	}



	public void setUrlBack(String urlBack) {
		this.urlBack = urlBack;
	}



	public String getNotes() {
		return notes;
	}



	public void setNotes(String notes) {
		this.notes = notes;
	}



	public UUID getIdProjet() {
		return idProjet;
	}

	public void setIdProjet(UUID idProjet) {
		this.idProjet = idProjet;
	}

	public UUID getIdServ() {
		return idServ;
	}

	public void setIdServ(UUID idServ) {
		this.idServ = idServ;
	}

	public String getNomProjet() {
		return nomProjet;
	}

	public void setNomProjet(String nomProjet) {
		this.nomProjet = nomProjet;
	}

	public Serveur getServeur() {
		return serveur;
	}



	public void setServeur(Serveur serveur) {
		this.serveur = serveur;
	}



	public void finalize() throws Throwable {

	}
}//end Environnement