
<%@page import="Modele.personne"%>
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

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
      <section  id="comments" class="comments wow fadeInRight animated"  > <br>
                            <h1 style="text-align:center;color:#F4C543;" class="text-uppercase wow fadeInLeft animated">Proprietaires : </h1>

<%operation op=new operation(); %>
<%ArrayList<personne> liste=new ArrayList<personne>();
liste=op.getProprietaires();
for(int i=0;i<liste.size();i++){
	personne p=liste.get(i);
%>
                            <div style="margin:100px;" class="row comment">
                                <div class="col-sm-3 col-md-2 text-center-xs">
                                    <p>
                                        <img src="assets/img/client-face1.png" class="img-responsive img-circle" alt="">
                                    </p>
                                </div>
                                <div class="col-sm-9 col-md-10">
                                    <h5 > Nom et Prenom :<%=op.GetNamePersonne(p.getId_personne()) %></h5>
                                    <p class="posted"><i class="fa fa-clock-o"></i>Adresse Email :<%=p.getEmail() %></p>
                                    <p> Numero de telephone :<%=p.getNum_telephone() %></p>
                                    <p class="reply"><a href="#"><i class="fa fa-reply"></i> Retour</a>
                                    </p>
                                </div>
                            </div>
                            <!-- /.comment -->


                        <%} %>
                        </section>

   <%@ include file="footer2.jsp" %>
