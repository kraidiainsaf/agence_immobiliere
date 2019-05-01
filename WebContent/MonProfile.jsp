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

<%@page import="Modele.operation" %>
<%@page import="Modele.personne" %>
<div class="home-lager-shearch" style="padding-top: 25px; margin-top: -10px; padding-bottom: 60px; background-color: rgb(252, 252, 252);"  style="text-align: center;">
            <div class="container"  style="text-align: center;">
         <!-- cadre de recherche  -->      
          <div class="col-md-12 large-search" style="background-color: #F4C543;padding: 3px;"  style="text-align: center;"> 
                    <div class="search-form wow pulse" style="background-color:#EEF0F0;text-align: center;color: black;">
  <div class="col-xs-4 col-sm-4 dealer-face"  style="text-align: center;">
  
                                                <a href="">
                                                    <img src="assets/img/client-face1.png" class="img-circle">
                                                </a>
                                            	   <%operation op=new operation(); %>
                                               <br>
                                               <%if(obj.isLocataire(id)&&obj.isProprietaire(id)){ %>
                                               <h3 style="text-align: center;color:#F4C543;">Nombre des Locations : </h3>
                                                <%=(int)session.getAttribute("locations") %>
                                               <h3 style="text-align: center;color:#F4C543;">Nombre des biens : </h3>                                           
                                                <%=(int)session.getAttribute("biens") %>
                                                <h3 style="text-align: center;color:#F4C543;">Mes Points :</h3>
                                            	   <%=op.getPoint(id) %>
                                               <%}else{
                                            	   if(obj.isLocataire(id)){%>
                                            		    <h3 style="text-align: center;color:#F4C543;">Nombre des Locations : </h3>
                                                <%=(int)session.getAttribute("locations") %>
                                            	   <% }else{%>
                                            	   <h3 style="text-align: center;color:#F4C543;" >Mes Points :</h3>
                                            	   <%=op.getPoint(id) %>
                                            		    <h3 style="text-align: center;color:#F4C543;">Nombre des biens : </h3>                                           
                                                <%=(int)session.getAttribute("biens") %>
                                            	   
                                            	   <%}} %>
                                            	   
                                            	   
                                              
                                            </div>
                                            <div class="col-xs-8 col-sm-8 ">
                                              <div  style="text-align: center"> <h3 class="dealer-name">
		 
                                                    <h2> <%=(String)session.getAttribute("nom") %> ,<%=(String)session.getAttribute("prenom") %> </h2>
                                                    <span><img width="30px" height="30px"  src="pseudo.png"><%=(String)session.getAttribute("pseudo") %> </span>        
                                                </h3>
                                              
                                                <div class="dealer-social-media">
                                                    <a class="twitter" target="_blank" href="">
                                                        <i class="fa fa-twitter"></i>
                                                    </a>
                                                    <a class="facebook" target="_blank" href="">
                                                        <i class="fa fa-facebook"></i>
                                                    </a>
                                                    <a class="gplus" target="_blank" href="">
                                                        <i class="fa fa-google-plus"></i>
                                                    </a>
                                                    <a class="linkedin" target="_blank" href="">
                                                        <i class="fa fa-linkedin"></i>
                                                    </a> 
                                                    <a class="instagram" target="_blank" href="">
                                                        <i class="fa fa-instagram"></i>
                                                    </a>       
                                                </div>

                                            </div>
                                    
                                        <div class="clear">
                                            <ul class="dealer-contacts">                                       
                                              <h6><img width="30px" height="30px"  src="card.png"> Numero Cart Identité :<%=(String)session.getAttribute("cart_identite") %></h6>
                                                <li><img width="30px" height="30px"  src="email.png"> Email :<%=(String)session.getAttribute("email") %></li>
                                                <li><img width="20px" height="20px"  src="tlf.png"> Numero Telephone :<%=(String)session.getAttribute("num_telephone") %></li>
                                                <li><img width="20px" height="20px"  src="password.png"> Password :<%=(String)session.getAttribute("password") %></li>
                                              
                                              <a href="GoFormModifierProfile">Modifier Mon Profile  <img width="10px" height="10px" src="modif.png"></a>
                                               
                                            </ul>
                                         
                                        </div>
</div>
                </div></div>
            </div>
        </div>
         <%@ include file="footer2.jsp" %>