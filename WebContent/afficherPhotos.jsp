<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>photos</title>
</head>
<body>
<link rel="stylesheet" href="css/font.css" type="text/css"/>	
			
<%@ include file="header.jsp" %>
<%@ page import="Modele.bien"%>
<%@ page import="Modele.cntrlBien"%>
<%@ page import=" java.util.ArrayList"%>
<% cntrlBien  cb=new cntrlBien();
bien b=new bien();
String id1=(String)request.getParameter("id");
int idb=Integer.parseInt(id1);%>
<div class="main-grid">
			<div class="agile-grids">	
				<!-- gallery -->
				<div class="grids-heading gallery-heading">
					<h2>Photos de bien</h2>
				</div>
				<div class="gallery-grids">
						<div class="show-reel">
							<div class="col-md-3 agile-gallery-grid">
								<div class="agile-gallery">
									<a href="<%=b.getimg1(idb) %>" class="lsb-preview" data-lsb-group="header">
										<img src="<%=b.getimg1(idb) %>" alt="" />
										<div class="agileits-caption">
											<h4>Photo 1</h4>
											
										</div>
									</a>
								</div>
							</div>
							<div class="col-md-3 agile-gallery-grid">
								<div class="agile-gallery">
									<a href="<%=b.getimg2(idb) %>" class="lsb-preview" data-lsb-group="header">
										<img src="<%=b.getimg2(idb) %>" alt="" />
										<div class="agileits-caption">
											<h4>Photo 2</h4>
											
										</div>
									</a>
								</div>
							</div>
							<div class="col-md-3 agile-gallery-grid">
								<div class="agile-gallery">
									<a href="<%=b.getimg3(idb) %>" class="lsb-preview" data-lsb-group="header">
										<img src="<%=b.getimg3(idb) %>" alt="" />
										<div class="agileits-caption">
											<<h4>Photo 3</h4>
										</div>
									</a>
								</div>
							</div>
							<div class="col-md-3 agile-gallery-grid">
								<div class="agile-gallery">
									<a href="<%=b.getimg4(idb) %>" class="lsb-preview" data-lsb-group="header">
										<img src="<%=b.getimg4(idb) %>" alt="" />
										<div class="agileits-caption">
											<h4>Photo 4</h4>
										</div>
									</a>
								</div>
							</div>
							<div class="clearfix"> </div>
						</div>
						
						<div class="show-reel">
							<div class="col-md-3 agile-gallery-grid">
								<div class="agile-gallery">
									<a href="<%=b.getimg2(idb) %>" class="lsb-preview" data-lsb-group="header">
										<img src="<%=b.getimg2(idb) %>" alt="" />
										<div class="agileits-caption">
											<h4>Photo 5</h4>
										</div>
									</a>
								</div>
							</div>
<script>
							$(window).load(function() {
							  $.fn.lightspeedBox();
							});

						</script>
				</div>

<link rel="stylesheet" href="css/lsb.css">
	<script src="js/lsb.js"></script>
	<!-- //gallery -->
	<script src="js/proton.js"></script>
<script src="js/bootstrap.js"></script>
	<script src="js/proton.js"></script>
</body>
</html>