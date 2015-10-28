<%-- 
    Document   : searchshow
    Created on : 19-Apr-2015, 13:53:46
    Author     : Victor
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="header.jsp"/>

<c:choose>
    <c:when test="${requestScope.listshow == null}">
        <h1>what is at entertainment center</h1>
        <form method='post' action='searchshow'>
    <fieldset>
        <legend>Search for shows</legend>
        <label for='st'>Show type</label>
        <select id='st' name = 'st'>
            <option value='Drama'>Drama</option>
            <option value='Film'>Film</option>
            <option value='Opera'>Opera</option>
            <option value='Jazz'>Jazz</option>
            <option value='World Music'>World Music</option>
            <option value='Ballet'>Ballet</option>
            <option value='Recital'>Recital</option>
            <option value='Concert'>Concert</option>
            <option value='Choral'>Choral</option>
            <option value='Contemporary Dance'>Contemporary Dance</option>
            <option value='Comedy'>Comedy</option>
            <option value='Children'>Children</option>
        </select><br>
        
        <label for='ve'>Venue</label>
        <select id='ve' name='ve'>
            <option value='Opera'>Opera</option>
            <option value='Concert'>Concert</option>
            <option value='Playhouse'>Playhouse</option>
            <option value='Studio'>Studio</option>
        </select><br>
        
        <label for='sd'>Start date</label>
        <input type='date' id='sd' name = 'sd'><br>
        <label for='ed'>End date</label>
        <input type='date' id='ed' name = 'ed'><br>
        <input type='submit' value='Search'>
    </fieldset>
    </form>
    </c:when>
    <c:when test="${requestScope.listshow != null}">
        <h1>Shows on at entertainment center</h1>
        <c:if test="${requestScope.len == 0}">
            <h2>nothing find!</h2>
        </c:if>
        <c:if test="${requestScope.len != 0}">
            <ul>
                <c:forEach var="shows" items="${requestScope.listshow}">
                    <li>
                        <a href="searchreport?title=<c:out value="${shows.title}"/>"><c:out value="${shows.title}"/></a>
                    </li>
                </c:forEach>
            </ul>
        </c:if>
        
    </c:when>
</c:choose>


<jsp:include page="footer.jsp"/>
