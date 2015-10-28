<%-- 
    Document   : admin
    Created on : 19-May-2015, 16:24:06
    Author     : Victor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="header.jsp"/>

<div class="container">
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
            <ul class="nav navbar-nav navbar-right">
                <li><a class="navbar-brand" href="#" onclick="adminusecase(0)"><span class="glyphicon glyphicon-home"> HOME</span></a> </li>
                <li><a href="#menu-toggle" class="btn btn-info" id="menu-toggle"><span class="glyphicon glyphicon-pushpin"></span></a></li>
            </ul>                      
        </div>             
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">             
            <li><a href="Logout.jsp">Logout</a></li>
          </ul>
        </div>
      </div>
    </nav>
    
    <div id="wrapper" class="">
        
        <div id="sidebar-wrapper">
            <ul class="sidebar-nav ">
                <br>
                <li  data-toggle="collapse" data-target="#Assjob" class="collapsed active">
                  <a href="#">Personnel Administration<span class="glyphicon glyphicon-menu-right"></span></a>
                </li>
                <ul class="collapse" id="Assjob">
                    <li id="m1">
                        <a href="#" onclick="adminusecase(1)">Assign manager <span class="glyphicon glyphicon-pawn"></span></a>
                    </li>     
                    <li id="m2">
                        <a href="#" onclick="adminusecase(2)">shifting to manager <span class="glyphicon glyphicon-pawn"></span></a>
                    </li> 
                </ul>
                               
            </ul>
        </div>
        
        <div id="page-content-wrapper" id="home">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="page-header">
                           <h1>Hello Administration <%
                               HttpSession hs=request.getSession(true);  
                               String user = (String)hs.getAttribute("username");                         
                               out.print(user);
                           %> what bussiness for today</h1>
                        </div>                                           
                    </div>
                </div>
            </div>
        </div>
        
        <div class="col-xs-12 col4">
            <div id="sec0" >            
                    <img src="images/admin.jpg" class="img-responsive" >
            </div>
        </div>
        <div id="sec1" style="display: none;">
            <jsp:include page="createrole.jsp"/>
        </div>
        <div id="sec2" style="display: none;">
            <ul class="list-group">
                <li class="list-group-item"><a href="flightmanager.jsp">flight manager <span class="glyphicon glyphicon-queen"></span></a></li>
                <li class="list-group-item"><a href="servicemanager.jsp">service manager <span class="glyphicon glyphicon-bishop"></span></a></li>
                <li class="list-group-item"><a href="profilemanager.jsp">profile manager <span class="glyphicon glyphicon-knight"></span></a></li>
                <li class="list-group-item"><a href="bookingmanager.jsp">booking manager <span class="glyphicon glyphicon-pawn"></span></a></li>
            </ul>
        </div>
        
    </div>
</div>

<script>  
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });
</script>
<jsp:include page="footer.jsp"/>
