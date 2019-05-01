package Modele;

public class appartement extends bien {
private int etage;
private int nbr_chambre;
	public appartement(int id_bien, int id_personne, double superficie, int wilaya, double prix, String condition,
			String adresse, String etat_bien,int max_colocataire, String image1, String image2, String image3, String image4,
			String image5) {
		super(id_bien, id_personne, superficie, wilaya, prix, condition, adresse, etat_bien,max_colocataire, image1, image2, image3, image4,
				image5);
		
	}
	public appartement(int id_bien, int id_personne, double superficie, int wilaya, double prix, String condition,
			String adresse, String etat_bien,int max_colocataire, String image1, String image2, String image3, String image4, String image5,
			int etage,int nbr_chambre) {
		super(id_bien, id_personne, superficie, wilaya, prix, condition, adresse, etat_bien,max_colocataire, image1, image2, image3,
				image4, image5);
		this.etage = etage;
		this.nbr_chambre=nbr_chambre;
	}
	public int getNbr_chambre() {
		return nbr_chambre;
	}
	public void setNbr_chambre(int nbr_chambre) {
		this.nbr_chambre = nbr_chambre;
	}
	public int getEtage() {
		return etage;
	}
	public void setEtage(int etage) {
		this.etage = etage;
	}
	
	

}
