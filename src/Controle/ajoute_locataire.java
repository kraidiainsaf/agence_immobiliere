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
 * Servlet implementation class ajoute_locataire
 */
@WebServlet("/ajoute_locataire")
public class ajoute_locataire extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ajoute_locataire() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");			HttpSession session=request.getSession();

		PrintWriter out=response.getWriter();
		
		String  pseudo=(String) session.getAttribute("pseudo");
				
		String  password=(String) session.getAttribute("password");
		cntrlAuthentif ct=new cntrlAuthentif();
		int id;
		
			try {
				id = ct.getId(pseudo, password);
				System.out.println(""+pseudo+"  "+password+"id :"+id);
				cntrlCompte c=new cntrlCompte();
				operation op=new operation();
				if(op.is_anc_pro(id)){
				if(op.getEtat_pro(id).equals("supprime")) {
					op.SetEtat_Pro(id);
				}}else {
				c.creerProprietaire(id, "non approuve",0);
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			request.setAttribute("note","vous avez créer un compte 'Proprietaire' utiliser votre pseudo et password pour accéder a votre espace,maintenat vous pouvez proposer des biens ");

			RequestDispatcher DL =request.getRequestDispatcher("AjouterBien.jsp");
			DL.forward(request,response);
			response.sendRedirect("AjouterBien.jsp");
			
					

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
