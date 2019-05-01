<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<head>
<title>Colored  an Admin Panel Category Flat Bootstrap Responsive Website Template | Home :: w3layouts</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Colored Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<style type="text/css">
#table{
border-collapse: collapse;
width:70%;

margin-left: 60px;}
#table td{ border:1px solid #ddd; padding:2px;
padding:2px;}
 #table tr{ padding:5px;
 margin:6px;
 }
 #table th{ }</style>
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- bootstrap-css -->
<link rel="stylesheet" href="css/bootstrap.css">
<!-- //bootstrap-css -->
<!-- Custom CSS -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<!-- font CSS -->
<link href='//fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
<!-- font-awesome icons -->
<link rel="stylesheet" href="css/font.css" type="text/css"/>
<link href="css/font-awesome.css" rel="stylesheet"> 
<!-- //font-awesome icons -->
<script src="js/jquery2.0.3.min.js"></script>
<script src="js/modernizr.js"></script>
<script src="js/jquery.cookie.js"></script>
<script src="js/screenfull.js"></script>
		<script>
		$(function () {
			$('#supported').text('Supported/allowed: ' + !!screenfull.enabled);

			if (!screenfull.enabled) {
				return false;
			}

			

			$('#toggle').click(function () {
				screenfull.toggle($('#container')[0]);
			});	
		});
		</script>
<!-- charts -->
<script src="js/raphael-min.js"></script>
<script src="js/morris.js"></script>
<link rel="stylesheet" href="css/morris.css">
<link rel="stylesheet" href="css/table-style.css">
<!-- //charts -->
<!--skycons-icons-->
<script src="js/skycons.js"></script>
<!--//skycons-icons-->
</head>
<body class="dashboard-page">
	<script>
	        var theme = $.cookie('protonTheme') || 'default';
	        $('body').removeClass (function (index, css) {
	            return (css.match (/\btheme-\S+/g) || []).join(' ');
	        });
	        if (theme !== 'default') $('body').addClass(theme);
        </script>
	<nav class="main-menu">
		<ul>
			<li>
				<a href="newspace.jsp">
					<i class="fa fa-home nav_icon"></i>
					<span class="nav-text">
					menu generale
					</span>
				</a>
			</li>
			<li class="has-subnav">
				<a href="approuver.jsp">
				<i class="fa fa-check-square-o nav_icon" aria-hidden="true"></i>
				<span class="nav-text">
					approuver un bien
				</span>
				
				</ul>
			</li>
			<li class="has-subnav">
				<a href="">
				<i class="fa fa-cogs"></i>
				<span class="nav-text">
				gerer les bien
				</span>
				<i class="icon-angle-right"></i><i class="icon-angle-down"></i>
				</a>
				<ul>
					<li>
						<a class="subnav-text" href="modifierServ">modifier un bien</a>
					</li>
					<li>
						<a class="subnav-text" href="SuppBienServ">supprimer un bien</a>
					</li>
				</ul>
			</li>
			<li class="has-subnav">
				<a href="javascript:;">
					<i class="fa fa-cogs"></i>
						<span class="nav-text">gérer les comptes</span>
					<i class="icon-angle-right"></i><i class="icon-angle-down"></i>
				</a>
				<ul>
				
					<li>
						<a class="subnav-text" href="calendar.html">
							ajouter un compte
						</a>
					</li>
					<li>
						<a class="subnav-text" href="">
							supprimer un compte
						</a>
					</li>
				</ul>
			</li>
			<li>
				
			</li>
			<li>
				<a href="EnvoyerNotif">
					<i class="icon-font nav-icon"></i>
					<span class="nav-text">
					envoyer une notification 
					</span>
				</a>
			</li>
			<li>
				<a href="ConsulterBien.jsp">
					<i class="icon-table nav-icon"></i>
					<span class="nav-text">
					consulter la liste des biens 
					</span>
				</a>
			</li>
			<li>
				<a href="approuverLocation1.jsp">
					<i class="fa fa-check-square-o nav_icon" aria-hidden="true"></i>
					<span class="nav-text">
					approuver les locations
					</span>
				</a>
			</li>
			<li>
				<a href="stat.html">
					<i class="fa fa-bar-chart nav_icon"></i>
					<span class="nav-text">
						consulter les statistiques
					</span>
				</a>
			</li>
			
			
		</ul>
		<ul class="logout">
			<li>
			<a href="logout">
			<i class="icon-off nav-icon"></i>
			<span class="nav-text">
			Logout
			</span>
			</a>
			</li>
		</ul>
	</nav>
		<section class="wrapper scrollable">
		<nav class="user-menu">
			<a href="javascript:;" class="main-menu-access">
			<i class="icon-proton-logo"></i>
			<i class="icon-reorder"></i>
			</a>
		</nav>
		<section class="title-bar">
			<div class="logo">
				<h1><a href="index.html"><img src="images/logo.png" alt="" />Elkariaa</a></h1>
			</div>
			<div class="full-screen">
				<section class="full-top">
					<button id="toggle"><i class="fa fa-arrows-alt" aria-hidden="true"></i></button>	
				</section>
			</div>
			<div class="w3l_search">
				<h1 id="bien">Bienvenu </h1>
				<h3> nous somme le </h3> <%= new java.util.Date().toString() %>
				</form>
			</div>
												<%@ page import="Modele.cntrlNotif"%>
<%@ page import="Modele.notification"%>
									<%cntrlNotif n=new cntrlNotif();
HttpSession utilisateur1=request.getSession();

String p=String.valueOf(utilisateur1.getAttribute("id_personne"));
int id=Integer.parseInt(p);
%>
			<div class="header-right">
				<div class="profile_details_left">
					<div class="header-right-left">
						<!--notifications of menu start -->
						<ul class="nofitications-dropdown">
							<li class="dropdown head-dpdn">
								
							</li>
							<li class="dropdown head-dpdn">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="fa fa-bell"></i><span class="badge blue"><%=n.nombreNotif(id) %></span></a>
								<ul class="dropdown-menu anti-dropdown-menu agile-notification">
									<li>

										<div class="notification_header">
											<h3>vous avez <%=n.nombreNotif(id) %> notifications</h3>
										</div>
									</li>
									
										<div class="notification_bottom">
											<a href="consulterNotif.jsp">consulter vos  notifications</a>
										</div> 
									</li>
								</ul>
							</li>	
								
								</ul>
							</li>	
							<div class="clearfix"> </div>
						</ul>
					</div>	
					<div class="profile_details">		
						<ul>
							<li class="dropdown profile_details_drop">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
									<div class="profile_img">	
										<span class="prfil-img"><i class="fa fa-user" aria-hidden="true"></i></span> 
										<div class="clearfix"></div>	
									</div>	
								</a>
								<ul class="dropdown-menu drp-mnu">
									<li> <a href="afficherProfile.jsp"><i class="fa fa-user"></i> Profile</a> </li> 
									<li> <a href="logout"><i class="fa fa-sign-out"></i> Logout</a> </li>
								</ul>
							</li>
						</ul>
					</div>
					<div class="clearfix"> </div>
				</div>
			</div>
			<div class="clearfix"> </div>
		</section>
		<div class="main-grid">
			
			<%@ page import="Modele.bien"%>
<%@ page import="Modele.cntrlBien"%>
<%@ page import="Modele.cntrlCompte"%>
<%@ page import=" java.util.ArrayList"%>
<%cntrlBien b=new cntrlBien();
cntrlCompte c=new cntrlCompte();
ArrayList<bien> list=b.getBienapprouve();%>
					<h2 align="center">Approuver de biens </h2>
				</div>
				<div class="agile-tables">
					<div class="w3l-table-info">
					    <table id="table">
						<thead>
						  <tr>
						  <th>type de bien</th>
<th>proprietaire</th>
<th>adresse</th>
<th> superficie</th>
<th> prix</th>
<th> description</th>
<th> max_coloccataire</th>
<th>photo 1</th>
<th>photo 2</th>
<th>photo 3</th>
<th>photo 4</th>
<th>photo 5</th>
<th></th>
<th></th>
</tr>
<% bien bi=null;	 int i=0;
out.println(list.isEmpty());%>
<%while((list.isEmpty()==false)){
 bi=list.get(i); 
 %>

<tr>
<td><%=b.getTypeBien(bi.getId_bien()) %>
<td><%=b.getNameprop(b.getProprietaire(bi.getId_bien())) %> </td>
<td><%=b.getAdresse(bi.getId_bien()) %>
<td> <%=bi.getSuperficie() %></td>
<td><%=bi.getPrix()%></td>
<td> <%=bi.getdescription() %></td>
<td><%=bi.getMax_colocataire() %></td>
<td><img  width="70" height="70" src="<%=bi.getimg1(bi.getId_bien())%>"></td>
<td><img  width="70" height="70" src="<%=bi.getimg2(bi.getId_bien())%>"></td>
<td><img  width="70" height="70" src="<%=bi.getimg3(bi.getId_bien())%>"></td>
<td><img  width="70" height="70" src="<%=bi.getimg4(bi.getId_bien())%>"></td>
<td><img  width="70" height="70" src="<%=bi.getimg5(bi.getId_bien())%>"></td>
 
 <form action="approuverBien2.jsp">
    <input type="hidden" name="id" value=<%=bi.getId_bien() %>>
    <input type="hidden" name="bien" value=<%= bi %>>
    <input type="hidden" name="prop" value=<%=c.getproprietaire(b.getProprietaire(bi.getId_bien()))%>>
         <td> <input type="submit" name="approuver" value="approuver"></td> </form>
   <form action="refuserBien.jsp">
    <input type="hidden" name="id" value=<%=bi.getId_bien() %>>
    <input type="hidden" name="bien" value=<%= bi %>>
      <td><input type="submit" name="reffuser" value="reffuser"></td> </form>    

</tr>
<%
list.remove(i);} %>
<a href="#d"> aller au bas</a>
</table>
<h1>rtyghu</h1>
	<h1>rtyghu</h1>
	<h1>rtyghu</h1>
	<h1>rtyghu</h1>
	<h1>rtyghu</h1>
	<h1>rtyghu</h1>
	</div>
	</div>
	</div></div>
	</div>
	
		<!-- footer -->
		<div class="footer">
			<p>© 2016 Colored . All Rights Reserved . Design by <a href="http://w3layouts.com/">W3layouts</a></p>
		</div>
		<!-- //footer -->
	</section>
	<script src="js/bootstrap.js"></script>
	<script src="js/proton.js"></script>
</body>
</html>
