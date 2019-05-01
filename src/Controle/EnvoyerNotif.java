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

import Modele.cntrlBien;

/**
 * Servlet implementation class EnvoyerNotif
 */
@WebServlet("/EnvoyerNotif")
public class EnvoyerNotif extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnvoyerNotif() {
        super();
       // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession utilisateur1=request.getSession();
		//out.println(utilisateur1.getAttribute("id_personne"));
		//out.println(utilisateur1.getAttribute("pseudo"));
		HttpSession news=request.getSession(true);
		news.setAttribute("id", utilisateur1.getAttribute("id_personne"));
		
		
		RequestDispatcher DL =request.getRequestDispatcher("/envoyerNotif.jsp");
		DL.include(request,response);
	}

}
