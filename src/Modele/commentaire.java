package Modele;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class commentaire {
	private int id_commentaire;
	private int id_bien;
	private String nom_ecri;
	private String contenue;
	
	public commentaire(){}
	public commentaire(int id_commentaire,int id_bien,String nom_ecri,String contenu){
this.id_commentaire=id_commentaire;
this.id_bien=id_bien;
this.nom_ecri=nom_ecri;
this.contenue=contenu;
	} 
	public ArrayList<commentaire> getCom(int id_bien) throws ClassNotFoundException, SQLException{
		ArrayList<commentaire> liste=new ArrayList<commentaire>();
		cntrlCompte c=new cntrlCompte();
		Connection con=null;
		
			con=c.conex();
			 Statement requete1 = con.createStatement();
			 ResultSet res=requete1.executeQuery("select * from commentaire where id_bien="+id_bien);
			 while(res.next()){
				 int id_commentaire=res.getInt("id_commentaire");
				 String nom_ecri=res.getString("nom_ecri");
				 String contenu=res.getString("contenue");
				 commentaire com=new commentaire(id_commentaire, id_bien, nom_ecri, contenu);
			
			 liste.add(com);} 
			 
		return liste ;
			 }
	public int getId_commentaire() {
		return id_commentaire;
	}
	public void setId_commentaire(int id_commentaire) {
		this.id_commentaire = id_commentaire;
	}
	public int getId_bien() {
		return id_bien;
	}
	public void setId_bien(int id_bien) {
		this.id_bien = id_bien;
	}
	public String getNom_ecri() {
		return nom_ecri;
	}
	public void setNom_ecri(String nom_ecri) {
		this.nom_ecri = nom_ecri;
	}
	public String getContenue() {
		return contenue;
	}
	public void setContenue(String contenue) {
		this.contenue = contenue;
	}
	

}
