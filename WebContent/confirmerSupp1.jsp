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
<title>Supprimer un Compte</title>
</head>
<body>
 <%@ include file="header.jsp" %>
 <%@ page import="Modele.cntrlCompte"%>
 <div class="main-grid">
			<div class="agile-grids">
<form action="trys" method="get">
<div class="panel panel-widget forms-panel">
						<div class="forms">
							<div class="form-grids widget-shadow" data-example-id="basic-forms"> 
								<div class="form-title">
<b>Supprimer un compte</b>
</br></div>
<b>voulez vous supprimer ce compte? </b>
<input id="in" align="center" type="submit" name="confirmer" value="supprimer">
<input id="in" align="center" type="submit" name="confirmer" value="annuler">
</div>
</form></div></div>
<script src="js/bootstrap.js"></script>
	<script src="js/proton.js"></script>
</body>
</html>