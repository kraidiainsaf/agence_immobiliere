 <%
	       response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	       response.addHeader("Cache-Control", "post-check=0, pre-check=0");
	       response.setHeader("Pragma", "no-cache");
	       response.setDateHeader("Expires", 0);
    
if(session.getAttribute("id_personne")==null){
	RequestDispatcher DL =request.getRequestDispatcher("authentifg");
DL.forward(request,response);}
	%>  
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Vos Contart</title>
<style type="text/css">

#contenu{
text-align:center;
width:100%;
}

#liste{
text-align:left;
width:100%;
}
</style>
</head>
<body>
<%if(session.getAttribute("adresse").equals("reply")){
	response.sendRedirect("AjouterBien.jsp");
} %>
<%@page import="Modele.operation" %>
<%operation op=new operation(); %>
<div id="fond">
<div id="contenu">
<img  src="base.png">
<h1>CONTRAT        DE         LOCATION  </h1>
<img width="500" height="50" src="sous_base.png">
<br><br>
<img width="90" height="50" src="m.png">
<p align="center">
<b>Le présent contrat est conclu entre les soussignés : </b>
<%int id_proprietaire=(int)session.getAttribute("id_personne"); %>
- Nom et prénom de propriétaire, ou dénomination du bailleur :<%=op.GetNamePersonne(id_proprietaire) %><br>
- numero cart identité N°:<%=op.GetNumCart(id_proprietaire) %><br>
- Nom et prénom du locataire :............................<br>
- Numero cart identité N°:................................<br>
<h2><i><u><img height="40" width="40" align="top" src="titre.png">  Des informations sur le bien  :</u></i></h2>
<%if(session.getAttribute("typebien").equals("maison")){ %>
     C'est un bien de type <%=session.getAttribute("typebien")%>,construit :<%=(String)session.getAttribute("ajoute4")%><br>
avec une  superficié de <%=(double)session.getAttribute("superficie")%>  <sub> métre carré</sub> et un prix de <%=(double)session.getAttribute("prix")%>  <sub>DA</sub>
par jour , admis <%=(int)session.getAttribute("max_colocataire")%>  <sub>locataire/s</sub> a la fois ,ce <%=session.getAttribute("typebien") %> est localisé a :<%=(String)session.getAttribute("adresse")%> , 
Le <%=(String)session.getAttribute("ajoute1")%><br>
Si le locataire  de ce bien retarde le paiement il doit rembourcer:<%=(String)session.getAttribute("ajoute2")%><br>
Chaque mois le loyer sera payable(le cas du mode paiement est mensuel) :<%=(String)session.getAttribute("ajoute3")%><br>
   <img align="top" width="20" height="20" src="facade.png">  Nombre chambre est :<%=(int)session.getAttribute("nbr_chambre")%> chambre/s <br>
   <img align="top" width="20" height="20"src="chambre.png">  Nombre facade est :<%=(int)session.getAttribute("nbr_facade")%> facade/s<br>
 <%String jardin; %>
      <%if((Boolean)session.getAttribute("jardin")==true){
    	   jardin="Oui";
      }else{
    	  jardin="Non";

      } %>     
       <%String parking; %>
      <%if((Boolean)session.getAttribute("parking")==true){
    	   parking="Oui";
      }else{
    	  parking="Non";

      } %>     
      
     <img align="top" width="20" height="20" src="jardin.png">  Jardin : <%=jardin%><br>
     <img align="top" width="20" height="20" src="parking.png"> Parking :<%=parking%><br>
 <%} %>
 <%if(session.getAttribute("typebien").equals("appartement")){ %>
C'est un bien de type <%=session.getAttribute("typebien")%>, construit :<%=(String)session.getAttribute("ajoute4")%><br>,
avec une superficié de <%=(double)session.getAttribute("superficie")%> <sub>  métre carré</sub>,et un prix de <%=(double)session.getAttribute("prix")%> <sub> DA</sub>
par jour , admis <%=(int)session.getAttribute("max_colocataire")%> <sub>  locataire/s</sub> a la fois ,ce/cette <%=session.getAttribute("typebien") %> est localisé a :<%=(String)session.getAttribute("adresse")%> , 
Le <%=(String)session.getAttribute("ajoute1")%><br>
Si le locataire  de ce bien  retarde le paiement il doit rembourcer:<%=(String)session.getAttribute("ajoute2")%><br>
Chaque mois le loyer sera payable(le cas du mode paiement est mensuel) :<%=(String)session.getAttribute("ajoute3")%><br>
  <img width="20px" height="20px" align="top" src="facade.png">Nombre chambre est :<%=(int)session.getAttribute("nbr_chambre")%>chambre/s <br>
  <img width="20px" height="20px" align="top" src="etage.png"> Etage  :<%=(int)session.getAttribute("etage")%>etage/s<br>
 <%} %>
 
 <%if(session.getAttribute("typebien").equals("depot")){ %>
C'est un bien de type <%=session.getAttribute("typebien")%>,construit  :<%=(String)session.getAttribute("ajoute4")%><br>
avec une  superficié de <%=(double)session.getAttribute("superficie")%>  <sub>  métre carré</sub> ,et un prix de <%=(double)session.getAttribute("prix")%>  <sub> DA</sub>
par jour , admis <%=(int)session.getAttribute("max_colocataire")%>  <sub>  locataire/s</sub> a la fois ,ce/cette <%=session.getAttribute("typebien") %> est localisé a :<%=(String)session.getAttribute("adresse")%> , 
Le <%=(String)session.getAttribute("ajoute1")%><br>
Si le locataire  de ce bien retarde le paiement  il doit rembourcer:<%=(String)session.getAttribute("ajoute2")%><br>
Chaque mois le loyer sera payable(le cas du mode paiement est mensuel) :<%=(String)session.getAttribute("ajoute3")%><br>
     <img width="20px" height="20px" align="top" src="box.png"> Capacite de Stockage est :<%=(int)session.getAttribute("capacite_stockage")%><sub> boites</sub> <br>
     <img width="20px" height="20px" align="top" src="depot.png"> Type   :<%=(String)session.getAttribute("type")%><br>
 <%} %>
 
  <%if(session.getAttribute("typebien").equals("garage")){ %>
C'est un bien de type <%=session.getAttribute("typebien")%>,construit  :<%=(String)session.getAttribute("ajoute4")%><br>,
avec une  superficié de <%=(double)session.getAttribute("superficie")%>  <sub>  métre carré</sub> ,et un prix de <%=(double)session.getAttribute("prix")%> <sub> DA</sub>
par jour , admis <%=(int)session.getAttribute("max_colocataire")%> <sub>  locataire/s</sub> a la fois ,ce/cette <%=session.getAttribute("typebien") %> est localisé a :<%=(String)session.getAttribute("adresse")%> , 
Le <%=(String)session.getAttribute("ajoute1")%><br>
Si le locataire  de ce bien retarde le paiement il doit rembourcer:<%=(String)session.getAttribute("ajoute2")%><br>
Chaque mois le loyer sera payable(le cas du mode paiement est mensuel) :<%=(String)session.getAttribute("ajoute3")%><br>
   <img width="20px" height="20px" align="top" src="garage.png">  Capacite de Vehicule est :<%=(int)session.getAttribute("capacite_vehicule")%><sub> vehicule/s</sub><br>
 <%} %>
 <%if(session.getAttribute("typebien").equals("locale_commercial")){ %>
  C'est un bien de type <%=session.getAttribute("typebien")%>,construit  :<%=(String)session.getAttribute("ajoute4")%><br>,
avec une  superficié de <%=(double)session.getAttribute("superficie")%>  <sub>  métre carré</sub> ,et un prix de <%=(double)session.getAttribute("prix")%>  <sub> DA</sub>
par jour , admis <%=(int)session.getAttribute("max_colocataire")%>  <sub>  locataire/s</sub> a la fois ,ce/cette <%=session.getAttribute("typebien") %> est localisé a :<%=(String)session.getAttribute("adresse")%> , 
Le <%=(String)session.getAttribute("ajoute1")%><br>
Si le locataire  de ce bien retarde le paiement il doit rembourcer:<%=(String)session.getAttribute("ajoute2")%><br>
Chaque mois le loyer sera payable(le cas du mode paiement est mensuel) :<%=(String)session.getAttribute("ajoute3")%><br>
     <img width="20px" height="20px"  align="top" src="dis.png"> Distance centre  est :<%=(double)session.getAttribute("distance_centre")%><sub> m</sub><br>
     <img width="20px" height="20px"  align="top" src="doct.png"> Type Locale est :<%=(String)session.getAttribute("type_local")%><br>
 <%} %>
 <%if(session.getAttribute("typebien").equals("terrain")){ %>
  C'est un bien de type <%=session.getAttribute("typebien")%>,construit  :<%=(String)session.getAttribute("ajoute4")%><br>,
avec une  superficié de <%=(double)session.getAttribute("superficie")%>  <sub>  métre carré</sub> ,et un prix de <%=(double)session.getAttribute("prix")%>  <sub> DA</sub>
par jour , admis <%=(int)session.getAttribute("max_colocataire")%>  <sub>  locataire/s</sub> a la fois ,ce/cette <%=session.getAttribute("typebien") %> est localisé a :<%=(String)session.getAttribute("adresse")%> , 
Le <%=(String)session.getAttribute("ajoute1")%><br>
Si le locataire  de ce bien retarde le paiement il doit rembourcer:<%=(String)session.getAttribute("ajoute2")%><br>
Chaque mois le loyer sera payable(le cas du mode paiement est mensuel) :<%=(String)session.getAttribute("ajoute3")%><br>
     <img width="20px" height="20px" align="top" src="dis.png"> caracteristique:<%=(String)session.getAttribute("caracteristique")%><br>
 <%} %>

<h2><i><u><img height="40" width="40" align="top" src="titre.png">  Les droits et obligations des locataires et des propriétaires  :</u></i></h2><br>
<h2><i><u><img height="25" width="25" align="top" src="cri.png">  Les obligations du locataire  :</u></i></h2>
    <img height="20" width="20" align="top" src="1.png"> Payer son loyer dans les délais prévus au contrat de location<br>
    <img height="20" width="20" align="top" src="2.png"> Payer les charges :
        <br>- Les charges locatives sont les charges liées à l'immeuble : ascenseur, entretien des espaces verts, gardiens, ménage des parties communes,…. etc. Elles sont payées à un représentant des copropriétaires, de façon forfaitaire, au prorata du nombre d'appartements dans l'immeuble. En contre partie, le locataire reçoit un justificatif de paiement.
        <br>- La taxe d'enlèvement des ordures ménagères : elle est annuelle et à la charge du locataire (plus d'information ici)
        <br>- La taxe d'habitation au titre des services de l'APC : cette taxe est payée via la facture d'électricité.
        <br>- Le tarif d'assainissement via la facture d'eau.
        <br>- L'électricité, l'eau et le gaz : le contrat le prévoit expressément.<br>
    <img height="20" width="20" align="top" src="3.png"> Entretenir le logement en « bon père de famille ».<br>
    <img height="20" width="20" align="top" src="4.png"> Le locataire doit veiller à maintenir en bon état les sols, les appareils sanitaires, réparer au fil du temps les petits dégâts inévitables, …etc. Il doit faire les petites réparations urgentes ;<br>
    <img height="20" width="20" align="top" src="5.png"> Il ne peut pas apporter de modifications au logement (suppression d'un mur, véranda,… etc.) sans l'accord préalable du propriétaire, s'il le fait, il sera obligé de remettre les lieux dans leur état initial et à sa charge.<br>
    <img height="20" width="20" align="top" src="6.png"> Remettre le logement en état en fin de bail : le locataire n'a pas à remettre en état tout ce qui relève de l'état d'usage du logement : rayures normales sur le sol, peintures défraichies, …etc. En revanche, il doit réparer les dégradations anormales. Soit il procède lui-même aux réparations, soit le montant de ces réparations est prélevé sur la caution.<br>
    <img height="20" width="20" align="top" src="7.png"> Le locataire n'a pas le droit de sous-louer le logement, sauf autorisation expresse du bailleur ou clause prévue au bail.
<br><br>
<div id="nb"  style="border:2px double red;background-color:geray;" >
<img height="20" width="20" align="bottom" src="nb1.png"><b> A noter</b> :<br> l'assurance habitation (MRH) , n'est pas obligatoire et n'est pas toujours imposée dans le bail. C'est un risque important pour le locataire et ses biens et pour le logement lui-même.
</div> <br>
<h2><i><u><img height="25" width="25" align="top" src="cri.png">  Les obligations du propriétaire  :</u></i></h2>
<img height="20" width="20" align="top" src="1.png"> Livrer le bien en bon état ;<br>
<img height="20" width="20" align="top" src="2.png"> Payer la taxe foncière ( plus d'info ),<br>
<img height="20" width="20" align="top" src="3.png"> Souscrire une assurance catastrophes naturelles (plus d'info) ;<br>
<img height="20" width="20" align="top" src="4.png"> Faire les réparations importantes telles que l'étanchéité, l'entretien des conduites d'écoulement des eaux, la chaudière, les appareils sanitaires, ….etc.<br>
<img height="20" width="20" align="top" src="6.png"> Ne pas troubler le locataire dans la jouissance du bien loué : le locataire est chez lui, le propriétaire n'a pas le droit d'avoir les clés ou d'entrer dans son accord et, s'il doit faire des réparations importantes pour conserver le bien qui gênent le locataire, il doit dédommager ou accepter la résiliation du bail.<br>
<img height="20" width="20" align="top" src="7.png"> <%=(String)session.getAttribute("ajoute5")%><br>
<h2><i><u><img height="25" width="25" align="top" src="cri.png">  Fin du bail  :</u></i></h2>
<img height="20" width="20" align="top" src="1.png"> Le bail est toujours à durée déterminée.<br>
<img height="20" width="20" align="top" src="2.png"> La fin du bail arrive normalement à l'échéance du contrat puisque le bail est maintenant obligatoirement à durée déterminée. En effet, suite aux difficultés rencontrées par les propriétaires pour récupérer leur bien, la loi impose désormais une durée déterminée.<br>
<img height="20" width="20" align="top" src="3.png"> Résiliation en cours de bail:<br>
<img height="20" width="20" align="top" src="4.png"> Toutefois, le locataire peut résilier le contrat en cours de bail :<br>
    <img height="20" width="20" align="top" src="nice.png">S'il doit quitter l'appartement en cours de bail pour des raisons qui lui sont propres (donc pas de justification à apporter),<br> il peut résilier son contrat en respectant un préavis de deux mois ;<br>
    <img height="20" width="20" align="top" src="nice.png">Si le logement est détruit à la suite d'un sinistre ;<br>
    <img height="20" width="20" align="top" src="nice.png">Si les travaux effectués par le propriétaire le privent partiellement ou totalement de la jouissance de logement ;<br>
    <img height="20" width="20" align="top" src="nice.png">Si le logement est vendu, le contrat de location reste valable vis-à-vis du nouveau propriétaire. Ce dernier doit <br>donc respecter l'échéance normale du bail s'il souhaite récupérer le logement pour son usage personnel.<br>
<h2><i><u><img height="25" width="25" align="top" src="cri.png">  Conseils pratiques :</u></i></h2>
   <img height="20" width="20" align="top" src="1.png"> Ne signez pas le contrat sans l'avoir lu et demandez des explications sur les clauses que vous ne comprenez pas.<br>
   <img height="20" width="20" align="top" src="2.png"> Faites un état des lieux d'entré et de sortie : prenez votre temps, visitez chaque pièce, faites attention aux 
   appareils sanitaires, porte et fenêtres... etc. Vérifiez que tout est bien noté, signez-le.<br>
   <img height="20" width="20" align="top" src="3.png"> Souscrivez, même si elle n'est pas obligatoire ni imposée dans le bail, une assurance multirisques habitation.<br>
<%session.setAttribute("id",session.getAttribute("id_personne") ); %>
<h2><i><u><img height="40" width="40" src="money.png">  La Facture  :</u></i></h2>
- Code facture :...........................................<br>
- Date debut:..............................................<br>
- Date fin:................................................<br>
- Nombre des jours :.......................................<br>
- Prix De Bien :...........................................<br>
- Montant:............................................<br>
- Mode Paiement :..........................................<br>
- Date de révision du loyer annuel :-------------/-----/-----<br>
- Durée  du  contrat  :................................... a ........................................<br>
- Le ------------/-----/----- , à ........................................[lieu].
 <br><br>                            
 <img height="20" width="20" src="si.png">  Signature du bailleur [ou de son mandataire,  le cas échéant ]..............................  <br>
 <br><br><img height="20" width="20" src="si.png">-Signature du locataire :....................................
 <br>
 <img height="200" width="200" src="vip.jpg"> <img height="200" width="200" src="limite.jpg"> <img height="200" width="200" src="pending3.jpg"> 
 <br>
 <img width="900"  height="90" src="base.png">
 <br>
<form action="AjouterBienServlet2" method="get">
<input type="submit" name="confirmer" value="confirmer">
</form><br>
<form action="AjouterContrat1.jsp" method="get">
<input type="submit" name="annuler" value="annuler">
</body>
</html>