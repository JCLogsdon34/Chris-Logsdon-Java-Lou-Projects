<%-- 
    Document   : Sightings
    Created on : Apr 17, 2018, 10:55:17 AM
    Author     : JCLog
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        
             <table id="sightingsTable" class="table table-hover">
                        <tr>
                            <th width="15%">Sighting ID</th>
                            <th width="15%">Sighting Super Hero Name</th>
                            <th width="15%">Sighting Super Date</th>
                            <th width="15%">Sighting Address</th>
                            <th width="15%">Super Hero Organization membership</th>
                            <th width="15%"></th>
                            <th width="10%"></th>
                        </tr>
                        <c:forEach var="currentSighting" items="${sightingList}">
                            <tr>
                                <td>
                                    <a href="displaySighting?sightingId=${currentSighting.sightingId}">
                                        <c:out value="${currentSighting.sightingID}"/> <c:out value="${currentSighting.getSuperHero.getSuperHeroName}"/>
                                    </a>
                                </td>
                                <td>
                                    <c:out value="${currentSighting.date}"/>
                                </td>
                                <td>
                                    <a href="displayEditSightingForm?sightingId=${currentSighting.sightingId}">
                                        Edit
                                    </a>
                                </td>
                                <td>
                                    <a href="deleteSighting?sightingId=${currentSighting.sightingId}">
                                        Delete
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>                    
                </div> <!-- End col div -->
                <!-- 
                    Add col to hold the new contact form - have it take up the other 
                    half of the row
                -->
                <div class="col-md-6">
                    <h2>Add New Sighting</h2>
                    <form class="form-horizontal" 
                          role="form" method="POST" 
                          action="createSighting">
                        <div class="form-group">
                            <label for="add-super-hero-name" class="col-md-4 control-label">Super Hero Name:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="name" placeholder="Name"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-date" class="col-md-4 control-label">Date:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="date" placeholder="Date"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-address" class="col-md-4 control-label">Address: </label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="address" placeholder="Address"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <input type="submit" class="btn btn-default" value="Create Sighting"/>
                            </div>
                        </div>
                    </form>
        
    </body>
</html>
