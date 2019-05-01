package Controle;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Modele.appartement;
import Modele.commentaire;
import Modele.depot;
import Modele.garage;
import Modele.locale_commercial;
import Modele.location;
import Modele.maison;
import Modele.operation;
import Modele.terrain;

@WebServlet("/RechercherBienDetailServlet")
public class RechercherBienDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RechercherBienDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
int id_bien=Integer.parseInt((String)request.getParameter("id_bien"));
String type_colocation=(String)request.getParameter("type_colocation");

session.setAttribute("type_colocation",type_colocation);
System.out.println("type colocation ="+type_colocation);
session.setAttribute("id_bien",id_bien);
		//int id_bien=(int)session.getAttribute("id_bien");
		String typebien=(String)session.getAttribute("typebien");
		
		operation op=new operation();
		try {
			if(op.isMaison(id_bien)) {
			typebien="maison";	
			}
			if(op.isAppartement(id_bien)) {
				typebien="appartement";	
				}
			if(op.isDepot(id_bien)) {
				typebien="depot";	
				}
			if(op.isGarage(id_bien)) {
				typebien="garage";	
				}
			if(op.isLocale(id_bien)) {
				typebien="locale_commercial";	
				}
			if(op.isTerrain(id_bien)) {
				typebien="terrain";	
				}
			session.setAttribute("typebien",typebien);
			
		} catch (ClassNotFoundException | SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
			int id_proprietaire=0;
		
		try {
			id_proprietaire = op.GetIdPersonne(id_bien);
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(typebien.equals("maison")) {
	try {
		maison m=op.GetInfo(id_bien);
	String name=op.GetNamePersonne(id_proprietaire);
	ArrayList<commentaire> listc=op.GetListCommentaire(id_bien);
		ArrayList<location> listl=op.GetLocations(id_bien);
		session.setAttribute("maison",m);
		session.setAttribute("id_proprietaire",id_proprietaire);
		session.setAttribute("listc",listc);
		session.setAttribute("listl",listl);
response.sendRedirect("AfficherRechercheMaisonDetail.jsp");
		
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}else {if(typebien.equals("appartement")){
		appartement a;
		try {
			a = op.GetInfoAppartement(id_bien);
			String name=op.GetNamePersonne(id_proprietaire);
			ArrayList<commentaire> listc=op.GetListCommentaire(id_bien);
				ArrayList<location> listl=op.GetLocations(id_bien);
				session.setAttribute("appartement",a);
				session.setAttribute("id_proprietaire",id_proprietaire);
				session.setAttribute("listc",listc);
				session.setAttribute("listl",listl);
				response.sendRedirect("AfficherRechercherAppartementDetail.jsp");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}else {
		if(typebien.equals("depot")) {
			depot a;
			try {
				a = op.GetInfoDepot(id_bien);
				String name=	op.GetNamePersonne(id_proprietaire);
				ArrayList<commentaire> listc=op.GetListCommentaire(id_bien);
					ArrayList<location> listl=op.GetLocations(id_bien);
					session.setAttribute("depot",a);
					session.setAttribute("id_proprietaire",id_proprietaire);
					session.setAttribute("listc",listc);
					session.setAttribute("listl",listl);
					response.sendRedirect("AfficherRechercherDepotDetail.jsp");

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}else {
			if(typebien.equals("locale_commercial")) {
				locale_commercial a;
				try {
					a = op.GetInfoLocale(id_bien);
					String name=	op.GetNamePersonne(id_proprietaire);
					ArrayList<commentaire> listc=op.GetListCommentaire(id_bien);
						ArrayList<location> listl=op.GetLocations(id_bien);
						session.setAttribute("locale_commercial",a);
						session.setAttribute("id_proprietaire",id_proprietaire);
						session.setAttribute("listc",listc);
						session.setAttribute("listl",listl);
						response.sendRedirect("AfficherRechercherLocaleCommercialDetail.jsp");

				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}else {
		if(typebien.equals("garage")) {
			garage a;
			try {
				a = op.GetInfoGarage(id_bien);
				String name=	op.GetNamePersonne(id_proprietaire);
				ArrayList<commentaire> listc=op.GetListCommentaire(id_bien);
					ArrayList<location> listl=op.GetLocations(id_bien);
					session.setAttribute("garage",a);
					session.setAttribute("id_proprietaire",id_proprietaire);
					session.setAttribute("listc",listc);
					session.setAttribute("listl",listl);
					response.sendRedirect("AfficherRechercherGarageDetail.jsp");

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	}else {
				if(typebien.equals("terrain")) {
					terrain a;
					try {
						a = op.GetInfoTerrain(id_bien);
						String name=	op.GetNamePersonne(id_proprietaire);
						ArrayList<commentaire> listc=op.GetListCommentaire(id_bien);
							ArrayList<location> listl=op.GetLocations(id_bien);
							session.setAttribute("terrain",a);
							session.setAttribute("id_proprietaire",id_proprietaire);
							session.setAttribute("listc",listc);
							session.setAttribute("listl",listl);
							response.sendRedirect("AfficherRechercherTerrainDetail.jsp");

					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	}}
	}}} }}
}