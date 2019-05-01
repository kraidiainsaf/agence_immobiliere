<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/font.css" type="text/css"/>
<link rel="stylesheet" href="css/table-style.css">
<style>

</style>
<title>Supprimer Bien</title>
</head>
<body>


 <%@ include file="header.jsp" %>
 <div class="main-grid">
			<div class="agile-grids">
			<h1 align="center"> <img alt="" src="pic/trash.png" width="40px" height="40px" align="top" > Supprimer un bien </h1>
			</br>
<form action="supprimerB" method="GET">
<fieldset>
<%@ page import="Modele.bien"%>
<%@ page import="Modele.cntrlBien"%>
<%@ page import=" java.util.ArrayList"%>
<%HttpSession listBien=request.getSession();
ArrayList<bien> list=(ArrayList<bien>)listBien.getAttribute("liste");
cntrlBien b=new cntrlBien();
%>
<div class="agile-tables">
					<div class="w3l-table-info">
					    <table id="table">
						<thead>
						<tr>
<th>type de bien</th>
<th>proprietaire</th>
<th>adresse</th>
<th> superficie</th>
<th> prix</th>
<th> description</th>
<th> max_coloccataire</th>
<th>photo 1</th>
<th>photo 2</th>
<th>photo 3</th>
<th>photo 4</th>
<th>photo 5</th>
<th>Supprimer</th>
</tr>
</thead>
<% bien bi=null;	 int i=0;
//out.println(list.isEmpty());
%>
<%while((list.isEmpty()==false)){
 bi=list.get(i);%>

<tr>
<td><%=b.getTypeBien(bi.getId_bien()) %></td>
<td><%=b.getProprietaire(bi.getId_bien()) %> </td>
<td><%=b.getAdresse(bi.getId_bien()) %></td>
<td> <%=bi.getSuperficie() %></td>
<td><%=bi.getPrix()%></td>
<td> <%=bi.getdescription() %></td>
<td><%=bi.getMax_colocataire() %></td>
<td><img  width="70" height="70" src="<%=bi.getimg1(bi.getId_bien())%>"></td>
<td><img  width="70" height="70" src="<%=bi.getimg2(bi.getId_bien())%>"></td>
<td><img  width="70" height="70" src="<%=bi.getimg3(bi.getId_bien())%>"></td>
<td><img  width="70" height="70" src="<%=bi.getimg4(bi.getId_bien())%>"></td>
<td><img  width="70" height="70" src="<%=bi.getimg5(bi.getId_bien())%>"></td>
 <form action="supprimerB">
    <input type="hidden" name="id" value=<%=bi.getId_bien() %>>
      <td><input type="submit" name="modifier" value="supprimer"> </td></form>
      

</tr>
<%
list.remove(i);} %>
</table>


</div></div>
</div></div>
</form>
</body>
<script src="js/bootstrap.js"></script>
	<script src="js/proton.js"></script>
</html>