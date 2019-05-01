package Modele;

public class proprietaire extends personne{
	private String type_pro;
	private int points ; 
	

public proprietaire(int id_personne,int points){
	super(id_personne);
	
	this.points=points;
}
	
public proprietaire(int id_personne, String cart_identite, String pseudo, String password, String nom,
			String prenom, String email, String num_telephone) {
		super(id_personne, cart_identite, pseudo, password, nom, prenom, email, num_telephone);
	}
public proprietaire(int id_personne, String cart_identite, String pseudo, String password, String nom, String prenom,
		String email, String num_telephone, String type_pro) {
	super(id_personne, cart_identite, pseudo, password, nom, prenom, email, num_telephone);
	this.type_pro = type_pro;
}

public int getPoints() {
	return points;
}
public void setPoints(int points) {
	this.points = points;
}
public proprietaire(int id_personne, String cart_identite, String pseudo, String password, String nom, String prenom,
		String email, String num_telephone, String type_pro,int points) {
	super(id_personne, cart_identite, pseudo, password, nom, prenom, email, num_telephone);
	this.type_pro = type_pro;
	this.points=points;
}
public String getType_pro() {
	return type_pro;
}

public void setType_pro(String type_pro) {
	this.type_pro = type_pro;
}

public proprietaire(){}
public proprietaire (String type_pro){
	super();
	this.type_pro=type_pro;
}
}
