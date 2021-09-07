<%--
  Created by IntelliJ IDEA.
  User: duckbui
  Date: 9/3/2021
  Time: 9:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
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
                        <a href="customer">List All Users</a>

                        <form method="post">
                            <div class="form-group">
                                <label for="name">Name</label>
                                <input type="text" class="form-control" id="name" placeholder="Name" name="name">
                            </div>
                            <div class="form-group">
                                <label for="area">Area</label>
                                <input type="text" class="form-control" id="area" placeholder="Area" name="area">
                            </div>
                            <div class="form-group">
                                <label for="cost">Cost</label>
                                <input type="text" class="form-control" id="cost" name="cost" >
                            </div>

                            <div class="form-group">
                                <label for="maxPeople">Max people</label>
                                <input type="text" class="form-control" id="maxPeople" name="maxPeople" >
                            </div>
                            <div class="form-group">
                            <select id="rentType" class="form-control" name="rentType">
                                <option selected value="1">Nam</option>
                                <option value="2">Thang</option>
                                <option value="3">Ngay</option>
                                <option value="4">Gio</option>
                            </select>
                            </div>
                            <div class="form-group">
                            <select id="serviceType" class="form-control" name="serviceType">
                                <option selected value="1">Villa</option>
                                <option value="2">House</option>
                                <option value="3">Room</option>
                            </select>
                            </div>
                            <div class="form-group">
                                <label for="standardRoom">Standard Room</label>
                                <input type="text" class="form-control" id="standardRoom" name="standardRoom" >
                            </div>
                            <div class="form-group">
                                <label for="des">Des  Other Convenient</label>
                                <input type="text" class="form-control" id="des" name="des" >
                            </div>
                            <div class="form-group">
                                <label for="poolArea">Pool Area</label>
                                <input type="text" class="form-control" id="poolArea" name="poolArea" >
                            </div>
                            <div class="form-group">
                                <label for="numFloor">Number Of Floor</label>
                                <input type="text" class="form-control" id="numFloor" name="numFloor" >
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
