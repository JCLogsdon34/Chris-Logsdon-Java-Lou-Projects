<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Update Organizations Form</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/myCss.css" rel="stylesheet">     
        <link href="${pageContext.request.contextPath}/css/sightingscss.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <h1>Update Organizations Form </h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayOrganizationsPage">Organizations Main Page</a></li>
                </ul>    
            </div>
            <div class="container">
                <h1>Edit Organization Information </h1>
                <hr/>

                <sf:form class="form-horizontal" role="form" modelAttribute="organizationList" action="updateOrganization" method="POST">
                    <div class="form-group">

                        <label for="add-organization-name" class="col-md-4 control-label">Organization Name:</label>
                        <div class="col-md-8">
                            <sf:input type="text" class="form-control" id="add-name"
                                      path="orgName" placeholder="name"/>
                            <sf:errors path="name" cssclass="error"></sf:errors>
                        </div>

                        <label for="add-organization-description" class="col-md-4 control-label">Organization Description:</label>
                        <div class="col-md-8">
                            <sf:input type="text" class="form-control" id="add-description"
                                      path="description" placeholder="name"/>
                            <sf:errors path="description" cssclass="error"></sf:errors>
                        </div>

                        <label for="add-location-name" class="col-md-4 control-label">Location Name:</label>
                        <div class="col-md-8">
                            <sf:input type="text" class="form-control" id="add-location-name"
                                      path="locationName" placeholder="Name"/>
                            <sf:errors path="location-name" cssclass="error"></sf:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-address" class="col-md-4 control-label">Location Address:</label>
                        <div class="col-md-8">
                            <sf:input type="text" class="form-control" id="add-address"
                                      path="address" placeholder="Address Here"/>
                            <sf:errors path="address" cssclass="error"></sf:errors>
                        </div>
                        <div class="form-group">
                            <label for="add-longitude" class="col-md-4 control-label">Location Longitude:</label>
                            <div class="col-md-8">
                                <sf:input type="text" class="form-control" id="add-longitude"
                                          path="longitude" placeholder="Longitude"/>
                                <sf:errors path="longitude" cssclass="error"></sf:errors>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-latitude" class="col-md-4 control-label">Location Latitude:</label>
                            <div class="col-md-8">
                                <sf:input type="text" class="form-control" id="add-latitude"
                                          path="latitude" placeholder="Latitude"/>
                                <sf:errors path="latitude" cssclass="error"></sf:errors>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="update-members" class="col-md-4 control-label">Organization Members:</label>
                            <div class="col-md-8">
                                <sf:input type="text" class="form-control" id="update-members"
                                          path="orgMembers" placeholder="org Members"/>
                                <sf:errors path="orgMembers" cssclass="error"></sf:errors>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <input type="submit" class="btn btn-default" value="/updateOrganization"/>
                            </div>
                        </div>
                </sf:form>                
            </div>

            <!-- Placed at the end of the document so the pages load faster -->
            <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>