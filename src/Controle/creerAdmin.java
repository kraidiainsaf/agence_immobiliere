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

/**
 * Servlet implementation class creerAdmin
 */
@WebServlet("/creerAdmin")
public class creerAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public creerAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String  nom=request.getParameter("nom");
		String  prenom=request.getParameter("prenom");
		String  cart_identite=request.getParameter("numCart");
		String  email=request.getParameter("email");
		String  num_telephone=request.getParameter("numTel");
		String  pseudo=request.getParameter("pseudo");
		String  password=request.getParameter("passe1");
		cntrlCompte cp=new cntrlCompte();
		/*if((cp.attributNull(nom, prenom, cart_identite, email, num_telephone))||(cp.pseudopassnull(pseudo, password))){
			out.println("<h1>vous devez remplir tous les champs</h1>");
			RequestDispatcher DL =request.getRequestDispatcher("/creercmpAdmin.jsp");
			DL.include(request,response);
		}else{*/
		if(cp.verifierCarte(cart_identite)){
			request.setAttribute("error","error");
						
						RequestDispatcher D5 =request.getRequestDispatcher("/comptecréé.jsp");
							D5.include(request,response);
					}else{
						if(cp.verifierEmail(email)){
							request.setAttribute("error","error");
							
							RequestDispatcher D5 =request.getRequestDispatcher("/comptecréé.jsp");
								D5.include(request,response);
						}else{
							if(cp.verifierNumTlpn(num_telephone)){
								request.setAttribute("error","error");
								
								RequestDispatcher D5 =request.getRequestDispatcher("/comptecréé.jsp");
									D5.include(request,response);
							}
						else{
		try {
			if(cp.verifierCompte(pseudo, password)){
				request.setAttribute("erroPseudo","error");
				RequestDispatcher D5 =request.getRequestDispatcher("/creercmpAdmin.jsp");
				D5.include(request,response);
			}else{
				request.setAttribute("erroPseudo","nop");
			cp.creerCompte( cart_identite, pseudo, password, nom, prenom, email, num_telephone);
			cntrlAuthentif cnt=new cntrlAuthentif();
			int id=cnt.getId(pseudo, password);
			cp.creerAdmin(id);
			
			request.setAttribute("error","no");
			HttpSession back1=request.getSession(true);
			back1.setAttribute("b", "oui");
			RequestDispatcher D =request.getRequestDispatcher("/comptecréé.jsp");
			D.include(request,response);}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}}}}
	//}
	}


