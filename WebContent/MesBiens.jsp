<%@page import="Modele.location"%>
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
 <%@ include file="header_proprietaire.jsp" %>
 <%} %>

<%@page import="java.util.ArrayList"%>
<%@page import="Modele.operation" %>

<%@page import="Modele.maison" %>
<%@page import="Modele.appartement" %>
<%@page import="Modele.depot" %>
<%@page import="Modele.garage" %>
<%@page import="Modele.locale_commercial" %>
<%@page import="Modele.terrain" %>
 <style type="text/css">
        table , th,td{
	border: 1px solid #F4C543;
	padding: 5px;
	text-align: center;
}
        </style>
<style>
<!--
 /* Dropdown Button */
.dropbtn1 {
    background-color: white;
    color: white;
    font-size: 16px;
    height:37px;
    border: 2px solid #F4C543;
    color: #F4C543;
    padding-bottom: 10px;
        padding-top :5px;
        
    
}

/* The container <div> - needed to position the dropdown content */
.dropdown1 {

padding-top:1px;
    position: inherit;
    display: inline-block;
    height:15px;
}

/* Dropdown Content (Hidden by Default) */
.dropdown-content1 {
    display: none;
    position: absolute;
    min-width:500px;
    background-color: #f1f1f1;
   padding:20px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
}

/* Links inside the dropdown */
.dropdown-content1 a {

    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
}

/* Change color of dropdown links on hover */
.dropdown-content1 a:hover {background-color: #ddd}

/* Show the dropdown menu on hover */
.dropdown1:hover .dropdown-content1 {
    display: block;
}

/* Change the background color of the dropdown button when the dropdown content is shown */
.dropdown1:hover .dropbtn1 {
    background-color: #3e8e41;
} 
-->
</style>
<%operation op=new operation(); %>
<% ArrayList<maison> liste_maison=(ArrayList<maison>)session.getAttribute("liste_maison");%> 
<% ArrayList<appartement> liste_appartement=(ArrayList<appartement>)session.getAttribute("liste_appartement");%> 
<% ArrayList<depot> liste_depot=(ArrayList<depot>)session.getAttribute("liste_depot");%> 
<% ArrayList<garage> liste_garage=(ArrayList<garage>)session.getAttribute("liste_garage");%> 
<% ArrayList<locale_commercial> liste_locale_commercial=(ArrayList<locale_commercial>)session.getAttribute("liste_locale_commercial");%> 
<% ArrayList<terrain> liste_terrain=(ArrayList<terrain>)session.getAttribute("liste_terrain");%> 

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
                                    <label for="items_per_page"><b>Biens Par page :</b></label>
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
                                <h2  style="text-align: center;color:#F4C543;"><i ><u> Mes Maisons </u></i>:</h2>
                        
                            <div id="list-type" class="proerty-th-list">
                                <div class="col-md-4 p0">
                                    <div class="box-two proerty-item">
                                     <%if(liste_maison.isEmpty()){ %>
 <h6 style="text-align: center;" ><img width="40px" height="40px" src="vide.png"> Votre liste est vide (0) Maison ajouter </h6>
 <%}else{ %>
  <% int co=1;%>
<%for(int i=0;i<liste_maison.size();i++){
	maison m=liste_maison.get(i);%>
                                        <div class="item-thumb">
                                            <a href="property-1.html" ><img src="<%=m.getImage1()%>"></a>
                                            
                                        </div>
                                        <div class="item-entry overflow">
                                       
      <%String jardin; %>
      <%if(m.getJardin()==true){
    	   jardin="Oui";
      }else{
    	  jardin="Non";

      } %>     
       <%String parking; %>
      <%if(m.getParking()==true){
    	   parking="Oui";
      }else{
    	  parking="Non";

      } %>     
   
      <%int max_colocataire=m.getMax_colocataire(); %>
   
                                            <h5><a href="property-1.html">Numero :<%=co%></a></h5>
                                            
                                            <div class="dot-hr"></div>
                                            
                                            <span class="pull-left"><b>Superficie : </b><%=m.getSuperficie()%></span>
                                            <span class="pull-right"><b>Wilaya : </b>  <%=m.getWilaya()%></span><br>
                                            <span class="pull-left"><b> Adresse : </b><%=m.getAdresse()%> </span>
                                            <span class="pull-right"><b>Locataire : </b><%=m.getMax_colocataire()%> </span><br>
                                             <span class="pull-left"><b> Etat Bien : </b><%=m.getEtat_bien() %> </span>
                                            
                                            <span class="proerty-price pull-right">Prix <%=m.getPrix()%></span>
                                            <div class="property-icon" style="background-color: #F4C543;">
                                                <img width="30px" height="30px" src="chambre.png">(<%=m.getNbr_chambre()%> chambre)|
                                                <img width="30px" height="30px" src="facade.png">(<%=m.getNbr_facade() %> facade)|
                                                 <img width="30px" height="30px" src="jardin.png">(<%=jardin%> jardin)|
                                                <img width="30px" height="30px" src="parking.png">(<%=parking%> parking)|</div><br>

                                                <div class="dealer-action pull-right" style="background-color:white;display: inline-flex;"> 
                                                    <%  if(m.getEtat_bien().equals("non approuve")){%>
   <h4><img  src="alarm.png">En Attente</h4>
     <%}else{ %>
     <%if(op.islouer(m.getId_bien())){ %>
      <form action="ModifierBienServlet" method="get">
    
     <strike><input type="submit" name="Modifier" disabled="disabled"  value="Modifier" style="border: 2px solid #F4C543;"></strike><hr> </form>
      <%}else{ %>
       <form action="ModifierBienServlet" method="get">
      <input type="hidden" name="id_bien" value=<%=m.getId_bien() %> >
         <input type="hidden" name="typebien" value="maison" >
      <input type="submit" name="Modifier"  value="Modifier" style="border: 2px solid #F4C543;"><hr> </form><%} %>
     <%if(op.a_des_location(m.getId_bien())){ %>
      <form action="SupprimerBienServlet">
      <input type="hidden" name="id_bien" value=<%=m.getId_bien() %> >
   
      <strike><input type="submit" name="Supprimer" disabled="disabled"  value="Supprimer" style="border: 2px solid #F4C543;"></strike><hr> </form>
      <%}else{ %>
      <form action="SupprimerBienServlet">
      <input type="hidden" name="id_bien" value=<%=m.getId_bien() %> >
    <%session.setAttribute("typebien","maison");%>
             <input type="hidden" name="typebien" value="maison" >
      <input type="submit" name="Supprimer"  value="Supprimer" style="border: 2px solid #F4C543;"><hr> </form><%} %>
      <%ArrayList<location> listl=op.GetLocations(m.getId_bien()); %>
            <%ArrayList<location> list_non_approuve=op.GetLocations_non_approuve(m.getId_bien()); %>
      
      <br><div class="dot-hr"></div>
     <div  class="dropdown1">
  <button class="dropbtn1">Plannig</button><hr style="margin-top:15px;"> 
  <div class="dropdown-content1">
  <%if(listl.isEmpty()){ %>
	  
	   <p style="text-align: center;" ><img width="40px" height="40px" src="vide.png"> Pas Des Locations Approuver  </p>
	  
  <%}else{%>
     <table >
     <caption style="color:#F4C543;text-align: center; "> Tableau Des Locations Approuver</caption>
   <thead>	
    <tr >
        <th >Debut </th>
        <th >Fin </th>
        <th >Etat </th>
        <th >Locataire Actuel </th>
        <th >Locataire Restant </th>
       
    </tr>
  </thead>
<%for(int x=0;x<listl.size();x++){
	
	location l=listl.get(x);%>
                          <tbody>
    <tr >
   
      <td><%=l.getDate_debut() %></td>
      <td><%=l.getDate_fin()%></td>
      <td><%=l.getEtat_location()%></td>
      <%int nbr_location_dans_ce_date=op.nbr_locataire_exist(l.getId_bien(),l.getDate_debut(),l.getDate_fin());%>
        <%int rest=max_colocataire-nbr_location_dans_ce_date;%>
  
     <%if(rest<0){ %>
      <td><%=nbr_location_dans_ce_date+rest %></td>
       <td><%=rest-rest%></td> 
       <%}else{ %>
        <td><%=nbr_location_dans_ce_date %></td>
       <td><%=rest%></td> 
       <%} %>
      </tr>
<%} %>
  </tbody>          
   </table>
   <%} %>
   <br>
     <%if(list_non_approuve.isEmpty()){ %>
	  
	   <p style="text-align: center;" ><img width="40px" height="40px" src="vide.png"> Pas Des Locations Non Approuver  </p>
	  
  <%}else{%>
     <table >
     <caption style="color:#F4C543;text-align: center; "> Tableau Des Locations Non Approuver</caption>
   <thead>	
    <tr >
        <th >Debut </th>
        <th >Fin </th>
        <th >Etat </th>
        <th >Locataire Actuel </th>
        <th >Locataire Restant </th>
       
    </tr>
  </thead>
<%for(int x=0;x<list_non_approuve.size();x++){
	
	location l=list_non_approuve.get(x);%>
                          <tbody>
    <tr >
   
      <td><%=l.getDate_debut() %></td>
      <td><%=l.getDate_fin()%></td>
      <td><%=l.getEtat_location()%></td>
      <%int nbr_location_dans_ce_date=op.nbr_locataire_exist(l.getId_bien(),l.getDate_debut(),l.getDate_fin());%>
       <%int rest=max_colocataire-nbr_location_dans_ce_date;%>
  
     <%if(rest<0){ %>
      <td><%=nbr_location_dans_ce_date+rest %></td>
       <td><%=rest-rest%></td> 
       <%}else{ %>
        <td><%=nbr_location_dans_ce_date %></td>
       <td><%=rest%></td> 
       <%} %>
      </tr>
<%} %>
  </tbody>          
   </table>
   <%} %>
  </div>
</div> 
     <%}co++; %>
          </div>    	                                                 
                             </div>   	
                             <br><br><br><br>      
             
          <%}} %> 

 </div>  
                  <br>                 
                                   
                                </div>                                              
                            </div>
                        </div>
                        
                        
                        
                        
                          <div id="app" class="section"> 
                              <h2  style="text-align: center;color:#F4C543;"><i ><u> Mes Appartements  </u></i>:</h2>

                            <div id="list-type" class="proerty-th-list">
                                <div class="col-md-4 p0">
                                    <div class="box-two proerty-item">
<%if(liste_appartement.isEmpty()){ %>
<h6 style="text-align: center;" ><img width="40px" height="40px" src="vide.png"> Votre liste est vide (0) appartement ajouter </h6>
            <%}else{ %>
  <% int co1=1;%>
<%for(int j=0;j<liste_appartement.size();j++){
	appartement m=liste_appartement.get(j);%>
                                        <div class="item-thumb">
                                            <a href="property-1.html" ><img src="<%=m.getImage1()%>"></a>
                                            
                                        </div>
                                        <div class="item-entry overflow">
                                       
      
   
      <%int max_colocataire=m.getMax_colocataire(); %>
   
                                            <h5><a href="property-1.html">Numero :<%=co1%></a></h5>
                                            <div class="dot-hr"></div>
                                            
                                            <span class="pull-left"><b>Superficie : </b><%=m.getSuperficie()%></span>
                                            <span class="pull-right"><b>Wilaya : </b>  <%=m.getWilaya()%></span><br>
                                            <span class="pull-left"><b> Adresse : </b><%=m.getAdresse()%> </span>
                                            <span class="pull-right"><b>Locataire : </b><%=m.getMax_colocataire()%> </span><br>
                                             <span class="pull-left"><b> Etat Bien : </b><%=m.getEtat_bien() %> </span>
                                            
                                            <span class="proerty-price pull-right">Prix <%=m.getPrix()%></span>
                                            
                                            <div class="property-icon" style="background-color: #F4C543;">
                                                <img width="30px" height="30px" src="chambre.png">(<%=m.getNbr_chambre()%> chambre)|
                                                <img width="30px" height="30px" src="etage.png">(<%=m.getEtage() %> etage)|
                                                </div><br>
                                                <div class="dealer-action pull-right" style="background-color:white;display: inline-flex;"> 
                                                    <%  if(m.getEtat_bien().equals("non approuve")){%>
   <h4><img  src="alarm.png">En Attente</h4>
     <%}else{ %>
     <%if(op.islouer(m.getId_bien())){ %>
      <form action="ModifierBienServlet" method="get">
      
     <strike><input type="submit" name="Modifier" disabled="disabled"  value="Modifier" style="border: 2px solid #F4C543;"></strike><hr> </form>
      <%}else{ %>
       <form action="ModifierBienServlet" method="get">
      <input type="hidden" name="id_bien" value=<%=m.getId_bien() %> >
         <input type="hidden" name="typebien" value="appartement" >
      <input type="submit" name="Modifier"  value="Modifier" style="border: 2px solid #F4C543;"><hr> </form><%} %>
     <%if(op.a_des_location(m.getId_bien())){ %>
      <form action="SupprimerBienServlet">
      <input type="hidden" name="id_bien" value=<%=m.getId_bien() %> >
   
      <strike><input type="submit" name="Supprimer" disabled="disabled"  value="Supprimer" style="border: 2px solid #F4C543;"></strike><hr> </form>
      <%}else{ %>
      <form action="SupprimerBienServlet">
      <input type="hidden" name="id_bien" value=<%=m.getId_bien() %> >
    <%session.setAttribute("typebien","appartement");%>
             <input type="hidden" name="typebien" value="appartement" >
      <input type="submit" name="Supprimer"  value="Supprimer" style="border: 2px solid #F4C543;"><hr> </form><%} %>
           <%ArrayList<location> listl=op.GetLocations(m.getId_bien()); %>
                       <%ArrayList<location> list_non_approuve=op.GetLocations_non_approuve(m.getId_bien()); %>
            <br><div class="dot-hr"></div>
     <div  class="dropdown1">
  <button class="dropbtn1">Plannig</button><hr> 
  <div class="dropdown-content1">
  <%if(listl.isEmpty()){ %>
	  
	   <p style="text-align: center;" ><img width="40px" height="40px" src="vide.png"> Pas Des Locations Approuver  </p>
	  
  <%}else{%>
     <table >
     <caption style="color:#F4C543;text-align: center; "> Tableau Des Locations Approuver</caption>
   <thead>	
    <tr >
        <th >Debut </th>
        <th >Fin </th>
        <th >Etat </th>
        <th >Locataire Actuel </th>
        <th >Locataire Restant </th>
       
    </tr>
  </thead>
<%for(int XX=0;XX<listl.size();XX++){
	
	location l=listl.get(XX);%>
                          <tbody>
    <tr >
   
      <td><%=l.getDate_debut() %></td>
      <td><%=l.getDate_fin()%></td>
      <td><%=l.getEtat_location()%></td>
      <%int nbr_location_dans_ce_date=op.nbr_locataire_exist(l.getId_bien(),l.getDate_debut(),l.getDate_fin());%>
        <%int rest=max_colocataire-nbr_location_dans_ce_date;%>
  
     <%if(rest<0){ %>
      <td><%=nbr_location_dans_ce_date+rest %></td>
       <td><%=rest-rest%></td> 
       <%}else{ %>
        <td><%=nbr_location_dans_ce_date %></td>
       <td><%=rest%></td> 
       <%} %>
      </tr>
<%} %>
  </tbody>          
   </table>
   <%} %>
    <br>
     <%if(list_non_approuve.isEmpty()){ %>
	  
	   <p style="text-align: center;" ><img width="40px" height="40px" src="vide.png"> Pas Des Locations Non Approuver  </p>
	  
  <%}else{%>
     <table >
     <caption style="color:#F4C543;text-align: center; "> Tableau Des Locations Non Approuver</caption>
   <thead>	
    <tr >
        <th >Debut </th>
        <th >Fin </th>
        <th >Etat </th>
        <th >Locataire Actuel </th>
        <th >Locataire Restant </th>
       
    </tr>
  </thead>
<%for(int x=0;x<list_non_approuve.size();x++){
	
	location l=list_non_approuve.get(x);%>
                          <tbody>
    <tr >
   
      <td><%=l.getDate_debut() %></td>
      <td><%=l.getDate_fin()%></td>
      <td><%=l.getEtat_location()%></td>
      <%int nbr_location_dans_ce_date=op.nbr_locataire_exist(l.getId_bien(),l.getDate_debut(),l.getDate_fin());%>
        <%int rest=max_colocataire-nbr_location_dans_ce_date;%>
  
     <%if(rest<0){ %>
      <td><%=nbr_location_dans_ce_date+rest %></td>
       <td><%=rest-rest%></td> 
       <%}else{ %>
        <td><%=nbr_location_dans_ce_date %></td>
       <td><%=rest%></td> 
       <%} %>
      </tr>
<%} %>
  </tbody>          
   </table>
   <%} %>
  </div>
</div> 
     <%}co1++; %>
                                            <div class="dot-hr"></div>
          </div>    	                                                 
                             </div>   	
                             <br><br><br><br>      
             
          <%}} %> 

 </div>  
                  <br>                 
                                   
                                </div>                                              
                            </div>
                        </div>
                        
                        
                        
                          <div id="depot" class="section"> 
                                            <h2  style="text-align: center;color:#F4C543;"><i ><u> Mes Depots </u></i>:</h2>
                        
                            <div id="list-type" class="proerty-th-list">
                                <div class="col-md-4 p0">
                                    <div class="box-two proerty-item">
<%if(liste_depot.isEmpty()){ %>
 <h6 style="text-align: center;" ><img width="40px" height="40px" src="vide.png"> Votre liste est vide (0) depot ajouter </h6>
           
 <%}else{ %>
   <%int co2=1;%>
<%for(int k=0;k<liste_depot.size();k++){
	depot m=liste_depot.get(k);%>
                                        <div class="item-thumb">
                                            <a href="property-1.html" ><img src="<%=m.getImage1()%>"></a>
                                            
                                        </div>
                                        <div class="item-entry overflow">
                                       
      
   
      <%int max_colocataire=m.getMax_colocataire(); %>
   
                                            <h5><a href="property-1.html">Numero :<%=co2%></a></h5>
                                            <div class="dot-hr"></div>
                                            
                                            <span class="pull-left"><b>Superficie : </b><%=m.getSuperficie()%></span>
                                            <span class="pull-right"><b>Wilaya : </b>  <%=m.getWilaya()%></span><br>
                                            <span class="pull-left"><b> Adresse : </b><%=m.getAdresse()%> </span>
                                            <span class="pull-right"><b>Locataire : </b><%=m.getMax_colocataire()%> </span><br>
                                             <span class="pull-left"><b> Etat Bien : </b><%=m.getEtat_bien() %> </span>
                                            
                                            <span class="proerty-price pull-right">Prix <%=m.getPrix()%></span>
                                            <div class="property-icon" style="background-color: #F4C543;">
                                                <img width="30px" height="30px" src="box.png">(<%=m.getCapacite_stockage()%>box)|
                                                <img width="20px" height="20px" src="frigo.png">(<%=m.getType() %>)|
                                                </div><br>
                                                <div class="dealer-action pull-right" style="background-color:white;display: inline-flex;"> 
                                                    <%  if(m.getEtat_bien().equals("non approuve")){%>
   <h4><img  src="alarm.png">En Attente</h4>
     <%}else{ %>
     <%if(op.islouer(m.getId_bien())){ %>
      <form action="ModifierBienServlet" method="get">
      
     <strike><input type="submit" name="Modifier" disabled="disabled"  value="Modifier" style="border: 2px solid #F4C543;"></strike><hr> </form>
      <%}else{ %>
       <form action="ModifierBienServlet" method="get">
      <input type="hidden" name="id_bien" value=<%=m.getId_bien() %> >
         <input type="hidden" name="typebien" value="depot" >
      <input type="submit" name="Modifier"  value="Modifier" style="border: 2px solid #F4C543;"><hr> </form><%} %>
     <%if(op.a_des_location(m.getId_bien())){ %>
      <form action="SupprimerBienServlet">
      <input type="hidden" name="id_bien" value=<%=m.getId_bien() %> >
   
      <strike><input type="submit" name="Supprimer" disabled="disabled"  value="Supprimer" style="border: 2px solid #F4C543;"></strike><hr> </form>
      <%}else{ %>
      <form action="SupprimerBienServlet">
      <input type="hidden" name="id_bien" value=<%=m.getId_bien() %> >
    <%session.setAttribute("typebien","depot");%>
             <input type="hidden" name="typebien" value="depot" >
      <input type="submit" name="Supprimer"  value="Supprimer" style="border: 2px solid #F4C543;"><hr> </form><%} %>
           <%ArrayList<location> listl=op.GetLocations(m.getId_bien()); %>
                       <%ArrayList<location> list_non_approuve=op.GetLocations_non_approuve(m.getId_bien()); %>
            <br><div class="dot-hr"></div>
     <div  class="dropdown1">
  <button class="dropbtn1">Plannig</button><hr> 
  <div class="dropdown-content1">
  <%if(listl.isEmpty()){ %>
	  
	   <p style="text-align: center;" ><img width="40px" height="40px" src="vide.png"> Pas Des Locations Approuver  </p>
	  
  <%}else{%>
     <table >
     <caption style="color:#F4C543;text-align: center; "> Tableau Des Locations Non Approuver</caption>
   <thead>	
    <tr >
        <th >Debut </th>
        <th >Fin </th>
        <th >Etat </th>
        <th >Locataire Actuel </th>
        <th >Locataire Restant </th>
       
    </tr>
  </thead>
<%for(int XXX=0;XXX<listl.size();XXX++){
	
	location l=listl.get(XXX);%>
                          <tbody>
    <tr >
   
      <td><%=l.getDate_debut() %></td>
      <td><%=l.getDate_fin()%></td>
      <td><%=l.getEtat_location()%></td>
      <%int nbr_location_dans_ce_date=op.nbr_locataire_exist(l.getId_bien(),l.getDate_debut(),l.getDate_fin());%>
        <%int rest=max_colocataire-nbr_location_dans_ce_date;%>
  
     <%if(rest<0){ %>
      <td><%=nbr_location_dans_ce_date+rest %></td>
       <td><%=rest-rest%></td> 
       <%}else{ %>
        <td><%=nbr_location_dans_ce_date %></td>
       <td><%=rest%></td> 
       <%} %> 
      </tr>
<%} %>
  </tbody>          
   </table>
   <%} %>
    <br>
     <%if(list_non_approuve.isEmpty()){ %>
	  
	   <p style="text-align: center;" ><img width="40px" height="40px" src="vide.png"> Pas Des Locations Non Approuver  </p>
	  
  <%}else{%>
     <table >
     <caption style="color:#F4C543;text-align: center; "> Tableau Des Locations Approuver</caption>
   <thead>	
    <tr >
        <th >Debut </th>
        <th >Fin </th>
        <th >Etat </th>
        <th >Locataire Actuel </th>
        <th >Locataire Restant </th>
       
    </tr>
  </thead>
<%for(int x=0;x<list_non_approuve.size();x++){
	
	location l=list_non_approuve.get(x);%>
                          <tbody>
    <tr >
   
      <td><%=l.getDate_debut() %></td>
      <td><%=l.getDate_fin()%></td>
      <td><%=l.getEtat_location()%></td>
      <%int nbr_location_dans_ce_date=op.nbr_locataire_exist(l.getId_bien(),l.getDate_debut(),l.getDate_fin());%>
       <%int rest=max_colocataire-nbr_location_dans_ce_date;%>
  
     <%if(rest<0){ %>
      <td><%=nbr_location_dans_ce_date+rest %></td>
       <td><%=rest-rest%></td> 
       <%}else{ %>
        <td><%=nbr_location_dans_ce_date %></td>
       <td><%=rest%></td> 
       <%} %>
      </tr>
<%} %>
  </tbody>          
   </table>
   <%} %>
  </div>
</div> 
     <%}co2++; %>
                                            <div class="dot-hr"></div>
          </div>    	                                                 
                             </div>   	
                             <br><br><br><br>      
             
          <%}} %> 

 </div>  
                  <br>                 
                                   
                                </div>                                              
                            </div>
                        </div>
                        
                        
                               
                        
                          <div id="garage" class="section"> 
                                     <h2  style="text-align: center;color:#F4C543;"><i ><u> Mes Garages </u></i>:</h2>
                        
                            <div id="list-type" class="proerty-th-list">
                                <div class="col-md-4 p0">
                                    <div class="box-two proerty-item">
<%if(liste_garage.isEmpty()){ %> 
<h6 style="text-align: center;" ><img width="40px" height="40px" src="vide.png"> Votre liste est vide (0) garage ajouter </h6>
 
 <%}else{ %>
  <% int co3=1;%>
<%for(int p=0;p<liste_garage.size();p++){
	garage m=liste_garage.get(p);%>
                                        <div class="item-thumb">
                                            <a href="property-1.html" ><img src="<%=m.getImage1()%>"></a>
                                            
                                        </div>
                                        <div class="item-entry overflow">
                                       
      
   
      <%int max_colocataire=m.getMax_colocataire(); %>
   
                                            <h5><a href="property-1.html">Numero :<%=co3%></a></h5>
                                            <div class="dot-hr"></div>
                                            
                                            <span class="pull-left"><b>Superficie : </b><%=m.getSuperficie()%></span>
                                            <span class="pull-right"><b>Wilaya : </b>  <%=m.getWilaya()%></span><br>
                                            <span class="pull-left"><b> Adresse : </b><%=m.getAdresse()%> </span>
                                            <span class="pull-right"><b>Locataire : </b><%=m.getMax_colocataire()%> </span><br>
                                             <span class="pull-left"><b> Etat Bien : </b><%=m.getEtat_bien() %> </span>
                                            
                                            <span class="proerty-price pull-right">Prix <%=m.getPrix()%></span>
                                            <div class="property-icon" style="background-color: #F4C543;">
                                                <img width="15px" height="15px" src="car.png">(<%=m.getCapacite_vehicule()%> voiture)|
                                                </div><br>
                                                <div class="dealer-action pull-right" style="background-color:white;display: inline-flex;"> 
                                                    <%  if(m.getEtat_bien().equals("non approuve")){%>
   <h4><img  src="alarm.png">En Attente</h4>
     <%}else{ %>
      <%if(op.islouer(m.getId_bien())){ %>
      <form action="ModifierBienServlet" method="get">
      
     <strike><input type="submit" name="Modifier" disabled="disabled"  value="Modifier" style="border: 2px solid #F4C543;"></strike><hr> </form>
      <%}else{ %>
       <form action="ModifierBienServlet" method="get">
      <input type="hidden" name="id_bien" value=<%=m.getId_bien() %> >
         <input type="hidden" name="typebien" value="garage" >
      <input type="submit" name="Modifier"  value="Modifier" style="border: 2px solid #F4C543;"><hr> </form><%} %>
     <%if(op.a_des_location(m.getId_bien())){ %>
      <form action="SupprimerBienServlet">
      <input type="hidden" name="id_bien" value=<%=m.getId_bien() %> >
   
      <strike><input type="submit" name="Supprimer" disabled="disabled"  value="Supprimer" style="border: 2px solid #F4C543;"></strike><hr> </form>
      <%}else{ %>
      <form action="SupprimerBienServlet">
      <input type="hidden" name="id_bien" value=<%=m.getId_bien() %> >
    <%session.setAttribute("typebien","garage");%>
             <input type="hidden" name="typebien" value="garage" >
      <input type="submit" name="Supprimer"  value="Supprimer" style="border: 2px solid #F4C543;"><hr> </form><%} %>
           <%ArrayList<location> listl=op.GetLocations(m.getId_bien()); %>
                       <%ArrayList<location> list_non_approuve=op.GetLocations_non_approuve(m.getId_bien()); %>
            <br><div class="dot-hr"></div>
     <div  class="dropdown1">
  <button class="dropbtn1">Plannig</button><hr> 
  <div class="dropdown-content1">
  <%if(listl.isEmpty()){ %>
	  
	   <p style="text-align: center;" ><img width="40px" height="40px" src="vide.png"> Pas Des Locations Approuver  </p>
	  
  <%}else{%>
     <table >
     <caption style="color:#F4C543;text-align: center; "> Tableau Des Locations Approuver</caption>
   <thead>	
    <tr >
        <th >Debut </th>
        <th >Fin </th>
        <th >Etat </th>
        <th >Locataire Actuel </th>
        <th >Locataire Restant </th>
       
    </tr>
  </thead>
<%for(int XXXX=0;XXXX<listl.size();XXXX++){
	
	location l=listl.get(XXXX);%>
                          <tbody>
    <tr >
   
      <td><%=l.getDate_debut() %></td>
      <td><%=l.getDate_fin()%></td>
      <td><%=l.getEtat_location()%></td>
      <%int nbr_location_dans_ce_date=op.nbr_locataire_exist(l.getId_bien(),l.getDate_debut(),l.getDate_fin());%>
        <%int rest=max_colocataire-nbr_location_dans_ce_date;%>
  
     <%if(rest<0){ %>
      <td><%=nbr_location_dans_ce_date+rest %></td>
       <td><%=rest-rest%></td> 
       <%}else{ %>
        <td><%=nbr_location_dans_ce_date %></td>
       <td><%=rest%></td> 
       <%} %>
      </tr>
<%} %>
  </tbody>          
   </table>
   <%} %>
    <br>
     <%if(list_non_approuve.isEmpty()){ %>
	  
	   <p style="text-align: center;" ><img width="40px" height="40px" src="vide.png"> Pas Des Locations Non Approuver  </p>
	  
  <%}else{%>
     <table >
     <caption style="color:#F4C543;text-align: center; "> Tableau Des Locations Non Approuver</caption>
   <thead>	
    <tr >
        <th >Debut </th>
        <th >Fin </th>
        <th >Etat </th>
        <th >Locataire Actuel </th>
        <th >Locataire Restant </th>
       
    </tr>
  </thead>
<%for(int x=0;x<list_non_approuve.size();x++){
	
	location l=list_non_approuve.get(x);%>
                          <tbody>
    <tr >
   
      <td><%=l.getDate_debut() %></td>
      <td><%=l.getDate_fin()%></td>
      <td><%=l.getEtat_location()%></td>
      <%int nbr_location_dans_ce_date=op.nbr_locataire_exist(l.getId_bien(),l.getDate_debut(),l.getDate_fin());%>
       <%int rest=max_colocataire-nbr_location_dans_ce_date;%>
  
     <%if(rest<0){ %>
      <td><%=nbr_location_dans_ce_date+rest %></td>
       <td><%=rest-rest%></td> 
       <%}else{ %>
        <td><%=nbr_location_dans_ce_date %></td>
       <td><%=rest%></td> 
       <%} %>
      </tr>
<%} %>
  </tbody>          
   </table>
   <%} %>
  </div>
</div> 
     <%}co3++; %>
                                            <div class="dot-hr"></div>
          </div>    	                                                 
                             </div>   	
                             <br><br><br><br>      
             
          <%}} %> 

 </div>  
                  <br>                 
                                   
                                </div>                                              
                            </div>
                        </div>
                        
                                 <div id="locale" class="section"> 
      <h2  style="text-align: center;color:#F4C543;"><i ><u> Mes Locaux commerciaux </u></i>:</h2>                        
                            <div id="list-type" class="proerty-th-list">
                                <div class="col-md-4 p0">
                                    <div class="box-two proerty-item">
<%if(liste_locale_commercial.isEmpty()){ %> 
<h6 style="text-align: center;" ><img width="40px" height="40px" src="vide.png"> Votre liste est vide (0) locale ajouter </h6>
 
 <%}else{ %>
  <% int co4=1;%>
<%for(int s=0;s<liste_locale_commercial.size();s++){
    	locale_commercial m=liste_locale_commercial.get(s);%>
                                        <div class="item-thumb">
                                            <a href="property-1.html" ><img src="<%=m.getImage1()%>"></a>
                                            
                                        </div>
                                        <div class="item-entry overflow">
                                       
      
   
      <%int max_colocataire=m.getMax_colocataire(); %>
   
                                           <h5><a href="property-1.html">Numero :<%=co4%></a></h5>
                                            <div class="dot-hr"></div>
                                            
                                            <span class="pull-left"><b>Superficie : </b><%=m.getSuperficie()%></span>
                                            <span class="pull-right"><b>Wilaya : </b>  <%=m.getWilaya()%></span><br>
                                            <span class="pull-left"><b> Adresse : </b><%=m.getAdresse()%> </span>
                                            <span class="pull-right"><b>Locataire : </b><%=m.getMax_colocataire()%> </span><br>
                                             <span class="pull-left"><b> Etat Bien : </b><%=m.getEtat_bien() %> </span>
                                            
                                            <span class="proerty-price pull-right">Prix <%=m.getPrix()%></span>
                                            <div class="property-icon" style="background-color: #F4C543;">
                                                <img width="30px" height="30px" src="dis.png">(<%=m.getDistance_center()%> m2)|
                                                <img width="30px" height="30px" src="doct.png">(<%=m.getType_local()%>)|
                                              
                                                </div><br>
                                                <div class="dealer-action pull-right" style="background-color:white;display: inline-flex;"> 
                                                    <%  if(m.getEtat_bien().equals("non approuve")){%>
      <h4><img  src="alarm.png">En Attente</h4>

     <%}else{ %>
      <%if(op.islouer(m.getId_bien())){ %>
      <form action="ModifierBienServlet" method="get">
     
     <strike><input type="submit" name="Modifier" disabled="disabled"  value="Modifier" style="border: 2px solid #F4C543;"></strike><hr> </form>
      <%}else{ %>
       <form action="ModifierBienServlet" method="get">
      <input type="hidden" name="id_bien" value=<%=m.getId_bien() %> >
         <input type="hidden" name="typebien" value="locale_commercial" >
      <input type="submit" name="Modifier"  value="Modifier" style="border: 2px solid #F4C543;"><hr> </form><%} %>
     <%if(op.a_des_location(m.getId_bien())){ %>
      <form action="SupprimerBienServlet">
     
      <strike><input type="submit" name="Supprimer" disabled="disabled"  value="Supprimer" style="border: 2px solid #F4C543;"></strike><hr> </form>
      <%}else{ %>
      <form action="SupprimerBienServlet">
      <input type="hidden" name="id_bien" value=<%=m.getId_bien() %> >
    <%session.setAttribute("typebien","locale_commercial");%>
             <input type="hidden" name="typebien" value="locale_commercial" >
      <input type="submit" name="Supprimer"  value="Supprimer" style="border: 2px solid #F4C543;"><hr> </form><%} %>
            <%ArrayList<location> listl=op.GetLocations(m.getId_bien()); %>
                        <%ArrayList<location> list_non_approuve=op.GetLocations_non_approuve(m.getId_bien()); %>
             <br><div class="dot-hr"></div>
     <div  class="dropdown1">
  <button class="dropbtn1">Plannig</button><hr> 
  <div class="dropdown-content1">
  <%if(listl.isEmpty()){ %>
	  
	   <p style="text-align: center;" ><img width="40px" height="40px" src="vide.png"> Pas Des Locations Approuver  </p>
	  
  <%}else{%>
     <table >
     <caption style="color:#F4C543;text-align: center; "> Tableau Des Locations Approuver</caption>
   <thead>	
    <tr >
        <th >Debut </th>
        <th >Fin </th>
        <th >Etat </th>
        <th >Locataire Actuel </th>
        <th >Locataire Restant </th>
       
    </tr>
  </thead>
<%for(int XXXXX=0;XXXXX<listl.size();XXXXX++){
	
	location l=listl.get(XXXXX);%>
                          <tbody>
    <tr >
   
      <td><%=l.getDate_debut() %></td>
      <td><%=l.getDate_fin()%></td>
      <td><%=l.getEtat_location()%></td>
      <%int nbr_location_dans_ce_date=op.nbr_locataire_exist(l.getId_bien(),l.getDate_debut(),l.getDate_fin());%>
        <%int rest=max_colocataire-nbr_location_dans_ce_date;%>
  
     <%if(rest<0){ %>
      <td><%=nbr_location_dans_ce_date+rest %></td>
       <td><%=rest-rest%></td> 
       <%}else{ %>
        <td><%=nbr_location_dans_ce_date %></td>
       <td><%=rest%></td> 
       <%} %>
      </tr>
<%} %>
  </tbody>          
   </table>
   <%} %>
    <br>
     <%if(list_non_approuve.isEmpty()){ %>
	  
	   <p style="text-align: center;" ><img width="40px" height="40px" src="vide.png"> Pas Des Locations Non Approuver  </p>
	  
  <%}else{%>
     <table >
     <caption style="color:#F4C543;text-align: center; "> Tableau Des Locations Non Approuver</caption>
   <thead>	
    <tr >
        <th >Debut </th>
        <th >Fin </th>
        <th >Etat </th>
        <th >Locataire Actuel </th>
        <th >Locataire Restant </th>
       
    </tr>
  </thead>
<%for(int x=0;x<list_non_approuve.size();x++){
	
	location l=list_non_approuve.get(x);%>
                          <tbody>
    <tr >
   
      <td><%=l.getDate_debut() %></td>
      <td><%=l.getDate_fin()%></td>
      <td><%=l.getEtat_location()%></td>
      <%int nbr_location_dans_ce_date=op.nbr_locataire_exist(l.getId_bien(),l.getDate_debut(),l.getDate_fin());%>
       <%int rest=max_colocataire-nbr_location_dans_ce_date;%>
  
     <%if(rest<0){ %>
      <td><%=nbr_location_dans_ce_date+rest %></td>
       <td><%=rest-rest%></td> 
       <%}else{ %>
        <td><%=nbr_location_dans_ce_date %></td>
       <td><%=rest%></td> 
       <%} %>
      </tr>
<%} %>
  </tbody>          
   </table>
   <%} %>
  </div>
</div> 
     <%}co4++; %>
                                            <div class="dot-hr"></div>
          </div>    	                                                 
                             </div>   	
                             <br><br><br><br>      
             
          <%}} %> 

 </div>  
                  <br>                 
                                   
                                </div>                                              
                            </div>
                        </div>
                         
                         
                         
                          <div id="terrain" class="section"> 
                                         <h2  style="text-align: center;color:#F4C543;"><i ><u> Mes Terrains </u></i>:</h2>

                        
                            <div id="list-type" class="proerty-th-list">
                                <div class="col-md-4 p0">
                                    <div class="box-two proerty-item">
<%if(liste_terrain.isEmpty()){ %>
<h6 style="text-align: center;" ><img width="40px" height="40px" src="vide.png"> Votre liste est vide (0) terrain ajouter </h6>
 
 <%}else{ %>
 <% int co5=1;%>
<%for(int x=0;x<liste_terrain.size();x++){
    	terrain m=liste_terrain.get(x);%>
                                        <div class="item-thumb">
                                            <a href="property-1.html" ><img src="<%=m.getImage1()%>"></a>
                                            
                                        </div>
                                        <div class="item-entry overflow">
              
      <%int max_colocataire=m.getMax_colocataire(); %>
   
                                           <h5><a href="property-1.html">Numero :<%=co5%></a></h5>
                                            <div class="dot-hr"></div>
                                            
                                            <span class="pull-left"><b>Superficie : </b><%=m.getSuperficie()%></span>
                                            <span class="pull-right"><b>Wilaya : </b>  <%=m.getWilaya()%></span><br>
                                            <span class="pull-left"><b> Adresse : </b><%=m.getAdresse()%> </span>
                                            <span class="pull-right"><b>Locataire : </b><%=m.getMax_colocataire()%> </span><br>
                                             <span class="pull-left"><b> Etat Bien : </b><%=m.getEtat_bien() %> </span>
                                            
                                            <span class="proerty-price pull-right">Prix <%=m.getPrix()%></span>
                                            <div class="property-icon" style="background-color: #F4C543;">
                                                <img width="30px" height="30px" src="climo.png">(<%=m.getCaracteristique()%>)|
                                              
                                                </div><br>
                                                <div class="dealer-action pull-right" style="background-color:white;display: inline-flex;"> 
                                                    <%  if(m.getEtat_bien().equals("non approuve")){%>
   <h4><img  src="alarm.png">En Attente</h4>
     <%}else{ %>
      <%if(op.islouer(m.getId_bien())){ %>
      <form action="ModifierBienServlet" method="get">
      
     <strike><input type="submit" name="Modifier" disabled="disabled"  value="Modifier" style="border: 2px solid #F4C543;"></strike><hr> </form>
      <%}else{ %>
       <form action="ModifierBienServlet" method="get">
      <input type="hidden" name="id_bien" value=<%=m.getId_bien() %> >
         <input type="hidden" name="typebien" value="terrain" >
      <input type="submit" name="Modifier"  value="Modifier" style="border: 2px solid #F4C543;"><hr> </form><%} %>
     <%if(op.a_des_location(m.getId_bien())){ %>
      <form action="SupprimerBienServlet">
      
      <strike><input type="submit" name="Supprimer" disabled="disabled"  value="Supprimer" style="border: 2px solid #F4C543;"></strike><hr> </form>
      <%}else{ %>
      <form action="SupprimerBienServlet">
      <input type="hidden" name="id_bien" value=<%=m.getId_bien() %> >
    <%session.setAttribute("typebien","terrain");%>
             <input type="hidden" name="typebien" value="terrain" >
      <input type="submit" name="Supprimer"  value="Supprimer" style="border: 2px solid #F4C543;"><hr> </form><%} %>
            <%ArrayList<location> listl=op.GetLocations(m.getId_bien()); %>
                        <%ArrayList<location> list_non_approuve=op.GetLocations_non_approuve(m.getId_bien()); %>
             <br><div class="dot-hr"></div>
     <div  class="dropdown1">
  <button class="dropbtn1">Plannig</button><hr> 
  <div class="dropdown-content1">
    <%if(listl.isEmpty()){ %>
	  
	   <p style="text-align: center;" ><img width="40px" height="40px" src="vide.png"> Pas Des Locations Approuver  </p>
	  
  <%}else{%>
     <table >
     <caption style="color:#F4C543;text-align: center; "> Tableau Des Locations Approuver</caption>
   <thead>	
    <tr >
        <th >Debut </th>
        <th >Fin </th>
        <th >Etat </th>
        <th >Locataire Actuel </th>
        <th >Locataire Restant </th>
       
    </tr>
  </thead>
<%for(int XXXXXX=0;XXXXXX<listl.size();XXXXXX++){
	
	location l=listl.get(XXXXXX);%>
                          <tbody>
    <tr >
   
      <td><%=l.getDate_debut() %></td>
      <td><%=l.getDate_fin()%></td>
      <td><%=l.getEtat_location()%></td>
      <%int nbr_location_dans_ce_date=op.nbr_locataire_exist(l.getId_bien(),l.getDate_debut(),l.getDate_fin());%>
       <%int rest=max_colocataire-nbr_location_dans_ce_date;%>
  
     <%if(rest<0){ %>
      <td><%=nbr_location_dans_ce_date+rest %></td>
       <td><%=rest-rest%></td> 
       <%}else{ %>
        <td><%=nbr_location_dans_ce_date %></td>
       <td><%=rest%></td> 
       <%} %>
      </tr>
<%} %>
  </tbody>          
   </table>
   <%} %>
    <br>
     <%if(list_non_approuve.isEmpty()){ %>
	  
	   <p style="text-align: center;" ><img width="40px" height="40px" src="vide.png"> Pas Des Locations Non Approuver  </p>
	  
  <%}else{%>
     <table >
     <caption style="color:#F4C543;text-align: center; "> Tableau Des Locations Non  Approuver</caption>
   <thead>	
    <tr >
        <th >Debut </th>
        <th >Fin </th>
        <th >Etat </th>
        <th >Locataire Actuel </th>
        <th >Locataire Restant </th>
       
    </tr>
  </thead>
<%for(int x8=0;x8<list_non_approuve.size();x8++){
	
	location l=list_non_approuve.get(x8);%>
                          <tbody>
    <tr >
   
      <td><%=l.getDate_debut() %></td>
      <td><%=l.getDate_fin()%></td>
      <td><%=l.getEtat_location()%></td>
      <%int nbr_location_dans_ce_date=op.nbr_locataire_exist(l.getId_bien(),l.getDate_debut(),l.getDate_fin());%>
       <%int rest=max_colocataire-nbr_location_dans_ce_date;%>
  
     <%if(rest<0){ %>
      <td><%=nbr_location_dans_ce_date+rest %></td>
       <td><%=rest-rest%></td> 
       <%}else{ %>
        <td><%=nbr_location_dans_ce_date %></td>
       <td><%=rest%></td> 
       <%} %>
      </tr>
<%} %>
  </tbody>          
   </table>
   <%} %>
  </div>
</div> 
     <%}co5++; %>
                                            <div class="dot-hr"></div>
          </div>    	                                                 
                             </div>   	
                             <br><br><br><br>      
             
          <%}} %> 

 </div>  
                  <br>                 
                                   
                                </div>                                              
                            </div>
                        </div>
                         
                         
                         
                         
                         
         
                         
                         
                         
                         
                         
                         
                        
                        
                              
                        <div class="section"> 
                            <div class="pull-right">
                                <div class="pagination">
                                    <ul>
                                        <li><a href="#">Prev</a></li>
                                        <li><a href="#">1</a></li>
                                        <li><a href="#">2</a></li>
                                        <li><a href="#">3</a></li>
                                        <li><a href="#">4</a></li>
                                        <li><a href="#">Next</a></li>
                                    </ul>
                                </div>
                            </div>                
                        </div>

                    </div>       

                    <div class="col-md-3 p0 padding-top-40" >
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
