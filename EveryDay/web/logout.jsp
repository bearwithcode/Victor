<%-- 
    Document   : logout
    Created on : 23/10/2015, 1:50:24 PM
    Author     : victor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    request.getSession().invalidate();
    response.sendRedirect("index.jsp");
%>
