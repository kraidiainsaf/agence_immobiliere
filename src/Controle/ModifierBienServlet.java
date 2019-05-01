package Controle;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Modele.appartement;
import Modele.depot;
import Modele.garage;
import Modele.locale_commercial;
import Modele.maison;
import Modele.operation;
import Modele.terrain;

@WebServlet("/ModifierBienServlet")
public class ModifierBienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ModifierBienServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int id_bien=Integer.parseInt((String)request.getParameter("id_bien"));    HttpSession  session=request.getSession();
session.setAttribute("id_bien",id_bien);
String typebien=request.getParameter("typebien");
  // String typebien=(String)session.getAttribute("typebien");
session.setAttribute("typebien",typebien);
    operation op=new operation();
    System.out.println(""+typebien);
   

		                if(typebien.equals("maison")) {
			try {
				maison m=op.GetMaison(id_bien);
				
				session.setAttribute("maison",m);
				response.sendRedirect("ModifierMaison.jsp");
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		                                            }else {
		       if(typebien.equals("appartement")) {
			try {
				appartement  m=op.GetAppartement(id_bien);
				session.setAttribute("appartement",m);
				response.sendRedirect("ModifierAppartement.jsp");

			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {if(typebien.equals("depot")) {
			try {
				depot  m=op.GetDepot(id_bien);
				session.setAttribute("depot",m);
				response.sendRedirect("ModifierDepot.jsp");

			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {if(typebien.equals("garage")) {
			try {
				garage  m=op.GetGarage(id_bien);
				session.setAttribute("garage",m);
				response.sendRedirect("ModifierGarage.jsp");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {if(typebien.equals("locale_commercial")) {
			try {
				locale_commercial  m=op.GetLocaleCommercial(id_bien);
				session.setAttribute("locale_commercial",m);
				response.sendRedirect("ModifierLocale.jsp");

			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
try {
		terrain  m=op.GetTerrain(id_bien);
		session.setAttribute("terrain",m);

} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
}
response.sendRedirect("ModifierTerrain.jsp");

		}
			
		}
			
		}
			
		}
			
		}

		


}
}