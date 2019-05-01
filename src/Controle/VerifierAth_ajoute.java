package Controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/VerifierAth_ajoute")
public class VerifierAth_ajoute extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public VerifierAth_ajoute() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

HttpSession session=request.getSession();System.out.println("id  methode "+session.getAttribute("id_personne")==null);
session.setAttribute("id_personne",null);
if(session.getAttribute("id_personne")==null) {
	RequestDispatcher requestDispatcher = request.getRequestDispatcher("authentificationPro.jsp");
	 requestDispatcher.include(request, response);

}else {
	RequestDispatcher requestDispatcher = request.getRequestDispatcher("AjouterBien.jsp");
	 requestDispatcher.include(request, response);
}
	}

	

}
