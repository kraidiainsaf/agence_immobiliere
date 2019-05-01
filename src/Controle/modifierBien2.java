package Controle;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Modele.bien;
import Modele.cntrlBien;

/**
 * Servlet implementation class modifierBien2
 */
@WebServlet("/modifierBien2")
public class modifierBien2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifierBien2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		String sup=request.getParameter("superficie");
		String pri=request.getParameter("prix");
		double superficie=Double.parseDouble(sup);
		double prix=Double.parseDouble(pri);
		String description=request.getParameter("description");
		String maxco=request.getParameter("max_colocataire");
		int max_colocataire=Integer.parseInt(maxco);
		String id1=request.getParameter("id");
		int id_bien=Integer.parseInt(id1);
		cntrlBien cb=new cntrlBien();
		bien b=new bien();
		HttpSession bien=request.getSession();
		try {
			cb.modifierBien(id_bien, superficie, prix, description, max_colocataire);
			String tof1=request.getParameter("tof");
			String image1="images/"+request.getParameter("image1");
			System.out.println(image1);
			String image2="images/"+request.getParameter("image2");
			String image3="images/"+request.getParameter("image3");
			String image4="images/"+request.getParameter("image4");
			String image5="images/"+request.getParameter("image5");
			//cb.modifierImage(id_bien, image1, image2, image3, image4, image5);
			System.out.println("1"+b.getimg1(id_bien));
			System.out.println("2"+b.getimg2(id_bien));
			System.out.println("3"+b.getimg3(id_bien));
			System.out.println("4"+b.getimg4(id_bien));
			System.out.println("5"+b.getimg5(id_bien));
			System.out.println(image1.equals(b.getimg1(id_bien)));
			
			if((image1.equals(b.getimg1(id_bien))==false)&&((image1.equals("images/"))==false)&&(image1!=null)){
				System.out.println("h1"+(((image1.equals(b.getimg1(id_bien)))==false)&&((image1.isEmpty()))==false));
				//cb.modifierImage(id_bien, image1,b.getimg2(id_bien),b.getimg3(id_bien),b.getimg4(id_bien),b.getimg5(id_bien));
				cb.modifierImage1(id_bien, image1);
			}
			
			if((image2.equals(b.getimg2(id_bien)) ==false)&&((image2.equals("images/"))==false)&&(image2!=null)){
				System.out.println("h2"+(((image2.equals(b.getimg2(id_bien))) ==false)&&((image2.isEmpty()))==false));
			//	cb.modifierImage(id_bien, b.getimg1(id_bien),image2,b.getimg3(id_bien),b.getimg4(id_bien),b.getimg5(id_bien));
				cb.modifierImage2(id_bien, image2);	
			}
			if((image3.equals(b.getimg3(id_bien))==false)&&((image3.equals("images/"))==false)&&(image3!=null)){
				System.out.println("h3"+(((image3.equals(b.getimg3(id_bien)))==false)&&((image3.isEmpty()))==false));
				//cb.modifierImage(id_bien, b.getimg1(id_bien),b.getimg2(id_bien),image3,b.getimg4(id_bien),b.getimg5(id_bien));
				cb.modifierImage3(id_bien, image3);
			}
			if((image4.equals(b.getimg4(id_bien))==false)&&((image4.equals("images/"))==false)&&(image4!=null)){
				System.out.println("h4"+(((image4.equals(b.getimg4(id_bien)))==false)&&((image4.isEmpty()))==false));
				//cb.modifierImage(id_bien, b.getimg1(id_bien),b.getimg2(id_bien),b.getimg3(id_bien),image4,b.getimg5(id_bien));
				cb.modifierImage4(id_bien, image4);
			}
			if((image5.equals(b.getimg5(id_bien))==false)&&((image5.equals("images/"))==false)&&(image5!=null)){
				System.out.println("h5"+(((image5.equals(b.getimg5(id_bien)))==false)&&((image5.isEmpty()))==false));
				//cb.modifierImage(id_bien, b.getimg1(id_bien),b.getimg2(id_bien),b.getimg4(id_bien),b.getimg4(id_bien),image5);}
				cb.modifierImage5(id_bien, image5);}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
RequestDispatcher DL =request.getRequestDispatcher("/modifierbiens1");
		DL.forward(request,response);	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
