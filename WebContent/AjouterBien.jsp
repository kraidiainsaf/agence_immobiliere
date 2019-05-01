<%
	       response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	       response.addHeader("Cache-Control", "post-check=0, pre-check=0");
	       response.setHeader("Pragma", "no-cache");
	       response.setDateHeader("Expires", 0);
    
if(session.getAttribute("id_personne")==null){
	RequestDispatcher DL =request.getRequestDispatcher("authentifg");
DL.forward(request,response);}
	%>
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
 <%}} %>

<title>Ajouter Bien </title>

 <div class="home-lager-shearch" style="padding-top: 25px; margin-top: -10px; padding-bottom: 60px; background-color: rgb(252, 252, 252);">
            <div class="container" >
         <!-- cadre de recherche  -->      
          <div class="col-md-12 large-search" style="background-color: #F4C543;padding: 3px;"> 
                    <div class="search-form wow pulse" style="background-color:#f9f8f8;text-align: center;color: black;">
                    
   
 <div class="row">
 
 <h1  style="text-align: center;color:#F4C543;"><i ><u> Selectionner un type de bien  </u></i>:</h1>
                      <%String n=(String)request.getAttribute("note"); %>
                        
 <%if(n!=null){ %>
<P style="border:1px double #b3e6b3;background-color:geray;padding:10px;margin-left:400px;margin-right:400px;background-color: #b3e6b3;"><%=n %></P>
                        <%} %>
 <br>
                                    <div class="col-xs-6 m-padding"><p style="text-align: center;" >
                                    
                                     <div class="welcome-icon"><a href="GoAjouteMaison"> <img width="250" height="350" src="maison.png"><br><br>Ajouter  Maison</a>
                                     </div></div>
                                   
                                <div class="col-xs-6 m-padding"><p style="text-align: center;" >
                                     <div class="welcome-icon"><a href="GoAjouteDepot"> <img width="250" height="350" src="depot.png"><br><br>Ajouter Depot</a>
                                    </div></div>

                                    <div class="col-xs-6 m-padding"><p style="text-align: center;" >
                                     <div class="welcome-icon"><a href="GoAjouteAppartement"> <img width="250" height="350" src="app.png"><br><br>Ajouter Appartement</a>
                                     </div></div>
                                     <img alt="" src="">
                                    <div class="col-xs-6 m-padding"><p style="text-align: center;" >
                                     <div class="welcome-icon"><a href="GoAjouteGarage"> <img width="250" height="350" src="garage.png"><br><br>Ajouter Garage</a>
                                     </div></div>
                                    <div class="col-xs-6 m-padding"><p style="text-align: center;" >
                                     <div class="welcome-icon"><a href="GoAjouteLocaleCommercial"> <img width="250" height="350" src="local.png"><br><br>Ajouter Locale</a>
                                     </div></div>
                                    <div class="col-xs-6 m-padding"><p style="text-align: center;" >
                                     <div class="welcome-icon"><a href="GoAjouteTerrain"> <img width="150" height="150" src="terrain.png"><br><br>Ajouter Terrain</a>
                                    </div></div>
                                </div>
                    </div>
                </div>
            </div>
        </div>
         <%@ include file="footer2.jsp" %>
        