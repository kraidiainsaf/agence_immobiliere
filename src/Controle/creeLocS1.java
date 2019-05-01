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
 * Servlet implementation class creeLocS1
 */
@WebServlet("/creeLocS1")
public class creeLocS1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public creeLocS1() {
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
		String  pseudo=request.getParameter("pseudo");
		String  password=request.getParameter("passe1");
		cntrlCompte cp=new cntrlCompte();
		HttpSession Compte1=request.getSession(false);
		String nom=(String) Compte1.getAttribute("nom");
		String prenom=(String) Compte1.getAttribute("prenom");
		String cart_identite=(String) Compte1.getAttribute("cart_identite");
		String email=(String) Compte1.getAttribute("email");
		String num_telephone=(String) Compte1.getAttribute("num_telephone");
		
		if(cp.pseudopassnull(pseudo, password)){
		
			RequestDispatcher DL =request.getRequestDispatcher("/creercmpLocataire1.jsp");
			DL.include(request,response);
		}else{
		try {
			if(cp.verifierCompte(pseudo, password)){
				
				request.setAttribute("erroPseudo","error");
				RequestDispatcher D5 =request.getRequestDispatcher("/creercmpLocataire1.jsp");
				D5.include(request,response);
			}else{
			cp.creerCompte( cart_identite, pseudo, password, nom, prenom, email, num_telephone);
			cntrlAuthentif cnt=new cntrlAuthentif();
			int id=cnt.getId(pseudo, password);
			request.setAttribute("error","no");
			request.setAttribute("erroPseudo","nop");
			cp.creerLocataire(id);
			//out.println("vous avez créer un compte 'locataire' utiliser votre pseudo et password pour accéder a votre espace,maintenat vous pouvez proposer des biens");
			RequestDispatcher D =request.getRequestDispatcher("/comptecréé.jsp");
			D.include(request,response);
}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		}}}
