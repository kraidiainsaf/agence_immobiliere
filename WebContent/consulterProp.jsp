<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<link rel="stylesheet" href="css/font.css" type="text/css"/>	
			
<%@ include file="header.jsp" %>
<%@ page import="Modele.cntrlCompte"%>
<%@ page import="Modele.personne"%>
<%@ page import=" java.util.ArrayList"%>

<%cntrlCompte cot=new cntrlCompte();
String prop=request.getParameter("prop");
int idProp=Integer.parseInt(prop);%>
<% cntrlCompte c=new cntrlCompte();

ArrayList<personne>list=c.getProfile(idProp);%>

<% int i=0;personne per= new personne();
while((list.isEmpty()==false)){
 per=list.get(i);%>
<div class="main-grid">
			<div class="agile-grids">
<div class="panel panel-widget forms-panel">
						<div class="forms">
							<div class="form-grids widget-shadow" data-example-id="basic-forms"> 
								<div class="form-title">
								<h1 align="center">Profile proprietaire</h1></div>
								 </br>
 <div class="form-body">
 <label class="col-md-2 control-label"><img alt="" src="pic\name.png" width="20px" height="20px" align="top" > nom: </label>
 <div class="input-group input-icon right">
													<span class="input-group-addon">
														<i class=""></i>
													</span>
 <input  class="form-control1"  type="text" value="<%=per.getNom()%>"  disabled="disabled" name="nom"></div>
 </br>
 <label class="col-md-2 control-label"><img alt="" src="pic\name.png" width="20px" height="20px" align="top" > prenom: </label>
 <div class="input-group input-icon right">
													<span class="input-group-addon">
														<i class=""></i>
													</span>
 <input  class="form-control1"  type="text" value="<%=per.getPrenom()%>"  disabled="disabled" name="prenom"></div>
</br>
 <label class="col-md-2 control-label"><img alt="" src="pic\name1.png" width="30px" height="30px" align="top" > pseudo: </label>
 <div class="input-group input-icon right">
													<span class="input-group-addon">
														<i class=""></i>
													</span>
 <input class="form-control1"  type="text" value="<%=per.getPseudo()%>"  disabled="disabled"  name="pseudo"></div>
 
  </br>
 <label class="col-md-2 control-label"><img alt="" src="pic\tel.png" width="20px" height="20px" align="top" > téléphone: </label>
 <div class="input-group input-icon right">
													<span class="input-group-addon">
														<i class=""></i>
													</span>
 <input  class="form-control1"  type="tel" pattern="0[0-9][0-9][0-9]-\d\d-\d\d-\d\d"  disabled="disabled" value="<%=per.getNum_telephone()%>" name="num"></div>
 </br>
  
 <label  class="col-md-2 control-label"><img alt="" src="pic\mail.png" width="20px" height="20px" align="top" > e-mail: </label>
 <div class="input-group input-icon right">
												<div class="input-group input-icon right">
													<span class="input-group-addon">
														<i class=""></i>
													</span>
 <input id="email" class="form-control1" type="email" value="<%=per.getEmail()%>" name="email" style="width: 895px" disabled="disabled"></div></div>
 
</br>

<label  class="col-md-2 control-label"><img alt="" src="pic\cart.png" width="25px" height="25px" align="top" > carte d'identité: </label>
 <div class="input-group input-icon right">
												<div class="input-group input-icon right">
													<span class="input-group-addon">
														<i class=""></i>
													</span>
 <input id="email" class="form-control1" type="text" value="<%=per.getCart_identite()%>" name=""  disabled="disabled" style="width: 895px"></div></div>
 </div>
 </br>
 <%
list.remove(i);} %>

</div>
</div>
</div>
</div>
</div>

	<script src="js/bootstrap.js"></script>
	<script src="js/proton.js"></script>

</body>
</html>