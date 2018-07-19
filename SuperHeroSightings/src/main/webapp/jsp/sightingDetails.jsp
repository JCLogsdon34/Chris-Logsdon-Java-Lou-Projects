<%-- 
    Document   : sightingDetails
    Created on : May 3, 2018, 5:34:06 PM
    Author     : JCLog
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Sighting Details</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/myCss.css" rel="stylesheet">     
        <link href="${pageContext.request.contextPath}/css/sightingscss.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displaySightingsPage">Sightings Main Page</a></li>
                </ul>    
            </div>
            <h1>Sighting Details</h1>
            <hr/>
            <c:forEach var="currentSighting" items="${sightingList}">
                <p>
                    Sighting ID: <c:out value="${currentSighting.sightingID}"/>
                </p>
                <p>
                    Sighting Date: <c:out value="${currentSighting.date}"/>
                </p>

                <p>
                    Location ID: <c:out value="${currentSighting.location.locationID}"/> 
                </p>

                <p>
                    Location Name: <c:out value="${currentSighting.location.locationName}"/> 
                </p>
                <p>
                    Address: <c:out value="${currentSighting.location.address}"/> 
                </p>
            </c:forEach>
            <c:forEach var="currentSuperHero" items="${heroList}">
                <p>
                    <a href="displayHeroDetails?superHeroID=${currentSuperHero.superHeroID}">
                        <c:out value="${currentSuperHero.superHeroID}"/> 
                    </a>
                </p>

                <p>
                    <a href="displayHeroDetails?superHeroID=${currentSuperHero.superHeroID}">
                        <c:out value="${currentSuperHero.name}"/>
                    </a>
                </p>

            </c:forEach>         
            

        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>