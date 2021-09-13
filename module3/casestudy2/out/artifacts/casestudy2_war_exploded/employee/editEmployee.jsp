<%--
  Created by IntelliJ IDEA.
  User: duckbui
  Date: 9/7/2021
  Time: 11:40 PM
  To change this template use File | Settings | File Templates.
--%>
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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

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
                                <label for="name">Name</label>
                                <input type="text" class="form-control" id="name" name="name"
                                       value="<c:out value='${employee.name}' />">
                            </div>
                            <div class="form-group">
                                <label for="birthdaytime">Birthday</label>
                                <input type="date" class="form-control" id="birthdaytime" name="birthday"
                                       value="<c:out value='${employee.birthday}' />">
                            </div>
                            <div class="form-group">
                                <label for="idcard">ID Card</label>
                                <input type="text" class="form-control" id="idcard" name="idCard"
                                       value="<c:out value='${employee.idCard}' />">
                            </div>

                            <div class="form-group">
                                <label for="salary">Salary</label>
                                <input type="text" class="form-control" id="salary" name="salary"
                                       value="<c:out value='${employee.salary}' />">
                            </div>
                            <div class="form-group">
                                <label for="phone">Phone</label>
                                <input type="text" class="form-control" id="phone" name="phone"
                                       value="<c:out value='${employee.phone}' />">
                            </div>
                            <div class="form-group">
                                <label for="email">Email </label>
                                <input type="email" class="form-control" id="email" name="email"
                                       value="<c:out value='${employee.email}' />">
                            </div>
                            <div class="form-group">
                                <label for="address">Address</label>
                                <input type="text" class="form-control" id="address" name="address"
                                       value="<c:out value='${employee.address}' />">
                            </div>
                            <div class="form-group">
                                <label for="position">Position</label>
                                <select id="position" class="form-control" name="position" >
                                    <option selected value="<c:out value='${employee.position}' />">
                                        <c:choose>
                                            <c:when test = "${employee.position == 1}">
                                                Le Tan
                                            </c:when>

                                            <c:when test = "${employee.position == 2}">
                                                Phuc Vu
                                            </c:when>

                                            <c:when test = "${employee.position == 3}">
                                                Chuyen Vien
                                            </c:when>

                                            <c:when test = "${employee.position == 4}">
                                                Giam Sat
                                            </c:when>
                                            <c:when test = "${employee.position == 5}">
                                                Quan Ly
                                            </c:when>
                                            <c:when test = "${employee.position == 6}">
                                                Giam Doc
                                            </c:when>
                                        </c:choose>
                                    </option>
                                    <option value="1">Le Tan</option>
                                    <option value="2">Phuc Vu</option>
                                    <option value="3">Chuyen Vien</option>
                                    <option value="4">Giam Sat</option>
                                    <option value="5">Quan Ly</option>
                                    <option value="6">Giam Doc</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="education">Education</label>
                                <select id="education" class="form-control" name="education" >
                                    <option selected value="<c:out value='${employee.education}' />">
                                        <c:choose>
                                            <c:when test = "${employee.education == 1}">
                                                Trung Cap
                                            </c:when>

                                            <c:when test = "${employee.education == 2}">
                                                Cao Dang
                                            </c:when>

                                            <c:when test = "${employee.education == 3}">
                                                Dai hoc
                                            </c:when>

                                            <c:when test = "${employee.education == 4}">
                                                Sau Dai Hoc
                                            </c:when>
                                        </c:choose>
                                    </option>
                                    <option value="1"> Trung Cap</option>
                                    <option value="2">Cao Dang</option>
                                    <option value="3">Dai hoc</option>
                                    <option value="4">Sau Dai Hoc</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="division">Division</label>
                                <select id="division" class="form-control" name="division" >
                                    <option selected value="<c:out value='${employee.division}' />">
                                        <c:choose>
                                            <c:when test = "${employee.division == 1}">
                                                Sale-Marketing
                                            </c:when>

                                            <c:when test = "${employee.division == 2}">
                                                Hanh Chinh
                                            </c:when>

                                            <c:when test = "${employee.division == 3}">
                                                Phuc Vu
                                            </c:when>

                                            <c:when test = "${employee.division == 4}">
                                                Quan Ly
                                            </c:when>
                                        </c:choose>
                                    </option>
                                    <option value="1"> Sale-Marketing</option>
                                    <option value="2">Hanh Chinh</option>
                                    <option value="3">Phuc Vu</option>
                                    <option value="4">Quan Ly</option>
                                </select>
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
    $(function () {
        $("#to").datepicker();
        $("#from").datepicker().bind("change", function () {
            var minValue = $(this).val();
            minValue = $.datepicker.parseDate("mm/dd/yy", minValue);
            minValue.setDate(minValue.getDate() + 1);
            $("#to").datepicker("option", "minDate", minValue);
        })
    });
</script>
</html>