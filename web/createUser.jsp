<%-- 
    Document   : createUser
    Created on : Jul 11, 2021, 1:27:02 AM
    Author     : Quoc Dat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="datnq.dto.UserError"%>
<!DOCTYPE html>
<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<title>Register Page</title>
<style>
    h2{
        margin-bottom: 50px;
    }
</style>
<form class="form-horizontal" action="MainController">
    <fieldset>
        <h2>Register form</h2>
        <div class="control-group">
            <!-- Username -->
            <label class="control-label"  for="username">Email</label>
            <div class="controls">
                <input type="email" id="username" name="userID" placeholder="dat@gmail.com" class="input-xlarge">
                ${requestScope.USER_ERROR.getUserIDError()}<br>
            </div>
        </div>

        <div class="control-group">
            <!--Name -->
            <label class="control-label" for="name1">Name</label>
            <div class="controls">
                <input type="text" id="name1" name="name" placeholder="Nguyen Van A" class="input-xlarge">
                ${requestScope.USER_ERROR.getNameError()}<br>
            </div>
        </div>

        <div class="control-group">
            <!-- Password-->
            <label class="control-label" for="password">Password</label>
            <div class="controls">
                <input type="password" id="password" name="password" placeholder="" class="input-xlarge">
            
            </div>
        </div>

        <div class="control-group">
            <!-- Re-Password -->
            <label class="control-label"  for="password_confirm">Password (Confirm)</label>
            <div class="controls">
                <input type="password" id="password_confirm" name="repassword"  class="input-xlarge">
                  ${requestScope.USER_ERROR.getConfirmPasswordError()}<br> 
            </div>
        </div>

        <div class="control-group">
            <!-- Phone -->
            <label class="control-label"  for="phone1">Your phone number </label>
            <div class="controls">
                <input type="number" id="phone1" name="phone"  class="input-xlarge">
                  ${requestScope.USER_ERROR.getPhoneError()}<br> 
            </div>
        </div>

        <div class="control-group">
            <!-- Address -->
            <label class="control-label"  for="address1">Your address</label>
            <div class="controls">
                <input type="text" id="address1" name="address"  class="input-xlarge">
                 ${requestScope.USER_ERROR.getAddressError()}<br> 
            </div>
        </div>
        <div class="control-group">
            <!-- Create Date -->
            <label class="control-label" for="DATE">Create Date</label>
            <div class="controls">
                <input type="text" id="DATE" name="createDate"  class="input-xlarge">

            </div>
        </div>
        <div class="control-group">
            <!-- Button -->
            <div class="controls">
                <button type="submit" class="btn btn-success" name="action" value="Register">Register</button>
            </div>
        </div>
    </fieldset>
    <script>
        var today = new Date();
        var dd = String(today.getDate()).padStart(2, '0');
        var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
        var yyyy = today.getFullYear();

        today = yyyy + '-' + mm + '-' + dd;
        document.getElementById('DATE').value = today;
    </script>

</form>
