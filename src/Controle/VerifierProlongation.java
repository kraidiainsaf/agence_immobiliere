package Controle;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Modele.location;
import Modele.operation;

/**
 * Servlet implementation class VerifierProlongation
 */
@WebServlet("/VerifierProlongation")
public class VerifierProlongation extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public VerifierProlongation() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();PrintWriter out=response.getWriter();
operation op=new operation();
		
    int id_location=(int)session.getAttribute("id_location");
    System.out.print("id loc 1 verif "+id_location);
	int id_bien_louer=(int)session.getAttribute("id_bien_louer");
	System.out.print("id loc "+id_location);
	String f=(String)request.getParameter("date_fin_p");
	String mode_pay=(String)request.getParameter("mode_pay");
	 session.setAttribute("mode_pay",mode_pay);

	SimpleDateFormat d=new SimpleDateFormat("yyyy-MM-dd");
	Date date_fin_p;
	try {
		date_fin_p =d.parse(f);
		session.setAttribute("date_fin",date_fin_p);
	location l=op.GetLocation(id_location);
	session.setAttribute("mode_pay",l.getMode_pay());


	Date date_fin= l.getDate_fin();
	Calendar calendar=Calendar.getInstance();
	calendar.setTime(date_fin);
	calendar.add(calendar.DAY_OF_YEAR,+1);
	System.out.println(""+calendar.getTime());
	session.setAttribute("date_debut",calendar.getTime());
	String type_colocation=null;
	if(op.GetMaxColocataire(id_bien_louer)!=1) {
 		session.setAttribute("type_colocation","colocation");
 		type_colocation="colocation";
 		
}else {
		session.setAttribute("type_colocation","normale");
		type_colocation="normale";
				}
	System.out.print("dat debut "+calendar.getTime()+" dat fin"+date_fin_p);
	if(calendar.getTime().after(date_fin_p)) {
		out.println("erreur date  ");
		request.setAttribute("erreur","Erreur : Date de fin avant Date debut !");
		RequestDispatcher DL =request.getRequestDispatcher("FormProlongation.jsp");
		DL.forward(request,response);
		response.sendRedirect("FormProlongation.jsp");

	}
	final long ms=1000*60*60*24;
	long nbr_jour=Math.abs(date_fin_p.getTime()-date_fin.getTime())/ms;
	
	final long t=1000*60*60*24;

	long tt=Math.abs(date_fin_p.getTime()-date_fin.getTime())/t;
	
	if((tt<356)&&(mode_pay.equals("annuel"))) {
		request.setAttribute("erreur","Erreur :Mode payement incorrect !");
		RequestDispatcher DL =request.getRequestDispatcher("FormProlongation.jsp");
		DL.forward(request,response);
		response.sendRedirect("FormProlongation.jsp");
	}
	if(nbr_jour>2190||nbr_jour<31) {
		request.setAttribute("erreur","Erreur : Periode de location +/- periode normale !inserer date entre moi /6 ans !");
		RequestDispatcher DL =request.getRequestDispatcher("FormProlongation.jsp");
		DL.forward(request,response);
		response.sendRedirect("FormProlongation.jsp");

	}
if(op.GetMaxColocataire(id_bien_louer)!=1) {
		if(op.is_plane(id_bien_louer, calendar.getTime() , date_fin_p)) {
			request.setAttribute("erreur","Erreur : nombre des locataires a cette date a ca max valeur! Choisir autre date svp");
			RequestDispatcher DL =request.getRequestDispatcher("FormProlongation.jsp");
			DL.forward(request,response);
			response.sendRedirect("FormProlongation.jsp");

	}}else {
if(op.islouer(id_bien_louer, calendar.getTime(), date_fin_p)) {
	request.setAttribute("erreur","Erreur : bien est deja louer dans cette date choisir une autre");
	RequestDispatcher DL =request.getRequestDispatcher("FormProlongation.jsp");
	DL.forward(request,response);
	response.sendRedirect("FormProlongation.jsp");

	}else {
	if(op.isAtt(id_bien_louer,calendar.getTime(), date_fin_p)) {
		request.setAttribute("erreur","Erreur :Il ya deja une demmande de location au cette date possible d'etre refuse ou accepter alore consulter ce bien bientot!");
		RequestDispatcher DL =request.getRequestDispatcher("FormProlongation.jsp");
		DL.forward(request,response);
		response.sendRedirect("FormProlongation.jsp");

		}}}

session.setAttribute("nbr_jour",nbr_jour);
System.out.print("nbr joour"+nbr_jour);
double prix_jour=op.GetPrix(id_bien_louer);
session.setAttribute("prix_jour",prix_jour);

double montant_pure=nbr_jour*prix_jour+((nbr_jour*prix_jour*20)/100);
session.setAttribute("montant_pure",montant_pure);
session.setAttribute("montant_agence",nbr_jour*prix_jour+((nbr_jour*prix_jour*20)/100));

double mode;
if(session.getAttribute("mode_pay").equals("mensuel")) {
	 mode=30*prix_jour;
}else {
	if(session.getAttribute("mode_pay").equals("annuel")) {
	 mode=365*prix_jour;
	}else {
		
	 mode=montant_pure;
	}
	 
}
session.setAttribute("mode",mode);
response.sendRedirect("AfficherContratFactp.jsp");



	} catch (ClassNotFoundException | SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (ParseException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}

}