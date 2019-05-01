package Controle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Modele.cntrlCompte;

/**
 * Servlet implementation class creerProS
 */
@WebServlet("/creerProS")
public class creerProS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public creerProS() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String  nom=request.getParameter("nom");
		String  prenom=request.getParameter("prenom");
		String  cart_identite=request.getParameter("numCart");
		String  email=request.getParameter("email");
		String  num_telephone=request.getParameter("numTel");
		HttpSession Compte=request.getSession( true);
		cntrlCompte c=new cntrlCompte();
		System.out.println("nom="+nom);
		if(c.attributNull(nom, prenom, cart_identite, email, num_telephone)){
			
			RequestDispatcher DL =request.getRequestDispatcher("/creercmpProprietaire.jsp");
			DL.include(request,response);
		}else{
		
		if(c.verifierCarte(cart_identite)){
			
			request.setAttribute("error","error");
			
			RequestDispatcher D5 =request.getRequestDispatcher("/comptecréé.jsp");
				D5.include(request,response);
		}else{
			if(c.verifierEmail(email)){
			
				request.setAttribute("error","error");
				
				RequestDispatcher D5 =request.getRequestDispatcher("/comptecréé.jsp");
					D5.include(request,response);
			}else{
				if(c.verifierNumTlpn(num_telephone)){
					
					request.setAttribute("error","error");
					
					RequestDispatcher D5 =request.getRequestDispatcher("/comptecréé.jsp");
						D5.include(request,response);
				}
			else{
		
		Compte.setAttribute("nom",nom);
		Compte.setAttribute("prenom", prenom);
		Compte.setAttribute("cart_identite", cart_identite);
		Compte.setAttribute("email", email);
		Compte.setAttribute("num_telephone", num_telephone);
		request.setAttribute("erroPseudo","nop");
		RequestDispatcher DL =request.getRequestDispatcher("/creercmpProprietaire1.jsp");
		DL.include(request,response);}}}}
	
	}

}
