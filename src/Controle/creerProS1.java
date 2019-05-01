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
 * Servlet implementation class creerProS1
 */
@WebServlet("/creerProS1")
public class creerProS1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public creerProS1() {
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
		HttpSession Compte=request.getSession(false);
		String nom=(String) Compte.getAttribute("nom");
		String prenom=(String) Compte.getAttribute("prenom");
		String cart_identite=(String) Compte.getAttribute("cart_identite");
		String email=(String) Compte.getAttribute("email");
		String num_telephone=(String) Compte.getAttribute("num_telephone");
		cntrlCompte cp=new cntrlCompte();
		if(cp.pseudopassnull(pseudo, password)){
		
			RequestDispatcher DL =request.getRequestDispatcher("/creercmpProprietaire1.jsp");
			DL.include(request,response);
		}else{
		try {
			if(cp.verifierCompte(pseudo, password)){
				request.setAttribute("erroPseudo","error");

			RequestDispatcher D5 =request.getRequestDispatcher("/creercmpProprietaire1.jsp");
				D5.include(request,response);
			}
			else{
			cp.creerCompte( cart_identite, pseudo, password, nom, prenom, email, num_telephone);
			cntrlAuthentif cnt=new cntrlAuthentif();
			int id=cnt.getId(pseudo, password);
			System.out.println(id);
			cp.creerProprietaire(id, "non approuve",0);
			request.setAttribute("error","no");
			request.setAttribute("erroPseudo","nop");
			HttpSession er=request.getSession(true);
			er.setAttribute("test", "oui");
			RequestDispatcher D =request.getRequestDispatcher("/comptecréé.jsp");
			D.include(request,response);
}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
	}
	}


