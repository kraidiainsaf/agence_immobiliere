
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
<h4> vous pouvez nous contacter sur :</h4>                            
                                <div class="col-sm-4">
                                    <h3><img alt="" src="fb.png" height="40" width="40"> facebook </h3>
                                    <p>El keria agence immobiliere 
                                    </p>
                                </div>
                                <!-- /.col-sm-4 -->
                                <div class="col-sm-4">
                                    <h3><img alt="" src="phonne.png" height="40" width="40"> Telephone </h3>
                                    <p class="text-muted">ce numero disponible 24h</p>
                                    <p><strong>+33 555 444 333</strong></p>
                                </div>
                                <!-- /.col-sm-4 -->
                                <div class="col-sm-4">
                                    <h3><img alt="" src="gmail.png" height="40" width="40">e-mail </h3>
                                    <p class="text-muted">Vous Pouvez Communiquer avec nous par cette adress electronique :</p>
                                    <ul>
                                        <li><strong><a href="mailto:">Elkeria@gmail.com</a></strong>   </li>
                                    </ul>
                                </div>
                                 <div class="col-sm-4">
                                    <h3><img alt="" src="twitter.png" height="40" width="40"> twitter </h3>
                                    <p class="text-muted">@ELkeria agence immobiliere </p>
                                </div>
                                <br><br><br><br><br><br><br><br>     <br><br><br><br><br>     
                <h4>    vous pouvez contacter les développeurs  de ce site : groupe "INSE" :</h4>
                 
                 <div class="col-sm-4">
                                    <h3><img alt="" src="fb.png" height="40" width="40"> facebook </h3>
                                    <p>INSE website developpers
                                    </p>
                                </div>
                                <!-- /.col-sm-4 -->
                                <div class="col-sm-4">
                                    <h3><img alt="" src="phonne.png" height="40" width="40"> Telephone </h3>
                                    <p class="text-muted">ce numero disponible 24h</p>
                                    <p><strong>+213 660 12 13 15</strong></p>
                                </div>
                                <!-- /.col-sm-4 -->
                                <div class="col-sm-4">
                                    <h3><img alt="" src="gmail.png" height="40" width="40">e-mail </h3>
                                    
                                    <p class="text-muted">Vous Pouvez Communiquer avec nous par cette adress electronique :</p>
                                    <ul>
                                        <li><strong><a href="mailto:">INSE@gmail.com</a></strong>   </li>
                                    </ul>
                                </div>
                                 <div class="col-sm-4">
                                    <h3><img alt="" src="twitter.png" height="40" width="40"> twitter </h3>
                                    <p class="text-muted">@INSE website developpers </p>
                                </div>
                   <div class="col-sm-4">
                                    <img  src="sout1.png" height="150" width="150"> 
                                   
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

   <%@ include file="footer2.jsp" %>