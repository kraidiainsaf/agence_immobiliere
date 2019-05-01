
<!DOCTYPE html>
<html lang="en" >

<head>
  <meta charset="UTF-8">
<title>Créer Compte Propriétaire</title>
  
  
  
      <link rel="stylesheet" href="css/style1.css">

  
</head>

  <body>
<div class="container">
	<section id="content">
		<form action="creerCmtProp">
			<h2 style="color:#F4C543;">Créer Compte Propriétaire</h2>
<div>
<%String e=(String)request.getAttribute("erreur"); %>

			<div>
			<%if(e!=null){ %>
<p 				 style="border:1px double #f65e5e;background-color:geray;padding:3px;margin-left:0px;margin-top:2px;margin-bottom:2px;margin-right:0px;background-color:#ff8c8c;">
 <%=e %></p><br><br>
                        <%} %> 
<label 	><b>Nom: </b></label><br>
<input style="height: 30px;padding:1px;"  type="text" placeholder="entrer votre nom" name="nom" required="required"/>
</div>
<div>
<label 	><b>Prénom: </b></label><br>
<input style="height: 30px;padding:1px;"   type="text" placeholder="entrer votre prénom"  name="prenom" required="required"/>
</div>
<div >
<label 	><b>Numéro de la carte d'identité: </b></label>
<input style="height: 30px;padding:1px;"  type="number"  min="000001" max="9999999" placeholder="entrer le numéro de votre carte d'identité" name="numCart" required="required"/>
</div>
<div >
<label 	><b>Adresse email: </b></label>
<input style="height: 30px;padding:1px;"  type="email" placeholder="entrer adresse email" name="email" required="required" />
</div>
<div >
<label 	><b>Numéro de téléphone:</b></label>
<input style="height: 30px;padding:1px;"  type="tel" placeholder="entrer votre numéro de téléphone" pattern="0[0-9][0-9][0-9]-\d\d-\d\d-\d\d" name="numTel" required="required"/>
</div>


			<div>
				<input type="submit" value="Suivant" />
			</div>
		</form><!-- form -->
		<div class="button">
		
			<a href="agence_immobiliere.jsp"><img width="300px" height="100px" src="logo2.png"></a>
		</div><!-- button -->
	</section><!-- content -->
</div><!-- container -->
</body>
  
  

    <script  src="js/index.js"></script>




</body>

</html>
