<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/font.css" type="text/css"/>
<style type="text/css">
#er{ boder: 1px solid ;
background-color: #ff6a6a;
padding:10px;
}</style>
<title>créer un compte proprietaire</title>
</head>
<body>
<%--HttpSession er=request.getSession(true); 
if(!(er.getAttribute("test").equals(null))){
er.removeAttribute("test");
RequestDispatcher DL =request.getRequestDispatcher("/ajouterCompte.jsp");
			DL.include(request,response);}else{--%>
<%@ include file="header.jsp" %>
 <div class="main-grid">
 <form action="creerProS1" method="post">
			
							<%if((request.getAttribute("erroPseudo").equals("error")) ){%>
<div id="er">
<h3 > <img src="pic\error12.png" width="20px" height="20px" align="top"> ce pseudo et password existent déja! <img src="sorry.png" width="25px" height="25px" align="top"> Réessayer encore  </h3><%} %>
</div></br>
<div class="agile-grids"><div class="panel panel-widget forms-panel">
						<div class="forms">
							<div class="form-grids widget-shadow" data-example-id="basic-forms"> 
								<div class="form-title">

<h1>Créer un Compte proprietaire</h1></div>

 <div class="form-body">
 <label 	label class="col-md-2 control-label"> <img src="pic\name1.png" width="20px" height="20px" align="top"><b> Pseudo: </b></label>
<div class="input-group input-icon right">
													<span class="input-group-addon">
														<i class=""></i>
													</span>
<input id="pl" align="center" type="text" placeholder="pseudo" name="pseudo" REQUIRED size="20" style="width:250px;"/></div>
</br>
<label 	label class="col-md-2 control-label"><img src="pic\pass.png" width="20px" height="20px" align="top"><b>Password: </b></label>
<div class="input-group input-icon right">
													<span class="input-group-addon">
														<i class=""></i>
													</span>
<input id="pl" align="center" type="password" placeholder="password" name="passe1" REQUIRED size="20" style="width:250px;"/></div>
</br>

<button class="btn btn-default w3ls-button">
<p>Créer </p>
</button>

</div>
</form>
<script src="js/bootstrap.js"></script>
	<script src="js/proton.js"></script>
<%--} --%>
</body>
</html>