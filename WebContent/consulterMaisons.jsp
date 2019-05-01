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
<title>Consulter les maisons</title>
</head>
<body>
<%@ include file="header.jsp" %>
 <div class="main-grid">
			<div class="agile-grids">
<%@ page import="Modele.bien"%>
<%@ page import="Modele.cntrlBien"%>
<%@ page import=" java.util.ArrayList"%>
<%@ page import="Modele.cntrlCompte"%>
<%HttpSession maisons=request.getSession();
ArrayList<bien> list=(ArrayList<bien> )maisons.getAttribute("list");
cntrlBien b=new cntrlBien(); cntrlCompte c=new cntrlCompte();
if(list.isEmpty()){%>
 <h1 align="center">aucun maison disponible</h1>
 
<%}else{%>
<h1 align="center"><img height="50" width="50" src="pic\maisonn.png"> liste des maisons </h1>
</br>
</div>

				<div class="agile-tables">
					<div class="w3l-table-info">
					    <table id="tab">
						<thead>

<tr>
<th  align="center"><img height="20" width="20" src="pic\name.png">proprietaire</th>
<th  align="center"><img height="20" width="20" src="pic\adresse.png">adresse</th>
<th  align="center" ><img height="20" width="20" src="pic\wilaya.png">wilaya</th>
<th  align="center"><img height="20" width="20" src="pic\superficie.png">superficie</th>
<th  align="center"><img height="20" width="20" src="pic\prix.png">prix</th>
<th  align="center"><img height="20" width="20" src="pic\jardin.png">jardin</th>
<th  align="center"><img height="20" width="20" src="pic\park.png">park</th>
<th  align="center"><img height="20" width="20" src="pic\description.png">description</th>
<th  align="center">etat</th>
<th  align="center"><img height="20" width="20" src="pic\commentaire.png"> Commentaires</th>
<th  align="center"><img height="20" width="20" src="pic\photo.png">photos</th>
<th  align="center"><img height="20" width="20" src="pic\planning.png">planning</th>
</tr>
<tr>
<% bien bi=null;	 int i=0;%>
<%while((list.isEmpty()==false)){
 bi=list.get(i);%>
<td  align="center"><%=b.getNameprop(b.getProprietaire(bi.getId_bien())) %><form action="consulterProp.jsp">
 <input type="hidden" name="prop" value=<%=c.getproprietaire(b.getProprietaire(bi.getId_bien()))%>>
          <input type="submit" name="consulter" value="details"></form></td>
<td  align="center"><%=bi.getAdresse() %></td>
<td  align="center"><%=bi.getWilaya() %></td>
<td  align="center"><%=bi.getSuperficie() %>
<td  align="center"><%=bi.getPrix() %></td>
<td  align="center"><%=b.text(b.getjardin(bi.getId_bien())) %></td>
<td  align="center"><%=b.text(b.getpark(bi.getId_bien())) %></td>
<td  align="center"><%=bi.getdescription() %></td>
<td  align="center"><%=bi.getEtat_bien() %></td>
<form action="consulterCommentaire.jsp">
    <input  type="hidden" name="id" value=<%=bi.getId_bien() %>>
      <td  align="center"><input type="submit" name="modifier" value=" commentaires "> </td></form>
 <form action="afficherPhotos.jsp">
    <input type="hidden" name="id" value=<%=bi.getId_bien() %>>
      <td  align="center"><input type="submit" name="modifier" value=" photos "> </td></form>
   <form action="afficherPlanning.jsp">
    <input type="hidden" name="id" value=<%=bi.getId_bien() %>>
      <td  align="center"><input type="submit" name="modifier" value="  planning"> </td></form>   

</tr>
<%
list.remove(i);}} %>
</table>
	</div>
	</div>
	</div></div>
	</div>
	
<script src="js/bootstrap.js"></script>
	<script src="js/proton.js"></script>

</body>
</html>