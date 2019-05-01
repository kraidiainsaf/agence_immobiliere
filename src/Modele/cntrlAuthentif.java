package Modele;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class cntrlAuthentif {
	public cntrlAuthentif(){}
	operation op=new operation();
	Connection con=null;
	public boolean verifierAuth(String psd,String pw){
		boolean b=false;
		   try {

		   Connection con = op.GetConnection();
			 
		        Statement requete = con.createStatement();
		   ResultSet resultat = requete.executeQuery("select * from personne ");
		   while(resultat.next()){			   
		        if (resultat.getString("pseudo").equals(psd)&&resultat.getString("password").equals(pw)) {
		       
		        	b=true;
		        	 return b;
		                       }
		        
		   }}
		  catch(Exception e) {  System.out.println("Exception problem");  }
		  
		   return b;
	}
public int getId(String psd,String pw) throws ClassNotFoundException, SQLException{
	int id = 0;
	  Connection con = op.GetConnection();
	   try {
	        Statement requete = con.createStatement();
	        //Execution de la requ�te
	   ResultSet resultat = requete.executeQuery("select * from personne ");
          //Parcourir les enregistrements
	   while(resultat.next()){
		   
	        if (resultat.getString("pseudo").equals(psd)&&resultat.getString("password").equals(pw)) {
	       id=resultat.getInt("id_personne");
	        	 return id;
	                       }
	   }}
	  catch(Exception e) {  System.out.println("Exception problem");  }
	  finally {
	     try {
	    	 //D�connetion
	    	 con.close();}
	    catch(SQLException e) {e.printStackTrace();}}
	   return id;
}
public boolean isAdmin(int id) throws ClassNotFoundException, SQLException{
	boolean answer=false;
	  Connection con = op.GetConnection();
	   try {
	        Statement requete = con.createStatement();
	        //Execution de la requ�te
	   ResultSet resultat = requete.executeQuery("select * from admin ");
          //Parcourir les enregistrements
	   while(resultat.next()){
		   
	        if (resultat.getInt("id_personne")==id) {
	       answer=true;
	   return answer;
	                       }
	        
	   }}
	  catch(Exception e) {  System.out.println("Exception problem");  }
	
	   return answer;
	
}
public boolean isProprietaire(int id) throws ClassNotFoundException, SQLException{
	boolean answer=false;
	  Connection con = op.GetConnection();

	 
		  
	        Statement requete = con.createStatement();
	        //Execution de la requ�te
	   ResultSet resultat = requete.executeQuery("select * from proprietaire where type_pro not like 'supprime' ");
          //Parcourir les enregistrements
	   while(resultat.next()){
		   
	        if (resultat.getInt("id_personne")==id) {
	       answer=true;}}
	   return answer;
	                       
	   
}
public boolean isSuppLoc(int id_personne) throws SQLException{
	boolean test=false;
	
	   Connection c1 = null;
	   try {
		  c1= op.GetConnection();
		 Statement requete = c1.createStatement();
	     ResultSet resultat= requete.executeQuery("select * from locataire where id_personne="+id_personne);
	     while(resultat.next()){
	       if(resultat.getString("etat_locataire").equals("supprimer")){
	    	   test=true;
	       }
	   }}
	  catch(Exception e) {  System.out.println("Exception :"+e);  }
	  finally {
	     //D�connetion
		c1.close();
	    }
	   return test;
}
//insaf nouvelle methode

public boolean isSuppPro(int id_personne) throws SQLException, ClassNotFoundException{
	boolean test=false;
	
	   Connection c1 = null;
	  
		  c1= op.GetConnection();
		 Statement requete = c1.createStatement();
	     ResultSet resultat= requete.executeQuery("select * from proprietaire where id_personne="+id_personne+" and type_pro like 'supprime'");
	     if(resultat.next()){
	      
	    	   test=true;
	       }
	  
	   return test;
}
public boolean isLocataire(int id) throws ClassNotFoundException, SQLException{
	boolean answer=false;
	  Connection con = op.GetConnection();

		  
	        Statement requete = con.createStatement();
	        //Execution de la requ�te
	   ResultSet resultat = requete.executeQuery("select * from locataire where etat_locataire not like 'supprime' ");
          //Parcourir les enregistrements
	   while(resultat.next()){
		   
	        if (resultat.getInt("id_personne")==id) {
	       answer=true;
	        }
	                       }
	 
	   return answer;
	
}}