package Modele;

public class depot extends bien {
private int capacite_stockage;
private String type;
	public depot(int id_bien, int id_personne, double superficie, int wilaya, double prix, String condition,
			String adresse, String etat_bien,int max_colocataire, String image1, String image2, String image3, String image4,
			String image5) {
		super(id_bien, id_personne, superficie, wilaya, prix, condition, adresse, etat_bien, max_colocataire, image1, image2, image3, image4,
				image5);
		// TODO Auto-generated constructor stub
	}
	public depot(int id_bien, int id_personne, double superficie, int wilaya, double prix, String condition,
			String adresse, String etat_bien,int max_colocataire, String image1, String image2, String image3, String image4, String image5,
			int capacite_stockage, String type) {
		super(id_bien, id_personne, superficie, wilaya, prix, condition, adresse, etat_bien,max_colocataire, image1, image2, image3,
				image4, image5);
		this.capacite_stockage = capacite_stockage;
		this.type = type;
	}
	public int getCapacite_stockage() {
		return capacite_stockage;
	}
	public void setCapacite_stockage(int capacite_stockage) {
		this.capacite_stockage = capacite_stockage;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	

}
