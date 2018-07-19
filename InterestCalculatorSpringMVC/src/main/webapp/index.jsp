<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Index Page</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" 
              rel="stylesheet">             
    </head>
    <body>
        <div class="container">
            <h1>Interest Calculator</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation" 
                        class="active">
                        <a href="${pageContext.request.contextPath}/index.jsp">
                            Home
                        </a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/hello/sayhi">
                            Hello Controller
                        </a>
                    </li>
                </ul>    
            </div>
            <h2>Investment Info:</h2>
            <form method="POST" action="factorNumber">
                <h3>Years Invested</h3>
                </br>
                <input type="text" name="years"/>
                </br>
                <h3>Principle</h3>
                <input type="text" name="principle"/>
                </br>

                <h3>Interest Rate</h3>
                <input type="text" name="interestRate"/>
                </br>

                <input type="submit" value="Money Me!!!"/>
            </form>
        </div>
</html>

