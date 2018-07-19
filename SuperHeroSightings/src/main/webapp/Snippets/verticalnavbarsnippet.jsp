<%-- 
    Document   : verticalnavbarsnippet
    Created on : Apr 2, 2018, 10:08:50 AM
    Author     : JCLog
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>    
        <title>Page Template Snippet</title>
        <link href="${pageContext.request.contextPath}/css/myCss.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="sidenav">
            <div class="bee">               
                <img src="http://i39.tinypic.com/2nvcf7l.jpg" alt="Bee" id="bee">
            </div>
            <h2> Buzz's Bees </h2>
            <h3 style="color: #FF299C"> Links </h3>

            <a style="color: #706F6F" href="https://www.zombeewatch.org/"><u>ZomBee Watch</u></a>
            <br>
            <a style="color: #706F6F" href="https://en.wikipedia.org/wiki/Apocephalus_borealis"><u>Apocephalus borealis</u></a>
            <br>
            <a style="color: #706F6F" href="http://veggieipsum.com/"><u>Veggie Ipsum!</u></a>
            <br>
        </div> 
        <h3 style="color: #FF299C"> Blog Posts </h3>
    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/post/{1}"><c:out value="${post.title}"/> </a></li>
    <br>
    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/post/{2}"><c:out value="${post.title}"/> </a></li>
    <br>
    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/post/{1}"><c:out value="${post.title}"/> </a></li>
    <br>

</body>
</html>

<!--ADD THIS TO YOUR JSP TO APPLY PROPER FORMATTING 
<div id="navbar">
<%--<%@ include file="/Snippets/horizontalnavbarsnippet.jsp" %>--%>
</div> -->