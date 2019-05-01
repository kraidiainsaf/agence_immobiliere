
<%if(session.getAttribute("id_personne")==null){%>
 <%@ include file="header2.jsp" %>

<%}else{ %>
<%@page import="Modele.cntrlAuthentif" %>
<%int id=(int)session.getAttribute("id_personne"); %>
<% cntrlAuthentif obj=new cntrlAuthentif(); %>

<%if(obj.isLocataire(id)&&obj.isProprietaire(id)){%>
	<%@ include file="header_proprietaire_locataire.jsp" %>
<% }else{%>
<% if(obj.isProprietaire(id)){%>
	<%@ include file="header_proprietaire.jsp" %>
	
<% 
}else{ %>
 <%@ include file="header_locataire.jsp" %>
 <%}} }%> 
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Rechercher Maison</title>
        <meta name="description" content="company is a real-estate template">
        <meta name="author" content="Kimarotec">
        <meta name="keyword" content="html5, css, bootstrap, property, real-estate theme , bootstrap template">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,700,800' rel='stylesheet' type='text/css'>

        <!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
        <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <link rel="icon" href="favicon.ico" type="image/x-icon">

        <link rel="stylesheet" href="assets/css/normalize.css">
        <link rel="stylesheet" href="assets/css/font-awesome.min.css">
        <link rel="stylesheet" href="assets/css/fontello.css">
        <link href="assets/fonts/icon-7-stroke/css/pe-icon-7-stroke.css" rel="stylesheet">
        <link href="assets/fonts/icon-7-stroke/css/helper.css" rel="stylesheet">
        <link href="assets/css/animate.css" rel="stylesheet" media="screen">
        <link rel="stylesheet" href="assets/css/bootstrap-select.min.css"> 
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/icheck.min_all.css">
        <link rel="stylesheet" href="assets/css/price-range.css">
        <link rel="stylesheet" href="assets/css/owl.carousel.css">  
        <link rel="stylesheet" href="assets/css/owl.theme.css">
        <link rel="stylesheet" href="assets/css/owl.transitions.css">
        <link rel="stylesheet" href="assets/css/lightslider.min.css">
        <link rel="stylesheet" href="assets/css/style.css">
        <link rel="stylesheet" href="assets/css/responsive.css">
        <style type="text/css">
        table , th,td{
	border: 1px solid #F4C543;
	margin-left: 30px;
	padding: 5px;
	text-align: center;
}
        </style>
    </head>
    <body>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="javax.swing.text.DateFormatter"%>
<%@page import="java.time.ZonedDateTime"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modele.maison" %>
<%@page import="Modele.operation" %>
<%@page import="Modele.personne" %>
<%operation op =new operation(); %>
  <%@page import="Modele.commentaire" %>
  <%@page import="Modele.location" %>
<%ArrayList<location> listl=null;%>
<%ArrayList<commentaire> listc=null;%>
<%maison m=null;%>
<%if(session.getAttribute("id_proprietaire")==null){
	   RequestDispatcher DL =request.getRequestDispatcher("agence_immobiliere.jsp");
		DL.forward(request,response);
	   
   } %>
<%int id_proprietaire=(int)session.getAttribute("id_proprietaire");%>
<%personne p=op.GetPersonneinfo(id_proprietaire); %>
<% m=(maison)session.getAttribute("maison");%>

      <%String jardin; %>
      <%if(m.getJardin()==true){
    	   jardin="oui";
      }else{
    	  jardin="non";

      } %>     
      
       <%String parking; %>
      <%if(m.getParking()==true){
    	   parking="oui";
      }else{
    	  parking="non";

      } %>     
      
      <%int max_colocataire=m.getMax_colocataire(); %>
     

        <!-- property area -->
        <div class="content-area single-property" style="background-color: #FCFCFC;">&nbsp;
            <div class="container">   

                <div class="clearfix padding-top-40"  >

                    <div class="col-md-8 single-property-content prp-style-1 " style="background-color:#fdfdfc;">
                        <div class="row">
                            <div class="light-slide-item">            
                                <div class="clearfix">
                                    <div class="favorite-and-print">
                                        <a class="add-to-fav" href="#login-modal" data-toggle="modal">
                                            <i class="fa fa-star-o"></i>
                                        </a>
                                        <a class="printer-icon " href="javascript:window.print()">
                                            <i class="fa fa-print"></i> 
                                        </a>
                                    </div> 

                                    <ul id="image-gallery" class="gallery list-unstyled cS-hidden">
                                        <li data-thumb="<%=m.getImage1()%>"> 
                                            <img src="<%=m.getImage1()%>" />
                                        </li>
                                        <li data-thumb="<%=m.getImage2()%>"> 
                                            <img src="<%=m.getImage2()%>" />
                                        </li>
                                        <li data-thumb="<%=m.getImage3()%>"> 
                                            <img src="<%=m.getImage3()%>" />
                                        </li>
                                        <li data-thumb="<%=m.getImage4()%>"> 
                                            <img src="<%=m.getImage4()%>" />
                                        </li>          
                                         <li data-thumb="<%=m.getImage5()%>"> 
                                            <img src="<%=m.getImage5()%>" />
                                        </li>                                
                                    </ul>
                                </div>
                            </div>
                        </div>

                        <div class="single-property-wrapper">
                            <div class="single-property-header">                      
                          
                                <span class="property-price pull-right"> Prix :<%=m.getPrix()%><b class="property-info-unit">DA</b></span><br><br>
                                
                                <form action="Verifier2" >    
                                <span class="property-price pull-right">  
                <input type="submit" name="submit" value="louer ce bien" ></span>
                </form>
                                
                            </div>

                            <div class="property-meta entry-meta clearfix ">   

                                <div class="col-xs-6 col-sm-3 col-md-3 p-b-15">
                                    <span class="property-info-icon icon-tag">                                        
                                        <img width="30px" height="30px" src="position.png">
                                    </span>
                                    <span class="property-info-entry">
                                        <span class="property-info-label"> Adresse</span>
                                        <span class="property-info-value"><%=m.getAdresse()%></span>
                                    </span>
                                </div>
<div class="col-xs-6 col-sm-3 col-md-3 p-b-15">
                                    <span class="property-info icon-area">
                                        <img width="30px" height="30px"  src="adress.png">
                                    </span>
                                    <span class="property-info-entry">
                                        <span class="property-info-label"> Wilaya</span>
                                        <span class="property-info-value"> <%=m.getWilaya()%></span>
                                    </span>
                                </div>
  <div class="col-xs-6 col-sm-3 col-md-3 p-b-15">
                                    <span class="property-info-icon icon-bed">
                                        <img width="30px" height="30px"  src="seperficie2.png">
                                    </span>
                                    <span class="property-info-entry">
                                        <span class="property-info-label"> Superficie</span>
                                        <span class="property-info-value"><%=m.getSuperficie()%><b class="property-info-unit">M2</b></span>
                                    </span>
                                </div>
                                 <div class="col-xs-6 col-sm-3 col-md-3 p-b-15">
                                    <span class="property-info-icon icon-bed">
                                        <img width="30px" height="30px"  src="parking.png">
                                    </span>
                                    <span class="property-info-entry"> 
                                        <span class="property-info-label"> Parking</span>
                                        <span class="property-info-value"><%=parking%></span>
                                    </span>
                                </div>

                                <div class="col-xs-6 col-sm-3 col-md-3 p-b-15">
                                    <span class="property-info-icon icon-bath">
                                        <img  width="30px" height="30px"  src="jardin.png">
                                    </span>
                                    <span class="property-info-entry">
                                        <span class="property-info-label"> jardin</span>
                                        <span class="property-info-value"><%=jardin%></span>
                                    </span>
                                </div>

                           
                                
                                <div class="col-xs-6 col-sm-3 col-md-3 p-b-15">
                                    <span class="property-info-icon icon-garage">
                                        <img width="30px" height="30px"  src="locataire.png">
                                    </span>
                                    <span class="property-info-entry">
                                        <span class="property-info-label"> Max locataire:</span>
                                        <span class="property-info-value"><%=m.getMax_colocataire()%></span>
                                    </span>
                                </div>


                             <div class="col-xs-6 col-sm-3 col-md-3 p-b-15">
                                    <span class="property-info-icon icon-garage">
                                        <img width="30px" height="30px"  src="facade.png">
                                    </span>
                                    <span class="property-info-entry">
                                        <span class="property-info-label"> Nombre du chambre:</span>
                                        <span class="property-info-value"><%=m.getNbr_chambre()%></span>
                                    </span>
                                </div>
                                
                                <div class="col-xs-6 col-sm-3 col-md-3 p-b-15">
                                    <span class="property-info-icon icon-garage">
                                        <img width="30px" height="30px"  src="chambre.png">
                                    </span>
                                    <span class="property-info-entry">
                                        <span class="property-info-label"> Nombre du facade:</span>
                                        <span class="property-info-value"><%=m.getNbr_facade() %></span>
                                    </span>
                                </div></div>
                                     <div class="section">
                                <h4 class="s-property-title"> Description</h4>
                                <div class="s-property-content">
                                    <p><%=m.getdescription() %></p>
                                </div>
                        
                           </div>
                               <div class="section">
                                <h4 class="s-property-title"> Planning</h4>
                                <div class="s-property-content">
                                  <%listl=(ArrayList<location>)session.getAttribute("listl");int co=1;%>
                                   <%if(listl.isEmpty()){ %>
 <h6 style="text-align: center;" ><img width="40px" height="40px" src="vide.png"> pas des locations Approuve a ce bien </h6>
 <%}else{ %>
   <table >
                                   <thead>	
    <tr>
        <th >Numero </th>
        <th >Debut </th>
        <th >Fin </th>
        <th >Etat </th>
        <th >Colocation Actuel </th>
        <th >Colocation Restant </th>
       
    </tr>
  </thead>
<%for(int i=0;i<listl.size();i++){
	
	location l=listl.get(i);%>
                          <tbody>
     <tr >
   <td><%=co %></td>
      <td><%=l.getDate_debut() %></td>
      <td><%=l.getDate_fin()%></td>
      <td><%=l.getEtat_location()%></td>
      <%int nbr_location_dans_ce_date=op.nbr_locataire_exist(l.getId_bien(),l.getDate_debut(),l.getDate_fin());%>
        <%int rest=max_colocataire-nbr_location_dans_ce_date;%>
  
     <%if(rest<0){ %>
      <td><%=nbr_location_dans_ce_date+rest %></td>
       <td><%=rest-rest%></td> 
       <%}else{ %>
        <td><%=nbr_location_dans_ce_date %></td>
       <td><%=rest%></td> 
       <%} %>
      </tr>
<%co++;} %>
  </tbody>          
                                   </table>
                               <%} %>    
                                </div>
                        
                           </div>
                             <div class="section">
                                <h4 class="s-property-title">Commentaire</h4>
                                <div class="s-property-content">
                                <%listc=(ArrayList<commentaire>)session.getAttribute("listc");%>
                                
                                <%if(listc.isEmpty()){ %>
 <h6 style="text-align: center;" ><img width="40px" height="40px" src="vide.png"> Il n'y a pas encore des commentaires </h6>
 <%} %>
   
<%for(int j=0;j<listc.size();j++){
	commentaire c=listc.get(j);%>
	<div style="align-content:flex-start; ">
     <div style="background-color: #e8e3e3;width:500px; border-radius:12px;"> 
     <img width="60px" height="60px" src="visiteur.png"><br>
      <strong style="margin-left: 15px;"> <%=c.getNom_ecri() %></strong>
      <%=c.getContenue() %></div>
    </div>
    <br>
<%} %>
<br>
<br>
 <h4 style="color: #F4C543;">Laisser un commentaire</h4>
Les champs obligatoires sont indiques avec *
<form action="AjouterCommentaireServlet" method="get">
<label>Quel est votre nom ? *
</label><br>
<input type="text" name="nom_ecri" value="inconnu" style="background-color:#e8e3e3;width: 300px; " ><br>
<label>Que souhaitez-vous dire ? *</label>
<input type="text" name="contenue" value="bon prix" style="background-color:#e8e3e3;height:200px;" >
<%session.setAttribute("id_bien_louer",m.getId_bien()); %>
<br><br>
<input type="submit" name="submit" value="Laisser un commentaire" style="border:1px solid #F4C543;">

</form>
         
                 </div></div></div></div>
                   <div class="col-md-4 p0">
                        <aside class="sidebar sidebar-property blog-asside-right" style="align-content: right ">
                            <div class="dealer-widget">
                                <div class="dealer-content">
                                    <div class="inner-wrapper">

                                        <div class="clear">
                                            <div class="col-xs-4 col-sm-4 dealer-face">
                                                <a href="">
                                                    <img src="assets/img/client-face1.png" class="img-circle">
                                                </a>
                                            </div>
                                            <div class="col-xs-8 col-sm-8 ">
                                                <h3 class="dealer-name">
                                                    <h2><%=p.getNom() %> <%=p.getPrenom() %></h2>
                                                    <span> Proprietaire </span>        
                                                </h3>
                                                <div class="dealer-social-media">
                                                    <a class="twitter" target="_blank" href="">
                                                        <i class="fa fa-twitter"></i>
                                                    </a>
                                                    <a class="facebook" target="_blank" href="">
                                                        <i class="fa fa-facebook"></i>
                                                    </a>
                                                    <a class="gplus" target="_blank" href="">
                                                        <i class="fa fa-google-plus"></i>
                                                    </a>
                                                    <a class="linkedin" target="_blank" href="">
                                                        <i class="fa fa-linkedin"></i>
                                                    </a> 
                                                    <a class="instagram" target="_blank" href="">
                                                        <i class="fa fa-instagram"></i>
                                                    </a>       
                                                </div>

                                            </div>
                                        </div>

                                        <div class="clear">
                                            <ul class="dealer-contacts">                                       
                                              
                                                <li><i class="pe-7s-mail strong"> </i><%=p.getEmail() %></li>
                                                <li><i class="pe-7s-call strong"> </i><%=p.getNum_telephone() %></li>
                                            </ul>
                                         
                                        </div>

                                    </div>
                                </div>
                            </div>

                            <div class="panel panel-default sidebar-menu similar-property-wdg wow fadeInRight animated">
                                <div class="panel-heading">
                                    <h3 class="panel-title"> Nouveau dans la famille </h3>
                                </div>
                                <div class="panel-body recent-property-widget">
                                        <ul>
                                        
                                        <% ArrayList<maison> l=op.NewsMaison(); 
                                        for(int t=0;t<l.size();t++){ 
                                        maison tt=l.get(t);
                                        %>
                                        	
                                        <li>
                                            <div class="col-md-3 col-sm-3 col-xs-3 blg-thumb p0">
                                                <a href="single.html"><img src="<%=tt.getImage1() %>"></a>
                                                <span class="property-seeker">
                                                    <b class="b-1">Nouveau</b>
                                                </span>
                                            </div>
                                            <div class="col-md-8 col-sm-8 col-xs-8 blg-entry">
                                                <h6> <a href="#"> <%=tt.getPrix() %> DA</a></h6>
                                           <span class="property-price"><%=tt.getSuperficie() %> Mettre</span>
                                           <span class="property-price"><%=tt.getWilaya() %></span>
                                                
                                            </div>
                                        </li>
                                        
                                          <% }%>
                                        
                                    </ul>
                                </div>
                            </div>                          





                            <div class="panel panel-default sidebar-menu wow fadeInRight animated" style="height:100%;">
                                <div class="panel-heading">
                                    <h3 class="panel-title">Notre Application Mobile !  click ici !</h3>
                                </div>
                                <div class="panel-body recent-property-widget">
                                    <img style="width:500px;height: 500px;" src="app_mobile.png">
                                </div>
                            </div>

                           
                   

                        </aside>
                    </div>
                 
                 
                 
                 
                 </div></div></div>
                         
           <%@ include file="footer2.jsp" %>