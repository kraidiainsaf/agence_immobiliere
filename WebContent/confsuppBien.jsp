<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/font.css" type="text/css"/>
<style type="text/css">
#in{
margin-left:20px;
margin:10px;
padding:10px;}</style>
<title>Supprimer un Bien</title>
</head>
<body>
 <%@ include file="header.jsp" %>
 <%@ page import="Modele.cntrlCompte"%>
 <div class="main-grid">
			<div class="agile-grids">
<form action="supprimerBien1" method="GET">
<div class="panel panel-widget forms-panel">
						<div class="forms">
							<div class="form-grids widget-shadow" data-example-id="basic-forms"> 
								<div class="form-title">
<h3 align="center">Supprimer un bien</h3>
</br></div>
<br>
<div style="text-align: center;">
<h4 align="center">voulez vous supprimer ce bien? </h4>
<%HttpSession biens=request.getSession();
String idb7=new String();
idb7=String.valueOf(biens.getAttribute("idbi"));
int id5=Integer.parseInt(idb7);%>
   <input type="hidden" name="id5" value=<%=id5 %>>
<input id="in" align="center" type="submit" name="confirmer" value="supprimer">
<input id="in" align="center" type="submit" name="confirmer" value="annuler">
</div>
</div>
</form></div></div>
	<script src="js/bootstrap.js"></script>
	<script src="js/proton.js"></script>
</body>
</html>