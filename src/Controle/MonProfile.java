package Controle;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Modele.cntrlAuthentif;
import Modele.operation;
import Modele.personne;

@WebServlet("/MonProfile")
public class MonProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public MonProfile() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session=request.getSession();
		 int id_personne=(int)session.getAttribute("id_personne");

			session.setAttribute("id_personne", id_personne);
			operation op=new operation();
			personne p;
			try {
				p = op.GetPersonneinfo(id_personne);
			session.setAttribute("locations",op.getNbr_Locations_totale(id_personne));
			session.setAttribute("biens",op.getNbr_bien_totale(id_personne));
		   session.setAttribute("pseudo",p.getpseudo());
		   session.setAttribute("password",p.getPassword());
		   session.setAttribute("cart_identite",p.getCart_identite());
		   session.setAttribute("email",p.getEmail());
		   session.setAttribute("num_telephone",p.getNum_telephone());
		   session.setAttribute("prenom",p.getPrenom());
		   session.setAttribute("nom",p.getNom());
			cntrlAuthentif ct=new cntrlAuthentif();
			response.sendRedirect("MonProfile.jsp");
		
	        
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   }
}
