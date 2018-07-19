<%-- 
    Document   : herosPage
    Created on : Apr 26, 2018, 11:25:39 AM
    Author     : JCLog
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Heros Page</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/myCss.css" rel="stylesheet">     
        <link href="${pageContext.request.contextPath}/css/sightingscss.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <h1>Heros</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayHerosPage">Heros Main Page</a></li>
                </ul>    
            </div>
            <div class="col-md-8">
                <h2>Heros</h2>
                <table id="superHeroTable" class="table table-hover">
                    <tr>
                        <th width="10%">SuperHero ID</th>
                        <th width="15%">Hero Name</th>
                        <th width="25%">Hero Description</th>
                    </tr>
                    <c:forEach var="currentSuperHero" items="${heroList}">
                        <tr>
                            <td>
                                <a href="displayHeroDetails?superHeroID=${currentSuperHero.superHeroID}">
                                    <c:out value="${currentSuperHero.superHeroID}"/> 
                                </a>
                            </td>
                            <td>
                                <a href="displayHeroDetails?superHeroID=${currentSuperHero.superHeroID}">                                 
                                    <c:out value="${currentSuperHero.name}"/>
                                </a>
                            </td>
                            <td>
                                <a href="displayHeroDetails?superHeroID=${currentSuperHero.superHeroID}">
                                    <c:out value="${currentSuperHero.description}"/>
                                </a>
                            </td>
                                <td>
                                    <a href="displayUpdateHero?superHeroID=${currentSuperHero.superHeroID}">
                                        Edit
                                    </a>
                                </td>
                                <td>
                                    <a href="deleteSuperHero?superHeroID=${currentSuperHero.superHeroID}">
                                        Delete
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>                    
                </div>
                <div class="col-md-6">
                    <h2>Add New Hero</h2>
                    <form class="form-horizontal" 
                          role="form" method="POST" 
                          action="createSuperHero">
                        <div class="form-group">
                            <label for="add-hero-name" class="col-md-4 control-label">Hero Name:</label>
                            <div class="col-md-6">
                                <input type="text" class="form-control" name="name" placeholder="Hero Name"/>
                                
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-description" class="col-md-4 control-label">Description:</label>
                            <div class="col-md-6">
                                <input type="text" class="form-control" name="description" placeholder="Tell us the Hero"/>
                               
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-superPowerID" class="col-md-4 control-label">SuperPower ID:</label>
                            <div class="col-md-6">
                                <input type="text" class="form-control" name="superPowerID" placeholder="Please give one or more power IDs"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-6">
                                <input type="submit" class="btn btn-default" value="Create SuperHero"/>
                            </div>
                        </div>
                    </form>
                </div>
        </div>
                <!-- Placed at the end of the document so the pages load faster -->
                <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
                <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        </body>
    </html>
