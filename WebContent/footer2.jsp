   <div class="footer-copy text-center">
                <div class="container">
                    <div class="row">
                        <div class="pull-left">
                            <span><img width="20px" height="20px"  src="right.png"> Tous les droits reserves 2018 , </span> 
                           <span><img  width="20px" height="20px" src="fine.png"> Projet fin d'etude  </span> 
                            
                        </div> 
                        <div class="bottom-menu pull-right"> 
                            <ul> 
<%@page import="Modele.cntrlAuthentif" %>
<% cntrlAuthentif objk=new cntrlAuthentif(); %>
<%if(session.getAttribute("id_personne")==null){%>
    <li><a class="wow fadeInUp animated" href="agence_immobiliere.jsp" data-wow-delay="0.2s">Accueil</a></li>
<%}else{ %>
                              <%int kobj=(int)session.getAttribute("id_personne");%>

<%if(objk.isLocataire(kobj)&&objk.isProprietaire(kobj)){%>
 <li><a class="wow fadeInUp animated" href="EspaceLocatair_proprietaire.jsp" data-wow-delay="0.2s">Accueil</a></li>
<% }else{%>
<% if(objk.isProprietaire(kobj)){%>
  <li><a class="wow fadeInUp animated" href="EspaceProprietaire.jsp" data-wow-delay="0.2s">Accueil</a></li>
	
<% 
}else{ %>
   <li><a class="wow fadeInUp animated" href="EspaceLocataire.jsp" data-wow-delay="0.2s">Accueil</a></li>
 <%}}} %>
                                <li><a class="wow fadeInUp animated" href="Qestions.jsp" data-wow-delay="0.4s">Questions</a></li>
                                <li><a class="wow fadeInUp animated" href="Contact.jsp" data-wow-delay="0.6s">Contact</a></li>
                            </ul> 
                        </div>
                    </div>
                </div>
            </div>

        </div>
          
        
        
        <script src="assets/js/vendor/modernizr-2.6.2.min.js"></script>
        <script src="assets/js/jquery-1.10.2.min.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/js/bootstrap-select.min.js"></script>
        <script src="assets/js/bootstrap-hover-dropdown.js"></script>
        <script src="assets/js/easypiechart.min.js"></script>
        <script src="assets/js/jquery.easypiechart.min.js"></script>
        <script src="assets/js/owl.carousel.min.js"></script>
        <script src="assets/js/wow.js"></script>
        <script src="assets/js/icheck.min.js"></script>
        <script src="assets/js/price-range.js"></script>
        <script type="text/javascript" src="assets/js/lightslider.min.js"></script>
        <script src="assets/js/main.js"></script>

        <script>
            $(document).ready(function () {

                $('#image-gallery').lightSlider({
                    gallery: true,
                    item: 1,
                    thumbItem: 9,
                    slideMargin: 0,
                    speed: 500,
                    auto: true,
                    loop: true,
                    onSliderLoad: function () {
                        $('#image-gallery').removeClass('cS-hidden');
                    }
                });
            });
        </script>
      
    </body>
</html>