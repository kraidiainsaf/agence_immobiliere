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
import Modele.cntrlCompte;
import Modele.operation;
import Modele.cntrlBien;

/**
 * Servlet implementation class AuthentificationServlet
 */
@WebServlet("/AuthentificationServlet")
public class AuthentificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthentificationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");			HttpSession session=request.getSession(true);

		PrintWriter out=response.getWriter();
		operation op=new operation();
		String  pseudo=request.getParameter("pseudo");
		String  password=request.getParameter("password");
		cntrlAuthentif ct=new cntrlAuthentif();
		int id;
		try {
			id = ct.getId(pseudo, password);
		
		if(ct.verifierAuth(pseudo, password)){
			out.println("correcte password");
			session.setAttribute("pseudo", pseudo);
			session.setAttribute("password", password);
			session.setAttribute("id_personne", id);
			if(ct.isProprietaire(id)){
				op.AjoutePoints(id, 1);
				response.sendRedirect("AjouterBien.jsp");
			 RequestDispatcher requestDispatcher = request.getRequestDispatcher("AjouterBien.jsp");
			 requestDispatcher.include(request, response);

		 }
			else{
				if(ct.isLocataire(id)){
					cntrlCompte c=new cntrlCompte();
					c.creerProprietaire(id, "non approuve",0);
					response.sendRedirect("AjouterBien.jsp");
						RequestDispatcher requestDispatcher = request.getRequestDispatcher("AjouterBien.jsp");
						 requestDispatcher.include(request, response);

				 }
			 }
		
		}
		else{
			request.setAttribute("erreur","password incorrecte,Réessayer ");
			RequestDispatcher DL =request.getRequestDispatcher("authentificationPro.jsp");
			DL.forward(request,response);
			
		}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
		
		}
	
	


}
