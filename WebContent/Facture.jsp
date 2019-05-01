
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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

<%@page import="Modele.operation" %>
<%operation op=new operation(); %>
<div id="fond">
<div id="contenu">
<img  src="base.png">
<h1>FACTURE       DE         LOCATION  </h1>
<img width="500" height="50" src="sous_base.png">
<br><br>
<img width="90" height="50" src="m.png">
<p align="center">
<%int id_bien=(int)session.getAttribute("id_bien_louer"); %>
<%int id_personne=op.GetIdPersonne(id_bien); %><%int id_locataire=(int)session.getAttribute("id_personne"); %>
- Nom et prénom de propriétaire, ou dénomination du bailleur :<%=op.GetNamePersonne(id_personne) %><br>
- numero cart identité N°:<%=op.GetNumCart(id_personne) %><br>
- Nom et prénom du locataire :<%=op.GetNamePersonne(id_locataire)%><br>
- Numero cart identité N°:<%=op.GetNumCart(id_locataire) %><br>
<%session.setAttribute("id",session.getAttribute("id_personne") ); %>
<h2><i><u><img height="40" width="40" src="money.png">  La Facture  :</u></i></h2>
- Code facture :<%=(int)session.getAttribute("code") %><br>
- Date debut: <%=session.getAttribute("date_debut")%><br>
- Date fin:<%=session.getAttribute("date_fin")%><br>
- Nombre des jours : <%=(Long)session.getAttribute("nbr_jour")%><br>
- Prix De Bien : <%=(double)session.getAttribute("prix_jour") %><br>
- Montant: <%=(double)session.getAttribute("montant_pure") %><br>
- Mode Paiement : <%=(String)session.getAttribute("mode_pay") %><br>
- Le ------------/-----/----- , à ........................................[lieu].
 <br><br>                            
 <img height="20" width="20" src="si.png">  Signature du bailleur [ou de son mandataire,  le cas échéant ]..............................  <br>
 <br><br><img height="20" width="20" src="si.png">-Signature du locataire :....................................
 <br>
 <img height="200" width="200" src="vip.jpg"> <img height="200" width="200" src="limite.jpg"> <img height="200" width="200" src="pending3.jpg"> 
 <br>
 <img width="900"  height="90" src="base.png">
 <br>
 ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 ......................................................................<img height="30" width="30" src="couper.png"> couper ici............................................................................................................
 ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 <br>
<button type="button" value="imprimer"  onclick="javascript:print()">imprimer </button>
</div></div>
</body>
</html>