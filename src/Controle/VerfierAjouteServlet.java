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
 * Servlet implementation class VerfierAjouteServlet
 */
@WebServlet("/VerfierAjouteServlet")
public class VerfierAjouteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public VerfierAjouteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();operation op=new operation(); PrintWriter out=response.getWriter();
		int id_personne=(int)session.getAttribute("id_personne");
		String typebien=request.getParameter("typebien");
		session.setAttribute("typebien",typebien);
	
	if(typebien.equals("maison")) {
	
		String description=request.getParameter("description");
		session.setAttribute("description",description);
		String adresse=request.getParameter("adresse");
		session.setAttribute("adresse",adresse);
	double superficie=Double.parseDouble((String)request.getParameter("superficie"));
	session.setAttribute("superficie",superficie);
	double prix=Double.parseDouble((String)request.getParameter("prix"));
	session.setAttribute("prix",prix);
	int wilaya=Integer.parseInt((String)request.getParameter("wilaya"));
	session.setAttribute("wilaya",wilaya);
	int max_colocataire=Integer.parseInt((String)request.getParameter("max_colocataire"));
	session.setAttribute("max_colocataire",max_colocataire);
		
		int nbr_chambre=Integer.parseInt((String)request.getParameter("nbr_chambre"));
		session.setAttribute("nbr_chambre",nbr_chambre);
		int nbr_facade=Integer.parseInt((String)request.getParameter("nbr_facade"));
		session.setAttribute("nbr_facade",nbr_facade);
		Boolean jardin=Boolean.parseBoolean((String)request.getParameter("jardin"));
		session.setAttribute("jardin",jardin);
		Boolean parking=Boolean.parseBoolean((String)request.getParameter("parking"));
		session.setAttribute("parking",parking);
		Boolean result=null;
		try {
			result = op.IsExist(typebien, adresse);
			System.out.print("is exist"+result);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result.equals(true)) {
			request.setAttribute("erreur","Cette address est deja utiliser par un bien du agence verifier votre informations! ");
			RequestDispatcher DL =request.getRequestDispatcher("AjouterMaison.jsp");
			DL.forward(request,response);
			response.sendRedirect("AjouterMaison.jsp");
			
		}else {
			response.sendRedirect("AjouterContrat1.jsp");

		}
	
	}else {
		if(typebien.equals("appartement")) {
			
			String description=request.getParameter("description");
			session.setAttribute("description",description);
			String adresse=request.getParameter("adresse");
			session.setAttribute("adresse",adresse);
		double superficie=Double.parseDouble((String)request.getParameter("superficie"));
		session.setAttribute("superficie",superficie);
		double prix=Double.parseDouble((String)request.getParameter("prix"));
		session.setAttribute("prix",prix);
		int wilaya=Integer.parseInt((String)request.getParameter("wilaya"));
		session.setAttribute("wilaya",wilaya);
		int max_colocataire=Integer.parseInt((String)request.getParameter("max_colocataire"));
		session.setAttribute("max_colocataire",max_colocataire);
			
			
			int nbr_chambre=Integer.parseInt((String)request.getParameter("nbr_chambre"));
			session.setAttribute("nbr_chambre",nbr_chambre);
			int etage=Integer.parseInt((String)request.getParameter("etage"));
			session.setAttribute("etage",etage);
			
			Boolean result=null;
			try {
				result = op.IsExist(typebien, adresse);
				System.out.print("is exist"+result);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(result.equals(true)) {
				request.setAttribute("erreur","Cette address est deja utiliser par un bien du agence verifier votre informations! ");
				RequestDispatcher DL =request.getRequestDispatcher("AjouterAppartement.jsp");
				DL.forward(request,response);
				response.sendRedirect("AjouterAppartement.jsp");

			}else {
				response.sendRedirect("AjouterContrat1.jsp");

			}}else {
				if(typebien.equals("depot")) {
					
					String description=request.getParameter("description");
					session.setAttribute("description",description);
					String adresse=request.getParameter("adresse");
					session.setAttribute("adresse",adresse);
				double superficie=Double.parseDouble((String)request.getParameter("superficie"));
				session.setAttribute("superficie",superficie);
				double prix=Double.parseDouble((String)request.getParameter("prix"));
				session.setAttribute("prix",prix);
				int wilaya=Integer.parseInt((String)request.getParameter("wilaya"));
				session.setAttribute("wilaya",wilaya);
				int max_colocataire=Integer.parseInt((String)request.getParameter("max_colocataire"));
				session.setAttribute("max_colocataire",max_colocataire);
		
					
					int capacite_stockage=Integer.parseInt((String)request.getParameter("capacite_stockage"));
					session.setAttribute("capacite_stockage",capacite_stockage);
					String type=(String)request.getParameter("type");
					session.setAttribute("type",type);
					
					Boolean result=null;
					try {
						result = op.IsExist(typebien, adresse);
						System.out.print("is exist"+result);
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(result.equals(true)) {
						request.setAttribute("erreur","Cette address est deja utiliser par un bien du agence verifier votre informations! ");
						RequestDispatcher DL =request.getRequestDispatcher("AjouterDepot.jsp");
						DL.forward(request,response);
						response.sendRedirect("AjouterDepot.jsp");

					}else {
						
						response.sendRedirect("AjouterContrat1.jsp");

					}}else {
						if(typebien.equals("garage")) {
							
							String description=request.getParameter("description");
							session.setAttribute("description",description);
							String adresse=request.getParameter("adresse");
							session.setAttribute("adresse",adresse);
						double superficie=Double.parseDouble((String)request.getParameter("superficie"));
						session.setAttribute("superficie",superficie);
						double prix=Double.parseDouble((String)request.getParameter("prix"));
						session.setAttribute("prix",prix);
						int wilaya=Integer.parseInt((String)request.getParameter("wilaya"));
						session.setAttribute("wilaya",wilaya);
						int max_colocataire=Integer.parseInt((String)request.getParameter("max_colocataire"));
						session.setAttribute("max_colocataire",max_colocataire);
							
							
							int capacite_vehicule=Integer.parseInt((String)request.getParameter("capacite_vehicule"));
							session.setAttribute("capacite_vehicule",capacite_vehicule);

							
							Boolean result=null;
							try {
								result = op.IsExist(typebien, adresse);
								System.out.print("is exist"+result);
							} catch (ClassNotFoundException | SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							if(result.equals(true)) {
								request.setAttribute("erreur","Cette address est deja utiliser par un bien du agence verifier votre informations! ");
								RequestDispatcher DL =request.getRequestDispatcher("AjouterGarage.jsp");
								DL.forward(request,response);
								response.sendRedirect("AjouterGarage.jsp");

							}else {
								response.sendRedirect("AjouterContrat1.jsp");

							}}else {
								if(typebien.equals("locale_commercial")) {
									
									String description=request.getParameter("description");
									session.setAttribute("description",description);
									String adresse=request.getParameter("adresse");
									session.setAttribute("adresse",adresse);
								double superficie=Double.parseDouble((String)request.getParameter("superficie"));
								session.setAttribute("superficie",superficie);
								double prix=Double.parseDouble((String)request.getParameter("prix"));
								session.setAttribute("prix",prix);
								int wilaya=Integer.parseInt((String)request.getParameter("wilaya"));
								session.setAttribute("wilaya",wilaya);
								int max_colocataire=Integer.parseInt((String)request.getParameter("max_colocataire"));
								session.setAttribute("max_colocataire",max_colocataire);
									
									
									double distance_centre=Double.parseDouble((String)request.getParameter("distance_centre"));
									session.setAttribute("distance_centre",distance_centre);
									String type_local=(String)request.getParameter("type_local");
									session.setAttribute("type_local",type_local);
									
									Boolean result=null;
									try {
										result = op.IsExist(typebien, adresse);
										System.out.print("is exist"+result);
									} catch (ClassNotFoundException | SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									if(result.equals(true)) {
										request.setAttribute("erreur","Cette address est deja utiliser par un bien du agence verifier votre informations! ");
										RequestDispatcher DL =request.getRequestDispatcher("AjouterLocaleCommercial.jsp");
										DL.forward(request,response);
										
										response.sendRedirect("AjouterLocaleCommercial.jsp");

									}else {
										response.sendRedirect("AjouterContrat1.jsp");

									}}else {
										
										String description=request.getParameter("description");
										session.setAttribute("description",description);
										String adresse=request.getParameter("adresse");
										session.setAttribute("adresse",adresse);
									double superficie=Double.parseDouble((String)request.getParameter("superficie"));
									session.setAttribute("superficie",superficie);
									double prix=Double.parseDouble((String)request.getParameter("prix"));
									session.setAttribute("prix",prix);
									int wilaya=Integer.parseInt((String)request.getParameter("wilaya"));
									session.setAttribute("wilaya",wilaya);
									int max_colocataire=Integer.parseInt((String)request.getParameter("max_colocataire"));
									session.setAttribute("max_colocataire",max_colocataire);
										
										
										String caracteristique=(String)request.getParameter("caracteristique");
										session.setAttribute("caracteristique",caracteristique);
										
										Boolean result=null;
										try {
											result = op.IsExist(typebien, adresse);
											System.out.print("is exist"+result);
										} catch (ClassNotFoundException | SQLException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										if(result.equals(true)) {
											request.setAttribute("erreur","Cette address est deja utiliser par un bien du agence verifier votre informations! ");
											RequestDispatcher DL =request.getRequestDispatcher("AjouterTerrain.jsp");
											DL.forward(request,response);
											
											response.sendRedirect("AjouterTerrain.jsp");

									}else {
										
										response.sendRedirect("AjouterContrat1.jsp");

							}
					}
			}}}
	}


}}
