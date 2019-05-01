package Modele;

public class garage extends bien {
private int capacite_vehicule;
	public garage(int id_bien, int id_personne, double superficie, int wilaya, double prix, String condition,
			String adresse, String etat_bien,int max_colocataire, String image1, String image2, String image3, String image4,
			String image5) {
		super(id_bien, id_personne, superficie, wilaya, prix, condition, adresse, etat_bien,max_colocataire, image1, image2, image3, image4,
				image5);
		// TODO Auto-generated constructor stub
	}
	public garage(int id_bien, int id_personne, double superficie, int wilaya, double prix, String condition,
			String adresse, String etat_bien,int max_colocataire, String image1, String image2, String image3, String image4, String image5,
			int capacite_vehicule) {
		super(id_bien, id_personne, superficie, wilaya, prix, condition, adresse, etat_bien,max_colocataire, image1, image2, image3,
				image4, image5);
		this.capacite_vehicule = capacite_vehicule;
	}
	public int getCapacite_vehicule() {
		return capacite_vehicule;
	}
	public void setCapacite_vehicule(int capacite_vehicule) {
		this.capacite_vehicule = capacite_vehicule;
	}
	
	

}
