<%-- 
    Document   : Login
    Created on : 17/10/2015, 5:46:16 PM
    Author     : victor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="header.jsp"/>

        <form class="form-control" method="post" action="j_security_check">
            <label class="form-control" for="logintable"><b>Enter your name and password</b></label>
            <table class="table" id="logintable" border = "3" >
                <tr class="tab-content">
                    <th>Name:</th>
                    <td><input type="text" name="j_username"></td>
                </tr>
                <tr class="tab-content">
                    <th>Password:</th>
                    <td><input type="password" name="j_password"></td>
                </tr>
                <tr class="tab-content">
                    <td align="center" colspan="2">
                        <input type="submit"  value="OK">
                    </td>
                </tr>
            </table>
        </form>
        
<jsp:include page="footer.jsp"/>
    
