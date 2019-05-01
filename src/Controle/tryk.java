package Controle;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modele.cntrlNotif;

/**
 * Servlet implementation class tryk
 */
@WebServlet("/tryk")
public class tryk extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public tryk() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
cntrlNotif k=new cntrlNotif();
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String  contenu=request.getParameter("contenu");
		String  destinataire=request.getParameter("dest");

	out.println(destinataire);
	
	cntrlNotif no =new cntrlNotif();
	int id;
	try {
		id = no.getIdp(contenu);
		out.println(id);
		no.envoyerNotif(id, contenu,"adminA");
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}

}
