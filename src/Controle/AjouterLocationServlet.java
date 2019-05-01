package Controle;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.util.ConcurrentDateFormat;

import Modele.operation;

@WebServlet("/AjouterLocationServlet")
public class AjouterLocationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AjouterLocationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//ajouter fact 
	//ajouter location en attende 
		operation op=new operation();
		HttpSession session=request.getSession();
		int id_personne=(int)session.getAttribute("id");
		int id_bien=(int) session.getAttribute("id_bien_louer");
		int id_bien_louer=(int) session.getAttribute("id_bien_louer");
		Date date_debut=(Date) session.getAttribute("date_debut");
		Date date_fin=(Date) session.getAttribute("date_fin");
String mode_pay=(String) session.getAttribute("mode_pay");
	double	montant=(double) session.getAttribute("montant_pure");
	int id_location=0;
	String type_colocation=null;
			type_colocation=(String)session.getAttribute("type_colocation");
		
		
			System.out.println(""+type_colocation);
			if(type_colocation.equals("colocation")) {
	session.setAttribute("type_colocation","colocationr");
			}else {
				
				session.setAttribute("type_colocation","normaler");
			}
		try {
			id_location = op.Ajouterlocation(id_bien, date_debut, date_fin, mode_pay);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		try {
			int code=op.AjouterFact(id_personne, id_location, montant);
			session.setAttribute("code",code);
			System.out.println("code fact"+code);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("ImprimerFact.jsp");

	}

}
