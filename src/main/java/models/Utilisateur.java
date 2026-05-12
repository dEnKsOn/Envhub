package models;
import java.util.UUID;

/**
 * @author jub-ubuntu
 * @version 1.0
 * @created 26-avr.-2026 01:04:50
 */
public class Utilisateur {

	private UUID idUser;
	private String nomUser;
	private String prenomUser;
	private String email;
	private String password;
	public Profil profil;

	public Utilisateur(){

	}

	

	public UUID getIdUser() {
		return idUser;
	}



	public void setIdUser(UUID idUser) {
		this.idUser = idUser;
	}



	public String getNomUser() {
		return nomUser;
	}



	public void setNomUser(String nomUser) {
		this.nomUser = nomUser;
	}



	public String getPrenomUser() {
		return prenomUser;
	}



	public void setPrenomUser(String prenomUser) {
		this.prenomUser = prenomUser;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}


	public Profil getProfil() {
		return profil;
	}

	public void setProfil(Profil profil) {
		this.profil = profil;
	}


	public void finalize() throws Throwable {

	}


}//end Utilisateur