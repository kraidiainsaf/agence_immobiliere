<%
	       response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	       response.addHeader("Cache-Control", "post-check=0, pre-check=0");
	       response.setHeader("Pragma", "no-cache");
	       response.setDateHeader("Expires", 0);
    
if(session.getAttribute("id_personne")==null){
	RequestDispatcher DL =request.getRequestDispatcher("authentifg");
DL.forward(request,response);}%>
<%@page import="Modele.cntrlAuthentif" %>
<%int id=(int)session.getAttribute("id_personne"); %>
<% cntrlAuthentif obj=new cntrlAuthentif(); %>

<%if(obj.isLocataire(id)&&obj.isProprietaire(id)){%>
	<%@ include file="header_proprietaire_locataire.jsp" %>
<% }else{%>
<% if(obj.isProprietaire(id)){%>
	<%@ include file="header_proprietaire.jsp" %>
	
<% 
}else{ %>
 <%@ include file="header_locataire.jsp" %>
 <%}} %> 
 <%
 
 if(session.getAttribute("type_colocation").equals("normaler")) {

					//session.setAttribute("type_colocation","normale");
					response.sendRedirect("FormLouerBien.jsp");

				}

 if(session.getAttribute("type_colocation").equals("colocationr")) {

					//session.setAttribute("type_colocation","colocation");
					response.sendRedirect("FormLouerBien.jsp");

				}
 
 
 %>
<%System.out.println("type_location_form louer"+session.getAttribute("type_colocation"));
 %>

 <div class="home-lager-shearch" style="padding-top: 25px; margin-top: -10px; padding-bottom: 60px; background-color: rgb(252, 252, 252);">
            <div class="container" >
         <!-- cadre de recherche  -->      
          <div class="col-md-12 large-search" style="background-color: #F4C543;padding: 3px;"> 
                    <div class="search-form wow pulse" style="background-color:#f9f8f8;text-align: center;color: black;">
                      <h2><img height="40" width="40" src="money.png"><i> <u>La Facture  :</u></i></h2>
<img width="20px" height="20px" src="titre.png"> Code facture :............................<br><br>
<img width="20px" height="20px" src="titre.png"><u> Date debut: <%=session.getAttribute("date_debut")%></u><br><br>
<img width="20px" height="20px" src="titre.png"><u> Date fin:<%=session.getAttribute("date_fin")%></u><br><br>
<img width="20px" height="20px" src="titre.png"> Nombre des jours : <%=(Long)session.getAttribute("nbr_jour")%><br>
<img width="20px" height="20px" src="titre.png"> Prix De Bien : <%=(double)session.getAttribute("prix_jour") %> DA<br>
<img width="20px" height="20px" src="titre.png"> Montant : <%=(double)session.getAttribute("montant_pure") %> DA<br>
<img width="20px" height="20px" src="titre.png"> Mode Paiement : <%=(String)session.getAttribute("mode_pay") %> <br>
<img width="20px" height="20px" src="titre.png"> Prix selon mode : <%=(double)session.getAttribute("mode") %> DA<br>
<img width="20px" height="20px" src="titre.png"> Prix D'agance : <%="20%" %><br>

<form action="AjouterLocationServlet" method="get">
<input type="submit" name="confirmer loucation" value="confirmation de la location"  style="border: 1px solid #F4C543;width: 230px; ">
</form>
<br>
<form action="AfficherRechercheMaisonDetail.jsp" method="get">
<input type="submit" name="annuler" value="annuler" style="border: 1px solid #F4C543;width: 200px; " >
</form>


                    </div>
                </div>
            </div>
        </div>
	
 <%@ include file="footer2.jsp" %>