<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
#in{
margin-left:20px;
margin:10px;
padding:10px;}</style>
<title>Terminer la location</title>
</head>
<body>

<title>Terminer la location</title>
</head>
<body>
 <%@ include file="header.jsp" %>
 <%@ page import="Modele.cntrlCompte"%>
 <div class="main-grid">
			<div class="agile-grids">

<div class="panel panel-widget forms-panel">
						<div class="forms">
							<div class="form-grids widget-shadow" data-example-id="basic-forms"> 
								<div class="form-title">
<h1 >Fin de location </h1>
</br></div>
</br>
<b id="in">voulez vous terminer cette location? </b>
</br></br>
<form action="rendreBien" method="post">
<%String id2=(String)request.getParameter("idloc");
 int idloca=Integer.parseInt(id2); %>
 <input type="hidden" name="idloca" value=<%=idloca %>>
 <button id="in" class="btn btn-default w3ls-button" style="padding: 3px; width: 130px;"><p> <img height="25" width="25" src="pic\yes.png"> OUI</p></button></form>

 <form action="afficherPlanning.jsp">
 <%String id1=(String)request.getParameter("idbi");
 int idloc2=Integer.parseInt(id1); %>
  <input type="hidden" name="id" value=<%=idloc2 %>>
 <button id="in" class="btn btn-default w3ls-button" style="padding: 3px; width: 130px;"><p> <img height="25" width="25" src="pic\no.png"> NON</p></button></form>
 </div></div></div></div></div>
<script src="js/bootstrap.js"></script>
	<script src="js/proton.js"></script>
</body>

</html>