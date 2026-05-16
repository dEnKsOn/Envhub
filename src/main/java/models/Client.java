package models;
import java.util.UUID;

public class Client {

	private UUID idClient;
	private String nomClient;
	private String prenomClient;
	private String entrepriseClient;
	
	// Champ ajouté pour l'affichage (nombre de projets associés)
	private int nombreProjets;

	public Client(){

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

	public String getPrenomClient() {
		return prenomClient;
	}

	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}

	public String getEntrepriseClient() {
		return entrepriseClient;
	}

	public void setEntrepriseClient(String entrepriseClient) {
		this.entrepriseClient = entrepriseClient;
	}

	public int getNombreProjets() {
		return nombreProjets;
	}

	public void setNombreProjets(int nombreProjets) {
		this.nombreProjets = nombreProjets;
	}
}