package Modele;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class cntrlBien {
	operation op=new operation();
 public cntrlBien(){}




 public String text(String b){
	 String tex=b;
	 if(b==null||b.equals("0")){
		 tex="non";
		return tex; 
	 }else{
		 tex="oui";
	 }
	 return tex;
 }
 public String getAjout1(int id_bien) throws ClassNotFoundException, SQLException{
	 cntrlCompte c=new cntrlCompte(); 
	 Connection cn = null;
	 String ajout=null;
	  
		  cn= c.conex();
		 Statement requete = cn.createStatement();
	      ResultSet res=requete.executeQuery("select ajout1 from bien where id_bien="+id_bien);
	      if(res.next()){
	    	  ajout=res.getString("ajout1");}
	      
			   return ajout;
	    	  
	      }
 public String getAjout2(int id_bien) throws ClassNotFoundException, SQLException{
	 cntrlCompte c=new cntrlCompte(); 
	 Connection cn = null;
	 String ajout=null;
	  
		  cn= c.conex();
		 Statement requete = cn.createStatement();
	      ResultSet res=requete.executeQuery("select ajout2 from bien where id_bien="+id_bien);
	      if(res.next()){
	    	  ajout=res.getString("ajout2");}
	     
			   return ajout;
	    	  
	      }
 public String getAjout3(int id_bien) throws ClassNotFoundException, SQLException{
	 cntrlCompte c=new cntrlCompte(); 
	 Connection cn = null;
	 String ajout=null;
	  
		  cn= c.conex();
		 Statement requete = cn.createStatement();
	      ResultSet res=requete.executeQuery("select ajout3 from bien where id_bien="+id_bien);
	      if(res.next()){
	    	  ajout=res.getString("ajout3");}
	     
			   return ajout;
	    	  
	      }
 public String getAjout4(int id_bien) throws ClassNotFoundException, SQLException{
	 cntrlCompte c=new cntrlCompte(); 
	 Connection cn = null;
	 String ajout=null;
	   
		  cn= c.conex();
		 Statement requete = cn.createStatement();
	      ResultSet res=requete.executeQuery("select ajout4 from bien where id_bien="+id_bien);
	      if(res.next()){
	    	  ajout=res.getString("ajout4");}
	      
			   return ajout;
	    	  
	      }
 public String getAjout5(int id_bien) throws ClassNotFoundException, SQLException{
	 cntrlCompte c=new cntrlCompte(); 
	 Connection cn = null;
	 String ajout=null;
	   
		  cn= c.conex();
		 Statement requete = cn.createStatement();
	      ResultSet res=requete.executeQuery("select ajout5 from bien where id_bien="+id_bien);
	      if(res.next()){
	    	  ajout=res.getString("ajout5");}
	      
			   return ajout;
	    	  
	      }
public ArrayList<bien> getListBien() throws ClassNotFoundException, SQLException{
	ArrayList<bien> biens=new ArrayList<bien>();
	cntrlCompte c=new cntrlCompte();
	cntrlBien b=new cntrlBien();
	 Connection cn = null;
	  
		  cn= c.conex();
		 Statement requete = cn.createStatement();
	      ResultSet res=requete.executeQuery("select* from bien where etat_bien like 'approuve'" );
	      while (res.next()){
	    	 
	    	  int id_bien=res.getInt("id_bien");
	    	  if(!(b.estLoue(id_bien))){
	    	  double superficie=res.getDouble("superficie");
	    	  double prix=res.getDouble("prix");
	    	  String description=res.getString("description");
	    	  int max_colocataire=res.getInt("max_colocataire");
	    	  bien bien=new bien(id_bien, superficie, prix, description, max_colocataire);
	    	  biens.add(bien);}
	      }
	  
	   return biens;
}
public String getProprietaire(int id_bien) throws ClassNotFoundException, SQLException{
	cntrlCompte c=new cntrlCompte();
	String name=null;
	 Connection cn = null;
	  
		  cn= c.conex();
		 Statement requete = cn.createStatement();
		 Statement requete1 = cn.createStatement();
	      ResultSet res=requete.executeQuery("select id_personne from bien where id_bien="+id_bien );
	      if (res.next()){
	    	int id=  res.getInt("id_personne");
	    	ResultSet res1=requete1.executeQuery("select pseudo from personne where id_personne="+id );
	    	 if (res1.next()){
	    		 name=res1.getString("pseudo");
	    	 }
	    	
	      }
	   
		   return name;
}
public void modifierBien(int id_bien,double superficie,double prix,String description,int max_colocataire) throws ClassNotFoundException, SQLException{
	cntrlCompte c=new cntrlCompte();
	 Connection cn = null;
	
		  cn= c.conex();
		 Statement requete = cn.createStatement();
	      int res=requete.executeUpdate("update bien set superficie="+superficie+", prix="+prix+", "+"description='"+description+"',max_colocataire="+max_colocataire+" where id_bien="+id_bien);
	  
}
public void modifierImage(int id_bien,String image1,String image2,String image3,String image4,String image5) throws ClassNotFoundException, SQLException{
	cntrlCompte c=new cntrlCompte();
	 Connection cn = null;
	
		  cn= c.conex();
		 Statement requete = cn.createStatement();
	      int res=requete.executeUpdate("update bien set image1='"+image1+"', image2='"+image2+"', "+"image3='"+image3+"',image4='"+image4+"' ,image5='"+image5+"' where id_bien="+id_bien);
	   
	   System.out.println("update bien set image1='"+image1+"', image2='"+image2+"', "+"image3='"+image3+"',image4='"+image4+"' ,image5='"+image5+"' where id_bien="+id_bien);
	   
	   }
public void approuverBien(int id_bien) throws ClassNotFoundException, SQLException{
	cntrlCompte c=new cntrlCompte();
	 Connection cn = null;
	  
		  cn= c.conex();
		 Statement requete = cn.createStatement();
	      int res=requete.executeUpdate("update bien set etat_bien='approuve' where id_bien="+id_bien);
	   
}
public void refuserBien(int id_bien) throws ClassNotFoundException, SQLException{
	cntrlCompte c=new cntrlCompte();
	 Connection cn = null;
	
		  cn= c.conex();
		 Statement requete = cn.createStatement();
	      int res=requete.executeUpdate(" delete from bien where id_bien="+id_bien);
	  
}

public void modifierImage1(int id_bien,String image1) throws ClassNotFoundException, SQLException{
	cntrlCompte c=new cntrlCompte();
	 Connection cn = null;
	   
		  cn= c.conex();
		 Statement requete = cn.createStatement();
		 int res=requete.executeUpdate("update bien set image1='"+image1+"' where id_bien="+id_bien);
	 System.out.println("update bien set image1='"+image1+"' where id_bien="+id_bien); 
	 
}
public void modifierImage2(int id_bien,String image2) throws ClassNotFoundException, SQLException{
	cntrlCompte c=new cntrlCompte();
	 Connection cn = null;
	  
		  cn= c.conex();
		 Statement requete = cn.createStatement();
	      int res=requete.executeUpdate("update bien set image2='"+image2+"' where id_bien="+id_bien);
	  
}
public void modifierImage3(int id_bien,String image3) throws ClassNotFoundException, SQLException{
	cntrlCompte c=new cntrlCompte();
	 Connection cn = null;
	  
		  cn= c.conex();
		 Statement requete = cn.createStatement();
	      int res=requete.executeUpdate("update bien set image3='"+image3+"' where id_bien="+id_bien);
	  
}
public void modifierImage4(int id_bien,String image4) throws ClassNotFoundException, SQLException{
	cntrlCompte c=new cntrlCompte();
	 Connection cn = null;
	  
		  cn= c.conex();
		 Statement requete = cn.createStatement();
	      int res=requete.executeUpdate("update bien set image4='"+image4+"'where id_bien="+id_bien);
	   
}
public void modifierImage5(int id_bien,String image5) throws ClassNotFoundException, SQLException{
	cntrlCompte c=new cntrlCompte();
	 Connection cn = null;
	  
		  cn= c.conex();
		 Statement requete = cn.createStatement();
	      int res=requete.executeUpdate("update bien set image5='"+image5+"'where id_bien="+id_bien);
	   
}
public bien getBien(int id_bien) throws ClassNotFoundException, SQLException{
	cntrlCompte c=new cntrlCompte();
	bien bien=null;
	 Connection cn = null;
	 
		  cn= c.conex();
		 Statement requete = cn.createStatement();
	      ResultSet res=requete.executeQuery("select* from bien where id_bien="+id_bien);
	      if (res.next()){
	    	  int id_bien1=res.getInt("id_bien");
	    	  double superficie=res.getDouble("superficie");
	    	  double prix=res.getDouble("prix");
	    	  String description=res.getString("description");
	    	  int max_colocataire=res.getInt("max_colocataire");
	    	   bien=new bien(id_bien1, superficie, prix, description, max_colocataire);
	   }
	  
	return bien;
}
public void approuverProp(int id_personne) throws ClassNotFoundException, SQLException{
	cntrlCompte c=new cntrlCompte();
	 Connection cn = null;
	  
		  cn= c.conex();
		 Statement requete = cn.createStatement();
	      int res=requete.executeUpdate("update proprietaire set type_pro='approuve' where id_personne="+id_personne);
	  
}
public String getTypeBien(int id_bien) throws ClassNotFoundException, SQLException{
	cntrlCompte c=new cntrlCompte();
String type=null;
	 Connection cn = null;
	 
		  cn= c.conex();
		 Statement requete1 = cn.createStatement();
		 Statement requete2 = cn.createStatement();
		 Statement requete3 = cn.createStatement();
		 Statement requete4 = cn.createStatement();
		 Statement requete5 = cn.createStatement();
		 Statement requete6 = cn.createStatement();
	      ResultSet res1=requete1.executeQuery(" select* from terrain where id_bien="+id_bien);
	      if(res1.next()){
	    	  type="terrain";
	    	  return  type;
	      }
	      ResultSet res2=requete2.executeQuery(" select* from maison where id_bien="+id_bien);
	      if(res2.next()){
	    	  type="maison";
	    	  return  type;
	      }
	      ResultSet res3=requete3.executeQuery(" select* from appartement where id_bien="+id_bien);
	      if(res3.next()){
	    	  type="appartement";
	    	  return  type;
	      }
	      ResultSet res4=requete4.executeQuery(" select* from depot where id_bien="+id_bien);
	      if(res4.next()){
	    	  type="depot";
	    	  return  type;
	      }
	      ResultSet res5=requete5.executeQuery(" select* from garage where id_bien="+id_bien);
	      if(res5.next()){
	    	  type="garage";
	    	  return  type;
	      }
	      ResultSet res6=requete1.executeQuery(" select* from locale_commercial where id_bien="+id_bien);
	      if(res6.next()){
	    	  type="locale_commercial";
	    	  return  type;
	      }
	  
	  
	return type;
}
public boolean estLoue(int id_bien) throws ClassNotFoundException, SQLException{
	boolean test=false;
	cntrlCompte c=new cntrlCompte();
	Connection con=null;
	
		con=c.conex();
		 Statement requete1 = con.createStatement();
		 ResultSet res=requete1.executeQuery("select* from location where etat_location not like 'supprime'  and id_bien="+id_bien);
		 if(res.next()){
			 test=true;
			 return test;
		 }
		 
		
	
	return test;

	
}
public ArrayList<bien> getBienSupp() throws ClassNotFoundException, SQLException{
	ArrayList<bien>liste=new ArrayList<bien>();
cntrlBien b=new cntrlBien();
	cntrlCompte c=new cntrlCompte();
	Connection con=null;
	
		con=c.conex();
		 Statement requete1 = con.createStatement();
		 ResultSet res=requete1.executeQuery("select* from bien where etat_bien not like 'supprime'  ");
		 while(res.next()){
			 if(!(b.estLoue(res.getInt("id_bien")))){
				 int id_bien=res.getInt("id_bien");
				 int id_personne=res.getInt("id_personne");
				 double superficie=res.getDouble("superficie");
				 int prix=res.getInt("prix");
				 int wilaya=res.getInt("wilaya");
				 String description=res.getString("description");
				 String adresse=res.getString("adresse");
				 int max_colocataire=res.getInt("max_colocataire");
				 String image1=res.getString("image1");
				 String image2=res.getString("image2");
				 String image3=res.getString("image3");
				 String image4=res.getString("image4");
				 String image5=res.getString("image5");
				 String etat_bien=res.getString("etat_bien");
				bien bien=new bien(id_bien, id_personne, superficie, wilaya, prix, description, adresse, etat_bien, max_colocataire, image1, image2, image3, image4, image5);		 
				 liste.add(bien);
			 }}
		
		return liste;
	
}
public void supprimerBien(int id_bien) throws ClassNotFoundException, SQLException{
	
	cntrlCompte c=new cntrlCompte();
	Connection con=null;
	
		con=c.conex();
		 Statement requete1 = con.createStatement();
		int res=requete1.executeUpdate("update bien set etat_bien='supprime' where id_bien="+id_bien);
	
	
}
public boolean lastBien(int id_personne) throws ClassNotFoundException, SQLException{
	boolean test=true;
	cntrlCompte c=new cntrlCompte();
	Connection con=null;
	
		con=c.conex();
		 Statement requete1 = con.createStatement();
		 ResultSet res=requete1.executeQuery("select* from bien where etat_bien not like 'supprime' and id_personne="+id_personne);
	if(res.next()){
		test=false;
		return test;
	}
	
	return test;
}
public String getAdresse(int id_bien) throws ClassNotFoundException, SQLException{
	String adresse=null;
	cntrlCompte c=new cntrlCompte();
	Connection con=null;

		con=c.conex();
		 Statement requete1 = con.createStatement();
		 ResultSet res=requete1.executeQuery("select adresse from bien where  id_bien="+id_bien);
	if(res.next()){
		adresse=res.getString("adresse");}

return adresse;
	}
public ArrayList<bien> getMaisons() throws ClassNotFoundException, SQLException{
	ArrayList<bien> liste=new ArrayList<bien>();
	cntrlCompte c=new cntrlCompte();
	Connection con=null;
	
		con=c.conex();
		 Statement requete1 = con.createStatement();
		 ResultSet res=requete1.executeQuery("select * from bien,maison where bien.id_bien=maison.id_bien");
while(res.next()){
	 int id_bien=res.getInt("id_bien");
	 int id_personne=res.getInt("id_personne");
	 double superficie=res.getDouble("superficie");
	 int prix=res.getInt("prix");
	 int wilaya=res.getInt("wilaya");
	 String description=res.getString("description");
	 String adresse=res.getString("adresse");
	 int max_colocataire=res.getInt("max_colocataire");
	 String image1=res.getString("image1");
	 String image2=res.getString("image2");
	 String image3=res.getString("image3");
	 String image4=res.getString("image4");
	 String image5=res.getString("image5");
	 String etat_bien=res.getString("etat_bien");
	bien bien=new bien(id_bien, id_personne, superficie, wilaya, prix, description, adresse, etat_bien, max_colocataire, image1, image2, image3, image4, image5);		 
	 liste.add(bien);
}
return liste ;
	}
	public int getNbrChambre(int id_bien) throws ClassNotFoundException, SQLException{
		int nbrchambre=0;
		cntrlCompte c=new cntrlCompte();
		Connection con=null;
		
			con=c.conex();
			 Statement requete1 = con.createStatement();
			 ResultSet res=requete1.executeQuery("select nbr_chambre from maison where id_bien="+id_bien);
			 if(res.next()){
				 nbrchambre=res.getInt("nbr_chambre");
				 return nbrchambre;
			 }
		return nbrchambre ;
	}
	public int getNbrFacade(int id_bien) throws ClassNotFoundException, SQLException{
		int nbrfacade=0;
		cntrlCompte c=new cntrlCompte();
		Connection con=null;
		
			con=c.conex();
			 Statement requete1 = con.createStatement();
			 ResultSet res=requete1.executeQuery("select nbr_facade from maison where id_bien="+id_bien);
			 if(res.next()){
				 nbrfacade=res.getInt("nbr_facade");
				 return nbrfacade;
			 }
		return nbrfacade ;
	}
	public String getjardin(int id_bien) throws ClassNotFoundException, SQLException{
		String jardin=null;
		cntrlCompte c=new cntrlCompte();
		Connection con=null;
		
			con=c.conex();
			 Statement requete1 = con.createStatement();
			 ResultSet res=requete1.executeQuery("select jardin from maison where id_bien="+id_bien);
			 if(res.next()){
				 jardin=res.getString("jardin");
				 return jardin;
			 }
		return jardin ;
	}
	public String getpark(int id_bien) throws ClassNotFoundException, SQLException{
		String park=null;
		cntrlCompte c=new cntrlCompte();
		Connection con=null;
		
			con=c.conex();
			 Statement requete1 = con.createStatement();
			 ResultSet res=requete1.executeQuery("select parking from maison where id_bien="+id_bien);
			 if(res.next()){
				 park=res.getString("parking");
				 return park;
			 }
		return park;
	}
	public ArrayList<bien> getDepot() throws ClassNotFoundException, SQLException{
		ArrayList<bien> liste=new ArrayList<bien>();
		cntrlCompte c=new cntrlCompte();
		Connection con=null;
		
			con=c.conex();
			 Statement requete1 = con.createStatement();
			 ResultSet res=requete1.executeQuery("select * from bien,depot where bien.id_bien=depot.id_bien");
	while(res.next()){
		 int id_bien=res.getInt("id_bien");
		 int id_personne=res.getInt("id_personne");
		 double superficie=res.getDouble("superficie");
		 int prix=res.getInt("prix");
		 int wilaya=res.getInt("wilaya");
		 String description=res.getString("description");
		 String adresse=res.getString("adresse");
		 int max_colocataire=res.getInt("max_colocataire");
		 String image1=res.getString("image1");
		 String image2=res.getString("image2");
		 String image3=res.getString("image3");
		 String image4=res.getString("image4");
		 String image5=res.getString("image5");
		 String etat_bien=res.getString("etat_bien");
		bien bien=new bien(id_bien, id_personne, superficie, wilaya, prix, description, adresse, etat_bien, max_colocataire, image1, image2, image3, image4, image5);		 
		 liste.add(bien);
	}
	return liste ;
		}
	public ArrayList<bien> getAppartement() throws ClassNotFoundException, SQLException{
		ArrayList<bien> liste=new ArrayList<bien>();
		cntrlCompte c=new cntrlCompte();
		Connection con=null;
		
			con=c.conex();
			 Statement requete1 = con.createStatement();
			 ResultSet res=requete1.executeQuery("select * from bien,appartement where bien.id_bien=appartement.id_bien");
	while(res.next()){
		 int id_bien=res.getInt("id_bien");
		 int id_personne=res.getInt("id_personne");
		 double superficie=res.getDouble("superficie");
		 int prix=res.getInt("prix");
		 int wilaya=res.getInt("wilaya");
		 String description=res.getString("description");
		 String adresse=res.getString("adresse");
		 int max_colocataire=res.getInt("max_colocataire");
		 String image1=res.getString("image1");
		 String image2=res.getString("image2");
		 String image3=res.getString("image3");
		 String image4=res.getString("image4");
		 String image5=res.getString("image5");
		 String etat_bien=res.getString("etat_bien");
		bien bien=new bien(id_bien, id_personne, superficie, wilaya, prix, description, adresse, etat_bien, max_colocataire, image1, image2, image3, image4, image5);		 
		 liste.add(bien);
	}
	return liste ;
		}
	public String getCapacite(int id_bien) throws ClassNotFoundException, SQLException{
		String capacite=null;
	
		cntrlCompte c=new cntrlCompte();
		Connection con=null;
		
			con=c.conex();
			 Statement requete1 = con.createStatement();
			 ResultSet res=requete1.executeQuery("select capacite_stockage from depot where id_bien="+id_bien);
			 while(res.next()){
				 capacite=res.getString("capacite_stockage");
				 return capacite;
			 }
		
	return capacite ;
		}
	public String gettypedepot(int id_bien) throws ClassNotFoundException, SQLException{
		String type=null;
	
		cntrlCompte c=new cntrlCompte();
		Connection con=null;
		
			con=c.conex();
			 Statement requete1 = con.createStatement();
			 ResultSet res=requete1.executeQuery("select type from depot where id_bien="+id_bien);
			 while(res.next()){
				 type=res.getString("type");
				 return type;
			 }
		
	return type ;
		}
	public ArrayList<bien> getTerrain() throws ClassNotFoundException, SQLException{
		ArrayList<bien> liste=new ArrayList<bien>();
		cntrlCompte c=new cntrlCompte();
		Connection con=null;
		
			con=c.conex();
			 Statement requete1 = con.createStatement();
			 ResultSet res=requete1.executeQuery("select * from bien,terrain where bien.id_bien=terrain.id_bien");
	while(res.next()){
		 int id_bien=res.getInt("id_bien");
		 int id_personne=res.getInt("id_personne");
		 double superficie=res.getDouble("superficie");
		 int prix=res.getInt("prix");
		 int wilaya=res.getInt("wilaya");
		 String description=res.getString("description");
		 String adresse=res.getString("adresse");
		 int max_colocataire=res.getInt("max_colocataire");
		 String image1=res.getString("image1");
		 String image2=res.getString("image2");
		 String image3=res.getString("image3");
		 String image4=res.getString("image4");
		 String image5=res.getString("image5");
		 String etat_bien=res.getString("etat_bien");
		bien bien=new bien(id_bien, id_personne, superficie, wilaya, prix, description, adresse, etat_bien, max_colocataire, image1, image2, image3, image4, image5);		 
		 liste.add(bien);
	}
	return liste ;
		}
	public String getCaractéristique(int id_bien) throws ClassNotFoundException, SQLException{
		String cacatéristique=null;
	
		cntrlCompte c=new cntrlCompte();
		Connection con=null;
		
			con=c.conex();
			 Statement requete1 = con.createStatement();
			 ResultSet res=requete1.executeQuery("select caracteristique from terrain where id_bien="+id_bien);
			 while(res.next()){
				 cacatéristique=res.getString("caracteristique");
				 return cacatéristique;
			 }
		
	return cacatéristique ;
		}
	public ArrayList<bien> getLocaleCommercial() throws ClassNotFoundException, SQLException{
		ArrayList<bien> liste=new ArrayList<bien>();
		cntrlCompte c=new cntrlCompte();
		Connection con=null;
		
			con=c.conex();
			 Statement requete1 = con.createStatement();
			 ResultSet res=requete1.executeQuery("select * from bien,locale_commercial where bien.id_bien=locale_commercial.id_bien");
	while(res.next()){
		 int id_bien=res.getInt("id_bien");
		 int id_personne=res.getInt("id_personne");
		 double superficie=res.getDouble("superficie");
		 int prix=res.getInt("prix");
		 int wilaya=res.getInt("wilaya");
		 String description=res.getString("description");
		 String adresse=res.getString("adresse");
		 int max_colocataire=res.getInt("max_colocataire");
		 String image1=res.getString("image1");
		 String image2=res.getString("image2");
		 String image3=res.getString("image3");
		 String image4=res.getString("image4");
		 String image5=res.getString("image5");
		 String etat_bien=res.getString("etat_bien");
		bien bien=new bien(id_bien, id_personne, superficie, wilaya, prix, description, adresse, etat_bien, max_colocataire, image1, image2, image3, image4, image5);		 
		 liste.add(bien);
	}
	return liste ;
		}
	public String getDistanceCentre(int id_bien) throws ClassNotFoundException, SQLException{
		String cacatéristique=null;
	
		cntrlCompte c=new cntrlCompte();
		Connection con=null;
		
			con=c.conex();
			 Statement requete1 = con.createStatement();
			 ResultSet res=requete1.executeQuery("select distance_centre from locale_commercial where id_bien="+id_bien);
			 while(res.next()){
				 cacatéristique=res.getString("distance_centre");
				 return cacatéristique;
			 }
		
	return cacatéristique ;
		}
	public ArrayList<bien> getGarage() throws ClassNotFoundException, SQLException{
		ArrayList<bien> liste=new ArrayList<bien>();
		cntrlCompte c=new cntrlCompte();
		Connection con=null;
		
			con=c.conex();
			 Statement requete1 = con.createStatement();
			 ResultSet res=requete1.executeQuery("select * from bien,garage where bien.id_bien=garage.id_bien");
	while(res.next()){
		 int id_bien=res.getInt("id_bien");
		 int id_personne=res.getInt("id_personne");
		 double superficie=res.getDouble("superficie");
		 int prix=res.getInt("prix");
		 int wilaya=res.getInt("wilaya");
		 String description=res.getString("description");
		 String adresse=res.getString("adresse");
		 int max_colocataire=res.getInt("max_colocataire");
		 String image1=res.getString("image1");
		 String image2=res.getString("image2");
		 String image3=res.getString("image3");
		 String image4=res.getString("image4");
		 String image5=res.getString("image5");
		 String etat_bien=res.getString("etat_bien");
		bien bien=new bien(id_bien, id_personne, superficie, wilaya, prix, description, adresse, etat_bien, max_colocataire, image1, image2, image3, image4, image5);		 
		 liste.add(bien);
	}
	return liste ;
		}
	public int getNbrchambrea(int id_bien) throws ClassNotFoundException, SQLException{
		int nbr=0;
		cntrlCompte c=new cntrlCompte();
		Connection con=null;
		
			con=c.conex();
			 Statement requete1 = con.createStatement();
			 ResultSet res=requete1.executeQuery("select nbr_chambre from appartement where id_bien="+id_bien);
			 while(res.next()){
				 nbr=res.getInt("nbr_chambre");
				
			 }
	return nbr ;
	}
	public int getEtage(int id_bien) throws ClassNotFoundException, SQLException{
		int nbr=0;
		cntrlCompte c=new cntrlCompte();
		Connection con=null;
		
			con=c.conex();
			 Statement requete1 = con.createStatement();
			 ResultSet res=requete1.executeQuery("select etage from appartement where id_bien="+id_bien);
			 while(res.next()){
				 nbr=res.getInt("etage");
				
			 }
	return nbr ;
	}
	public String getCapacitéVéhi(int id_bien) throws ClassNotFoundException, SQLException{
		String capaciteV=null;
	
		cntrlCompte c=new cntrlCompte();
		Connection con=null;
		
			con=c.conex();
			 Statement requete1 = con.createStatement();
			 ResultSet res=requete1.executeQuery("select capacite_vehicule from garage where id_bien="+id_bien);
			 while(res.next()){
				 capaciteV=res.getString("capacite_vehicule");
				 return capaciteV;
			 }
		
	return capaciteV ;
		}
	public ArrayList<bien> getBienapprouve() throws ClassNotFoundException, SQLException{
		ArrayList<bien> liste=new ArrayList<bien>();
		cntrlCompte c=new cntrlCompte();
		Connection con=null;
		
			con=c.conex();
			 Statement requete1 = con.createStatement();
			 ResultSet res=requete1.executeQuery("select * from bien where etat_bien like 'non approuve'");
			 while(res.next()){
				 int id_bien=res.getInt("id_bien");
				 int id_personne=res.getInt("id_personne");
				 double superficie=res.getDouble("superficie");
				 int prix=res.getInt("prix");
				 int wilaya=res.getInt("wilaya");
				 String description=res.getString("description");
				 String adresse=res.getString("adresse");
				 int max_colocataire=res.getInt("max_colocataire");
				 String image1=res.getString("image1");
				 String image2=res.getString("image2");
				 String image3=res.getString("image3");
				 String image4=res.getString("image4");
				 String image5=res.getString("image5");
				 String etat_bien=res.getString("etat_bien");
				 String ajout1=res.getString("ajoute1");
				 String ajout2=res.getString("ajoute2");
				 String ajout3=res.getString("ajoute3");
				 String ajout4=res.getString("ajoute4");
				 String ajout5=res.getString("ajoute5");
				 bien b=new bien(id_bien, id_personne, superficie, wilaya, prix, description, adresse, etat_bien, max_colocataire, image1, image2, image3, image4, image5, ajout1, ajout2, ajout3, ajout4, ajout5);
				 liste.add(b);
				
			 }
		
		return liste;
	}
	
	public String getNameprop(String pseudo) throws ClassNotFoundException, SQLException{
		String nom=null;
		cntrlCompte c=new cntrlCompte();
		Connection con=null;
		
			con=c.conex();
			 Statement requete1 = con.createStatement();
			 ResultSet res=requete1.executeQuery("select nom,prenom from personne where pseudo like '"+pseudo+"'");
		if(res.next()){
			nom=""+res.getString("nom")+" "+res.getString("prenom");
		}
		
		return nom;
		}
	public String getNameprop1(int id_personne) throws ClassNotFoundException, SQLException{
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
	public void plus50Points(int id_personne) throws ClassNotFoundException, SQLException{
		cntrlCompte c=new cntrlCompte();
		Connection con=null;
	
			con=c.conex();
			 Statement requete1 = con.createStatement();
			 int r=requete1.executeUpdate("update proprietaire set points=points+20 where id_personne="+id_personne);
		
	}

	




}
