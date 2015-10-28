<%-- 
    Document   : customer
    Created on : 11-May-2015, 16:53:58
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
                <li><a class="navbar-brand" href="#" onclick="cususecase(0)"><span class="glyphicon glyphicon-home"> HOME</span></a> </li>
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

        <!-- Sidebar -->
        <div id="sidebar-wrapper">
            <ul class="sidebar-nav ">
                <br>
                <li  data-toggle="collapse" data-target="#booking" class="collapsed active">
                  <a href="#">Booking<span class="glyphicon glyphicon-menu-right"></span></a>
                </li>
                <ul class="collapse" id="booking">
                    <li id="m2">
                        <a href="#" onclick="cususecase(2)">Create booking</a>
                    </li>                    
                    <li id="m5">
                        <a href="#" onclick="cususecase(5)">Cancel flight booking</a>
                    </li>
                    <li id="m1">
                        <a href="#" onclick="cususecase(1)">Change seat</a>
                    </li>                
                </ul>
                
                <li  data-toggle="collapse" data-target="#flight" class="collapsed active">
                  <a href="#">Flight<span class="glyphicon glyphicon-menu-right"></span></a>
                </li>
                <ul class="collapse" id="flight">
                    <li id="m3">
                        <a href="#" onclick="cususecase(3)">Pay for flight</a>
                    </li>
                </ul>
                
                <li  data-toggle="collapse" data-target="#details" class="collapsed active">
                  <a href="#">Details<span class="glyphicon glyphicon-menu-right"></span></a>
                </li>
                <ul class="collapse" id="details">
                    <li id="m6">
                        <a href="#" onclick="cususecase(6)">update details<span class="glyphicon glyphicon-user"></span></a>
                    </li>
                    <li id="m7">
                        <a href="#" onclick="cususecase(7)">update creditcard info<span class="glyphicon glyphicon-credit-card"></span></a>
                    </li>
                </ul>  
            </ul>
        </div>
        <!-- /#sidebar-wrapper -->

        <!-- Page Content -->
        <div id="page-content-wrapper" id="home">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="page-header">
                           <h1>welcome to our airline</h1>
                        </div>                                           
                    </div>
                </div>
            </div>
        </div>
        <!-- /#page-content-wrapper -->

        <div class="col-xs-12 col4">
            <div id="sec0" >
                <div class="page-header">
                            <h1><%
                            HttpSession hs=request.getSession(true);  
                            String user = (String)hs.getAttribute("username");                         
            
                            out.println("Hello customer " + user);
                            %></h1>
                        </div> 
                    
                    <img src="images/customer.jpg" class="img-responsive" >
                    <div class="col-md-12 col-xs-5 col7">
                        <label for="service">Checking what on service today</label>
                        <select class="form-control" onchange="checkservicetoday()" id="service">
                            <option value="All">All</option>
                            <option value="Intenational">Intenational</option>                            
                        </select>
                        <ul class="list-group" id="cheinven"></ul>
                    </div>
            </div>
            <div id="sec1" style="display: none;">
                <jsp:include page="listbookingCS.jsp"/>
            </div>
            <div id="sec2"  style="display: none;">
               <label for="startdate">start date</label>
               <input class="form-control datepicker" name="startdate" id="startdate" data-date-format="mm/dd/yyyy" required>
                
                <label for="enddate">end date</label>
                <input class="form-control datepicker" name="enddate" id="enddate" data-date-format="mm/dd/yyyy" required>
                
                <button onclick="search()" class="btn btn-info">search for schedule</button>
                
                <jsp:include page="listschduleforbooking.jsp"/>
            </div>
            <div id="sec3" style="display: none;">               
               <jsp:include page="listbookingP.jsp"/>
            </div>           
            <div id="sec5" style="display: none;">
                <jsp:include page="listbookingD.jsp"/>
            </div>
            <div id="sec6" style="display: none;">     
                <jsp:include page="customerdetail.jsp"/>              
            </div>
            
            <div id="sec7" style="display: none;">
                <jsp:include page="creditcard.jsp"/>    
            </div>
        </section>
        </div>
        </div>
            
            <div class="modal fade" id="confirmbooking" role="dialog" >
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            Confirm booking?
                        </div>
                        <div class="modal-body">
                            <script type="text/javascript" src="js/ajax17.js"></script>
                            <table class="table table-striped" id="choosingseat">
                                    
                            </table>
                            <form id="confirmticket">                                
                                <input class="form-control" id="schid" name="schid" type="hidden">
                                Seat id:<input name="seatid" id="seatid" class="form-control" type="text" readonly>

                                <input onclick="ajax17()" type="submit" class="btn btn-warning btn-lg btn-primary"  value="confirm">
                            </form>
                        </div>
                        <div class="modal-footer">       
                          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div>                  
                </div>                
            </div>
            
            <div class="modal fade" id="confirmdeltick" role="dialog" >
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            Confirm delete booking?
                        </div>
                        <div class="modal-body">
                            <script type="text/javascript" src="js/ajax18.js"></script>
                            
                            <form class="form-control" id="confirmDticket">                                
                                <input class="form-control" id="dtkid" name="dtkid" type="hidden">                              

                                <input onclick="ajax18()" type="submit" class="form-control btn btn-warning btn-lg btn-primary"  value="confirm">
                            </form>
                        </div>
                        <div class="modal-footer">       
                          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div>                  
                </div>                
            </div>
            
            <div class="modal fade" id="confirmseatchange" role="dialog" >
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            Confirm change seat?
                        </div>
                        <div class="modal-body">
                            <table class="table table-striped" id="changetoempty">
                                
                            </table>
                            <script type="text/javascript" src="js/ajax19.js"></script>
                            <form class="form-control" id="chosenseat">
                                <label for="ticketid">ticket ID</label>
                                <input id="ticketid" name="ticketid" type="text" readonly>
                                
                                <label for="nseatid">new seat ID</label>
                                <input id="nseatid" name="nseatid" type="text" readonly>
                                
                                <input onclick="ajax19()" type="submit" value="confirm change" class="btn-info btn">
                            </form>
                        </div>
                        <div class="modal-footer">       
                          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div>                  
                </div>                
            </div>
            
            <div class="modal fade" id="confirmpaying" role="dialog" >
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            Are u going to pay?
                        </div>
                        <div class="modal-body">
                            <script type="text/javascript" src="js/ajax20.js"></script>
                            
                            <form class="form-control" id="payticket">                                
                                <input class="form-control" id="paytkid" name="paytkid" type="hidden">                              

                                <label for="confirmcre">Confirm Credit Card</label>
                                <input class="form-control" id="confirmcre" name="confirmcre" type="text">
                                <input onclick="ajax20()" type="submit" class="form-control btn btn-warning btn-lg btn-primary"  value="confirm">
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
    function checkservicetoday(){
        var type = document.getElementById("service").value
        var onetime = true;
    if(onetime == true){
        $.get('checkinventory', {
            type:type
           }, function(response) {
                $('#cheinven').html(response);
        }).fail(function(){
            alert( "Getting failed." );
        });
        onetime = false;
    }
    }
    
    function buyticket(btkid){
        document.getElementById("paytkid").value = btkid;
    }
    
    function switchseatid(nis){
        document.getElementById("nseatid").value = nis;
    }
    
    $('.datepicker').datepicker({
        startDate: '-3d'
    })
    
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });
</script>

<jsp:include page="footer.jsp"/>
