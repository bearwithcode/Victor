<%-- 
    Document   : createbooking
    Created on : 18-May-2015, 21:49:01
    Author     : Victor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<form class="customerop form-horizontal" method="post">                   
                    <label for="dep">department airport:</label>
                    <input class="form-control" type="text" id="dep" name="dep" required readonly>
                    <label for="des">designation airport:</label>
                    <input class="form-control" type="text" id="des" name="des" required readonly>
                    
                    <br>
                    <label><input  class="form-control datepicker">choose date</label>
                    <button class="btn btn-lg btn-primary btn-block " type="submit">find available flight</button>
</form>

<script>
    $('.datepicker').datepicker({
        
    })
</script>