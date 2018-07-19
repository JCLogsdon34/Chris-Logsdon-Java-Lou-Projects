<%-- 
    Document   : result.jsp
    Created on : Feb 27, 2018, 1:24:56 PM
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
            You asked us for a tip for ${billAmount}
        </p>
        <p>
            The Bill is: 
        
        <c:out value="${billAmount}"/> 
        The Tip Amount is : 
        <c:out value="${tipAmount} "/>
        <c:out value="${tipProduct} "/>
        The Total is :
        <c:out value="${total} "/>

</p>

<p>
    <a href="index.jsp">Calculate another tip amount!</a>
</p>
</body>
</html>

