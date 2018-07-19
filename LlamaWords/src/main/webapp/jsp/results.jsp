<%-- 
    Document   : results
    Created on : Mar 3, 2018, 5:05:49 PM
    Author     : JCLog
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Game Results</title>
    </head>
    <body>
        <h1>Game Results</h1>
        </hr>
        <div class="navbar navbar-default" style="text-align: center;">
            <ul class="nav navbar-nav" style="display: inline-block; float: none; vertical-align: top;">
               <li class="active"><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
                    <li ><a href="${pageContext.request.contextPath}/gameboard/gameboard?new=game">New Game</a></li>
                    <li ><a href="${pageContext.request.contextPath}/gameboard/gameboard">Current Board</a></li>
                    <li ><a href="${pageContext.request.contextPath}/highscores">High Scores</a></li>
            </ul>    
        </div>
        <p>
            You scored ${scores.points}
    </p>
    <p>
        What is your name genius!?
         <div class="form-group">
            <div class="col-md-8">
                <sf:input type="text" class="form-control" id="name"
                          path="name" placeholder="Your Name"/>
                <sf:errors path="name" cssclass="error"></sf:errors>
            </div>
            <input type="submit" class="btn btn-default" value="gameboard">
        </div>
    </p>


    <form action="/gameboard?new=game">
        <input type="submit" class="btn btn-default" value="gameboard">
    </form>
    <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>
