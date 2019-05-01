<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/font.css" type="text/css"/>
<style>
input{background-color:  #e49b03;
border:solid 1px #e49b03;}</style>
<%@ include file="header.jsp" %>
<%@ page import="Modele.location"%>
<div class="main-grid">
			<div class="agile-grids">
			<div class="panel panel-widget forms-panel">
						<div class="forms">
							<div class="form-grids widget-shadow" data-example-id="basic-forms"> 
								<div class="form-title">
<title>refuser une location</title>
</head>
<body>
<p> <img height="50" width="50" src="pic\no2.png"> <b>voulez vous vraiment reffuser cette location?</b></p>
</br>
 <form action="refuserLocation" method="post">
<%System.out.println("id"+request.getParameter("idloc") ); 
location l=new location();
System.out.print(" resultat"+l.getLocataireid(Integer.parseInt((String)request.getParameter("idloc"))));
%>
    <input type="hidden" name="idloc" value=<%=request.getParameter("idloc") %>>
     <input type="hidden" name="idpers" value=<%=l.getLocataireid(Integer.parseInt((String)request.getParameter("idloc"))) %>>
   <img height="50" width="50" src="pic\yes.png">  <button class="btn btn-default w3ls-button">
<p> Oui</p>
</button></form>
 </br> 
       <form action="approuverLocation1.jsp">
    <img height="50" width="50" src="pic\no.png">  <button class="btn btn-default w3ls-button">
     
<p>Non</p>
</button>
       </div></div>  </div></div></div></div>
     <script src="js/bootstrap.js"></script>
	<script src="js/proton.js"></script>
</body>
</html>