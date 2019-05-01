package Controle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ajouterCmpt
 */
@WebServlet("/ajouterCmpt")
public class ajouterCmpt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ajouterCmpt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String  type=request.getParameter("type");
		try{
		if(type.equals("admin")){
			//out.println("ad "+type);
			request.setAttribute("erroPseudo","nop");
			RequestDispatcher Da =request.getRequestDispatcher("/creercmpAdmin.jsp");
			Da.include(request,response);
			}
			else{
				if(type.equals("locataire")){
					RequestDispatcher Db =request.getRequestDispatcher("/creercmpLocataire.jsp");
					Db.include(request,response);
				}else{
					RequestDispatcher Dc =request.getRequestDispatcher("/creercmpProprietaire.jsp");
					Dc.include(request,response);
				}
			}}catch(NullPointerException e){
				RequestDispatcher Dc =request.getRequestDispatcher("/AjouterCompte.html");
				Dc.include(request,response);
			}
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
