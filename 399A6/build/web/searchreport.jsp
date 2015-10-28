<%-- 
    Document   : searchreport
    Created on : 19-Apr-2015, 22:07:51
    Author     : Victor
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="header.jsp"/>
<h1><c:out value="${requestScope.basic.title}"/></h1>
<h2><c:out value="${requestScope.basic.mykey}"/></h2>
<h2>On at <c:out value="${requestScope.basic.company}"/> from <c:out value="${requestScope.basic.startseason}"/> to <c:out value="${requestScope.basic.endseason}"/></h2>
<p><c:out value="${requestScope.basic.shortdescription}"/></p>
<h2>Scheduled performances</h2>

<table border="3">
    <c:forEach var="times" items="${requestScope.time}">
        <tr>
            <td><c:out value="${times.showtime}"/></td>
            <fmt:formatDate value="${times.showdate}" var="formattedDate" pattern="yyyy-MM-dd"/>
            <td><c:out value="${formattedDate}"/></td>
        </tr>
    </c:forEach>
</table>

<table border="3">
    <c:forEach var="info" items="${requestScope.sup}">
        <tr>
            <td><img src="<c:out value="${info.picy}"/>"></td>
            <td><c:out value="${info.details}"/></td>
        </tr>
    </c:forEach>
</table>
<br>
<br>
<jsp:include page="footer.jsp"/>
