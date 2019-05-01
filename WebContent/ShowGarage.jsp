<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="header2.jsp" %>
  <div class="home-lager-shearch"  style="padding-top: 25px; margin-top: -130px; padding-bottom: 60px; background-color: rgb(252, 252, 252);">
            <div class="container" >
         <!-- cadre de recherche  -->      
          <div class="col-md-12 large-search"  style="background-color: #F4C543;padding: 3px;"> 
                    <div class="search-form wow pulse"  style="background-color:#ffffff;text-align: center;color: black;">
   
                     <%@page import="Modele.garage " %>
    <%@page import="Modele.operation" %>
   <%operation op=new operation(); %>
   <%ArrayList<garage> list=null;%>
<%list=op.ShowGarage();int i=0;%>
   
   <h1  style="color:#F4C543;font-family: serif;"><i >Les garages</i>:</h1>
<br><br>
 <div class="col-md-12 clear " style="display:inline;text-align: center;"> 
                        <div id="list-type" class="proerty-th" >
                        <%while(list.isEmpty()==false){
	garage m=list.get(i);
%>
                            <div class="col-sm-6 col-md-3 p0" >
                                <div class="box-two proerty-item" >
                                    <div class="item-thumb">
                                       <img width="50" height="50" src="<%=m.getImage1()%>">
                                    </div>

                                    <div class="item-entry overflow">
                                        <div class="dot-hr"></div>
                                        <span class="pull-right"><b> Superficie :</b><%=m.getSuperficie() %> m2</span> <br>
                                        <span class="pull-left"><b> Adresse :</b><%=m.getAdresse()%></span> <br>
                                        <span class="proerty-price pull-right"><b> Prix :</b><%=m.getPrix()%> DA</span>
                                         <form action="RechercherBienDetailServlet" method="get">
		<% 
		
if(op.GetMaxColocataire(m.getId_bien())!=1){
	%>
	<input type="hidden" name="type_colocation" value="colocation"> 
	<%}else{ %>
		<input type="hidden" name="type_colocation" value="normale"> 
	<%} %>
	<input type="hidden" name="id_bien" value=<%=m.getId_bien()%>> 
    <input type="submit" name="prolonger" value="voir bien" style="border: 2px solid #F4C543;"> <hr></form>
                                      
      
                                    </div>
                                </div>   
                    
                </div>
                 <%list.remove(i);} %> 
                
                 </div>          
            </div>

 </div></div></div></div>
            
        
        
 
 
 
 
 
 <%@ include file="footer.html" %>