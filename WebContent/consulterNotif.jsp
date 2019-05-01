<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
#table{
border-collapse: collapse;
width:70%; 
margin:150px;
margin-top: 70px;
}
img{
}
button{
border:none;
background-image: url("sup2.jpg");}
margin-left: 60px;}
#table td{ border:1px solid #ddd; padding:2px;
padding:2px;}
 #table tr{ padding:5px;
 margin:6px;
 }
 h1{
 margin-left: 200px;}
 #table th{ }</style>
 <link rel="stylesheet" href="css/table-style.css">
<title>consulter les notifications</title>
</head>
<body>
<%@ include file="header.jsp" %>

<%@ page import="Modele.cntrlNotif"%>
<%@ page import="Modele.notification"%>
<%ArrayList<notification>list=n.getNotifications(id);
if(list.isEmpty()){%>
<br><br><br>
<h1 align="center">aucune notification disponible</h1>
<%}else{ %>
<div class="agile-tables">
					<div class="w3l-table-info">
					
					    <table id="table">
						<thead>
<tr>
<th align="center"><img height="30" width="30" src="pic\name.png">Emetteur</th>
<th align="center"> <img height="30" width="30" src="pic\description.png">Contenu</th>
<th align="center">Supprimer</th></tr>
<% int i=0;notification no= new notification();

while((list.isEmpty()==false)){
 no=list.get(i);%>
 <td  align="center"><%=no.getEmetteur() %></td>
 <td  align="center"><%=no.getContenue_notif()%></td>
 <td align="center"><form action="supprimerNotif" method="post">
<input type="hidden" name="id" value=<%=no.getId_notif() %>>
<button align="center" style="background-color:white;">
<a>
<img height="30" width="40" src="pic\trash.png">
</button>
</form></td>
 </tr>
 <%
list.remove(i);} }%>
 </table>
<script src="js/bootstrap.js"></script>
	<script src="js/proton.js"></script>

</body>
</html>