<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Hero Details</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/myCss.css" rel="stylesheet">     
        <link href="${pageContext.request.contextPath}/css/sightingscss.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayHerosPage">Heros Main Page</a></li>
                </ul>    
            </div>
            <h1>Hero Details</h1>
            <hr/>
            <c:forEach var="currentSuperHero" items="${superHeroList}">
                <p>
                    Hero ID: <c:out value="${currentSuperHero.superHeroID}"/>
                </p>
                <p>
                    Hero Name: <c:out value="${currentSuperHero.name}"/> 
                </p>
                <p>
                    Hero Description: <c:out value="${currentSuperHero.description}"/>
                </p>
            </c:forEach>
            <c:forEach var="currentSuperPower" items="${superPowersList}">
                <p>
                    Super Power ID: <c:out value="${currentSuperPower.superPowerID}"/> 
                </p>
                <p>
                    Super Power Name: <c:out value="${currentSuperPower.name}"/> 
                </p>
            </c:forEach>
            <c:forEach var="currentOrganization" items="${orgList}">
                <p>
                    Organization ID: <c:out value="${currentOrganization.orgID}"/> 
                </p>
                <p>
                    Organization Name: <c:out value="${currentOrganization.orgName}"/> 
                </p>
                <p>
                    Organization Description: <c:out value="${currentOrganization.orgDescription}"/>
                </p>
            </c:forEach>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>
