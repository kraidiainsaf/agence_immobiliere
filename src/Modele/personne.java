package Modele;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import java.sql.Statement;


public class personne {
	private int id_personne;
	private String cart_identite;
	private String pseudo;
	private String password;
	private String nom;
	private String prenom;
	private String email;
	private String num_telephone;
	private String  image;
	public personne( int id_personne){
		this.id_personne=id_personne;
	}
	public personne(int id_personne, String cart_identite, String pseudo, String password, String nom, String prenom,String email, String num_telephone,String image) {
		this.id_personne = id_personne;
		this.cart_identite = cart_identite;
		this.pseudo = pseudo;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.num_telephone = num_telephone;
		this.image=image;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public personne(int id_personne, String cart_identite, String pseudo, String password, String nom, String prenom,String email, String num_telephone) {
		this.id_personne = id_personne;
		this.cart_identite = cart_identite;
		this.pseudo = pseudo;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.num_telephone = num_telephone;
	}
	public int getId_personne() {
		return id_personne;
	}
	public void setId_personne(int id_personne) {
		this.id_personne = id_personne;
	}
	public String getCart_identite() {
		return cart_identite;
	}
	public void setCart_identite(String cart_identite) {
		this.cart_identite = cart_identite;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNum_telephone() {
		return num_telephone;
	}
	public void setNum_telephone(String num_telephone) {
		this.num_telephone = num_telephone;
	}
	public personne(String pseudo,String password){
		this.pseudo=pseudo;
		this.password=password;
	}
	
	public personne(){}
	public personne (int id_personne,String pseudo){
		this.id_personne=id_personne;
		this.pseudo=pseudo;
	}
	public personne(int id,String email2, String num_tlf, String image2) {
		this.id_personne=id;
		this.email=email2;
		this.num_telephone=num_tlf;
		this.image=image2;
	}
	public ArrayList<String> getNames() throws ClassNotFoundException, SQLException{
		ArrayList <String> names=new ArrayList();
		cntrlCompte c=new cntrlCompte();
		Connection con = null;
		
			con = c.conex();
			  Statement requete = con.createStatement();
		        Statement requete1 = con.createStatement();
		        Statement requete2 = con.createStatement();
		        //Execution de la requ�te
		        ResultSet res1=requete1.executeQuery("select * from personne,locataire"
		        		+ " where personne.id_personne=locataire.id_personne"
		        		+ " and etat_locataire not like 'supprime'");
		        while (res1.next()) {
        names.add( res1.getString("pseudo"));	   
		        		}
		        ResultSet res2=requete2.executeQuery("select* from personne,proprietaire"
		        		+ " where personne.id_personne=proprietaire.id_personne"
		        		+ " and type_pro not like 'supprime'");
		        while (res2.next()) {
		            names.add( res2.getString("pseudo"));	   
		  		        		}  
		        ResultSet res3=requete.executeQuery("select * from personne,admin  "
		        		+ " where personne.id_personne=admin.id_personne");
		        while(res3.next()){
		        	names.add(res3.getString("pseudo"));
		        }
		
		  return names;  }
	public ArrayList<personne> getlist() throws ClassNotFoundException, SQLException{
		ArrayList <personne> list=new ArrayList();
		cntrlCompte ct=new cntrlCompte();
		   Connection con = ct.conex();
		 
		        Statement requete = con.createStatement();
		        //Execution de la requ�te
		   ResultSet resultat = requete.executeQuery("select * from personne");
                    //Parcourir les enregistrements
		        while (resultat.next()) {
		        	
		        	personne p=new personne(resultat.getString("id_personne"),resultat.getString("pseudo"));
                  		boolean n=list.add(p);
          
		                      
		                       }
		  
		  return list;  }
	public String getpseudo(){
		return pseudo;
	}
	public ArrayList<String> getNamesSupp() throws ClassNotFoundException, SQLException{
		ArrayList <String> names=new ArrayList();
		cntrlCompte ct=new cntrlCompte();
		   Connection con = ct.conex();
		 
		
		        Statement requete = con.createStatement();
		        Statement requete1 = con.createStatement();
		        Statement requete2 = con.createStatement();
		        //Execution de la requ�te
		        ResultSet res1=requete1.executeQuery("select * from personne,locataire"
		        		+ " where personne.id_personne=locataire.id_personne"
		        		+ " and etat_locataire not like 'supprime'");
		        while (res1.next()) {
        String l=   res1.getString("pseudo");
       // System.out.println(l);
        names.add(l);
		        		}
		       
		   
		  return names;  }
	public ArrayList<String> getNamesSuppPro() throws ClassNotFoundException, SQLException{
		ArrayList <String> names=new ArrayList();
		cntrlCompte ct=new cntrlCompte();
		   Connection con = ct.conex();
		        Statement requete2 = con.createStatement();
		       
		       
		        ResultSet res2=requete2.executeQuery("select* from personne,proprietaire"
		        		+ " where personne.id_personne=proprietaire.id_personne"
		        		+ " and type_pro not like 'supprime'");
		        while (res2.next()) {
		           String p=res2.getString("pseudo");	  
		          // System.out.println(p);
		           names.add(p);
		  		        		}  
		 
		  return names;  }
	public boolean ispers(int id_personne) throws ClassNotFoundException, SQLException {
		boolean test=false;
		cntrlCompte ct=new cntrlCompte();
		   Connection con = ct.conex();
		        Statement requete2 = con.createStatement();
		       
		       
		        ResultSet res2=requete2.executeQuery("select id_personne from personne where id_personne not IN(( select id_personne from proprietaire where type_pro not like 'supprime' and id_personne="+id_personne+")or (select id_personne from locataire where etat_locataire not like 'supprime' and id_personne="+id_personne+"))and(id_personne="+id_personne+")");
		        if (res2.next()) {
		        	test=true;
		        }
		        return test;
		        		
	}


}
