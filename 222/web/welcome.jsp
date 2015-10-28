<%-- 
    Document   : welcome
    Created on : 11-May-2015, 14:22:44
    Author     : Victor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="header.jsp"/>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>          
          </button>
          <a class="navbar-brand" href="#"></a>
        </div>
        
        <form class="navbar-form navbar-right" method="post" action="LoginController">
            <div class="form-group">
              <input type="text" placeholder="Username" name="username" class="form-control" required autofocus>
            </div>
            <div class="form-group">
              <input type="password" placeholder="Password" name="password" class="form-control" required>
            </div>
            <button type="submit" class="btn btn-success">Login</button>
          </form>
      </div>
</nav>

<div class="img-responsive" class ="plane">
    <img class="plane" src="images/header.PNG">
</div>

<div class="container">
        <h1><b>Welcome to our airline website!</b></h1>
        <p><b>If you are new to the system, please sign up below. If you are an existing user, please sign in above.</b></p>  
       <form class="form-signup" method="post" action="RegisterController" onSubmit="return checkform()">
        <h2 class="form-signup-heading">Sign Up Here</h2>              
        <label for="inputUsername" class="sr-only">Username</label>
        <input type="text" id="inputUsername" name="username" class="form-control" placeholder="Username" required>

        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>

        <label for="inputConfirmPassword" class="sr-only">Confirm Password</label>
        <input type="password" id="inputConfirmPassword" name="password"  class="form-control" placeholder="Confirm Password" required>      
        
        <button class="btn btn-lg btn-primary btn-block form-signup-submit-button" type="submit">Register now</button>
      </form>

        <p id="info">
                <%
                    String c = (String)request.getAttribute("msg");
                    if(c != null)
                        out.println("<span class='label label-warning'><b>" + c + "<b></span>");
                %>
        </p>   
</div>

<jsp:include page="footer.jsp"/>
