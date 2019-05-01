package Modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.mysql.fabric.xmlrpc.base.Data;

public class operation {
	
	public Connection GetConnection() throws SQLException, ClassNotFoundException {
		Connection conn=null;	
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost/agenceimmobiliere";
		conn=DriverManager.getConnection(url,"insaf","123");
		return conn;
	
		}
	public int isfin_location(int id_personne) throws ClassNotFoundException, SQLException{
		Connection conn=GetConnection();		char k='"';

		String sql="SELECT * FROM facture,location where facture.id_personne  like "+id_personne+" and location.id_location=facture.id_location and etat_location like 'approuve' and location.date_fin-(select current_date()) <= 5 ";
		System.out.println(""+sql );		
		//"like "+k+"approuver"+k+" or etat_bien like "+k+"non approuver"+k;
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			int rst=0;
			if(resultSet.next()) {
				rst=resultSet.getInt("location.id_location");
				}return rst;
		
		
	}
	public double getMontatnt(int id_location) throws SQLException, ClassNotFoundException {
		Connection conn=GetConnection();		char k='"';

		String sql="SELECT * FROM `facture` where id_location  like "+id_location;
		System.out.println(""+sql );		
		//"like "+k+"approuver"+k+" or etat_bien like "+k+"non approuver"+k;
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			double mont=0;
			if(resultSet.next()) {
				mont=resultSet.getDouble("montant");
				} return mont;
			
	}
	public String getEtat_pro(int id_personne) throws SQLException, ClassNotFoundException {
		Connection conn=GetConnection();		char k='"';

		String sql="SELECT * FROM `proprietaire` where id_personne  like "+id_personne;
		System.out.println(""+sql );		
		//"like "+k+"approuver"+k+" or etat_bien like "+k+"non approuver"+k;
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			String e=null;
			if(resultSet.next()) {
				e=resultSet.getString("type_pro");
				} return e;
			
	}
	public Boolean is_anc_pro(int id_personne) throws SQLException, ClassNotFoundException {
		Connection conn=GetConnection();		char k='"';
Boolean res=false;
		String sql="SELECT * FROM `proprietaire` where id_personne  like "+id_personne;
		System.out.println(""+sql );		
		//"like "+k+"approuver"+k+" or etat_bien like "+k+"non approuver"+k;
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			String e=null;
			if(resultSet.next()) {
				res=true;
				} return res;
			
	}
	public void SetEtat_Pro(int id_personne) throws SQLException, ClassNotFoundException {
		Connection conn=GetConnection();		char k='"';
		String sql1="UPDATE `proprietaire` SET `type_pro`='non approuve' where id_personne="+id_personne;
		PreparedStatement preparedStatement1=conn.prepareStatement(sql1);
		int resultSet=preparedStatement1.executeUpdate();
		
	}
	public int getNbr_notif(int id_personne) throws SQLException, ClassNotFoundException {
		Connection conn=GetConnection();		char k='"';

		String sql="SELECT count(id_notif) FROM `notification` where id_personne  like "+id_personne;
		System.out.println(""+sql );		
		//"like "+k+"approuver"+k+" or etat_bien like "+k+"non approuver"+k;
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			int mont=0;
			if(resultSet.next()) {
				mont=resultSet.getInt(1);
				} return mont;
			
	}
	public int getPoint(int id_personne) throws SQLException, ClassNotFoundException {
		Connection conn=GetConnection();		char k='"';

		String sql="SELECT * FROM `proprietaire` where id_personne  like "+id_personne;
		System.out.println(""+sql );		
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			int mont=0;
			if(resultSet.next()) {
				mont=resultSet.getInt("points");
				} return mont;
			
	}
	
	public int getNbr_Locations_totale(int id_personne) throws SQLException, ClassNotFoundException {
		Connection conn=GetConnection();		char k='"';

		String sql="SELECT count(*) FROM `location`,facture where id_personne  like "+id_personne+" and location.id_location=facture.id_location";
		System.out.println(""+sql );		
		//"like "+k+"approuver"+k+" or etat_bien like "+k+"non approuver"+k;
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			int mont=0;
			if(resultSet.next()) {
				mont=resultSet.getInt(1);
				} return mont;
			
	}
	public int getNbr_bien_totale(int id_personne) throws SQLException, ClassNotFoundException {
		Connection conn=GetConnection();		char k='"';

		String sql="SELECT count(*) FROM `bien` where id_personne  like "+id_personne;
		System.out.println(""+sql );		
		//"like "+k+"approuver"+k+" or etat_bien like "+k+"non approuver"+k;
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			int mont=0;
			if(resultSet.next()) {
				mont=resultSet.getInt(1);
				} return mont;
			
	}
	public ArrayList<Integer> getMaxPOINT() throws SQLException, ClassNotFoundException {
		Connection conn=GetConnection();		char k='"';

		String sql="SELECT * FROM `proprietaire` where points > 49 and type_pro like 'approuve' limit 4 " ;
		System.out.println("get les bien buliere"+sql );		
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			ArrayList<Integer> l=new ArrayList<Integer>();
			while(resultSet.next()) {
				int s=resultSet.getInt("id_personne");
				l.add(s);
				} return l;
			
	}
	
	public ArrayList<personne> getLocataires() throws SQLException, ClassNotFoundException {
		Connection conn=GetConnection();		char k='"';

		String sql="SELECT * FROM `locataire`,personne where locataire.id_personne=personne.id_personne and etat_locataire like 'approuve'  " ;
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			ArrayList<personne> l=new ArrayList<personne>();
			while(resultSet.next()) {
				int id=resultSet.getInt("id_personne");

				String email=resultSet.getString("email");
				String image=resultSet.getString("image");
				String num_tlf=resultSet.getString("num_telephone");
				personne p=new personne(id,email,num_tlf,image);
				l.add(p);
				} return l;
			
	}
	public ArrayList<personne> getProprietaires() throws SQLException, ClassNotFoundException {
		Connection conn=GetConnection();		char k='"';

		String sql="SELECT * FROM `proprietaire`,personne where proprietaire.id_personne=personne.id_personne and type_pro like 'approuve'  " ;
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			ArrayList<personne> l=new ArrayList<personne>();
			while(resultSet.next()) {
				int id=resultSet.getInt("id_personne");
				String email=resultSet.getString("email");
				String image=resultSet.getString("image");
				String num_tlf=resultSet.getString("num_telephone");
				personne p=new personne(id,email,num_tlf,image);
				l.add(p);
				} return l;
			
	}
	public ArrayList<bien> getbienPub() throws SQLException, ClassNotFoundException {
		Connection conn=GetConnection();		char k='"';
		ArrayList<Integer> l=getMaxPOINT();
		String sql="SELECT * FROM `bien` where id_personne like "+l.get(0)+"  and etat_bien like 'approuve' limit 1 ";
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			System.out.println("b1"+sql );		

			ResultSet resultSet=preparedStatement.executeQuery();
			ArrayList<bien> b=new ArrayList<bien>();bien b1=new bien(),b2=new bien(),b3=new bien(),b4=new bien();
			if(resultSet.next()) {
				int id_bien1=resultSet.getInt("id_bien");
				int id_personne1=resultSet.getInt("id_personne");
				double superficie1=resultSet.getDouble("superficie");
				int wilaya1=resultSet.getInt("wilaya");
				double prix1=resultSet.getDouble("prix");
				String description=resultSet.getString("description");
				String adresse1=resultSet.getString("adresse");
				String etat_bien1=resultSet.getString("etat_bien");
				int max_colocataire=resultSet.getInt("max_colocataire");
				String image1=resultSet.getString("image1");
				String image2=resultSet.getString("image2");
				String image3=resultSet.getString("image3");
				String image4=resultSet.getString("image4");
				String image5=resultSet.getString("image5");
			 b1=new bien(id_bien1, id_personne1, superficie1, wilaya1, prix1, description, adresse1, etat_bien1, max_colocataire, image1, image2, image3, image4, image5);
				} 
			b.add(b1);
			String sql1="SELECT * FROM `bien` where id_personne like "+l.get(1)+"  and etat_bien like 'approuve' limit 1 ";
			PreparedStatement preparedStatement1=conn.prepareStatement(sql1);
			System.out.println("b1"+sql1 );		

			ResultSet resultSet1=preparedStatement1.executeQuery();
			if(resultSet1.next()) {
				int id_bien1=resultSet1.getInt("id_bien");
				int id_personne1=resultSet1.getInt("id_personne");
				double superficie1=resultSet1.getDouble("superficie");
				int wilaya1=resultSet1.getInt("wilaya");
				double prix1=resultSet1.getDouble("prix");
				String description=resultSet1.getString("description");
				String adresse1=resultSet1.getString("adresse");
				String etat_bien1=resultSet1.getString("etat_bien");
				int max_colocataire=resultSet1.getInt("max_colocataire");
				String image1=resultSet1.getString("image1");
				String image2=resultSet1.getString("image2");
				String image3=resultSet1.getString("image3");
				String image4=resultSet1.getString("image4");
				String image5=resultSet1.getString("image5");
		 b2=new bien(id_bien1, id_personne1, superficie1, wilaya1, prix1, description, adresse1, etat_bien1, max_colocataire, image1, image2, image3, image4, image5);
				} 
			b.add(b2);
			String sql2="SELECT * FROM `bien` where id_personne like "+l.get(2)+"  and etat_bien like 'approuve' limit 1  ";
			PreparedStatement preparedStatement2=conn.prepareStatement(sql2);
			System.out.println("b1"+sql2 );		

			ResultSet resultSet2=preparedStatement2.executeQuery();
			if(resultSet2.next()) {
				int id_bien1=resultSet2.getInt("id_bien");
				int id_personne1=resultSet2.getInt("id_personne");
				double superficie1=resultSet2.getDouble("superficie");
				int wilaya1=resultSet2.getInt("wilaya");
				double prix1=resultSet2.getDouble("prix");
				String description=resultSet2.getString("description");
				String adresse1=resultSet2.getString("adresse");
				String etat_bien1=resultSet2.getString("etat_bien");
				int max_colocataire=resultSet2.getInt("max_colocataire");
				String image1=resultSet2.getString("image1");
				String image2=resultSet2.getString("image2");
				String image3=resultSet2.getString("image3");
				String image4=resultSet2.getString("image4");
				String image5=resultSet2.getString("image5");
		  b3=new bien(id_bien1, id_personne1, superficie1, wilaya1, prix1, description, adresse1, etat_bien1, max_colocataire, image1, image2, image3, image4, image5);
				} 
			b.add(b3);
			String sql3="SELECT * FROM `bien` where id_personne like "+l.get(3)+"  and etat_bien like 'approuve' limit 1  ";
			PreparedStatement preparedStatement3=conn.prepareStatement(sql3);
			System.out.println("b1"+sql3 );		

			ResultSet resultSet3=preparedStatement3.executeQuery();
			if(resultSet3.next()) {
				int id_bien1=resultSet3.getInt("id_bien");
				int id_personne1=resultSet3.getInt("id_personne");
				double superficie1=resultSet3.getDouble("superficie");
				int wilaya1=resultSet3.getInt("wilaya");
				double prix1=resultSet3.getDouble("prix");
				String description=resultSet3.getString("description");
				String adresse1=resultSet3.getString("adresse");
				String etat_bien1=resultSet3.getString("etat_bien");
				int max_colocataire=resultSet3.getInt("max_colocataire");
				String image1=resultSet3.getString("image1");
				String image2=resultSet3.getString("image2");
				String image3=resultSet3.getString("image3");
				String image4=resultSet3.getString("image4");
				String image5=resultSet3.getString("image5");
				 b4=new bien(id_bien1, id_personne1, superficie1, wilaya1, prix1, description, adresse1, etat_bien1, max_colocataire, image1, image2, image3, image4, image5);
				} 
			b.add(b4);
			return b;
			
	}
	public ArrayList<personne> GetPersonne(int id_personne1) throws ClassNotFoundException, SQLException {
		Connection conn=GetConnection();		char k='"';
		ArrayList<personne> listl=new ArrayList<personne>();
		String sql="SELECT * FROM `personne` where id_personne not like "+id_personne1;
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
			int id_personne=resultSet.getInt("id_personne");
			String cart_identite=resultSet.getString("cart_identite");
			String pseudo=resultSet.getString("pseudo");
			String password=resultSet.getString("password");
			String nom=resultSet.getString("nom");
			String prenom=resultSet.getString("prenom");
			String email=resultSet.getString("email");
			String num_telephone=resultSet.getString("num_telephone");
				personne p=new personne(id_personne, cart_identite, pseudo, password, nom, prenom, email, num_telephone);
			listl.add(p);
			} return listl;
			}
	public ArrayList<Integer> GetListeIDbiens(int id_personne1) throws ClassNotFoundException, SQLException {
		Connection conn=GetConnection();		char k='"';

		ArrayList<Integer> listl=new ArrayList<Integer>();
		String sql="SELECT * FROM `bien` where id_personne  like "+id_personne1+" and etat_bien not like "+k+"supprime"+k;
		System.out.println(""+sql );		
		//"like "+k+"approuver"+k+" or etat_bien like "+k+"non approuver"+k;
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Integer id_bien1=resultSet.getInt("id_bien");
							listl.add(id_bien1);
			} return listl;
			}
	public boolean isMaison(int id_bien) throws ClassNotFoundException, SQLException {
		Connection conn=GetConnection();		char k='"';
		String sql="SELECT * FROM `maison` where id_bien  like "+id_bien;
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				return true;	
			} return false;
	}
	public boolean isAppartement(int id_bien) throws ClassNotFoundException, SQLException {
		Connection conn=GetConnection();		char k='"';
		String sql="SELECT * FROM `appartement` where id_bien  like "+id_bien;
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				return true;	
			} return false;
	}
	public boolean isDepot(int id_bien) throws ClassNotFoundException, SQLException {
		Connection conn=GetConnection();
		String sql="SELECT * FROM `depot` where id_bien  like "+id_bien;
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				return true;	
			} return false;
	}
	public boolean isGarage(int id_bien) throws ClassNotFoundException, SQLException {
		Connection conn=GetConnection();		char k='"';
		String sql="SELECT * FROM `garage` where id_bien  like "+id_bien;
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				return true;	
			} return false;
	}
	public boolean isLocale(int id_bien) throws ClassNotFoundException, SQLException {
		Connection conn=GetConnection();		char k='"';
		String sql="SELECT * FROM `locale_commercial` where id_bien  like "+id_bien;
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				return true;	
			} return false;
	}
	public boolean isTerrain(int id_bien) throws ClassNotFoundException, SQLException {
		Connection conn=GetConnection();		char k='"';
		String sql="SELECT * FROM `terrain` where id_bien  like "+id_bien;
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				return true;	
			} return false;
	}
	public personne GetPersonneinfo(int id_personne1) throws ClassNotFoundException, SQLException {
		Connection conn=GetConnection();		char k='"';

		String sql="SELECT * FROM `personne` where id_personne like "+id_personne1;
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();personne p=null;
			while(resultSet.next()) {
			int id_personne=resultSet.getInt("id_personne");
			String cart_identite=resultSet.getString("cart_identite");
			String pseudo=resultSet.getString("pseudo");
			String password=resultSet.getString("password");
			String nom=resultSet.getString("nom");
			String prenom=resultSet.getString("prenom");
			String email=resultSet.getString("email");
			String num_telephone=resultSet.getString("num_telephone");
			System.out.println("get info"+id_personne+password+prenom+pseudo);
			 p=new personne(id_personne, cart_identite, pseudo, password, nom, prenom, email, num_telephone);
			}return p;
			}
	public ArrayList<notification> GetMes_notif(int id_personne) throws ClassNotFoundException, SQLException {
		Connection conn=GetConnection();		char k='"';

		ArrayList<notification> listl=new ArrayList<notification>();
		String sql="SELECT * FROM `notification` WHERE id_personne like "+id_personne; 
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
			int id_personne1=resultSet.getInt("id_personne");
			int id_notif=resultSet.getInt("id_notif");
			String contenue_notif=resultSet.getString("contenue_notif");
			String emetteur=resultSet.getString("emetteur");
				      notification n=new notification(id_notif, id_personne1, contenue_notif, emetteur);
			listl.add(n);
			} return listl;
			}
	
	public ArrayList<location> GetLocation_locataire(int id_personne) throws ClassNotFoundException, SQLException {
		Connection conn=GetConnection();		char k='"';

		ArrayList<location> listl=new ArrayList<location>();
		String sql="SELECT * FROM `facture`,`location` WHERE facture.id_location=location.id_location and  facture.id_personne like "+id_personne+" and (( location.etat_location like "+k+"approuve"+k+" ) or ( location.etat_location like "+k+"non approuve"+k+" ) )"; 
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				int id_bien=resultSet.getInt("id_bien");

			int id_location=resultSet.getInt("id_location");
			String mode_pay=resultSet.getString("mode_pay");
			Date date_debut=resultSet.getDate("date_debut");
			Date date_fin=resultSet.getDate("date_fin");
			String etat_location =resultSet.getString("etat_location");
	      location l=new location(id_location, id_bien, date_debut, date_fin, mode_pay, etat_location);
			listl.add(l);
			} return listl;
			}
	public boolean IsExist(String typebien,String adresse) throws ClassNotFoundException, SQLException {
		Connection conn=GetConnection();
		char k='"';
		String sql="SELECT * FROM `bien` WHERE `adresse`="+k+adresse+k+""; 
		System.out.print(""+sql);

			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			if(resultSet.next()) {
			return true;}
	return false;}
	public Date getDatePay(int id_location ,int id_personne ) throws ClassNotFoundException, SQLException {
		Connection conn=GetConnection();
		char k='"';
		String sql="SELECT * FROM `facture` WHERE id_personne like "+id_personne+" and  `id_location`="+id_location; 
		System.out.print(""+sql);

			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			if(resultSet.next()) {
			return resultSet.getDate("date_pay");}
	return null;}
	public location GetLocation(int id_location) throws ClassNotFoundException, SQLException {
		Connection conn=GetConnection();
		String sql="SELECT *  FROM `location` WHERE id_location like "+id_location+"";
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			location l=null;
			if(resultSet.next()) {
			int id_location1=resultSet.getInt("id_location");
			int id_bien=resultSet.getInt("id_bien");
			String mode_pay=resultSet.getString("mode_pay");
			String etat_location=resultSet.getString("etat_location");
			Date date_debut=resultSet.getDate("date_debut");
			Date date_fin=resultSet.getDate("date_fin");
			 l=new location(id_location, id_bien, date_debut, date_fin, mode_pay, etat_location);}
	return l;}
	
	public int GetMaxColocataire(int id_bien) throws ClassNotFoundException, SQLException {
		Connection conn=GetConnection();
		String sql="SELECT *  FROM `bien` WHERE id_bien like "+id_bien+"";
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
	return resultSet.getInt("max_colocataire");
			}return 0;}
	public int GetNbrLocataire(int id_location) throws ClassNotFoundException, SQLException {
		Connection conn=GetConnection();
		String sql="SELECT *  FROM `location` WHERE id_location like "+id_location+"";
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
	return resultSet.getInt("nbr_locataire");
			}return 0;}

	public int  AjouterCommentaire(int id_bien,String nom_ecri,String contenue) throws ClassNotFoundException, SQLException {
		Connection conn=GetConnection();
		String sql="INSERT INTO `commentaire` (`id_bien`, `nom_ecri`, `contenue`) VALUES (?,?,?)";
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			preparedStatement.setInt(1,id_bien);
			preparedStatement.setString(2,nom_ecri);
			preparedStatement.setString(3,contenue);
			int resultSet=0;
			resultSet=preparedStatement.executeUpdate();
			if(resultSet!=0) {
				return resultSet;
			}else {
				return 0;
			}
			}
	public int  ModifierProfilePersonne(int id_personne,String pseudo,String password,String nom,String prenom,String email,String num_telephone) throws ClassNotFoundException, SQLException {
		Connection conn=GetConnection();char k='"';
String sql="UPDATE `personne` SET `pseudo`="+k+pseudo+k+" ,`password`="+k+password+k+" ,`nom`="+k+nom+k+" ,`prenom`="+k+prenom+k+" ,`email`="+k+email+k+" ,`num_telephone`="+k+num_telephone+k+" WHERE id_personne like "+id_personne;
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			int resultSet=0;
			resultSet=preparedStatement.executeUpdate();
			if(resultSet!=0) {
				return resultSet;
			}else {
				return 0;
			}}
	public int Supprime_Notif(int id_notif) throws ClassNotFoundException, SQLException {
		Connection conn=GetConnection();char k='"';
String sql="DELETE FROM `notification` WHERE `notification`.`id_notif` = "+id_notif;

			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			int resultSet=0;
			resultSet=preparedStatement.executeUpdate();
			if(resultSet!=0) {
				return resultSet;
			}else {
				return 0;
			}}
	public int  ModifierMaison(int id_bien,double prix,int max_locataire,String description,int nbr_chambre,int nbr_facade,boolean jardin, boolean parking) throws ClassNotFoundException, SQLException {
		Connection conn=GetConnection();char k='"';
String sql="UPDATE `maison` SET `nbr_chambre`="+nbr_chambre+" ,`nbr_facade`="+nbr_facade+" ,`jardin`="+jardin+" ,`parking`="+parking+" WHERE id_bien like "+id_bien;
			PreparedStatement preparedStatement=conn.prepareStatement(sql);		
			int resultSet=preparedStatement.executeUpdate();
System.out.println("sql1  "+sql);
			String sql2="UPDATE `bien` SET `prix`="+prix+" ,`max_colocataire`="+max_locataire+" ,`description`="+k+description+k+"  WHERE id_bien like "+id_bien;
			PreparedStatement preparedStatement1=conn.prepareStatement(sql2);
			int resultSet1=resultSet=preparedStatement1.executeUpdate();
			System.out.println("sql2  "+sql2);

			if(resultSet!=0) {
				return resultSet;
			}else {
				return 0;
			}}
	public int  ModifierAppatemnet(int id_bien,double prix,int max_locataire,String description,int nbr_chambre) throws ClassNotFoundException, SQLException {
		Connection conn=GetConnection();char k='"';
String sql="UPDATE `appartement` SET `nbr_chambre`="+nbr_chambre+"  WHERE id_bien like "+id_bien;
			PreparedStatement preparedStatement=conn.prepareStatement(sql);		
			int resultSet=preparedStatement.executeUpdate();
System.out.println("sql1  "+sql);
			String sql2="UPDATE `bien` SET `prix`="+prix+" ,`max_colocataire`="+max_locataire+" ,`description`="+k+description+k+"  WHERE id_bien like "+id_bien;
			PreparedStatement preparedStatement1=conn.prepareStatement(sql2);
			int resultSet1=resultSet=preparedStatement1.executeUpdate();
			System.out.println("sql2  "+sql2);

			if(resultSet!=0) {
				return resultSet;
			}else {
				return 0;
			}}
	public int  ModifierDepot(int id_bien,double prix,int max_locataire,String description,String type) throws ClassNotFoundException, SQLException {
		Connection conn=GetConnection();char k='"';
String sql="UPDATE `depot` SET `type`= "+k+type+k+" WHERE id_bien like "+id_bien;
			PreparedStatement preparedStatement=conn.prepareStatement(sql);		System.out.println("sql1  "+sql);

			int resultSet=preparedStatement.executeUpdate();
System.out.println("sql1  "+sql);
			String sql2="UPDATE `bien` SET `prix`="+prix+" ,`max_colocataire`="+max_locataire+" ,`description`="+k+description+k+"  WHERE id_bien like "+id_bien;
			PreparedStatement preparedStatement1=conn.prepareStatement(sql2);
			int resultSet1=resultSet=preparedStatement1.executeUpdate();
			System.out.println("sql2  "+sql2);

			if(resultSet!=0) {
				return resultSet;
			}else {
				return 0;
			}}
	public int  ModifierGarage(int id_bien,double prix,int max_locataire,String description) throws ClassNotFoundException, SQLException {
		Connection conn=GetConnection();char k='"';

			String sql2="UPDATE `bien` SET `prix`="+prix+" ,`max_colocataire`="+max_locataire+" ,`description`="+k+description+k+"  WHERE id_bien like "+id_bien;
			PreparedStatement preparedStatement1=conn.prepareStatement(sql2);
			int resultSet=preparedStatement1.executeUpdate();
			System.out.println("sql2  "+sql2);

			if(resultSet!=0) {
				return resultSet;
			}else {
				return 0;
			}}
	public int  ModifierLocale(int id_bien,double prix,int max_locataire,String description,String type_local) throws ClassNotFoundException, SQLException {
		Connection conn=GetConnection();char k='"';
		String sql="UPDATE `locale_commercial` SET `type_local` = "+k+type_local+k+" WHERE id_bien like "+id_bien;
		PreparedStatement preparedStatement=conn.prepareStatement(sql);		
		int resultSet=preparedStatement.executeUpdate();
			String sql2="UPDATE `bien` SET `prix`="+prix+" ,`max_colocataire`="+max_locataire+" ,`description`="+k+description+k+"  WHERE id_bien like "+id_bien;
			PreparedStatement preparedStatement1=conn.prepareStatement(sql2);
			int resultSet1=preparedStatement1.executeUpdate();
			System.out.println("sql2  "+sql2);

			if(resultSet!=0) {
				return resultSet;
			}else {
				return 0;
			}}
	public int  AjoutePoints(int id_personne,int point) throws ClassNotFoundException, SQLException {
		Connection conn=GetConnection();char k='"';
		int p=getPoint(id_personne)+point;
		String sql="UPDATE `proprietaire` SET `points` = "+p+" WHERE id_personne like "+id_personne;
		PreparedStatement preparedStatement=conn.prepareStatement(sql);		
		int resultSet=preparedStatement.executeUpdate();
			return resultSet;
			}
	public int  ModifierTerrain(int id_bien,double prix,int max_locataire,String description,String caracteristique) throws ClassNotFoundException, SQLException {
		Connection conn=GetConnection();char k='"';	
		String sql="UPDATE `terrain` SET `caracteristique` = "+k+caracteristique+k+" WHERE id_bien like "+id_bien;System.out.println("sql2  "+sql);
		PreparedStatement preparedStatement=conn.prepareStatement(sql);		System.out.println("sql2  "+sql);
		int resultSet=preparedStatement.executeUpdate();
			String sql2="UPDATE `bien` SET `prix`="+prix+" ,`max_colocataire`="+max_locataire+" ,`description`="+k+description+k+"  WHERE id_bien like "+id_bien;
			PreparedStatement preparedStatement1=conn.prepareStatement(sql2);
			int resultSet1=preparedStatement1.executeUpdate();
			System.out.println("sql2  "+sql2);

			if(resultSet!=0) {
				return resultSet;
			}else {
				return 0;
			}}
	public int  AjouterMaison( int id_bien,int nbr_chambre,int nbr_facade,Boolean jardin,Boolean parking)  throws ClassNotFoundException, SQLException {
		Connection conn=GetConnection();
String sql="INSERT INTO `maison`( id_bien,nbr_chambre, nbr_facade, jardin, parking)VALUES ( "+id_bien+","+nbr_chambre+","+nbr_facade+","+jardin+","+parking+")";
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			int resultSet2=preparedStatement.executeUpdate(sql);
			 return 1;}
	public int  AjouterAppartement( int id_bien,int nbr_chambre,int etage)  throws ClassNotFoundException, SQLException {
		Connection conn=GetConnection();
String sql="INSERT INTO `appartement`( id_bien,nbr_chambre, etage)VALUES ( "+id_bien+","+nbr_chambre+","+etage+")";
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			int resultSet2=preparedStatement.executeUpdate(sql);
			 return 1;}
	public int  AjouterDepot( int id_bien,int capacite_stockage,String type)  throws ClassNotFoundException, SQLException {
		Connection conn=GetConnection();char k='"';
String sql="INSERT INTO `depot`( id_bien,capacite_stockage, type )VALUES ( "+id_bien+","+capacite_stockage+","+k+type+k+")";
System.out.println(""+sql);		
PreparedStatement preparedStatement=conn.prepareStatement(sql);
			int resultSet2=preparedStatement.executeUpdate(sql);
			 return 1;}
	public int  AjouterGarage( int id_bien,int capacite_vehicule)  throws ClassNotFoundException, SQLException {
		Connection conn=GetConnection();
String sql="INSERT INTO `garage`( id_bien,capacite_vehicule )VALUES ( "+id_bien+","+capacite_vehicule+")";
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			int resultSet2=preparedStatement.executeUpdate(sql);
			 return 1;}
	public int  AjouterLocaleCommercial( int id_bien, double distance_centre,String type_local )  throws ClassNotFoundException, SQLException {
		Connection conn=GetConnection();char k='"';
String sql="INSERT INTO `locale_commercial`( id_bien,type_local ,distance_centre )VALUES ( "+id_bien+","+k+type_local+k+","+distance_centre+")";
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			int resultSet2=preparedStatement.executeUpdate(sql);
			 return 1;}
	public int  AjouterTerrain( int id_bien,String caracteristique 	)  throws ClassNotFoundException, SQLException {
		Connection conn=GetConnection();
		char k='"'; 
String sql="INSERT INTO `terrain`( id_bien,caracteristique )VALUES ( "+id_bien+","+k+caracteristique+k+")";
System.out.println(""+sql);
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			int resultSet2=preparedStatement.executeUpdate(sql);
			 return 1;}
	public int  Ajouterbien( int id_personne, double superficie, int wilaya, double prix, String description, String adresse,
			int max_colocataire ,String ajoute1,String ajoute2,String ajoute3,String ajoute4,String ajoute5)  throws ClassNotFoundException, SQLException {
		Connection conn=GetConnection();char k='"';
String sql="INSERT INTO `bien` ( `id_personne`, `superficie`, `wilaya`, `prix`, `description`, `adresse`, `etat_bien`, `max_colocataire`, `ajoute1`, `ajoute2`, `ajoute3`, `ajoute4`, `ajoute5`) VALUES "+
 "("+id_personne+","+superficie+","+wilaya+","+prix+","+k+description+k+","+k+adresse+k+","+k+"non approuve"+k+","+max_colocataire+","+k+ajoute1+k+","+k+ajoute2+k+","+k+ajoute3+k+","+k+ajoute4+k+","+k+ajoute5+k+")";
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			System.out.println(""+sql);
			int resultSet=preparedStatement.executeUpdate();
	            String sql2="select * from `bien` where id_bien LIKE (SELECT MAX( id_bien ) from bien) ";
	            System.out.println(""+sql2);
				PreparedStatement preparedStatement1=conn.prepareStatement(sql2);
			ResultSet r=	preparedStatement1.executeQuery();
			int code=0;
				if(r.next()) {
				code=	r.getInt("id_bien");
				}
return code;
	}
	
	public int  SupprimerCompteProprietaire(int id_personne) throws ClassNotFoundException, SQLException {
		Connection conn=GetConnection();char k='"';
		String sql="UPDATE `proprietaire` SET `type_pro` = "+k+"supprime"+k+" WHERE `id_personne` ="+id_personne;
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			int resultSet=0;
			resultSet=preparedStatement.executeUpdate();
			if(resultSet!=0) {
				return resultSet;
			}else {
				return 0;
			}
			}
	public int  SupprimerBienProprietaire(int id_bien) throws ClassNotFoundException, SQLException {
		Connection conn=GetConnection();char k='"';
		String sql="UPDATE `bien` SET `etat_bien` = "+k+"supprime"+k+" WHERE `id_bien` ="+id_bien;
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			int resultSet=0;
			resultSet=preparedStatement.executeUpdate();
			if(resultSet!=0) {
				return resultSet;
			}else {
				return 0;
			}
			}
	public int  Ajouterlocation(int id_bien, Date date_debut,Date date_fin,String mode_pay) throws ClassNotFoundException, SQLException {
		Connection conn=GetConnection();char k='"';
		String sql="INSERT INTO `location` (`id_bien`,  `date_debut`, `date_fin`, `mode_pay`,`etat_location`) VALUES (?,?,?,?,?)";
		System.out.println(""+sql);
		PreparedStatement preparedStatement=conn.prepareStatement(sql);
		System.out.println(""+sql);

			preparedStatement.setInt(1,id_bien);
			java.sql.Date d=(java.sql.Date)new java.sql.Date(date_debut.getTime());
			java.sql.Date f=(java.sql.Date)new java.sql.Date(date_fin.getTime());
			preparedStatement.setDate(2,d);
			preparedStatement.setDate(3,f);
			preparedStatement.setString(4,mode_pay);
			preparedStatement.setString(5,"non approuve");

			int resultSet=0;
			resultSet=preparedStatement.executeUpdate();
	

			String sql2="SELECT * FROM `location` where id_location LIKE (SELECT MAX( id_location ) from location) " ;
		 System.out.println(""+sql2);
			ResultSet resultSet2=preparedStatement.executeQuery(sql2);
		 int resultat=0;
		 if(resultSet2.next()) {
	 resultat=resultSet2.getInt("id_location");}
	return resultat;
	}
	
	
	public int  AjouterFact(int id_personne,int id_location,double montant) throws ClassNotFoundException, SQLException {
		Connection conn=GetConnection();
		String sql="INSERT INTO `facture` ( `id_location`, `id_personne`, `montant`) VALUES (?, ?, ?)";
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			preparedStatement.setInt(1,id_location);
			preparedStatement.setInt(2,id_personne);
            preparedStatement.setDouble(3,montant);
    		System.out.println(""+sql);
    		System.out.println(""+id_personne);

            int resultSet=preparedStatement.executeUpdate();     
            String sql2="select * from `facture` where code_fact LIKE (SELECT MAX( code_fact ) from facture) ";
            System.out.println(""+sql2);
			PreparedStatement preparedStatement1=conn.prepareStatement(sql2);
		ResultSet r=	preparedStatement1.executeQuery();
		int code=0;
			if(r.next()) {
			code=	r.getInt("code_fact");
			}

            
            return code;
	}
	public double GetPrix(int id_bien_louer) throws ClassNotFoundException, SQLException {
		Connection conn=GetConnection();
		String sql="SELECT * FROM `bien` where id_bien like ? ";
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			preparedStatement.setInt(1,id_bien_louer);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				return resultSet.getDouble("prix");
			}return 0; }
	
	public Boolean islouer(int id_bien_louer,Date date_debut,Date date_fin) throws ClassNotFoundException, SQLException {
		Connection conn=GetConnection();char k='"';
		java.sql.Date d=(java.sql.Date)new java.sql.Date(date_debut.getTime());
		java.sql.Date g=(java.sql.Date)new java.sql.Date(date_fin.getTime());
String sql="SELECT * FROM `location` where (id_bien like "+id_bien_louer+" )and( ("+k+d+k+" < date_debut and "+k+g+k+" > date_fin  ) or("+k+d+k+" between date_debut and date_fin and "+k+g+k+" > date_fin  ) or ( "+k+g+k+" between date_debut and date_fin and "+k+d+k+" < date_debut )or( "+k+d+k+" between date_debut and date_fin and  "+k+g+k+" between date_debut and date_fin )) "
										+ "and (etat_location like 'approuve' )";

		System.out.println(""+d);
		System.out.println(""+g);
		System.out.println(""+sql);

			PreparedStatement preparedStatement=conn.prepareStatement(sql);

			ResultSet resultSet=preparedStatement.executeQuery();int n=0;
			if(resultSet.next()) {
			return true;	
			}else{return false;}}
	public Boolean is_plane(int id_bien_louer,Date date_debut,Date date_fin) throws ClassNotFoundException, SQLException {
		Connection conn=GetConnection();char k='"';
		java.sql.Date d=(java.sql.Date)new java.sql.Date(date_debut.getTime());
		java.sql.Date g=(java.sql.Date)new java.sql.Date(date_fin.getTime());
String sql="SELECT * FROM `location` where (id_bien like "+id_bien_louer+" )and( ("+k+d+k+" < date_debut and "+k+g+k+" > date_fin  ) or("+k+d+k+" between date_debut and date_fin and "+k+g+k+" > date_fin  ) or ( "+k+g+k+" between date_debut and date_fin and "+k+d+k+" < date_debut )or( "+k+d+k+" between date_debut and date_fin and  "+k+g+k+" between date_debut and date_fin )) "
										+ "and ((etat_location like 'approuve' )or(etat_location like 'non approuve'))";

		System.out.println(""+d);
		System.out.println(""+g);
		System.out.println(""+sql);

			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();int n=0;
			while(resultSet.next()) {
				n++;
			
			}
			if(GetMaxColocataire(id_bien_louer)==n) {
				return true;
			}else {
				return false;
			}
			
			
	}
	public int nbr_locataire_exist(int id_bien_louer,Date date_debut,Date date_fin) throws ClassNotFoundException, SQLException {
		Connection conn=GetConnection();char k='"';
		java.sql.Date d=(java.sql.Date)new java.sql.Date(date_debut.getTime());
		java.sql.Date g=(java.sql.Date)new java.sql.Date(date_fin.getTime());
String sql="SELECT * FROM `location` where (id_bien like "+id_bien_louer+" )and( ("+k+d+k+" < date_debut and "+k+g+k+" > date_fin  ) or("+k+d+k+" between date_debut and date_fin and "+k+g+k+" > date_fin  ) or ( "+k+g+k+" between date_debut and date_fin and "+k+d+k+" < date_debut )or( "+k+d+k+" between date_debut and date_fin and  "+k+g+k+" between date_debut and date_fin )) "
										+ "and ((etat_location like 'approuve' )or(etat_location like 'non approuve'))";

		System.out.println(""+d);
		System.out.println(""+g);
		System.out.println(""+sql);

			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();int n=0;
			while(resultSet.next()) {
				n++;
			
			}
			return n;
			
			
	}
	public Boolean isDernierBien(int id_personne,int id_bien) throws ClassNotFoundException, SQLException {
		Connection conn=GetConnection();char k='"';
	
String sql="SELECT * FROM bien where id_personne like "+id_personne+" and etat_bien not like "+k+"supprime"+k;          
								
		System.out.println(""+sql);

			PreparedStatement preparedStatement=conn.prepareStatement(sql);

			ResultSet resultSet=preparedStatement.executeQuery();int n=0;
			while(resultSet.next()) {
			n++;
			}
			if(n==1) {
			return true;}else {
				return false ;}
			}
	public Boolean islouer(int id_bien) throws ClassNotFoundException, SQLException {
		Connection conn=GetConnection();char k='"';
String sql="SELECT * FROM `location` where id_bien like "+id_bien+" and CURDATE()  between date_debut and  date_fin" ;

		System.out.println(""+sql);

			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();int n=0;
			if(resultSet.next()) {
			return true;	
			}else{return false;}}
	public Boolean a_des_location(int id_bien) throws ClassNotFoundException, SQLException {
		Connection conn=GetConnection();char k='"';
String sql="SELECT * FROM `location`  where id_bien like "+id_bien+" and etat_location not like "+k+"supprime"+k;

		System.out.println(""+sql);

			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();int n=0;
			if(resultSet.next()) {
			return true;	
			}else{return false;}}
	
	public Boolean isAtt(int id_bien_louer,Date date_debut,Date date_fin) throws ClassNotFoundException, SQLException {
		Connection conn=GetConnection();char k='"';
		java.sql.Date d=(java.sql.Date)new java.sql.Date(date_debut.getTime());
		java.sql.Date g=(java.sql.Date)new java.sql.Date(date_fin.getTime());
		String sql="SELECT * FROM `location` where (id_bien like "+id_bien_louer+" )and( ("+k+d+k+" < date_debut and "+k+g+k+" > date_fin  ) or("+k+d+k+" between date_debut and date_fin and "+k+g+k+" > date_fin  ) or ( "+k+g+k+" between date_debut and date_fin and "+k+d+k+" < date_debut )or( "+k+d+k+" between date_debut and date_fin and  "+k+g+k+" between date_debut and date_fin )) "
				+ "and (etat_location like 'non approuve' )";
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			System.out.println(""+sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				return true;
			}else{return false;}	}
	public String GetNamePersonne(int id_personne) throws ClassNotFoundException, SQLException {
		Connection conn=GetConnection();String n=null;
		String sql="SELECT * FROM `personne` where id_personne like ? ";
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			preparedStatement.setInt(1,id_personne);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
			 n=resultSet.getString("prenom")+"  "+resultSet.getString("nom");
			} return n;
			}
	public int GetNumCart(int id_personne) throws ClassNotFoundException, SQLException {
		Connection conn=GetConnection();int n=0;
		String sql="SELECT * FROM `personne` where id_personne like ? ";
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			preparedStatement.setInt(1,id_personne);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
			 n=resultSet.getInt("cart_identite");
			} return n;
			}
	public String GetContenueCol(String nom,int id_bien) throws ClassNotFoundException, SQLException {
		Connection conn=GetConnection();String n=null;
		String sql="SELECT "+nom+" FROM `bien` where id_bien like "+id_bien;
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
			 n=resultSet.getString(1);
			} return n;
			}
	public int GetIdPersonne(int id_bien) throws ClassNotFoundException, SQLException {
		Connection conn=GetConnection();int n=0;
		String sql="SELECT * FROM `bien` where id_bien like ? ";
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			preparedStatement.setInt(1,id_bien);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
			 n=resultSet.getInt("id_personne");
			} return n;
			}
	public ArrayList<commentaire> GetListCommentaire(int id_bien) throws ClassNotFoundException, SQLException {
		Connection conn=GetConnection();
		ArrayList<commentaire> listc=new ArrayList<commentaire>();
		String sql="SELECT * FROM `commentaire` where id_bien like ? ";
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			preparedStatement.setInt(1,id_bien);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				int id_commentaire=resultSet.getInt("id_commentaire");
			
			String nom_ecri= resultSet.getString("nom_ecri");
			String contenue= resultSet.getString("contenue");
			commentaire c=new commentaire(id_commentaire, id_bien, nom_ecri, contenue);
			listc.add(c);
			} return listc;
			}
	public ArrayList<location> GetLocations(int id_bien) throws ClassNotFoundException, SQLException {
		Connection conn=GetConnection();
		ArrayList<location> listl=new ArrayList<location>();
		String sql="SELECT * FROM `location` where id_bien like ? and etat_location like "+'"'+"approuve"+'"'+"";
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			preparedStatement.setInt(1,id_bien);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
			int id_location=resultSet.getInt("id_location");

			String mode_pay=resultSet.getString("mode_pay");
			Date date_debut=resultSet.getDate("date_debut");
			Date date_fin=resultSet.getDate("date_fin");
			String etat_location =resultSet.getString("etat_location");
	      location l=new location(id_location, id_bien,date_debut, date_fin, mode_pay, etat_location);
			listl.add(l);
			} return listl;
			}
	public ArrayList<location> GetLocations_non_approuve(int id_bien) throws ClassNotFoundException, SQLException {
		Connection conn=GetConnection();
		ArrayList<location> listl=new ArrayList<location>();
		String sql="SELECT * FROM `location` where id_bien like ? and etat_location like "+'"'+"non approuve"+'"'+"";
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			preparedStatement.setInt(1,id_bien);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
			int id_location=resultSet.getInt("id_location");

			String mode_pay=resultSet.getString("mode_pay");
			Date date_debut=resultSet.getDate("date_debut");
			Date date_fin=resultSet.getDate("date_fin");
			String etat_location =resultSet.getString("etat_location");
	      location l=new location(id_location, id_bien,date_debut, date_fin, mode_pay, etat_location);
			listl.add(l);
			} return listl;
			}
	public maison GetInfo(int id_bien) throws ClassNotFoundException, SQLException {
		Connection conn=GetConnection();
		maison m=null;
		String sql="SELECT * FROM `maison`,`bien` where maison.id_bien=bien.id_bien and maison.id_bien like ? ";
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			preparedStatement.setInt(1,id_bien);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				int id_bien1=resultSet.getInt("id_bien");
				int id_personne1=resultSet.getInt("id_personne");
				double superficie1=resultSet.getDouble("superficie");
				int wilaya1=resultSet.getInt("wilaya");
				double prix1=resultSet.getDouble("prix");
				String description=resultSet.getString("description");
				String adresse1=resultSet.getString("adresse");
				String etat_bien1=resultSet.getString("etat_bien");
				int max_colocataire=resultSet.getInt("max_colocataire");
				String image1=resultSet.getString("image1");
				String image2=resultSet.getString("image2");
				String image3=resultSet.getString("image3");
				String image4=resultSet.getString("image4");
				String image5=resultSet.getString("image5");
				int nbr_facade1=resultSet.getInt("nbr_facade");
				int nbr_chambre1=resultSet.getInt("nbr_chambre");
				boolean jardin1=resultSet.getBoolean("jardin");
				boolean parking1=resultSet.getBoolean("parking");
	            m=new maison(id_bien1, id_personne1, superficie1, wilaya1, prix1, description, adresse1,
	            etat_bien1,max_colocataire, image1, image2, image3, image4, image5, nbr_chambre1, nbr_facade1, jardin1, parking1);
	}return m;
	}
	public appartement GetInfoAppartement(int id_bien) throws ClassNotFoundException, SQLException {
		Connection conn=GetConnection();
		appartement a=null;
		String sql="SELECT * FROM `appartement`,`bien` where appartement.id_bien=bien.id_bien and appartement.id_bien like ? ";
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			preparedStatement.setInt(1,id_bien);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				int id_bien1=resultSet.getInt("id_bien");
				int id_personne1=resultSet.getInt("id_personne");
				double superficie1=resultSet.getDouble("superficie");
				int wilaya1=resultSet.getInt("wilaya");
				double prix1=resultSet.getDouble("prix");
				String description=resultSet.getString("description");
				String adresse1=resultSet.getString("adresse");
				String etat_bien1=resultSet.getString("etat_bien");
				int max_colocataire=resultSet.getInt("max_colocataire");
				String image1=resultSet.getString("image1");
				String image2=resultSet.getString("image2");
				String image3=resultSet.getString("image3");
				String image4=resultSet.getString("image4");
				String image5=resultSet.getString("image5");
				int etage1=resultSet.getInt("etage");
				
				int nbr_chambre=resultSet.getInt("nbr_chambre");
	            a=new appartement(id_bien1, id_personne1, superficie1, wilaya1, prix1, description, adresse1,
	            etat_bien1,max_colocataire, image1, image2, image3, image4, image5,etage1,nbr_chambre);
	}return a;
	}
	public depot GetInfoDepot(int id_bien) throws ClassNotFoundException, SQLException {
		Connection conn=GetConnection();
		depot d=null;
		String sql="SELECT * FROM `depot`,`bien` where depot.id_bien=bien.id_bien and depot.id_bien like ? ";
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			preparedStatement.setInt(1,id_bien);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				int id_bien1=resultSet.getInt("id_bien");
				int id_personne1=resultSet.getInt("id_personne");
				double superficie1=resultSet.getDouble("superficie");
				int wilaya1=resultSet.getInt("wilaya");
				double prix1=resultSet.getDouble("prix");
				String description=resultSet.getString("description");
				String adresse1=resultSet.getString("adresse");
				String etat_bien1=resultSet.getString("etat_bien");
				int max_colocataire=resultSet.getInt("max_colocataire");
				String image1=resultSet.getString("image1");
				String image2=resultSet.getString("image2");
				String image3=resultSet.getString("image3");
				String image4=resultSet.getString("image4");
				String image5=resultSet.getString("image5");
				int capacite_stockage=resultSet.getInt("capacite_stockage");
				String type1=resultSet.getString("type");
 d=new depot(id_bien1, id_personne1, superficie1, wilaya1, prix1, description, adresse1, etat_bien1,max_colocataire, image1, image2, image3, image4, image5, capacite_stockage, type1);
	}return d;
	}
	public garage GetInfoGarage(int id_bien) throws ClassNotFoundException, SQLException {
		Connection conn=GetConnection();
		garage g=null;
		String sql="SELECT * FROM `garage`,`bien` where garage.id_bien=bien.id_bien and garage.id_bien like ? ";
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			preparedStatement.setInt(1,id_bien);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				int id_bien1=resultSet.getInt("id_bien");
				int id_personne1=resultSet.getInt("id_personne");
				double superficie1=resultSet.getDouble("superficie");
				int wilaya1=resultSet.getInt("wilaya");
				double prix1=resultSet.getDouble("prix");
				String description=resultSet.getString("description");
				String adresse1=resultSet.getString("adresse");
				String etat_bien1=resultSet.getString("etat_bien");
				int max_colocataire=resultSet.getInt("max_colocataire");
				String image1=resultSet.getString("image1");
				String image2=resultSet.getString("image2");
				String image3=resultSet.getString("image3");
				String image4=resultSet.getString("image4");
				String image5=resultSet.getString("image5");
				int capacite_vehicule1=resultSet.getInt("capacite_vehicule");
			 g=new garage(id_bien1, id_personne1, superficie1, wilaya1, prix1, description, adresse1, etat_bien1,max_colocataire, image1, image2, image3, image4, image5, capacite_vehicule1);
	}return g;
	}
	public terrain GetInfoTerrain(int id_bien) throws ClassNotFoundException, SQLException {
		Connection conn=GetConnection();
		terrain t=null;
		String sql="SELECT * FROM `terrain`,`bien` where terrain.id_bien=bien.id_bien and terrain.id_bien like ? ";
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			preparedStatement.setInt(1,id_bien);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				int id_bien1=resultSet.getInt("id_bien");
				int id_personne1=resultSet.getInt("id_personne");
				double superficie1=resultSet.getDouble("superficie");
				int wilaya1=resultSet.getInt("wilaya");
				double prix1=resultSet.getDouble("prix");
				String description=resultSet.getString("description");
				String adresse1=resultSet.getString("adresse");
				String etat_bien1=resultSet.getString("etat_bien");
				int max_colocataire=resultSet.getInt("max_colocataire");
				String image1=resultSet.getString("image1");
				String image2=resultSet.getString("image2");
				String image3=resultSet.getString("image3");
				String image4=resultSet.getString("image4");
				String image5=resultSet.getString("image5");
				String caracteristique1=resultSet.getString("caracteristique");
				t=new terrain(id_bien1, id_personne1, superficie1, wilaya1, prix1, description, adresse1, etat_bien1,max_colocataire, image1, image2, image3, image4, image5, caracteristique1);
			}return t;
	}
	public locale_commercial GetInfoLocale(int id_bien) throws ClassNotFoundException, SQLException {
		Connection conn=GetConnection();
		locale_commercial l=null;
		String sql="SELECT * FROM `locale_commercial`,`bien` where locale_commercial.id_bien=bien.id_bien and locale_commercial.id_bien like ? ";
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			preparedStatement.setInt(1,id_bien);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				int id_bien1=resultSet.getInt("id_bien");
				int id_personne1=resultSet.getInt("id_personne");
				double superficie1=resultSet.getDouble("superficie");
				int wilaya1=resultSet.getInt("wilaya");
				double prix1=resultSet.getDouble("prix");
				String description=resultSet.getString("description");
				String adresse1=resultSet.getString("adresse");
				String etat_bien1=resultSet.getString("etat_bien");
				int max_colocataire=resultSet.getInt("max_colocataire");
				String image1=resultSet.getString("image1");
				String image2=resultSet.getString("image2");
				String image3=resultSet.getString("image3");
				String image4=resultSet.getString("image4");
				String image5=resultSet.getString("image5");
				String type_local1=resultSet.getString("type_local");
				double distance_centre1=resultSet.getDouble("distance_centre");
				 l=new locale_commercial(id_bien1, id_personne1, superficie1, wilaya1, prix1, description, adresse1, etat_bien1,max_colocataire, image1, image2, image3, image4, image5, distance_centre1,type_local1);
				}return l;
	
	}
	
	public ArrayList<maison> NewsMaison() throws SQLException, ClassNotFoundException{
		Connection conn=GetConnection();
		ArrayList<maison> list=new ArrayList<maison>();
			String sql="SELECT * FROM `maison`,`bien` where maison.id_bien=bien.id_bien  ORDER BY maison.id_bien DESC limit 3";
			PreparedStatement preparedStatement=conn.prepareStatement(sql);	System.out.println(""+sql);
           
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				int id_bien1=resultSet.getInt("id_bien");
				int id_personne1=resultSet.getInt("id_personne");
				double superficie1=resultSet.getDouble("superficie");
				int wilaya1=resultSet.getInt("wilaya");
				double prix1=resultSet.getDouble("prix");
				String description=resultSet.getString("description");
				String adresse1=resultSet.getString("adresse");
				String etat_bien1=resultSet.getString("etat_bien");
				int max_colocataire=resultSet.getInt("max_colocataire");
				String image1=resultSet.getString("image1");
				String image2=resultSet.getString("image2");
				String image3=resultSet.getString("image3");
				String image4=resultSet.getString("image4");
				String image5=resultSet.getString("image5");
				int nbr_facade1=resultSet.getInt("nbr_facade");
				int nbr_chambre1=resultSet.getInt("nbr_chambre");
				boolean jardin1=resultSet.getBoolean("jardin");
				boolean parking1=resultSet.getBoolean("parking");
			
	            maison m=new maison(id_bien1, id_personne1, superficie1, wilaya1, prix1, description, adresse1,
	            etat_bien1,max_colocataire, image1, image2, image3, image4, image5, nbr_chambre1, nbr_facade1, jardin1, parking1);
	            list.add(m);
			    }
			return list;
	            }
	
	public ArrayList<maison> RechercherMaison(int nbr_facade,int nbr_chambre,int wilaya,double prixmax,double prixmin) throws SQLException, ClassNotFoundException{
		Connection conn=GetConnection();
		ArrayList<maison> list=new ArrayList<maison>();
		String a1=" nbr_facade like "+nbr_facade+" and ";
		String a2=" nbr_chambre like "+nbr_chambre+" and ";
		
		if(nbr_facade==-1) {
		 a1="";
		}
		if(nbr_chambre==-1) {
		 a2="";	
			}
		
			String sql="SELECT * FROM `maison`,`bien` where maison.id_bien=bien.id_bien "
					+ "and "+a1+" "+a2+" wilaya like ? and prix between ? and ? and etat_bien like "+'"'+"approuve"+'"'+"";
			PreparedStatement preparedStatement=conn.prepareStatement(sql);	System.out.println(""+sql);
			
			preparedStatement.setInt(1,wilaya);
			preparedStatement.setDouble(2,prixmin);
			preparedStatement.setDouble(3,prixmax);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				int id_bien1=resultSet.getInt("id_bien");
				int id_personne1=resultSet.getInt("id_personne");
				double superficie1=resultSet.getDouble("superficie");
				int wilaya1=resultSet.getInt("wilaya");
				double prix1=resultSet.getDouble("prix");
				String description=resultSet.getString("description");
				String adresse1=resultSet.getString("adresse");
				String etat_bien1=resultSet.getString("etat_bien");
				int max_colocataire=resultSet.getInt("max_colocataire");
				String image1=resultSet.getString("image1");
				String image2=resultSet.getString("image2");
				String image3=resultSet.getString("image3");
				String image4=resultSet.getString("image4");
				String image5=resultSet.getString("image5");
				int nbr_facade1=resultSet.getInt("nbr_facade");
				int nbr_chambre1=resultSet.getInt("nbr_chambre");
				boolean jardin1=resultSet.getBoolean("jardin");
				boolean parking1=resultSet.getBoolean("parking");
			
	            maison m=new maison(id_bien1, id_personne1, superficie1, wilaya1, prix1, description, adresse1,
	            etat_bien1,max_colocataire, image1, image2, image3, image4, image5, nbr_chambre1, nbr_facade1, jardin1, parking1);
	            list.add(m);
			    }
			return list;
	            }
	public ArrayList<maison> ShowMaison() throws SQLException, ClassNotFoundException{
		Connection conn=GetConnection();
		ArrayList<maison> list=new ArrayList<maison>();
		
		
			String sql="SELECT * FROM `maison`,`bien` where maison.id_bien=bien.id_bien "
					+ "and  etat_bien like "+'"'+"approuve"+'"'+"";
			PreparedStatement preparedStatement=conn.prepareStatement(sql);	System.out.println(""+sql);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				int id_bien1=resultSet.getInt("id_bien");
				int id_personne1=resultSet.getInt("id_personne");
				double superficie1=resultSet.getDouble("superficie");
				int wilaya1=resultSet.getInt("wilaya");
				double prix1=resultSet.getDouble("prix");
				String description=resultSet.getString("description");
				String adresse1=resultSet.getString("adresse");
				String etat_bien1=resultSet.getString("etat_bien");
				int max_colocataire=resultSet.getInt("max_colocataire");
				String image1=resultSet.getString("image1");
				String image2=resultSet.getString("image2");
				String image3=resultSet.getString("image3");
				String image4=resultSet.getString("image4");
				String image5=resultSet.getString("image5");
				int nbr_facade1=resultSet.getInt("nbr_facade");
				int nbr_chambre1=resultSet.getInt("nbr_chambre");
				boolean jardin1=resultSet.getBoolean("jardin");
				boolean parking1=resultSet.getBoolean("parking");
			
	            maison m=new maison(id_bien1, id_personne1, superficie1, wilaya1, prix1, description, adresse1,
	            etat_bien1,max_colocataire, image1, image2, image3, image4, image5, nbr_chambre1, nbr_facade1, jardin1, parking1);
	            list.add(m);
			    }
			return list;
	            }

	public maison GetMaison(int id_bien) throws SQLException, ClassNotFoundException{
		Connection conn=GetConnection();
		
			String sql="SELECT * FROM `maison`,`bien` where maison.id_bien=bien.id_bien "
					+ "and bien.id_bien like "+id_bien+" and etat_bien not like 'supprime'";
			PreparedStatement preparedStatement=conn.prepareStatement(sql);	System.out.println(""+sql);
			maison m=null;
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				int id_bien1=resultSet.getInt("id_bien");
				int id_personne1=resultSet.getInt("id_personne");
				double superficie1=resultSet.getDouble("superficie");
				int wilaya1=resultSet.getInt("wilaya");
				double prix1=resultSet.getDouble("prix");
				String description=resultSet.getString("description");
				String adresse1=resultSet.getString("adresse");
				String etat_bien1=resultSet.getString("etat_bien");
				int max_colocataire=resultSet.getInt("max_colocataire");
				String image1=resultSet.getString("image1");
				String image2=resultSet.getString("image2");
				String image3=resultSet.getString("image3");
				String image4=resultSet.getString("image4");
				String image5=resultSet.getString("image5");
				int nbr_facade1=resultSet.getInt("nbr_facade");
				int nbr_chambre1=resultSet.getInt("nbr_chambre");
				boolean jardin1=resultSet.getBoolean("jardin");
				boolean parking1=resultSet.getBoolean("parking");
			
	             m=new maison(id_bien1, id_personne1, superficie1, wilaya1, prix1, description, adresse1,
	            etat_bien1,max_colocataire, image1, image2, image3, image4, image5, nbr_chambre1, nbr_facade1, jardin1, parking1);
	           
			    }
			return m;
	            }
	public ArrayList<appartement> NewsApp() throws SQLException, ClassNotFoundException{
		Connection conn=GetConnection();
		ArrayList<appartement> list=new ArrayList<appartement>();
			String sql="SELECT * FROM `appartement`,`bien` where appartement.id_bien=bien.id_bien  ORDER BY appartement.id_bien DESC limit 3";
			PreparedStatement preparedStatement=conn.prepareStatement(sql);	System.out.println(""+sql);
           
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				int id_bien1=resultSet.getInt("id_bien");
				int id_personne1=resultSet.getInt("id_personne");
				double superficie1=resultSet.getDouble("superficie");
				int wilaya1=resultSet.getInt("wilaya");
				double prix1=resultSet.getDouble("prix");
				String description=resultSet.getString("description");
				String adresse1=resultSet.getString("adresse");
				String etat_bien1=resultSet.getString("etat_bien");
				int max_colocataire=resultSet.getInt("max_colocataire");
				String image1=resultSet.getString("image1");
				String image2=resultSet.getString("image2");
				String image3=resultSet.getString("image3");
				String image4=resultSet.getString("image4");
				String image5=resultSet.getString("image5");
				int etage1=resultSet.getInt("etage");
				int nbr_chambre1=resultSet.getInt("nbr_chambre");
				System.out.println(""+nbr_chambre1);
appartement a=new appartement(id_bien1, id_personne1, superficie1, wilaya1, prix1, description, adresse1, etat_bien1,max_colocataire, image1, image2, image3, image4, image5, etage1,nbr_chambre1);
	            list.add(a);
			    }
			return list;
	            }
	public ArrayList<appartement> RechercherAppartement(int etage,int nbr_chambre,int wilaya,double prixmax,double prixmin) throws SQLException, ClassNotFoundException{
		Connection conn=GetConnection();
		ArrayList<appartement> list=new ArrayList<appartement>();
		String a1=" etage like "+etage+" and ";
		String a2=" nbr_chambre like "+nbr_chambre+" and ";
		
		if(etage==-1) {
		 a1="";
		}
		if(nbr_chambre==-1) {
		 a2="";	
			}
		String sql="SELECT * FROM `appartement`,`bien` where appartement.id_bien=bien.id_bien "
				+ "and "+a1+" "+a2+" wilaya like "+wilaya+" and prix between "+prixmin+" and "+prixmax+" and etat_bien like "+'"'+"approuve"+'"'+"";
		
		PreparedStatement preparedStatement=conn.prepareStatement(sql);
			
			System.out.println(""+sql);	
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				int id_bien1=resultSet.getInt("id_bien");
				int id_personne1=resultSet.getInt("id_personne");
				double superficie1=resultSet.getDouble("superficie");
				int wilaya1=resultSet.getInt("wilaya");
				double prix1=resultSet.getDouble("prix");
				String description=resultSet.getString("description");
				String adresse1=resultSet.getString("adresse");
				String etat_bien1=resultSet.getString("etat_bien");
				int max_colocataire=resultSet.getInt("max_colocataire");
				String image1=resultSet.getString("image1");
				String image2=resultSet.getString("image2");
				String image3=resultSet.getString("image3");
				String image4=resultSet.getString("image4");
				String image5=resultSet.getString("image5");
				int etage1=resultSet.getInt("etage");
				int nbr_chambre1=resultSet.getInt("nbr_chambre");
				System.out.println(""+nbr_chambre1);
appartement a=new appartement(id_bien1, id_personne1, superficie1, wilaya1, prix1, description, adresse1, etat_bien1,max_colocataire, image1, image2, image3, image4, image5, etage1,nbr_chambre1);
	            list.add(a);
			    }
			return list;
	            }
	public ArrayList<appartement> ShowAppartement() throws SQLException, ClassNotFoundException{
		Connection conn=GetConnection();
		ArrayList<appartement> list=new ArrayList<appartement>();
		
		String sql="SELECT * FROM `appartement`,`bien` where appartement.id_bien=bien.id_bien "
				+ " and etat_bien like "+'"'+"approuve"+'"'+"";
		
		PreparedStatement preparedStatement=conn.prepareStatement(sql);
			
			System.out.println(""+sql);	
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				int id_bien1=resultSet.getInt("id_bien");
				int id_personne1=resultSet.getInt("id_personne");
				double superficie1=resultSet.getDouble("superficie");
				int wilaya1=resultSet.getInt("wilaya");
				double prix1=resultSet.getDouble("prix");
				String description=resultSet.getString("description");
				String adresse1=resultSet.getString("adresse");
				String etat_bien1=resultSet.getString("etat_bien");
				int max_colocataire=resultSet.getInt("max_colocataire");
				String image1=resultSet.getString("image1");
				String image2=resultSet.getString("image2");
				String image3=resultSet.getString("image3");
				String image4=resultSet.getString("image4");
				String image5=resultSet.getString("image5");
				int etage1=resultSet.getInt("etage");
				int nbr_chambre1=resultSet.getInt("nbr_chambre");
				System.out.println(""+nbr_chambre1);
appartement a=new appartement(id_bien1, id_personne1, superficie1, wilaya1, prix1, description, adresse1, etat_bien1,max_colocataire, image1, image2, image3, image4, image5, etage1,nbr_chambre1);
	            list.add(a);
			    }
			return list;
	            }
	
	public appartement GetAppartement(int id_bien) throws SQLException, ClassNotFoundException{
		Connection conn=GetConnection();
		appartement a=null;
		
		String sql="SELECT * FROM `appartement`,`bien` where appartement.id_bien=bien.id_bien "
				+ "and bien.id_bien like "+id_bien+" and etat_bien not like 'supprime'";
		PreparedStatement preparedStatement=conn.prepareStatement(sql);
			
			System.out.println(""+sql);	
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				int id_bien1=resultSet.getInt("id_bien");
				int id_personne1=resultSet.getInt("id_personne");
				double superficie1=resultSet.getDouble("superficie");
				int wilaya1=resultSet.getInt("wilaya");
				double prix1=resultSet.getDouble("prix");
				String description=resultSet.getString("description");
				String adresse1=resultSet.getString("adresse");
				String etat_bien1=resultSet.getString("etat_bien");
				int max_colocataire=resultSet.getInt("max_colocataire");
				String image1=resultSet.getString("image1");
				String image2=resultSet.getString("image2");
				String image3=resultSet.getString("image3");
				String image4=resultSet.getString("image4");
				String image5=resultSet.getString("image5");
				int etage1=resultSet.getInt("etage");
				int nbr_chambre1=resultSet.getInt("nbr_chambre");
				System.out.println(""+nbr_chambre1);
 a=new appartement(id_bien1, id_personne1, superficie1, wilaya1, prix1, description, adresse1, etat_bien1,max_colocataire, image1, image2, image3, image4, image5, etage1,nbr_chambre1);
			}
			return a;
	            }
	public ArrayList<locale_commercial> Newslocale() throws SQLException, ClassNotFoundException{
		Connection conn=GetConnection();
		ArrayList<locale_commercial> list=new ArrayList<locale_commercial>();
			String sql="SELECT * FROM `locale_commercial`,`bien` where locale_commercial.id_bien=bien.id_bien  ORDER BY locale_commercial.id_bien DESC limit 3";
			PreparedStatement preparedStatement=conn.prepareStatement(sql);	System.out.println(""+sql);
           
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				int id_bien1=resultSet.getInt("id_bien");
				int id_personne1=resultSet.getInt("id_personne");
				double superficie1=resultSet.getDouble("superficie");
				int wilaya1=resultSet.getInt("wilaya");
				double prix1=resultSet.getDouble("prix");
				String description=resultSet.getString("description");
				String adresse1=resultSet.getString("adresse");
				String etat_bien1=resultSet.getString("etat_bien");
				int max_colocataire=resultSet.getInt("max_colocataire");
				String image1=resultSet.getString("image1");
				String image2=resultSet.getString("image2");
				String image3=resultSet.getString("image3");
				String image4=resultSet.getString("image4");
				String image5=resultSet.getString("image5");
				String type_local1=resultSet.getString("type_local");
				double distance_centre1=resultSet.getDouble("distance_centre");
				locale_commercial l=new locale_commercial(id_bien1, id_personne1, superficie1, wilaya1, prix1, description, adresse1, etat_bien1,max_colocataire, image1, image2, image3, image4, image5, distance_centre1, type_local1);
	            list.add(l);
			    }
			return list;
	            }
	public ArrayList<locale_commercial> RechercherLocaleCommercial(String type_local,double dmax,double dmin,int wilaya,double prixmax,double prixmin) throws SQLException, ClassNotFoundException{
		Connection conn=GetConnection();
		ArrayList<locale_commercial> list=new ArrayList<locale_commercial>();
		String sql="SELECT * FROM `locale_commercial`,`bien` where locale_commercial.id_bien=bien.id_bien "
				+ "and type_local like ? and distance_centre between ? and ? and wilaya like ? and prix between ? and ? and etat_bien like "+'"'+"approuve"+'"'+"";
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			preparedStatement.setString(1,type_local);
			preparedStatement.setDouble(2,dmin);
			preparedStatement.setDouble(3,dmax);
			preparedStatement.setInt(4,wilaya);
			preparedStatement.setDouble(5,prixmin);
			preparedStatement.setDouble(6,prixmax);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				int id_bien1=resultSet.getInt("id_bien");
				int id_personne1=resultSet.getInt("id_personne");
				double superficie1=resultSet.getDouble("superficie");
				int wilaya1=resultSet.getInt("wilaya");
				double prix1=resultSet.getDouble("prix");
				String description=resultSet.getString("description");
				String adresse1=resultSet.getString("adresse");
				String etat_bien1=resultSet.getString("etat_bien");
				int max_colocataire=resultSet.getInt("max_colocataire");
				String image1=resultSet.getString("image1");
				String image2=resultSet.getString("image2");
				String image3=resultSet.getString("image3");
				String image4=resultSet.getString("image4");
				String image5=resultSet.getString("image5");
				String type_local1=resultSet.getString("type_local");
				double distance_centre1=resultSet.getDouble("distance_centre");
				locale_commercial l=new locale_commercial(id_bien1, id_personne1, superficie1, wilaya1, prix1, description, adresse1, etat_bien1,max_colocataire, image1, image2, image3, image4, image5, distance_centre1, type_local);
	            list.add(l);
			    }
			return list;
	            }
	public ArrayList<locale_commercial> ShowLocaleCommercial() throws SQLException, ClassNotFoundException{
		Connection conn=GetConnection();
		ArrayList<locale_commercial> list=new ArrayList<locale_commercial>();
		String sql="SELECT * FROM `locale_commercial`,`bien` where locale_commercial.id_bien=bien.id_bien "
				+ " and etat_bien like "+'"'+"approuve"+'"'+"";
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				int id_bien1=resultSet.getInt("id_bien");
				int id_personne1=resultSet.getInt("id_personne");
				double superficie1=resultSet.getDouble("superficie");
				int wilaya1=resultSet.getInt("wilaya");
				double prix1=resultSet.getDouble("prix");
				String description=resultSet.getString("description");
				String adresse1=resultSet.getString("adresse");
				String etat_bien1=resultSet.getString("etat_bien");
				int max_colocataire=resultSet.getInt("max_colocataire");
				String image1=resultSet.getString("image1");
				String image2=resultSet.getString("image2");
				String image3=resultSet.getString("image3");
				String image4=resultSet.getString("image4");
				String image5=resultSet.getString("image5");
				String type_local1=resultSet.getString("type_local");
				double distance_centre1=resultSet.getDouble("distance_centre");
				locale_commercial l=new locale_commercial(id_bien1, id_personne1, superficie1, wilaya1, prix1, description, adresse1, etat_bien1,max_colocataire, image1, image2, image3, image4, image5, distance_centre1, type_local1);
	            list.add(l);
			    }
			return list;
	            }
	public locale_commercial GetLocaleCommercial(int id_bien) throws SQLException, ClassNotFoundException{
		Connection conn=GetConnection();
	    locale_commercial l=null;
		String sql="SELECT * FROM `locale_commercial`,`bien` where locale_commercial.id_bien=bien.id_bien "
				+ "and bien.id_bien like "+id_bien+" and etat_bien not like 'supprime'";System.out.println(""+sql);
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				int id_bien1=resultSet.getInt("id_bien");
				int id_personne1=resultSet.getInt("id_personne");
				double superficie1=resultSet.getDouble("superficie");
				int wilaya1=resultSet.getInt("wilaya");
				double prix1=resultSet.getDouble("prix");
				String description=resultSet.getString("description");
				String adresse1=resultSet.getString("adresse");
				String etat_bien1=resultSet.getString("etat_bien");
				int max_colocataire=resultSet.getInt("max_colocataire");
				String image1=resultSet.getString("image1");
				String image2=resultSet.getString("image2");
				String image3=resultSet.getString("image3");
				String image4=resultSet.getString("image4");
				String image5=resultSet.getString("image5");
				String type_local1=resultSet.getString("type_local");
				double distance_centre1=resultSet.getDouble("distance_centre");
				 l=new locale_commercial(id_bien1, id_personne1, superficie1, wilaya1, prix1, description, adresse1, etat_bien1,max_colocataire, image1, image2, image3, image4, image5, distance_centre1, type_local1);
	           
			    }
			return l;
	            }
	
	public ArrayList<depot> Newsdepot() throws SQLException, ClassNotFoundException{
		Connection conn=GetConnection();
		ArrayList<depot> list=new ArrayList<depot>();
		
			String sql="SELECT * FROM `depot`,`bien` where depot.id_bien=bien.id_bien  ORDER BY depot.id_bien DESC limit 3";
			PreparedStatement preparedStatement=conn.prepareStatement(sql);	System.out.println(""+sql);
           
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				int id_bien1=resultSet.getInt("id_bien");
				int id_personne1=resultSet.getInt("id_personne");
				double superficie1=resultSet.getDouble("superficie");
				int wilaya1=resultSet.getInt("wilaya");
				double prix1=resultSet.getDouble("prix");
				String description=resultSet.getString("description");
				String adresse1=resultSet.getString("adresse");
				String etat_bien1=resultSet.getString("etat_bien");
				int max_colocataire=resultSet.getInt("max_colocataire");
				String image1=resultSet.getString("image1");
				String image2=resultSet.getString("image2");
				String image3=resultSet.getString("image3");
				String image4=resultSet.getString("image4");
				String image5=resultSet.getString("image5");
				int capacite_stockage1=resultSet.getInt("capacite_stockage");
				String type1=resultSet.getString("type");
				depot d=new depot(id_bien1, id_personne1, superficie1, wilaya1, prix1, description, adresse1, etat_bien1,max_colocataire, image1, image2, image3, image4, image5, capacite_stockage1, type1);
	            list.add(d);
			    }
			return list;
	            }
	public ArrayList<depot> RechercherDepot(int capacite_stockage,String type,int wilaya,double prixmax,double prixmin) throws SQLException, ClassNotFoundException{
		Connection conn=GetConnection();System.out.println(" aven sql");
		ArrayList<depot> list=new ArrayList<depot>();
		String a1="  capacite_stockage like "+capacite_stockage+" and ";
		
		if(capacite_stockage==-1) {
		 a1="";
		}
		
		String sql="SELECT * FROM `depot`,`bien` where depot.id_bien=bien.id_bien "
				+ "and "+a1+"    type like ? and wilaya like ? and prix between ? and ? and etat_bien like "+'"'+"approuve"+'"'+"";
			PreparedStatement preparedStatement=conn.prepareStatement(sql);System.out.println(""+sql);
			preparedStatement.setString(1,type);
			preparedStatement.setInt(2,wilaya);
			preparedStatement.setDouble(3,prixmin);
			preparedStatement.setDouble(4,prixmax);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				int id_bien1=resultSet.getInt("id_bien");
				int id_personne1=resultSet.getInt("id_personne");
				double superficie1=resultSet.getDouble("superficie");
				int wilaya1=resultSet.getInt("wilaya");
				double prix1=resultSet.getDouble("prix");
				String description=resultSet.getString("description");
				String adresse1=resultSet.getString("adresse");
				String etat_bien1=resultSet.getString("etat_bien");
				int max_colocataire=resultSet.getInt("max_colocataire");
				String image1=resultSet.getString("image1");
				String image2=resultSet.getString("image2");
				String image3=resultSet.getString("image3");
				String image4=resultSet.getString("image4");
				String image5=resultSet.getString("image5");
				int capacite_stockage1=resultSet.getInt("capacite_stockage");
				String type1=resultSet.getString("type");
				depot d=new depot(id_bien1, id_personne1, superficie1, wilaya1, prix1, description, adresse1, etat_bien1,max_colocataire, image1, image2, image3, image4, image5, capacite_stockage1, type1);
	            list.add(d);
			    }
			return list;
	            }
	public ArrayList<depot> ShowDepot() throws SQLException, ClassNotFoundException{
		Connection conn=GetConnection();System.out.println(" aven sql");
		ArrayList<depot> list=new ArrayList<depot>();
		String sql="SELECT * FROM `depot`,`bien` where depot.id_bien=bien.id_bien "
				+ "and etat_bien like "+'"'+"approuve"+'"'+"";
			PreparedStatement preparedStatement=conn.prepareStatement(sql);System.out.println(""+sql);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				int id_bien1=resultSet.getInt("id_bien");
				int id_personne1=resultSet.getInt("id_personne");
				double superficie1=resultSet.getDouble("superficie");
				int wilaya1=resultSet.getInt("wilaya");
				double prix1=resultSet.getDouble("prix");
				String description=resultSet.getString("description");
				String adresse1=resultSet.getString("adresse");
				String etat_bien1=resultSet.getString("etat_bien");
				int max_colocataire=resultSet.getInt("max_colocataire");
				String image1=resultSet.getString("image1");
				String image2=resultSet.getString("image2");
				String image3=resultSet.getString("image3");
				String image4=resultSet.getString("image4");
				String image5=resultSet.getString("image5");
				int capacite_stockage1=resultSet.getInt("capacite_stockage");
				String type1=resultSet.getString("type");
				depot d=new depot(id_bien1, id_personne1, superficie1, wilaya1, prix1, description, adresse1, etat_bien1,max_colocataire, image1, image2, image3, image4, image5, capacite_stockage1, type1);
	            list.add(d);
			    }
			return list;
	            }
	public depot GetDepot(int id_bien) throws SQLException, ClassNotFoundException{
		Connection conn=GetConnection();
		depot d=null;System.out.println(" aven sql");
		String sql="SELECT * FROM `depot`,`bien` where depot.id_bien=bien.id_bien "
				+ "and  bien.id_bien like "+id_bien+" and etat_bien not like 'supprime'";System.out.println(""+sql);
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				int id_bien1=resultSet.getInt("id_bien");
				int id_personne1=resultSet.getInt("id_personne");
				double superficie1=resultSet.getDouble("superficie");
				int wilaya1=resultSet.getInt("wilaya");
				double prix1=resultSet.getDouble("prix");
				String description=resultSet.getString("description");
				String adresse1=resultSet.getString("adresse");
				String etat_bien1=resultSet.getString("etat_bien");
				int max_colocataire=resultSet.getInt("max_colocataire");
				String image1=resultSet.getString("image1");
				String image2=resultSet.getString("image2");
				String image3=resultSet.getString("image3");
				String image4=resultSet.getString("image4");
				String image5=resultSet.getString("image5");
				int capacite_stockage1=resultSet.getInt("capacite_stockage");
				String type1=resultSet.getString("type");
				 d=new depot(id_bien1, id_personne1, superficie1, wilaya1, prix1, description, adresse1, etat_bien1,max_colocataire, image1, image2, image3, image4, image5, capacite_stockage1, type1);
	            
			    }
			return d;
	            }
	public ArrayList<garage> Newsgarage() throws SQLException, ClassNotFoundException{
		Connection conn=GetConnection();
		ArrayList<garage> list=new ArrayList<garage>();
			String sql="SELECT * FROM `garage`,`bien` where garage.id_bien=bien.id_bien  ORDER BY garage.id_bien DESC limit 3";
			PreparedStatement preparedStatement=conn.prepareStatement(sql);	System.out.println(""+sql);
           
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				int id_bien1=resultSet.getInt("id_bien");
				int id_personne1=resultSet.getInt("id_personne");
				double superficie1=resultSet.getDouble("superficie");
				int wilaya1=resultSet.getInt("wilaya");
				double prix1=resultSet.getDouble("prix");
				String description=resultSet.getString("description");
				String adresse1=resultSet.getString("adresse");
				String etat_bien1=resultSet.getString("etat_bien");
				int max_colocataire=resultSet.getInt("max_colocataire");
				String image1=resultSet.getString("image1");
				String image2=resultSet.getString("image2");
				String image3=resultSet.getString("image3");
				String image4=resultSet.getString("image4");
				String image5=resultSet.getString("image5");
				int capacite_vehicule1=resultSet.getInt("capacite_vehicule");
				garage g=new garage(id_bien1, id_personne1, superficie1, wilaya1, prix1, description, adresse1, etat_bien1,max_colocataire, image1, image2, image3, image4, image5, capacite_vehicule1);
	            list.add(g);
			    }
			return list;
	            }
	public ArrayList<garage> RechercherGarage(int capacite_vehicule,int wilaya,double prixmax,double prixmin) throws SQLException, ClassNotFoundException{
		Connection conn=GetConnection();
		ArrayList<garage> list=new ArrayList<garage>();
		String sql="SELECT * FROM `garage`,`bien` where garage.id_bien=bien.id_bien "
				+ "and  capacite_vehicule like ?  and wilaya like ? and prix between ? and ? and etat_bien like "+'"'+"approuve"+'"'+"";
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			preparedStatement.setInt(1,capacite_vehicule);
			preparedStatement.setInt(2,wilaya);
			preparedStatement.setDouble(3,prixmin);
			preparedStatement.setDouble(4,prixmax);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				int id_bien1=resultSet.getInt("id_bien");
				int id_personne1=resultSet.getInt("id_personne");
				double superficie1=resultSet.getDouble("superficie");
				int wilaya1=resultSet.getInt("wilaya");
				double prix1=resultSet.getDouble("prix");
				String description=resultSet.getString("description");
				String adresse1=resultSet.getString("adresse");
				String etat_bien1=resultSet.getString("etat_bien");
				int max_colocataire=resultSet.getInt("max_colocataire");
				String image1=resultSet.getString("image1");
				String image2=resultSet.getString("image2");
				String image3=resultSet.getString("image3");
				String image4=resultSet.getString("image4");
				String image5=resultSet.getString("image5");
				int capacite_vehicule1=resultSet.getInt("capacite_vehicule");
				garage g=new garage(id_bien1, id_personne1, superficie1, wilaya1, prix1, description, adresse1, etat_bien1,max_colocataire, image1, image2, image3, image4, image5, capacite_vehicule1);
	            list.add(g);
			    }
			return list;
	            }
	public ArrayList<garage> ShowGarage() throws SQLException, ClassNotFoundException{
		Connection conn=GetConnection();
		ArrayList<garage> list=new ArrayList<garage>();
		String sql="SELECT * FROM `garage`,`bien` where garage.id_bien=bien.id_bien "
				+ "and   etat_bien like "+'"'+"approuve"+'"'+"";
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				int id_bien1=resultSet.getInt("id_bien");
				int id_personne1=resultSet.getInt("id_personne");
				double superficie1=resultSet.getDouble("superficie");
				int wilaya1=resultSet.getInt("wilaya");
				double prix1=resultSet.getDouble("prix");
				String description=resultSet.getString("description");
				String adresse1=resultSet.getString("adresse");
				String etat_bien1=resultSet.getString("etat_bien");
				int max_colocataire=resultSet.getInt("max_colocataire");
				String image1=resultSet.getString("image1");
				String image2=resultSet.getString("image2");
				String image3=resultSet.getString("image3");
				String image4=resultSet.getString("image4");
				String image5=resultSet.getString("image5");
				int capacite_vehicule1=resultSet.getInt("capacite_vehicule");
				garage g=new garage(id_bien1, id_personne1, superficie1, wilaya1, prix1, description, adresse1, etat_bien1,max_colocataire, image1, image2, image3, image4, image5, capacite_vehicule1);
	            list.add(g);
			    }
			return list;
	            }
	public garage GetGarage(int id_bien) throws SQLException, ClassNotFoundException{
		Connection conn=GetConnection();
		garage g=null;
		String sql="SELECT * FROM `garage`,`bien` where garage.id_bien=bien.id_bien "
				+ "and  bien.id_bien like "+id_bien+" and etat_bien not like 'supprime'";System.out.println(""+sql);
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				int id_bien1=resultSet.getInt("id_bien");
				int id_personne1=resultSet.getInt("id_personne");
				double superficie1=resultSet.getDouble("superficie");
				int wilaya1=resultSet.getInt("wilaya");
				double prix1=resultSet.getDouble("prix");
				String description=resultSet.getString("description");
				String adresse1=resultSet.getString("adresse");
				String etat_bien1=resultSet.getString("etat_bien");
				int max_colocataire=resultSet.getInt("max_colocataire");
				String image1=resultSet.getString("image1");
				String image2=resultSet.getString("image2");
				String image3=resultSet.getString("image3");
				String image4=resultSet.getString("image4");
				String image5=resultSet.getString("image5");
				int capacite_vehicule1=resultSet.getInt("capacite_vehicule");
				 g=new garage(id_bien1, id_personne1, superficie1, wilaya1, prix1, description, adresse1, etat_bien1,max_colocataire, image1, image2, image3, image4, image5, capacite_vehicule1);
			    }
			return g;
	            }
	public ArrayList<terrain> Newsterrain() throws SQLException, ClassNotFoundException{
		Connection conn=GetConnection();
		ArrayList<terrain> list=new ArrayList<terrain>();
			String sql="SELECT * FROM `terrain`,`bien` where terrain.id_bien=bien.id_bien  ORDER BY terrain.id_bien DESC limit 3";
			PreparedStatement preparedStatement=conn.prepareStatement(sql);	System.out.println(""+sql);
           
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				int id_bien1=resultSet.getInt("id_bien");
				int id_personne1=resultSet.getInt("id_personne");
				double superficie1=resultSet.getDouble("superficie");
				int wilaya1=resultSet.getInt("wilaya");
				double prix1=resultSet.getDouble("prix");
				String description=resultSet.getString("description");
				String adresse1=resultSet.getString("adresse");
				String etat_bien1=resultSet.getString("etat_bien");
				int max_colocataire=resultSet.getInt("max_colocataire");
				String image1=resultSet.getString("image1");
				String image2=resultSet.getString("image2");
				String image3=resultSet.getString("image3");
				String image4=resultSet.getString("image4");
				String image5=resultSet.getString("image5");
				String caracteristique1=resultSet.getString("caracteristique");
				terrain t=new terrain(id_bien1, id_personne1, superficie1, wilaya1, prix1, description, adresse1, etat_bien1,max_colocataire, image1, image2, image3, image4, image5, caracteristique1);
	            list.add(t);
			    }
			return list;
	            }
	public ArrayList<terrain> RechercherTerrain(String caracteristique ,int wilaya,double smax,double smin,double prixmax,double prixmin) throws SQLException, ClassNotFoundException{
		Connection conn=GetConnection();
		String tt="'"+caracteristique+"'";
		ArrayList<terrain> list=new ArrayList<terrain>();
		String sql="SELECT * FROM `terrain`,`bien` where terrain.id_bien=bien.id_bien "
				+ "and  caracteristique  ="+tt+" and wilaya like ? and superficie between ? and ? and prix between ? and ? and etat_bien like "+'"'+"approuve"+'"'+"";
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			//preparedStatement.setString(1,caracteristique );
			preparedStatement.setInt(1,wilaya);
			preparedStatement.setDouble(2,smin);
			preparedStatement.setDouble(3,smax);
			preparedStatement.setDouble(4,prixmin);
			preparedStatement.setDouble(5,prixmax);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				int id_bien1=resultSet.getInt("id_bien");
				int id_personne1=resultSet.getInt("id_personne");
				double superficie1=resultSet.getDouble("superficie");
				int wilaya1=resultSet.getInt("wilaya");
				double prix1=resultSet.getDouble("prix");
				String description=resultSet.getString("description");
				String adresse1=resultSet.getString("adresse");
				String etat_bien1=resultSet.getString("etat_bien");
				int max_colocataire=resultSet.getInt("max_colocataire");
				String image1=resultSet.getString("image1");
				String image2=resultSet.getString("image2");
				String image3=resultSet.getString("image3");
				String image4=resultSet.getString("image4");
				String image5=resultSet.getString("image5");
				String caracteristique1=resultSet.getString("caracteristique");
				terrain t=new terrain(id_bien1, id_personne1, superficie1, wilaya1, prix1, description, adresse1, etat_bien1,max_colocataire, image1, image2, image3, image4, image5, caracteristique1);
	            list.add(t);
			    }
			return list;
	            }
	public ArrayList<terrain> showTerrain() throws SQLException, ClassNotFoundException{
		Connection conn=GetConnection();
		ArrayList<terrain> list=new ArrayList<terrain>();
		String sql="SELECT * FROM `terrain`,`bien` where terrain.id_bien=bien.id_bien "
				+ "and  etat_bien like "+'"'+"approuve"+'"'+"";
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			//preparedStatement.setString(1,caracteristique );
			
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				int id_bien1=resultSet.getInt("id_bien");
				int id_personne1=resultSet.getInt("id_personne");
				double superficie1=resultSet.getDouble("superficie");
				int wilaya1=resultSet.getInt("wilaya");
				double prix1=resultSet.getDouble("prix");
				String description=resultSet.getString("description");
				String adresse1=resultSet.getString("adresse");
				String etat_bien1=resultSet.getString("etat_bien");
				int max_colocataire=resultSet.getInt("max_colocataire");
				String image1=resultSet.getString("image1");
				String image2=resultSet.getString("image2");
				String image3=resultSet.getString("image3");
				String image4=resultSet.getString("image4");
				String image5=resultSet.getString("image5");
				String caracteristique1=resultSet.getString("caracteristique");
				terrain t=new terrain(id_bien1, id_personne1, superficie1, wilaya1, prix1, description, adresse1, etat_bien1,max_colocataire, image1, image2, image3, image4, image5, caracteristique1);
	            list.add(t);
			    }
			return list;
	            }
	public terrain GetTerrain(int id_bien) throws SQLException, ClassNotFoundException{
		Connection conn=GetConnection();
		terrain t=null;
		String sql="SELECT * FROM `terrain`,`bien` where terrain.id_bien=bien.id_bien "
				+ "and  bien.id_bien like "+id_bien+" and etat_bien not like 'supprime'";System.out.println(""+sql);
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				int id_bien1=resultSet.getInt("id_bien");
				int id_personne1=resultSet.getInt("id_personne");
				double superficie1=resultSet.getDouble("superficie");
				int wilaya1=resultSet.getInt("wilaya");
				double prix1=resultSet.getDouble("prix");
				String description=resultSet.getString("description");
				String adresse1=resultSet.getString("adresse");
				String etat_bien1=resultSet.getString("etat_bien");
				int max_colocataire=resultSet.getInt("max_colocataire");
				String image1=resultSet.getString("image1");
				String image2=resultSet.getString("image2");
				String image3=resultSet.getString("image3");
				String image4=resultSet.getString("image4");
				String image5=resultSet.getString("image5");
				String caracteristique1=resultSet.getString("caracteristique");
				 t=new terrain(id_bien1, id_personne1, superficie1, wilaya1, prix1, description, adresse1, etat_bien1,max_colocataire, image1, image2, image3, image4, image5, caracteristique1);
	          
			    }
			return t;
	            }
}