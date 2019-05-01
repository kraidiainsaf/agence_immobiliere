package Controle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AjouterBienServlet")
public class AjouterBienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AjouterBienServlet() {
        super();    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
HttpSession session=request.getSession();PrintWriter out=response.getWriter();
		int id_personne=(int)session.getAttribute("id_personne");
		session.setAttribute("id_personne",id_personne);
		
			String ajoute1=(String)request.getParameter("ajoute1");
			session.setAttribute("ajoute1",ajoute1);
		
		
			String ajoute2=(String)request.getParameter("ajoute2");
			session.setAttribute("ajoute2",ajoute2);
			
			String ajoute3=(String)request.getParameter("ajoute3");
			session.setAttribute("ajoute3",ajoute3);
			
		
			String ajoute4=(String)request.getParameter("ajoute4");
			session.setAttribute("ajoute4",ajoute4);
	
		String ajoute5=(String)request.getParameter("ajoute5");
		session.setAttribute("ajoute5",ajoute5);
		response.sendRedirect("VosContrat.jsp");
		
		}

}
