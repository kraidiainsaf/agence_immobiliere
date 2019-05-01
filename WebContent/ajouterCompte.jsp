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
<title>Ajouter un Compte</title>
</head>
<body>
 <%@ include file="header.jsp" %>
 <div class="main-grid">
			<div class="agile-grids">
<form action="ajouterCmpt" method="GET">
<div class="panel panel-widget forms-panel">
						<div class="forms">
							<div class="form-grids widget-shadow" data-example-id="basic-forms"> 
								<div class="form-title">
<h3>Type de compte</h3>
</br></div>
<label id= "in">Compte Administrateur </label>
<input type="radio" name="type" value="admin" id="in" checked="checked">
</br>
<label id= "in">Compte locataire </label>
<input type="radio" name="type" value="locataire">

</br>
<label id= "in">Compte proprietaire </label>
<input type="radio" name="type" value="proprietaire">
</br>
<button id="in" class="btn btn-default w3ls-button">
<p>Suivant</p>
</button></div>
</form></div></div>
<script src="js/bootstrap.js"></script>
	<script src="js/proton.js"></script>
</body>
</html>