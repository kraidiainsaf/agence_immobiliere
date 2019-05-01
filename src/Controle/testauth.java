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

import Modele.cntrlCompte;

/**
 * Servlet implementation class testauth
 */
@WebServlet("/testauth")
public class testauth extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public testauth() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String  pseudo=request.getParameter("pseudo");
		String  password=request.getParameter("passWord");
		cntrlCompte cp=new cntrlCompte();
		if(cp.pseudopassnull(pseudo, password)){
			out.println("vous devez remplir tous les champs");
			RequestDispatcher DL =request.getRequestDispatcher("/authentificationg.html");
			DL.include(request,response);
		}else{
			HttpSession utilisateur1=request.getSession( true);
			utilisateur1.setAttribute("pseudo", pseudo);
			utilisateur1.setAttribute("password", password);
			RequestDispatcher DL =request.getRequestDispatcher("/espaceAdmin.jsp");
			DL.include(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
