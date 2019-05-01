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
//import Modele.cntrlCompte;

@WebServlet("/authentifg")
public class authentifg extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public authentifg() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		HttpSession session=request.getSession(true);

				response.setContentType("text/html");
				PrintWriter out=response.getWriter();
				
				String  pseudo=request.getParameter("pseudo");
				String  password=request.getParameter("password");
				//request.logout();
				cntrlAuthentif ct=new cntrlAuthentif();
				cntrlCompte co=new cntrlCompte();
				int id;
				try {
					id = ct.getId(pseudo, password);
				System.out.println("p"+pseudo+" pas "+password);
				if(ct.verifierAuth(pseudo, password)){
					if(ct.isAdmin(id)){
						if(co.isGradeb(id)){
							HttpSession utilisateur1=request.getSession( true);
							utilisateur1.setAttribute("pseudo", pseudo);
							utilisateur1.setAttribute("pseudo2", pseudo);
							utilisateur1.setAttribute("password", password);
							 utilisateur1.setAttribute("id_personne", id);
							 utilisateur1.setAttribute("test", "no");
							response.sendRedirect("newspace.jsp");	
						}else{
						HttpSession utilisateur1=request.getSession( true);
						utilisateur1.setAttribute("pseudo", pseudo);
						utilisateur1.setAttribute("pseudo2", pseudo);
						utilisateur1.setAttribute("password", password);
						 utilisateur1.setAttribute("id_personne", id);
						System.out.println("id1"+utilisateur1.getAttribute("id"));
						response.sendRedirect("newspace.jsp");}
						/*RequestDispatcher DL =request.getRequestDispatcher("/espaceAdmin.jsp");
						DL.include(request,response);
						*/}else {
					session.setAttribute("pseudo", pseudo);
					session.setAttribute("password", password);
					session.setAttribute("id_personne", id);
					response.sendRedirect("authentifg2");
					RequestDispatcher DL =request.getRequestDispatcher("authentifg2");
						DL.include(request,response);
					
						}}else{
					request.setAttribute("erreur","password incorrecte,Réessayer ");
					RequestDispatcher DL =request.getRequestDispatcher("authentificationg.jsp");
					DL.forward(request,response);
					
				}} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}	
	
}
