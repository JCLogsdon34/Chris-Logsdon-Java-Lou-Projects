<%-- 
    Document   : organizationDetails
    Created on : May 3, 2018, 5:21:33 PM
    Author     : JCLog
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Organization Details</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/myCss.css" rel="stylesheet">     
        <link href="${pageContext.request.contextPath}/css/sightingscss.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayOrganizationsPage">Organizations Main Page</a></li>
                </ul>    
            </div>
            <h1>Organization Details</h1>
            <hr/>
            <c:forEach var="currentOrganization" items="${organizationList}">
                <p>
                    Organization ID: <c:out value="${currentOrganization.orgID}"/> 
                </p>
                <p>
                    Organization Name: <c:out value="${currentOrganization.orgName}"/> 
                </p>
                <p>
                    Organization Description: <c:out value="${currentOrganization.orgDescription}"/>
                </p>

                <p>
                    Location ID: <c:out value="${currentOrganization.orgLocation.locationID}"/>
                </p>
                <p>
                    Location Name: <c:out value="${currentOrganization.orgLocation.locationName}"/> 
                </p>
                <p>
                    Address: <c:out value="${currentOrganization.orgLocation.address}"/> 
                </p>
                </c:forEach>
                <c:forEach var="currentSuperHero" items="${heroList}">
                    <p>
                        <c:out value="${currentSuperHero.superHeroID}"/> 
                    </p>
                    <p>
                        <c:out value="${currentSuperHero.name}"/>
                    </p>

                </c:forEach> 
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>