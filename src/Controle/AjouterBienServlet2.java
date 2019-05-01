package Controle;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Modele.operation;

/**
 * Servlet implementation class AjouterBienServlet2
 */
@WebServlet("/AjouterBienServlet2")
public class AjouterBienServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterBienServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//ajouter bien 
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		operation op=new operation();operation operation=new operation();
		String adresse=(String)session.getAttribute("adresse");
		String description=(String)session.getAttribute("description");
	double superficie=(double) session.getAttribute("superficie");
	double prix=(double) session.getAttribute("prix");
	int wilaya=(int) session.getAttribute("wilaya");
	int id_personne=(int) session.getAttribute("id_personne");
	try {
		op.AjoutePoints(id_personne, 5);
	} catch (ClassNotFoundException | SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}

	int max_colocataire=(int) session.getAttribute("max_colocataire");
	String ajoute1=(String)session.getAttribute("ajoute1");
	String ajoute2=(String)session.getAttribute("ajoute2");
	String ajoute3=(String)session.getAttribute("ajoute3");
	String ajoute4=(String)session.getAttribute("ajoute4");
	String ajoute5=(String)session.getAttribute("ajoute5");
	String typebien=(String)session.getAttribute("typebien");

	if(typebien.equals("maison")) {
		int nbr_chambre=(int) session.getAttribute("nbr_chambre");
		int nbr_facade=(int) session.getAttribute("nbr_facade");
boolean jardin=(boolean) session.getAttribute("jardin");
boolean parking=(boolean) session.getAttribute("parking");
	try {
	int id_bien=op.Ajouterbien(id_personne, superficie, wilaya, prix, description, adresse, max_colocataire, ajoute1, ajoute2, ajoute3, ajoute4, ajoute5);
	op.AjouterMaison(id_bien, nbr_chambre, nbr_facade, jardin, parking);
	request.setAttribute("erreur","Votre demmande d'ajoute est pris en charge !");
	
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}else {
		if(typebien.equals("appartement")) {
			int nbr_chambre=(int) session.getAttribute("nbr_chambre");
			int etage=(int) session.getAttribute("etage");
	
		try {
		int id_bien=op.Ajouterbien(id_personne, superficie, wilaya, prix, description, adresse, max_colocataire, ajoute1, ajoute2, ajoute3, ajoute4, ajoute5);
		op.AjouterAppartement(id_bien, nbr_chambre, etage);
		request.setAttribute("erreur","Votre demmande d'ajoute est pris en charge !");

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		}else {
			if(typebien.equals("depot")) {
				int capacite_stockage=(int) session.getAttribute("capacite_stockage");
				String type=(String)session.getAttribute("type");
		
			try {
			int id_bien=op.Ajouterbien(id_personne, superficie, wilaya, prix, description, adresse, max_colocataire, ajoute1, ajoute2, ajoute3, ajoute4, ajoute5);
			op.AjouterDepot(id_bien, capacite_stockage, type);
			request.setAttribute("erreur","Votre demmande d'ajoute est pris en charge !");

			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			}else {
				if(typebien.equals("garage")) {
					int capacite_vehicule=(int) session.getAttribute("capacite_vehicule");
			
				try {
				int id_bien=op.Ajouterbien(id_personne, superficie, wilaya, prix, description, adresse, max_colocataire, ajoute1, ajoute2, ajoute3, ajoute4, ajoute5);
				op.AjouterGarage(id_bien, capacite_vehicule);
				request.setAttribute("erreur","Votre demmande d'ajoute est pris en charge !");

				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				}else {
					if(typebien.equals("locale_commercial")) {
						 
						double distance_centre =(double) session.getAttribute("distance_centre");
						String type_local=(String)session.getAttribute("type_local");

					try {
					int id_bien=op.Ajouterbien(id_personne, superficie, wilaya, prix, description, adresse, max_colocataire, ajoute1, ajoute2, ajoute3, ajoute4, ajoute5);
					op.AjouterLocaleCommercial(id_bien, distance_centre,type_local);
					request.setAttribute("erreur","Votre demmande d'ajoute est pris en charge !");

					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					}else {
						String caracteristique=(String)session.getAttribute("caracteristique");

						try {
						int id_bien=op.Ajouterbien(id_personne, superficie, wilaya, prix, description, adresse, max_colocataire, ajoute1, ajoute2, ajoute3, ajoute4, ajoute5);
						op.AjouterTerrain(id_bien, caracteristique);
						request.setAttribute("erreur","Votre demmande d'ajoute est pris en charge !");

						} catch (ClassNotFoundException | SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}	
					}
				}
			}
		}
	}
response.sendRedirect("operationAjouteTerminer.jsp");

	}



}
