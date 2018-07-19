<%-- 
    Document   : Home
    Created on : May 17, 2018, 7:39:43 PM
    Author     : JCLog
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/myCss.css" rel="stylesheet">     
        <link href="${pageContext.request.contextPath}/css/sightingscss.css" rel="stylesheet">

    </head>
    <body>
        <div class="container">
            <h1>Home Page For Hero Sightings</h1>
            <hr/>

            <ul class="nav nav-tabs">
                <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/displayHomePage">Home</a></li>
                <li role="presentation"><a href="${pageContext.request.contextPath}/displaySightingsPage"> Sightings </a></li>
                <li role="presentation"><a href="${pageContext.request.contextPath}/displaySuperPowersPage">Super Powers</a></li>
                <li role="presentation"><a href="${pageContext.request.contextPath}/displayHerosPage">Heros</a></li>
                <li role="presentation"><a href="${pageContext.request.contextPath}/displayOrganizationsPage">Organizations</a></li>
                <li role="presentation"><a href="${pageContext.request.contextPath}/displayLocationsPage">Locations</a></li>
            </ul>   



            <div class="col-md-12">
                <h2>Super Hero Sightings Home</h2>
                <h3>Map</h3>
                <img src="C:\Users\JCLog\Desktop\Chris-Logsdon-Individual-Work-Lou\SuperHeroSightings\800px-Homeric_Greece-en.png"/>
            </div>

            <div class="col-md-12">
                <h3>Most Recent Ten Sightings</h3>
                <h4>*Heros at each sighting are available on clicking a list item</h4>
                <table id="lastTenSightings" class="table table-hover">
                    <tr>
                        <th width="10%">Sighting ID</th>
                        <th width="20%">Sighting Date</th>
                        <th width="20%">Location Name</th>
                        <th width="10%">Location Address</th>
                        <th width="10%"></th>
                        <th width="10%"></th>
                    </tr>
                    <c:forEach var="currentSighting" items="${sights}">
                       
                            <tr>
                                <td>
                                    <a href="displaySightingDetails?sightingID=${currentSighting.sightingID}">
                                        <c:out value="${currentSighting.sightingID}"/> 
                                    </a>
                                </td>
                                <td>
                                    <a href="displaySightingDetails?sightingID=${currentSighting.sightingID}">
                                        <c:out value="${currentSighting.date}"/>
                                    </a>
                                </td>
                                <td>
                                    
                                        <c:out value="${currentSighting.location.locationName}"/>
                                    
                                </td>
                                <td>
                                    
                                        <c:out value="${currentSighting.location.address}"/>
                                    

                                </td>
                                <td>
                                    <a href="displayUpdateSightingsForm?sightingID=${currentSighting.sightingID}">
                                        Edit
                                    </a>
                                </td>
                                <td>
                                    <a href="deleteSighting?sightingID=${currentSighting.sightingID}">
                                        Delete
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                </table>                    
            </div>
        </div> 
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/superHeroSightings.js"></script>
    </body>
</html>
