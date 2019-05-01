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

/**
 * Servlet implementation class AuthentificationServlet2
 */
@WebServlet("/AuthentificationServlet2")
public class AuthentificationServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthentificationServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();operation op=new operation();
		String  pseudo=request.getParameter("pseudo");
		String  password=request.getParameter("password");
		String type_colocation=(String) session.getAttribute("type_colocation");
		cntrlAuthentif ct=new cntrlAuthentif();
		int id;
		
		try {
			id = ct.getId(pseudo, password);
		System.out.print(" id aapre aut "+id);
		if(ct.verifierAuth(pseudo, password)){
			session.setAttribute("pseudo", pseudo);
			session.setAttribute("password", password);
			session.setAttribute("id_personne", id);
			 //ca dépend aux cas effectuer location et ajouter bien 
			 if(ct.isLocataire(id)){
				 response.sendRedirect("FormLouerBien.jsp");
							

			 }else{
				 
				 if(ct.isProprietaire(id)){
					 cntrlCompte c=new cntrlCompte();
					 c.creerLocataire(id);
			op.AjoutePoints(id, 1);
			 response.sendRedirect("FormLouerBien.jsp");
							

				 }
			 }
		
		}
		else{
			request.setAttribute("erreur","password incorrecte,Réessayer ");
			RequestDispatcher DL =request.getRequestDispatcher("authentification.jsp");
			DL.forward(request,response);
			
		}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
		
	}



}
