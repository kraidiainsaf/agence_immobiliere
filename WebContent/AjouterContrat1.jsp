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
					if((document.form.ajoute1.value=="")||(document.form.ajoute1.value==null)){
						alert("vous devez remplir tous les champs!");
						return false;
					}
					if((document.form.ajoute2.value=="")||(document.form.ajoute2.value==null)){
						alert("vous devez remplir tous les champs! ");
						return false;
					}
					if((document.form.ajoute3.value=="")||(document.form.ajoute3.value==null)){
						alert("vous devez remplir tous les champs!");
						return false;
					}
					
					if((document.form.ajoute4.value=="")||(document.form.ajoute4.value==null)){
						alert("vous devez remplir tous les champs!");
						return false;
					}
					if((document.form.ajoute5.value=="")||(document.form.ajoute5.value==null)){
						alert("vous devez remplir tous les champs!");
						return false;
					}
				}
		        
		        </script>



  <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Contart</title>
        <meta name="description" content="GARO is a real-estate template">
        <meta name="author" content="Kimarotec">
        <meta name="keyword" content="html5, css, bootstrap, property, real-estate theme , bootstrap template">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,700,800' rel='stylesheet' type='text/css'>

        <!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
        <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <link rel="icon" href="favicon.ico" type="image/x-icon">

        <link rel="stylesheet" href="assets/css/normalize.css">
        <link rel="stylesheet" href="assets/css/font-awesome.min.css">
        <link rel="stylesheet" href="assets/css/fontello.css">
        <link href="assets/fonts/icon-7-stroke/css/pe-icon-7-stroke.css" rel="stylesheet">
        <link href="assets/fonts/icon-7-stroke/css/helper.css" rel="stylesheet">
        <link href="css/animate.css" rel="stylesheet" media="screen">
        <link rel="stylesheet" href="assets/css/bootstrap-select.min.css"> 
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/icheck.min_all.css">
        <link rel="stylesheet" href="assets/css/price-range.css">
        <link rel="stylesheet" href="assets/css/owl.carousel.css">  
        <link rel="stylesheet" href="assets/css/owl.theme.css">
        <link rel="stylesheet" href="assets/css/owl.transitions.css"> 
        <link rel="stylesheet" href="assets/css/wizard.css"> 
        <link rel="stylesheet" href="assets/css/style.css">
        <link rel="stylesheet" href="assets/css/responsive.css">
 <div class="content-area submit-property" style="background-color:#ffffff;">&nbsp;
            <div class="container">
                <div class="clearfix" > 
                    <div class="wizard-container"> 

                        <div class="wizard-card ct-wizard-orange" id="wizardProperty" style="background-color:#f4f1f1;">
<form name="form" method="get" action="AjouterBienServlet" onsubmit='return v()' >
                                <div class="wizard-header">
                                    <h3>
                                        <b>Contrat </b> Etablire Votre contrat rapidement <br>
                                    </h3>
                                </div>

                                <ul>
                                    <li><a href="#step1" data-toggle="tab">Step 1 </a></li>
                                    <li><a href="#step2" data-toggle="tab">Step 2 </a></li>
                                    <li><a href="#step3" data-toggle="tab">Step 3 </a></li>
                                    <li><a href="#step4" data-toggle="tab">Step 4 </a></li>
                                    <li><a href="#step5" data-toggle="tab">final</a></li>
                                </ul>

                                <div class="tab-content">

                                    <div class="tab-pane" id="step1">
                                        <div class="row p-b-15  ">
                                      <img width="300px" height="300px" src="g1.png">
                                           
                                            <div class="col-sm-6">
                                                <div class="form-group" style="text-align: center;">
<h1><label>Est ce que votre bien est sous garantie ?</label><br></h1>
<label class="radio-inline"> bien est sous garantie  <input type="radio" name="ajoute1" value="bien est sous garantie" ></label><br>
<label class="radio-inline"> bien non garantie  <input type="radio" name="ajoute1" value="bien non garantie"></label><br>

                                                </div>
                                               
                                            </div>
                                        </div>
                                    </div>
                                    <!--  End step 1 -->

                                    <div class="tab-pane" id="step2">
                                        <div class="row p-b-15  ">
                                      <img width="300px" height="300px" src="pina.png">
                                        
                                            <div class="col-sm-6">
                                                <div class="form-group" style="text-align: center;">
<h1><label>si le locataire  de votre bien a retarde le paiement de ......jours  il va etre pinalise :</label></h1><br>
<label class="radio-inline"> 10% du montant totale <input type="radio" name="ajoute2" value="20% pour chaque jour de retard" ></label><br>
<label class="radio-inline"> 20% de montant totale <input type="radio" name="ajoute2" value="15% pour chaque jour de retard "></label><br>
<label class="radio-inline"> 30% de montant totale <input type="radio" name="ajoute2" value="10% pour chaque jour de retard"></label><br>

                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- End step 2 -->

                                    <div class="tab-pane" id="step3">   
                                    <div class="row p-b-15  ">
                                                <img width="300px" height="300px" src="jour2.png">
                                           
                                            <div class="col-sm-6">
                                                <div class="form-group" style="text-align: center;">
<h1><label> Quel jour de chaque mois le loyer sera payable(le cas du mode payement est mensuel) ?</label></h1><br>
<label class="radio-inline"> En debut du mois (1-15) <input type="radio" name="ajoute3" value="en debut du mois " ></label><br>
<label class="radio-inline"> En fin du mois (15-30)<input type="radio" name="ajoute3" value="en fin du mois"></label><br>

                                                </div>
                                            </div>
                                        </div>
                                    </div>                                     
                                       
                                    <!--  End step 4 -->
                                     <div class="tab-pane" id="step4">   
                                    <div class="row p-b-15  ">
                                                         <img width="300px" height="300px" src="construction.png">
                                           
                                            <div class="col-sm-6">
                                                <div class="form-group" style="text-align: center;">
<h1><label>Periode de construction du logement :</label></h1><br>
<label class="radio-inline"> De 1940 a 1990<input type="radio" name="ajoute4" value="De 1940 a 1990"></label><br>
<label class="radio-inline"> De 1990 a 2000<input type="radio" name="ajoute4" value="De 1990 a 2000"></label><br>
<label class="radio-inline"> De 2000 a 2010<input type="radio" name="ajoute4" value="De 2000 a 2010"></label><br>
<label class="radio-inline"> Depuis 2010<input type="radio" name="ajoute4" value="Depuis 2010"></label><br>
<br>
                                                </div>
                                            </div>
                                            
                                              
                                        </div>
                                         <div class="row p-b-15  ">
                                                                <img width="300px" height="150px" src="contratcondition.png">
                                           
                                             <div class="col-sm-6">
                                                <div class="form-group" style="text-align: center;">

<h1><label>Des Autres Conditions particuliers :</label></h1>
<TEXTAREA  name="ajoute5"   rows=2 cols=40 >-</TEXTAREA><br>

                                                </div>
                                            </div>
                                            
                                              
                                        </div>
                                       
                                    </div>   

                                </div>
<!-- end 4 step -->
                                <div class="wizard-footer">
                                    <div class="pull-right">
                                        <input type='button' class='btn btn-next btn-primary' name='next' value='Next' />
                                        <input type="submit" class='btn btn-finish btn-primary ' value="voir contrat" />
                                    </div>

                                    <div class="pull-left">
                                        <input type='button' class='btn btn-previous btn-default' name='previous' value='Previous' />
                                    </div>
                                    <div class="clearfix"></div>                                            
                                </div>	
                            </form>
                        </div>
                        <!-- End submit form -->
                    </div> 
                </div>
            </div>
        </div>

  <%@ include file="footer2.jsp" %>
          <script src="assets/js/vendor/modernizr-2.6.2.min.js"></script>
        <script src="assets/js//jquery-1.10.2.min.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/js/bootstrap-select.min.js"></script>
        <script src="assets/js/bootstrap-hover-dropdown.js"></script>
        <script src="assets/js/easypiechart.min.js"></script>
        <script src="assets/js/jquery.easypiechart.min.js"></script>
        <script src="assets/js/owl.carousel.min.js"></script>
        <script src="assets/js/wow.js"></script>
        <script src="assets/js/icheck.min.js"></script>

        <script src="assets/js/price-range.js"></script> 
        <script src="assets/js/jquery.bootstrap.wizard.js" type="text/javascript"></script>
        <script src="assets/js/jquery.validate.min.js"></script>
        <script src="assets/js/wizard.js"></script>

        <script src="assets/js/main.js"></script>