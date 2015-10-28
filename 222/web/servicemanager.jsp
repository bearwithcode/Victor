<%-- 
    Document   : servicemanager
    Created on : 19-May-2015, 17:09:45
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
                <li><a class="navbar-brand" href="#" onclick="smusecase(0)"><span class="glyphicon glyphicon-home"> HOME</span></a> </li>
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
                <li  data-toggle="collapse" data-target="#createser" class="collapsed active">
                  <a href="#">Create Services<span class="glyphicon glyphicon-menu-right"></span></a>
                </li>
                <ul class="collapse" id="createser">
                    <li id="m1">
                        <a href="#" onclick="smusecase(1)">Create and Discard Services Available <span class="glyphicon glyphicon-apple"></span></a>
                    </li>                        
                </ul>
                
                <li  data-toggle="collapse" data-target="#modiser" class="collapsed active">
                  <a href="#">Modify Services<span class="glyphicon glyphicon-menu-right"></span></a>
                </li>
                <ul class="collapse" id="modiser">                  
                    <li id="m2">
                        <a href="#" onclick="smusecase(2)">Change Service Costs and Included Flight Services <span class="glyphicon glyphicon-erase"></span></a>
                    </li>                                     
                </ul>
            </ul>
        </div>
        
        <div id="page-content-wrapper" id="home">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="page-header">
                           <h1>Hello Service manager <%
                               HttpSession hs=request.getSession(true);  
                               String user = (String)hs.getAttribute("username");                         
                               out.print(user);
                           %> what's managing for today</h1>
                        </div>                                           
                    </div>
                </div>
            </div>
        </div>
       
         <div class="col-xs-12">
            <div id="sec0" >            
                    <img src="images/servicem.jpg" class="img-responsive" >
            </div>
             <div id="sec1" >
                 <div class="page-header">
                     <h3>Inventory List</h3>
                 </div>
                 <br><hr>
                 <jsp:include page="listinventory.jsp"/>
                 <br><hr>
                 <button type='button' class='btn btn-info ' data-toggle='modal' data-target='#CreateIv'>Create Inventory Item </button>                
             </div>
             <div id="sec2" >
                 <div class="page-header">
                     <h3>Inventory List</h3>
                 </div>
                 <br><hr>
                 <jsp:include page="listinventoryII.jsp"/>
                 <br><hr>                
             </div>            
        </div>                  
        
    </div>
             
             <div class="modal fade" id="CreateIv" role="dialog" >
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            Create Inventory
                        </div>                        
                        <div class="modal-body" style="height: 400px">
                            <script type="text/javascript" src="js/ajax7.js"></script>
                            <form class="form-control" id="eachinv">
                            <label for="chooseitem">Item</label>
                            <select class="form-control" id="chooseitem" name="chooseitem" required>
                                <option value="small meal">small meal</option>
                                <option value="standard meal">standard meal</option>
                                <option value="deluxe meal">deluxe meal</option>
                                <option value="dietary needs meal">dietary needs meal</option>
                                <option value="packet of chips">packet of chips</option>
                                <option value="packet of nuts">packet of nuts</option>
                                <option value="chocolate bar">chocolate bar</option>
                                <option value="snack pack">snack pack</option>
                                <option value="bottle water">bottle water</option>
                                <option value=">beer">beer</option>
                                <option value="wine">wine</option>
                                <option value="spirit">spirit</option>
                                <option value="soft drink">soft drink</option>
                                <option value="Tea/Coffee">Tea/Coffee</option>
                                <option value="screen hire">screen hire</option>
                                <option value="headphones">headphones</option>
                                <option value="movie hire">movie hire</option>
                                <option value="Batteries">Batteries</option>
                                <option value="Charger hire">Charger hire</option>
                                <option value="WIFI hire">WIFI hire</option>
                                <option value="blanket">blanket</option>
                                <option value="pillow">pillow</option>
                            </select>
                            
                            <label for="cost">Cost</label>
                            <input class="form-control" id="cost" name="cost" type="number" min="0" step="1" required>
                            
                            <label for="avail">Availability</label>
                            <select id="avail" name='avail' class="form-control" required>
                                <option value="All">All</option>
                                <option value="Intenational">Intenational</option>
                            </select>
                            
                            <input onclick="ajax7()" type="submit" class="btn btn-info"   value="Create">
                            </form>
                        </div>
                        <div class="modal-footer">                             
                          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>                       
                    </div>                  
                </div>                
            </div>
             
             <div class="modal fade" id="changeitem" role="dialog" >
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            Change Inventory Cost and availability
                        </div>
                        <div class="modal-body" style="height: 300px">
                            <script type="text/javascript" src="js/ajax8.js"></script>   
                            <form class="form-control" id="conch">
                                <input class="form-control" id="chitem" name="chitem" type="hidden">
                                
                                <label for="ccost">Cost</label>
                                <input class="form-control" id="ccost" name="ccost" type="number" min="0" step="1">

                                <label for="cavail">Availability</label>
                                <select id="cavail" name='cavail' class="form-control">
                                    <option value="All">All</option>
                                    <option value="Intenational">Intenational</option>
                                </select>

                                <input onclick="ajax8()" type="submit" class="btn btn-info" value="confirm changing">
                            </form>
                        </div>
                        <div class="modal-footer">                                                   
                          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div>                  
                </div>                
            </div>
                 
                 <div class="modal fade" id="confirmreit" role="dialog" >
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            Confirm delete this Item?
                        </div>
                        <div class="modal-body">
                            <script type="text/javascript" src="js/ajax9.js"></script>
                            <form id="confirmd">                                
                                <input class="form-control" id="ditem" name="ditem" type="hidden">

                                <input onclick="ajax9()" type="submit" class="btn btn-warning btn-lg btn-primary"  value="confirm deleting">
                            </form>
                        </div>
                        <div class="modal-footer">       
                          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div>                  
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
