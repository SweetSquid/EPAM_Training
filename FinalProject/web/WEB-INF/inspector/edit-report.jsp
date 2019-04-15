<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <fmt:setBundle var="link" basename="message" scope="session" />
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title><fmt:message key="common.edit" bundle="${link}"/></title>


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
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav ml-auto main-nav ">
                            <li class="nav-item ">
                                <a class="nav-link" href="${pageContext.request.contextPath}/taxreturn/new-tax-return"><fmt:message key="user.header.new" bundle="${link}"/></a>
                            </li>
                            <li class="nav-item ">
                                <a class="nav-link" href="${pageContext.request.contextPath}/taxreturn/action-report-list"><fmt:message key="user.header.actionList" bundle="${link}"/></a>
                            </li>
                            <li class="nav-item ">
                                <a class="nav-link" href="${pageContext.request.contextPath}/taxreturn/history"><fmt:message key="user.header.history" bundle="${link}"/></a>
                            </li>
                        </ul>
                        <ul class="navbar-nav ml-auto mt-10">
                            <li class="nav-item">
                                <label class="nav-link " style="font-size: 30px">${fullname}</label>
                            </li>
                            <li class="nav-item logoutButton">
                                <a class="nav-link login-button"
                                   href="${pageContext.request.contextPath}/taxreturn/logout"><fmt:message key="common.header.log.out" bundle="${link}"/></a>
                            </li>
                            <li style="padding-top: 4.5%;"><a href="${pageContext.request.contextPath}/?lang=en"><img
                                    src="${pageContext.request.contextPath}/images/usa-flag.png" alt=""
                                    style="width: 40px;height: 25px;margin-left: 10px"></a></li>
                            <li style="padding-top: 4.5%;"><a href="${pageContext.request.contextPath}/?lang=ua"><img
                                    src="${pageContext.request.contextPath}/images/ukraine-flag.png" alt=""
                                    style="width: 40px;height: 25px;margin-left: 10px"></a></li>
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
                    <h3 class="bg-gray p-4"><fmt:message key="common.edit" bundle="${link}"/></h3>
                    <form method="post" action="${pageContext.request.contextPath}/taxreturn/edit?id=${editAction.getId()}">
                        <fieldset class="p-4">
                            <ul>
                                <li><span class="categories ol1"><strong><fmt:message key="inspector.tax.userId" bundle="${link}"/>:</strong> <c:out
                                        value="${editAction.getUserId()}"/></span></li>
                                <li><span class="categories ol1"><strong><fmt:message key="inspector.edit.taxId" bundle="${link}"/>:</strong> <c:out
                                        value="${editAction.getId()}"/></span></li>
                                <li><span class="categories ol1"><strong><fmt:message key="inspector.tax.wage" bundle="${link}"/>:</strong> <c:out
                                        value="${editAction.getWage()}"/></span></li>
                                <li><span class="categories ol1"><strong><fmt:message key="inspector.tax.military" bundle="${link}"/>:</strong> <c:out
                                        value="${editAction.getMilitaryCollection()}"/></span></li>
                                <li><span class="categories ol1"><strong><fmt:message key="inspector.tax.income" bundle="${link}"/>:</strong> <c:out
                                        value="${editAction.getIncomeTax()}"/></span></li>
                                <li><span class="categories ol1"><strong><fmt:message key="inspector.tax.posted" bundle="${link}"/>:</strong><time> <c:out
                                        value="${editAction.getDate()}"/></time> </span></li>
                            </ul>
                            <textarea name="message"  class="border p-3 w-100 my-3 " placeholder="<fmt:message key="inspector.edit.enter" bundle="${link}"/>" maxlength="299" style="resize: none"></textarea>

                            <div class="loggedin-forgot d-inline-flex my-1">
                                <button type="submit"
                                        class="d-block py-3 px-4 bg-primary text-white border-0 rounded font-weight-bold">
                                    <fmt:message key="inspector.edit.send" bundle="${link}"/>
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
