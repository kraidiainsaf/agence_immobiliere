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

import Modele.appartement;
import Modele.depot;
import Modele.garage;
import Modele.locale_commercial;
import Modele.maison;
import Modele.operation;
import Modele.personne;
import Modele.terrain;

@WebServlet("/MesBienServlet")
public class MesBienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MesBienServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session=request.getSession();
		 
		 int id_personne=(int)session.getAttribute("id_personne");

			session.setAttribute("id_personne", id_personne);
			operation op=new operation();
			ArrayList<maison> liste_maison=new ArrayList<maison>();
			ArrayList<appartement> liste_appartement=new ArrayList<appartement>();
			ArrayList<depot> liste_depot=new ArrayList<depot>();
			ArrayList<garage> liste_garage=new ArrayList<garage>();
			ArrayList<locale_commercial> liste_locale_commercial=new ArrayList<locale_commercial>();
			ArrayList<terrain> liste_terrain=new ArrayList<terrain>();
		try {
			ArrayList<Integer> list_id_bien=op.GetListeIDbiens(id_personne);
			for(int i=0;i<list_id_bien.size();i++) {
				Integer	p=list_id_bien.get(i);
				       boolean result=false;
				if(op.isMaison(p)) {
					liste_maison.add(op.GetMaison(p));
				}else {
					if(op.isAppartement(p)) {
						liste_appartement.add(op.GetAppartement(p));
					}else {
						if(op.isDepot(p)) {
							liste_depot.add(op.GetDepot(p));
						}else {
							if(op.isGarage(p)) {
								liste_garage.add(op.GetGarage(p));
							}else {
								if(op.isLocale(p)) {
									liste_locale_commercial.add(op.GetLocaleCommercial(p));
								}else {
									liste_terrain.add(op.GetTerrain(p));

								}
							}
						}
					}
				}
					
			}
			session.setAttribute("liste_maison",liste_maison);
			session.setAttribute("liste_appartement",liste_appartement);
			session.setAttribute("liste_depot",liste_depot);
			session.setAttribute("liste_garage",liste_garage);
			session.setAttribute("liste_locale_commercial",liste_locale_commercial);
			session.setAttribute("liste_terrain",liste_terrain);
			response.sendRedirect("MesBiens.jsp");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
