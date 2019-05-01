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

import Modele.cntrlNotif;
import Modele.location;

/**
 * Servlet implementation class refuserLocation
 */
@WebServlet("/refuserLocation")
public class refuserLocation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public refuserLocation() {
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
		
		location l=new location();
		cntrlNotif not=new cntrlNotif();
		String i=request.getParameter("idloc");
		int id=Integer.parseInt(i);
		System.out.println("id1"+id);
		String idpers=request.getParameter("idpers");
		int idpers2=Integer.parseInt(idpers);

		try {
			l.refuserLocation(id);
			//l.suppFacture(id);
			
			
			not.envoyerNotif(idpers2, "votre location a été refusée ", "Admin");
			RequestDispatcher DL =request.getRequestDispatcher("/approuverLocation1.jsp");
			DL.include(request,response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
