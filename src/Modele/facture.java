package Modele;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class facture {
private int code_fact;
private int id_location;
private int id_personne;
private double montant;
private Date date_pay;

public facture(){}
public facture(int code_facture,int id_location,int id_personne,double montant,Date date_pay){
	this.code_fact=code_facture;
	this.id_location=id_location;
	this.id_personne=id_personne;
	this.montant=montant;
	this.date_pay=date_pay;
}
public ArrayList<facture> getFacture(int id_location ) throws ClassNotFoundException, SQLException{
	ArrayList<facture> facture=new ArrayList<facture>();
	Connection cn = null;
	cntrlCompte c=new cntrlCompte();
	  
		  cn= c.conex();
		 Statement requete = cn.createStatement();
	      ResultSet res=requete.executeQuery("select* from facture where id_location="+id_location);
	  while (res.next()){
		  int code_facture=res.getInt("code_fact");
		   int id_location1=res.getInt("id_location");
		  int id_personne=res.getInt("id_personne") ;
		   double montant=res.getDouble("montant");
		  Date date_pay=res.getDate("date_pay");
		  facture f=new facture(code_facture, id_location1, id_personne, montant, date_pay);
		  facture.add(f);
		  
	  }
	   
		   return facture;
}
public String getNameloca(int id_personne) throws ClassNotFoundException, SQLException{
	String nom=null;
	cntrlCompte c=new cntrlCompte();
	Connection con=null;
	
		con=c.conex();
		 Statement requete1 = con.createStatement();
		 ResultSet res=requete1.executeQuery("select nom,prenom from personne where id_personne="+id_personne);
	if(res.next()){
		nom=""+res.getString("nom")+" "+res.getString("prenom");
	}
	
	return nom;
	}
	public int getCode_facture() {
	return code_fact;
}
public int getCode_fact() {
	return code_fact;
}
public void setCode_fact(int code_fact) {
	this.code_fact = code_fact;
}
public int getId_location() {
	return id_location;
}
public void setId_location(int id_location) {
	this.id_location = id_location;
}
public int getId_personne() {
	return id_personne;
}
public void setId_personne(int id_personne) {
	this.id_personne = id_personne;
}
public double getMontant() {
	return montant;
}
public void setMontant(double montant) {
	this.montant = montant;
}
public Date getDate_pay() {
	return date_pay;
}
public void setDate_pay(Date date_pay) {
	this.date_pay = date_pay;
}

}
