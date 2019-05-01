package Modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class cntrlCompte {
	operation op=new operation();

	public cntrlCompte(){
	}
	
	public Connection conex() throws ClassNotFoundException, SQLException{
		Connection con;
		        con = op.GetConnection();
		  
		    return con;
	}
	public void deconex(Connection con){
		 try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean isGradeb(int id_personne){
		cntrlCompte c=new cntrlCompte();
		Connection con=null;
		try{
			con=c.conex();
			 Statement requete = con.createStatement();
		       
		   ResultSet resultat = requete.executeQuery("select * from admin where grade like'B' and  id_personne="+id_personne);
			if(resultat.next()){
				return true;
			}
		 }catch(Exception e) {  System.out.println("Exception :"+e);  }
		  finally {
			     //D�connetion
				 c.deconex(con);
			    }
			   return false;
	    	  
	      }
	

	public void creerCompte(String cart_identite,String pseudo,String password
			,String nom,String prenom,String  email,String num_telephone) throws ClassNotFoundException, SQLException{
		
		   Connection con = conex();
		  
			   
		        Statement requete = con.createStatement();
		        int  NbIns ;
		        
		        //Execution de la requ�te
		       NbIns = requete.executeUpdate("INSERT INTO personne (cart_identite,pseudo,password,nom,prenom,email,num_telephone)VALUES ('"+cart_identite
		    		   +"','"+pseudo+"','"+password+"','"+nom+"','"+prenom+"','"+email+"','"
		    		   +num_telephone+"')");
		        System.out.println(NbIns+" ligne ins�r�e");
		   
		  
	}
	public void creerAdmin(int id_personne) throws ClassNotFoundException, SQLException{
		
		   Connection c = null;
		 
			  c= conex();
			 Statement requete = c.createStatement();
		       int NbIns = requete.executeUpdate("INSERT INTO admin  VALUES ("+id_personne+", 'B')");
		        System.out.println(NbIns+" ligne ins�r�e");
		   
		 
	}
	public boolean verfiferPseudo(String pseudo) throws ClassNotFoundException, SQLException{
		Connection con = null;
		boolean b=false;
		cntrlCompte cn=new cntrlCompte();
		
			con=cn.conex();
			 Statement requete = con.createStatement();
			 ResultSet res=requete.executeQuery("select pseudo from personne");
			 while(res.next())
			 {
				 if(res.getString("pseudo").equals(pseudo)){
					 b=true; return b;
				 }
			 }
		
		return b;
	}
	public void modifierProfile(int id_personne,String nom,String prenom,String pseudo,String email,String numtlpn,String password) throws ClassNotFoundException, SQLException{
		Connection con = null;
	
		cntrlCompte cn=new cntrlCompte();
			con=cn.conex();
			 Statement requete = con.createStatement();
			 int n=requete.executeUpdate("update personne set nom='"+nom+"',prenom='"+prenom+"',pseudo='"+pseudo+"',email='"+email+"',num_telephone='"+numtlpn+"',password='"+password+"' where id_personne="+id_personne);
		
	}
	
	public boolean hasLocation(int id_personne) throws ClassNotFoundException, SQLException{
		boolean has=false;
		   Connection con = conex();
		  
			   
		        Statement requete = con.createStatement();
		        //Execution de la requ�te
		   ResultSet  resultat = requete.executeQuery("select*  from facture  where id_personne ="+id_personne);
	       
		   if(resultat.next()){
			   has=true;
			   return has;
		                       } 
		   
		   return has;
	}
	public ArrayList<Integer>getIdLocation(int id_personne) throws ClassNotFoundException, SQLException{
		ArrayList<Integer> liste= new ArrayList<Integer>();
	
		   Connection con = conex();
		  
			  
		        Statement requete = con.createStatement();
		        //Execution de la requ�te
		   ResultSet  resultat = requete.executeQuery("select*  from facture  where id_personne ="+id_personne);
	       
		   while(resultat.next()){
			   int id=resultat.getInt("id_location");
			   Integer id1=new Integer(id);
			   liste.add(id1);
		   }
				   return liste;
	}
	public boolean prochaineLoc(int id_location) throws ClassNotFoundException, SQLException{
		boolean prochaine=false;
		   Connection con = conex();
		  
		        Statement requete = con.createStatement();
		        //Execution de la requ�te
		   ResultSet  resultat = requete.executeQuery("select*  from location where id_location="+id_location+" and  (current_date"
		   		+ "<date_debut or current_date<date_fin)");
	       
		   if(resultat.next()){
			   prochaine=true;
			   return prochaine;
		                       } 
		   
		  
		   return prochaine;
	}
	public boolean verifierSupploc(int id_locataire) throws ClassNotFoundException, SQLException{
		boolean test=true;
		cntrlCompte c=new cntrlCompte();
		if(c.hasLocation(id_locataire)){
			ArrayList<Integer>l=c.getIdLocation(id_locataire);
			for(int i=0;i<l.size();i++){
				if(c.prochaineLoc(l.get(i))){
					test=false;
					return test;
				}
			}
		}
		return test;
	}
	public ArrayList<Integer> getBiens(int id_personne) throws ClassNotFoundException, SQLException{
		ArrayList<Integer>biens=new ArrayList<Integer>();
		   Connection con = conex();
		   
		Statement requet=con.createStatement();
		ResultSet resultat=requet.executeQuery("select * from bien where id_personne="+id_personne+" and etat_bien='approuve'  ");
	while(resultat.next()){
		Integer idb=new Integer(resultat.getInt("id_bien"));
		biens.add(idb);
	}
		   
	return biens;
	}
	public boolean prochaineBien(int id_bien) throws ClassNotFoundException, SQLException{
		boolean prochain=false;
		   Connection con = conex();
		 
			  
		        Statement requete = con.createStatement();
		        //Execution de la requ�te
		   ResultSet  resultat = requete.executeQuery("select*  from location where id_bien="+id_bien+" and  (current_date"
		   		+ "<date_debut or current_date<date_fin)");
	       
		   if(resultat.next()){
			   prochain=true;
			   return prochain;
		                       } 
		
		   return prochain;
	}
	public boolean verifiersuppPro(int id_personne) throws ClassNotFoundException, SQLException{
		boolean supp=true;
	ArrayList<Integer>l=getBiens(id_personne);
	for(int i=0;i<l.size();i++){
		if(prochaineBien(l.get(i)))
				{
			supp=false;
			return supp;
			
				}
	}
	return supp;
	}
	public void suppBienPro(int id_personne) throws ClassNotFoundException, SQLException{	
	ArrayList<Integer>l=getBiens(id_personne);
	 Connection c = null;
	  
		  c= conex();
		 Statement requete = c.createStatement();
			for(int i=0;i<l.size();i++){
				
		 int NbIns = requete.executeUpdate("update bien set etat_bien='supprime' where id_personne="+id_personne);
		  System.out.println(NbIns+" ligne ins�r�e");	
				
				
			}
	      
	   
	
	}
	public void supprimerLocataire(int id_personne) throws ClassNotFoundException, SQLException{
		   Connection con = conex();
		  
		Statement requet=con.createStatement();
		int resultat=requet.executeUpdate("update locataire set etat_locataire='supprime' where id_personne="+id_personne);
	System.out.println(resultat);
		   }
	

	
	public void supprimerProprietaire(int id_personne) throws ClassNotFoundException, SQLException{
		   Connection con = conex();
		  
		Statement requet=con.createStatement();
		int resultat=requet.executeUpdate("update proprietaire set type_pro='supprime' where id_personne="+id_personne);
	System.out.println(resultat);
		  
	

	}
	
	public boolean verifierNumTlpn(String num_telephone ){
		cntrlCompte c=new cntrlCompte();
	boolean b=false;
		Connection con = null;
		   try {
			   con=c.conex();
			   Statement requete=con.createStatement();
			   ResultSet res=requete.executeQuery("select* from personne where num_telephone='"+num_telephone+"'" );
			   if(res.next()){
				   b=true ;
				   return b;
			   }
		   }
			  catch(Exception e) {  System.out.println(e);  }
			  finally {
			     try {
			    	 //D�connetion
			    	 con.close();}
			    catch(SQLException e) {e.printStackTrace();}
			     
	}
		   return b;
	}
	public boolean verifierCarte(String cart_identite ){
		cntrlCompte c=new cntrlCompte();
	boolean b=false;
		Connection con = null;
		   try {
			   con=c.conex();
			   Statement requete=con.createStatement();
			   ResultSet res=requete.executeQuery("select* from personne where cart_identite= '"+cart_identite+"'" );
			   if(res.next()){
				   b=true ;
				   return b;
			   }
		   }
			  catch(Exception e) {  System.out.println(e);  }
			  finally {
			     try {
			    	 //D�connetion
			    	 con.close();}
			    catch(SQLException e) {e.printStackTrace();}
			     
	}
		   return b;
	}
	public boolean verifierEmail(String email ){
		cntrlCompte c=new cntrlCompte();
	boolean b=false;
		Connection con = null;
		   try {
			   con=c.conex();
			   Statement requete=con.createStatement();
			   ResultSet res=requete.executeQuery("select* from personne where email='"+email+"'" );
			   if(res.next()){
				   b=true ;
				   return b;
			   }
		   }
			  catch(Exception e) {  System.out.println(e);  }
			  finally {
			     try {
			    	 //D�connetion
			    	 con.close();}
			    catch(SQLException e) {e.printStackTrace();}
			     
	}
		   return b;
	}
	public String getPhoto(int id_personne ){
		cntrlCompte c=new cntrlCompte();
	String p=null;
		Connection con = null;
		   try {
			   con=c.conex();
			   Statement requete=con.createStatement();
			   ResultSet res=requete.executeQuery("select image from personne where id_personne="+id_personne+"" );
			   if(res.next()){
				p=res.getString("image");
			   }
		   }
			  catch(Exception e) {  System.out.println(e);  }
			  finally {
			     try {
			    	 //D�connetion
			    	 con.close();}
			    catch(SQLException e) {e.printStackTrace();}
			     
	}
		   return p;
	}
	public void modifierphoto(int id_personne,String img){
		cntrlCompte c=new cntrlCompte();
		String p=null;
			Connection con = null;
			   try {
				   con=c.conex();
				   Statement requete=con.createStatement();
				   int res=requete.executeUpdate("update personne set image='"+img+"' where id_personne="+id_personne);
			   }
				  catch(Exception e) {  System.out.println(e);  }
				  finally {
				     try {
				    	 //D�connetion
				    	 con.close();}
				    catch(SQLException e) {e.printStackTrace();}
				     
		}
		
	}
	public boolean attributNull(String nom,String prenom,String carte_identite,String email,String num_telephone){
		boolean b=false;
		if((nom.equals(""))||(prenom.equals(""))||(carte_identite.equals(""))||(email.equals(""))||(num_telephone.equals(""))){
			b=true;
		}
		return b;
	}
	public boolean pseudopassnull(String pseudo,String password){
		boolean b=false;
		if((pseudo.equals(""))||(password.equals(""))){
			b=true;
		}
		return b;
	}
	public int getproprietaire(String pseudo){
		int id=0;
		Connection con=null;
		cntrlCompte c=new cntrlCompte();
		try{
		con=c.conex();
		Statement requete=con.createStatement();
		   ResultSet res=requete.executeQuery("select id_personne from personne where pseudo like '"+pseudo+"'");
		   if(res.next()){
			   id=res.getInt("id_personne");
			   return id;
		   }
	   }
		  catch(Exception e) {  System.out.println(e);  }
		  finally {
		     try {
		    	 //D�connetion
		    	 con.close();}
		    catch(SQLException e) {e.printStackTrace();}
		     
}
	   return id;
		}
	public ArrayList<personne> getProfile(int id_personne) throws ClassNotFoundException, SQLException{
		Connection con=null;
		ArrayList<personne> list=new ArrayList<personne>();
		personne p=null;
		cntrlCompte c=new cntrlCompte();
		
		con=c.conex();
		Statement requete=con.createStatement();
		   ResultSet res=requete.executeQuery("select* from personne where id_personne="+id_personne);
		   if(res.next()){
			   int idp=res.getInt("id_personne");
			   String pseudo=res.getString("pseudo");
			   String password=res.getString("password");
			   String email=res.getString("email");
			   String numtelepn=res.getString("num_telephone");
			   String carte_identite=res.getString("cart_identite");
			   String nom=res.getString("nom");
			   String prenom=res.getString("prenom");
			   p=new personne(idp, carte_identite, pseudo, password, nom, prenom, email, numtelepn);
			  list.add(p) ;
			   
		  
		
		     
} return list;
		
	}
	



	public boolean verifierCompte(String pseudo,String password) throws ClassNotFoundException, SQLException{
		boolean test=false;
		Connection con=op.GetConnection();
		        Statement requete = con.createStatement();
		        //Execution de la requ�te
		   ResultSet resultat = requete.executeQuery("select * from personne ");
	       //Parcourir les enregistrements
		   while(resultat.next()){
			   
		        if (resultat.getString("pseudo").equals(pseudo)||resultat.getString("password").equals(password)) {
		       test=true;
		   return test;
		        }
		        
		   }
		 
		   return test;
		
	}
	
	
	public void creerLocataire(int id_personne) throws ClassNotFoundException, SQLException{
		   Connection con = null;
		  
			  con=op.GetConnection();
		        Statement requete = con.createStatement();
		        int  NbIns ;
		      
		        //Execution de la requ�te
		       NbIns = requete.executeUpdate("INSERT INTO locataire VALUES ("+id_personne+",'approuve')");
		        System.out.println(NbIns+" ligne ins�r�e");
		   
		 
	}
	public void creerProprietaire(int id_personne,String type_pro,int points) throws ClassNotFoundException, SQLException{
		   Connection con = null;
		 
			  con=op.GetConnection();
		        Statement requete = con.createStatement();
		        int  NbIns ;
		        //Execution de la requ�te
		        System.out.println(""+"INSERT INTO proprietaire VALUES ("+id_personne+",'"+type_pro+"',"+points+")");

		       NbIns = requete.executeUpdate("INSERT INTO proprietaire VALUES ("+id_personne+",'"+type_pro+"',"+points+")");
		        System.out.println(NbIns+" ligne ins�r�e");
		  
		  }
	
	
	
	
	

	
	
	
	
	public void changePasse(int id_personne){
		   Connection con = null;
		   try {
			  con=op.GetConnection();
		Statement requet=con.createStatement();
		int resultat=requet.executeUpdate("update personne set password='supprime' where id_personne="+id_personne);
	System.out.println(resultat);
		   }
			  catch(Exception e) {  System.out.println(e);  }
			
	}
	

}
