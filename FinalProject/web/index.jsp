<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
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
                    <a class="navbar-brand fa fa-home fa-3x" href="${pageContext.request.contextPath}/taxreturn">
                    </a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse"
                            data-target="#navbarSupportedContent"
                            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">

                        <ul class="navbar-nav ml-auto mt-10">
                            <li class="nav-item">
                                <a class="nav-link login-button"
                                   href="${pageContext.request.contextPath}/taxreturn/login">Login</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link login-button"
                                   href="${pageContext.request.contextPath}/taxreturn/registration">Registration</a>
                            </li>
                        </ul>
                    </div>
                </nav>
            </div>
        </div>
    </div>
</section>


<section class=" overly bg-3 section-sm">
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

<jsp:include page="${pageContext.request.contextPath}/footer.jsp"/>
</body>
</html>




