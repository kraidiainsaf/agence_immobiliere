package Controle;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modele.cntrlCompte;

/**
 * Servlet implementation class modifierProfile
 */
@WebServlet("/modifierProfile")
public class modifierProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifierProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		cntrlCompte ct=new cntrlCompte();
		String nom=	request.getParameter("nom");
	String prenom=request.getParameter("prenom");
			String pseudo=request.getParameter("pseudo");
			String num=request.getParameter("num");
			String email=request.getParameter("email");
			String psd=request.getParameter("ps");
			String id=request.getParameter("id");
			String password=request.getParameter("password");
			String photo="images/"+request.getParameter("photo");
			System.out.println("ps"+password);
			int id_pers=Integer.parseInt(id);
			if(nom.equals("")||prenom.equals("")||pseudo.equals("")||email.equals("")||num.equals("")){
				RequestDispatcher DL =request.getRequestDispatcher("/afficherProfile.jsp");
				DL.include(request,response);
			}else{
			if(psd.equals(pseudo)){
				try {
					ct.modifierProfile(id_pers, nom, prenom, pseudo, email, num,password);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(((photo.equals(ct.getPhoto(id_pers)))==false)&&(photo!=null)&&(photo.equals("images/")==false)){
					ct.modifierphoto(id_pers, photo);}
				RequestDispatcher DL =request.getRequestDispatcher("/afficherProfile.jsp");
				DL.include(request,response);
			}else{
				try {
					if(ct.verfiferPseudo(pseudo)){
						RequestDispatcher DL =request.getRequestDispatcher("/afficherProfile.jsp");
						DL.include(request,response);
					}else{
						ct.modifierProfile(id_pers, nom, prenom, pseudo, email, num,password);
						
						System.out.println("test");
						System.out.println(photo);
						if(((photo.equals(ct.getPhoto(id_pers)))==false)&&((photo.equals("")))==false)
						ct.modifierphoto(id_pers, photo);
						
						RequestDispatcher DL =request.getRequestDispatcher("/afficherProfile.jsp");
						DL.include(request,response);
					}
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}}
	}

}
