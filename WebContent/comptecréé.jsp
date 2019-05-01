<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/font.css" type="text/css"/>
<style type="text/css">
#h1 { color:red;}
#b{margin-left: 600px;width: 150px;height: 50px;}

#er{ boder: 1px solid ;
background-color: #ff6a6a;
padding:10px; width: 400px;margin-left:390px; border-radius:10px;
}
body{
background-image: url("/error-bg");}
</style>
<title>Création Compte</title>
</head>
<body>
<%@ include file="header.jsp" %>
<%
utilisateur1.setAttribute("pseudo", "oui");
System.out.println(request.getAttribute("error"));
if( request.getAttribute("error").equals("error")){
	%>

 <div class="main-grid">
 <div id="er">
 <h1 id="h1" align="center" color="red"><img alt="" src="pic\erreur.png" width="45px" height="45px" align="top" > Erreur
 </h1><form action="ajouterCompte.jsp">
 <h3 align="center">Vous avez peut etre entré des informations invalides! <img src="pic\sorry.png" width="25px" height="25px" align="top">
 </h3></br> </div></div><button  id="b"  align="center">
<p><img alt="" src="pic\try.png" width="20px" height="20px" align="top" > Réessayer </p>
</button></form>
 <form action="http://localhost:8080/agenceImmob/CreerComptServlet1" method="post">
 
 
<%}else{ %>
			<div class="agile-grids"><div class="panel panel-widget forms-panel">
			<div class="forms">
							<div class="form-grids widget-shadow" data-example-id="basic-forms"> 
								<div class="form-title">
<img alt="" src="pic\finish.png" width="45px" height="45px" align="top" ><h1>Création terminée avec succés</h1></div>
			<%HttpSession er=request.getSession(true);
			er.setAttribute("test", "oui"); %>
</div></div></div></div>
</form><%} %>
	<script src="js/bootstrap.js"></script>
	<script src="js/proton.js"></script>
</body>
</html>