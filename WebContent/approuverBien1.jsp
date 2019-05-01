<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<title>Approuver les biens</title>
<style type="text/css">
table{
border-collapse: collapse;
width:70%;

margin-left: 20px;}
#table td{ border:1px solid #ddd; padding:2px;
padding:2px;}
 #table tr{ padding:5px;
 margin:6px;
 }
 #table th{ }
 #tab{
width:100%;font-size:13px;
padding:50px;}</style>
<link rel="stylesheet" href="css/table-style.css">
 <%@ include file="header.jsp" %>
 <div class="main-grid">
			<div class="agile-grids">
	<%@ page import="Modele.bien"%>
<%@ page import="Modele.cntrlBien"%>
<%@ page import="Modele.cntrlCompte"%>
<%@ page import=" java.util.ArrayList"%>
<%cntrlBien b=new cntrlBien();
cntrlCompte c=new cntrlCompte();
ArrayList<bien> list=b.getBienapprouve();%>
<% if(list.isEmpty()) {%>
<h2 align="center">aucun bien en attente disponible</h2>
<%}else{%>
					<h2 align="center"><img src="pic\app.png" width="50px" height="50px"> Approuver les biens </h2>
					</br>
				</div>
				<div class="agile-tables">
					<div class="w3l-table-info">
					    <table id="tab">
						<thead>
						  <tr>
						  <th > <img alt="" src="pic/house.png" width="20px" height="20px" align="top" > type de bien</th>
<th> <img alt="" src="pic/name1.png" width="20px" height="20px" align="top" > proprietaire</th>
<th> <img alt="" src="pic/adresse.png" width="20px" height="20px" align="top" >adresse</th>
<th> <img alt="" src="pic/superficie.png" width="20px" height="20px" align="top" > superficie</th>
<th><img alt="" src="pic/prix.png" width="20px" height="20px" align="top" > prix</th>
<th><img alt="" src="pic/description.png" width="20px" height="20px" align="top" > description</th>
<th><img alt="" src="pic/max.png" width="20px" height="20px" align="top" > max_coloccataire</th>
<th><img alt="" src="pic/yes2.png" width="20px" height="20px" align="top" >approuver</th>
<th><img alt="" src="pic/no2.png" width="20px" height="20px" align="top" > reffuser</th>
</tr>
<% bien bi=null;	 int i=0;
%>
<%while((list.isEmpty()==false)){
 bi=list.get(i); 
 %>

<tr>
<td><%=b.getTypeBien(bi.getId_bien()) %>
<td><%=b.getNameprop(b.getProprietaire(bi.getId_bien())) %> <form action="consulterProp.jsp">
 <input type="hidden" name="prop" value=<%=c.getproprietaire(b.getProprietaire(bi.getId_bien()))%>>
          <input type="submit" name="consulter" value="details" ></form> </td>
<td><%=b.getAdresse(bi.getId_bien()) %>
<td> <%=bi.getSuperficie() %></td>
<td><%=bi.getPrix()%></td>
<td> <%=bi.getdescription() %></td>
<td><%=bi.getMax_colocataire() %></td>

 
 <form action="approuverBien2.jsp">
    <input type="hidden" name="id" value=<%=bi.getId_bien() %>>
    <input type="hidden" name="bien" value=<%= bi %>>
    <input type="hidden" name="prop" value=<%=c.getproprietaire(b.getProprietaire(bi.getId_bien()))%>>
         <td> <input type="submit" name="approuver" value="approuver"></td> </form>
   <form action="refuserBien.jsp">
    <input type="hidden" name="id" value=<%=bi.getId_bien() %>>
    <input type="hidden" name="bien" value=<%= bi %>>
     <input type="hidden" name="prop" value=<%=c.getproprietaire(b.getProprietaire(bi.getId_bien()))%>>
      <td><input type="submit" name="reffuser" value="reffuser"></td> </form>    

</tr>
<%
list.remove(i);}} %>

</table>

	</div>
	</div>
	</div>
	
	
	
	<script src="js/bootstrap.js"></script>
	<script src="js/proton.js"></script>

	</body>
	</html>