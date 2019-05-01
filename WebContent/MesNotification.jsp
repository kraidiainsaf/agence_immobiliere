<%
	       response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	       response.addHeader("Cache-Control", "post-check=0, pre-check=0");
	       response.setHeader("Pragma", "no-cache");
	       response.setDateHeader("Expires", 0);
    
if(session.getAttribute("id_personne")==null){
	RequestDispatcher DL =request.getRequestDispatcher("authentifg");
DL.forward(request,response);}
	%>  
<%@page import="java.util.ArrayList"%>
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
 
 <style type="text/css">
        table , th,td{
	border: 1px solid #F4C543;
	margin-left:250px;;
	padding: 5px;
	text-align: center;
}
        </style>
        <%@page import="Modele.notification" %>
  
<%@page import="Modele.operation" %>
<%@page import="Modele.personne" %>
<%@page import="Modele.cntrlNotif" %>
<%@page import="Modele.location" %>
<%@page import="Modele.cntrlAuthentif" %>


<div class="home-lager-shearch" style="padding-top: 25px; margin-top: -10px; padding-bottom: 60px; background-color: rgb(252, 252, 252);"  style="text-align: center;">
            <div class="container"  style="text-align: center;">
         <!-- cadre de recherche  -->      
          <div class="col-md-12 large-search" style="background-color: #F4C543;padding: 3px;"  style="text-align: center;"> 
               
                    <div class="search-form wow pulse" style="background-color:#EEF0F0;text-align: center;color: black;">

 <img width="100px" height="100px" src="notif1.png">

<h2>Notifications : </h2>
<br>
 
<%ArrayList<notification> list=null;%>
<%list=(ArrayList<notification>)session.getAttribute("liste");%>
<%if(list.isEmpty()){%>
<h3>aucune  notification disponible ; </h3>

	
<%}else{ %>
<table >
  <thead>	
    <tr>
      <th scope="col">Emetteur :</th>
      <th scope="col">Contenue :</th>
       <th scope="col">Supprimer:</th>
      

    </tr>
  </thead>
 
<%for(int i=0;i<list.size();i++){
	notification m=list.get(i);
%>
  <tbody>
    <tr>
      <td><%=m.getEmetteur() %></td>
      <td><%=m.getContenue_notif()%></td>
      <td>
      <form action="SuppNotif">
      <input type="hidden" value="<%=m.getId_notif() %>" name="id_notif">
      <input type="submit" value="Supprimer"  style="border: 1px solid red ;background-color: #ff8080;" width="200px" >
      </form>
      
      
      </td>
      
     </tr>
<%} %>
  </tbody>
</table>
<%} %>
    </div></div>
            </div>
        </div>
         <%@ include file="footer2.jsp" %>