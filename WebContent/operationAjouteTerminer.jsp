 <%
	       response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	       response.addHeader("Cache-Control", "post-check=0, pre-check=0");
	       response.setHeader("Pragma", "no-cache");
	       response.setDateHeader("Expires", 0);
    
if(session.getAttribute("id_personne")==null){
	RequestDispatcher DL =request.getRequestDispatcher("authentifg");
DL.forward(request,response);}
	%>  
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

<%session.setAttribute("adresse","reply"); %>

 <div class="home-lager-shearch" style="padding-top: 25px; margin-top: -130px; padding-bottom: 60px; background-color: rgb(252, 252, 252);">
            <div class="container" >
         <!-- cadre de recherche  -->      
          <div class="col-md-12 large-search" style="background-color: #F4C543;padding: 3px;"> 
                    <div class="search-form wow pulse" style="background-color:#f9f8f8;text-align: center;color: black;">
                       <h6> votre demmande est envoyée! </h6>
  <h2><i><img height="40" width="40" align="top" src="titre.png"> Pour completer le processus d'ajout Vous devez : </i></h2><br>
                       
  <img height="15" width="15" align="top" src="nice.png"> Apportez 5 photos de votre bien.<br>
  <img height="15" width="15" align="top" src="nice.png"> Apportez Vos documents de propriété.<br>
  <img width="400px" height="400px" src="Merci.png">
  <br>
  
<a href="AjouterBien.jsp">
<img width="30px" height="30px" src="re.png">
<button  value="allez vers l'ajoute"></button>
</a>

                    </div>
                </div>
            </div>
        </div>
	
 <%@ include file="footer2.jsp" %>