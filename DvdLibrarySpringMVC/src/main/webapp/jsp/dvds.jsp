<%-- 
    Document   : dvds
    Created on : Mar 1, 2018, 8:15:21 PM
    Author     : JCLog
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Dvds</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">        
    </head>
    <body>
        <div class="container">
            <h1>Dvds</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation"> 
                        <a href="${pageContext.request.contextPath}/index.jsp">
                            Home
                        </a>
                    </li>
                    <li role="presentation"
                        class="active">
                        <a href="${pageContext.request.contextPath}/displayDvdsPage">
                            Dvds
                        </a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/displaySearchPage">
                            Search
                        </a>
                    </li>
                </ul>    
            </div>
            <!-- Main Page Content Start -->
            <div class="row">
                <!-- 
                    Add a col to hold the summary table - have it take up half the row 
                -->
                <div class="col-md-6">
                    <h2>My Dvds</h2>
                    <table id="dvdTable" class="table table-hover">
                        <tr>
                            <th width="40%">Dvd Title</th>
                            <th width="30%">Release Date</th>
                            <th width="15%"></th>
                            <th width="15%"></th>
                        </tr>
                        <c:forEach var="currentDvd" items="${dvdList}">
                            <tr>
                                <td>
                                    <a href="displayDvdDetails?dvdTitle=${currentDvd.dvdTitle}">
                                        <c:out value="${currentDvd.dvdTitle}"/> <c:out value="${currentDvd.releaseDate}"/>
                                    </a>
                                </td>
                                <td>
                                    <c:out value="${currentDvd.dvdTitle}"/>
                                </td>
                                <td>
                                    <a href="displayEditDvdForm?contactId=${currentDvd.dvdTitle}">
                                        Edit
                                    </a>
                                </td>
                                <td>
                                    <a href="deleteDvd?dvdTitle=${currentDvd.dvdTitle}">
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
                    <h2>Add New Dvd</h2>
                    <form class="form-horizontal" 
                          role="form" method="POST" 
                          action="createDvd">
                        <div class="form-group">
                            <label for="add-dvd-title" class="col-md-4 control-label">Dvd Title:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="dvdTitle" placeholder="Dvd Title"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-release-date" class="col-md-4 control-label">Release Date:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="releaseDate" placeholder="Release Date"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-directors-name" class="col-md-4 control-label">Director's Name:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="directorsName" placeholder="Director's Name"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-rating" class="col-md-4 control-label">Rating:</label>
                            <div class="col-md-8">
                                <input type="rating" class="form-control" name="rating" placeholder="Rating"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <input type="submit" class="btn btn-default" value="Create Dvd"/>
                            </div>
                        </div>
                    </form>

                </div> <!-- End col div -->

            </div> <!-- End row div -->
            <!-- Main Page Content Stop -->    
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>
