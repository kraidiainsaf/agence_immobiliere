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

import Modele.cntrlAuthentif;
import Modele.cntrlCompte;

/**
 * Servlet implementation class creerCmtProp
 */
@WebServlet("/creerCmtProp")
public class creerCmtProp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public creerCmtProp() {
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
		HttpSession Compte=request.getSession( true);
		Compte.setAttribute("nom",nom);
		Compte.setAttribute("prenom", prenom);
		Compte.setAttribute("cart_identite", cart_identite);
		Compte.setAttribute("email", email);
		Compte.setAttribute("num_telephone", num_telephone);
		cntrlCompte cp=new cntrlCompte();
		if(cp.verifierCarte(cart_identite)){
			request.setAttribute("erreur","  numero de carte d'identidté existe déja!");
						
						RequestDispatcher D5 =request.getRequestDispatcher("/creerCmpPro.jsp");
							D5.forward(request,response);
					}else{
						if(cp.verifierEmail(email)){
							request.setAttribute("erreur"," email existe déja!");
							
							RequestDispatcher D5 =request.getRequestDispatcher("/creerCmpPro.jsp");
								D5.forward(request,response);
						}else{
							if(cp.verifierNumTlpn(num_telephone)){
								request.setAttribute("erreur","  numero de telephone existe déja!");
								
								RequestDispatcher D5 =request.getRequestDispatcher("/creerCmpPro.jsp");
									D5.forward(request,response);
							}
						}}
		RequestDispatcher DL =request.getRequestDispatcher("/creerCmpPro1.jsp");
		DL.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
