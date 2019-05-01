package Modele;

import java.util.Date;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public class location {
	private int id_location;
	private int id_bien;
private Date date_debut;
private Date date_fin;
private String mode_pay;
private String etat_location;
public location(int id_location, int id_bien, Date date_debut, Date date_fin, String mode_pay,
		String etat_location) {
	super();
	this.id_location = id_location;
	this.id_bien = id_bien;
	this.date_debut = date_debut;
	this.date_fin = date_fin;
	this.mode_pay = mode_pay;
	this.etat_location = etat_location;
}
public void terminerLocation(int id_location) throws ClassNotFoundException, SQLException{
	Connection cn = null;
	   
	  
	cntrlCompte c=new cntrlCompte();
	   
		  cn= c.conex();
		 Statement requete = cn.createStatement();
		 int nbs=requete.executeUpdate("update location set etat_location='supprime' where id_location="+id_location);
	  
}
public location(){}

public ArrayList<location> getPlanning(int id_bien) throws ClassNotFoundException, SQLException{
	ArrayList<location> planning=new ArrayList<location>();
	Connection cn = null;
	cntrlCompte c=new cntrlCompte();
	
		  cn= c.conex();
		 Statement requete = cn.createStatement();
	      ResultSet res=requete.executeQuery("select* from location where id_bien="+id_bien);
	  while (res.next()){
		  int id_l=res.getInt("id_location");
		  int id_b=res.getInt("id_bien");
		  Date dated=res.getDate("date_debut");
		  Date datef=res.getDate("date_fin");
		  String modep=res.getString("mode_pay");
		  String etatl=res.getString("etat_location");
		  location l=new location(id_l, id_b, dated, datef, modep, etatl);
		  planning.add(l);
	  
	  }
	 
		   return planning;
	
	
}
public ArrayList<location> getLocationApprouver() throws ClassNotFoundException, SQLException{
	ArrayList<location> liste=new ArrayList<location>();
	location l=null;
	Connection cn = null;
	cntrlCompte c=new cntrlCompte();
	   
		  cn= c.conex();
		 Statement requete = cn.createStatement();
	      ResultSet res=requete.executeQuery("select* from location where etat_location like 'non approuve'");
	      while (res.next()){
			  int id_l=res.getInt("id_location");
			  int id_b=res.getInt("id_bien");
			  Date dated=res.getDate("date_debut");
			  Date datef=res.getDate("date_fin");
			  String modep=res.getString("mode_pay");
			  String etatl=res.getString("etat_location");
			   l=new location(id_l, id_b,dated, datef, modep, etatl);
			  liste.add(l);
		  
		  }
		   
			   return liste;
		
		
	}
	   public int  getLocataireid(int id_location) throws ClassNotFoundException, SQLException{
		
		   Connection cn = null;
		   int id=0;
			cntrlCompte c=new cntrlCompte();
			  
				  cn= c.conex();
				 Statement requete = cn.createStatement();
			      ResultSet res=requete.executeQuery("select * from facture where id_location="+id_location);
			      if(res.next()){
			    	   id=res.getInt("id_personne");
			    	//  System.out.println(id);
			    	  
			   
			      }
			      
			  
				   return id;
			
	   }
	   public int  getBienid(int id_location) throws ClassNotFoundException, SQLException{
			
		   Connection cn = null;
		   int id=0;
			cntrlCompte c=new cntrlCompte();
			   
				  cn= c.conex();
				 Statement requete = cn.createStatement();
				 Statement requete2 = cn.createStatement();
			      ResultSet res=requete.executeQuery("select id_bien from location where id_location="+id_location);
			      if(res.next()){
			    	   id=res.getInt("id_bien");
			    	//  System.out.println(id);
			    	  
			   
			      }
			      
			  
				   return id;
			
	   }
	   public String getLocataire(int id_personne) throws ClassNotFoundException, SQLException{
		   String locataire=null;
		   Connection cn = null;
		  
			cntrlCompte c=new cntrlCompte();
			  
				  cn= c.conex();
				 Statement requete = cn.createStatement();
				 ResultSet res2=requete.executeQuery("select * from personne where id_personne="+id_personne);
		    	  
		    	  if(res2.next()){
			    	  locataire=""+res2.getString("nom")+" "+res2.getString("prenom");
			    	//  system.out.println(locataire);
			      }
			   
				   return locataire;
			
	   }
	   public void approuverLocation(int id_location) throws ClassNotFoundException, SQLException{
		   Connection cn = null;
			  
			cntrlCompte c=new cntrlCompte();
			   
				  cn= c.conex();
				 Statement requete = cn.createStatement();
				 int nbs=requete.executeUpdate("update location set etat_location='approuve' where id_location="+id_location);
				 
			 
	   }
	   public void refuserLocation(int id_location) throws ClassNotFoundException, SQLException{
	   Connection cn = null;
			  
			cntrlCompte c=new cntrlCompte();
			 
				  cn= c.conex();
				 Statement requete = cn.createStatement();
				 int nbs=requete.executeUpdate("delete from location where id_location="+id_location);
				 
			  }
	   public void suppFacture(int id_location) throws ClassNotFoundException, SQLException{
		   Connection cn = null;
				  
				cntrlCompte c=new cntrlCompte();
				  
					  cn= c.conex();
					 Statement requete = cn.createStatement();
					 int nbs=requete.executeUpdate("delete from facture where id_location="+id_location);
					 
				  }
	   public void setFacture(int id_location,Date date_pay) throws ClassNotFoundException, SQLException{
		   Connection cn = null;
		   
			  
			cntrlCompte c=new cntrlCompte();
			 
				  cn= c.conex();
				 Statement requete = cn.createStatement();
				 int nbs=requete.executeUpdate("update facture  set date_pay='"+date_pay+"' where id_location="+id_location);
				 
	   }

 
public int getId_location() {
	return id_location;
}
public void setId_location(int id_location) {
	this.id_location = id_location;
}
public int getId_bien() {
	return id_bien;
}
public void setId_bien(int id_bien) {
	this.id_bien = id_bien;
}

public Date getDate_debut() {
	return date_debut;
}
public void setDate_debut(Date date_debut) {
	this.date_debut = date_debut;
}
public Date getDate_fin() {
	return date_fin;
}
public void setDate_fin(Date date_fin) {
	this.date_fin = date_fin;
}
public String getMode_pay() {
	return mode_pay;
}
public void setMode_pay(String mode_pay) {
	this.mode_pay = mode_pay;
}
public String getEtat_location() {
	return etat_location;
}
public void setEtat_location(String etat_location) {
	this.etat_location = etat_location;
}
public static void main(String[] args) throws ClassNotFoundException, SQLException {
location l=new location();
	System.out.println(l.getLocataireid(73));

}


}

