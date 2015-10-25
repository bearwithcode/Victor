<%-- 
    Document   : index
    Created on : 17/10/2015, 6:13:46 PM
    Author     : victor
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="header.jsp"/>

<div class="container">
        <h1><b>Welcome to record every moment of your life</b></h1>
        <button class="btn-primary" onclick="window.open('welcomediaryCon')">I'm here</button>
        
        <p><b>If you are new to the system, please sign up below. If you are an existing user, please click I'm here.</b></p>  
       <form class="form-signup" method="post" action="registerCon">
        <h2 class="form-signup-heading">Sign Up Here</h2>              
        <label for="inputUsername" class="sr-only">Username</label>
        <input type="text" id="inputUsername" name="username" class="form-control" placeholder="Username" required>

        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required>
        
        <button class="btn btn-lg btn-primary btn-block form-signup-submit-button" type="submit">Register now</button>
      </form>

        <p id="info">
            <c:if test="${requestScope.msg != null}">
                <span class="label label-warning"><b><c:out value="${requestScope.msg}"/></b></span>
            </c:if> 
        </p>   
</div>

<jsp:include page="footer.jsp"/>
