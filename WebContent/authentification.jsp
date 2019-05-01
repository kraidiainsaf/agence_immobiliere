
<!DOCTYPE html>
<html lang="en" >

<head>
  <meta charset="UTF-8">
  <title>Connexion</title>
  
  
  
      <link rel="stylesheet" href="css/style1.css">

  
</head>

  <body>
<div class="container">
	<section id="content">
		<form action="AuthentificationServlet2">
			<h1 style="color:#F4C543;">Connexion</h1>
			<%String e=(String)request.getAttribute("erreur"); %>

			<div>
			<%if(e!=null){ %>
<p 				 style="border:1px double #f65e5e;background-color:geray;padding:3px;margin-left:0px;margin-top:2px;margin-bottom:2px;margin-right:0px;background-color:#ff8c8c;">
 <%=e %></p><br><br>
                        <%} %> 
			<label style="color:#b3b3b3;" ><b> Pseudo</b>
			<input type="text" placeholder="Pseudo"  placeholder="entrer pseudo" name="pseudo"/>
			</label>
			</div>
			<div>
			<label style="color:#b3b3b3;"><b> Password</b>
			<input type="password" placeholder="Password" placeholder="entrer mot de passe" name="password">
			</label>
			</div>
			<div>
				<input type="submit" value="Se Connecter" />
				
				
				<a href="#">Password Oublié?</a>
				<a href="créerCompte.jsp">Créer un compte!</a>
				
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
