<%-- 
    Document   : index
    Created on : Feb 26, 2018, 10:42:47 AM
    Author     : JCLog
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Factorizor</title>
    </head>
    <body>
        <h1>Factorizor</h1>
        <p>
            Please enter the number you want to factor: 
        </p>
        <form method="post" action="FactorizorServlet">
            <input type="text" name="numberToFactor"/><br/>
            <input type="submit" value="Find Factors!!!"/>
        </form>
    </body>
</html>
