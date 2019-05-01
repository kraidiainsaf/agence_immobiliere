package Controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GoFormProlongation
 */
@WebServlet("/GoFormProlongation")
public class GoFormProlongation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoFormProlongation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		int id_location=Integer.parseInt((String)request.getParameter("id_location"));
		int id_bien_louer=Integer.parseInt((String)request.getParameter("id_bien_louer"));
String typebien=request.getParameter("typebien");
		
		session.setAttribute("id_location",id_location);
		session.setAttribute("id_bien_louer",id_bien_louer);
		session.setAttribute("typebien",typebien);
		response.sendRedirect("FormProlongation.jsp");



	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
