<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<style type="text/css">
#table{

border-collapse: collapse;
width:70%;

margin-left: 100px;}
#table td{ border:1px solid #ddd; padding:2px;
padding:2px;}
 #table tr{ padding:5px;
 margin:6px;
 }
 #di{
 border-style:solid;
 border-color:#40bac8;
 background-color:white;
 padding:5px; 
 margin:10px;
 margin-right: 10px;}
 #table th{ }
 #p{
 
 margin-left: 150px;}
 img{
 width: 400%.}
 #b{background-color: #40bac8;
 border-radius:5px;
 margin-left: 200px;}
#in{
size: 250px;}
 </style>
	<link rel="stylesheet" href="css/font.css" type="text/css"/>	
	
<%@ include file="header.jsp" %>
<%@ page import="Modele.cntrlNotif"%>
<%@ page import="Modele.cntrlCompte"%>
<%@ page import="Modele.personne"%>
<%@ page import=" java.util.ArrayList"%>
<div class="main-grid">
			<div class="agile-grids">
<div id="">
<% cntrlCompte c=new cntrlCompte();

ArrayList<personne>list=c.getProfile(id);%>

<% int i=0;personne per= new personne();
while((list.isEmpty()==false)){
 per=list.get(i);%>
 <form action="modifierProfile" method="post">
 <div class="panel panel-widget forms-panel">
						<div class="forms">
							<div class="form-grids widget-shadow" data-example-id="basic-forms"> 
								<div class="form-title">
 <div id="">
 <img alt="" src="<%=c.getPhoto(per.getId_personne()) %>" width="200px" height="200px" align="top" style="border-radius: 100px;margin-left:450px;" >


 </br>
 <div class="form-body" style="margin-left:280px;">
 <label class="col-md-2 control-label"> <img alt="" src="pic\name.png" width="20px" height="20px" align="top" > nom: </label>
 <div class="input-group input-icon right">
													<span class="input-group-addon">
														<i class=""></i>
													</span>
 <input   id="in"  type="text" value="<%=per.getNom()%>" name="nom" style="width: 300px;" ></div>
 </br>
 <label class="col-md-2 control-label"><img alt="" src="pic\name.png" width="20px" height="20px" align="top" > prenom: </label>
 <div class="input-group input-icon right">
													<span class="input-group-addon">
														<i class=""></i>
													</span>
 <input id="in"  type="text" value="<%=per.getPrenom()%>" name="prenom" REQUIRED style="width: 300px;"></div>
</br>
 <label class="col-md-2 control-label"><img alt="" src="pic\name1.png" width="30px" height="30px" align="top" > pseudo: </label>
 <div class="input-group input-icon right">
													<span class="input-group-addon">
														<i class=""></i>
													</span>
 <input id="in"  type="text" value="<%=per.getPseudo()%>" name="pseudo" REQUIRED style="width: 300px;"></div>
 
  </br>
 <label class="col-md-2 control-label"><img alt="" src="pic\tel.png" width="20px" height="20px" align="top" >telephone: </label>
 <div class="input-group input-icon right">
													<span class="input-group-addon">
														<i class=""></i>
													</span>
 <input  id="in"  type="tel" pattern="0[0-9][0-9][0-9]-\d\d-\d\d-\d\d"  value="<%=per.getNum_telephone()%>" name="num" REQUIRED style="width: 300px;"></div>
 </br>
  
 <label  class="col-md-2 control-label"><img alt="" src="pic\mail.png" width="20px" height="20px" align="top" > e-mail: </label>
 <div class="input-group input-icon right">
												<div class="input-group input-icon right">
													<span class="input-group-addon">
														<i class=""></i>
													</span>
 <input id="email" id="in" type="email" value="<%=per.getEmail()%>" name="email" REQUIRED style="width: 300px;"></div></div>
 
</br>

<label  class="col-md-2 control-label"><img alt="" src="pic\pass.png" width="20px" height="20px" align="top" > password: </label>
 <div class="input-group input-icon right">
												<div class="input-group input-icon right">
													<span class="input-group-addon">
														<i class=""></i>
													</span>
 <input id="email" id="in"" type="password" value="<%=per.getPassword()%>" name="password" REQUIRED style="width: 300px;"></div></div>
 <br>
<input type="hidden" name="id" value=<%=per.getId_personne() %>>
<input type="hidden" name="ps" value=<%=per.getPseudo() %>>
<button class="btn btn-default w3ls-button" style="margin-left:240px;">
<p style="padding-left: 2px">modifier</p>
</button>
</br>
</br>
<input type="file" name="photo" value="<%=c.getPhoto(per.getId_personne()) %>" id="exampleInputFile" style="margin-left:150px;"/>

</div>
 <%
list.remove(i);} %>

</div>
</div>
</div>
</div>
</div>
</div></div>
</form>


<script src="js/bootstrap.js"></script>
	<script src="js/proton.js"></script>
</body>
</html>
