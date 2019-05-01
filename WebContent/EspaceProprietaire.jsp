 <%
	       response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	       response.addHeader("Cache-Control", "post-check=0, pre-check=0");
	       response.setHeader("Pragma", "no-cache");
	       response.setDateHeader("Expires", 0);
    
if(session.getAttribute("id_personne")==null){
	RequestDispatcher DL =request.getRequestDispatcher("authentifg");
DL.forward(request,response);}else{
	%>  
	
 <%@ include file="header_proprietaire.jsp" %>
	
<%@page import="java.util.ArrayList"%>

           
           
        <div class="Welcome-area">
            <div class="container">
                <div class="row">
                
                    <div class="col-md-12 Welcome-entry  col-sm-12">
                    
                    
                    
                        <div class="col-md-5 col-md-offset-2 col-sm-6 col-xs-12">
                            <div class="welcome_text wow fadeInLeft" data-wow-delay="0.3s" data-wow-offset="100">
                                <div class="row">
                                    <div class="col-md-10 col-md-offset-1 col-sm-12 text-center page-title">
                                        <!-- /.feature title -->
                                        <h2>El KERIA</h2>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-5 col-sm-6 col-xs-12">
                            <div  class="welcome_services wow fadeInRight" data-wow-delay="0.3s" data-wow-offset="100">
                                <div class="row">
                                    <div class="col-xs-6 m-padding"><p style="text-align: center;" >
                                     <div class="welcome-icon"><a href="GoRechercherMaison"> <img width="200" height="300" src="maison.png"><br><br>Maison</a>
                                     </p></div></div>
                                   
                                <div class="col-xs-6 m-padding"><p style="text-align: center;" >
                                     <div class="welcome-icon"><a href="GoRechercherDepot"> <img width="200" height="300" src="depot.png"><br><br>Depot</a>
                                     </p></div></div>

                                    <div class="col-xs-6 m-padding"><p style="text-align: center;" >
                                     <div class="welcome-icon"><a href="GoRechercherAppartement"> <img width="200" height="300" src="app.png"><br><br>Appartement</a>
                                     </p></div></div>
                                    <div class="col-xs-6 m-padding"><p style="text-align: center;" >
                                     <div class="welcome-icon"><a href="GoRechercherGarage"> <img width="200" height="300" src="garage.png"><br><br>Garage</a>
                                     </p></div></div>
                                    <div class="col-xs-6 m-padding"><p style="text-align: center;" >
                                     <div class="welcome-icon"><a href="GoRechercherLocaleCommercial"> <img width="200" height="300" src="local.png"><br><br>Locale</a>
                                     </p></div></div>
                                    <div class="col-xs-6 m-padding"><p style="text-align: center;" >
                                     <div class="welcome-icon"><a href="GoRechercherTerrain"> <img width="100" height="100" src="terrain.png"><br><br>Terrain</a>
                                     </p></div></div>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
<!-- ajouter bien -->
      
                   
   <!-- Debut de recherche   -->
        <!--Welcome area -->
         <div class="slider-area">
            
            <div class="container slider-content">
                <div class="row">
                      <div class="home-lager-shearch"  style=" margin-top: -130px; padding-bottom: 60px; background-color: rgb(252, 252, 252);">
            <div class="container"  >
         <!-- cadre de recherche  -->      
                    <div   style="text-align: center;color: black;">
                     <%@page import="Modele.bien" %>
    <%@page import="Modele.operation" %>
   <%ArrayList<bien> list=null;%>
<%list=op.getbienPub();int i=0;%>
   
   <h2  style="color:#F4C543;font-family: serif;"><i >Louer avec bon prix </i>:</h2>
   <h4 style="color:#F4C543;font-family: serif;"><i >Nous proposer</i>:</h4>
<br><br>
 <div class="col-md-12 clear " style="display:inline;text-align: center;"> 
                        <div id="list-type" class="proerty-th" >
                        <%while(list.isEmpty()==false){
	bien m=list.get(i);
%>
                            <div class="col-sm-6 col-md-3 p0" >
                                <div class="box-two proerty-item" >
                                    <div class="item-thumb">
                                       <img width="50" height="50" src="<%=m.getImage1()%>">
                                    </div>

                                    <div class="item-entry overflow">
                                        <div class="dot-hr"></div>
                                        <span class="pull-right"><b> Superficie :</b><%=m.getSuperficie() %> m2</span> <br>
                                        <span class="pull-left"><b> Adresse :</b><%=m.getAdresse()%></span> <br>
                                        <span class="proerty-price pull-right"> Prix :<%=m.getPrix()%> DA</span>
                                         <form action="RechercherBienDetailServlet" method="get">
		<% 
		
if(op.GetMaxColocataire(m.getId_bien())!=1){
	%>
	<input type="hidden" name="type_colocation" value="colocation"> 
	<%}else{ %>
		<input type="hidden" name="type_colocation" value="normale"> 
	<%} %>
	<input type="hidden" name="id_bien" value=<%=m.getId_bien()%>> 
    <input type="submit" name="prolonger" value="voir bien" style="border: 2px solid #F4C543;"> <hr></form>
                                      
      
                                    </div>
                                </div>   
                    
                </div>
                 <%list.remove(i);} %> 
                
                 </div>          
            </div>

 </div></div></div></div>
                </div>
            </div>
        
        
            <div class="page-head"> 
            <div class="container">
                <div class="row">
                    <div class="page-head-content" style="text-align: center;">
                   <h3>Bien Loge dans un bon logement </h3>
                        <h1 class="page-title">Ajouter Votre bien</h1> 
                     <a href="GoAjouterBien"> <img width="100px" height="100px" src="add.png">    </a>          
                    </div>
                </div>
            </div>
        </div>
        
   <%@ include file="footer1.jsp" %>
<%} %>
