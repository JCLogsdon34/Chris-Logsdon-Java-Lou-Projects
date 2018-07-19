<%-- 
    Document   : Sandbox
    Created on : Mar 5, 2018, 3:01:26 PM
    Author     : JCLog
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Sandbox</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">     
    </head>
    <body>
        <div class="container">
            <h1>Sandbox</h1>
            <hr/>
            <div class="navbar navbar-default" style="text-align: center;">
                <ul class="nav navbar-nav" style="display: inline-block; float: none; vertical-align: top;">
                    <li class="active"><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
                    <li ><a href="${pageContext.request.contextPath}/gameboard?new=game">New Game</a></li>
                    <li ><a href="${pageContext.request.contextPath}/gameboard">Current Board</a></li>
                    <li ><a href="${pageContext.request.contextPath}/highscores">High Scores</a></li>
                </ul>    
            </div>
            </br>
            </hr>
            <!-- Main Page Content Start -->

            </br>
            </br>
            </br>
            <p>
                Word Goes Below Here:
            </p>
            <div class="col-md-16" style="text-align: center;">
                <c:forEach var="word" items="${word}">
                    <a href="${pageContext.request.contextPath}/newword">
                        <c:out value="${word.word}"/>    
                    </a>
                </c:forEach>
            </div>
            <p>
                And Above here
            </p>
            </hr>
            </br>
            </br>
            </br>


            <div class="form-group" style="text-align: center">
                <div class="col-md-8">
                    <a href="${pageContext.request.contextPath}/newWord">
                        <input type="submit" class="btn btn-default" value="New Word"/>
                    </a>
                </div>
            </div>
        </sf:form>
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>