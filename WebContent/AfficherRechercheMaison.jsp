 
<%@page import="java.util.ArrayList"%>
<%if(session.getAttribute("id_personne")==null){%>
 <%@ include file="header2.jsp" %>

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


        <div class="home-lager-shearch"  style="padding-top: 25px; margin-top: -10px; padding-bottom: 60px; background-color: rgb(252, 252, 252);">
            <div class="container" >
         <!-- cadre de recherche  -->      
          <div class="col-md-12 large-search"  style="background-color: #F4C543;padding: 3px;"> 
                    <div class="search-form wow pulse"  style="background-color: #fdfdfd;text-align: center;color: black;">
                     <%@page import="Modele.maison" %>
    <%@page import="Modele.operation" %>
   <%operation op=new operation(); %>
   <%ArrayList<maison> list=null;%>
<%list=(ArrayList<maison>)session.getAttribute("list");%>
   <%System.out.print("liste "+list); %>
   <%if(list==null){
	   RequestDispatcher DL =request.getRequestDispatcher("agence_immobiliere.jsp");
		DL.forward(request,response);
	   
   } %>
   <h1  style="color:#F4C543;"><i > Resultat du recherche </i>:</h1>

 <h6 style="color: #dfdfdf;">Vous avez (<%=list.size() %>) resultat ! : </h6>

<br><br>
 <div class="col-md-12 clear " style="display:inline;text-align: center;"> 
                        <div id="list-type" class="proerty-th" >
                        <%for(int i=0;i<list.size();i++){
	maison m=list.get(i);
%>
                            <div class="col-sm-6 col-md-3 p0" >
                                <div class="box-two proerty-item" >
                                    <div class="item-thumb">
                                       <img width="50" height="50" src="<%=m.getImage1()%>">
                                    </div>

      <%String jardin; %>
      <%if(m.getJardin()==true){
    	   jardin="oui";
      }else{
    	  jardin="non";

      } %>     
      
       <%String parking; %>
      <%if(m.getParking()==true){
    	   parking="oui";
      }else{
    	  parking="non";

      } %>     
                                    <div class="item-entry overflow">
                                        <div class="dot-hr"></div>
                                        <span class="pull-right"><b> Superficie :</b><%=m.getSuperficie() %> m2</span> <br>
                                        <span class="pull-left"><b> Adresse :</b><%=m.getAdresse()%></span> <br>
                                        <span class="proerty-price pull-right"> Prix :<%=m.getPrix()%> DA</span>
                                        <div class="property-icon">
                                            <img width="30px" height="30px" src="facade.png">(<%=m.getNbr_facade() %>)|
                                            <img width="30px" height="30px" src="chambre.png">(<%=m.getNbr_chambre() %>)
                                           <img width="30px" height="30px" src="jardin.png">(<%=jardin %>)|
                                            <img width="30px" height="30px" src="parking.png">(<%=parking %>)
                                        </div>
                                        <form action="RechercherBienDetailServlet">
      <%int max_colocataire=m.getMax_colocataire(); %>
      <%if(max_colocataire!=1){%>
          <input type="hidden" name="type_colocation" value="colocation" >
    <%   }else{    %> 
              <input type="hidden" name="type_colocation" value="normale" >
    	  
   <% } %>
      <input type="hidden" name="id_bien" value=<%=m.getId_bien() %> >
    <%session.setAttribute("typebien","maison");%>
      <input type="submit" name="detail" value="detail"> </form>
      
                                    </div>
                                </div>   
                    
                </div>
                 <%} %> 
                
                 </div>          
            </div>

 </div></div></div></div>
 <%@ include file="footer.html" %>