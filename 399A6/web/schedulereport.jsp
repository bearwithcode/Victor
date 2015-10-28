<%-- 
    Document   : schedulereport
    Created on : 22-Apr-2015, 23:57:11
    Author     : Victor
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="header.jsp"/>
<hr>
<h1>New record added</h1>
<ul>
    <li><a href='scheduleshow'>Schedule another event</a></li>
    <li><a href='addinfo?si=<c:out value="${requestScope.sid}"/>&title=<c:out value="${requestScope.title}"/>'>Add information to show</a></li>
</ul>
<jsp:include page="footer.jsp"/>
