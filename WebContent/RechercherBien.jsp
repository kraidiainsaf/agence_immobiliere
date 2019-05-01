 
<%int id=(int)session.getAttribute("id_personne");%>
<%@page import="Modele.cntrlAuthentif" %>
<% cntrlAuthentif obj=new cntrlAuthentif(); %>

<%if(obj.isLocataire(id)&&obj.isProprietaire(id)){%>
	<%@ include file="header_proprietaire_locataire.jsp" %>
<% }else{%>
<% if(obj.isProprietaire(id)){%>
	<%@ include file="header_proprietaire.jsp" %>
	
<% 
}else{ %>
 <%@ include file="header_locataire.jsp" %>
 <%} }%>
 
 <div class="home-lager-shearch" style="padding-top: 25px; margin-top: -10px; padding-bottom: 60px; background-color: rgb(252, 252, 252);">
            <div class="container" >
         <!-- cadre de recherche  -->      
          <div class="col-md-12 large-search" style="background-color: #F4C543;padding: 3px;"> 
                    <div class="search-form wow pulse" style="background-color:#f9f8f8;text-align: center;color: black;">
                    
<div class="row">
<h1  style="text-align: center;color:#F4C543;"><i ><u> Selectionner un type de bien </u></i>:</h1>
 <br><br><br>
                                    <div class="col-xs-6 m-padding"><p style="text-align: center;" >
                                    
                                     <div class="welcome-icon"><a href="GoRechercherMaison"> <img width="250" height="350" src="maison.png"><br><br> Maison</a>
                                     </div></div>
                                   
                                <div class="col-xs-6 m-padding"><p style="text-align: center;" >
                                     <div class="welcome-icon"><a href="GoRechercherDepot"> <img width="250" height="350" src="depot.png"><br><br> Depot</a>
                                    </div></div>

                                    <div class="col-xs-6 m-padding"><p style="text-align: center;" >
                                     <div class="welcome-icon"><a href="GoRechercherAppartement"> <img width="250" height="350" src="app.png"><br><br> Appartement</a>
                                     </div></div>
                                     <img alt="" src="">
                                    <div class="col-xs-6 m-padding"><p style="text-align: center;" >
                                     <div class="welcome-icon"><a href="GoRechercherGarage"> <img width="250" height="350" src="garage.png"><br><br> Garage</a>
                                     </div></div>
                                    <div class="col-xs-6 m-padding"><p style="text-align: center;" >
                                     <div class="welcome-icon"><a href="GoRechercherLocaleCommercial"> <img width="250" height="350" src="local.png"><br><br> Locale</a>
                                     </div></div>
                                    <div class="col-xs-6 m-padding"><p style="text-align: center;" >
                                     <div class="welcome-icon"><a href="GoRechercherTerrain"> <img width="150" height="150" src="terrain.png"><br><br> Terrain</a>
                                    </div></div>
                                </div>
             </div></div></div>
             </div>
         <%@ include file="footer2.jsp" %>
        
