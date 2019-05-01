
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">

     function v() {
					if((document.form.prixmax.value=="")||(document.form.prixmax.value==null)){
						alert("vous devez remplir tous les champs! ");
						return false;
					}
					if((document.form.prixmin.value=="")||(document.form.prixmin.value==null)){
						alert("vous devez remplir tous les champs!");
						return false;
					}
					if((document.form.smin.value=="")||(document.form.smin.value==null)){
						alert("vous devez remplir tous les champs!");
						return false;
					}
					if((document.form.smax.value=="")||(document.form.smax.value==null)){
						alert("vous devez remplir tous les champs!");
						return false;
					}
					if((document.form.caracteristique.value=="")||(document.form.caracteristique.value==null)){
						alert("vous devez remplir tous les champs!");
						return false;
					}
					if((document.form.wilaya.value=="")||(document.form.wilaya.value==null)){
						alert("vous devez remplir tous les champs!");
						return false;
					}
				}
		        
		        </script>
		        <%
if(session.getAttribute("id_personne")==null){%>
 <%@ include file="header.html" %>
<%}else{ %>
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
 <%}} }%> 
<title>Recherche terrain</title></head>
 
        <div class="home-lager-shearch" style="padding-top: 25px; margin-top: -10px; padding-bottom: 60px; background-color: rgb(252, 252, 252);">
            <div class="container" >
         <!-- cadre de recherche  -->      
          <div class="col-md-12 large-search" style="background-color: #F4C543;padding: 3px;"> 
                    <div class="search-form wow pulse" style="background-color:#f9f8f8;text-align: center;color: black;">
                        <form name="form" action="RechercherBienServlet" method="post" class=" form-inline" onsubmit='return v()' >
                            
                        <h1  style="text-align: center;color:#F4C543;"><i ><u> Choisir Vos Critaires </u></i>:</h1>
		      <%String e=(String)request.getAttribute("erreur"); %>
                        <%if(e!=null){ %>
<P style="border:1px double #f65e5e;background-color:geray;padding:10px;margin-left:400px;margin-right:400px;background-color:#ff8c8c;"><img  width="20px" height="20px;" src="error.png" style="margin:5px;"><%=e %></P>
                        <%} %><br><br>
<input type="hidden" name="typebien" value="terrain">
<label>Caracteristique  :</label>
<label class="radio-inline"><img width="20px" height="20px" src="climo.png"> Industriel <input type="radio" name="caracteristique" value="industriel" ></label>
<label class="radio-inline"><img width="20px" height="20px" src="tomat.png"> Agricole <input type="radio" name="caracteristique" value="Agricole"></label><br>
<br><label><img width="20px" height="20px" src="seperficie2.png"> Superficie maximale (en m²) :</label>
<input type="number" name="smax" placeholder="2m²" min="1" style="width:200px;"><br><br>
<label><img width="30px" height="30px" src="superficie.png"> Superficie minimale (en m²):</label>
<input type="number" name="smin" placeholder="1m²" min="1" style="width:200px;" ><br><br>

<label><img width="30px" height="30px" src="prix.png"> Prix maximum (en dinare DA):</label>
<input type="number" name="prixmax" placeholder="100.000 DA" max="100.000.000.000" min="50.000" style="width:200px;"><br><br>
<label><img width="30px" height="30px" src="prix1.png"> Prix minimum (en dinare DA) :</label>
<input type="number" name="prixmin"  placeholder="50.000 DA" min="50.000" max="100.000.000.000" style="width:200px;" ><br><br>
<label><img width="25px" height="25px" src="position.png"> Wilaya</label>
<input type="number" list="wilaya" min=1 max="48"  placeholder="(12 tebessa ) " style="width:200px;" name="wilaya" ><br>
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
</datalist><br>
		               <div class="center">
                                <input type="submit" value="" class="btn btn-default btn-lg-sheach">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
	
    
    <%@ include file="footer.html" %>