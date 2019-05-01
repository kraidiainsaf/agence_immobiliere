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
 * Servlet implementation class CreerCmtProp1
 */
@WebServlet("/CreerCmtProp1")
public class CreerCmtProp1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreerCmtProp1() {
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
		String  pseudo=request.getParameter("pseudo");
		String  password=request.getParameter("passe1");
		HttpSession Compte=request.getSession(false);
		String nom=(String) Compte.getAttribute("nom");
		String prenom=(String) Compte.getAttribute("prenom");
		String cart_identite=(String) Compte.getAttribute("cart_identite");
		String email=(String) Compte.getAttribute("email");
		String num_telephone=(String) Compte.getAttribute("num_telephone");
		cntrlCompte cp=new cntrlCompte();
		try {		HttpSession session=request.getSession(true);

			if(cp.verifierCompte(pseudo, password)){
				request.setAttribute("erreur","ce compte existe déja ,Réessayer avec un autre pseudo et password");
				RequestDispatcher DL =request.getRequestDispatcher("creerCmpPro1.jsp");
				DL.forward(request,response);
			}else{
	
		cp.creerCompte( cart_identite, pseudo, password, nom, prenom, email, num_telephone);
		cntrlAuthentif cnt=new cntrlAuthentif();
		int id;
		session.setAttribute("password", password);
		session.setAttribute("pseudo", pseudo);
		
			id = cnt.getId(pseudo, password);
			session.setAttribute("id_personne",id);

		cp.creerProprietaire(id, "non approuve",0);
		request.setAttribute("note","vous avez créer un compte 'Proprietaire' utiliser votre pseudo et password pour accéder a votre espace,maintenat vous pouvez proposer des biens ");

		RequestDispatcher DL =request.getRequestDispatcher("AjouterBien.jsp");
		DL.forward(request,response);
		response.sendRedirect("AjouterBien.jsp");
		
		
			}} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
