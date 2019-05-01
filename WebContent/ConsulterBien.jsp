<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/font.css" type="text/css"/>	
	
<style type="text/css">
table{
border-collapse: collapse;
width:100%;
padding:50px;

margin-left: 20px;}
input{
background-color: white;
}
body{
background-color: #e6e6e6;
}
img{
border-radius:10px;
}
button{
border-radius:10px;
background-color: white;
}
#t{
align:center;
padding:100px;
margin-left: 60px;}
</style>

<title>consulter les biens</title>
</head>

<body>
	
<%@ include file="header.jsp" %>
<br><br>
<header><b><h1 align="center" style="font-size: 50px;">Consulter les biens </h1> </b> </header>
<br><br>
<div class="main-grid">
			
<table id="t" align="center">
<tr>
<td>

<a href="consulterMaison"><img height="200" width="200" src="pic\mais.png"></a>
</td>
<td>

<a href="consulterAppartement"><img height="200" width="200" src="pic\apa.png"></a>
</td>
<td>
<a href="consulterLocaleCommercial"><img height="200" width="200" src="pic\depo.png"></a>
</td>

</tr>
<tr>
<td ><h2  > </h2><br><br><br></td>
<td ><h2 align="center"> </h2><br><br><br></td>
<td ><h2 align="center"> </h2><br><br><br></td>
</tr>
<tr>
<td>

<a href="consulterTerrain"><img height="200" width="200" src="pic\terai.png"></a>
</td>

<td>

<a href="consulterGarrage"><img height="200" width="200" src="pic\gara.png"></a>
</td>
<td>

<a href="consulterDepot"><img height="200" width="200" src="pic\depo1.png"></a>
</td>

</tr>
<tr>
<td ><h2 align="center" > </h2><br><br><br></td>
<td ><h2 align="center"> </h2><br><br><br></td>
<td ><h2 align="center" > </h2><br><br><br></td>
</tr>
</table>
</div>
<script src="js/bootstrap.js"></script>
	<script src="js/proton.js"></script>
</body>
</html>