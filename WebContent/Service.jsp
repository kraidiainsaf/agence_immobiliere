
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
                               <img width="100px;" height="100px;"  src="service_off.png">                     
                        <br>
                        <h2>Nos Services: </h2>
                        <h4>l'agence immobiliere 'EL Keria' vous propose un ensembles des services int�ressants vous trouver dans cet article une breve description 
de ces services:</h4>
<p>les principaux services offerts par notre agence son:</p>
<h4><img alt="" src="rech.png" height="40" width="40"> - la recherche des biens: </h4>
<p> est tr�s pratique et ne n�cessite que de remplir quelques crit�res pour faciliter la recherche et obtenir des r�sultats bien pr�cis.</p>
<h4><img alt="" src="add.png" height="40" width="40"> - la proposition des biens: </h4>
<p>A partir du site web ou l'application mobile 'EL Keria'
 vous pouver proposer vos biens pour qu'ils soit consult�s et lou�s  par les visiteurs du site ou l'application et  vous ne perder pas votre temps a rechercher des locataires ou de n�gocier avec ces derniers
 vous n'avez qu'ajouter votre bien a partir du site ou l'application et de pr�senter les documents n�cessaires � l'agence. </p>
 <h4><img alt="" src="rent.png" height="40" width="40">- La location des biens : </h4>
 <p>  Avec l'agence 'EL Keria' la location est tr�s facile vous pouvez a tous moments rechercher un bien ,consulter son planning de location et les commentaires sur ce bien, et si vous voulez le louer c'est tr�s facile vous n'avez qu'a suivit la 
 proc�dure de location  et obtenir votre contrat de location et la facture selon le mode de payement que vous voulez choisir puis acc�der au payement.</p>
 
                        <br>
                    </div>
                </div>
                                          
                

                <div class="row row-feat"> 
                    <div class="col-md-12">
 
                      

                    </div>
                </div>
                
            </div>
        </div>
 
 
 
 
   <%@ include file="footer2.jsp" %>