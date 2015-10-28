<%-- 
    Document   : customerdetail
    Created on : 12-May-2015, 13:44:44
    Author     : Victor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    <div class="page-header">
        <h1>Personal details</h1>
    </div>
    
<form id="customerform" class="form-group">
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
        <input type="submit" class="form-group" value="update personal">     
    </form>

<script type="text/javascript" src="js/ajax1.js"></script>



