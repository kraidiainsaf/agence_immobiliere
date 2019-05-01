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
 * Servlet implementation class trys
 */
@WebServlet("/trys")
public class trys extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public trys() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		String answer=request.getParameter("confirmer");
	HttpSession utilisateur1=request.getSession();
	String type=(String)utilisateur1.getAttribute("type");
		
		if(answer.equals("annuler")){
			RequestDispatcher Ds1 =request.getRequestDispatcher("/suppressionCompte.jsp");
			Ds1.include(request,response);
			
		}else{
			HttpSession per=request.getSession(false);
			int i= (Integer) per.getAttribute("id");
			System.out.println("hada"+i);
			cntrlAuthentif ct=new cntrlAuthentif();
			cntrlCompte co=new cntrlCompte();
			try {
				if(ct.isLocataire(i)&&(type.equals("loc"))){
					System.out.println("hna");
					if(co.verifierSupploc(i)){
						System.out.println("hna2");
						co.supprimerLocataire(i);
						RequestDispatcher Ds1 =request.getRequestDispatcher("/suppressionCompte.jsp");
						Ds1.include(request,response);
						//co.changePasse(i);
					//}else{
						//out.println("you can't delete this locataire");
					//}
				}}
					else{
						if(ct.isProprietaire(i)&&(type.equals("pro"))){
							//if(co.verifiersuppPro(i)){
							System.out.println("hnnnnn");
								co.supprimerProprietaire(i);
								co.suppBienPro(i);
								RequestDispatcher Ds1 =request.getRequestDispatcher("/suppressionCompte.jsp");
								Ds1.include(request,response);
								//co.changePasse(i);
							//}else{
								//out.println("you cant delete this propr");
							//}
						}
						}
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
