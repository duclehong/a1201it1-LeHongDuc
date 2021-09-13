<%--
  Created by IntelliJ IDEA.
  User: duckbui
  Date: 9/7/2021
  Time: 3:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<%--    <link rel="stylesheet" href="/static/listService.css">--%>
</head>
<body >
<div align="center container w-75 p3">
    <div class="container pt-4 ">
        <div class="row">
            <div class="col-sm-4">
                <form class="form-inline" method="get" action="/employee">
                    <input type="hidden" id="action" name="action" value="find">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="findId">
                    <button type="submit" class="btn btn-outline-primary"> Find By ID</button>
                </form>
            </div>
            <div class="col-sm">
                <a href="${pageContext.request.contextPath}/customer">
                    <button type="button " class="btn btn-outline-info">List All Customer</button>
                </a>
            </div>

            <div class="col-sm">
                <a href="/customer?action=create">
                    <button type="button o" class="btn btn-outline-info">Create Customer</button></a>
            </div>
            <div class="col-sm">
                <a href="/services?action=create">
                    <button type="button " class="btn btn-outline-info">Create Service</button></a>
            </div>
            <div class="col-sm">
                <a href="/customer?action=create">
                    <button type="button " class="btn btn-outline-info">List Employee</button></a>
            </div>
            <div class="col-sm">
                <a href="/employee?action=create">
                    <button type="button " class="btn btn-outline-info">Create Employee</button></a>
            </div>
        </div>
    </div>
<%--    <table class="display" id="example" >--%>
<%--        <thead>--%>
<%--        <tr>--%>
<%--            <th>ID</th>--%>
<%--            <th>Name</th>--%>
<%--            <th>Birthday</th>--%>
<%--            <th>ID Card</th>--%>
<%--            <th>Salary</th>--%>
<%--            <th>Phone Number</th>--%>
<%--            <th>Email</th>--%>
<%--            <th>Address</th>--%>
<%--            <th>Position ID</th>--%>
<%--            <th>Education ID</th>--%>
<%--            <th>Division ID</th>--%>
<%--            <th>Actions</th>--%>
<%--        </tr>--%>
<%--        </thead>--%>
<%--        <c:forEach var="emplpoyee" items="${listEmployee}">--%>
<%--            <tr>--%>
<%--                <td><c:out value="${emplpoyee.id}"/></td>--%>
<%--                <td><c:out value="${emplpoyee.getName()}"/></td>--%>
<%--                <td><c:out value="${emplpoyee.birthday}"/></td>--%>
<%--                <td><c:out value="${emplpoyee.idCard}"/></td>--%>
<%--                <td><c:out value="${emplpoyee.salary}"/></td>--%>
<%--                <td><c:out value="${emplpoyee.phone}"/></td>--%>
<%--                <td><c:out value="${emplpoyee.email}"/></td>--%>
<%--                <td><c:out value="${emplpoyee.address}"/></td>--%>
<%--                <td><c:out value="${emplpoyee.position}"/></td>--%>
<%--                <td><c:out value="${emplpoyee.education}"/></td>--%>
<%--                <td><c:out value="${emplpoyee.division}"/></td>--%>
<%--                <td>--%>
<%--                    <a href="${pageContext.request.contextPath}/employee?action=edit&id=${emplpoyee.id}">--%>
<%--                        <button class="btn btn-outline-primary" >Edit</button>--%>
<%--                    </a>--%>
<%--                    <a href="${pageContext.request.contextPath}/employee?action=delete&id=${emplpoyee.id}">--%>
<%--                        <button type="button btn-outline-dark" class="btn btn-secondary">Delete</button>--%>
<%--                    </a>--%>

<%--                </td>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
<%--    </table>--%>
    <table id="example" class="display" style="width:100%">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Birthday</th>
            <th>ID Card</th>
            <th>Salary</th>
            <th>Phone Number</th>
            <th>Email</th>
            <th>Address</th>
            <th>Position ID</th>
            <th>Education ID</th>
            <th>Division ID</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="emplpoyee" items="${listEmployee}">
            <tr>
                <td><c:out value="${emplpoyee.id}"/></td>
                <td><c:out value="${emplpoyee.getName()}"/></td>
                <td><c:out value="${emplpoyee.birthday}"/></td>
                <td><c:out value="${emplpoyee.idCard}"/></td>
                <td><c:out value="${emplpoyee.salary}"/></td>
                <td><c:out value="${emplpoyee.phone}"/></td>
                <td><c:out value="${emplpoyee.email}"/></td>
                <td><c:out value="${emplpoyee.address}"/></td>
                <td><c:out value="${emplpoyee.position}"/></td>
                <td><c:out value="${emplpoyee.education}"/></td>
                <td><c:out value="${emplpoyee.division}"/></td>
                <td>
                    <a href="${pageContext.request.contextPath}/employee?action=edit&id=${emplpoyee.id}">
                        <button class="btn btn-outline-primary" >Edit</button>
                    </a>
                    <a href="${pageContext.request.contextPath}/employee?action=delete&id=${emplpoyee.id}">
                        <button type="button btn-outline-dark" class="btn btn-secondary">Delete</button>
                    </a>

                </td>
            </tr>
        </c:forEach>
        </tbody>
        <tfoot>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Birthday</th>
            <th>ID Card</th>
            <th>Salary</th>
            <th>Phone Number</th>
            <th>Email</th>
            <th>Address</th>
            <th>Position ID</th>
            <th>Education ID</th>
            <th>Division ID</th>
            <th>Actions</th>
        </tr>
        </tfoot>
    </table>
</div>
</body>
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"--%>
<%--        integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"--%>
<%--        crossorigin="anonymous"></script>--%>
<script type="text/javascript" src="https://cdn.datatables.net/v/bs4/dt-1.11.1/datatables.min.js"></script>
<script>
    $(document).ready(function() {
        $('#example').DataTable( {
            "order": [[ 3, "desc" ]]
        } );
    } );
</script>
</html>
