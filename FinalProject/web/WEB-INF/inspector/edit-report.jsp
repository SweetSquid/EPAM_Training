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
                    <a class="navbar-brand fa fa-home fa-3x" href="${pageContext.request.contextPath}/taxreturn">
                    </a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse"
                            data-target="#navbarSupportedContent"
                            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav ml-auto main-nav ">
                            <li class="nav-item ">
                                <a class="nav-link" href="${pageContext.request.contextPath}/taxreturn/tax-return-list">Tax return list</a>
                            </li>
                            <li class="nav-item dropdown dropdown-slide">

                        </ul>
                        <ul class="navbar-nav ml-auto mt-10">
                            <li class="nav-item">
                                <label class="nav-link " style="font-size: 30px">Hello, ${fullname}</label>
                            </li>
                            <li class="nav-item logoutButton">
                                <a class="nav-link login-button "
                                   href="${pageContext.request.contextPath}/taxreturn/logout">Logout</a>
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
                <div class="border">
                    <h3 class="bg-gray p-4">Edit</h3>
                    <form method="post" action="${pageContext.request.contextPath}/taxreturn/edit?id=${editAction.getId()}">
                        <fieldset class="p-4">
                            <ul>
                                <li><span class="categories ol1"><strong>User id:</strong> <c:out
                                        value="${editAction.getUserId()}"/></span></li>
                                <li><span class="categories ol1"><strong>Tax return id:</strong> <c:out
                                        value="${editAction.getId()}"/></span></li>
                                <li><span class="categories ol1"><strong>Wage:</strong> <c:out
                                        value="${editAction.getWage()}"/></span></li>
                                <li><span class="categories ol1"><strong>Military collection:</strong> <c:out
                                        value="${editAction.getMilitaryCollection()}"/></span></li>
                                <li><span class="categories ol1"><strong>Income tax:</strong> <c:out
                                        value="${editAction.getIncomeTax()}"/></span></li>
                                <li><span class="categories ol1"><strong>Posted on: </strong><time> <c:out
                                        value="${editAction.getDate()}"/></time> </span></li>
                            </ul>
                            <textarea name="message" class="border p-3 w-100 my-3 " placeholder="Enter something..." maxlength="800" style="resize: none"></textarea>

                            <div class="loggedin-forgot d-inline-flex my-1">
                                <button type="submit"
                                        class="d-block py-3 px-4 bg-primary text-white border-0 rounded font-weight-bold">
                                    Send tax return
                                </button>
                            </div>

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
