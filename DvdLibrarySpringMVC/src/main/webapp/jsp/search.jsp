<%-- 
    Document   : search
    Created on : Mar 1, 2018, 8:02:03 PM
    Author     : JCLog
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Company Contacts</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">  
        <script src="${pageContext.request.contextPath}/js/dvdList.js"></script>
    </head>
    <body>
        <div class="container">
            <h1>Company Dvds</h1>
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
                          Dvds
                      </a>
                  </li>
                  <li role="presentation"
                      class="active">
                      <a href="${pageContext.request.contextPath}/displaySearchPage">
                          Search
                      </a> 
                  </li>
                </ul>    
            </div>
            <!-- Main Page Content Start -->
                        <ul class="list-group" id="errorMessages"></ul>
            <div class="row">
                <!-- 
                    Add a col to hold the summary table - have it take up half the row 
                -->
                <div class="col-md-6">
                    <h2>Search Results</h2>
                    <table id="contactTable" class="table table-hover">
                        <tr>
                            <th width="40%">Dvd Title</th>
                            <th width="30%">Release Date</th>
                            <th width="15%">Director's Name</th>
                            <th width="15%">Rating</th>
                        </tr>
                        <tbody id="contentRows"/>
                    </table>                    
                </div> <!-- End col div -->
                <!-- 
                    Add col to hold the search form - have it take up the other 
                    half of the row
                -->
                <div class="col-md-6">
                    <h2>Search</h2>
                    <form class="form-horizontal" role="form" id="search-form">
                        <div class="form-group">
                            <label for="search-dvd-title" class="col-md-4 control-label">Dvd Title:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="search-dvd-title" placeholder="Dvd Title"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="search-release-date" class="col-md-4 control-label">Release Date:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="search-release-date" placeholder="Release Date"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="search-directors-name" class="col-md-4 control-label">Director's Name:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="search-directors-name" placeholder="Director's Name"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="search-rating" class="col-md-4 control-label">Rating:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="search-rating" placeholder="Rating"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <input type="button" class="btn btn-default" id="search-button" value="Search"/>
                            </div>
                        </div>
                    </form>

                </div> <!-- End col div -->

            </div> <!-- End row div -->
            <!-- Main Page Content Stop -->                 
        </div>
            <!-- Main Page Content Stop -->                 
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>
