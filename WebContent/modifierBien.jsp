<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/font.css" type="text/css"/>
<style type="text/css">
	
table{
border-collapse: collapse;
width:90%;

margin-left: 20px;}
#in{background-color: #ff9933;
border-color:
size:20px;width:90%;
height:100%;
margin:10px;}
#table td{  padding:2px;
padding:2px;}
 #table tr{ padding:5px;
 margin:6px;
 }
 #table th{ }</style>
<link rel="stylesheet" href="css/table-style.css">
</head>
<body>

 <%@ include file="header.jsp" %>
 <div class="main-grid">
			<div class="agile-grids">

<%@ page import="Modele.bien"%>
<%@ page import="Modele.cntrlBien"%><%@ page import="Modele.cntrlCompte"%>
<%@ page import=" java.util.ArrayList"%>
<%HttpSession session1=request.getSession();
cntrlBien b=new cntrlBien();cntrlCompte c=new cntrlCompte();
ArrayList<bien> list=(ArrayList<bien>)session1.getAttribute("list"); %>

<h1 align="center"><img height="40" width="40" src="pic\modi.png"> Modifier un bien</h1></br>
				<div class="agile-tables">
					<div class="w3l-table-info">
					    <table id="table">
						<thead>
<th> type de bien</th>
<th> proprietaire</th>
<th> adresse</th>
<th> superficie</th>
<th>  prix</th>
<th> description</th>
<th width="5px"> max_coloccataire</th>
<th>photo 1</th>
<th>photo 2</th>
<th>photo 3</th>
<th>photo 4</th>
<th>photo 5</th>
<th>modifier</th>
</tr>
</thead>
<% bien bi=null;	 int i=0;
%>
<%while((list.isEmpty()==false)){
 bi=list.get(i);%>

<tr>
<td><%=b.getTypeBien(bi.getId_bien()) %>
<td><%=b.getNameprop(b.getProprietaire(bi.getId_bien())) %> <form action="consulterProp.jsp">
 <input type="hidden" name="prop" value=<%=c.getproprietaire(b.getProprietaire(bi.getId_bien()))%>>
          <input type="submit" name="consulter" value="details"></form> </td>
<td><%=b.getAdresse(bi.getId_bien()) %></td>
<td> <%=bi.getSuperficie() %></td>
<td><%=bi.getPrix()%></td>
<td> <%=bi.getdescription() %></td>
<td><%=bi.getMax_colocataire() %></td>
<td><img  width="70" height="70" src="<%=bi.getimg1(bi.getId_bien())%>"></td>
<td><img  width="70" height="70" src="<%=bi.getimg2(bi.getId_bien())%>"></td>
<td><img  width="70" height="70" src="<%=bi.getimg3(bi.getId_bien())%>"></td>
<td><img  width="70" height="70" src="<%=bi.getimg4(bi.getId_bien())%>"></td>
<td><img  width="70" height="70" src="<%=bi.getimg5(bi.getId_bien())%>"></td>
 <form action="modifierBienServ" method="post">
    <input type="hidden" name="id" value=<%=bi.getId_bien() %>>
     <input type="hidden" name="im1" value=<%=bi.getimg1(bi.getId_bien()) %>>
      <td><button "btn btn-default w3ls-button"><h5>modifer</h5></button> </td></form>
      

</tr>
<%
list.remove(i);} %>
</table>
</div>
	</div>
	</div></div>
	</div>
	
	<script src="js/bootstrap.js"></script>
	<script src="js/proton.js"></script>



</body>
</html>