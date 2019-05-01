package Modele;

public class notification {
	private int id_notif;
	private int id_personne;
	private String contenue_notif;
	private String emetteur;
	public notification(int id_notif, int id_personne, String contenue_notif, String emetteur) {
		super();
		this.id_notif = id_notif;
		this.id_personne = id_personne;
		this.contenue_notif = contenue_notif;
		this.emetteur = emetteur;
	} 
	public notification(){
	}
	public int getId_notif() {
		return id_notif;
	}
	public void setId_notif(int id_notif) {
		this.id_notif = id_notif;
	}
	public int getId_personne() {
		return id_personne;
	}
	public void setId_personne(int id_personne) {
		this.id_personne = id_personne;
	}
	public String getContenue_notif() {
		return contenue_notif;
	}
	public void setContenue_notif(String contenue_notif) {
		this.contenue_notif = contenue_notif;
	}
	public String getEmetteur() {
		return emetteur;
	}
	public void setEmetteur(String emetteur) {
		this.emetteur = emetteur;
	}
	

}
