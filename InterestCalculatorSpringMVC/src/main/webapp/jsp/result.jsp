<%-- 
    Document   : result
    Created on : Feb 28, 2018, 7:46:31 PM
    Author     : JCLog
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
        <body>
        <h1>Result</h1>
        <p>
            Here are the Results of your investment ${billAmount}
        </p>
        <p>
         Initial Capital: 
         </br>
        <c:out value="${billAmount}"/> 
        </br>
        Principle at begining of Year : 
        </br>
        <c:out value="${tipAmount} "/>
        </br>
        Principle at the end of the year:
        </br>
        <c:out value="${tipProduct} "/>
        </br>
        The Total Interest Earned this year :
        </br>
        <c:out value="${total} "/>
        </br>
        Total:
        <c:out value="${total} "/>
</p>

<p>
    <a href="index.jsp">Calculate another tip amount!</a>
</p>
</html>
