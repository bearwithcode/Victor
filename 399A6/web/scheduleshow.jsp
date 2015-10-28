<%-- 
    Document   : scheduleshow
    Created on : 19-Apr-2015, 16:38:52
    Author     : Victor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="header.jsp"/>
<form method='post' action='scheduleshow'>
    <h1>Create a new show record</h1>
        <fieldset>
            <legend>Add a show</legend>
                <label for='showid'>Show identifier</label>
                <br><input type='text' id='showid' name='showid'><br>
                <label for='title'>Title</label>
                <br><input type='text' id='title' name='title'><br>
                <label for='venue'>Venue</label>
                <br>
                <select id='ve' name='ve'>
                    <option value='Opera'>Opera</option>
                    <option value='Concert'>Concert</option>
                    <option value='Playhouse'>Playhouse</option>
                    <option value='Studio'>Studio</option>
                </select><br>
                <label for='st'>Show type</label>
                    <br>
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
                <label for='sd'>From date</label>
                    <br><input type='date' id='sd' name = 'sd'><br>
                    <label for='ed'>To date</label>
                    <br><input type='date' id='ed' name = 'ed'><br>
                <label for='com'>Company</label>
                <input type='text' id='com' name='com'><br>
                <label for='des'>Description</label>
                <br><textarea id='des' name='des' rows='4' cols='40'></textarea><br>
                <label for='per'>Performances</label>
                <br><textarea id='Per' name='per' rows='4' cols='40' readonly = 'readonly'></textarea><br>
                <input type='submit' value='Add event'><br>
        </fieldset><br>
</form><br>

<fieldset>
    <legend>Enter performance details</legend>
        <label for='st'>Show time</label>
        <br>
        <select id='stime' name='st'>
            <option value='matinee'>matinee</option>
            <option value='evening'>evening</option>
        </select><br>
        <label for=date>Date</label>
        <br><input type='date' id='d' name='date'><br>
        <button onclick='doaddp()'>Add performance</button><br>
</fieldset>
<jsp:include page="footer.jsp"/>
