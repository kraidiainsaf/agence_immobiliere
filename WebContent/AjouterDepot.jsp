 <%
	       response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	       response.addHeader("Cache-Control", "post-check=0, pre-check=0");
	       response.setHeader("Pragma", "no-cache");
	       response.setDateHeader("Expires", 0);
    
if(session.getAttribute("id_personne")==null){
	RequestDispatcher DL =request.getRequestDispatcher("authentifg");
DL.forward(request,response);}
	%>  
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
					if((document.form.superficie.value=="")||(document.form.superficie.value==null)){
						alert("vous devez remplir tous les champs!");
						return false;
					}
					if((document.form.prix.value=="")||(document.form.prix.value==null)){
						alert("vous devez remplir tous les champs! ");
						return false;
					}
					if((document.form.adresse.value=="")||(document.form.adresse.value==null)){
						alert("vous devez remplir tous les champs!");
						return false;
					}
					
					if((document.form.wilaya.value=="")||(document.form.wilaya.value==null)){
						alert("vous devez remplir tous les champs!");
						return false;
					}
					if((document.form.description.value=="")||(document.form.description.value==null)){
						alert("vous devez remplir tous les champs!");
						return false;
					}if((document.form.max_colocataire.value=="")||(document.form.max_colocataire.value==null)){
						alert("vous devez remplir tous les champs!");
						return false;
					}
					if((document.form.capacite_stockage.value=="")||(document.form.capacite_stockage.value==null)){
						alert("vous devez remplir tous les champs!");
						return false;
					}
					if((document.form.type.value=="")||(document.form.type.value==null)){
						alert("vous devez remplir tous les champs!");
						return false;
					}
				
				}
		        
		        </script>

 

<div class="home-lager-shearch" style="padding-top: 25px; margin-top: -10px; padding-bottom: 60px; background-color: rgb(252, 252, 252);">
            <div class="container" >
         <!-- cadre de recherche  -->      
          <div class="col-md-12 large-search" style="background-color: #F4C543;padding: 3px;"> 
                    <div class="search-form wow pulse" style="background-color:#f9f8f8;text-align: center;color: black;">

              
<h1  style="text-align: center;color:#F4C543;"><i><img width="80px" height="80px"  src="titre.png"> <u> Ajouter Un Depot </u></i></h1>

<%String e=(String)request.getAttribute("erreur"); %>
 <%if(e!=null){ %>
<P style="border:1px double #f65e5e;background-color:geray;padding:10px;margin-left:400px;margin-right:400px;background-color:#ff8c8c;"><img  width="20px" height="20px;" src="error.png" style="margin:5px;"><%=e %></P>
                        <%} %>
<br><br>
<form name="form" action="VerfierAjouteServlet" method="get" onsubmit='return v()' >
<label><img width="15px" height="15px" src="seperficie2.png"> Superficié (Mètres carrés ):</label>
<input type="number" name="superficie"  placeholder="200.000 m²" min="10" maxlength="10000000000" style="width:200px;"><br><br>
<label><img width="22px" height="22px" src="adress.png"> Wilaya</label>
<input type="number" list="wilaya" min=1 max="48"  placeholder="(12 tebessa ) " style="width:200px;" name="wilaya" ><br><br>
<datalist id="wilaya"  > 
<option value="1">Adrar</option>
<option value="2" >Chlef</option>
<option value="3" >Laghouat</option>
<option value="4" >Oum El Bouaghi</option>
<option value="5" >Batna</option>
<option value="6" >Béjaïa</option>
<option value="7" >Biskra</option>
<option value="8" >Béchar</option>
<option value="9" >Blida</option>
<option value="10" >Bouira</option>
<option value="11" >Tamanrasset</option>
<option value="12" >Tébessa</option>
<option value="13" >Tlemcen</option>
<option value="14" >Tiaret</option>
<option value="15" >Tizi Ouzou</option>
<option value="16" >Alger</option>
<option value="17" >Djelfa</option>
<option value="18" >Jijel</option>
<option value="19" >Sétif</option>
<option value="20" >Saïda</option>
<option value="21" >Skikda</option>
<option value="22" >Sidi Bel Abbès</option>
<option value="23" >Annaba </option>
<option value="24" >Guelma</option>
<option value="25" >Constantine</option>
<option value="26" >Médéa</option>
<option value="27" >Mostaganem</option>
<option value="28" >M'Sila</option>
<option value="29" >Mascara</option>
<option value="30" >Ouargla</option>
<option value="31" >Oran</option>
<option value="32" >El Bayadh</option>
<option value="33" >Illizi</option>
<option value="34" >Bordj Bou Arreridj</option>
<option value="35" >Boumerdès</option>
<option value="36" >El Tarf</option>
<option value="37" >Tindouf </option>
<option value="38" >Tissemsilt</option>
<option value="39" >El Oued </option>
<option value="40" >Khenchela</option>
<option value="41" >Souk Ahras</option>
<option value="42" >Tipaza</option>
<option value="43" >Mila </option>
<option value="45" >Aïn Defla </option>
<option value="46" >Naâma </option>
<option value="47" >Aïn Témouchent</option>
<option value="48" >Relizane</option>
</datalist>
<label><img width="30px" height="30px" src="prix.png"> Prix de jour (en dinare DA) :</label>
<input type="number" name="prix" placeholder="100.000 DA" max="100000000000.00" min="50.000"  style="width:200px;"><br><br>

<label><img width="20px" height="20px" src="position.png"> Adresse (ou localisation) :</label>
<input type="text" name="adresse" placeholder="ain bay route 125" style="width:200px;"><br><br>
<label><img width="30px" height="30px" src="ecole.png"><img width="30px" height="30px" src="hos.png">
<img width="30px" height="30px" src="cafe.png"><img width="20px" height="20px" src="frit.png"> Descriptions :</label><br><br>
<TEXTAREA  name="description"   rows=4 cols=40 >café                                restaurant                              ecole                               hopitale                               ,meubleé..</TEXTAREA><br><br>
<label><img width="20px" height="20px" src="locataire.png">	Max Locataire :</label>
<input type="number" name="max_colocataire" placeholder="Un seul locataire a la foi"  max="10" min="1" style="width:200px;"><br><br>

<label><img width="30px" height="30px" src="box.png">Capacite de stockage :</label>
<label class="radio-inline">100-500 box <input type="radio" name="capacite_stockage" value="500" ></label>
<label class="radio-inline">500-1000 box <input type="radio" name="capacite_stockage" value="1000"></label>
<label class="radio-inline">1000-1500 box <input type="radio" name="capacite_stockage" value="1500"></label><br>
<br>
<label><img width="20px" height="20px" src="depot.png">Type depot :</label>
<label class="radio-inline">Depot a ciel ouvert(non couvet) <input type="radio" name="type" value="depot a ciel ouvert(non couvet)" ></label>
<label class="radio-inline">Frigorifique <input type="radio" name="type" value=" frigorifique"></label>
<label class="radio-inline">Depot couvet <input type="radio" name="type" value="depot couvet" ></label><br>

<input type="hidden" name="typebien" value="depot">
<input type="submit" style="width: 200px;background-color: #e8e3e3;border: 1px solid #F4C543;"  name="établir votre  contrat" value="établir votre  contrat">
</form>
 </div>
            </div>
        </div></div>
         <%@ include file="footer2.jsp" %>
