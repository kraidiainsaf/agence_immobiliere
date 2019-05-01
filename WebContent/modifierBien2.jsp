<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/font.css" type="text/css"/>
<style>
#t{width: 400px;
height: 100px;}</style>
<title>Modifier  un Bien </title>
</head>
<body>
<%@ include file="header.jsp" %>
<%@ page import="Modele.bien"%>
<%@ page import="Modele.cntrlBien"%>
<%@ page import=" java.util.ArrayList"%>
<div class="main-grid">
			<div class="agile-grids">
<%HttpSession bien=request.getSession();%>
<form action="modifierBien2" enctype="multipart/form-data" method="get">
<h1 align="center"><img height="40" width="40" src="pic\modi.png"> Modifier un bien</h1></br>
<div class="panel panel-widget forms-panel" >
						<div class="forms" >
							<div class="form-grids widget-shadow" data-example-id="basic-forms"> 
								<div class="form-title">
								<div class="form-body">
<label><img height="25" width="25" src="pic\superficie.png"> superficie:</label>
<input type="number" name="superficie" REQUIRED value="<%=bien.getAttribute("superficie") %>" >
</br>
</br>
<label><img height="25" width="25" src="pic\prix.png"> prix:</label>
<input type="number" name="prix" REQUIRED value="<%=bien.getAttribute("prix") %>">

</br>
</br>
<label> <img height="25" width="25" src="pic\descri.png"> description:</label>
<input type="text" id="t" name="description" REQUIRED value="<%=bien.getAttribute("description") %>">
</br></br>
<label> <img height="25" width="25" src="pic\name1.png" >max colocataire:</label>
<input type="number" name="max_colocataire" min="1" max="10" REQUIRED value="<%=bien.getAttribute("max_colocataire") %>">
</br>
</br>


<label><img height="25" width="25" src="pic\photo.png"> photo 1:</label>
<input type="file" name="image1" value="<%=bien.getAttribute("image1") %>">
</br>
<label> <img height="25" width="25" src="pic\photo.png"> photo 2:</label>
<input type="file" name="image2"  value="<%=bien.getAttribute("image2") %>">
</br>
<label> <img height="25" width="25" src="pic\photo.png"> photo 3:</label>
<input type="file" name="image3"  value="<%=bien.getAttribute("image3") %>">
</br>
<label><img height="25" width="25" src="pic\photo.png"> photo 4:</label>
<input type="file" name="image4"  value="<%=bien.getAttribute("image4") %>">
</br>
<label><img height="25" width="25" src="pic\photo.png">  photo 5:</label>
<input type="file" name="image5"  value="<%=bien.getAttribute("image5") %>">
</br>
</br>
 <input type="hidden" name="id" value=<%=bien.getAttribute("id_bien") %>>
<button class="btn btn-default w3ls-button">
<p>modifier</p>
</button>
</div></div></div></div>
</form></div></div>
  <script src="js/bootstrap.js"></script>
	<script src="js/proton.js"></script>

</body>
</html>