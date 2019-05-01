package Modele;

public class locataire extends personne {
	
	private String etat_locataire;
	public locataire(){
		super();
	}
	public locataire(int id_personne, String cart_identite, String pseudo, String password, String nom, String prenom,
			String email, String num_telephone) {
		super(id_personne, cart_identite, pseudo, password, nom, prenom, email, num_telephone);
		
	}
	public locataire(int id_personne, String cart_identite, String pseudo, String password, String nom, String prenom,
			String email, String num_telephone, String etat_locataire) {
		super(id_personne, cart_identite, pseudo, password, nom, prenom, email, num_telephone);
		this.etat_locataire = etat_locataire;
	}
	public String getEtat_locataire() {
		return etat_locataire;
	}
	public void setEtat_locataire(String etat_locataire) {
		this.etat_locataire = etat_locataire;
	}
	

}
