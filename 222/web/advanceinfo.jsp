<%-- 
    Document   : advanceinfo
    Created on : 17-May-2015, 19:39:40
    Author     : Victor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="header.jsp"/>


<div class="page-header">
    <h1>Hello <b><%
    HttpSession hs=request.getSession(true);  
    String user = (String)hs.getAttribute("username");
    out.println(user);
%></b> Please finish your information details to complete registration</h1>

        <h1>Personal details</h1>
    </div>
    
    <form class="form-group" method="post" action="CreateperRecord" onSubmit="return checkcard()">
        <div id="page1" class="col-md-12 col-xs-8">
            <label for="title" class="form-group">Title</label>
        <select id="title" name="title" class="form-group">
            <option value="Mr">Mr</option>
            <option value="Ms">Ms</option>
            <option value="Dr">Dr</option>
            <option value="Rev">Rev</option>
            <option value="Honorable">Honorable</option>
            <option value="Mrs">Mrs</option>
        </select>
        <label for="lname" class="form-group">First name</label>
        <input id="lname" name="lname" class="form-group" type="text" required>
        <label for="fname" class="form-group">Last name</label>
        <input id="fname" name="fname" class="form-group" type="text" required><br>
        <div class="col-md-4 col-xs-2">
            <label class="radio control-label">Gender</label>
            <div class="radio form-group inline">
                <label><input type="radio" name="gender[]" required>Male</label>
            </div>
            <div class="radio form-group inline">
                <label><input type="radio" name="gender[]" required>Famale</label>
            </div>
        </div>
        
        <div class="col-xs-4 col-md-8">
            <fieldset class="form-group">
                <legend>DOB</legend>
                <div class="col-md-2 col-xs-1">
                    <label for="year" class="form-group"><input name="year" id="year" class="form-group" type="text" required>Year</label>
                </div>
                
                 <div class="col-md-2 col-xs-1">
                     <label for="month" class="form-group"><input name="month" id="month" class="form-group" type="text" required> Month</label>
                </div>
                
                 <div class="col-md-2 col-xs-1">
                     <label for="day" class="form-group"><input id="day" name="day" class="form-group" type="text" required>Day</label>
                </div>

            </fieldset>
        </div>
        
        <label for="ph">phone
        <div id="ph" class="col-md-6 col-xs-3">
            <div class="col-md-1 col-xs-1"> 
                <input class="form-group" name="dis" type="text" required>
            </div>
            <div class="col-md-5 col-xs-2">
                <input class="form-group" name="phnum"  type="text" required>
            </div>           
        </div></label>
        
        
            <div class="col-md-6 col-xs-3">
                <label for="email">Email<input id="email" name="email" class="form-group"  type="email" required></label>
            </div>
        
        
        <div class="col-md-12 col-xs-8 ">            
            <div class="col-md-2 col-xs-1">
                <label for="sadd" class="form-group"><input name="sadd" id="sadd" class="form-group" type="text" required>Street Address</label>
        </div>
                   
        <div class="col-md-2 col-xs-1">
            <label for="state" class="form-group"><input name="state" id="state" class="form-group" type="text" >State</label>
        </div>
        
        <div class="col-md-2 col-xs-1">            
            <label for="city" class="form-group"><input name="city" id="city" class="form-group" type="text" required>City</label>
        </div>
        
        <div class="col-md-2 col-xs-1">          
            <label for="cou" class="form-group"><input name="cou" id="cou" class="form-group" type="text" required><br>Country</label>
        </div>
        </div>
        
        <div class="col-md-12 col-xs-10">            
          <label class="radio control-label">Passport holder</label>
          <div class="radio form-group inline">
                <label><input type="radio" name="passport[]" required>No</label>
          </div>
          <div class="radio form-group inline">
                <label><input type="radio" name="passport[]" required>Yes</label>
          </div>                 
        </div>
        </div>
        
        <div id="page2" class="col-md-12 col-xs-8">
            <fieldset class="form-group">
                <legend>Credit Card Information</legend>
                <div class="col-md-4 col-xs-2">
                    <label for="cretype">Credite card Type
                    <select id="cretype" name="cretype" class="form-group">
                        <option value="jcb">jcb</option>
                        <option value="americanexpress">americanexpress</option>
                        <option value="bankcard">bankcard</option>
                        <option value="maestro">maestro</option>
                        <option value="visa-electron">visa-electron</option>
                        <option value="diners-club-carte-blanche">diners-club-carte-blanche</option>
                        <option value="switch">switch</option>
                        <option value="solo">solo</option>laser
                        <option value="china-unionpay">china-unionpay</option>
                        <option value="laser">laser</option>
                    </select></label>
                </div>
                <div class="col-md-5 col-xs-2">
                    <label for="ccn">Credit card No.<input id="ccn" name="ccn" class="form-group"  type="text" required></label>
                </div>
            </fieldset>
        </div>
        
        <div id="info">               
        </div> 
        
        <input onsubmit="return checkcard()" type="submit" class="form-group" value="Create personal details">     
    </form>

<jsp:include page="footer.jsp"/>