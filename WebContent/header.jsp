<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<head>
<title>El Keria</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Colored Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<style type="text/css">
#table{
border-collapse: collapse;
width:70%;

margin-left: 60px;}
#bien{ 
padding-top: 40px; width:300px;}
#table td{ border:1px solid #ddd; padding:2px;
padding:2px;}
 #table tr{ padding:5px;
 margin:6px;
 }
 b{
 font-size: 16px;}
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

<!-- //charts -->
<!--skycons-icons-->
<script src="js/skycons.js"></script>
<!--//skycons-icons-->
</head>
<body class="dashboard-page">
<%@ page import="Modele.cntrlNotif"%>
<%@ page import="Modele.cntrlCompte"%>
<% HttpSession utilisateur1=request.getSession();
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
if(utilisateur1.getAttribute("pseudo")==null){
	//response.sendRedirect("authentificationg.html");
RequestDispatcher DL =request.getRequestDispatcher("/authentificationg.jsp");
					DL.forward(request,response);}%>
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
				<a href="approuverBien1.jsp">
				<i class="fa fa-check-square-o nav_icon" aria-hidden="true"></i>
				<span class="nav-text">
					approuver un bien
				</span>
				
				</ul>
					
			</li>
				<%String lu=(String)utilisateur1.getAttribute("pseudo");
			cntrlCompte ct5=new cntrlCompte(); cntrlNotif cn=new cntrlNotif();
			int myid=cn.getIdPersonne(lu);
			%>
			<% if(	ct5.isGradeb(myid)){%>
			<li class="has-subnav">
				<a href="modifierServ">
					<i class="fa fa-cogs"></i>
						
						
							<span class="nav-text"> modifier un bien </span>
						
					
				</a>
		<%}else{ %>
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
			</li><%} %>
				<% if(	ct5.isGradeb(myid)){%>
		<li class="has-subnav">
				<a href="ajouterCompte.jsp">
					<i class="fa fa-cogs"></i>
						
						
							<span class="nav-text"> ajouter comptes</span>
						
					
				</a>
		<%}else{ %>
			<li class="has-subnav">
				<a href="javascript:;">
					<i class="fa fa-cogs"></i>
						<span class="nav-text">gérer les comptes</span>
					<i class="icon-angle-right"></i><i class="icon-angle-down"></i>
				</a>
				<ul>
				
					<li>
						<a class="subnav-text" href="ajouterCompte.jsp"">
							ajouter un compte
						</a>
					</li>
					<li>
						<a class="subnav-text" href="suppressionCompte.jsp">
							supprimer un compte
						</a>
					</li>
				</ul>
			</li>
			<li>
				<%} %>
			</li>
			<li>
				<a href="envoyerNotif.jsp">
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
								<li class="has-subnav">
				<a href="calendar.jsp">
					<i class="fa fa-file-text-o nav_icon"></i>
						<span class="nav-text">calendrier</span>
					
				</a>
			
			<li>
				<a href="faq.jsp">
					<i class="fa fa-list-ul"></i>
					<span class="nav-text">
						FAQ
					</span>
				</a>
			</li>
			
			
		</ul>
		<ul class="logout">
			<li>
			<a href="logout1">
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
				<h1><a href="index.html"><img src="pic\logoo.png" alt="" width="230px" heigh="230px"/> </a></h1>
			</div>
			<div class="full-screen">
				<section class="full-top">
					<button id="toggle"><i class="fa fa-arrows-alt" aria-hidden="true"></i></button>	
				</section>
			</div>
			<div class="w3l_search">
			
				<h4 id="bien"> <img height="20" width="20" src="pic\clock.png"> <%= new java.util.Date().toLocaleString() %>  </h4>
				</form>
			</div>
												<%@ page import="Modele.cntrlNotif"%>
<%@ page import="Modele.notification"%>
									<%cntrlNotif n=new cntrlNotif();
 utilisateur1=request.getSession();

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
									<%  int j=0;ArrayList<String> listNo=n.afficherNot(id);
									while(listNo.isEmpty()==false){%>
									<li><a href="consulterNotif.jsp">
										<div class="user_img"><img src="pic\admin1.png" alt=""></div>
									   <div class="notification_desc">
									   <%String no1=listNo.get(j); %>
										<p><%=no1.substring(0,23)%>..</p>
										
										</div>
									  <div class="clearfix"></div>	
									 </a>
									<%listNo.remove(j);} %>
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
									<li> <a href="logout1"><i class="fa fa-sign-out"></i> Logout</a> </li>
								</ul>
							</li>
						</ul>
					</div>
					<div class="clearfix"> </div>
				</div>
			</div>
			<div class="clearfix"> </div>
		</section></body>
</html>