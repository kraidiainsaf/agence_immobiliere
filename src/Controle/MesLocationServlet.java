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

import Modele.location;
import Modele.operation;

@WebServlet("/MesLocationServlet")
public class MesLocationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public MesLocationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		int id_personne=(int)session.getAttribute("id_personne");
		ArrayList<location>liste_location_maison=new ArrayList<location>();
		ArrayList<location>liste_location_appartement=new ArrayList<location>();
		ArrayList<location>liste_location_depot=new ArrayList<location>();
		ArrayList<location>liste_location_garage=new ArrayList<location>();
		ArrayList<location>liste_location_locale=new ArrayList<location>();
		ArrayList<location>liste_location_terrain=new ArrayList<location>();

		session.setAttribute("id_personne", id_personne);
			
		operation op=new operation();
		try {
		ArrayList<location>liste_location=op.GetLocation_locataire(id_personne);
		for(int i=0;i<liste_location.size();i++) {
		int p=liste_location.get(i).getId_bien();
		if(op.isMaison(p)) {
			liste_location_maison.add(op.GetLocation(liste_location.get(i).getId_location()));
		}else {
			if(op.isAppartement(p)) {
				liste_location_appartement.add(op.GetLocation(liste_location.get(i).getId_location()));
			}else {
				if(op.isDepot(p)) {
					liste_location_depot.add(op.GetLocation(liste_location.get(i).getId_location()));
				}else {
					if(op.isGarage(p)) {
						liste_location_garage.add(op.GetLocation(liste_location.get(i).getId_location()));
					}else {
						if(op.isLocale(p)) {
							liste_location_locale.add(op.GetLocation(liste_location.get(i).getId_location()));
						}else {
							liste_location_terrain.add(op.GetLocation(liste_location.get(i).getId_location()));

						}
					}
				}
			}
		}
			
	}
	session.setAttribute("liste_location_maison",liste_location_maison);
	session.setAttribute("liste_location_appartement",liste_location_appartement);
	session.setAttribute("liste_location_depot",liste_location_depot);
	session.setAttribute("liste_location_garage",liste_location_garage);
	session.setAttribute("liste_location_locale",liste_location_locale);
	session.setAttribute("liste_location_terrain",liste_location_terrain);
	response.sendRedirect("MesLocations.jsp");
	
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
