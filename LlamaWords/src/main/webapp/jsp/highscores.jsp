<%-- 
    Document   : HighScores
    Created on : Mar 2, 2018, 3:59:17 PM
    Author     : JCLog
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>High Scores</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">        
    </head>
    <body>
        <div class="container">
            <h1>High Scores</h1>
            <hr/>
            <div class="navbar navbar-default" style="text-align: center;">
                <ul class="nav navbar-nav" style="display: inline-block; float: none; vertical-align: top;">
                   <li class="active"><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
                    <li ><a href="${pageContext.request.contextPath}/gameboard/gameboard?new=game">New Game</a></li>
                    <li ><a href="${pageContext.request.contextPath}/gameboard/gameboard">Current Board</a></li>
                    <li ><a href="${pageContext.request.contextPath}/highscores">High Scores</a></li>
                </ul>    
            </div>
            <!-- Main Page Content Start -->
            <div class="row">

                <div class="col-md-8">
                    <h2>High Scores</h2>
                    <table id="highScoresTable" class="table table-hover">
                        <tr>
                            <th width="55%">Name: </th>
                            <th width="45%">Score: </th>
                        </tr>
                        <c:forEach var="/topscores" items="${score}">             
                            <tr>
                                <td>
                                    <a href="${pageContext.request.contextPath}/highscores/topscores">
                                        <c:out value="${topScores.name}"/>  
                                    </a>
                                </td>
                                <td>
                                    <c:out value="${topScores.score}"/> 
                                </td>
                            </tr>
                        </c:forEach>
                    </table>                    
                </div> <!-- End col div -->
                <!-- Main Page Content Stop -->    
            </div>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>