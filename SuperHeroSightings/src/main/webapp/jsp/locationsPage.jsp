<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Location Page</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/myCss.css" rel="stylesheet">     
        <link href="${pageContext.request.contextPath}/css/sightingscss.css" rel="stylesheet"></head>
    <body>
        <div class="container">
            <h1>Location Page</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayLocationsPage">Locations Main Page</a></li>
                </ul>    
            </div>
            <div class="col-md-6">
                <h2>Locations:</h2>
                <table id="locationTable" class="table table-hover">
                    <tr>
                        <th width="10%">Location ID</th>
                        <th width="20%">Location Name</th>
                        <th width="20%">Location Address</th>
                        <th width="15%">Longitude</th>
                        <th width="15%">Latitude</th>
                    </tr>
                    <c:forEach var="currentLocation" items="${locationList}">
                        <tr>
                            <td>
                                <a href="displayLocation?locationID=${currentLocation.locationID}">
                                    <c:out value="${currentLocation.locationID}"/> 
                                </a>
                            </td>
                            <td>
                                <a href="displayLocation?locationID=${currentLocation.locationID}">
                                    <c:out value="${currentLocation.locationName}"/>
                                </a>
                            </td>
                            <td>
                                <a href="displayLocation?locationID=${currentLocation.locationID}">
                                    <c:out value="${currentLocation.address}"/> 
                                </a>
                            </td>
                            <td>
                                <a href="displayLocation?locationID=${currentLocation.locationID}">
                                    <c:out value="${currentLocation.longitude}"/> 
                                </a>
                            </td>
                            <td>
                                <a href="displayLocation?locationID=${currentLocation.locationID}">
                                    <c:out value="${currentLocation.latitude}"/>
                                </a>
                            </td>
                            <td>
                                <a href="displayUpdateLocations=${currentLocation.locationID}">
                                    Edit
                                </a
                            <td>
                                <a href="deleteLocation?locationID=${currentLocation.locationID}">
                                    Delete
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>                    
            </div>
                
            <div class="col-md-4">
                <h2>Add New Location</h2>
                <form class="form-horizontal" 
                      role="form" method="POST" 
                      action="createLocation">
                    <div class="form-group">
                        <label for="add-location-name" class="col-md-4 control-label">Location Name:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="locationName" placeholder="Location Name"/>
                            
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-location-address" class="col-md-4 control-label">Location Address:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="address" placeholder="Tell us the Address"/>
                            
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-location-longitude" class="col-md-4 control-label">Longitude:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="longitude" placeholder="Tell us the Longitude"/>
                            
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-location-latitude" class="col-md-4 control-label">Latitude:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="latitude" placeholder="Tell us the Latitude"/>
                            
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-8">
                            <input type="submit" class="btn btn-default" value="Create Location"/>
                        </div>
                    </div>
                </form>
            </div>
            <!-- Placed at the end of the document so the pages load faster -->
            <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>