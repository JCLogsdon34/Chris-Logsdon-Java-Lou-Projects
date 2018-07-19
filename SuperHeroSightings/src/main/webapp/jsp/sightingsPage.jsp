<%-- 
    Document   : sightingsPage
    Created on : May 2, 2018, 3:22:41 PM
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
        <title>Sightings Page</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/myCss.css" rel="stylesheet">     
        <link href="${pageContext.request.contextPath}/css/sightingscss.css" rel="stylesheet">
        <script>
            if (${currentSighting.locationID} === ${currentLocation.locationID}) {
                var locationName = <c:out value="${currentLocation.locationName}"/>
                var locationAddress = <c:out value="${currentLocation.address}"/>
            }
        </script>
    </head>
    <body>
        <div class="container">
            <h1>Sightings Page</h1>
            <hr/>

            <ul class="nav nav-tabs">
                <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/">Home</a></li>
                <li role="presentation"><a href="${pageContext.request.contextPath}/displaySightingsPage"> Sightings </a></li>
            </ul>   

            <h2> Sightings </h2>
            <div class="col-md-12">
                <h2>Sighting Table</h2>
                <h4>*Heros at each sighting are available on clicking a list item</h4>
                <table id="sightings" class="table table-hover">
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

            <div class="col-md-8">
                <h2>Add New Sighting</h2>
                <form class="form-horizontal" 
                      role="form" method="POST" 
                      action="createSighting">
                    <div class="form-group">
                        <label for="add-sighting-date" class="col-md-4 control-label">Sighting Date:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="sightingDate" placeholder="Date"/>

                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-locationID" class="col-md-4 control-label">Location ID:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="locationID" placeholder="locationID"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-superHeroID" class="col-md-4 control-label">SuperHero ID:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="superHeroID" placeholder="superHeroID"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-8">
                            <input type="submit" class="btn btn-default" value="Create Sighting"/>
                        </div>
                    </div>
                </form>
            </div>
        </div> <!-- End col div --> <!-- End row div -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/superHeroSightings.js"></script>
    </body>
</html>