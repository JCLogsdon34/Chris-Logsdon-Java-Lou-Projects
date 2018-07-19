<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index Page</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/myCss.css" rel="stylesheet">     
        <link href="${pageContext.request.contextPath}/css/sightingscss.css" rel="stylesheet">

    </head>
    <body>
        <div class="container">
            <h1>Home Page For Hero Sightings</h1>
            <hr/>



            <div class="col-md-12">
                <h2>Welcome To Where We Keep Track of the Movements of Heros</h2>
                <a href="${pageContext.request.contextPath}/displayHomePage">Continue to Home Page</a>
                <img src="C:\Users\JCLog\Desktop\Chris-Logsdon-Individual-Work-Lou\SuperHeroSightings\image010jpg.jpg"/>
            </div>

        </div> 
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/superHeroSightings.js"></script>
    </body>
</html>