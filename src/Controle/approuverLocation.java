package Controle;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modele.cntrlNotif;
import Modele.location;

/**
 * Servlet implementation class approuverLocation
 */
@WebServlet("/approuverLocation")
public class approuverLocation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public approuverLocation() {
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
		String i=request.getParameter("idloc");
		String date=request.getParameter("date_pay");
		String an=date.substring(0, 4);
		String mo=date.substring(5, 7);
		String jr=date.substring(8, 10);
		int annee=Integer.parseInt(an);
		int mois=Integer.parseInt(mo);
		int jour=Integer.parseInt(jr);
		Date d=new Date(annee-1900,mois-1,jour);
		cntrlNotif not=new cntrlNotif();
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int id=Integer.parseInt(i);
		location l=new location();
		try {
			l.approuverLocation(id);
			int idloc=	l.getLocataireid(id);
			l.setFacture(id, d);
			not.envoyerNotif(idloc, "votre location a été bien approuvée ", "Admin");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		RequestDispatcher DL =request.getRequestDispatcher("/approuverLocation1.jsp");
		DL.forward(request,response);
	}

}
