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
 * Servlet implementation class creerComptServlet
 */
@WebServlet("/creerComptServlet")
public class creerComptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public creerComptServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String  nom=request.getParameter("nom");
		String  prenom=request.getParameter("prenom");
		String  cart_identite=request.getParameter("numCart");
		String  email=request.getParameter("email");
		String  num_telephone=request.getParameter("numTel");
		
		HttpSession Compte1=request.getSession( true);
		Compte1.setAttribute("nom",nom);
		Compte1.setAttribute("prenom", prenom);
		Compte1.setAttribute("cart_identite", cart_identite);
		Compte1.setAttribute("email", email);
		Compte1.setAttribute("num_telephone", num_telephone);
		cntrlCompte cp=new cntrlCompte();
		if(cp.verifierCarte(cart_identite)){
			request.setAttribute("erreur","  numero de carte d'identidté existe déja!");
						
						RequestDispatcher D5 =request.getRequestDispatcher("/créerCompte.jsp");
							D5.forward(request,response);
					}else{
						if(cp.verifierEmail(email)){
							request.setAttribute("erreur"," email existe déja!");
							
							RequestDispatcher D5 =request.getRequestDispatcher("/créerCompte.jsp");
								D5.forward(request,response);
						}else{
							if(cp.verifierNumTlpn(num_telephone)){
								request.setAttribute("erreur","  numero de telephone existe déja!");
								
								RequestDispatcher D5 =request.getRequestDispatcher("/créerCompte.jsp");
									D5.forward(request,response);
							}
						}}
		RequestDispatcher Di =request.getRequestDispatcher("/créerCompte1.jsp");
		Di.forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
