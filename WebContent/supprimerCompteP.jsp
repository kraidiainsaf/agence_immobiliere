<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/font.css" type="text/css"/>
<style type="text/css">
#in{
margin-left:20px;
margin:10px;
padding:10px;}</style>
<title>Supprimer compte</title>
</head>
<body>
 <%@ include file="header.jsp" %>
 <div class="main-grid">
			<div class="agile-grids">
<form action="supprimerCmpt" method="GET">
<div class="panel panel-widget forms-panel">
						<div class="forms">
							<div class="form-grids widget-shadow" data-example-id="basic-forms"> 
								<div class="form-title">
								<h3><img height="40" width="40" src="pic\trash.png"> Supprimer un  Compte</h3>
</div>
<%@ page import="Modele.personne"%>
<%@ page import="Modele.cntrlNotif"%>
<%@ page import=" java.util.ArrayList"%>
<%utilisateur1.setAttribute("type","pro"); %>
<% cntrlNotif nt=new cntrlNotif(); %>
<% personne p1=new personne();
ArrayList<String> list=p1.getNamesSuppPro();

%>
<div class="form-body">
<label><b >Selectionner le compte a supprimer </b></label>


<input list="personne" id="pl" name="pers" placeholder="enter le pseudo" autocomplete="off">
<datalist id="personne">
<%for(int i=0;i< list.size();i++){
	%>
<option value=<%=list.get(i)%>>
<%System.out.println(list.get(i));
} %>
</datalist>

<button class="btn btn-default w3ls-button">
<p>Supprimer </p>
</button>


</form>
</div></div></div></div>
<script src="js/bootstrap.js"></script>
	<script src="js/proton.js"></script>


</body>
</html>