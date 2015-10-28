<%-- 
    Document   : flightmanager
    Created on : 19-May-2015, 17:10:09
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
                <li><a class="navbar-brand" href="#" onclick="flmusecase(0)"><span class="glyphicon glyphicon-home"> HOME</span></a> </li>
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
                <li  data-toggle="collapse" data-target="#location" class="collapsed active">
                  <a href="#">Location and Routing<span class="glyphicon glyphicon-menu-right"></span></a>
                </li>
                <ul class="collapse" id="location">
                    <li id="m1">
                        <a href="#" onclick="flmusecase(1)">Create and Delete Airpot record <span class="glyphicon glyphicon-flag"></span></a>
                    </li>        
                    <li id="m2">
                        <a href="#" onclick="flmusecase(2)">Mapping the Route <span class="glyphicon glyphicon-globe"></span></a>
                    </li> 
                </ul>    
                
                <li  data-toggle="collapse" data-target="#fleet" class="collapsed active">
                  <a href="#">Fleet<span class="glyphicon glyphicon-menu-right"></span></a>
                </li>
                <ul class="collapse" id="fleet">
                    <li id="m3">
                        <a href="#" onclick="flmusecase(3)">Create fleet <span class="glyphicon glyphicon-road"></span></a>
                    </li>        
                    <li id="m4">
                        <a href="#" onclick="flmusecase(4)">Add Airplane <span class="glyphicon glyphicon-plane"></span></a>
                    </li> 
                </ul> 
                
                <li  data-toggle="collapse" data-target="#schedule" class="collapsed active">
                  <a href="#">Schedule<span class="glyphicon glyphicon-menu-right"></span></a>
                </li>
                <ul class="collapse" id="schedule">
                    <li id="m5">
                        <a href="#" onclick="flmusecase(5)">Build Schedule <span class="glyphicon glyphicon-list-alt"></span></a>
                    </li>        
                    <li id="m6">
                        <a href="#" onclick="flmusecase(6)"> Delete schedule <span class="glyphicon glyphicon-time"></span></a>
                    </li>                     
                </ul> 
            </ul>
        </div>
        
        <div id="page-content-wrapper" id="home">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="page-header">
                           <h1>Hello Flight manager <%
                               HttpSession hs=request.getSession(true);  
                               String user = (String)hs.getAttribute("username");                         
                               out.print(user);
                           %> what's managing for today</h1>
                        </div>                                           
                    </div>
                </div>
            </div>
        </div>
       
        <div class="col-xs-12 col4">
            <div id="sec0" >            
                    <img src="images/flightm.png" class="img-responsive" >
            </div>
            <div id="sec1" >
                <jsp:include page="airportlistcd.jsp"/>
                <button type='button' class='btn btn-info ' data-toggle='modal' data-target='#CreateAR'>Create Airport Record </button>
            </div>
            <div id="sec2" >
                <jsp:include page="airportlistR.jsp"/>
                <button type='button' class='btn btn-info ' data-toggle='modal' data-target='#confirmRT'>Create Route </button>
            </div>
            <div id="sec3" >
                <jsp:include page="airportlistF.jsp"/>
            </div>
            <div id="sec4" >
                <jsp:include page="listfleet.jsp"/>               
            </div>
            <div id="sec5" >
                <button onclick="getrouteforch()" type='button' class='btn btn-info ' data-toggle='modal' data-target='#ViewRouteCh'>Choose the route </button>
                <table class="table table-striped" id="takeoffplane">
                    
                </table>
                <script type="text/javascript" src="js/ajax15.js"></script>
                <form id="addschedule" class="form-control">
                <label class="form-control" for="Choroute">Choson route</label>
                <input class="form-control" id="Choroute" type="text" name="Choroute" readonly required>  
                
                <label class="form-control" for="Chopid">Choson Plane Td</label>
                <input class="form-control" id="Chopid" type="text" name="Chopid" readonly required>
                
                <label class="form-control" for="depdate">Depart Date</label>
                <input class="form-control datepicker" name="depdate" id="depdate" data-date-format="mm/dd/yyyy">
                
                <label class="form-control" for="deptime">Depart Time</label>
                <input class="form-control" name="deptime" id="deptime" type="time">
                
                <label class="form-control" for="Ardate">Arrive Date</label>
                <input class="form-control datepicker" name="ardate" id="ardate" data-date-format="mm/dd/yyyy">
                
                <label class="form-control" for="artime">Arrive Time</label>
                <input class="form-control" name="artime" id="artime" type="time">
                
                <input onclick="ajax15()" type="submit" class='btn btn-info' value="Create Schedule">
                </form>
            </div>
            <div id="sec6" >
                <jsp:include page="schedulelistD.jsp"/>
            </div>
        </div>                   
        
    </div>
            
            <div class="modal fade" id="CreateAR" role="dialog" >
                <div class="modal-dialog">
                    <div class="modal-content" >
                        <div class="modal-header" >
                            New Airport Record                          
                        </div>
                        <div class="modal-body" style="height: 650px">
                            <script type="text/javascript" src="js/ajax10.js"></script>
                            <form id="newair" class="form-control">
                                <label for="airname">Air portname</label>
                                <input class="form-control" id="airname" name="airname" type="text">
                                
                                <label for="aircity">City</label>
                                <input class="form-control" id="aircity" name="aircity" type="text">
                                
                                <label for="aircou">Country</label>
                                <input class="form-control" id="aircou" name="aircou" type="text">
                                
                                <label for="airITIA">ITIA(the 3 letters of Airportname)</label>
                                <input class="form-control" id="airITIA" name="airIata" type="text">
                                
                                <label for="airLat">Latitude</label>
                                <input class="form-control" id="airLat" name="airLat" type="number" step="any">
                                
                                <label for="airLat">Longitude</label>
                                <input class="form-control" id="airLon" name="airLon" type="number" step="any">
                                
                                <label for="altitude">Altitude</label>
                                <input class="form-control" id="altitude" name="altitude" type="number">
                                
                                <label for="timezone">Timezone</label>
                                <input class="form-control" id="timezone" name="timezone" type="text">
                                
                                <label for="dst">DST</label>
                                <input class="form-control" id="dst" name="dst" type="text">
                                
                                <input onclick="ajax10()" type="submit" value="Add" class="form-control btn-info">
                            </form>
                        </div>
                        <div class="modal-footer">
                          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div>                  
                </div>                
            </div>                   
</div>
            
            <div class="modal fade" id="deleteAR" role="dialog" >
                <div class="modal-dialog">
                    <div class="modal-content" >
                        <div class="modal-header" >
                            Are u sure u want to delete this airport                        
                        </div>
                        <div class="modal-body">
                            <script type="text/javascript" src="js/ajax11.js"></script>
                            <form id="delair" class="form-control">
                                <input  id="dairportiata" name="dairportiata" type="hidden">
                                <input onclick="ajax11()" type="submit" class="btn btn-warning btn-lg btn-primary"  value="confirm">
                            </form>
                        </div>
                        <div class="modal-footer">
                          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div>                  
                </div>                
            </div>
            
            <div class="modal fade" id="addtoroute" role="dialog" >
                <div class="modal-dialog">
                    <div class="modal-content" >
                        <div class="modal-header" >
                            choose destination or source                      
                        </div>
                        <div class="modal-body">
                            <label for="choosing">Choosing airport IATA</label>
                            <input type="text" id="choosing" readonly>
                            <button onclick="chooseairport(1)" data-dismiss="modal" class="btn-info">source</button>
                            <button onclick="chooseairport(2)" data-dismiss="modal" class="btn-info">destination</button>
                        </div>
                        <div class="modal-footer">
                          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div>                  
                </div>                
            </div>
            
            <div class="modal fade" id="addtofleet" role="dialog" >
                <div class="modal-dialog">
                    <div class="modal-content" >
                        <div class="modal-header" >
                            Add new fleet to this airport                       
                        </div>
                        <div class="modal-body">
                            <script type="text/javascript" src="js/ajax13.js"></script>
                            <form id="newfleet" class="form-control">
                                <input class="form-control" id="choosing2" name="choosing2" type="hidden">
                                <input onclick="ajax13()" type="submit" class="btn btn-warning btn-lg btn-primary"  value="create">
                            </form>
                        </div>
                        <div class="modal-footer">
                          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div>                  
                </div>                
            </div>
            
            <div class="modal fade" id="addplanepanel" role="dialog" >
                <div class="modal-dialog">
                    <div class="modal-content" >
                        <div class="modal-header" >
                            Add new plane to fleet                     
                        </div>
                        <div class="modal-body" style="height: 400px">
                            <script type="text/javascript" src="js/ajax14.js"></script>
                            <form id="newplane" class="form-control">
                                <input class="form-control" id="choosing3" name="choosing3" type="hidden">
                               
                                <label for="fclass">First Class</label>
                                <input class="form-control" type="number" step="1" id="fclass" name="fclass">
                                
                                <label for="bclass">Business Class</label>
                                <input class="form-control" type="number" step="1" id="bclass" name="bclass">
                                
                                <label for="pclass">Premium Class</label>
                                <input class="form-control" type="number" step="1" id="pclass" name="pclass">
                                
                                <label for="eclass">Economy Class</label>
                                <input class="form-control" type="number" step="1" id="eclass" name="eclass">
                                
                                <input onclick="ajax14()" type="submit" class="btn btn-warning btn-lg btn-primary"  value="create">
                            </form>
                        </div>
                        <div class="modal-footer">
                          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div>                  
                </div>                
            </div>
            
            <div class="modal fade" id="viewcurrentplanes" role="dialog" >
                <div class="modal-dialog">
                    <div class="modal-content" >
                        <div class="modal-header" >
                            Current airplane in the fleet                    
                        </div>
                        <div class="modal-body" style="height: 500px">
                            <form id="newfleet" class="form-control">
                                <table id="cuplanelist" class="table-striped table">
                                    
                                </table>
                            </form>
                        </div>
                        <div class="modal-footer">
                          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div>                  
                </div>                
            </div>
            
            <div class="modal fade" id="ViewRouteCh" role="dialog" >
                <div class="modal-dialog">
                    <div class="modal-content" >
                        <div class="modal-header" >
                            Select a route                   
                        </div>
                        <div class="modal-body" style="height: 600px">
                                <table id="routelistofsch" class="table-striped table">
                                    
                                </table>
                        </div>
                        <div class="modal-footer">
                          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div>                  
                </div>                
            </div>
            
            <div class="modal fade" id="confirmdelete" role="dialog" >
                <div class="modal-dialog">
                    <div class="modal-content" >
                        <div class="modal-header" >
                            Are u sure u want to delete this schedule                  
                        </div>
                        <div class="modal-body">
                            <script type="text/javascript" src="js/ajax16.js"></script>
                            <form class="form-control" id="delschform">
                                <input id="delschid" class="form-control" name="delschid" type="hidden">
                                <input onclick="ajax16()" type="submit" value="confirm delete" class="btn-warning btn">
                            </form> 
                        </div>
                        <div class="modal-footer">
                          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div>                  
                </div>                
            </div>
            
            <div class="modal fade" id="confirmRT" role="dialog" >
                <div class="modal-dialog">
                    <div class="modal-content" >
                        <div class="modal-header" >
                            confirm create new route                      
                        </div>
                        <div class="modal-body" style="height: 500px">
                            <script type="text/javascript" src="js/ajax12.js"></script>
                            <form id="addroute" class="form-control">
                                <label class="form-control" for="source">Source airport</label>
                                <input class="form-control" id="source" type="text" name="source" readonly required>
                                <label class="form-control" for="destination">Destination airport</label>
                                <input class="form-control" id="destination" type="text" name="destination" readonly required>

                                    <label class="form-control" for="cshare">Code share</label>
                                    <input class="form-control" id="cshare" type="text" name="cshare">

                                    <label class="form-control" for="stops">Stops</label>
                                    <input class="form-control" id="stops" type="number" name="stops" step="1">

                                    <label class="form-control" for="international">International(1 for yes)</label>
                                    <input class="form-control" id="international" name="international" type="text">

                                <input onclick="ajax12()" type="submit" class='btn btn-info' value="Create Route">
                            </form>
                        </div>
                        <div class="modal-footer">
                          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div>                  
                </div>                
            </div>
<script>
    $('.datepicker').datepicker({
        startDate: '-3d'
    })
    
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });
</script>
<jsp:include page="footer.jsp"/>
