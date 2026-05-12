package models;
import java.util.UUID;

/**
 * @author jub-ubuntu
 * @version 1.0
 * @created 26-avr.-2026 01:04:43
 */
public class Client {

	private UUID idClient;
	private String nomClient;
	private String entrepriseClient;
	public Projet projet;

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



	public String getEntrepriseClient() {
		return entrepriseClient;
	}



	public void setEntrepriseClient(String entrepriseClient) {
		this.entrepriseClient = entrepriseClient;
	}



	public Projet getProjet() {
		return projet;
	}



	public void setProjet(Projet projet) {
		this.projet = projet;
	}



	public void finalize() throws Throwable {

	}
}//end Client