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
<%@page import="Modele.maison" %>
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
					if((document.form.nbr_facade.value=="")||(document.form.nbr_facade.value==null)){
						alert("vous devez remplir tous les champs!");
						return false;
					}
					if((document.form.nbr_chambre.value=="")||(document.form.nbr_chambre.value==null)){
						alert("vous devez remplir tous les champs!");
						return false;
					}
					if((document.form.parking.value=="")||(document.form.parking.value==null)){
						alert("vous devez remplir tous les champs!");
						return false;
					}
					if((document.form.jardin.value=="")||(document.form.jardin.value==null)){
						alert("vous devez remplir tous les champs!");
						return false;
					}
				}
		        
		        </script>

<%maison m=(maison) session.getAttribute("maison");%>
<div class="home-lager-shearch" style="padding-top: 25px; margin-top: -10px; padding-bottom: 60px; background-color: rgb(252, 252, 252);"  style="text-align:center;">
            <div class="container"  style="text-align: center;">
         <!-- cadre de recherche  -->      
          <div class="col-md-12 large-search" style="background-color: #F4C543;padding: 3px;"  style="text-align:center;"> 
                    <div class="search-form wow pulse" style="background-color:#f9f8f8;text-align: center;color: black;">
  <h2  style="text-align: center;color:#F4C543;"><i ><u> Modifier Maison</u></i>:</h2><br>
<form name="form" action="ModifierBienServlet2" method="get" style="text-align: center;" onsubmit='return v()' >
<label><img width="30px" height="30px" src="chambre.png"> Nombre Du Chambre :</label>
<%int n=m.getNbr_chambre();char k='"';String a1="",a2="",a3="",a4="",a5="";
if(n==1){
    a1="checked="+k+"checked"+k;
}
if(n==2){
	 a2="checked="+k+"checked"+k;
}
if(n==3){
	 a3="checked="+k+"checked"+k;
}
if(n==4){
	 a4="checked="+k+"checked"+k;
}
if(n==5){
	 a5="checked="+k+"checked"+k;
}
%>
<label class="radio-inline"> F1 <input type="radio" <%=a1 %>  name="nbr_chambre" value="1" ></label>
<label class="radio-inline"> F2 <input type="radio" <%=a2 %> name="nbr_chambre" value="2"></label>
<label class="radio-inline"> F3 <input type="radio" <%=a3 %> name="nbr_chambre" value="3"></label>
<label class="radio-inline"> F4 <input type="radio" <%=a4 %>  name="nbr_chambre" value="4"></label>
<label class="radio-inline"> F5 <input type="radio" <%=a5 %> name="nbr_chambre" value="5"></label><br><br>
<%int nf=m.getNbr_facade();String af1="",af2="",af3="",af4="",af5="";
if(nf==1){
    af1="checked="+k+"checked"+k;
}
if(nf==2){
	 af2="checked="+k+"checked"+k;
}
if(nf==3){
	 af3="checked="+k+"checked"+k;
}
if(nf==4){
	 af4="checked="+k+"checked"+k;
}
%>
<label><img width="30px" height="30px" src="facade.png"> Nombre Du Facade :</label>
<label class="radio-inline"> 1 <input type="radio" <%=af1%> name="nbr_facade" value="1" ></label>
<label class="radio-inline"> 2 <input type="radio" <%=af2 %> name="nbr_facade" value="2"></label>
<label class="radio-inline"> 3  <input type="radio" <%=af4 %> name="nbr_facade" value="3"></label>
<label class="radio-inline"> 4  <input type="radio" <%=af5 %> name="nbr_facade" value="4"></label><br><br>
<%Boolean j=m.getJardin(); String j1="",j2="";
if(j.equals(true)){
    j1="checked="+k+"checked"+k;
}
if(j.equals(false)){
	 j2="checked="+k+"checked"+k;
}
%>
<label><img width="30px" height="30px" src="jardin.png"> Avec Jardin :</label>
<label class="radio-inline"> Oui <input type="radio" <%=j1 %> name="jardin" value="true" ></label>
<label class="radio-inline"> Non<input type="radio" <%=j2 %> name="jardin" value="false"></label><br><br>
<%Boolean p=m.getParking(); String p1="",p2="";
if(p.equals(true)){
    p1="checked="+k+"checked"+k;
}
if(p.equals(false)){
	 p2="checked="+k+"checked"+k;
}
%>
<label><img width="30px" height="30px" src="parking.png"> Avec Parking :</label>
<label class="radio-inline"> Oui <input type="radio" <%=p1 %> name="parking" value="true" ></label>
<label class="radio-inline"> Non <input type="radio" <%=p2 %> name="parking" value="false"></label><br><br>
<label><img width="20px" height="20px" src="seperficie2.png"> Superficié (Mètres carrés ):</label>
<input type="number" name="superficie" style="width:200px;" value=<%=m.getSuperficie() %> disabled="disabled" ><br><br>
<label><img width="22px" height="22px" src="adress.png"> Wilaya</label>
<input type="text" name="wilaya" style="width:200px;" disabled="disabled" value=<%=m.getWilaya() %> ><br><br>
<label><img width="30px" height="30px" src="prix.png"> Prix de jour (en dinare DA) :</label>
<input type="number" name="prix" style="width:200px;" value=<%=m.getPrix() %>><br><br>
<label><img width="20px" height="20px" src="position.png"> Adresse (ou localisation) :</label>
<input type="text" name="adresse" style="width:200px;" disabled="disabled" value=<%=m.getAdresse() %>><br><br>
<label><img width="30px" height="30px" src="cafe.png"><img width="20px" height="20px" src="frit.png"> Descriptions :</label>
<input type="text" name="description" style="width:200px;" value=<%=m.getdescription() %>><br><br>
<label><img width="20px" height="20px" src="locataire.png">	Max Locataire :</label>
<input type="number" name="max_colocataire" style="width:200px;" value=<%=m.getMax_colocataire() %>><br><br>
      <input type="hidden" name="id_bien" value=<%=m.getId_bien() %> >

<input type="hidden" name="typebien" value="maison">
<input type="submit" style="color:#F4C543;border:1px solid #F4C543;width:100px;"  name="MODIFIER" value="Modifier">
</form>
<br>
 <form action="ModifierBienServlet" method="get">
      <input type="hidden" name="id_bien" value=<%=m.getId_bien() %> >
         <input type="hidden" name="typebien" value="maison" >
         <input type="submit" style="color:#F4C543;border:1px solid #F4C543;width:100px;"  name="RESTAURATION" value="Restaurer">   
         </form>
</div></div></div></div>
  <%@ include file="footer2.jsp" %>
