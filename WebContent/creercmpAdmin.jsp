<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
#er{ boder: 1px solid ;
background-color: #ff6a6a;
padding:10px;
}</style>
<link rel="stylesheet" href="css/font.css" type="text/css"/>
<title>Créer Compte Administrateur</title>
</head>
<body>
<%--
if(!(er.getAttribute("test").equals(null))){
	er.removeAttribute("test");
RequestDispatcher DL =request.getRequestDispatcher("/ajouterCompte.jsp");
			DL.include(request,response);}--%>
<%@ include file="header.jsp" %>
<%--if(utilisateur1.getAttribute("pseudo").equals("oui")) {
	System.out.println(utilisateur1.getAttribute("pseudo"));
	utilisateur1.setAttribute("pseudo", utilisateur1.getAttribute("pseudo2"));
	RequestDispatcher D =request.getRequestDispatcher("/comptecréé.jsp");
	D.include(request,response);
}else{
--%>
 <div class="main-grid">
 <form action="creerAdmin" method="post">
 
							<%if((request.getAttribute("erroPseudo").equals("error")) ){%>
<div id="er">
<h3 > <img src="pic\error12.png" width="20px" height="20px" align="top"> ce pseudo et password existent déja! <img src="sorry.png" width="25px" height="25px" align="top"> Réessayer encore  </h3><%} %>
</div></br>
			<div class="agile-grids"><div class="panel panel-widget forms-panel">
						<div class="forms">
							<div class="form-grids widget-shadow" data-example-id="basic-forms"> 
								<div class="form-title">
<h1>Créer Compte Administrateur</h1></div>

 <div class="form-body">
<label  class="col-md-2 control-label" >  <img height="20" width="20" src="pic\name.png"><b> Nom: </b></label>
<div class="input-group input-icon right">
													<span class="input-group-addon">
														<i class=""></i>
													</span>
<input id="pl" align="center" type="text"   placeholder="nom" name="nom" REQUIRED size="20" style="width:250px;" /></div>
</br>
<label 	label class="col-md-2 control-label"><img height="20" width="20" src="pic\name.png"><b> Prénom: </b></label>
<div class="input-group input-icon right">
													<span class="input-group-addon">
														<i class=""></i>
													</span>
<input id="pl" align="center" type="text" placeholder="prénom"  name="prenom" REQUIRED size="20" style="width:250px;" /></div>
</br>
<label 	label class="col-md-2 control-label"><img height="20" width="20" src="pic\cart.png"><b> Numéro de la carte d'identité: </b></label>
<div class="input-group input-icon right">
													<span class="input-group-addon">
														<i class=""></i>
													</span>
<input id="pl" align="center" type="text" placeholder=" numéro de carte d'identité" min="000001" max="9999999" name="numCart" REQUIRED size="20" style="width:250px;" /></div>
</br>
<label label class="col-md-2 control-label"> <img height="20" width="20" src="pic\mail.png"><b> Adresse email: </b></label>
<div class="input-group input-icon right">
													<span class="input-group-addon">
														<i class=""></i>
													</span>
<input id="pl" align="center" type="email" placeholder="xxx@gmail.com" name="email" REQUIRED size="20" style="width:250px;" /></div>
</br>
<label label class="col-md-2 control-label"><img height="20" width="20" src="pic\tel.png"><b> Numéro de téléphone: </b></label>
<div class="input-group input-icon right">
													<span class="input-group-addon">
														<i class=""></i>
													</span>
<input id="pl" align="center" type="tel" placeholder="0666-66-66-66" pattern="0[0-9][0-9][0-9]-\d\d-\d\d-\d\d" name="numTel" REQUIRED size="20" style="width:250px;" /></div>
</br>
<label 	label class="col-md-2 control-label"><img height="20" width="20" src="pic\name1.png"><b> Pseudo: </b></label>
<div class="input-group input-icon right">
													<span class="input-group-addon">
														<i class=""></i>
													</span>
<input id="pl" align="center" type="text" placeholder="pseudo" name="pseudo" REQUIRED size="20" style="width:250px;" /></div>
</br>
<label 	label class="col-md-2 control-label"><img height="20" width="20" src="pic\pass.png"><b> Password: </b></label>
<div class="input-group input-icon right">
													<span class="input-group-addon">
														<i class=""></i>
													</span>
<input id="pl" align="center" type="password" placeholder="password" name="passe1" REQUIRED size="20" style="width:250px;" /></div>
</br>

<button class="btn btn-default w3ls-button">
<p>Créer </p>
</button>

</div>
</form>
<script src="js/bootstrap.js"></script>
	<script src="js/proton.js"></script><%--} --%>
</body>
</html>