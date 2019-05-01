<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/font.css" type="text/css"/>
<style type="text/css">
#t{
width: 450px;
height: 100px;
}
</style>
<title>Envoyer Notification</title>
</head>
<body>

<form action="NotificationServlet" method="post">
<%HttpSession back=request.getSession();
if(back.getAttribute("b").equals("oui")){
RequestDispatcher DL =request.getRequestDispatcher("/notificationEnvoyé.jsp");
	DL.include(request,response);}else{%>
 <%@ include file="header.jsp" %>
 <div class="main-grid">
			<div class="agile-grids">
<h2 align="center">vous devez remplir tous les champs</h2>
</br>
<div class="panel panel-widget forms-panel">
						<div class="forms">
							<div class="form-grids widget-shadow" data-example-id="basic-forms"> 
								<div class="form-title">

<%@ page import="Modele.personne"%>
<%@ page import="Modele.cntrlNotif"%>
<%@ page import=" java.util.ArrayList"%>
<% cntrlNotif nt=new cntrlNotif(); %>
<% personne p1=new personne();
ArrayList<String> list=p1.getNames();

%>
<div class="form-body">
<h2 align="center"><img height="50" width="50" src="pic\noti2.png"> Envoyer une notification</h2>
 </br></br>
 <label 	 class="col-md-2 control-label"><b ><img height="20" width="20" src="pic\dest.png">  Destinataire</b></label>
<input list="personne" id="pl" name="dest">
<datalist id="personne">
<%for(int i=0;i< list.size();i++){
	%>
<option value="<%=list.get(i)%>">
<%

} %></option>
</datalist>
</br>

</br>
<label class="col-md-2 control-label" ><b> <img height="20" width="20" src="pic\pen.png">  Contenu: </b></label>
<input type="text" name="contenu" id="t"  >

</br>
</br>
<button class="btn btn-default w3ls-button">
<p>envoyer </p>
</button>

</div></div></div></div></div>
</form>
</div></div>

<script src="js/bootstrap.js"></script>
	<script src="js/proton.js"></script>
	<%} %>
</body>
</html>