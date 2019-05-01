package Controle;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modele.cntrlBien;
import Modele.cntrlCompte;

/**
 * Servlet implementation class supprimerBien1
 */
@WebServlet("/supprimerBien1")
public class supprimerBien1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public supprimerBien1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ans=request.getParameter("confirmer");
		if(ans.equals("annuler")){
			RequestDispatcher DL =request.getRequestDispatcher("/SuppBienServ");
			DL.include(request,response);
		}else{
		String idbien=request.getParameter("id5");
		System.out.println(idbien);
		int idb=Integer.parseInt(idbien);
		cntrlCompte c=new cntrlCompte();
		cntrlBien c1=new cntrlBien();
		String pseudo;
		try {
			pseudo = c1.getProprietaire(idb);
			int idp=c.getproprietaire(pseudo);
			c1.supprimerBien(idb);
			if(c1.lastBien(idp)){
				c.supprimerProprietaire(idp);
			}
			RequestDispatcher DL =request.getRequestDispatcher("/SuppBienServ");
			DL.include(request,response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
