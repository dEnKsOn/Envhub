package models;
import java.util.UUID;

/**
 * @author jub-ubuntu
 * @version 1.0
 * @created 26-avr.-2026 01:04:49
 */
public class Technologie {

	private UUID idTechno;
	private String nomTechno;
	private TypeTechno typeTechno;
	private int utilisations;

	public Technologie(){

	}

	public UUID getIdTechno() {
		return idTechno;
	}

	public void setIdTechno(UUID idTechno) {
		this.idTechno = idTechno;
	}

	public String getNomTechno() {
		return nomTechno;
	}

	public void setNomTechno(String nomTechno) {
		this.nomTechno = nomTechno;
	}

	public TypeTechno getTypeTechno() {
		return typeTechno;
	}

	public void setTypeTechno(TypeTechno typeTechno) {
		this.typeTechno = typeTechno;
	}

	public int getUtilisations() {
		return utilisations;
	}

	public void setUtilisations(int utilisations) {
		this.utilisations = utilisations;
	}

	public void finalize() throws Throwable {

	}
}//end Technologie