<%-- 
    Document   : createrole
    Created on : 19-May-2015, 16:42:08
    Author     : Victor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<form class="form-control" id="creroles">
    <fieldset class="form-control">
        <legend>New Manager</legend>
        <br>
        <label for="muname">Manager name</label>
        <input class="form-control" type="text" name="muname" id="muname"/>
        
        <label for="mupass">Manager password</label>
        <input class="form-control" type="password" name="mupass" id="mupass"/>
        
    <label for="roles">roles</label>
    <select class="form-control" name="roles" id="roles">
        <option class="form-control" value="bookingmanager">booking manager</option>
        <option class="form-control" value="profilemanager">profile manager</option>
        <option class="form-control" value="servicemanager">service manager</option>
        <option class="form-control" value="flightmanager">flight manager</option>
    </select><br>
    
    <input type="submit" onclick="ajax3()" class="form-group" value="assign role for manager"/> 
    </fieldset>
</form>
<script type="text/javascript" src="js/ajax3.js"></script>
