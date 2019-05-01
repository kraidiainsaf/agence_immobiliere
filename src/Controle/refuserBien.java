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

import Modele.cntrlBien;
import Modele.cntrlCompte;
import Modele.cntrlNotif;
import Modele.operation;

/**
 * Servlet implementation class refuserBien
 */
@WebServlet("/refuserBien")
public class refuserBien extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public refuserBien() {
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
		String i=request.getParameter("id");
		response.setContentType("text/html");
		
		int id=Integer.parseInt(i);
		cntrlNotif not=new cntrlNotif();
	
		cntrlBien b=new cntrlBien();
		try {
		
			String ip=request.getParameter("idprop");
			int ip1=Integer.parseInt(ip);
			operation op=new operation();
			System.out.println("dernier"+op.isDernierBien(ip1, id));
			if(op.isDernierBien(ip1, id)) {
				cntrlCompte cp=new cntrlCompte();
				cp.supprimerProprietaire(ip1);
				b.refuserBien(id);
			}else {
			b.refuserBien(id);
			not.envoyerNotif(ip1, "votre bien a été reffusé", "Admin");}
			RequestDispatcher DL =request.getRequestDispatcher("/approuverBien1.jsp");
			DL.forward(request,response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
