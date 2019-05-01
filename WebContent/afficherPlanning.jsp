<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/mytab.css">
<style type="text/css">
#tab{
width:100%;
padding:50px;}
</style>
<title>Consulter le planning de location</title>
</head>
<body>
<%@ include file="header.jsp" %>
<%@ page import="Modele.bien"%>
<%@ page import="Modele.location"%>
<%@ page import=" java.util.ArrayList"%>
<%@ page import="Modele.cntrlCompte"%>
<% location loc=new location(); cntrlCompte cp=new cntrlCompte();
String id1=(String)request.getParameter("id");
int idb=Integer.parseInt(id1);
ArrayList<location> list=loc.getPlanning(idb);%>

 <div class="main-grid">
			<div class="agile-grids">
<%if (list.isEmpty()){ %>
<h2 align="center">aucune location disponible</h2>
<%}else{%>
<h1 align="center"><img height="40" width="40" src="pic\paln.png"> Planning des locations</h1>
</br>
<div class="agile-tables">
					<div class="w3l-table-info">
					    <table id="tab">
<tr>
<th  align="center"><img height="25" width="25" src="pic\name.png">locataire</th>
<th  align="center">état</th>
<th  align="center"> <img height="25" width="25" src="pic\debut.png"> Date de début</th>
<th  align="center"> <img height="25" width="25" src="pic\fin.png"> Date de fin</th>
<th  align="center">  <img height="25" width="25" src="pic\mode.png"> mode de payement</th>
<th  align="center"> <img height="25" width="25" src="pic\factu.png">Factures</th>
<th  align="center"> <img height="25" width="25" src="pic\end.png"> Fin de location</th>
</tr>
<tr>

<% location l=null;	 int i=0;%>
<%while((list.isEmpty()==false)){
 l=list.get(i);%>
 <td align="center"><%=l.getLocataire(l.getLocataireid(l.getId_location())) %><form action="consulterLoc.jsp">
 <input type="hidden" name="prop" value=<%=l.getLocataireid(l.getId_location()) %>>
          <input type="submit" name="consulter" value="details"></form></td>
 <td  align="center"><%=l.getEtat_location() %></td>
 <td  align="center"><%=l.getDate_debut() %></td>
 <td  align="center"><%=l.getDate_fin() %></td>
 <td  align="center"><%=l.getMode_pay() %></td>
 <form action="afficherFacture.jsp">
    <input type="hidden" name="idloc" value=<%=l.getId_location() %>>
      <td  align="center"><input type="submit" name="consulter" value="consulter la facture"> </td></form>
  <td  align="center"><%if(l.getEtat_location().equals("approuve")){  %>
 <form action="rendreBien1.jsp">
  <input type="hidden" name="idbi" value=<%=idb%>>
    <input type="hidden" name="idloc" value=<%=l.getId_location() %>>
     <input type="submit" name="consulter" value="fin de location"> </form></td>

 <%
 }%>
 </tr>
<% list.remove(i);} }%>
 </table>
	</div>
	</div>
	</div></div>
	</div>
	
<script src="js/bootstrap.js"></script>
	<script src="js/proton.js"></script>

</body>
</html>