package Controle;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Modele.cntrlAuthentif;
import Modele.cntrlNotif;
import Modele.location;
import Modele.notification;
import Modele.operation;

@WebServlet("/ConsulterNotificationServlet")
public class ConsulterNotificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ConsulterNotificationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		int id_personne=(int)session.getAttribute("id_personne");
		session.setAttribute("id_personne", id_personne);
				
		operation op=new operation();
		try {
			cntrlNotif cn=new cntrlNotif();
			cntrlAuthentif ct=new cntrlAuthentif();

			if(ct.isLocataire(id_personne)) {
					int reslt=op.isfin_location(id_personne);
					
				if(reslt!=0) {
					System.out.println("co");
					location l=op.GetLocation(reslt);
					String contenu="la location de "+l.getDate_debut()+" à "+l.getDate_fin()+" se terminera dans quelques jours (-5jr)";
					cn.envoyerNotif(id_personne, contenu,"Admin");
				}
				}
			 
		ArrayList<notification> liste=op.GetMes_notif(id_personne);
		session.setAttribute("liste",liste);
		response.sendRedirect("MesNotification.jsp");
		
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
