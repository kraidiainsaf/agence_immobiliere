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
 * Servlet implementation class creeLocS
 */
@WebServlet("/creeLocS")
public class creeLocS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public creeLocS() {
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
		cntrlCompte c=new cntrlCompte();
	/*	if(c.attributNull(nom, prenom, cart_identite, email, num_telephone)){
			out.println("vous devez remplir tous les champs");
			RequestDispatcher DL =request.getRequestDispatcher("/creercmpLocataire.jsp");
			DL.include(request,response);
		}else{*/
		
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
		
		HttpSession Compte1=request.getSession( true);
		Compte1.setAttribute("nom",nom);
		Compte1.setAttribute("prenom", prenom);
		Compte1.setAttribute("cart_identite", cart_identite);
		Compte1.setAttribute("email", email);
		Compte1.setAttribute("num_telephone", num_telephone);
		request.setAttribute("erroPseudo","nop");
		RequestDispatcher Di =request.getRequestDispatcher("/creercmpLocataire1.jsp");
		Di.include(request,response);}}}
		
	//}
	}


	}


