<%
	       response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	       response.addHeader("Cache-Control", "post-check=0, pre-check=0");
	       response.setHeader("Pragma", "no-cache");
	       response.setDateHeader("Expires", 0);
   
    
if(session.getAttribute("id_personne")==null){
	RequestDispatcher DL =request.getRequestDispatcher("authentifg");
DL.forward(request,response);} %>
<%int id=(int)session.getAttribute("id_personne");%>
<%@page import="Modele.cntrlAuthentif" %>
<% cntrlAuthentif obj=new cntrlAuthentif(); %>

<%if(obj.isLocataire(id)&&obj.isProprietaire(id)){%>
	<%@ include file="header_proprietaire_locataire.jsp" %>
<% }else{
if(obj.isSuppPro(id)){
	System.out.print("suup oui00"+obj.isSuppPro(id));
	RequestDispatcher DL =request.getRequestDispatcher("authentifg");
	DL.forward(request,response);
}else{
%>

 <%@ include file="header_proprietaire.jsp" %>
 <%} }%>
 <div class="home-lager-shearch" style="padding-top: 25px; margin-top: -10px; padding-bottom: 60px; background-color: rgb(252, 252, 252);"  style="text-align:center;">
            <div class="container"  style="text-align: center;">
         <!-- cadre de recherche  -->      
          <div class="col-md-12 large-search" style="background-color: #F4C543;padding: 3px;"  style="text-align:center;"> 
                    <div class="search-form wow pulse" style="background-color:#f9f8f8;text-align: center;color: black;">
  
  <%String e=(String)request.getAttribute("erreur"); %>
  <h2  style="text-align: center;color:#F4C543;"><i ><u> Confirmation  </u></i>:</h2><br>
  <%if(e!=null) {%>
<P style="border:1px double #f65e5e;background-color:geray;padding:10px;margin-left:400px;margin-right:400px;background-color:#ff8c8c;"><img  width="20px" height="20px;" src="error.png" style="margin:5px;">  Note :<%=e %></P>
<br><%} %>
<form action="SupprimerBienServlet2">
<input type="submit" name="confirmer"  style="width:200px;color:#F4C543;border:1px solid #F4C543;" value="Supprimer">
<br>
</form>
<br>
<form action="MesBiens.jsp">
<input type="submit" style="width:200px;color:#F4C543;border:1px solid #F4C543;" name="annuler"value="Annuler">

</form>
</div></div></div></div>

  <%@ include file="footer2.jsp" %>
