<%
	       response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	       response.addHeader("Cache-Control", "post-check=0, pre-check=0");
	       response.setHeader("Pragma", "no-cache");
	       response.setDateHeader("Expires", 0);
    
if(session.getAttribute("id_personne")==null){
	RequestDispatcher DL =request.getRequestDispatcher("authentifg");
DL.forward(request,response);}%>
<%@page import="Modele.cntrlAuthentif" %>
<%int id=(int)session.getAttribute("id_personne"); %>
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
 <script type="text/javascript">
		        function v() {

		        	
		        
					if((document.form.date_debut.value=="")||(document.form.date_debut.value==null)){
						alert("vous devez remplir tous les champs! ");
						return false;
					}
					if((document.form.date_fin.value=="")||(document.form.date_fin.value==null)){
						alert("vous devez remplir tous les champs!");
						return false;
					}
					if((document.form.mode_pay.value=="")||(document.form.mode_pay.value==null)){
						alert("vous devez remplir tous les champs!");
						return false;
					}
					
				}
		        
		        </script>


<%System.out.println("type_location_form louer"+session.getAttribute("type_colocation"));
 %>

 <div class="home-lager-shearch" style="padding-top: 25px; margin-top: -10px; padding-bottom: 60px; background-color: rgb(252, 252, 252);">
            <div class="container" >
         <!-- cadre de recherche  -->      
          <div class="col-md-12 large-search" style="background-color: #F4C543;padding: 3px;"> 
                    <div class="search-form wow pulse" style="background-color:#fbfbfa;text-align: center;color: black;">
                    <%String e=(String)request.getAttribute("erreur"); %>
                     <%String n=(String)request.getAttribute("note"); %>
                    
                    <h2  style="text-align: center;color:#F4C543;"><i ><u>Des Informations Sur Votre location </u></i>:</h2>
                                
 <%if(n!=null){ %>
<P style="border:1px double #b3e6b3;background-color:geray;padding:10px;margin-left:400px;margin-right:400px;background-color: #b3e6b3;"><%=n %></P>
                        <%} %>
 <%if(e!=null){ %>
<P style="border:1px double #f65e5e;background-color:geray;padding:10px;margin-left:400px;margin-right:400px;background-color:#ff8c8c;"><img  width="20px" height="20px;" src="error.png" style="margin:5px;"><%=e %></P>
                        <%} %>
                    <br><br>
                       <form  name="form" action="VerifierLocationServlet"  onsubmit='return v()' >
<label><img width="30px" height="30px"  alt="" src="1er.png"> Debut de location :</label>
<input type="date" style="width: 150px;border: 1px solid #F4C543;" placeholder="yyyy-mm-dd" name="date_debut" required pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"  ><br><br>
<label><img alt=""  width="30px" height="30px"  src="door.png">  Fin de location :</label>
<input type="date" style="width: 150px;border: 1px solid #F4C543;" placeholder="yyyy-mm-dd" name="date_fin" required pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}" ><br><br>
<label> Mode paiement :</label>
<label class="radio-inline"> Mensuel  <input type="radio" name="mode_pay" value="mensuel" ></label>
<label class="radio-inline"> Annuel  <input type="radio" name="mode_pay" value="annuel"></label>
<label class="radio-inline"> Totale  <input type="radio" name="mode_pay" value="totale"></label>
<br><br>
		               <div class="center">
                               <img width="20px" height="20px"  src="nice.png"> <input style="width: 200px;background-color: #e8e3e3;border: 1px solid #F4C543;" type="submit" value="louer" >
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
	
 <%@ include file="footer2.jsp" %>