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
 <%@ include file="header_proprietaire.jsp" %>
 <%} %>

<%@page import="Modele.locale_commercial" %>
<script type="text/javascript">
		        function v() {
		        	
					
					if((document.form.prix.value=="")||(document.form.prix.value==null)){
						alert("vous devez remplir tous les champs! ");
						return false;
					}
					
					
					if((document.form.description.value=="")||(document.form.description.value==null)){
						alert("vous devez remplir tous les champs!");
						return false;
					}if((document.form.max_colocataire.value=="")||(document.form.max_colocataire.value==null)){
						alert("vous devez remplir tous les champs!");
						return false;
					}
					
					if((document.form.type_local.value=="")||(document.form.type_local.value==null)){
						alert("vous devez remplir tous les champs!");
						return false;
					}
					
				}
		        
		        </script>

<%locale_commercial m=(locale_commercial) session.getAttribute("locale_commercial");%>
<div class="home-lager-shearch" style="padding-top: 25px; margin-top: -10px; padding-bottom: 60px; background-color: rgb(252, 252, 252);"  style="text-align:center;">
            <div class="container"  style="text-align: center;">
         <!-- cadre de recherche  -->      
          <div class="col-md-12 large-search" style="background-color: #F4C543;padding: 3px;"  style="text-align:center;"> 
                    <div class="search-form wow pulse" style="background-color:#f9f8f8;text-align: center;color: black;">
    <h2  style="text-align: center;color:#F4C543;"><i ><u> Modifier Locale </u></i>:</h2><br>
  
<form name="form" action="ModifierBienServlet2" method="get" onsubmit='return v()'>
<label><img width="20px" height="20px" src="seperficie2.png">Superficié (Mètres carrés ):</label>
<input type="number" name="superficie" style="width:200px;" value=<%=m.getSuperficie() %> disabled="disabled" ><br><br>
<label><img width="22px" height="22px" src="adress.png"> Wilaya</label>
<input type="text" name="wilaya" style="width:200px;" disabled="disabled" value=<%=m.getWilaya() %> ><br><br>
<label><img width="30px" height="30px" src="prix.png">Prix de jour (en dinare DA) :</label>
<input type="number" name="prix" style="width:200px;" value=<%=m.getPrix() %>><br><br>
<label><img width="20px" height="20px" src="position.png">Adresse (ou localisation) :</label>
<input type="text" name="adresse" style="width:200px;" disabled="disabled" value=<%=m.getAdresse() %>><br><br>
<label><img width="30px" height="30px" src="cafe.png"><img width="20px" height="20px" src="frit.png"> Descriptions :</label>
<input type="text" name="description" style="width:200px;" value=<%=m.getdescription() %>><br><br>
<label><img width="20px" height="20px" src="locataire.png">	Max Locataire :</label>
<input type="number" name="max_colocataire" style="width:200px;" value=<%=m.getMax_colocataire() %>><br><br>
<br>
<%String n=m.getType_local();char k='"';String a1="",a2="",a3="",a4="";
if(n.equals("boutique")){
    a1="checked="+k+"checked"+k;
}
if(n.equals("cabinet")){
	 a2="checked="+k+"checked"+k;
}
if(n.equals("magasin(ou superet)")){
	 a3="checked="+k+"checked"+k;
}
if(n.equals("marché")){
	 a4="checked="+k+"checked"+k;
}
%>
<label><img width="20px" height="20px" src="local.png">Type Locale :</label>
<label class="radio-inline"> boutique <input type="radio" <%=a1 %> name="type_local" value="boutique"></label>
<label class="radio-inline"> cabinet (medicale,conptabilité,les travaux lidirale) <input type="radio" <%=a2 %> name="type_local" value="cabinet" ></label>
<label class="radio-inline"> magasin(ou superet) <input type="radio" <%=a3 %> name="type_local" value="magasin(ou superet)"></label>
<label class="radio-inline"> marché <input type="radio" <%=a4 %> name="type_local" value="marché"></label>
<br><br>
<input type="hidden" name="id_bien" value=<%=m.getId_bien() %> >
<input type="hidden" name="typebien" value="locale_commercial">
<input type="submit" style="color:#F4C543;border:1px solid #F4C543;width:100px;"  name="MODIFIER" value="Modifier">
</form><br>
 <form action="ModifierBienServlet" method="get">
      <input type="hidden" name="id_bien" value=<%=m.getId_bien() %> >
<input type="hidden" name="typebien" value="locale_commercial">
         <input type="submit" style="color:#F4C543;border:1px solid #F4C543;width:100px;"  name="RESTAURATION" value="Restaurer">   
         </form>
</div></div></div></div>
  <%@ include file="footer2.jsp" %>