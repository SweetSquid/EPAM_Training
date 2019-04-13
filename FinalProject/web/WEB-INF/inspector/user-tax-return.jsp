<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Tax Return</title>


    <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/4.3.1/js/bootstrap.js">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body class="body-wrapper">
<%--display: flex;--%>
<%--flex-direction: column;--%>
<%--justify-content: center;--%>
<%--position: relative;--%>
<%--bottom: 5px;--%>
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
                            <li class="nav-item">
                                <a class="nav-link" href="${pageContext.request.contextPath}/taxreturn/tax-return-list">Tax
                                    return list</a>
                            </li>

                        </ul>
                        <ul class="navbar-nav ml-auto mt-10">
                            <ul class="navbar-nav ml-auto mt-10">
                                <li class="nav-item">
                                    <label class="nav-link " style="font-size: 30px">Hello, ${fullname}</label>
                                </li>
                                <li class="nav-item logoutButton ">
                                    <a class="nav-link login-button "
                                       href="${pageContext.request.contextPath}/taxreturn/logout">Logout</a>
                                </li>
                            </ul>
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

<c:if test="${not empty taxReturnList}">
<section class="dashboard section">
    <div class="col-md-10 offset-md-1 col-lg-8 offset-lg-0">
        <!-- Recently Favorited -->
        <div class="widget dashboard-container my-adslist" style="background: #F5F5F5">
            <h3 class="widget-header">Tax returns</h3>

            <table class="table ">
                <thead>
                <tr>
                    <th>User</th>
                    <th class="text-center">Category</th>
                    <th class="text-center">Action</th>
                </tr>
                </thead>
                <c:forEach items="${taxReturnList}" var="taxReturn">
                    <tbody>
                    <tr>
                        <td class="product-details">
                            <span class="categories ol1"><strong>User id:</strong> <c:out
                                    value="${taxReturn.getUserId()}"/></span>
                            <span class="categories ol1"><strong>Wage:</strong> <c:out
                                    value="${taxReturn.getWage()}"/></span>
                            <span class="categories ol1"><strong>Military collection:</strong> <c:out
                                    value="${taxReturn.getMilitaryCollection()}"/></span>
                            <span class="categories ol1"><strong>Income tax:</strong> <c:out
                                    value="${taxReturn.getIncomeTax()}"/></span>
                            <span class="categories ol1"><strong>Posted on: </strong><time> <c:out
                                    value="${taxReturn.getDate()}"/></time> </span>
                        </td>
                        <td class="product-category"><span class="categories ol1 align-content-center"><c:out
                                value="${taxReturn.getCategory()}"/></span></td>
                        <td class="action" data-title="Action">
                            <div class="">
                                <ul class="list-inline justify-content-center">
                                    <li class="list-inline-item">
                                        <a name="a" data-toggle="tooltip" data-placement="top" title="Approve"
                                           class="view"
                                           href="${pageContext.request.contextPath}/taxreturn/approve?id=${taxReturn.getId()}">
                                            <i class="fa fa-check"></i>
                                        </a>
                                    </li>
                                    <li class="list-inline-item">
                                        <a class="edit" data-toggle="tooltip" data-placement="top" title="Edit"
                                           href="${pageContext.request.contextPath}/taxreturn/edit?id=${taxReturn.getId()}">
                                            <i class="fa fa-pencil"></i>
                                        </a>
                                    </li>

                                </ul>
                            </div>
                        </td>
                    </tr>

                    </tbody>
                </c:forEach>
            </table>
        </div>
    </div>
</section>
</c:if>
<c:if test="${empty taxReturnList}">
    <section class="overly  section-sm" style="margin-top:20vh">
        <!-- Container Start -->
        <div class="container">
            <div class="row justify-content-md-center text-center">
                <div class="col-md-8" >
                    <p style="font-size: 5em">No new tax returns</p>
                </div>
            </div>
        </div>
        <!-- Container End -->
    </section>
</c:if>



<jsp:include page="${pageContext.request.contextPath}/footer.jsp"/>
</body>
</html>




