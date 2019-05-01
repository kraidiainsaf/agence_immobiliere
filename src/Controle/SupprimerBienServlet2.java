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

/**
 * Servlet implementation class SupprimerBienServlet2
 */
@WebServlet("/SupprimerBienServlet2")
public class SupprimerBienServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public SupprimerBienServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  HttpSession  session=request.getSession();
		PrintWriter out=response.getWriter();	operation op=new operation();

		 int id_personne=(int)session.getAttribute("id_personne");
		 int id_bien=(int)session.getAttribute("id_bien");
		 try {
			if(op.isDernierBien(id_personne, id_bien)) {
					
					 cntrlAuthentif obj=new cntrlAuthentif(); 

					if(obj.isLocataire(id_personne)&&obj.isProprietaire(id_personne)){
						op.SupprimerCompteProprietaire(id_personne);
						op.SupprimerBienProprietaire(id_bien);
						response.sendRedirect("EspaceLocataire.jsp");

					}else {

						op.SupprimerCompteProprietaire(id_personne);
						op.SupprimerBienProprietaire(id_bien);
						session.removeAttribute("pseudo");
						session.removeAttribute("password");
						session.removeAttribute("id_personne");
session.invalidate();
response.sendRedirect("agence_immobiliere.jsp");

					}
			   		 
				}else {
					op.SupprimerBienProprietaire(id_bien);
					response.sendRedirect("MesBiens.jsp");

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
