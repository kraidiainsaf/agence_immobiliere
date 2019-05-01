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
import javax.swing.JOptionPane;

import Modele.operation;

@WebServlet("/AjouterCommentaireServlet")
public class AjouterCommentaireServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public AjouterCommentaireServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
HttpSession session=request.getSession();
		int id_bien=(int)session.getAttribute("id_bien_louer");
		session.setAttribute("id_bien",id_bien);
PrintWriter out=response.getWriter();
		String nom_ecri=(String)request.getParameter("nom_ecri");
		String contenue=(String)request.getParameter("contenue");
		operation op=new operation();
		try {
			op.AjouterCommentaire(id_bien, nom_ecri, contenue);
			session.setAttribute("listc",op.GetListCommentaire(id_bien));
			String typebien=(String)session.getAttribute("typebien");
			if(typebien.equals("maison")) {
				response.sendRedirect("AfficherRechercheMaisonDetail.jsp");
				
				
			}else {
				if(typebien.equals("appartement")) {
					response.sendRedirect("AfficherRechercherAppartementDetail.jsp");
					
				}else {
					if(typebien.equals("garage")) {
						response.sendRedirect("AfficherRechercherGarageDetail.jsp");
						
					}else {
						if(typebien.equals("depot")) {
							response.sendRedirect("AfficherRechercherDepotDetail.jsp");
							
						}else {
							if(typebien.equals("locale_commercial")) {
								response.sendRedirect("AfficherRechercherLocaleCommercialDetail.jsp");
								
							}else {
								response.sendRedirect("AfficherRechercherTerrainDetail.jsp");
								
							}
						}
						
					}
				}
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
