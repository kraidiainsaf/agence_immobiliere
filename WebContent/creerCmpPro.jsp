
<!DOCTYPE html>
<html lang="en" >

<head>
  <meta charset="UTF-8">
<title>Cr�er Compte Propri�taire</title>
  
  
  
      <link rel="stylesheet" href="css/style1.css">

  
</head>

  <body>
<div class="container">
	<section id="content">
		<form action="creerCmtProp">
			<h2 style="color:#F4C543;">Cr�er Compte Propri�taire</h2>
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
<label 	><b>Pr�nom: </b></label><br>
<input style="height: 30px;padding:1px;"   type="text" placeholder="entrer votre pr�nom"  name="prenom" required="required"/>
</div>
<div >
<label 	><b>Num�ro de la carte d'identit�: </b></label>
<input style="height: 30px;padding:1px;"  type="number"  min="000001" max="9999999" placeholder="entrer le num�ro de votre carte d'identit�" name="numCart" required="required"/>
</div>
<div >
<label 	><b>Adresse email: </b></label>
<input style="height: 30px;padding:1px;"  type="email" placeholder="entrer adresse email" name="email" required="required" />
</div>
<div >
<label 	><b>Num�ro de t�l�phone:</b></label>
<input style="height: 30px;padding:1px;"  type="tel" placeholder="entrer votre num�ro de t�l�phone" pattern="0[0-9][0-9][0-9]-\d\d-\d\d-\d\d" name="numTel" required="required"/>
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
