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

import Modele.operation;

@WebServlet("/AjouterProlongationServlet")
public class AjouterProlongationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public AjouterProlongationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		operation op=new operation();
		HttpSession session=request.getSession();
		int id_personne=(int) session.getAttribute("id_personne");
		int id_bien=(int) session.getAttribute("id_bien_louer");
		Date date_debut=(Date) session.getAttribute("date_debut");
		Date date_fin=(Date) session.getAttribute("date_fin");
String mode_pay=(String) session.getAttribute("mode_pay");
	double	montant=(double) session.getAttribute("montant_agence");
try {
	int	id_location = op.Ajouterlocation(id_bien, date_debut, date_fin, mode_pay);
int code=	op.AjouterFact(id_personne, id_location, montant);
session.setAttribute("code",code);
response.sendRedirect("ImprimerFact.jsp");
	
} catch (ClassNotFoundException | SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}

}
