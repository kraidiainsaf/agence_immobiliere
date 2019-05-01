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
 * Servlet implementation class CreerComptServlet1
 */
@WebServlet("/CreerComptServlet1")
public class CreerComptServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreerComptServlet1() {
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
		cntrlCompte cp=new cntrlCompte();
		HttpSession Compte1=request.getSession(false);
		String nom=(String) Compte1.getAttribute("nom");
		String prenom=(String) Compte1.getAttribute("prenom");
		String cart_identite=(String) Compte1.getAttribute("cart_identite");
		String email=(String) Compte1.getAttribute("email");
		String num_telephone=(String) Compte1.getAttribute("num_telephone");
		HttpSession session=request.getSession();
		String type_colocation=(String) session.getAttribute("type_colocation");

		try {
			if(cp.verifierCompte(pseudo, password)){
				request.setAttribute("erreur","ce compte existe déja ,Réessayer avec un autre pseudo et password");
				RequestDispatcher DL =request.getRequestDispatcher("créerCompte1.jsp");
				DL.forward(request,response);
				
			}else{
			cp.creerCompte( cart_identite, pseudo, password, nom, prenom, email, num_telephone);
			cntrlAuthentif cnt=new cntrlAuthentif();
			session.setAttribute("password", password);
			session.setAttribute("pseudo", pseudo);

			int id;
			try {
				id = cnt.getId(pseudo, password);
			session.setAttribute("id_personne",id);
			cp.creerLocataire(id);} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("note","vous avez créer un compte 'locataire' utiliser votre pseudo et password pour accéder a votre espace,maintenat vous pouvez Louer des biens ");

			RequestDispatcher DL =request.getRequestDispatcher("FormLouerBien.jsp");
			DL.forward(request,response);
			
}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
