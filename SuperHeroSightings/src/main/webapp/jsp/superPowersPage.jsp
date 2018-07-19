<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Super Powers Page</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/myCss.css" rel="stylesheet">     
        <link href="${pageContext.request.contextPath}/css/sightingscss.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <h1>Super Powers Main Page</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displaySuperPowersPage">Super Powers Main Page</a></li>
                </ul>    
            </div>
            <div class="col-md-6">
                <h2>Super Powers</h2>
                <table id="superPowerTable" class="table table-hover">
                    <tr>
                        <th width="5%">Super Power ID</th>
                        <th width="20%">Super Power Name</th>
                        <th width="30%">Description</th>
                        <th width="15%"></th>
                        <th width="30%"></th>
                    </tr>
                    <c:forEach var="currentSuperPower" items="${superPowerList}">
                        <tr>
                            <td>
                                <a href="displaySuperPower?superPowerID=${currentSuperPower.superPowerID}">
                                    <c:out value="${currentSuperPower.superPowerID}"/> 
                                </a>
                            </td>
                            <td>
                                <a href="displaySuperPower?superPowerID=${currentSuperPower.superPowerID}">
                                    <c:out value="${currentSuperPower.name}"/> 
                                </a>
                            </td>
                            <td>
                                <a href="displaySuperPower?superPowerID=${currentSuperPower.superPowerID}">
                                   <c:out value="${currentSuperPower.description}"/>
                                </a>
                            </td>
                            <td>
                                <a href="displayUpdateSuperPower?superPowerID=${currentSuperPower.superPowerID}">
                                    Edit
                                </a>
                            </td>
                            <td>
                                <a href="deleteSuperPower?superPowerID=${currentSuperPower.superPowerID}">
                                    Delete
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>                    
            </div>

            <div class="col-md-6">
                <h2>Add New Super Power</h2>
               <form class="form-horizontal" 
                      role="form" method="POST" 
                      action="createSuperPower">
                    <div class="form-group">
                        <label for="add-name" class="col-md-4 control-label">Super Power Name:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="name" placeholder="Power Name"/>
                            
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-description" class="col-md-4 control-label">Description:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="description" placeholder="Tell us more"/>
                           
                        </div>

                    </div>
                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-8">
                            <input type="submit" class="btn btn-default" value="Create Super Power"/>
                        </div>
                    </div>
                </form>

            </div> <!-- End col div -->

        </div> <!-- End row div -->


    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

</body>
</html>

