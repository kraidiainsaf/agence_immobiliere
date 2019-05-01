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
import javax.servlet.http.HttpSession;

import Modele.bien;
import Modele.cntrlBien;

/**
 * Servlet implementation class modifierBienServ
 */
@WebServlet("/modifierBienServ")
public class modifierBienServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifierBienServ() {
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
		
		String id1=request.getParameter("id");
		int id=Integer.parseInt(id1);
		
		cntrlBien cb=new cntrlBien ();
		bien b;
		try {
			b = cb.getBien(id);
			HttpSession bien=request.getSession(true);
			bien.setAttribute("id_bien",id);
			bien.setAttribute("superficie", b.getSuperficie());
			bien.setAttribute("prix", b.getPrix());
			bien.setAttribute("description", b.getdescription());
			bien.setAttribute("max_colocataire", b.getMax_colocataire());
			bien.setAttribute("image1",b.getimg1(id));
			bien.setAttribute("image2",b.getimg2(id));
			bien.setAttribute("image3",b.getimg3(id));
			bien.setAttribute("image4",b.getimg4(id));
			bien.setAttribute("image5",b.getimg5(id));
			RequestDispatcher DL =request.getRequestDispatcher("/modifierBien2.jsp");
			DL.include(request,response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
