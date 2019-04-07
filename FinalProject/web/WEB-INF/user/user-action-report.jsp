<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Tax Return</title>


    <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/4.3.1/css/bootstrap.min.css">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body class="body-wrapper">

<section>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <nav class="navbar navbar-expand-lg navbar-light navigation">
                    <a class="navbar-brand" href="${pageContext.request.contextPath}/taxreturn"  style="width: 10%; height: 10%;" >
                        <img src="${pageContext.request.contextPath}/images/index_pic.jpg"
                             style="width: 72.5%; height: 72.5%;" alt="">
                    </a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav ml-auto main-nav ">
                            <li class="nav-item ">
                                <a class="nav-link" href="${pageContext.request.contextPath}/taxreturn/new-tax-return">New tax return</a>
                            </li>

                            <li class="nav-item ">
                                <a class="nav-link" href="${pageContext.request.contextPath}/taxreturn/action-report-list">Action report list</a>
                            </li>

                        </ul>
                        <ul class="navbar-nav ml-auto mt-10">
                            <li class="nav-item">
                                <label class="nav-link " style="font-size: 30px">Hello, ${name}</label>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link login-button"
                                   href="${pageContext.request.contextPath}/taxreturn/logout">Logout</a>
                            </li>
                        </ul>
                    </div>
                </nav>
            </div>
        </div>
    </div>
</section>

<section class="overly  section-sm">
    <!-- Container Start -->
    <div class="container">
        <div class="row justify-content-md-center text-center">
            <div class="col-md-8">
                <div style="size: auto; color: #07ad76">
                </div>
            </div>
        </div>
    </div>
    <!-- Container End -->
</section>
<section class="dashboard section">
    <div class="col-md-10 offset-md-1 col-lg-8 offset-lg-0">
        <!-- Recently Favorited -->
        <div class="widget dashboard-container my-adslist">
            <h3 class="widget-header">User's tax returns</h3>
            <table class="table table-responsive product-dashboard-table">
                <thead>
                <tr>
                    <th class="text-center">Action</th>
                    <th class="text-center">Message</th>
                    <th class="text-center">Date</th>
                </tr>
                </thead>
                <c:forEach items="${userActionReportList}" var="actionReport">
                    <tbody>
                    <tr>
                        <td><span class="categories"><c:out
                                value="${actionReport.getAction()}"/></span></td>
                        <td><span class="categories"><c:out
                                value="${actionReport.getMessage()}"/></span></td>
                        <td><span class="categories"><c:out
                                value="${actionReport.getDate()}"/></span></td>

                    </tr>

                    </tbody>
                </c:forEach>
            </table>

        </div>
    </div>
</section>
<!-- Footer Bottom -->
<footer class="footer-bottom">
    <!-- Container Start -->
    <div class="container">
        <div class="row">
            <div class="col-sm-6 col-12">
                <!-- Copyright -->
                <div class="copyright">
                    <p>Copyright
                        <script>
                            var CurrentYear = new Date().getFullYear()
                            document.write(CurrentYear)
                        </script>
                        . All Rights Reserved
                    </p>
                </div>
            </div>
            <div class="col-sm-6 col-12">
                <!-- Social Icons -->
                <ul class="social-media-icons text-right">
                    <li><a class="fa fa-github" href="https://github.com/SweetSquid" target="_blank"></a></li>
                    <li><a class="fa fa-instagram" href="https://www.instagram.com/sweet__squid/" target="_blank"></a>
                    </li>
                    <li><a class="fa fa-telegram" href="https://t.me/sweetsquid" target="_blank"></a></li>
                </ul>
            </div>
        </div>
    </div>
    <!-- Container End -->
    <!-- To Top -->

</footer>
</body>
</html>




