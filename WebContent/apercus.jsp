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
<% cntrlCompte c=new cntrlCompte();cntrlNotif t=new cntrlNotif();
String pers=request.getParameter("pers");
int id1=t.getIdPersonne(pers);
out.println(pers);
ArrayList<personne>list=c.getProfile(id1);%>

<% int i=0;personne per= new personne();
while((list.isEmpty()==false)){
 per=list.get(i);%>
 <form action="modifierProfile">
 <div class="panel panel-widget forms-panel">
						<div class="forms">
							<div class="form-grids widget-shadow" data-example-id="basic-forms"> 
								<div class="form-title">
 <div id="">
 <img alt="" src="admin.jpg" width="150px" height="150px" align="top" >


 </br>
 <div class="form-body">
 <label class="col-md-2 control-label"> <img alt="" src="name.png" width="20px" height="20px" align="top" > nom: </label>
 <div class="input-group input-icon right">
													<span class="input-group-addon">
														<i class=""></i>
													</span>
 <input   id="in"  type="text" value="<%=per.getNom()%>" name="nom" ></div>
 </br>
 <label class="col-md-2 control-label"><img alt="" src="name.png" width="20px" height="20px" align="top" > prenom: </label>
 <div class="input-group input-icon right">
													<span class="input-group-addon">
														<i class=""></i>
													</span>
 <input id="in"  type="text" value="<%=per.getPrenom()%>" name="prenom"></div>
</br>
 <label class="col-md-2 control-label"><img alt="" src="name1.png" width="30px" height="30px" align="top" > pseudo: </label>
 <div class="input-group input-icon right">
													<span class="input-group-addon">
														<i class=""></i>
													</span>
 <input id="in"  type="text" value="<%=per.getPseudo()%>" name="pseudo"></div>
 
  </br>
 <label class="col-md-2 control-label"><img alt="" src="tel.png" width="20px" height="20px" align="top" > numéro de téléphone: </label>
 <div class="input-group input-icon right">
													<span class="input-group-addon">
														<i class=""></i>
													</span>
 <input  id="in"  type="tel" pattern="0[0-9][0-9][0-9]-\d\d-\d\d-\d\d"  value="<%=per.getNum_telephone()%>" name="num"></div>
 </br>
  
 <label  class="col-md-2 control-label"><img alt="" src="mail.png" width="20px" height="20px" align="top" > e-mail: </label>
 <div class="col-md-8">
												<div class="input-group input-icon right">
													<span class="input-group-addon">
														<i class="fa fa-envelope-o"></i>
													</span>
 <input id="email" id="in" type="email" value="<%=per.getEmail()%>" name="email"></div></div>
 
</br>
</br>
<label  class="col-md-2 control-label"><img alt="" src="pass.png" width="20px" height="20px" align="top" > password: </label>
 <div class="col-md-8">
												<div class="input-group input-icon right">
													<span class="input-group-addon">
														<i class=""></i>
													</span>
 <input id="email" id="in"" type="password" value="<%=per.getPassword()%>" name=""></div></div>
 
<input type="hidden" name="id" value=<%=per.getId_personne() %>>
<input type="hidden" name="ps" value=<%=per.getPseudo() %>>
<button class="btn btn-default w3ls-button">
<p>modifier</p>
</button>
</br>
</br>
<input type="file" name="photo" id="exampleInputFile"/>
</td>
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


<%@ include file="footer.jsp" %>
</body>
</html>
