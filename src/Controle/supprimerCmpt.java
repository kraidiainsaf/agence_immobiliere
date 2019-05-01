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
import Modele.cntrlNotif;
import Modele.personne;

/**
 * Servlet implementation class supprimerCmpt
 */
@WebServlet("/supprimerCmpt")
public class supprimerCmpt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public supprimerCmpt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String pers=request.getParameter("pers");
		System.out.println("p"+pers);
		cntrlNotif t=new cntrlNotif();
		cntrlAuthentif ct=new cntrlAuthentif();
		cntrlCompte co=new cntrlCompte();
		personne pr=new personne();
		HttpSession utilisateur1=request.getSession();
		String type=(String)utilisateur1.getAttribute("type");
		try {
		if(pers.equals("")){
			RequestDispatcher Ds =request.getRequestDispatcher("/supprimerCompte1.jsp");
			Ds.forward(request,response);
		
		}
	
		int id;
		id = t.getIdPersonne(pers);
	
		
		if(ct.isLocataire(id)&&type.equals("loc")){
			System.out.println("test2"+co.verifierSupploc(id));
			if(!(co.verifierSupploc(id))){
				RequestDispatcher Ds =request.getRequestDispatcher("/cant.jsp");
				Ds.forward(request,response);
			}
			else{	System.out.println("wsalt");
			HttpSession per=request.getSession(true);
			per.setAttribute("id", id);
			RequestDispatcher Ds =request.getRequestDispatcher("/confirmerSupp1.jsp");
			Ds.include(request,response);}}else{
				if(ct.isProprietaire(id)&&type.equals("pro")){
					if(!(co.verifiersuppPro(id))){
						RequestDispatcher Ds =request.getRequestDispatcher("/cant.jsp");
						Ds.include(request,response);
					}else{
			HttpSession per=request.getSession(true);
			per.setAttribute("id", id);
			//out.println(pers);
		//	out.println(id);
			//String p2=(String) per.getAttribute("personne");
			//	out.println(p2);
			System.out.println("wsalt");
			RequestDispatcher Ds =request.getRequestDispatcher("/confirmerSupp1.jsp");
			Ds.include(request,response);}
					
				
				
				
				}else {
					
					RequestDispatcher Ds =request.getRequestDispatcher("/supprimerCompte1.jsp");
					Ds.include(request,response);
			}
				}
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stu
		
	}

}
