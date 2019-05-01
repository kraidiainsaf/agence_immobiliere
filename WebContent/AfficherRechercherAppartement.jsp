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

  <%@page import="Modele.appartement" %>
    <%@page import="Modele.operation" %>


        <div class="home-lager-shearch"  style="padding-top: 25px; margin-top: -10px; padding-bottom: 60px; background-color: rgb(252, 252, 252);">
            <div class="container" >
         <!-- cadre de recherche  -->      
          <div class="col-md-12 large-search"  style="background-color: #F4C543;padding: 3px;"> 
                    <div class="search-form wow pulse"  style="background-color: #fdfdfd;text-align: center;color: black;">
                     <%@page import="Modele.maison" %>
    <%@page import="Modele.operation" %>
   <%operation op=new operation(); %>


 <div class="col-md-12 clear " style="display:inline;text-align: center;"> 
                        <div id="list-type" class="proerty-th" >
                   
<%ArrayList<appartement> list=null;%>
<%list=(ArrayList<appartement>)session.getAttribute("list");int i=0;%>
 <%if(list==null){
	   RequestDispatcher DL =request.getRequestDispatcher("agence_immobiliere.jsp");
		DL.forward(request,response);
	   
   } %>
 <h1  style="color:#F4C543;"><i >Resultat du recherche </i>:</h1>

 <h6 style="color: #dfdfdf;">Vous avez (<%=list.size() %>) resultat ! : </h6>

<br><br>
<%while(list.isEmpty()==false){
	appartement a=list.get(i);
%>
                            <div class="col-sm-6 col-md-3 p0" >
                                <div class="box-two proerty-item" >
                                    <div class="item-thumb">
                                       <img width="50" height="50" src="<%=a.getImage1()%>">
                                    </div>

                                    <div class="item-entry overflow">
                                        <div class="dot-hr"></div>
                                        <span class="pull-right"><b> Superficie :</b><%=a.getSuperficie() %></span><br>
                                        <span class="pull-left"><b> Adresse :</b><%=a.getAdresse()%></span><br>
                                        <span class="proerty-price pull-right"> prix :<%=a.getPrix()%></span>
                                        <div class="property-icon">
                                            <img width="30px" height="30px" src="etage.png">(<%=a.getEtage() %>)|
                                            <img width="30px" height="30px" src="chambre.png">(<%=a.getNbr_chambre() %>)
                                           
                                        </div>
                                        <form action="RechercherBienDetailServlet">
      <%int max_colocataire=a.getMax_colocataire(); %>
      <%if(max_colocataire!=1){%>
          <input type="hidden" name="type_colocation" value="colocation" >
    <%   }else{    %> 
              <input type="hidden" name="type_colocation" value="normale" >
    	  
   <% } %>
      <input type="hidden" name="id_bien" value=<%=a.getId_bien() %> >
  <%session.setAttribute("typebien","appartement");%>  
      <input type="submit" name="detail" value="detail"> </form>
      
                                    </div>
                                </div>   
                    
                </div>
                 <%list.remove(i);} %> 
                
                 </div>          
            </div>

 </div></div></div></div>
 <%@ include file="footer.html" %>

  
 
