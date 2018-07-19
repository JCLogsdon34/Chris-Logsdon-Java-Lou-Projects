<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Update Super Power Form</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/myCss.css" rel="stylesheet">     
        <link href="${pageContext.request.contextPath}/css/sightingscss.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <h1>Update Super Powers </h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displaySuperPowersPage">Super Powers Main Page</a></li>
                </ul>    
            </div>
            <div class="container">
                <h1>Edit Super Power</h1>
                <hr/>

                <sf:form class="form-horizontal" role="form" modelAttribute="superPower" action="updateSuperPower" method="POST">
                    <div class="form-group">
                        <label for="add-name" class="col-md-4 control-label">Super Power Name:</label>
                        <div class="col-md-8">
                            <sf:input type="text" class="form-control" id="add-name"
                                      path="name" placeholder="Name"/>
                            <sf:errors path="name" cssclass="error"></sf:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-description" class="col-md-4 control-label">Description:</label>
                        <div class="col-md-8">
                            <sf:input type="text" class="form-control" id="add-description"
                                      path="description" placeholder="Tell Us More Please"/>
                            <sf:errors path="description" cssclass="error"></sf:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-8">
                            <input type="submit" class="btn btn-default" value="UpdateSuperPower"/>
                        </div>
                    </div>
                </sf:form>                
            </div>

            <!-- Placed at the end of the document so the pages load faster -->
            <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>