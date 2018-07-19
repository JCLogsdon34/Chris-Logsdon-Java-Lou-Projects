<%-- 
    Document   : organizationsPage
    Created on : Apr 3, 2018, 8:11:12 PM
    Author     : JCLog
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Organization Page</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/myCss.css" rel="stylesheet">     
        <link href="${pageContext.request.contextPath}/css/sightingscss.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <h1>Organizations </h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayOrganizationsPage">Organizations Main Page</a></li>
                </ul>    
            </div>
            <div class="col-md-8">
                <h2>Organizations</h2>
                <table id="organizationTable" class="table table-hover">
                    <tr>
                        <th width="10%">Organization ID</th>
                        <th width="20%">Organization Name</th>
                        <th width="20%">Organization Description</th>
                        <th width="20%">Organization Location Name</th>
                        <th width="15%"></th>
                        <th width="15%"></th>
                        
                    </tr>
                    <c:forEach var="currentOrganization" items="${organizationList}">
                        <tr>
                            <td>
                                <a href="displayOrganization?orgID=${currentOrganization.orgID}">
                                    <c:out value="${currentOrganization.orgID}"/> 
                                </a>
                            </td>
                            <td>
                                <a href="displayOrganization?orgID=${currentOrganization.orgID}">
                                    <c:out value="${currentOrganization.orgName}"/> 
                                </a>
                            </td>
                            <td>
                                <a href="displayOrganization?orgID=${currentOrganization.orgID}">
                                    <c:out value="${currentOrganization.orgDescription}"/>
                                </a>
                            </td>
                          
                                <td>
                                  <c:out value="${currentOrganization.orgLocation.locationName}"/>
     
                                </td>
                              
                            <td>
                                <a href="displayUpdateOrganizations?orgID=${currentOrganization.orgID}">
                                    Edit
                                </a>
                            </td>
                            <td>
                                <a href="deleteOrganization?orgID=${currentOrganization.orgID}">
                                    Delete
                                </a>
                            </td>
                            </c:forEach>
                        </tr>
                </table>                    
            </div>
                                    
            <div class="col-md-8">
                <h2>Add New Organization</h2>
                <form class="form-horizontal" 
                      role="form" method="POST" 
                      action="createOrganization">
                    <div class="form-group">
                        <label for="add-organization-name" class="col-md-4 control-label">Organization Name:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="orgName" placeholder="Organization Name"/>

                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-organization-description" class="col-md-4 control-label">Organization Description:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="orgDescription" placeholder="Tell Us About Them"/>

                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-locationID" class="col-md-4 control-label">Location ID:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="locationID" placeholder="Tell us the LocationID"/>

                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-superHeroID" class="col-md-4 control-label">Super Heros IDs:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="superHeroID" placeholder="Please give us one or more superHeroIDs, comma seperated"/>

                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-8">
                            <input type="submit" class="btn btn-default" value="Create Organization"/>
                        </div>
                    </div>
                </form>
            </div>
        </div>
            <!-- Placed at the end of the document so the pages load faster -->
            <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>