<%-- 
    Document   : result
    Created on : Feb 28, 2018, 8:34:31 PM
    Author     : JCLog
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result Page</title>
    </head>
    <body>
        <h1>Result</h1>
        <p>
            Your bet was: ${bet}
        </p>
        <p>
            <c:out value="${billAmount}"/> 
            </br>
            The Most Which You Won Was : 
            <c:out value="${winnings} "/>
            </br>
            Rounds At Highest Winnings:
            <c:out value="${turnCounterAtWins} "/>
            </br>
            Total Turns :
            <c:out value="${turnCounter} "/>


        </p>

        <p>
            <a href="index.jsp">Play Again!</a>
        </p>
    </body>
</html>
