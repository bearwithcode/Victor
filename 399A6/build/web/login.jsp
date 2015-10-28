<%-- 
    Document   : login
    Created on : 19-Apr-2015, 12:53:41
    Author     : Victor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="header.jsp"/>
<form method="post" action="j_security_check" >
            <label for="logintable"><b>Enter your name and password</b></label>
            <table id="logintable" border = "3" >
                <tr>
                    <th>Name:</th>
                    <td><input type="text" name="j_username"></td>
                </tr>
                <tr>
                    <th>Password:</th>
                    <td><input type="password" name="j_password"></td>
                </tr>
                <tr>
                    <td align="center" colspan="2">
                        <input type="submit"  value="OK">
                    </td>
                </tr>
            </table>
        </form>
<jsp:include page="footer.jsp"/>
