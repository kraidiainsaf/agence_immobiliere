<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/font.css" type="text/css"/>	
<title>refuser un bien</title>
</head>
<body>
<%@ include file="header.jsp" %>
<%String idprop=request.getParameter("prop");
int idprop1=Integer.parseInt(idprop);
%>
<div class="main-grid">
			<div class="agile-grids">
			<div class="panel panel-widget forms-panel">
						<div class="forms">
							<div class="form-grids widget-shadow" data-example-id="basic-forms"> 
								<div class="form-title">
<p><b>voulez vous vraiment reffuser ce bien ?</b></p>
</br>
 <form action="refuserBien" method="post">
    <input type="hidden" name="id" value=<%=request.getParameter("id") %>>
    <input type="hidden" name="idprop" value=<%=idprop1 %>>
      <button class="btn btn-default w3ls-button">
<p><img height="20" width="20" src="pic\yes.png"> Oui</p>
</button></form>
 </br> 
       <form action="approuverBien1.jsp">
      <button class="btn btn-default w3ls-button">
     
<p><img height="20" width="20" src="pic\no.png">Non</p>
</button></form> 
    </div></div>  </div></div></div></div>
    <script src="js/bootstrap.js"></script>
	<script src="js/proton.js"></script>

</body>
</html>