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
<script type="text/javascript">
		        function v() {

		        	
		        
					if((document.form.pseudo.value=="")||(document.form.pseudo.value==null)){
						alert("vous devez remplir tous les champs! ");
						return false;
					}
					if((document.form.password.value=="")||(document.form.password.value==null)){
						alert("vous devez remplir tous les champs!");
						return false;
					}
					if((document.form.nom.value=="")||(document.form.nom.value==null)){
						alert("vous devez remplir tous les champs!");
						return false;
					}
					if((document.form.prenom.value=="")||(document.form.prenom.value==null)){
						alert("vous devez remplir tous les champs! ");
						return false;
					}
					if((document.form.email.value=="")||(document.form.email.value==null)){
						alert("vous devez remplir tous les champs!");
						return false;
					}
					if((document.form.num_telephone.value=="")||(document.form.num_telephone.value==null)){
						alert("vous devez remplir tous les champs!");
						return false;
					}
					
				}
		        
		        </script>


<%@page import="Modele.operation" %>
<%@page import="Modele.personne" %>
<div class="home-lager-shearch" style="padding-top: 25px; margin-top: -10px; padding-bottom: 60px; background-color: rgb(252, 252, 252);">
            <div class="container" >
         <!-- cadre de recherche  -->      
          <div class="col-md-12 large-search" style="background-color: #F4C543;padding: 3px;"> 
                    <div class="search-form wow pulse" style="background-color:#EEF0F0;text-align: center;color: black;">
                     <h1  style="text-align: center;color:#F4C543;"><i ><u> Modifier Profile  </u></i>:</h1>
  <br>       
        <%String e=(String)request.getAttribute("erreur"); %>
 <%if(e!=null){ %>
<P style="border:1px double #f65e5e;background-color:geray;padding:10px;margin-left:400px;margin-right:400px;background-color:#ff8c8c;"><img  width="20px" height="20px;" src="error.png" style="margin:5px;"><%=e %></P>
                        <%} %>   
                        <br>    
<form name="form" onsubmit='return v()' action="ModifierProfileServlet">
<%operation op=new operation(); %>
<%int id_personne1=(int)session.getAttribute("id_personne"); %>
<%personne p=op.GetPersonneinfo(id_personne1); %>
<label><img width="30px" height="30px"  src="card.png"> N° Cart Identité :</label>
<input type="text" name="cart identie" disabled="disabled" value="<%=p.getCart_identite() %>" style="width:400px"><br><br>
<label><img width="30px" height="30px"  src="pseudo.png"> pseudo</label>
<input type="text" name="pseudo" value="<%=p.getpseudo() %>" style="width:200px" ><br><br>
<label><img width="20px" height="20px"  src="password.png"> password</label>
<input type="text" name="password" value=<%=p.getPassword() %> style="width:100px"><br><br>
<label><img width="30px" height="30px" src="name.png"> nom</label>
<input type="text" name="nom" value=<%=p.getNom() %> style="width:100px" ><br><br>
<label><img width="30px" height="30px"  src="name.png">prenom</label>
<input type="text" name="prenom" value=<%=p.getPrenom() %> style="width:100px" ><br><br>
<label><img width="30px" height="30px"  src="email.png"> email</label>
<input type="email" name="email" value=<%=p.getEmail() %> style="width:400px" ><br><br>
<label><img width="20px" height="20px"  src="tlf.png"> num_telephone</label>
<input type="tel" name="num_telephone" placeholder="0666-66-66-66" pattern="0[0-9][0-9][0-9]-\d\d-\d\d-\d\d" value=<%=p.getNum_telephone() %> style="width:300px"><br><br>
<input type="submit" style="width: 200px;background-color: #e8e3e3;border: 1px solid #F4C543;" name="modifier" value="Modifier">
</form>
<form action="MonProfile.jsp">
<input type="submit" style="width: 200px;background-color: #e8e3e3;border: 1px solid #F4C543;" name="annuler" value="Annuler">
</form>
 </div>
                </div>
            </div>
        </div>
         <%@ include file="footer2.jsp" %>