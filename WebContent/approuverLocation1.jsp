<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/mytab.css">
<title>liste des locations en attentes</title>
<style>
#tab{
width:100%;
padding:50px;}
</style>
</head>
<body>
<%@ include file="header.jsp" %>
<%@ page import="Modele.facture"%>
<%@ page import="Modele.location"%>
<%@ page import="Modele.cntrlBien"%>
<%@ page import=" java.util.ArrayList"%>
<%@ page import="Modele.cntrlCompte"%>
<div class="main-grid">
			<div class="agile-grids">
<% location loc=new location();cntrlCompte cp=new cntrlCompte();
facture f=new facture();cntrlBien b=new cntrlBien();
ArrayList<location> list=loc.getLocationApprouver();
if(list.isEmpty()){
%><h2 align="center">aucune demande de location disponible</h2><%}else{ %>
<h1 align="center"> <img height="45" width="45" src="pic\enattente.png"> locations en attentes</h1>
</br>
<div class="agile-tables">
					<div class="w3l-table-info">
					    <table id="tab">
<tr>
<th  align="center"><img height="25" width="25" src="pic\name.png"> locataire</th>
<th  align="center"><img alt="" src="pic/house.png" width="20px" height="20px" align="top" >Type de bien</th>
<th  align="center"><img height="25" width="25" src="pic\debut.png"> Date de début</th>
<th  align="center"> <img height="25" width="25" src="pic\fin.png"> Date de fin</th>

<th  align="center"> <img height="25" width="25" src="pic\factu.png"> Factures</th>
<th  align="center"><img height="25" width="25" src="pic\yes2.png"> approuver</th>
<th  align="center"><img height="25" width="25" src="pic\no2.png"> reffuser</th>

</tr>
<% location l=null;	 int i=0;%>
<%while((list.isEmpty()==false)){
 l=list.get(i);%>
 <tr>
 <td  align="center"><%=l.getLocataire(l.getLocataireid(l.getId_location()))%><form action="consulterLoc.jsp">
 <input type="hidden" name="prop" value=<%=l.getLocataireid(l.getId_location()) %>>
          <input type="submit" name="consulter" value="details"></form></td>
  <td  align="center"><%=b.getTypeBien(l.getBienid(l.getId_location()))%></td>
 <td  align="center"><%=l.getDate_debut() %></td>
 <td  align="center"><%=l.getDate_fin() %></td>

  <form action="afficherFacture.jsp">
    <input type="hidden" name="idloc" value=<%=l.getId_location() %>>
      <td  align="center"><input type="submit" name="consulter" value="consulter la facture"> </td></form>
 
   <form action="approuverLocation2.jsp">
    <input type="hidden" name="idloc" value=<%=l.getId_location() %>>
      <td  align="center"><input type="submit" name="consulter" value="approuver"> </td></form>
 <form action="refuserLocation.jsp">
   <input type="hidden" name="idloc" value=<%=l.getId_location() %>>
      <td><input type="submit" name="reffuser" value="reffuser"> </td></form>
 <%
list.remove(i);}} %>
</tr>
</table>
	</div>
	</div>
	</div></div>
	</div>
	<script src="js/bootstrap.js"></script>
	<script src="js/proton.js"></script>
</body>
</html>