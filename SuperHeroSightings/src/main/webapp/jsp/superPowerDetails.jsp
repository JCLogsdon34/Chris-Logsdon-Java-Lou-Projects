<%-- 
    Document   : superPowerDetails
    Created on : May 3, 2018, 5:18:57 PM
    Author     : JCLog
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Super Power Details</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/myCss.css" rel="stylesheet">     
        <link href="${pageContext.request.contextPath}/css/sightingscss.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displaySuperPowersPage">Super Powers Main Page</a></li>
                </ul>    
            </div>
            <h1>Super Power Details</h1>
            <hr/>
            <c:forEach var="currentSuperPower" items="${superPowerList}">
                <p>
                    Super Power ID: <c:out value="${currentSuperPower.superPowerID}"/> 
                </p>
                <p>
                    Super Power Name: <c:out value="${currentSuperPower.name}"/> 
                </p>
                <p>
                    Description: <c:out value="${currentSuperPower.description}"/> 
                </p>
            </c:forEach>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>

