package Modele;

public class terrain extends bien {
	private String caracteristique;
public terrain(int id_bien, int id_personne, double superficie, int wilaya, double prix, String condition,
			String adresse, String etat_bien,int max_colocataire, String image1, String image2, String image3, String image4,
			String image5) {
		super(id_bien, id_personne, superficie, wilaya, prix, condition, adresse, etat_bien, max_colocataire, image1, image2, image3, image4,
				image5);
		// TODO Auto-generated constructor stub
	}
public terrain(int id_bien, int id_personne, double superficie, int wilaya, double prix, String condition, String adresse,
		String etat_bien,int max_colocataire, String image1, String image2, String image3, String image4, String image5,
		String caracteristique) {
	super(id_bien, id_personne, superficie, wilaya, prix, condition, adresse, etat_bien, max_colocataire, image1, image2, image3, image4,
			image5);
	this.caracteristique = caracteristique;
}
public String getCaracteristique() {
	return caracteristique;
}
public void setCaracteristique(String caracteristique) {
	this.caracteristique = caracteristique;
}


}
