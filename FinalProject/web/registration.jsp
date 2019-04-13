<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>

    <!-- SITE TITTLE -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Registration</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="${pageContext.request.contextPath}/webjars/jquery/3.0.0/jquery.js"></script>

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

<section class="login py-5 border-top-1">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-5 col-md-8 align-item-center">
                <div class="border border">
                    <h3 class="bg-gray p-4">Register Now</h3>
                    <form method="post" action="${pageContext.request.contextPath}/taxreturn/registration">
                        <fieldset class="p-4">
                            <input type="text" name="fullName" placeholder="Full name*" class="border p-3 w-100 my-2"
                                   required>
                            <input type="text" name="username" placeholder="Username*" class="border p-3 w-100 my-2"
                                   required>
                            <input type="text" name="idCode" placeholder="ID code*" class="border p-3 w-100 my-2"
                                   required>
                            <input type="text" name="phone" placeholder="Phone*" class="border p-3 w-100 my-2"
                                   required>
                            <input type="email" name="email" placeholder="Email*" class="border p-3 w-100 my-2"
                                   required>
                            <input type="password" name="password" placeholder="Password*" class="border p-3 w-100 my-2"
                                   required>
                            <div class="loggedin-forgot d-inline-flex my-3">
                                <button type="submit"
                                        class="d-block py-3 px-4 bg-primary text-white border-0 rounded font-weight-bold">
                                    Register Now
                                </button>
                            </div>
                            <c:if test="${notUnique != null}">
                                <div class="alert alert-danger">
                                        ${notUnique}
                                </div>
                            </c:if>

                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>

<jsp:include page="${pageContext.request.contextPath}/footer.jsp"/>

</body>
</html>

<script>
    window.setTimeout(function() {
        $(".alert").fadeTo(500, 0).slideUp(500, function(){
            $(this).remove();
        });
    }, 2500);
</script>