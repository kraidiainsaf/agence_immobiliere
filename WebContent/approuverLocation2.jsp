<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/font.css" type="text/css"/>	
<title>approuver une location </title>

</head>
<body>
<%@ include file="header.jsp" %>
<div class="main-grid">
			<div class="agile-grids">
			<div class="panel panel-widget forms-panel">
						<div class="forms">
							<div class="form-grids widget-shadow" data-example-id="basic-forms"> 
								<div class="form-title">
								<h2> <img height="50" width="50" src="pic\yes2.png">Aprouver la location :</h2>
</br>
<form action="approuverLocation" method="post">
<%String i=request.getParameter("idloc");
int id1=Integer.parseInt(i);%>
<label><img height="30" width="30" src="pic\cal.png"> Date de paiement</label>
<input type="date" pattern="[0-9][0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9]" name="date_pay" style="height: 30px;"/  >
</br></br>
    <input type="hidden" name="idloc" value=<%=id1 %>>
      <td  align="center"><input type="submit" name="consulter" value="approuver" > </td></form>
</div></div></div></div></div></div>
<script src="js/bootstrap.js"></script>
	<script src="js/proton.js"></script>
</body>
</html>