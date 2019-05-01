package Controle;

import java.io.IOException;
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
 * Servlet implementation class Verifier2
 */
@WebServlet("/Verifier2")
public class Verifier2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Verifier2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

HttpSession session=request.getSession();
String type_colocation=(String) session.getAttribute("type_colocation");
session.setAttribute("type_colocation",type_colocation);
System.out.println("typ colocation verifier 2"+type_colocation);
System.out.println("typ colocation verifier 2 dans session"+(String)session.getAttribute("type_colocation"));

String  pseudo=(String) session.getAttribute("pseudo");
String  password=(String) session.getAttribute("password");
cntrlAuthentif ct=new cntrlAuthentif();
int id;
try {
	id = ct.getId(pseudo, password);

if(session.getAttribute("id_personne")==null) {
	 response.sendRedirect("authentification.jsp");

}else {
	 if(ct.isLocataire(id)){
		 
		 response.sendRedirect("FormLouerBien.jsp");
					
	 }else{
			
				 cntrlCompte c=new cntrlCompte();
				 c.creerLocataire(id);
				 response.sendRedirect("FormLouerBien.jsp");

					

	 }}} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }

	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
