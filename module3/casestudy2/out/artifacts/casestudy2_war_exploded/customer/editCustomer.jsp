<%--
  Created by IntelliJ IDEA.
  User: duckbui
  Date: 9/3/2021
  Time: 9:06 PM
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
                        <a href="users?action=customer">List All Users</a>

                        <form method="post">
                            <div class="form-group">
                                <label for="typeCustomer">Customer Type</label>
                                <select id="typeCustomer" class="form-control" name="type" >
                                    <option selected value="<c:out value='${customer.type}' />">
                                        <c:choose>
                                            <c:when test = "${customer.type == 1}">
                                                Diamond
                                            </c:when>

                                            <c:when test = "${customer.type == 2}">
                                                Gold
                                            </c:when>

                                            <c:when test = "${customer.type == 3}">
                                                Member
                                            </c:when>

                                            <c:when test = "${customer.type == 4}">
                                                Silver
                                            </c:when>
                                        </c:choose>
                                    </option>
                                    <option value="1">Diamond</option>
                                    <option value="2">Gold</option>
                                    <option value="3">Member</option>
                                    <option value="4">Silver</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="name">Name</label>
                                <input type="text" class="form-control" id="name"  name="name" value="<c:out value='${customer.name}' />">
                            </div>
                            <div class="form-group">
                                <label for="birthdaytime">Birthday</label>
                                <input type="date" class="form-control" id="birthdaytime" name="birthday" value="<c:out value='${customer.birthday}' />">
                            </div>
                            <div class="form-group">
                                <c:if test="${customer.gender =='Nam'}">
                                    <div class="form-row">
                                        <input type="radio" id="g1x" name="gender" value="Nam" class="mt-2" checked>
                                          <label for="g1x">Nam</label><br>
                                          <input type="radio" id="g1y" name="gender" value="Nu"  class="mt-2">
                                          <label for="g1x">Nữ</label><br>
                                    </div>
                                </c:if>
                                <c:if test="${customer.gender =='Nu'}">
                                    <div class="form-row">
                                        <input type="radio" id="g2x" name="gender" value="Nam" class="mt-2" >
                                          <label for="g2x">Nam</label><br>
                                          <input type="radio" id="g2y" name="gender" value="Nu"  class="mt-2" checked>
                                          <label for="g2y">Nữ</label><br>
                                    </div>
                                </c:if>
                            </div>
                            <div class="form-group">
                                <label for="idcard">ID Card</label>
                                <input type="text" class="form-control" id="idcard" name="idCard" value="<c:out value='${customer.idCard}' />">
                            </div>
                            <div class="form-group">
                                <label for="phone">Phone</label>
                                <input type="text" class="form-control" id="phone" name="phone" value="<c:out value='${customer.phone}' />">
                            </div>
                            <div class="form-group">
                                <label for="email">Email </label>
                                <input type="email" class="form-control" id="email" name="email" value="<c:out value='${customer.email}' />">
                            </div>
                            <div class="form-group">
                                <label for="address">Address</label>
                                <input type="text" class="form-control" id="address" name="address" value="<c:out value='${customer.address}' />">
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
