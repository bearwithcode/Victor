<%-- 
    Document   : creditcard
    Created on : 17-May-2015, 15:20:25
    Author     : Victor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<form class="form-group" id="creform">
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
                    <label for="ccn">Credit card No.<input onblur="checkcard()" id="ccn" name="ccn" class="form-group"  type="text" required></label>
                </div>
            </fieldset>
        </div>
    
    <div id="info">               
        </div> 
    <input type="submit" class="form-group" value="update credite card info"> 
</form>
<script type="text/javascript" src="js/ajax2.js"></script>

        
