package Modele;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class maison extends bien{

private int nbr_chambre;
private int nbr_facade;
private Boolean jardin;
private Boolean parking;
public maison(int id_bien, int id_personne, double superficie, int wilaya, double prix, String condition,
			String adresse, String etat_bien,int max_colocataire, String image1, String image2, String image3, String image4,
			String image5) {
		super(id_bien, id_personne, superficie, wilaya, prix, condition, adresse, etat_bien,max_colocataire, image1, image2, image3, image4,
				image5);
	}

public maison(int id_bien, int id_personne, double superficie, int wilaya, double prix, String condition, String adresse,
		String etat_bien,int max_colocataire, String image1, String image2, String image3, String image4, String image5, int nbr_chambre,
		int nbr_facade, Boolean jardin, Boolean parking) {
	super(id_bien, id_personne, superficie, wilaya, prix, condition, adresse, etat_bien,max_colocataire, image1, image2, image3, image4,
			image5);
	this.nbr_chambre = nbr_chambre;
	this.nbr_facade = nbr_facade;
	this.jardin = jardin;
	this.parking = parking;
}

public int getNbr_chambre() {
	return nbr_chambre;
}

public void setNbr_chambre(int nbr_chambre) {
	this.nbr_chambre = nbr_chambre;
}

public int getNbr_facade() {
	return nbr_facade;
}

public void setNbr_facade(int nbr_facade) {
	this.nbr_facade = nbr_facade;
}

public Boolean getJardin() {
	return jardin;
}

public void setJardin(Boolean jardin) {
	this.jardin = jardin;
}

public Boolean getParking() {
	return parking;
}

public void setParking(Boolean parking) {
	this.parking = parking;
}
}
