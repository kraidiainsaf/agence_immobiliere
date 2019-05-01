package Controle;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Modele.location;
import Modele.operation;

@WebServlet("/VerifierLocationServlet")
public class VerifierLocationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public VerifierLocationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		operation op=new operation();
		HttpSession session=request.getSession();//session.setAttribute("prolongation",null);
		PrintWriter out=response.getWriter();
		int id_bien_louer  =(int)session.getAttribute("id_bien");
session.setAttribute("id_bien_louer",id_bien_louer);	
				int id_personne=(int)session.getAttribute("id_personne");
System.out.println("id avant fact inserer par authetif"+id_personne);
String type_colocation=(String) session.getAttribute("type_colocation");
System.out.println("type_location apres fact servlet ajoute"+type_colocation);

if(type_colocation==null) {
	RequestDispatcher DL =request.getRequestDispatcher("FormLouerBien.jsp");
	DL.forward(request,response);
	 response.sendRedirect("FormLouerBien.jsp");

}
	

	if(type_colocation.equals("colocation") ){
			int max_colocataire;
			try {
				max_colocataire = op.GetMaxColocataire(id_bien_louer);
				
				String debut =(String)request.getParameter("date_debut");
				String fin =(String)request.getParameter("date_fin");
				String mode_pay =(String)request.getParameter("mode_pay");
				session.setAttribute("mode_pay",mode_pay);

				
			SimpleDateFormat d=new SimpleDateFormat("yyyy-MM-dd");
				Date date_debut;
		
					date_debut = d.parse(debut);
					session.setAttribute("date_debut",date_debut);
					Date date_fin=d.parse(fin);
					session.setAttribute("date_fin",date_fin);

final long t=1000*60*60*24;

long tt=Math.abs(date_debut.getTime()-date_fin.getTime())/t;
if((tt<356)&&(mode_pay.equals("annuel"))) {
	request.setAttribute("erreur","Erreur :Mode de  payement incorrect !");
	RequestDispatcher DL =request.getRequestDispatcher("FormLouerBien.jsp");
	DL.forward(request,response);
	
}
			if(date_debut.after(date_fin)) {
				
				request.setAttribute("erreur","Erreur : Date de fin avant Date debut !");
				RequestDispatcher DL =request.getRequestDispatcher("FormLouerBien.jsp");
				DL.forward(request,response);
			}
			Date date=new Date();
			
			if(date_debut.before(date)) {
				request.setAttribute("erreur","Erreur : La date inserée est  ancienne !");
				RequestDispatcher DL =request.getRequestDispatcher("FormLouerBien.jsp");
				DL.forward(request,response);

			}
			System.out.println("curent "+date);

			final long ms=1000*60*60*24;
			
			long nbr_jour=Math.abs(date_debut.getTime()-date_fin.getTime())/ms;
			if((Math.abs(date.getTime()-date_debut.getTime())/ms)>91.2501) {
				request.setAttribute("erreur","Erreur :  la réservation doit etre 1 mois avant la date de début ou maximum 3.");
				RequestDispatcher DL =request.getRequestDispatcher("FormLouerBien.jsp");
				DL.forward(request,response);

			}
			
			if(nbr_jour>2190||nbr_jour<31) {
				request.setAttribute("erreur","Erreur : la période de location ne doit pas etre supérieur à 6 ans ou inférieur à 3 mois. !");
				RequestDispatcher DL =request.getRequestDispatcher("FormLouerBien.jsp");
				DL.forward(request,response);

			}
			
					if(op.is_plane(id_bien_louer, date_debut, date_fin)) {
						request.setAttribute("erreur","Erreur : nombre de locataires actuel est saturé !");
						RequestDispatcher DL =request.getRequestDispatcher("FormLouerBien.jsp");
						DL.forward(request,response);

					}
						
					session.setAttribute("nbr_jour",nbr_jour);
		System.out.print("nbr joour"+nbr_jour);
			        double prix_jour=op.GetPrix(id_bien_louer);
					session.setAttribute("prix_jour",prix_jour);

			        double montant_pure=nbr_jour*prix_jour+((nbr_jour*prix_jour*20)/100);
					session.setAttribute("montant_pure",montant_pure);
					double mode;
					if(request.getParameter("mode_pay").equals("mensuel")) {
						 mode=30*prix_jour;
					}else {
						if(request.getParameter("mode_pay").equals("annuel")) {
						 mode=365*prix_jour;
						}else {
							
						 mode=montant_pure;
						}}
						System.out.println("test");
						 session.setAttribute("mode",mode);
						 session.setAttribute("type_colocation",type_colocation);
							RequestDispatcher DL =request.getRequestDispatcher("AfficherContrat.jsp");
							DL.forward(request,response);



					
				
			} catch (ParseException | ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
	}else {
		//verifier authentification
				//verifier que pas des location en ce date effectuee ou en attend et pas des prolongation 
		
		String debut =(String)request.getParameter("date_debut");
		String fin =(String)request.getParameter("date_fin");
		String mode_pay =(String)request.getParameter("mode_pay");
		session.setAttribute("mode_pay",mode_pay);

		
	SimpleDateFormat d=new SimpleDateFormat("yyyy-MM-dd");
		Date date_debut;
		try {
			date_debut = d.parse(debut);
			session.setAttribute("date_debut",date_debut);
			Date date_fin=d.parse(fin);
			session.setAttribute("date_fin",date_fin);

final long t=1000*60*60*24;

long tt=Math.abs(date_debut.getTime()-date_fin.getTime())/t;
			if((tt<356)&&(mode_pay.equals("annuel"))) {
				request.setAttribute("erreur","Erreur :Mode de  payement incorrect !");
				RequestDispatcher DL =request.getRequestDispatcher("FormLouerBien.jsp");
				DL.forward(request,response);
				
			} 
	if(date_debut.after(date_fin)) {
		request.setAttribute("erreur","Erreur : Date de fin avant Date debut !");
		RequestDispatcher DL =request.getRequestDispatcher("FormLouerBien.jsp");
		DL.forward(request,response); 

	}
	Date date=new Date();
	System.out.println("curent "+date);
	if(date_debut.before(date)) {

		request.setAttribute("erreur","Erreur : La date inserée est  ancienne !");
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("FormLouerBien.jsp");
		 requestDispatcher.forward(request, response);

	}
	System.out.println("curent "+date);

	final long ms=1000*60*60*24;
	
	long nbr_jour=Math.abs(date_debut.getTime()-date_fin.getTime())/ms;
	if((Math.abs(date.getTime()-date_debut.getTime())/ms)>91.2501) {
		request.setAttribute("erreur","Erreur :  la réservation doit etre 1 mois avant la date de début ou maximum 3.");
		RequestDispatcher DL =request.getRequestDispatcher("FormLouerBien.jsp");
		DL.forward(request,response);
		

	}
	
	if(nbr_jour>2190||nbr_jour<31) {
		request.setAttribute("erreur","Erreur : la période de location ne doit pas etre supérieur à 6 ans ou inférieur à 3 mois. !");
		RequestDispatcher DL =request.getRequestDispatcher("FormLouerBien.jsp");
		DL.forward(request,response); 

	}
	
			if(op.islouer(id_bien_louer, date_debut, date_fin)) {
				request.setAttribute("erreur","Erreur : ce  bien est deja louer ! ");
				RequestDispatcher DL =request.getRequestDispatcher("FormLouerBien.jsp");
				DL.forward(request,response);
			

			}
			if(op.isAtt(id_bien_louer, date_debut, date_fin)) {
				request.setAttribute("erreur","Erreur :Il ya deja une demmande de location dans cette date mais elle est  possible d'etre refusée ou acceptée  consulter ce bien bientot!");
				RequestDispatcher DL =request.getRequestDispatcher("FormLouerBien.jsp");
				DL.forward(request,response);

				}
				
			session.setAttribute("nbr_jour",nbr_jour);
System.out.print("nbr joour"+nbr_jour);
	        double prix_jour=op.GetPrix(id_bien_louer);
			session.setAttribute("prix_jour",prix_jour);

	        double montant_pure=nbr_jour*prix_jour+((nbr_jour*prix_jour*20)/100);
			session.setAttribute("montant_pure",montant_pure);
			double mode;
			if(request.getParameter("mode_pay").equals("mensuel")) {
				 mode=30*prix_jour+200;
			}else {
				if(request.getParameter("mode_pay").equals("annuel")) {
				 mode=365*prix_jour+200;
				}else {
					
				 mode=montant_pure+200;
					
				}
			}
			session.setAttribute("mode",mode);
			response.sendRedirect("AfficherContrat.jsp");
			RequestDispatcher DL =request.getRequestDispatcher("AfficherContrat.jsp");
			DL.include(request,response);

			
		
			} catch (ParseException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	 

		}}