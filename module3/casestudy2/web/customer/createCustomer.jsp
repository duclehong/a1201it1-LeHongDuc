<%--
  Created by IntelliJ IDEA.
  User: duckbui
  Date: 9/3/2021
  Time: 9:05 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Create</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body style="background-color: #8fc4b7;">
<div align="center pt-4">
    <div class="container py-5 ">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-lg-8 col-xl-6">
                <div class="card rounded-3">
                    <div class="card-body p-4 p-md-5">
        <a href="users?action=customer">List All Users</a>

    <form method="post">
        <div class="form-group">
            <label for="typeCustomer">Customer Type</label>
            <select id="typeCustomer" class="form-control" name="type">
                <option selected value="1">Diamond</option>
                <option value="2">Gold</option>
                <option value="3">Member</option>
                <option value="4">Silver</option>
            </select>
        </div>
        <div class="form-group">
            <label for="name">Name</label>
            <input type="text" class="form-control" id="name" placeholder="Email" name="name">
        </div>
        <div class="form-group">
            <label for="birthdaytime">Birthday</label>
            <input type="date" class="form-control" id="birthdaytime" name="birthday" >
        </div>
        <div class="form-group">
            <div class="form-row">
                <input type="radio" id="html" name="gender" value="Nam" class="mt-2">
                  <label for="html">Nam</label><br>
                  <input type="radio" id="css" name="gender" value="Nu"  class="mt-2">
                  <label for="css">Nữ</label><br>
            </div>
        </div>
        <div class="form-group">
            <label for="idcard">ID Card</label>
            <input type="text" class="form-control" id="idcard" placeholder="XXXX-XXXX-XXXX" name="idCard">
        </div>
        <div class="form-group">
            <label for="phone">Phone</label>
            <input type="text" class="form-control" id="phone" placeholder="XXXXXXXXXXX" name="phone">
        </div>
        <div class="form-group">
            <label for="email">Email </label>
            <input type="email" class="form-control" id="email" placeholder="duck@gmail.com" name="email">
        </div>
        <div class="form-group">
            <label for="address">Address</label>
            <input type="text" class="form-control" id="address" placeholder="Nghe An" name="address">
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-primary">ADD</button>
        </div>
    </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
<script>
    $(function(){
        $("#to").datepicker();
        $("#from").datepicker().bind("change",function(){
            var minValue = $(this).val();
            minValue = $.datepicker.parseDate("mm/dd/yy", minValue);
            minValue.setDate(minValue.getDate()+1);
            $("#to").datepicker( "option", "minDate", minValue );
        })
    });
</script>
</html>
