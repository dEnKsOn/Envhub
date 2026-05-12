package models;
/**
 * @author jub-ubuntu
 * @version 1.0
 * @created 26-avr.-2026 01:04:51
 */
public class VersionTechno {

	private String version;
	public Technologie technologie;
	public Environnement environnement;

	public VersionTechno(){

	}

	

	public String getVersion() {
		return version;
	}



	public void setVersion(String version) {
		this.version = version;
	}



	public Technologie getTechnologie() {
		return technologie;
	}



	public void setTechnologie(Technologie technologie) {
		this.technologie = technologie;
	}



	public Environnement getEnvironnement() {
		return environnement;
	}



	public void setEnvironnement(Environnement environnement) {
		this.environnement = environnement;
	}



	public void finalize() throws Throwable {

	}
}//end VersionTechno