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
<% }else{%>
<% if(obj.isProprietaire(id)){%>
	<%@ include file="header_proprietaire.jsp" %>
	
<% 
}else{ %>

 <%@ include file="header_locataire.jsp" %>
 <%}} %>


 <div class="home-lager-shearch" style="padding-top: 25px; margin-top: -10px; padding-bottom: 60px; background-color: rgb(252, 252, 252);">
            <div class="container" >
         <!-- cadre de recherche  -->      
          <div class="col-md-12 large-search" style="background-color: #F4C543;padding: 3px;"> 
                    <div class="search-form wow pulse" style="background-color:#f9f8f8;text-align: center;color: black;">
                       <h2  style="text-align: center;color:#F4C543;"><i ><u> Prolongation d'un bien  </u></i>:</h2>
                       <%String e=(String)request.getAttribute("erreur"); %>
 <%if(e!=null){ %>
<P style="border:1px double #f65e5e;background-color:geray;padding:10px;margin-left:400px;margin-right:400px;background-color:#ff8c8c;"><img  width="20px" height="20px;" src="error.png" style="margin:5px;"><%=e %></P>
                        <%} %>
                        <img  src="gal.png"> 
                       <form action="VerifierProlongation" method="get">
                       <br>
<label>Entrez une date pour la fin de votre nouvelle location :
<input type="DATE" placeholder="yyyy-mm-dd" required pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}" name="date_fin_p" style="width: 200px">
</label><br>
<label> Mode payement :</label>
<label class="radio-inline"> mensuel  <input type="radio" name="mode_pay" value="mensuel" ></label>
<label class="radio-inline"> annuel  <input type="radio" name="mode_pay" value="annuel"></label>
<label class="radio-inline"> totale  <input type="radio" name="mode_pay" value="totale"></label>
<br><br>
		               <div class="center">
                               <img width="30px" height="30px"  src="nice.png"> <input style="width: 200px;border:1px solid #F4C543;" type="submit" value="Prolonger" >
                            </div>
                        </form>
                         
                    </div>
                </div>
            </div>
        </div>

 <%@ include file="footer2.jsp" %>
