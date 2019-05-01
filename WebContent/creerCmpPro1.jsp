
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
		<form action="CreerCmtProp1">
			<h2 style="color:#F4C543;">Créer Compte Propriétaire</h2>
			<%String e=(String)request.getAttribute("erreur"); %>

			<div>
			<%if(e!=null){ %>
<p 				 style="border:1px double #f65e5e;background-color:geray;padding:3px;margin-left:0px;margin-top:2px;margin-bottom:2px;margin-right:0px;background-color:#ff8c8c;">
 <%=e %></p><br><br>
                        <%} %> 
			<label style="color:#b3b3b3;" ><b> Pseudo</b><br>
			<input type="text" placeholder="Pseudo"   placeholder="entrer un pseudo" name="pseudo" required="required"/>
			</label>
			</div>
			<div>
			<label style="color:#b3b3b3;"><b> Password</b>
			<input type="password" placeholder="Password" placeholder="entrer un mot de passe" name="passe1" required="required">
			</label>
			</div>
			<div>
				<input type="submit" value="Créer Compte" />
				
			
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
