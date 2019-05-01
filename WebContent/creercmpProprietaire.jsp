<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/font.css" type="text/css"/>
<title>Créer un compte Proprietaire</title>
</head>
<body>
<%@ include file="header.jsp" %>
 <div class="main-grid">
 <form action="creerProS" method="post">
			<div class="agile-grids"><div class="panel panel-widget forms-panel">
						<div class="forms">
							<div class="form-grids widget-shadow" data-example-id="basic-forms"> 
								<div class="form-title">
<h1>Créer un Compte proprietaire</h1></div>

 <div class="form-body">
 <label 	label class="col-md-2 control-label"><img alt="" src="pic\name.png" width="20px" height="20px" align="top" ><b> Nom: </b></label>
<div class="input-group input-icon right">
													<span class="input-group-addon">
														<i class=""></i>
													</span>
<input id="pl" align="center" type="text" placeholder="nom" name="nom" REQUIRED size="20" style="width:250px;"/></div>
</br>
<label 	label class="col-md-2 control-label"><img alt="" src="pic\name.png" width="20px" height="20px" align="top" ><b> Prénom: </b></label>
<div class="input-group input-icon right">
													<span class="input-group-addon">
														<i class=""></i>
													</span>
<input id="pl" align="center" type="text" placeholder="prénom"  name="prenom" REQUIRED size="20" style="width:250px;" /></div>
</br>
<label 	label class="col-md-2 control-label"><img alt="" src="pic\cart.png" width="20px" height="20px" align="top" ><b> Numéro de la carte d'identité: </b></label>
<div class="input-group input-icon right">
													<span class="input-group-addon">
														<i class=""></i>
													</span>
<input id="pl" align="center" type="number" min="000001" max="9999999" placeholder="numéro de carte d'identité" name="numCart" REQUIRED size="20" style="width:250px;" /></div>
</br>
<label label class="col-md-2 control-label"><img alt="" src="pic\mail.png" width="20px" height="20px" align="top" ><b> Adresse email: </b></label>
<div class="input-group input-icon right">
													<span class="input-group-addon">
														<i class=""></i>
													</span>
<input id="pl" align="center" type="email" placeholder="xxx@gmail.com" name="email" REQUIRED size="20" style="width:250px;" /></div>
</br>
<label label class="col-md-2 control-label"><img alt="" src="pic\tel.png" width="20px" height="20px" align="top" ><b> Numéro de téléphone: </b></label>
<div class="input-group input-icon right">
													<span class="input-group-addon">
														<i class=""></i>
													</span>
<input id="pl" align="center" type="tel" placeholder="0666-66-66-66" pattern="0[0-9][0-9][0-9]-\d\d-\d\d-\d\d" name="numTel" REQUIRED size="20" style="width:250px;" /></div>
</br>
<button class="btn btn-default w3ls-button">
<p>Suivant </p>
</button>

</div>
</form>
<script src="js/bootstrap.js"></script>
	<script src="js/proton.js"></script>

</body>
</html>