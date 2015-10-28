<%-- 
    Document   : Logout
    Created on : 17-May-2015, 16:08:33
    Author     : Victor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    request.getSession().invalidate();
    response.sendRedirect("index.jsp");
%>
