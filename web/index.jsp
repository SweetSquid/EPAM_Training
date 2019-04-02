<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>

  <!-- SITE TITTLE -->
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Tax system</title>

  <!-- FAVICON -->
  <link href="${pageContext.request.contextPath}/img/favicon.png" rel="shortcut icon">
  <!-- PLUGINS CSS STYLE -->
  <!-- <link href="plugins/jquery-ui/jquery-ui.min.css" rel="stylesheet"> -->
  <!-- Bootstrap -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap-slider.css">
  <!-- Font Awesome -->
  <link href="${pageContext.request.contextPath}/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet">
  <!-- Owl Carousel -->
  <link href="${pageContext.request.contextPath}/plugins/slick-carousel/slick/slick.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/plugins/slick-carousel/slick/slick-theme.css" rel="stylesheet">
  <!-- Fancy Box -->
  <link href="${pageContext.request.contextPath}/plugins/fancybox/jquery.fancybox.pack.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/plugins/jquery-nice-select/css/nice-select.css" rel="stylesheet">
  <!-- CUSTOM CSS -->
  <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">


  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
  <![endif]-->

</head>
<body class="body-wrapper">

<section>
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <nav class="navbar navbar-expand-lg navbar-light navigation">
          <a class="navbar-brand" href="${pageContext.request.contextPath}/app/index">
              <img src="${pageContext.request.contextPath}/images/index_pic.jpg" style="width: 10%; height: 10%;" alt="">
          </a>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                  aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto mt-10">
              <li class="nav-item">
                <a class="nav-link login-button" href="${pageContext.request.contextPath}/app/login">Login</a>
              </li>
              <li class="nav-item">
                <a class="nav-link login-button" href="${pageContext.request.contextPath}/app/registration">Registration</a>
              </li>
            </ul>
          </div>
        </nav>
      </div>
    </div>
  </div>
</section>


<section class="call-to-action overly bg-3 section-sm">
  <!-- Container Start -->
  <div class="container">
    <div class="row justify-content-md-center text-center">
      <div class="col-md-8">
        <div class="content-holder" style="size: auto">
        </div>
      </div>
    </div>
  </div>
  <!-- Container End -->
</section>


<!-- Footer Bottom -->
<footer class="footer-bottom">
  <!-- Container Start -->
  <div class="container">
    <div class="row">
      <div class="col-sm-6 col-12">
        <!-- Copyright -->
        <div class="copyright">
          <p>Copyright <script>
              var CurrentYear = new Date().getFullYear()
              document.write(CurrentYear)
          </script>. All Rights Reserved</p>
        </div>
      </div>
      <div class="col-sm-6 col-12">
        <!-- Social Icons -->
        <ul class="social-media-icons text-right">
        <li><a class="fa fa-facebook" href="#" target="_blank"></a></li>
        <li><a class="fa fa-instagram" href="https://www.instagram.com/sweet__squid/" target="_blank"></a></li>
        <li><a class="fa fa-telegram" href="https://t.me/sweetsquid" target="_blank"></a></li>
      </ul>
      </div>
    </div>
  </div>
  <!-- Container End -->
  <!-- To Top -->

</footer>

<!-- JAVASCRIPTS -->
<script src="${pageContext.request.contextPath}/plugins/jQuery/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap/js/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap-slider.js"></script>
<!-- tether js -->
<script src="${pageContext.request.contextPath}/plugins/tether/js/tether.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/raty/jquery.raty-fa.js"></script>
<script src="${pageContext.request.contextPath}/plugins/slick-carousel/slick/slick.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/jquery-nice-select/js/jquery.nice-select.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/fancybox/jquery.fancybox.pack.js"></script>
<script src="${pageContext.request.contextPath}/plugins/smoothscroll/SmoothScroll.min.js"></script>
<!-- google map -->
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCcABaamniA6OL5YvYSpB3pFMNrXwXnLwU&libraries=places"></script>
<script src="${pageContext.request.contextPath}/plugins/google-map/gmap.js"></script>
<script src="${pageContext.request.contextPath}/js/script.js"></script>

</body>

</html>




