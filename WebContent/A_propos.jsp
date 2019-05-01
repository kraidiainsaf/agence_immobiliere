
<%@page import="Modele.personne"%>
<%@page import="java.util.ArrayList"%>
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>A propos</title>
</head>
<body>
<div class="content-area recent-property padding-top-40" style="background-color: #FFF;">
            <div class="container">  
                <div class="row">
                    <div class="col-md-8 col-md-offset-2"> 
                        <div class="" id="contact1">                        
                            <div class="row">
                                                            <p><strong style="font-size: 80px;">P</strong>remier agence immobilières Alger, Rien ne remplace l’expertise immobilière de proximité de nos conseillers immobiliers qui vous guideront et vous conseilleront dans votre choix. Aussi, n’hésitez pas à les contacter pour convenir d’un rendez-vous directement dans l’agence immobilière la plus proche de chez vous.</p>
                            
                                <div class="col-sm-4">
                                    <h3><i class="fa fa-map-marker"></i> Address</h3>
                                    <p>Constantine 
                                        <br>Nouvelle ville 
                                        <br>Univ abd El hamid mehri
                                        <br>departement tlsi
                                        <strong>Alger</strong>
                                    </p>
                                </div>
                                <!-- /.col-sm-4 -->
                                <div class="col-sm-4">
                                    <h3><i class="fa fa-phone"></i> Numero de Telephone </h3>
                                    <p class="text-muted">ce numero disponible 24h</p>
                                    <p><strong>+33 555 444 333</strong></p>
                                </div>
                                <!-- /.col-sm-4 -->
                                <div class="col-sm-4">
                                    <h3><i class="fa fa-envelope"></i> support electronique</h3>
                                    <p class="text-muted">Vous Pouvez Communiquer avec nous par cette adress electronique :</p>
                                    <ul>
                                        <li><strong><a href="mailto:">Elkeria@gmail.com</a></strong>   </li>
                                    </ul>
                                </div>
                                 <div class="col-sm-4">
                                    <h3><img alt="" src="first.png"> Premier location </h3>
                                    <p class="text-muted">Moment clé de votre vie, un premier achat immobilier se prépare! Toutes les étapes pour mener à bien votre projet.</p>
                                </div>
                               
                             <div class="col-sm-4">
                                    <h3><img alt="" src="expert.png"> Une expertise locale </h3>
                                    <p class="text-muted">Les conseillers immobiliers El Keria sont des experts de proximité avec une connaissance approfondie du marché local.
                                    </p>
                                </div>
                                
                                
                                 <div class="col-sm-4">
                                    <h3><img src="estim.png"> Un estimateur en ligne </h3>
                                    <p class="text-muted">El Keria a mis au point des outils fiables et efficaces, permettant d’estimer la valeur de son bien.
                                    
                                    </p>
                                </div>
                            </div>
                            <!-- /.row -->
                            <hr>
                           
                        </div>
                    </div>    
                </div>
            </div>
        </div>
         <script src="assets/js/modernizr-2.6.2.min.js"></script>

        <script src="assets/js/jquery-1.10.2.min.js"></script> 
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/js/bootstrap-select.min.js"></script>
        <script src="assets/js/bootstrap-hover-dropdown.js"></script>

        <script src="assets/js/easypiechart.min.js"></script>
        <script src="assets/js/jquery.easypiechart.min.js"></script>

        <script src="assets/js/owl.carousel.min.js"></script>
        <script src="assets/js/wow.js"></script>

        <script src="assets/js/icheck.min.js"></script>
        <script src="assets/js/price-range.js"></script>
        
        <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&amp;sensor=false"></script>
        <script src="assets/js/gmaps.js"></script>        
        <script src="assets/js/gmaps.init.js"></script>

        <script src="assets/js/main.js"></script>
</body>
</html>