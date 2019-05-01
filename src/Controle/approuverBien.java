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

import Modele.cntrlBien;
import Modele.cntrlNotif;

/**
 * Servlet implementation class approuverBien
 */
@WebServlet("/approuverBien")
public class approuverBien extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public approuverBien() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String i=request.getParameter("id");
		response.setContentType("text/html");
		
		cntrlNotif not=new cntrlNotif();
		int id=Integer.parseInt(i);
		String ip=request.getParameter("idprop");
		int ip1=Integer.parseInt(ip);
		String img1="images/"+request.getParameter("image1");
		String img2="images/"+request.getParameter("image2");
		String img3="images/"+request.getParameter("image3");
		String img4="images/"+request.getParameter("image4");
		String img5="images/"+request.getParameter("image5");
		cntrlBien b=new cntrlBien();
		
		try {
			b.modifierImage(id, img1, img2, img3, img4, img5);
			b.approuverBien(id);
			b.approuverProp(ip1);
			b.plus50Points(ip1);
			not.envoyerNotif(ip1, "votre bien a été bien approuver consulter votre liste des biens", "Admin");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//out.println("bien approuvé avec succé");
		RequestDispatcher DL =request.getRequestDispatcher("/approuverBien1.jsp");
		DL.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
