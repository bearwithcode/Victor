<%-- 
    Document   : CuPanel
    Created on : 22-May-2015, 17:38:10
    Author     : Victor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<hr><br>
<div id="page1" class="col-md-12 col-xs-8">
<form id="customerprofile" class="form-group">   
        <label for="thisuser" class="form-group">username(must same as oringinal one) </label>
        <input id="thisuser" name="thisuser" type="text" class="form-group" required>
    
            <label for="title" class="form-group">Title</label>
        <select id="title" name="title2" class="form-group" required>
            <option value="Mr">Mr</option>
            <option value="Ms">Ms</option>
            <option value="Dr">Dr</option>
            <option value="Rev">Rev</option>
            <option value="Honorable">Honorable</option>
            <option value="Mrs">Mrs</option>
        </select>
        <label for="lname" class="form-group">First name</label>
        <input id="lname" name="lname2" class="form-group" type="text" required>
        <label for="fname" class="form-group">Last name</label>
        <input id="fname" name="fname2" class="form-group" type="text" required><br>
        <div class="col-md-4 col-xs-2">
            <label class="radio control-label">Gender</label>
            <div class="radio form-group inline">
                <label><input type="radio" name="gender2[]" required>Male</label>
            </div>
            <div class="radio form-group inline">
                <label><input type="radio" name="gender2[]" required>Famale</label>
            </div>
        </div>
        
        <div class="col-xs-4 col-md-8">
            <fieldset class="form-group">
                <legend>DOB</legend>
                <div class="col-md-2 col-xs-1">
                    <label for="year" class="form-group"><input name="year2" id="year" class="form-group" type="text" required>Year</label>
                </div>
                
                 <div class="col-md-2 col-xs-1">
                     <label for="month" class="form-group"><input name="month2" id="month" class="form-group" type="text" required> Month</label>
                </div>
                
                 <div class="col-md-2 col-xs-1">
                     <label for="day" class="form-group"><input id="day" name="day2" class="form-group" type="text" required>Day</label>
                </div>

            </fieldset>
        </div>
               
        
        <label for="ph">phone
        <div id="ph" class="col-md-6 col-xs-3">
            <div class="col-md-1 col-xs-1"> 
                <input class="form-group" name="dis2" type="text" required >
            </div>
            <div class="col-md-5 col-xs-2">
                <input class="form-group" name="phnum2"  type="text" required>
            </div>           
        </div></label>
        
        
            <div class="col-md-6 col-xs-3">
                <label for="email">Email<input id="email" name="email2" class="form-group"  type="email" required></label>
            </div>
        
        
        <div class="col-md-12 col-xs-8 ">            
            <div class="col-md-2 col-xs-1">
                <label for="sadd" class="form-group"><input name="sadd2" id="sadd" class="form-group" type="text" required>Street Address</label>
        </div>
                   
        <div class="col-md-2 col-xs-1">
            <label for="state" class="form-group"><input name="state2" id="state" class="form-group" type="text" required>State</label>
        </div>
        
        <div class="col-md-2 col-xs-1">            
            <label for="city" class="form-group"><input name="city2" id="city" class="form-group" type="text" required>City</label>
        </div>
        
        <div class="col-md-2 col-xs-1">          
            <label for="cou" class="form-group"><input name="cou2" id="cou" class="form-group" type="text" required><br>Country</label>
        </div>
        </div>
        
        <div class="col-md-12 col-xs-10">            
          <label class="radio control-label">Passport holder</label>
          <div class="radio form-group inline">
                <label><input type="radio" name="passport2[]" required>No</label>
          </div>
          <div class="radio form-group inline">
                <label><input type="radio" name="passport2[]" required>Yes</label>
          </div>                 
        </div>
        
        <div class="col-md-12 col-xs-10">
            <label for="flsta" class="form-group">Flight status<input name="flsta" id="flsta" class="form-group" type="text" ></label>
            <label for="travel" class="form-group">Travel agent<input name="travel" id="travel" class="form-group" type="text" required></label>
        </div>
              
        <div class="col-md-12 col-xs-10">
            <input onclick="ajax6()" type="submit" class="form-group" value="update for customer">
        </div>           
    </form>
 </div>
<script type="text/javascript" src="js/ajax6.js"></script>
