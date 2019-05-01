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
width:90%; 
margin-top:80px;
margin-left: 150px;
margin-right: 150px;
padding-left: 200px;
}
img{
}
button{

background-image: url("sup2.jpg");}
margin-left: 60px;}
#table td{ border:1px solid #ddd; padding:2px;
padding:2px;}
 #table tr{ padding:5px;
 margin:6px;
 }
 #table th{ }</style>
 <link rel="stylesheet" href="css/table-style.css">
<title>consulter les commentaires</title>
</head>
<body>
<%@ include file="header.jsp" %>

<%@ page import="Modele.commentaire"%>
<% commentaire com=new commentaire();
String id1=(String)request.getParameter("id");
int idb=Integer.parseInt(id1);
ArrayList<commentaire>list=com.getCom(idb);

if(list.isEmpty()){
%> <br><br><h1 align="center">aucun commentaire </h1>
<%}else{ %>
	</br>
						<h1 align="center"> <img height="40" width="40" src="pic\comm.png">  Commentaires </h1>
<div class="agile-tables">
					<div class="w3l-table-info">
					    <table id="table">
						<thead>
					
<tr>
<th align="center"> <img height="20" width="20" src="pic\ecri.png"> Ecrivain</th>
<th align="center"> <img height="20" width="20" src="pic\com.png"> Contenu</th>
</tr>
<% int i=0;

while((list.isEmpty()==false)){
 com=list.get(i);%>
 <td  align="center"><%=com.getNom_ecri() %></td>
 <td  align="center"><%=com.getContenue() %></td>

 </tr>
 <%
list.remove(i);} %>
 </table><%} %>
 </div></div>
 <script src="js/bootstrap.js"></script>
	<script src="js/proton.js"></script>
</body>
</html>