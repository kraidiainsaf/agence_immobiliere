<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>#tab{
width:100%;
padding:30px;}

</style>
<link rel="stylesheet" href="css/mytab.css">
<title>Facture</title>
</head>
<body>
<%@ include file="header.jsp" %>
 <div class="main-grid">
			<div class="agile-grids">
<%@ page import="Modele.facture"%>
<%@ page import="Modele.location"%>
<%@ page import=" java.util.ArrayList"%>
<%@ page import="Modele.cntrlCompte"%>
<% location loc=new location();

facture fact=new facture();
String id1=(String)request.getParameter("idloc");
int idl=Integer.parseInt(id1);cntrlCompte c=new cntrlCompte();
ArrayList<facture> list=fact.getFacture(idl);%>
<h1 align="center"><img height="40" width="40" src="pic\facture.png"> Factures</h1>
</br>
<div class="agile-tables">
					<div class="w3l-table-info">
					    <table id="tab">
						<thead>
<tr>
<th  align="center"><img height="20" width="20" src="pic\code.png"> code facture</th>
<th  align="center"> <img height="20" width="20" src="pic\name.png">locataire</th>
<th  align="center"><img height="20" width="20" src="pic\montant.png"> montant</th>
<th  align="center"><img height="20" width="20" src="pic\date.png"> Date de payement</th>
</tr>
<% facture f=null;	 int i=0;%>
<%while((list.isEmpty()==false)){
 f=list.get(i);%>
 <td  align="center"><%=f.getCode_facture() %></td>
 <td  align="center"><%=f.getNameloca(f.getId_personne()) %></td>
 <td  align="center"><%=f.getMontant() %></td>
 <td  align="center"><%=f.getDate_pay() %></td>
</tr>
 <%
list.remove(i);} %>
 </table>
	</div>
	</div>
	</div></div>
	</div>
	
<script src="js/bootstrap.js"></script>
	<script src="js/proton.js"></script>

</body>
</html>