package Modele;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class stat {
public stat(){
}
cntrlCompte c=new cntrlCompte();
public int  nbrBienAttente() throws ClassNotFoundException, SQLException{
	int n=0;
	Connection cn = null;
	 String ajout=null;
	
		  cn= c.conex();
		 Statement requete = cn.createStatement();
	      ResultSet res=requete.executeQuery("select count(id_bien) from bien where etat_bien='non approuve'");
	      if(res.next()){
	    	 n=res.getInt("count(id_bien)");
	      }
			   return n;
	
}
public int  nbrLocationAttente() throws ClassNotFoundException, SQLException{
	int n=0;
	Connection cn = null;
	 String ajout=null;
	
		  cn= c.conex();
		 Statement requete = cn.createStatement();
	      ResultSet res=requete.executeQuery("select count(id_location) from location where etat_location='non approuve'");
	      if(res.next()){
	    	 n=res.getInt("count(id_location)");
	      }
			   return n;
	
}
public int  nbrLocataire() throws ClassNotFoundException, SQLException{
	int n=0;
	Connection cn = null;
	 String ajout=null;
	  
		  cn= c.conex();
		 Statement requete = cn.createStatement();
	      ResultSet res=requete.executeQuery("select count(id_personne) from locataire where etat_locataire not like 'supprime'");
	      if(res.next()){
	    	 n=res.getInt("count(id_personne)");
	      }
			   return n;
	
}
public int  nbrProprietaire() throws ClassNotFoundException, SQLException{
	int n=0;
	Connection cn = null;
	 String ajout=null;
	
		  cn= c.conex();
		 Statement requete = cn.createStatement();
	      ResultSet res=requete.executeQuery("select count(id_personne) from proprietaire where type_pro not like 'supprime'");
	      if(res.next()){
	    	 n=res.getInt("count(id_personne)");
	      }
			   return n;
	
}
public int nbrBienLoue() throws ClassNotFoundException, SQLException{
	int n=0;
	Connection cn = null;
	 String ajout=null;
	  
		  cn= c.conex();
		 Statement requete = cn.createStatement();
	      ResultSet res=requete.executeQuery("select count(id_bien) from location where etat_location like 'approuve'");
	      if(res.next()){
	    	 n=res.getInt("count(id_bien)");
	      }

			   return n;
}
public int CountTolatCompte() throws ClassNotFoundException, SQLException{
	int n=0;
	Connection cn = null;
	 String ajout=null;
	  
		  cn= c.conex();
		 Statement requete = cn.createStatement();
	      ResultSet res=requete.executeQuery("select count(id_personne) from personne");
	      if(res.next()){
	    	 n=res.getInt("count(id_personne)");
	      }
			   return n;
}
public int CountnewCompte() throws ClassNotFoundException, SQLException{
	int n=0;
	Connection cn = null;
	 String ajout=null;
	
		  cn= c.conex();
		 Statement requete = cn.createStatement();
	      ResultSet res=requete.executeQuery("select count(id_personne) from proprietaire where type_pro like 'non approuve' ");
	      if(res.next()){
	    	 n=res.getInt("count(id_personne)");
	      }
			   return n;
}
public int CountsuppComptePro() throws ClassNotFoundException, SQLException{
	int n=0;
	Connection cn = null;
	 String ajout=null;
	   
		  cn= c.conex();
		 Statement requete = cn.createStatement();
	      ResultSet res=requete.executeQuery("select count(id_personne) from proprietaire where type_pro like 'supprime' ");
	      if(res.next()){
	    	 n=res.getInt("count(id_personne)");
	      }

			   return n;
}
public int CountsuppCompteLoc() throws ClassNotFoundException, SQLException{
	int n=0;
	Connection cn = null;
	 String ajout=null;
	 
		  cn= c.conex();
		 Statement requete = cn.createStatement();
	      ResultSet res=requete.executeQuery("select count(id_personne) from locataire where etat_locataire like 'supprime' ");
	      if(res.next()){
	    	 n=res.getInt("count(id_personne)");
	      }
			   return n;
}
public int CountCompteAdmin() throws ClassNotFoundException, SQLException{
	int n=0;
	Connection cn = null;
	 String ajout=null;
	
		  cn= c.conex();
		 Statement requete = cn.createStatement();
	      ResultSet res=requete.executeQuery("select count(id_personne) from admin ");
	      if(res.next()){
	    	 n=res.getInt("count(id_personne)");
	      }
			   return n;
}
public int montant15() throws ClassNotFoundException, SQLException{
	int n=0;
	Connection cn = null;
	 String ajout=null;
	   
		  cn= c.conex();
		 Statement requete = cn.createStatement();
	      ResultSet res=requete.executeQuery("select montant  from facture where date_pay<'2016-01-01' and date_pay>'2014-12-31' ");
	      while(res.next()){
	    	 n=n+(res.getInt("montant")*20)/100;
	      }
			   return n;
}
public int nbrLocation15() throws ClassNotFoundException, SQLException{
	int n=0;
	Connection cn = null;
	 String ajout=null;
	   
		  cn= c.conex();
		 Statement requete = cn.createStatement();
	      ResultSet res=requete.executeQuery("select count(id_location) from facture where date_pay<'2016-01-01' and date_pay>'2014-12-31' ");
	      while(res.next()){
	    	 n=res.getInt("count(id_location)");
	      }
			   return n;
}
public int montant16() throws ClassNotFoundException, SQLException{
	int n=0;
	Connection cn = null;
	 String ajout=null;
	 
		  cn= c.conex();
		 Statement requete = cn.createStatement();
	      ResultSet res=requete.executeQuery("select montant  from facture where date_pay<'2017-01-01' and date_pay>'2015-12-31' ");
	      while(res.next()){
	    	 n=n+(res.getInt("montant")*20)/100;
	      }
			   return n;
}
public int nbrLocation16() throws ClassNotFoundException, SQLException{
	int n=0;
	Connection cn = null;
	 String ajout=null;
	  
		  cn= c.conex();
		 Statement requete = cn.createStatement();
	      ResultSet res=requete.executeQuery("select count(id_location) from facture where date_pay<'2017-01-01' and date_pay>'2015-12-31' ");
	      if(res.next()){
	    	 n=res.getInt("count(id_location)");
	      }
			   return n;
}
public int montant17() throws ClassNotFoundException, SQLException{
	int n=0;
	Connection cn = null;
	 String ajout=null;
	   
		  cn= c.conex();
		 Statement requete = cn.createStatement();
	      ResultSet res=requete.executeQuery("select montant  from facture where date_pay<'2018-01-01' and date_pay>'2016-12-31' ");
	      while(res.next()){
	    	 n=n+(res.getInt("montant")*20)/100;
	      }
			   return n;
}
public int nbrLocation17() throws ClassNotFoundException, SQLException{
	int n=0;
	Connection cn = null;
	 String ajout=null;
	   
		  cn= c.conex();
		 Statement requete = cn.createStatement();
	      ResultSet res=requete.executeQuery("select count(id_location)  from facture where date_pay<'2018-01-01' and date_pay>'2016-12-31' ");
	      if(res.next()){
	    	  n=res.getInt("count(id_location)");
	      }
			   return n;
}
public int montant18() throws ClassNotFoundException, SQLException{
	int n=0;
	Connection cn = null;
	 String ajout=null;
	  
		  cn= c.conex();
		 Statement requete = cn.createStatement();
	      ResultSet res=requete.executeQuery("select montant  from facture where date_pay<'2019-01-01' and date_pay>'2017-12-31' ");
	      while(res.next()){
	    	 n=n+(res.getInt("montant")*20)/100;
	      }
			   return n;
}
public int nbrLocation18() throws ClassNotFoundException, SQLException{
	int n=0;
	Connection cn = null;
	 String ajout=null;
	 
		  cn= c.conex();
		 Statement requete = cn.createStatement();
	      ResultSet res=requete.executeQuery("select count(id_location) from facture where date_pay<'2019-01-01' and date_pay>'2017-12-31' ");
	      if(res.next()){
	    	 n=res.getInt("count(id_location)");
	      }
			   return n;
}
public int nbrMaisons() throws ClassNotFoundException, SQLException{
	int n=0;
	Connection cn = null;
	 String ajout=null;
	 
		  cn= c.conex();
		 Statement requete = cn.createStatement();
	      ResultSet res=requete.executeQuery("select count(id_bien) from maison ");
	      if(res.next()){
	    	 n=res.getInt("count(id_bien)");
	      }
			   return n;
}
public int nbrAppartements() throws ClassNotFoundException, SQLException{
	int n=0;
	Connection cn = null;
	 String ajout=null;
	  
		  cn= c.conex();
		 Statement requete = cn.createStatement();
	      ResultSet res=requete.executeQuery("select count(id_bien) from appartement ");
	      if(res.next()){
	    	 n=res.getInt("count(id_bien)");
	      }
			   return n;
}
public int nbrDepots() throws ClassNotFoundException, SQLException{
	int n=0;
	Connection cn = null;
	 String ajout=null;
	   
		  cn= c.conex();
		 Statement requete = cn.createStatement();
	      ResultSet res=requete.executeQuery("select count(id_bien) from depot ");
	      if(res.next()){
	    	 n=res.getInt("count(id_bien)");
	      }
			   return n;
}
public int nbrterrains() throws ClassNotFoundException, SQLException{
	int n=0;
	Connection cn = null;
	 String ajout=null;
	   
		  cn= c.conex();
		 Statement requete = cn.createStatement();
	      ResultSet res=requete.executeQuery("select count(id_bien) from terrain ");
	      if(res.next()){
	    	 n=res.getInt("count(id_bien)");
	      }
			   return n;
}
public int nbrGarages() throws ClassNotFoundException, SQLException{
	int n=0;
	Connection cn = null;
	 String ajout=null;
	 
		  cn= c.conex();
		 Statement requete = cn.createStatement();
	      ResultSet res=requete.executeQuery("select count(id_bien) from garage ");
	      if(res.next()){
	    	 n=res.getInt("count(id_bien)");
	      }
			   return n;
}
public int nbrLocales() throws ClassNotFoundException, SQLException{
	int n=0;
	Connection cn = null;
	 String ajout=null;
	 
		  cn= c.conex();
		 Statement requete = cn.createStatement();
	      ResultSet res=requete.executeQuery("select count(id_bien) from locale_commercial ");
	      if(res.next()){
	    	 n=res.getInt("count(id_bien)");
	      }
			   return n;
}
public ArrayList<proprietaire> top() throws ClassNotFoundException, SQLException{
	ArrayList<proprietaire> topp=new ArrayList();
	Connection cn = null;
	 
		  cn= c.conex();
		 Statement requete = cn.createStatement();
	      ResultSet res=requete.executeQuery("select id_personne,points from proprietaire where points >50 and type_pro not like 'supprime'");
	      while(res.next()){
	    	  
		    	proprietaire p=new proprietaire(res.getInt("id_personne"), res.getInt("points"));
		    		//System.out.println("i"+p.getId_personne());	
		    			topp.add(p);
		      }
	   return topp;
}
public ArrayList<proprietaire> top5() throws ClassNotFoundException, SQLException{
	stat s=new stat();
	ArrayList<proprietaire> topp5=s.top();
	 int  n=topp5.size()-1 ;
	   for (  int  i =n ;  i >= 0 ;  i -- ){
	    for (  int  j  =  1 ;  j <= i ;  j ++ ) {
	     if (  topp5.get(j-1).getPoints() <  topp5.get(j).getPoints() )
	     {
	       int  temp  =  topp5.get(j-1).getPoints() ;
	       int temp2= topp5.get(j-1).getId_personne();
	       topp5.get(j-1).setPoints( topp5.get(j).getPoints()) ;
	       topp5.get(j-1).setId_personne(topp5.get(j).getId_personne());
	       topp5.get(j).setPoints(temp);
	       topp5.get(j).setId_personne(temp2);
	       }}}
	       return topp5;
}
public ArrayList<String> top5names() throws ClassNotFoundException, SQLException{
	cntrlBien cb=new cntrlBien();
	stat st=new stat();
	ArrayList<proprietaire> top=st.top5();
	ArrayList<String> liste=new ArrayList<String>();
	for(int i=0;i<top.size();i++){
		liste.add(cb.getNameprop1(top.get(i).getId_personne()));
	}
	return liste;
}
public int MonthJanvier() throws ClassNotFoundException, SQLException{
	int n=0;
	Connection cn = null;
	
		  cn= c.conex();
		 Statement requete = cn.createStatement();
	      ResultSet res=requete.executeQuery("select date_pay,montant from facture ");
	      while(res.next()){
	    	 Date d=res.getDate("date_pay");
	    	 String p=String.valueOf(d);
	    	 if(p.equals("null")==false){
	    	 String p2=p.substring(5, 7);
	    	if(p2.equals("01")){
	    		n=n+res.getInt("montant");
	    	}}
	      }
			   return n;
}
public int MonthFevrier() throws ClassNotFoundException, SQLException{
	int n=0;
	Connection cn = null;
	
		  cn= c.conex();
		 Statement requete = cn.createStatement();
	      ResultSet res=requete.executeQuery("select date_pay,montant from facture ");
	      while(res.next()){
	    	 Date d=res.getDate("date_pay");
	    	 String p=String.valueOf(d);
	    	 if(p.equals("null")==false){
	    	 String p2=p.substring(5, 7);
	    	if(p2.equals("02")){
	    		n=n+res.getInt("montant");
	    	}}
	      }
			   return n;
}
public int MonthMars() throws ClassNotFoundException, SQLException{
	int n=0;
	Connection cn = null;
	
		  cn= c.conex();
		 Statement requete = cn.createStatement();
	      ResultSet res=requete.executeQuery("select date_pay,montant from facture ");
	      while(res.next()){
	    	 Date d=res.getDate("date_pay");
	    	 String p=String.valueOf(d);
	    	 if(p.equals("null")==false){
	    	 String p2=p.substring(5, 7);
	    	if(p2.equals("03")){
	    		n=n+res.getInt("montant");
	    	}}
	      }
			   return n;
}
public int MonthAvril() throws ClassNotFoundException, SQLException{
	int n=0;
	Connection cn = null;
	
		  cn= c.conex();
		 Statement requete = cn.createStatement();
	      ResultSet res=requete.executeQuery("select date_pay,montant from facture ");
	      while(res.next()){
	    	 Date d=res.getDate("date_pay");
	    	 String p=String.valueOf(d);
	    	 if(p.equals("null")==false){
	    	 String p2=p.substring(5, 7);
	    	if(p2.equals("04")){
	    		n=n+res.getInt("montant");
	    	}}
	      }
			   return n;
}
public int MonthMai() throws ClassNotFoundException, SQLException{
	int n=0;
	Connection cn = null;
	
		  cn= c.conex();
		 Statement requete = cn.createStatement();
	      ResultSet res=requete.executeQuery("select date_pay,montant from facture ");
	      while(res.next()){
	    	 Date d=res.getDate("date_pay");
	    	 String p=String.valueOf(d);
	    	 if(p.equals("null")==false){
	    	 String p2=p.substring(5, 7);
	    	if(p2.equals("05")){
	    		n=n+res.getInt("montant");
	    	}}
	      }
			   return n;
}
public int MonthJuin() throws ClassNotFoundException, SQLException{
	int n=0;
	Connection cn = null;
	
		  cn= c.conex();
		 Statement requete = cn.createStatement();
	      ResultSet res=requete.executeQuery("select date_pay,montant from facture ");
	      while(res.next()){
	    	 Date d=res.getDate("date_pay");
	    	 String p=String.valueOf(d);
	    	 if(p.equals("null")==false){
	    	 String p2=p.substring(5, 7);
	    	if(p2.equals("06")){
	    		n=n+res.getInt("montant");
	    	}}
	      }
			   return n;
}
public int MonthJuillet() throws ClassNotFoundException, SQLException{
	int n=0;
	Connection cn = null;
	
		  cn= c.conex();
		 Statement requete = cn.createStatement();
	      ResultSet res=requete.executeQuery("select date_pay,montant from facture ");
	      while(res.next()){
	    	 Date d=res.getDate("date_pay");
	    	 String p=String.valueOf(d);
	    	 if(p.equals("null")==false){
	    	 String p2=p.substring(5, 7);
	    	if(p2.equals("07")){
	    		n=n+res.getInt("montant");
	    	}}
	      }
			   return n;
}
public int MonthAout() throws ClassNotFoundException, SQLException{
	int n=0;
	Connection cn = null;
	
		  cn= c.conex();
		 Statement requete = cn.createStatement();
	      ResultSet res=requete.executeQuery("select date_pay,montant from facture ");
	      while(res.next()){
	    	 Date d=res.getDate("date_pay");
	    	 String p=String.valueOf(d);
	    	 if(p.equals("null")==false){
	    	 String p2=p.substring(5, 7);
	    	if(p2.equals("08")){
	    		n=n+res.getInt("montant");
	    	}}
	      }
			   return n;
}
public int MonthSeptembre() throws ClassNotFoundException, SQLException{
	int n=0;
	Connection cn = null;
	
		  cn= c.conex();
		 Statement requete = cn.createStatement();
	      ResultSet res=requete.executeQuery("select date_pay,montant from facture ");
	      while(res.next()){
	    	 Date d=res.getDate("date_pay");
	    	 String p=String.valueOf(d);
	    	 if(p.equals("null")==false){
	    	 String p2=p.substring(5, 7);
	    	if(p2.equals("09")){
	    		n=n+res.getInt("montant");
	    	}}
	      }
			   return n;
}
public int MonthOctobre() throws ClassNotFoundException, SQLException{
	int n=0;
	Connection cn = null;
	
		  cn= c.conex();
		 Statement requete = cn.createStatement();
	      ResultSet res=requete.executeQuery("select date_pay,montant from facture ");
	      while(res.next()){
	    	 Date d=res.getDate("date_pay");
	    	 String p=String.valueOf(d);
	    	 if(p.equals("null")==false){
	    	 String p2=p.substring(5, 7);
	    	if(p2.equals("10")){
	    		n=n+res.getInt("montant");
	    	}}
	      }
			   return n;
}
public int MonthNovembre() throws ClassNotFoundException, SQLException{
	int n=0;
	Connection cn = null;
	
		  cn= c.conex();
		 Statement requete = cn.createStatement();
	      ResultSet res=requete.executeQuery("select date_pay,montant from facture ");
	      while(res.next()){
	    	 Date d=res.getDate("date_pay");
	    	 String p=String.valueOf(d);
	    	 if(p.equals("null")==false){
	    	 String p2=p.substring(5, 7);
	    	if(p2.equals("11")){
	    		n=n+res.getInt("montant");
	    	}}
	      }
			   return n;
}
public int MonthDecembre() throws ClassNotFoundException, SQLException{
	int n=0;
	Connection cn = null;
	
		  cn= c.conex();
		 Statement requete = cn.createStatement();
	      ResultSet res=requete.executeQuery("select date_pay,montant from facture ");
	      while(res.next()){
	    	 Date d=res.getDate("date_pay");
	    	 String p=String.valueOf(d);
	    	 if(p.equals("null")==false){
	    	 String p2=p.substring(5, 7);
	    	if(p2.equals("12")){
	    		n=n+res.getInt("montant");
	    	}}
	      }
			   return n;
}
	
	}


