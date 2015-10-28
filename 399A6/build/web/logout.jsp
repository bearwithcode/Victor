<%-- 
    Document   : logout
    Created on : 19-Apr-2015, 13:30:20
    Author     : Victor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% request.logout();%>
<jsp:forward page="welcome.jsp"/>
    

