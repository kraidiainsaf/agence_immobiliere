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
<%System.out.println("type_location_form louer"+session.getAttribute("type_colocation"));
session.setAttribute("type_colocation",session.getAttribute("type_colocation"));
 %>
<%

%>
 <div class="home-lager-shearch" style="padding-top: 25px; margin-top: -10px; padding-bottom: 60px; background-color: rgb(252, 252, 252);">
            <div class="container" >
         <!-- cadre de recherche  -->      
          <div class="col-md-12 large-search" style="background-color: #F4C543;padding: 3px;"> 
                    <div class="search-form wow pulse" style="background-color:#f9f8f8;text-align: center;color: black;">
                       <h6> votre demmande est envoyée! </h6>
<h2><i><img height="40" width="40" align="top" src="titre.png"> Pour completer le processus de location Vous devez : </i></h2><br>
  <img height="15" width="15" align="top" src="nice.png"> Imprimer votre contrat et votre facture.<br>
  <img height="15" width="15" align="top" src="nice.png"> Apportez Vos papier d'identité( carte national d'identité,passport,permis de conduire).<br>
  <img height="15" width="15" align="top" src="nice.png"> Apres avoir terminer le processus de paiement et la consultation du bien ,vous pouver obtenir les cles <br> 
<br><br>
      <img width="400px" height="400px" src="Merci.png">
<br>
<a href="Facture.jsp">
<img  src="print.png" width="20px" height="20px">
<button style="width:200px;color:#F4C543;border:1px solid #F4C543;"   value="imprimer mon facture">Imprimer mon facture</button>
</a>
<a href="contrat-fact-pdf.jsp">
<img  src="print.png" width="20px" height="20px">
<button style="width:200px;color:#F4C543;border:1px solid #F4C543;"   value="imprimer mon contrat">Imprimer mon contrat</button>
</a>
<br>
                    </div>
        
                    
                </div>
       
                
            </div>
        </div>
	
 <%@ include file="footer2.jsp" %>