<%
	       response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	       response.addHeader("Cache-Control", "post-check=0, pre-check=0");
	       response.setHeader("Pragma", "no-cache");
	       response.setDateHeader("Expires", 0);
   
 
if(session.getAttribute("id_personne")==null){
	RequestDispatcher DL =request.getRequestDispatcher("authentifg");
DL.forward(request,response);} %>
<%@page import="java.util.ArrayList"%>
<%int id=(int)session.getAttribute("id_personne");%>
<%@page import="Modele.cntrlAuthentif" %>
<% cntrlAuthentif obj=new cntrlAuthentif(); %>

<%if(obj.isLocataire(id)&&obj.isProprietaire(id)){%>
	<%@ include file="header_proprietaire_locataire.jsp" %>
<% }else{%>

 <%@ include file="header_locataire.jsp" %>
 <%} %>

<%@page import="Modele.location" %>
<%@page import="Modele.operation" %>
<%@page import="java.util.ArrayList"%>
<%@page import="Modele.operation" %>
<%@page import="java.util.Date"%>

<%@page import="Modele.maison" %>
<%@page import="Modele.appartement" %>
<%@page import="Modele.depot" %>
<%@page import="Modele.garage" %>
<%@page import="Modele.locale_commercial" %>
<%@page import="Modele.terrain" %>
<%operation op=new operation(); %>
<% ArrayList<location> liste_location_maison=(ArrayList<location>)session.getAttribute("liste_location_maison");%> 
<% ArrayList<location> liste_location_appartement=(ArrayList<location>)session.getAttribute("liste_location_appartement");%> 
<% ArrayList<location> liste_location_depot=(ArrayList<location>)session.getAttribute("liste_location_depot");%> 
<% ArrayList<location> liste_location_garage=(ArrayList<location>)session.getAttribute("liste_location_garage");%> 
<% ArrayList<location> liste_location_locale=(ArrayList<location>)session.getAttribute("liste_location_locale");%> 
<% ArrayList<location> liste_location_terrain=(ArrayList<location>)session.getAttribute("liste_location_terrain");%>

        <!-- property area -->
        <div class="content-area recent-property" style="background-color: #FFF;">
            <div class="container">   
                <div class="row">

                    <div class="col-md-9 pr-30 padding-top-40 properties-page user-properties">

                        <div class="section"> 
                            <div class="page-subheader sorting pl0 pr-10">


                                <ul class="sort-by-list pull-left">
                                    <li class="active">
                                        <a href="javascript:void(0);" class="order_by_date" data-orderby="property_date" data-order="ASC">
                                           Bien selon Date <i class="fa fa-sort-amount-asc"></i>					
                                        </a>
                                    </li>
                                   
                                </ul><!--/ .sort-by-list-->

                                <div class="items-per-page pull-right">
                                    <label for="items_per_page"><b>Biens Par Page :</b></label>
                                    <div class="sel">
                                        <select id="items_per_page" name="per_page">
                                            <option value="3">3</option>
                                            <option value="6">6</option>
                                            <option value="9">9</option>
                                            <option selected="selected" value="12">12</option>
                                            <option value="15">15</option>
                                            <option value="30">30</option>
                                            <option value="45">45</option>
                                            <option value="60">60</option>
                                        </select>
                                    </div><!--/ .sel-->
                                </div><!--/ .items-per-page-->
                            </div>

                        </div>



                        <div id="maison" class="section"> 
<h2  style="text-align: center;color:#F4C543;"><i ><u> les Maisons </u></i>:</h2>  
                          <div id="list-type" class="proerty-th-list">
                            
                                <div class="col-md-4 p0">
                                
                                    <div class="box-two proerty-item">
                                         <%if(liste_location_maison.isEmpty()){ %>
 <h6 style="text-align: center;" ><img width="40px" height="40px" src="vide.png"> Votre liste est vide (0) Maison louer </h6>
 <%}else{ %>

<% int co=1;%>
<%for(int i=0;i<liste_location_maison.size();i++){
	location m=liste_location_maison.get(i);%>
                                    
                                        <div class="item-thumb">
                                        <%maison maison=op.GetMaison(m.getId_bien()); %>
                                            <a href="property-1.html" ><img src="<%=maison.getImage1()%>"></a>
                                        </div>
                                    
                                            <h5><a href="property-1.html"> Numero :<%=co %>  </a></h5><% co++;%>
                                            <div class="dot-hr"></div>
<% int propritaire=op.GetIdPersonne(m.getId_bien()); %>
<%Date d=op.getDatePay(m.getId_location(),(int)session.getAttribute("id_personne"));
%>
                                             <span class="pull-right proerty-price">Montant : <%=op.getMontatnt(m.getId_location()) %> DA</span><br>

                                            <span class="pull-left"><b>Proprietaire  :</b><%=op.GetNamePersonne(propritaire) %> </span>
                                            <span class="pull-right"><b>Mode Paiement :</b> <%=m.getMode_pay() %></span><br>
                                            
                                            <span class="pull-right"><b><u>Date debut </u> :</b><%=m.getDate_debut() %></span>
                                            <span class="pull-left"><b><u>Date fin </u> :</b><%=m.getDate_fin() %></span>
<br>
                                      
                                                <div class="dealer-action pull-right" style="background-color:white;display: inline-flex;"> 
                                                                               
                                                    <%if(d==null){%>
                                                  <h3><img width="40px" height="40px"  src="alarm.png"> En Attente</h3>
<%}else{ %>
	<form action="GoFormProlongation">
	<input type="hidden" name="typebien" value="maison"> 
	<input type="hidden" name="id_bien_louer" value=<%=m.getId_bien() %>> 
	<input type="hidden" name="id_location" value=<%=m.getId_location() %>> 
    <input type="submit" name="prolonger" value="prolonger" style="border: 2px solid #F4C543;"><hr> </form>
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
	<%}%>
                                                
                                           </div><br><br><br><br><%}} %>


                                       
                                    </div>
                                </div>                             
                                              
                            </div>
                            </div>
                            
                            
                        <div id="depot" class="section"> 
<h2  style="text-align: center;color:#F4C543;"><i ><u> les depots </u></i>:</h2>  
                            <div id="list-type" class="proerty-th-list">
                            
                                <div class="col-md-4 p0">
                                
                                    <div class="box-two proerty-item">
                                    <%if(liste_location_depot.isEmpty()){ %>
                                    
 <h6 style="text-align: center;" ><img width="40px" height="40px" src="vide.png"> Votre liste est vide (0) depot louer </h6>
 
 <%}else{ %>

<% int co2=1;%>
<%for(int j=0;j<liste_location_depot.size();j++){
	location m=liste_location_depot.get(j);%>
                                     
                                        <div class="item-thumb">
                                        <%depot depot=op.GetDepot(m.getId_bien()); %>
                                            <a href="property-1.html" ><img src="<%=depot.getImage1()%>"></a>
                                           
                                        </div>
	
                                            <h5><a href="property-1.html"> Numero:<%=co2 %>  </a></h5><% co2++;%>
                                            <div class="dot-hr"></div>
<% int propritaire=op.GetIdPersonne(m.getId_bien()); %>
<%Date d=op.getDatePay(m.getId_location(),(int)session.getAttribute("id_personne"));
%>
                                             <span class="pull-right proerty-price">Montant : <%=op.getMontatnt(m.getId_location()) %> DA</span><br>

                                            <span class="pull-left"><b>Proprietaire  :</b><%=op.GetNamePersonne(propritaire) %> </span>
                                            <span class="pull-right"><b>Mode Paiement :</b> <%=m.getMode_pay() %></span><br>
                                            
                                            <span class="pull-right"><b><u>Date debut </u> :</b><%=m.getDate_debut() %></span>
                                            <span class="pull-left"><b><u>Date fin </u> :</b><%=m.getDate_fin() %></span>
<br>
                                  
                                                <div class="dealer-action pull-right" style="background-color:white;display: inline-flex;"> 
                                                                               
                                                    <%if(d==null){%>
                                                  <h3><img width="40px" height="40px"  src="alarm.png"> En Attente</h3>
<%}else{ %>
	<form action="GoFormProlongation">
		<input type="hidden" name="typebien" value="depot"> 

	<input type="hidden" name="id_bien_louer" value=<%=m.getId_bien() %>> 
	<input type="hidden" name="id_location" value=<%=m.getId_location() %>> 
    <input type="submit" name="prolonger" value="prolonger" style="border: 2px solid #F4C543;"> <hr></form>
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
    
	<%}%>
                                                
                                           </div><br><br><br><br><%}} %>


                                       
                                    </div>
                                </div>                             
                                              
                            </div>
                            </div>
                            
                      		

                                                 <div id="app" class="section"> 
<h2  style="text-align: center;color:#F4C543;"><i ><u> les appartement </u></i>:</h2>  
                            <div id="list-type" class="proerty-th-list">
                            
                                <div class="col-md-4 p0">
                                
                                    <div class="box-two proerty-item">
                                    <%if(liste_location_appartement.isEmpty()){ %>     
 <h6 style="text-align: center;" ><img width="40px" height="40px" src="vide.png"> Votre liste est vide (0) appartement louer </h6>
 
 <%}else{ %>

<% int co3=1;%>
<%for(int k=0;k<liste_location_appartement.size();k++){
	location m=liste_location_appartement.get(k);%>
                                        <div class="item-thumb">
                                             <%appartement app=op.GetAppartement(m.getId_bien()); %>
                                            <a href="property-1.html" ><img src="<%=app.getImage1()%>"></a>
                                           
                                        </div>
	
                                            <h5><a href="property-1.html"> Numero :<%=co3 %>  </a></h5><% co3++;%>
                                            <div class="dot-hr"></div>
<% int propritaire=op.GetIdPersonne(m.getId_bien()); %>
<%Date d=op.getDatePay(m.getId_location(),(int)session.getAttribute("id_personne"));
%>
                                             <span class="pull-right proerty-price">Montant : <%=op.getMontatnt(m.getId_location()) %> DA</span><br>

                                            <span class="pull-left"><b>Proprietaire  :</b><%=op.GetNamePersonne(propritaire) %> </span>
                                            <span class="pull-right"><b>Mode Paiement :</b> <%=m.getMode_pay() %></span><br>
                                            
                                            <span class="pull-right"><b><u>Date debut </u> :</b><%=m.getDate_debut() %></span>
                                            <span class="pull-left"><b><u>Date fin </u> :</b><%=m.getDate_fin() %></span>
<br>
                                   
                                                <div class="dealer-action pull-right" style="background-color:white;display: inline-flex;"> 
                                                                               
                                                    <%if(d==null){%>
                                                  <h3><img width="40px" height="40px"  src="alarm.png"> En Attente</h3>
<%}else{ %>
	<form action="GoFormProlongation">
			<input type="hidden" name="typebien" value="appartement"> 

	<input type="hidden" name="id_bien_louer" value=<%=m.getId_bien() %>> 
	<input type="hidden" name="id_location" value=<%=m.getId_location() %>> 
    <input type="submit" name="prolonger" value="prolonger" style="border: 2px solid #F4C543;"><hr> </form>
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
	<%}%>
                                                   </div><br><br><br><br><%}} %>


                                       
                                    </div>
                                </div>                             
                                              
                            </div>
                            </div>
                            
                                                 <div id="garage" class="section"> 
<h2  style="text-align: center;color:#F4C543;"><i ><u> les garages </u></i>:</h2>  
                            <div id="list-type" class="proerty-th-list">
                            
                                <div class="col-md-4 p0">
                                
                                    <div class="box-two proerty-item">
                                    <%if(liste_location_garage.isEmpty()){ %>
      
 <h6 style="text-align: center;" ><img width="40px" height="40px" src="vide.png"> Votre liste est vide (0) garage louer </h6>
 
 <%}else{ %>
<% int co4=1;%>
<%for(int x=0;x<liste_location_garage.size();x++){
	location m=liste_location_garage.get(x);%>
  
                                        <div class="item-thumb">
                                            <%garage garage=op.GetGarage(m.getId_bien()); %>
                                            <a href="property-1.html" ><img src="<%=garage.getImage1()%>"></a>
                                           
                                        </div>
	                                          <h5><a href="property-1.html"> Numero :<%=co4 %>  </a></h5><% co4++;%>
                                            <div class="dot-hr"></div>
<% int propritaire=op.GetIdPersonne(m.getId_bien()); %>
<%Date d=op.getDatePay(m.getId_location(),(int)session.getAttribute("id_personne"));
%>
                                            <span class="pull-right proerty-price">Montant : <%=op.getMontatnt(m.getId_location()) %> DA</span><br>

                                            <span class="pull-left"><b>Proprietaire  :</b><%=op.GetNamePersonne(propritaire) %> </span>
                                            <span class="pull-right"><b>Mode Paiement :</b> <%=m.getMode_pay() %></span><br>
                                            
                                            <span class="pull-right"><b><u>Date debut </u> :</b><%=m.getDate_debut() %></span>
                                            <span class="pull-left"><b><u>Date fin </u> :</b><%=m.getDate_fin() %></span>
<br>
                           
                                                <div class="dealer-action pull-right" style="background-color:white;display: inline-flex;"> 
                                                                               
                                                    <%if(d==null){%>
                                                  <h3><img width="40px" height="40px"  src="alarm.png"> En Attente</h3>
<%}else{ %>
	<form action="GoFormProlongation">
			<input type="hidden" name="typebien" value="garage"> 

	<input type="hidden" name="id_bien_louer" value=<%=m.getId_bien() %>> 
	<input type="hidden" name="id_location" value=<%=m.getId_location() %>> 
    <input type="submit" name="prolonger" value="prolonger" style="border: 2px solid #F4C543;"><hr> </form>
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
	<%}%>
                                                
                                          </div><br><br><br><br><%}} %>


                                       
                                    </div>
                                </div>                             
                                              
                            </div>
                            </div>
                                                 <div id="locale" class="section"> 
<h2  style="text-align: center;color:#F4C543;"><i ><u> les locaux </u></i>:</h2>  
                            <div id="list-type" class="proerty-th-list">
                            
                                <div class="col-md-4 p0">
                                
                                    <div class="box-two proerty-item">
                                    <%if(liste_location_locale.isEmpty()){ %>
      
 <h6 style="text-align: center;" ><img width="40px" height="40px" src="vide.png"> Votre liste est vide (0) locale louer </h6>
 
 <%}else{ %>
<% int co5=1;%>
<%for(int y=0;y<liste_location_locale.size();y++){
	location m=liste_location_locale.get(y);%>
                                        <div class="item-thumb">
                                             <%locale_commercial locale=op.GetLocaleCommercial(m.getId_bien()); %>
                                            <a href="property-1.html" ><img src="<%=locale.getImage1()%>"></a>
                                           
                                        </div>
	
                                            <h5><a href="property-1.html"> Numero:<%=co5 %>  </a></h5><% co5++;%>
                                            <div class="dot-hr"></div>
<% int propritaire=op.GetIdPersonne(m.getId_bien()); %>
<%Date d=op.getDatePay(m.getId_location(),(int)session.getAttribute("id_personne"));
%>
                                             <span class="pull-right proerty-price">Montant : <%=op.getMontatnt(m.getId_location()) %> DA</span><br>

                                            <span class="pull-left"><b>Proprietaire  :</b><%=op.GetNamePersonne(propritaire) %> </span>
                                            <span class="pull-right"><b>Mode Paiement :</b> <%=m.getMode_pay() %></span><br>
                                            
                                            <span class="pull-right"><b><u>Date debut </u> :</b><%=m.getDate_debut() %></span>
                                            <span class="pull-left"><b><u>Date fin </u> :</b><%=m.getDate_fin() %></span>
<br>                     
                                                <div class="dealer-action pull-right" style="background-color:white;display: inline-flex;"> 
                                                                               
                                                    <%if(d==null){%>
                                                  <h3><img width="40px" height="40px"  src="alarm.png"> En Attente</h3>
<%}else{ %>
	<form action="GoFormProlongation">
			<input type="hidden" name="typebien" value="locale_commercial"> 

	<input type="hidden" name="id_bien_louer" value=<%=m.getId_bien() %>> 
	<input type="hidden" name="id_location" value=<%=m.getId_location() %>> 
    <input type="submit" name="prolonger" value="prolonger" style="border: 2px solid #F4C543;"> <hr> </form>
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
	<%}%>
                                                
                                            </div><br><br><br><br><%}} %>


                                       
                                    </div>
                                </div>                             
                                              
                            </div>
                            </div>
                                                            <div id="terrain" class="section"> 
<h2  style="text-align: center;color:#F4C543;"><i ><u> les terrains </u></i>:</h2>  
                            <div id="list-type" class="proerty-th-list">
                            
                                <div class="col-md-4 p0">
                                
                                    <div class="box-two proerty-item">
                                    <%if(liste_location_terrain.isEmpty()){ %>
      
 <h6 style="text-align: center;" ><img width="40px" height="40px" src="vide.png"> Votre liste est vide (0) terrain louer </h6>
 
 <%}else{ %>
<% int co6=1;%>
<%for(int f=0;f<liste_location_terrain.size();f++){
	location m=liste_location_terrain.get(f);%>
                                        <div class="item-thumb">
                                            <%terrain terrain=op.GetTerrain(m.getId_bien()); %>
                                            <a href="property-1.html" ><img src="<%=terrain.getImage1()%>"></a>
                                           
                                        </div>
	
                                            <h5><a href="property-1.html"> Numero Locations:<%=co6 %>  </a></h5><% co6++;%>
                                            <div class="dot-hr"></div>
<% int propritaire=op.GetIdPersonne(m.getId_bien()); %>
<%Date d=op.getDatePay(m.getId_location(),(int)session.getAttribute("id_personne"));
%>
                                              <span class="pull-right proerty-price">Montant : <%=op.getMontatnt(m.getId_location()) %> DA</span><br>

                                            <span class="pull-left"><b>Proprietaire  :</b><%=op.GetNamePersonne(propritaire) %> </span>
                                            <span class="pull-right"><b>Mode Paiement :</b> <%=m.getMode_pay() %></span><br>
                                            
                                            <span class="pull-right"><b><u>Date debut </u> :</b><%=m.getDate_debut() %></span>
                                            <span class="pull-left"><b><u>Date fin </u> :</b><%=m.getDate_fin() %></span>
<br>
                                
                                                <div class="dealer-action pull-right" style="background-color:white;display: inline-flex;"> 
                                                                               
                                                    <%if(d==null){%>
                                                  <h3><img width="40px" height="40px"  src="alarm.png"> En Attente</h3>
<%}else{ %>
	<form action="GoFormProlongation">
		<input type="hidden" name="typebien" value="terrain"> 
	
	<input type="hidden" name="id_bien_louer" value=<%=m.getId_bien() %>> 
	<input type="hidden" name="id_location" value=<%=m.getId_location() %>> 
    <input type="submit" name="prolonger" value="prolonger" style="border: 2px solid #F4C543;"> <hr></form>
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
	<%}%>
                                                
                                           </div><br><br><br><br><%}} %>


                                       
                                    </div>
                                </div>                             
                                              
                            </div>
                            </div>
                              
                        </div>

             

                    <div class="col-md-3 p0 padding-top-40">
                        <div class="blog-asside-right">
                            <div class="panel panel-default sidebar-menu wow fadeInRight animated" >
                                <div class="panel-heading">
                                        <a href="#maison"> <h3 class="panel-title">Mes Maisons</h3></a>
                                </div>
                               
                            </div>

                            <div class="panel panel-default sidebar-menu wow fadeInRight animated">
                                <div class="panel-heading">
                                        <a href="#depot"> <h3 class="panel-title">Mes depots </h3></a>
                                </div>
                                <div class="panel-body recent-property-widget">

                                </div>
                            </div>
                            <div class="panel panel-default sidebar-menu wow fadeInRight animated">
                                <div class="panel-heading">
                                        <a href="#app"> <h3 class="panel-title">Mes Apparetements </h3></a>
                                </div>
                                <div class="panel-body recent-property-widget">

                                </div>
                            </div>
                            <div class="panel panel-default sidebar-menu wow fadeInRight animated">
                                <div class="panel-heading">
                                         <a href="#garage"><h3 class="panel-title">Mes Garages</h3></a>
                                </div>
                                <div class="panel-body recent-property-widget">

                                </div>
                            </div>
                            <div class="panel panel-default sidebar-menu wow fadeInRight animated">
                                <div class="panel-heading">
                                       <a href="#terrain">  <h3 class="panel-title">Mes Terrains</h3></a>
                                </div>
                                <div class="panel-body recent-property-widget">

                                </div>
                            </div>
                            <div class="panel panel-default sidebar-menu wow fadeInRight animated">
                                <div class="panel-heading">
                                   <a href="#locale"> <h3 class="panel-title">Mes Locaux</h3></a>
                                </div>
                                <div class="panel-body recent-property-widget">

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>


 	
	
  <%@ include file="footer2.jsp" %>
