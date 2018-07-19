<%-- 
    Document   : horizontalnavbarsnippet
    Created on : Apr 2, 2018, 6:58:37 PM
    Author     : JCLog
--%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <link href="${pageContext.request.contextPath}/css/myCss.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <title>Page Template Snippet</title>
    </head>
    <body>
        <div class="hblogo">
            <a href="${pageContext.request.contextPath}/">
            <img src="Snippets/logo.jpg" alt="logo"/>
            </a>
        </div>
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <ul class="nav navbar-nav">
                    <li><a href="${pageContext.request.contextPath}/displayPost?postID=2"><span class="glyphicon glyphicon-home"></span></a></li>
                    <li><a href="${pageContext.request.contextPath}/aboutUs">About Us</a></li>
                    <li><a href="${pageContext.request.contextPath}/whereAreAllTheBees">Where are all the Bees?</a></li>
                    <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Posts<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="${pageContext.request.contextPath}/displayAllPosts">All Posts</a></li>
                            <li><a href="${pageContext.request.contextPath}/newpost">New Post</a></li>
                            <li><a href="#"></a> </li>
                        </ul>
                    </li>

                    <li><a href="${pageContext.request.contextPath}/displayAllAuthors">Author</a></li>
                    <li><a href="${pageContext.request.contextPath}/displayContactUsForm">Contact Us</a></li>  
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="${pageContext.request.contextPath}/createAccount"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                    <li><a href="${pageContext.request.contextPath}/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                </ul>
            </div>
        </nav>
    </body>
</html>

<!-- INCLUDE THIS IN JSP FOR NAVBAR AND INCLUDE MYCSS.CSS!!!

<div id="navbar">
<%--<%@ include file="/Snippets/horizontalnavbarsnippet.jsp" %>--%>
</div>-->