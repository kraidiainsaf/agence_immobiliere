package Modele;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public class cntrlNotif {
	public cntrlNotif(){}
	cntrlCompte ct=new cntrlCompte();
	public int getIdPersonne(String pseudo) throws ClassNotFoundException, SQLException{
		int id = 0;
		
		   Connection con =ct.conex() ;
		   
		        Statement requete = con.createStatement();
		        //Execution de la requ�te
		   ResultSet resultat = requete.executeQuery("select* from personne ");
	          //Parcourir les enregistrements
		   while(resultat.next()){
			   System.out.println("in");
		        if (resultat.getString("pseudo").equals(pseudo)) {
		       
		        id=resultat.getInt("id_personne");
		        System.out.println(id);
		        	 return id;
		   
		                      
		                       }
		        
		   }
		   return id;}
	public ArrayList<String > afficherNot(int id_personne) throws ClassNotFoundException, SQLException{
		ArrayList<String > list=new ArrayList<String>();
		String notif=null;
		Connection con=ct.conex();;
		
			 Statement requete = con.createStatement();
		   ResultSet resultat = requete.executeQuery("select* from notification where id_personne="+id_personne+" order by id_notif DESC limit 3");
			while(resultat.next()){
				notif=resultat.getString("emetteur")+":"+resultat.getString("contenue_notif")+"            ";
				list.add(notif);
			}
		
		return list;
	}
	public int getIdp(String psd) throws ClassNotFoundException, SQLException{
		int id = 0;
		   Connection con = ct.conex();
		        Statement requete = con.createStatement();
		        //Execution de la requ�te
		   ResultSet resultat = requete.executeQuery("select * from personne ");
	          //Parcourir les enregistrements
		   while(resultat.next()){
			   
		        if (resultat.getString("pseudo").equals(psd)) {
		       id=resultat.getInt("id_personne");
		      
		        	 return id;
		                      
		                       }
		        
		   }

		   return id;
	}
	public void envoyerNotif(int id_personne,String contenu,String emetteur) throws ClassNotFoundException, SQLException{
		cntrlNotif nt=new cntrlNotif();
		
		   Connection con = ct.conex();
		
		        Statement requete = con.createStatement();
		        int  NbIns ;
		       NbIns = requete.executeUpdate("INSERT INTO notification (id_personne,contenue_notif"
		       		+ ",emetteur) VALUES ("+id_personne+",'"+contenu+"','"+emetteur+"' ) ");
		        System.out.println(NbIns+" ligne ins�r�e");
		 
		    
	} 
	public int nombreNotif(int id_personne) throws ClassNotFoundException, SQLException{
		
		int nombre=0;
		Connection cn=ct.conex();
		
			 Statement requete = cn.createStatement();
		    ResultSet res=requete.executeQuery("select count(id_personne) from notification where id_personne="+id_personne);
		    	while(res.next()){
		    		nombre=res.getInt("count(id_personne)");
		    	}
					     
					     
		return nombre;
	}
	public ArrayList<notification> getNotifications(int id_personne) throws ClassNotFoundException, SQLException{
		ArrayList<notification> list=new ArrayList<notification>();
		Connection cn=ct.conex();
	
			 Statement requete = cn.createStatement();
		    ResultSet res=requete.executeQuery("select * from notification where id_personne="+id_personne);
		    	while(res.next()){
		    		int id_notif=res.getInt("id_notif");
		    		int id_pe=res.getInt("id_personne");
		    		String contenu=res.getString("contenue_notif");
		    		String emetteur=res.getString("emetteur");
		    		notification not=new notification(id_notif, id_pe, contenu, emetteur);
		    		list.add(not);
		    		}
		    	
		return list;
					     
	}
	public void supprimernotif(int id_notif) throws ClassNotFoundException, SQLException{
		
		Connection cn=ct.conex();
		
			 Statement requete = cn.createStatement();
			 int res=requete.executeUpdate("delete from notification where id_notif="+id_notif);
		
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		cntrlNotif b=new cntrlNotif();
		String d="hannane";
	
cntrlNotif n=new cntrlNotif();
System.out.println(n.nombreNotif(1));
//n.envoyerNotif(d, "blabla", "ad");
	}

}
