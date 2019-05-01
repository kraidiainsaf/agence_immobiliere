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
import Modele.operation;

@WebServlet("/SupprimerBienServlet")
public class SupprimerBienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SupprimerBienServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int id_bien=Integer.parseInt((String)request.getParameter("id_bien"));    HttpSession  session=request.getSession();

	
	 cntrlAuthentif obj=new cntrlAuthentif(); 
	
		if(session.getAttribute("id_personne")==null){
			
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("authentifg");
  		 requestDispatcher.forward(request, response);
  		 }
		 session.setAttribute("id_bien",id_bien);PrintWriter out=response.getWriter();
		 int id_personne=(int)session.getAttribute("id_personne");
	operation op=new operation();
	try {
		System.out.println("resultat de is dernier "+op.isDernierBien(id_personne, id_bien));
			if(op.isDernierBien(id_personne, id_bien)) {
				request.setAttribute("erreur","si vous confirmer  la suppression de votre dernier bien vous risquez de perdre votre compte");
				
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("confirmersupp.jsp");
		  		 requestDispatcher.forward(request, response);

				response.sendRedirect("confirmersupp.jsp");
			
			}else {
				request.setAttribute("erreur","Confirmer votre suppression");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("confirmersupp.jsp");
		  		 requestDispatcher.forward(request, response);

				response.sendRedirect("confirmersupp.jsp");
				
			}
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	}

	
}
