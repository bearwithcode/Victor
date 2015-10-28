<%-- 
    Document   : header
    Created on : 19-Apr-2015, 12:12:37
    Author     : Victor
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>welcome to entertainment center</title>
        <script src = 'js/MyScript.js'></script>
        <link rel="stylesheet" type="text/css" href="css/Mystyle.css" /> 
        <link href="image/drafavicon.ico" mce_href="favicon.ico" rel="icon" type="image/x-icon" /> 
    </head>
    <body>
        <header>
            <style>
                .targets{ 
                   width:400px;
                   height:190px;
                   background-color:#aaaaaa;
               }
            </style>
            <img src="image/layoutimg.PNG">
            <c:if test="${pageContext.request.remoteUser != null}">
                  <h1>Currently logged in as <c:out value="${pageContext.request.remoteUser}"/> <a href='logout.jsp'>Logout</a></h1>
            </c:if>               
        </header>
            <section>