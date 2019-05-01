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

/**
 * Servlet implementation class suppServ
 */
@WebServlet("/suppServ")
public class suppServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public suppServ() {
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
		HttpSession utilisateur=request.getSession();
		out.println(utilisateur.getAttribute("id_personne"));
		out.println(utilisateur.getAttribute("pseudo"));
		if(utilisateur.getAttribute("id_personne")==null){
			RequestDispatcher DL =request.getRequestDispatcher("/authentificationg.html");
			DL.forward(request,response);	
		}else{
		
		
		RequestDispatcher DL =request.getRequestDispatcher("/supprimerCompte1.jsp");
		DL.include(request,response);}
	}

}
