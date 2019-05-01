package Controle;

import java.io.IOException;
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
 * Servlet implementation class ModifierBienServlet2
 */
@WebServlet("/ModifierBienServlet2")
public class ModifierBienServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ModifierBienServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 HttpSession  session=request.getSession();
		 int id_bien=(int)session.getAttribute("id_bien");
		     String typebien=(String)session.getAttribute("typebien");
		     operation op=new operation();
		     System.out.println(""+typebien);
		    
		     double prix=Double.parseDouble((String)request.getParameter("prix"));
		 	String description=(String)request.getParameter(("description"));
		 int max_colocataire=Integer.parseInt((String)request.getParameter("max_colocataire"));
		 		if(typebien.equals("maison")) {
		 			
		 			 int nbr_chambre=Integer.parseInt((String)request.getParameter("nbr_chambre"));
		 			 int nbr_facade=Integer.parseInt((String)request.getParameter("nbr_facade"));
                      boolean  jardin=Boolean.parseBoolean((String)request.getParameter("jardin"));
                      boolean  parking=Boolean.parseBoolean((String)request.getParameter("parking"));

	try {
		op.ModifierMaison(id_bien, prix, max_colocataire, description, nbr_chambre, nbr_facade, jardin, parking);
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		 		}else {
		 			if(typebien.equals("appartement")) {
		 				
			 			 int nbr_chambre=Integer.parseInt((String)request.getParameter("nbr_chambre"));
			 			

		try {
			op.ModifierAppatemnet(id_bien, prix, max_colocataire, description, nbr_chambre); 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			 		}else {
			 			if(typebien.equals("depot")) {
			 				
				 			String type=(String)request.getParameter("type");
				 			

			try {
				op.ModifierDepot(id_bien, prix, max_colocataire, description, type); 
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				 		}else {
				 			if(typebien.equals("garage")) {
				 				
					 			

				try {
					op.ModifierGarage(id_bien, prix, max_colocataire, description); 
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					 		}else {
					 			if(typebien.equals("locale_commercial")) {
					 				
						 			String type_local=(String)request.getParameter("type_local");

									try {
										op.ModifierLocale(id_bien, prix, max_colocataire, description, type_local); 
									} catch (ClassNotFoundException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
										 		}else {
										 			
										 			String caracteristique=(String)request.getParameter("caracteristique");

													try {
														op.ModifierTerrain(id_bien, prix, max_colocataire, description, caracteristique);
														 	} catch (ClassNotFoundException e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
													} catch (SQLException e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
													}
														 		
										 			
										 		}
					 			
					 		}
				 		}}}

				request.setAttribute("id_bien",id_bien);
				request.setAttribute("typebien",typebien);
response.sendRedirect("MesBienServlet");
				

}}