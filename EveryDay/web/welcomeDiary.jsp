<%-- 
    Document   : StartDiary
    Created on : 17/10/2015, 5:45:36 PM
    Author     : victor
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="header.jsp"/>

<div class="container">
    <h1>Hello <c:out value="${requestScope.user}"/>,how is your day today<a href="logout.jsp">Logout</a></h1>
    <div class="row">
        <div class="col-sm-4" id="white">
            <ul class="list-group" id="ds">
                <li class="list-group-item-heading"><b>pick a diary</b></li>
                    <c:if test="${requestScope.diaries != null}">
                        <c:forEach var="diary" items="${requestScope.diaries}">
                        <li class="list-group-item">
                            <button onclick="getdiary('<c:out value='${diary.key}'/>')" class="btn-info">
                                <c:out value="${diary.key}"/>
                                <span class="badge" id="<c:out value='${diary.key}'/>"><c:out value="${diary.value}"/></span>
                            </button>
                        </li>
                    </c:forEach>
                </c:if>
            </ul>
        </div>
        <div class='col-sm-8' id="diarycontent">                  
                  
        </div>       
    </div>
    <div class="row">
        <fieldset class="form-control">
            <legend>create new diary</legend>

            <form class="form-control" id="newdiaryform">
                <div class="col-sm-8">
                    <textarea name="newcontent" id="newcontent" class="form-control" rows="8" cols="10" placeholder="write your diary here"></textarea>
                    <input name="when" id="when" type='text' class="form-control datepicker" />
                    
                </div>
                <div class="col-sm-4">
                    <div class = "targets" id="targets"></div>
                    <button type="submit" onsubmit="checkfeild()" class="btn-success btn-lg">Create</button>
                </div>
            </form>
            <div class="col-sm-4">
                <button class="btn-block" onclick="cleanimg()">clean</button>
            </div>
            
        </fieldset>

    </div>
</div>

<jsp:include page="footer.jsp"/>
