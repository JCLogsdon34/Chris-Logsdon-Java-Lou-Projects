<%-- 
    Document   : editDvdForm
    Created on : Mar 1, 2018, 8:15:46 PM
    Author     : JCLog
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- Directive for Spring Form tag libraries -->
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Company Contacts</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">        
    </head>
    <body>
        <div class="container">
            <h1>Edit Dvd</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/index.jsp">
                            Home
                        </a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/displayDvdsPage">
                            Contacts
                        </a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/displaySearchPage">
                            Search
                        </a>
                    </li>
                </ul>    
            </div>
            <sf:form class="form-horizontal" role="form" modelAttribute="dvd"
                     action="editDvd" method="POST">
                <div class="form-group">
                    <label for="add-dvd-title" class="col-md-4 control-label">Dvd Title:</label>
                    <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-first-title"
                                  path="dvdTitle" placeholder="Dvd Title"/>
                        <sf:errors path="dvdTitle" cssclass="error"></sf:errors>
                    </div>
                </div>
                <div class="form-group">
                    <label for="add-release-year" class="col-md-4 control-label">Release Year:</label>
                    <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-release-year"
                                  path="releaseYear" placeholder="Release Year"/>
                        <sf:errors path="releaseYear" cssclass="error"></sf:errors>
                    </div>
                </div>
                <div class="form-group">
                    <label for="add-director-name" class="col-md-4 control-label">Director's Name:</label>                          
                    <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-company"
                                  path="diectorsName" placeholder="Director's Name"/>
                        <sf:errors path="directorsName" cssclass="error"></sf:errors>
                    </div>
                </div>
                <div class="form-group">
                    <label for="add-rating" class="col-md-4 control-label">Rating:</label>
                    <div class="col-md-8">
                        <sf:input type="rating" class="form-control" id="add-rating"
                                  path="rating" placeholder="Rating"/>
                        <sf:errors path="rating" cssclass="error"></sf:errors>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-offset-4 col-md-8">
                        <input type="submit" class="btn btn-default" value="Update Dvd"/>
                    </div>
                </div>
            </sf:form>                
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>
