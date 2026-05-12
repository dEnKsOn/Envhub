package models;

/**
 * @author jub-ubuntu
 * @version 1.0
 * @created 26-avr.-2026 01:04:42
 */
public class Affectation {

	private RoleProjet roleProjet;
	public Utilisateur utilisateur;
	public Projet projet;

	public Affectation(){

	}

	

	public RoleProjet getRoleProjet() {
		return roleProjet;
	}



	public void setRoleProjet(RoleProjet roleProjet) {
		this.roleProjet = roleProjet;
	}



	public Utilisateur getUtilisateur() {
		return utilisateur;
	}



	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}



	public Projet getProjet() {
		return projet;
	}



	public void setProjet(Projet projet) {
		this.projet = projet;
	}



	public void finalize() throws Throwable {

	}
}//end Affectation