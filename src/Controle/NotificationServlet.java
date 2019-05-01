package Controle;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Modele.cntrlAuthentif;
import Modele.cntrlNotif;
import Modele.personne;

/**
 * Servlet implementation class NotificationServlet
 */
@WebServlet("/NotificationServlet")
public class NotificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NotificationServlet() {
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
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String  contenu=request.getParameter("contenu");
		String destinataire=request.getParameter("dest");
		HttpSession utilisateur1=request.getSession();
		personne pr=new personne();
		HttpSession back=request.getSession(true);
		System.out.println("test"+contenu.equals(""));
		if(contenu.equals("")){
			back.setAttribute("b", "non");
			RequestDispatcher DL =request.getRequestDispatcher("/envoyerNotiferror.jsp");
			DL.forward(request,response);
			
		}else{
			
			if(destinataire.equals("")){
				back.setAttribute("b", "non");
				RequestDispatcher DL =request.getRequestDispatcher("/envoyerNotiferror.jsp");
				DL.forward(request,response);
			}else{
//out.println(destinataire);
	cntrlNotif no =new cntrlNotif();
	cntrlAuthentif o=new cntrlAuthentif();
	int id;
	try {
		id = no.getIdPersonne(destinataire);
		System.out.println("test admin"+!(o.isAdmin(id)));
		System.out.println("test personne"+!(pr.ispers(id)));
		if(o.isAdmin(id)) {
			 utilisateur1=request.getSession();
				HttpSession notification=request.getSession(true);
				notification.setAttribute("contenu", contenu);
				notification.setAttribute("destinataire", destinataire);
				no.envoyerNotif(id, contenu, "Admin");
				System.out.println("id"+(String) utilisateur1.getAttribute("pseudo"));
				
				back.setAttribute("b", "oui");
				RequestDispatcher DL =request.getRequestDispatcher("/notificationEnvoyé.jsp");
				DL.forward(request,response);
		}else {
		if(!(pr.ispers(id))){
			RequestDispatcher Ds =request.getRequestDispatcher("/envoyerNotif.jsp");
			Ds.forward(request,response);
			}else {
		 utilisateur1=request.getSession();
			HttpSession notification=request.getSession(true);
			notification.setAttribute("contenu", contenu);
			notification.setAttribute("destinataire", destinataire);
			no.envoyerNotif(id, contenu, "Admin");
			System.out.println("id"+(String) utilisateur1.getAttribute("pseudo"));
			
			back.setAttribute("b", "oui");
			RequestDispatcher DL =request.getRequestDispatcher("/notificationEnvoyé.jsp");
			DL.forward(request,response);
			}} }catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//out.println(id);
	
	
			}
		}
	}

}
