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

import Modele.cntrlAuthentif;
import Modele.cntrlNotif;
import Modele.location;
import Modele.operation;

/**
 * Servlet implementation class authentifg2
 */
@WebServlet("/authentifg2")
public class authentifg2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public authentifg2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session=request.getSession();

		operation op=new operation();
		
		String  pseudo=(String)session.getAttribute("pseudo");
		
		String  password=(String)session.getAttribute("password");
		int  id=(int)session.getAttribute("id_personne");
		cntrlAuthentif ct=new cntrlAuthentif();
		
			try {
				id = ct.getId(pseudo, password);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		
		
		try {
					if(ct.isAdmin(id)){
				
                response.sendRedirect("EspaceAdmin.jsp");

			}else{
			try {
				if(ct.isProprietaire(id)&&ct.isLocataire(id)){
					System.out.println(" loc pro");
					op.AjoutePoints(id,1);
					
                    response.sendRedirect("EspaceLocatair_proprietaire.jsp");

					
				}else{
					try {
						if(ct.isProprietaire(id)){
							op.AjoutePoints(id, 1);
							System.out.println(" pro");

							response.sendRedirect("EspaceProprietaire.jsp");

						}else{
							try {
								if(ct.isLocataire(id)){
									
									System.out.println(" loc ");

                                    response.sendRedirect("EspaceLocataire.jsp");
									
								}
								else{
								request.setAttribute("erreur","Ops ,Votre Compte Est Supprime !");

								RequestDispatcher DL =request.getRequestDispatcher("authentificationg.jsp");
								DL.include(request,response);
									}
							} catch (ClassNotFoundException | SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}}
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
		
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
