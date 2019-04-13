<!DOCTYPE html>
<html lang="en">
<head>

    <!-- SITE TITTLE -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Error</title>


    <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/4.3.1/css/bootstrap.min.css">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


</head>

<body class="body-wrapper">


<section class="section" style="padding: 15%; background: #F5F5F5; min-height:100vh">
    <div class="container">
        <div class="row justify-content-md-center text-center">
            <div class="col-md-6 text-center mx-auto">
                <div class="404-img">
                    <img src="${pageContext.request.contextPath}/images/404.jpg" alt="ERROR">
                </div>
                <div class="404-content">
                    <h1 class="display-1 pt-1 pb-2">Oops</h1>
                    <p class="px-3 pb-2 text-dark">Something went wrong,we can't find the page that you are looking for :(</p>
                    <a href="${pageContext.request.contextPath}/taxreturn" class="btn btn-info">GO HOME</a>
                </div>
            </div>
        </div>
    </div>
</section>

<jsp:include page="${pageContext.request.contextPath}/footer.jsp"/>

</body>
</html>