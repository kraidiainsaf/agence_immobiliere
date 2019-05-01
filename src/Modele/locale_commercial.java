package Modele;

public class locale_commercial extends bien{
private  double distance_center;
private String type_local;
	public locale_commercial(int id_bien, int id_personne, double superficie, int wilaya, double prix, String condition,
			String adresse, String etat_bien,int max_colocataire, String image1, String image2, String image3, String image4,
			String image5) {
		super(id_bien, id_personne, superficie, wilaya, prix, condition, adresse, etat_bien, max_colocataire, image1, image2, image3, image4,
				image5);
	}
	public locale_commercial(int id_bien, int id_personne, double superficie, int wilaya, double prix, String condition,
			String adresse, String etat_bien,int max_colocataire, String image1, String image2, String image3, String image4, String image5,
			double distance_center,String type_local) {
		super(id_bien, id_personne, superficie, wilaya, prix, condition, adresse, etat_bien, max_colocataire, image1, image2, image3,
				image4, image5);
		this.distance_center = distance_center;
		this.type_local=type_local;
	}
	public double getDistance_center() {
		return distance_center;
	}
	public void setDistance_center(double distance_center) {
		this.distance_center = distance_center;
	}
	public String getType_local() {
		return type_local;
	}
	public void setType_local(String type_local) {
		this.type_local = type_local;
	}
	

}
