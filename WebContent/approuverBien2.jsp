<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
</style>
<link rel="stylesheet" href="css/font.css" type="text/css"/>	
<title>Approuver un  Bien </title>
</head>
<body>
<%@ include file="header.jsp" %>
<%@ page import="Modele.bien"%>
<%@ page import="Modele.cntrlBien"%>
<%@ page import=" java.util.ArrayList"%>
<div class="main-grid">
			<div class="agile-grids">
<%String idb=request.getParameter("id");
int id1=Integer.parseInt(idb);
String idprop=request.getParameter("prop");
int idprop1=Integer.parseInt(idprop);
bien bien=new bien();

%><form action="approuverBien">
<div class="panel panel-widget forms-panel">
						<div class="forms">
							<div class="form-grids widget-shadow" data-example-id="basic-forms"> 
								<div class="form-title">
					<div id="di">

<h3>Inserer les photos de biens</h3></div>
 <div class="form-body">
<label>photo 1:</label>
<input type="file" name="image1">
</br>
<label>photo 2:</label>
<input type="file" name="image2">
</br>
<label>photo 3:</label>
<input type="file" name="image3">
</br>
<label>photo 4:</label>
<input type="file" name="image4">
</br>
<label>photo 5:</label>
<input type="file" name="image5">
</br>
 
    <input type="hidden" name="id" value=<%=id1 %>>
    <input type="hidden" name="idprop" value=<%=idprop1 %>>
    <button class="btn btn-default w3ls-button">
<p>approuver</p>
</button>
</div>
    </div>
    </form>
   
    <script src="js/bootstrap.js"></script>
	<script src="js/proton.js"></script>
    
     
</body>
</html>