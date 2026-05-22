package models;
import java.util.UUID;

/**
 * @author jub-ubuntu
 * @version 1.0
 * @created 26-avr.-2026 01:04:48
 */
public class Serveur {

	private UUID idServ;
	private String adressIP;
	private String os;
	private int nombreEnvironnements;
	private Integer cpuCores;
	private Integer ramGb;
	private String fournisseur;

	public Serveur(){

	}

	public UUID getIdServ() {
		return idServ;
	}

	public void setIdServ(UUID idServ) {
		this.idServ = idServ;
	}

	public String getAdressIP() {
		return adressIP;
	}

	public void setAdressIP(String adressIP) {
		this.adressIP = adressIP;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public int getNombreEnvironnements() {
		return nombreEnvironnements;
	}

	public void setNombreEnvironnements(int nombreEnvironnements) {
		this.nombreEnvironnements = nombreEnvironnements;
	}

	public Integer getCpuCores() {
		return cpuCores;
	}

	public void setCpuCores(Integer cpuCores) {
		this.cpuCores = cpuCores;
	}

	public Integer getRamGb() {
		return ramGb;
	}

	public void setRamGb(Integer ramGb) {
		this.ramGb = ramGb;
	}

	public String getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(String fournisseur) {
		this.fournisseur = fournisseur;
	}

	public void finalize() throws Throwable {

	}
}
