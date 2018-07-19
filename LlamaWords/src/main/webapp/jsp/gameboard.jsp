<%-- 
    Document   : CurrentBoard
    Created on : Mar 2, 2018, 3:59:01 PM
    Author     : JCLog
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Current Board</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">      
    </head>
    <body>
        <div class="container">
            <h1>Current Board</h1>
            <hr/>
            <div class="navbar navbar-default" style="text-align: center;">
                <ul class="nav navbar-nav" style="display: inline-block; float: none; vertical-align: top;">
                    <li class="active"><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
                    <li ><a href="${pageContext.request.contextPath}/gameboard/gameboard?new=game">New Game</a></li>
                    <li ><a href="${pageContext.request.contextPath}/gameboard/gameboard">Current Board</a></li>
                    <li ><a href="${pageContext.request.contextPath}/highscores">High Scores</a></li>
                </ul>    
            </div>
            </br>
            </hr>
            </br>
            </br>
            <!-- Main Page Content Start -->

            </hr>
            </br>
            </br>
            </br>
            <p>
                Word Goes Below Here:
            </p>
            <div class="col-md-16" style="text-align: center;">
                <a href="${pageContext.request.contextPath}/gameboard/{word}">
                    <c:out value="${word}"/>    
                </a>
                </br>
                <a href="${pageContext.request.contextPath}/gameboard">
                    <c:out value="${turns}"/>    
                </a>
            </div>
            <p>
                And Above here
            </p>
            </hr>
            </br>
            </br>
            </br>

            <sf:form class="form-horizontal" role="form" modelAttribute="guess"
                     action="gameboard" method="GET">

                <div class="col-md-12" style="text-align: center;" >
                    <sf:input type="button" class="form-control" id="letters"
                              path="letters"/>

                    <input type="button" class="btn btn-default" id="Q" value="Q">
                    <input type="button" class="btn btn-default" id="W" value="W">
                    <input type="button" class="btn btn-default" id="E" value="E">
                    <input type="button" class="btn btn-default" id="R" value="R">
                    <input type="button" class="btn btn-default" id="T" value="T">
                    <input type="button" class="btn btn-default" id="Y" value="Y">
                    <input type="button" class="btn btn-default" id="U" value="U">
                    <input type="button" class="btn btn-default" id="I" value="I">
                    <input type="button" class="btn btn-default" id="O" value="O">
                    <input type="button" class="btn btn-default" id="P" value="P">
                    <input type="button" class="btn btn-default" id="A" value="A">
                    <input type="button" class="btn btn-default" id="R" value="R">
                    <input type="button" class="btn btn-default" id="T" value="T">
                    </br>
                </div>
                </br>
                </br>
                <div class="col-md-12" style="text-align: center;">
                    <sf:input type="button" class="form-control" id="letters"
                              path="letters"/>
                    <input type="button" class="btn btn-default" id="S" value="S">
                    <input type="button" class="btn btn-default" id="D" value="D">
                    <input type="button" class="btn btn-default" id="F" value="F">
                    <input type="button" class="btn btn-default" id="G" value="G">
                    <input type="button" class="btn btn-default" id="H" value="H">
                    <input type="button" class="btn btn-default" id="J" value="J">
                    <input type="button" class="btn btn-default" id="K" value="K">
                    <input type="button" class="btn btn-default" id="L" value="L">
                    <input type="button" class="btn btn-default" id="Z" value="Z">
                    <input type="button" class="btn btn-default" id="X" value="X">
                    <input type="button" class="btn btn-default" id="C" value="C">
                    <input type="button" class="btn btn-default" id="V" value="V">
                    <input type="button" class="btn btn-default" id="B" value="B">
                    <input type="button" class="btn btn-default" id="N" value="N">
                    <input type="button" class="btn btn-default" id="M" value="M">
                </div>
                </br>
                </br>
                </br>
                </br>
                </br>
                </br>
                </br>
                </br>
                <div class="form-group" style="text-align: center">
                    <div class="col-md-8">
                        <a href="${pageContext.request.contextPath}/gameboard">
                            <input type="submit" class="btn btn-default" value="new word"/>
                        </a>
                    </div>
                </div>
            </sf:form>
            <!-- Main Page Content Stop -->    
            <!-- Placed at the end of the document so the pages load faster -->
            <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>
