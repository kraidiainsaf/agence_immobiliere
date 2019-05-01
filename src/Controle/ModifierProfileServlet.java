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

/**
 * Servlet implementation class ModifierProfileServlet
 */
@WebServlet("/ModifierProfileServlet")
public class ModifierProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public ModifierProfileServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 HttpSession session=request.getSession();
 int id_personne=(int)session.getAttribute("id_personne");

	session.setAttribute("id_personne", id_personne);
	
   String pseudo=(String)request.getParameter("pseudo");
   String password=(String)request.getParameter("password");
   String nom=(String)request.getParameter("nom");
   String email=(String)request.getParameter("email");
   String num_telephone=(String)request.getParameter("num_telephone");
   String prenom=(String)request.getParameter("prenom");
   operation op=new operation();
   try {
	ArrayList<personne> liste=op.GetPersonne(id_personne);
for(int i=0;i<liste.size();i++) {
personne	p=liste.get(i);
        if((p.getpseudo().equals(pseudo))||(p.getPassword().equals(password))||(p.getNom().equals(nom))||(p.getPrenom().equals(prenom))||(p.getEmail().equals(email))||(p.getNum_telephone().equals(num_telephone))){
			request.setAttribute("erreur","informations exist deja !");
        	RequestDispatcher DL =request.getRequestDispatcher("FormModifierProfile.jsp");
			DL.forward(request,response);

        }
        
}
   op.ModifierProfilePersonne(id_personne, pseudo, password, nom, prenom, email, num_telephone);
   RequestDispatcher DL =request.getRequestDispatcher("MonProfile.jsp");
	DL.forward(request,response);
	
}catch (ClassNotFoundException | SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();

}
			}
	

		}
