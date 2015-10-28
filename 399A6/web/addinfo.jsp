<%-- 
    Document   : addinfo
    Created on : 19-Apr-2015, 15:33:28
    Author     : Victor
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="header.jsp"/>

<c:if test="${not empty param.si && not empty param.title}">
    <c:if test="${param.si != ''&&param.title != ''}">
        <h1>
            Details added to <c:out value="${param.si}"/> : <c:out value="${param.title}"/>
        </h1>
    </c:if>
</c:if>

    <form method='post' action='addinfo'>
        <fieldset>
            <legend>Show</legend>
            <label for='si'>Show identifier</label>
            <input type='text' id='si' name='si'>
        </fieldset>
        
        <fieldset>
            <legend>Supplementary data</legend>
            <table border='3' id='Myshow'>
                <tr><th>Picture</th><th>Comment</th></tr>
            </table>          
                <input type='button' onclick='doAdd()' value='Add data'>
        </fieldset>
        <fieldset>
            <legend>Action</legend>
                <input type='submit' value='Add details'>
        </fieldset>
    </form>
<jsp:include page="footer.jsp"/>
