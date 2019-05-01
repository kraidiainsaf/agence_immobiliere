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
<title>Envoyer Notification</title>
</head>
<body>
 <%@ include file="header.jsp" %>
 <div class="main-grid">
			<div class="agile-grids">
<div class="panel panel-widget forms-panel">
						<div class="forms">
							<div class="form-grids widget-shadow" data-example-id="basic-forms"> 
								<div class="form-title">
<%HttpSession notification=request.getSession(); %>
<b>notification " <%=notification.getAttribute("contenu") %>"  envoyée à <%=notification.getAttribute("destinataire") %> </b>
</div></div></div></div></div></div>
<script src="js/bootstrap.js"></script>
	<script src="js/proton.js"></script>
</body>
</html>