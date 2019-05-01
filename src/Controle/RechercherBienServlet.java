package Controle;

import java.io.IOException;
import java.io.PrintWriter;
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
import Modele.depot;
import Modele.garage;
import Modele.locale_commercial;
import Modele.maison;
import Modele.operation;
import Modele.terrain;

/**
 * Servlet implementation class RechercheBienServlet
 */
@WebServlet("/RechercherBienServlet")
public class RechercherBienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public RechercherBienServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();PrintWriter out=response.getWriter();
System.out.println("id   "+session.getAttribute("id_personne"));
	String typebien=(String)request.getParameter("typebien");
	session.setAttribute("typebien",typebien);
	if(typebien.equals("maison")) {
		
		ArrayList<maison> list=new ArrayList<maison>();
		
		int nbr_facade=Integer.parseInt((String)request.getParameter("nbr_facade"));
		int nbr_chambre=Integer.parseInt((String)request.getParameter("nbr_chambre"));
		
		int wilaya=Integer.parseInt((String)request.getParameter("wilaya"));
		
		double prixmax=0;
		prixmax=Double.parseDouble((String)request.getParameter("prixmax"));
		double prixmin=0;
		prixmin=Double.parseDouble((String)request.getParameter("prixmin"));
		System.out.println(" nbc "+nbr_chambre+" nbrf "+nbr_facade+"w" +wilaya+""+prixmax+"  "+prixmin);
		operation op=new operation();
		try {
			list=op.RechercherMaison(nbr_facade, nbr_chambre, wilaya, prixmax, prixmin);
		
			if(list.isEmpty()) {
			
				request.setAttribute("erreur","Malheureusement, le resultat de la recherche est (0) resultat");
				RequestDispatcher DL =request.getRequestDispatcher("RechercherMaison.jsp");
				DL.forward(request,response);
				response.sendRedirect("AfficherRechercheMaison.jsp");

			}else {
			session.setAttribute("list",list);
		
			response.sendRedirect("AfficherRechercheMaison.jsp");
}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}else {
		if(typebien.equals("appartement")) {
			
			ArrayList<appartement> list=new ArrayList<appartement>();
			int wilaya=Integer.parseInt((String)request.getParameter("wilaya"));
			double prixmax=0;
			prixmax=Double.parseDouble(request.getParameter("prixmax"));
			double prixmin=0;
			prixmin=Double.parseDouble(request.getParameter("prixmin"));
			int etage=Integer.parseInt((String)request.getParameter("etage"));
			int nbr_chambre=Integer.parseInt((String)request.getParameter("nbr_chambre"));

			operation op=new operation();
			try {
				
			list=op.RechercherAppartement(etage,nbr_chambre, wilaya, prixmax, prixmin);
				if(list.isEmpty()) {
					request.setAttribute("erreur","Malheureusement, le resultat de la recherche est (0) resultat");
					RequestDispatcher DL =request.getRequestDispatcher("RechercherAppartement.jsp");
					DL.forward(request,response);
					response.sendRedirect("RechercherAppartement.jsp");

				}else {
				session.setAttribute("list",list);
				response.sendRedirect("AfficherRechercherAppartement.jsp");
}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}else {
		if(typebien.equals("depot")) {
			
			ArrayList<depot> list=new ArrayList<depot>();
			String type=(String)request.getParameter("type");
			int capacite_stockage=Integer.parseInt((String)request.getParameter("capacite_stockage"));
			int wilaya=Integer.parseInt((String)request.getParameter("wilaya"));
			double prixmax=0;
			prixmax=Double.parseDouble(request.getParameter("prixmax"));
			double prixmin=0;
			prixmin=Double.parseDouble(request.getParameter("prixmin"));
			operation op=new operation();
			try {
				list=op.RechercherDepot(capacite_stockage, type, wilaya, prixmax, prixmin);
			
				if(list.isEmpty()) {
					request.setAttribute("erreur","Malheureusement, le resultat de la recherche est (0) resultat");
					RequestDispatcher DL =request.getRequestDispatcher("RechercherDepot.jsp");
					DL.forward(request,response);
					response.sendRedirect("RechercherDepot.jsp");

				}else {
				session.setAttribute("list",list);
				response.sendRedirect("AfficherRechercherDepot.jsp");
}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			if(typebien.equals("locale_commercial")) {
				
				ArrayList<locale_commercial> list=new ArrayList<locale_commercial>();
				String type_local=(String)request.getParameter("type_local");
				double dmax=0;
				dmax=Double.parseDouble(request.getParameter("dmax"));
				double dmin=0;
				dmin=Double.parseDouble(request.getParameter("dmin"));
				int wilaya=Integer.parseInt((String)request.getParameter("wilaya"));
				double prixmax=0;
				prixmax=Double.parseDouble(request.getParameter("prixmax"));
				double prixmin=0;
				prixmin=Double.parseDouble(request.getParameter("prixmin"));
				operation op=new operation();
				try {
					list=op.RechercherLocaleCommercial(type_local, dmax, dmin, wilaya, prixmax, prixmin);
				
					if(list.isEmpty()) {
						request.setAttribute("erreur","Malheureusement, le resultat de la recherche est (0) resultat");
						RequestDispatcher DL =request.getRequestDispatcher("RechercherLocaleCommercial.jsp");
						DL.forward(request,response);
						response.sendRedirect("RechercherLocaleCommercial.jsp");

						
					}else {
					session.setAttribute("list",list);
					response.sendRedirect("AfficherRechercherLocaleCommercial.jsp");
}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
				}
				}else {
					if(typebien.equals("garage")) {
						
						ArrayList<garage> list=new ArrayList<garage>();
						int capacite_vehicule=Integer.parseInt((String)request.getParameter("capacite_vehicule"));
						int wilaya=Integer.parseInt((String)request.getParameter("wilaya"));
						double prixmax=0;
						prixmax=Double.parseDouble(request.getParameter("prixmax"));
						double prixmin=0;
						prixmin=Double.parseDouble(request.getParameter("prixmin"));
						operation op=new operation();
						try {
							list=op.RechercherGarage(capacite_vehicule, wilaya, prixmax, prixmin);
						
							if(list.isEmpty()) {
								request.setAttribute("erreur","Malheureusement, le resultat de la recherche est (0) resultat");
								RequestDispatcher DL =request.getRequestDispatcher("RechercherGarage.jsp");
								DL.forward(request,response);
								response.sendRedirect("RechercherGarage.jsp");

							}else {
							session.setAttribute("list",list);
							response.sendRedirect("AfficherRechercherGarage.jsp");
}
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}else {
						if(typebien.equals("terrain")) {
							
							ArrayList<terrain> list=new ArrayList<terrain>();

                            String caracteristique=(String)request.getParameter("caracteristique");
							int wilaya=Integer.parseInt((String)request.getParameter("wilaya"));
							double prixmax=0;
							prixmax=Double.parseDouble(request.getParameter("prixmax"));
							double prixmin=0;
							prixmin=Double.parseDouble(request.getParameter("prixmin"));
							double smax=0;
							smax=Double.parseDouble(request.getParameter("smax"));
							double smin=0;
							smin=Double.parseDouble(request.getParameter("smin"));
							operation op=new operation();
							try { 
								list=op.RechercherTerrain(caracteristique, wilaya, smax, smin, prixmax, prixmin);
								if(list.isEmpty()) {
									request.setAttribute("erreur","Malheureusement, le resultat de la recherche est (0) resultat");
									RequestDispatcher DL =request.getRequestDispatcher("RechercherTerrain.jsp");
									DL.forward(request,response);
									response.sendRedirect("RechercherTerrain.jsp");

								}else {
								session.setAttribute("list",list);
								response.sendRedirect("AfficherRechercherTerrain.jsp");
}
							} catch (ClassNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
			}}
	}}}
}







