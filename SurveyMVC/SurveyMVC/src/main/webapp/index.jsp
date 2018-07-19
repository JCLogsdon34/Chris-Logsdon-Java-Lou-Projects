<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Survey MVC</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">        
    </head>
    <body>
        <div class="container">
            <h1>SURVEY</h1>
            <hr/>

            <form action="${pageContext.request.contextPath}/processForm" method="POST">
                <div class="form-group">
                    <label for="nameInput">Name:</label>
                    <input type="text" class="form-control" id="nameInput" name="name">
                </div>
                <div class="form-group">
                    <label for="ageInput">Age:</label>
                    <input type="number" step="1" class="form-control" id="ageInput" name="age">
                </div>
                <div class="form-group">
                    <label for="colorInput">Fav Color:</label>
                    <input type="text" class="form-control" id="colorInput" name="color">
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>

        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>

