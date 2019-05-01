<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
#tab{
width:100%;
padding:50px;}

</style>
<link rel="stylesheet" href="css/mytab.css">
<title>Consulter les appartements</title>
</head>
<body>
<%@ include file="header.jsp" %>
 <div class="main-grid">
			<div class="agile-grids">
<%@ page import="Modele.bien"%>
<%@ page import="Modele.cntrlBien"%>
<%@ page import=" java.util.ArrayList"%>
<%@ page import="Modele.cntrlCompte"%>
<%HttpSession appartements=request.getSession();
ArrayList<bien> liste=(ArrayList<bien> )appartements.getAttribute("liste");cntrlCompte c=new cntrlCompte();
cntrlBien b=new cntrlBien();
if(liste.isEmpty()){ 
	%>
	 <h1 align="center">aucune appartement disponible</h1>
	 <% 
}
else{%>
<h1 align="center"><img height="50" width="50" src="pic\appartementt.png"> liste des appartements </h1>
</br>
<div class="agile-tables">
					<div class="w3l-table-info">
					    <table id="tab">
						<thead>
<tr>
<th  align="center"><img height="20" width="20" src="pic\name.png">proprietaire</th>
<th  align="center"><img height="20" width="20" src="pic\adresse.png"> adresse</th>
<th  align="center" ><img height="20" width="20" src="pic\wilaya.png"> wilaya</th>
<th  align="center"><img height="20" width="20" src="pic\superficie.png"> superficie</th>
<th  align="center"><img height="20" width="20" src="pic\prix.png"> prix</th>
<th  align="center"><img height="20" width="20" src="pic\chambre.png"> nombre de chambres</th>
<th  align="center"><img height="20" width="20" src="pic\etage.png"> étage</th>
<th  align="center"><img height="20" width="20" src="pic\description.png">description</th>
<th  align="center">etat</th>
<th  align="center"><img height="20" width="20" src="pic\commentaire.png">commentaire</th>
<th  align="center"><img height="20" width="20" src="pic\photo.png">photos</th>
<th  align="center"><img height="20" width="20" src="pic\planning.png">planning</th>
</tr>
<tr>
<% bien bi=null;	 int i=0;%>
<%while((liste.isEmpty()==false)){
 bi=liste.get(i);%>
<td  align="center"><%=b.getNameprop(b.getProprietaire(bi.getId_bien())) %><form action="consulterProp.jsp">
 <input type="hidden" name="prop" value=<%=c.getproprietaire(b.getProprietaire(bi.getId_bien()))%>>
          <input type="submit" name="consulter" value="details"></form></td>
<td  align="center"><%=bi.getAdresse() %></td>
<td  align="center"><%=bi.getWilaya() %></td>
<td  align="center"><%=bi.getSuperficie() %>
<td  align="center"><%=bi.getPrix() %></td>
<td  align="center"><%=b.getNbrchambrea(bi.getId_bien()) %></td>
<td  align="center"><%=b.getEtage(bi.getId_bien()) %></td>
<td  align="center"><%=bi.getdescription() %></td>
<td  align="center"><%=bi.getEtat_bien() %>
<form action="consulterCommentaire.jsp">
    <input type="hidden" name="id" value=<%=bi.getId_bien() %>>
      <td  align="center"><input type="submit" name="modifier" value=" commentaires "> </td></form>
 <form action="afficherPhotos.jsp">
    <input type="hidden" name="id" value=<%=bi.getId_bien() %>>
      <td  align="center"><input type="submit" name="modifier" value=" photos"> </td></form>
   <form action="afficherPlanning.jsp">
    <input type="hidden" name="id" value=<%=bi.getId_bien() %>>
      <td  align="center"><input type="submit" name="modifier" value=" planning"> </td></form>   

</tr>
<%
liste.remove(i);}} %>
</table>
	</div>
	</div>
	</div></div>
	</div>
	
<script src="js/bootstrap.js"></script>
	<script src="js/proton.js"></script>

</body>
</html>