package Modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class bien {
	private int id_bien;
	private int id_personne;
	private double superficie;
	private int wilaya;
	private double prix;
	private String description ;
	private String adresse;
	private String etat_bien;
	private int max_colocataire;	
	private String image1;
	private String image2;
	private String image3;
	private String image4;
	private String image5;
	private String ajoute1;
	private String ajoute2;
	private String ajoute3;
	private String ajoute4;
	private String ajoute5;
	

	
	public bien(int id_bien, int id_personne, double superficie, int wilaya, double prix, String description, String adresse,
			String etat_bien,int max_colocataire, String image1, String image2, String image3, String image4, String image5,String ajoute1, String ajoute2, String ajoute3, String ajoute4, String ajoute5) {
		
		this.id_bien = id_bien;
		this.id_personne = id_personne;
		this.superficie = superficie;
		this.wilaya = wilaya;
		this.prix = prix;
		this.description = description;
		this.adresse = adresse;
		this.etat_bien = etat_bien;
		this.max_colocataire=max_colocataire;
		this.image1 = image1;
		this.image2 = image2;
		this.image3 = image3;
		this.image4 = image4;
		this.image5 = image5;
		this.ajoute1 = ajoute1;
		this.ajoute2 = ajoute2;
		this.ajoute3 = ajoute3;
		this.ajoute4 = ajoute4;
		this.ajoute5 = ajoute5;
	}
	
	
	public String getAjoute1() {
		return ajoute1;
	}

	public void setAjoute1(String ajoute1) {
		this.ajoute1 = ajoute1;
	}

	public String getAjoute2() {
		return ajoute2;
	}

	public void setAjoute2(String ajoute2) {
		this.ajoute2 = ajoute2;
	}

	public String getAjoute3() {
		return ajoute3;
	}

	public void setAjoute3(String ajoute3) {
		this.ajoute3 = ajoute3;
	}

	public String getAjoute4() {
		return ajoute4;
	}

	public void setAjoute4(String ajoute4) {
		this.ajoute4 = ajoute4;
	}

	public String getAjoute5() {
		return ajoute5;
	}

	public void setAjoute5(String ajoute5) {
		this.ajoute5 = ajoute5;
	}

	public bien(String ajoute1, String ajoute2, String ajoute3, String ajoute4, String ajoute5) {
		super();
		this.ajoute1 = ajoute1;
		this.ajoute2 = ajoute2;
		this.ajoute3 = ajoute3;
		this.ajoute4 = ajoute4;
		this.ajoute5 = ajoute5;
	}
	public bien() {
	
	}
	public bien(int id_bien, int id_personne, double superficie, int wilaya, double prix, String description, String adresse,
			String etat_bien,int max_colocataire, String image1, String image2, String image3, String image4, String image5) {
		
		this.id_bien = id_bien;
		this.id_personne = id_personne;
		this.superficie = superficie;
		this.wilaya = wilaya;
		this.prix = prix;
		this.description = description;
		this.adresse = adresse;
		this.etat_bien = etat_bien;
		this.max_colocataire=max_colocataire;
		this.image1 = image1;
		this.image2 = image2;
		this.image3 = image3;
		this.image4 = image4;
		this.image5 = image5;
	}
	
	public bien(int id_bien2, double superficie2, double prix2, String description2, int max_colocataire2) {
	this.id_bien=id_bien2;
	this.superficie=superficie2;
	this.prix=prix2;
	this.description=description2;
	this.max_colocataire=max_colocataire2;
		// TODO Auto-generated constructor stub
	}

	public int getMax_colocataire() {
		return max_colocataire;
	}

	public void setMax_colocataire(int max_colocataire) {
		this.max_colocataire = max_colocataire;
	}

	public int getId_bien() {
		return id_bien;
	}
	public void setId_bien(int id_bien) {
		this.id_bien = id_bien;
	}
	public int getId_personne() {
		return id_personne;
	}
	public void setId_personne(int id_personne) {
		this.id_personne = id_personne;
	}
	public double getSuperficie() {
		return superficie;
	}
	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}
	public int getWilaya() {
		return wilaya;
	}
	public void setWilaya(int wilaya) {
		this.wilaya = wilaya;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public String getdescription() {
		return description;
	}
	public void setdescription(String description) {
		this.description = description;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getEtat_bien() {
		return etat_bien;
	}
	public void setEtat_bien(String etat_bien) {
		this.etat_bien = etat_bien;
	}
	public String getImage1() {
		return image1;
	}
	public void setImage1(String image1) {
		this.image1 = image1;
	}
	public String getImage2() {
		return image2;
	}
	public void setImage2(String image2) {
		this.image2 = image2;
	}
	public String getImage3() {
		return image3;
	}
	public void setImage3(String image3) {
		this.image3 = image3;
	}
	public String getImage4() {
		return image4;
	}
	public void setImage4(String image4) {
		this.image4 = image4;
	}
	public String getImage5() {
		return image5;
	}
	public void setImage5(String image5) {
		this.image5 = image5;
	}
	
	public String getimg1(int id_bien){
		cntrlCompte c=new cntrlCompte();
	String mg=null;
		 Connection cn = null;
		   try {
			  cn= c.conex();
			 Statement requete = cn.createStatement();
		      ResultSet res=requete.executeQuery("select image1 from bien where id_bien="+id_bien);
		      if (res.next()){
		    	 mg=res.getString("image1"); }}
		      
		      catch(Exception e) {  System.out.println("Exception :"+e);  }
			  finally {
			     //D�connetion
				 c.deconex(cn);
			    }
		  
		return mg;
	}
	public String getimg2(int id_bien){
		cntrlCompte c=new cntrlCompte();
	String mg=null;
		 Connection cn = null;
		   try {
			  cn= c.conex();
			 Statement requete = cn.createStatement();
		      ResultSet res=requete.executeQuery("select image2 from bien where id_bien="+id_bien);
		      if (res.next()){
		    	 mg=res.getString("image2"); }}
		      
		      catch(Exception e) {  System.out.println("Exception :"+e);  }
			  finally {
			     //D�connetion
				 c.deconex(cn);
			    }
		  
		return mg;
	}
	public String getimg3(int id_bien){
		cntrlCompte c=new cntrlCompte();
	String mg=null;
		 Connection cn = null;
		   try {
			  cn= c.conex();
			 Statement requete = cn.createStatement();
		      ResultSet res=requete.executeQuery("select image3 from bien where id_bien="+id_bien);
		      if (res.next()){
		    	 mg=res.getString("image3"); }}
		      
		      catch(Exception e) {  System.out.println("Exception :"+e);  }
			  finally {
			     //D�connetion
				 c.deconex(cn);
			    }
		  
		return mg;
	}
	public String getimg4(int id_bien){
		cntrlCompte c=new cntrlCompte();
	String mg=null;
		 Connection cn = null;
		   try {
			  cn= c.conex();
			 Statement requete = cn.createStatement();
		      ResultSet res=requete.executeQuery("select image4 from bien where id_bien="+id_bien);
		      if (res.next()){
		    	 mg=res.getString("image4"); }}
		      
		      catch(Exception e) {  System.out.println("Exception :"+e);  }
			  finally {
			     //D�connetion
				 c.deconex(cn);
			    }
		  
		return mg;
	}
	public String getimg5(int id_bien){
		cntrlCompte c=new cntrlCompte();
	String mg=null;
		 Connection cn = null;
		   try {
			  cn= c.conex();
			 Statement requete = cn.createStatement();
		      ResultSet res=requete.executeQuery("select image5 from bien where id_bien="+id_bien);
		      if (res.next()){
		    	 mg=res.getString("image5"); }}
		      
		      catch(Exception e) {  System.out.println("Exception :"+e);  }
			  finally {
			     //D�connetion
				 c.deconex(cn);
			    }
		  
		return mg;
	}
}
