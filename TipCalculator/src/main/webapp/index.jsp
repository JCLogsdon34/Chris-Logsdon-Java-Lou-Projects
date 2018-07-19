<%-- 
    Document   : index
    Created on : Feb 27, 2018, 1:24:33 PM
    Author     : JCLog
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tip Calculator</title>
    </head>
        <body>
        <h1>Calculate My Tip</h1>
        <p>
            Please enter your bill: 
        </p>
        <form method="post" action="TipCalculator">
            <input type="text" name="billAmount"/><br/>
            <input type="submit" value="Find Tip!!!"/>
        </form>
    </body>
</html>
