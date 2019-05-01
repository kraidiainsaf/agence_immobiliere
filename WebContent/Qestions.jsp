
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
 
 
 <div class="content-area recent-property" style="background-color: #FCFCFC; padding-bottom: 55px;">
            <div class="container">    

                <div class="row">
                    <div class="col-md-10 col-md-offset-1 col-sm-12 text-center page-title">
                        <!-- /.feature title -->
                               <img width="100px;" height="100px;"  src="qst.png">                     
                        <br>
                        <h2>Questions </h2>
                        <br>
                    </div>
                </div>
                                          
                
<h4>Si vous n'arrivez pas a comprendre le principe du site ou comment réaliser une fonctinnalitée ce volet permet 
de vous expliquer comment réaliser quelques fonctionnalitées dans le site.</h4>
<br><br>
                <div class="row row-feat"> 
                    <div class="col-md-12">
 
                        <div class="col-sm-6 feat-list">
                            <div class="panel-group">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                         <h4  data-toggle="collapse" data-target="#fqa11" >
                                         <img width="25px;" height="25;"  src="ser.png">
                                           Comment rechercher un bien ? 
                                         </h4> 
                                    </div>
                                    <div id="fqa11" class="panel-collapse collapse fqa-body">
                                        <div class="panel-body">
                                            <ol>
                                                <li> Aller dans la page d'accueil du site en bas vous trouvez un ensemble des icons qui caractérise les types des biens disponibles
dans le site ,choisissez un type en cliquant sur l'icon correspondante ,un formulaire de recherche s'affiche 
, remplissez ce fomulaire on choisissant votre caractéristiques de recherche puis validez pour voir 
le résultat de la recherche , maintenant vous pouvez consulter les biens proposés ,ajouter des commentaires,
et meme effectuer des locations.</li>
                                                                                      
                                            </ol> 
                                        </div> 
                                    </div>
                                </div>
                            </div>
                            
                            <div class="panel-group">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h4  data-toggle="collapse" data-target="#fqa22" >
                                         <img width="25px;" height="25;"  src="ser2.png">
                                            Comment effectuer une location ? 
                                         </h4> 
                                    </div>
                                    <div id="fqa22" class="panel-collapse collapse fqa-body">
                                        <div class="panel-body">
                                            <ol>
                                                <li> pour effecture une location aprés la recherche  il y a deux possibilitées: soit à partir de votre espace locataire si vous avez un compte
,soit à partir de la page d'accueil dans le premier cas vous aller remplir directement le formulaire de location
mais dans le deuxiem vous aller accéder à l'authentification d'abord et si vous n'avez pas un compte déja vous pouvez
le créer on choisissant l'option créer compte du fomulaire d'authentification aprés vous pouvez remplir le formulaire de location.</p>
<p>Maintenant si les dates de location sont valides vous devez consulter votre contrat de location et votre facture et les acceptés pour valider
la location , cette location reste en attente jusqu'à ce que vous payer les frais de location au niveau de l'agence et récupérer les clés.</li>
                                                                                      
                                            </ol> 
                                        </div> 
                                    </div>
                                </div>
                            </div>
                            
                            <div class="panel-group">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                         <h4  data-toggle="collapse" data-target="#fqa33" >
                                         <img width="25px;" height="25;"   src="ser3.png">
                                            Comment ajouter un bien ?
                                         </h4> 
                                    </div>
                                    <div id="fqa33" class="panel-collapse collapse fqa-body">
                                        <div class="panel-body">
                                            <ol>
                                                <li> Vous pouvez ajouter un bien à partir de la page d'accueil on cliquant sur 'ajouter votre bien' ou à partir de votre espace personnel en tout cas vous allez choisir le type de bien à ajouter
puis remplir le formulaire d'ajout et suivez les étapes de création du contrat pour la validée aprés , le bien reste en attente et ne sera pas visible pour les visiteurs du site
tantque vous n'avez pas déposés les documents de propriété et les photos du bien dans l'agence pour que 
les administrateurs puissent approuver votre bien et il sera visible pour les visiteur.</li>
                                                                                         
                                            </ol> 
                                        </div> 
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6 feat-list">
                            <div class="panel-group">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                         <h4  data-toggle="collapse" data-target="#fqa12" >
                                         <img width="25px;" height="25;" src="ser4.png">
                                            Comment consulter mes biens ou mes locations?
                                         </h4> 
                                    </div>
                                    <div id="fqa12" class="panel-collapse collapse fqa-body">
                                        <div class="panel-body">
                                            <ol>
                                                <li>Pour consulter vos biens proposés leurs plannings et les commentaires de chaque bien c'est trés simple dans le menu de 
 votre espace vous avez l'option ' mes biens ' vous cliquez au dessus une  qui contient tous vos biens s'affiche et vous pouvez faire ce que vous voulez.
  <p><strong>Pour les locations </strong> c'est la meme chose que les biens mais vous choisissez l'option ' mes location '.</p>
 </li>
                                                                                        
                                            </ol> 
                                        </div> 
                                    </div>
                                </div>
                            </div>
                            
                            
                           
                        </div>

                    </div>
                </div>
                
            </div>
        </div>
 
  <%@ include file="footer2.jsp" %>