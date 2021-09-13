<%--
  Created by IntelliJ IDEA.
  User: duckbui
  Date: 9/3/2021
  Time: 9:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">
    <link rel="stylesheet" href="/static/listService.css">

</head>
<body >
<div align="center container w-75 p3">
    <div class="container pt-4 ">
        <div class="row">
            <div class="col-sm-4">
                <form class="form-inline" method="get" action="/customer">
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
                <a href="/employee">
                    <button type="button " class="btn btn-outline-info">List Employee</button></a>
            </div>
            <div class="col-sm">
                <a href="/customer?action=create">
                    <button type="button " class="btn btn-outline-info">Create Customer</button></a>
            </div>
        </div>
    </div>
    <table class="table table-striped" id="example">
        <thead>
        <tr>
            <th>ID</th>
            <th>Type</th>
            <th>Name</th>
            <th>Birthday</th>
            <th>Gender</th>
            <th>ID Card</th>
            <th>Phone Number</th>
            <th>Email</th>
            <th>Address</th>
            <th>Actions</th>
        </tr>
        </thead>
        <c:forEach var="customer" items="${listCutomers}">
            <tr>
                <td><c:out value="${customer.id}"/></td>
                <td><c:out value="${customer.getType()}"/></td>
                <td><c:out value="${customer.getName()}"/></td>
                <td><c:out value="${customer.getBirthday()}"/></td>
                <td><c:out value="${customer.getGender()}"/></td>
                <td><c:out value="${customer.getIdCard()}"/></td>
                <td><c:out value="${customer.getPhone()}"/></td>
                <td><c:out value="${customer.getEmail()}"/></td>
                <td><c:out value="${customer.getAddress()}"/></td>
                <td>

                         <div class="container-fluid">

                             <button  class="btn btn-warning" style="width: 100px;">
                                 <a href="${pageContext.request.contextPath}/customer?action=edit&id=${customer.id}"> EDIT
                                 </a>
                             </button>

                             <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#flipFlop${ground.ground_code}" style="width: 90px;">
                                 <a class="abc">DELETE</a>
                             </button>

                             <!-- The modal -->
                             <div class="modal fade" id="flipFlop${ground.ground_code}" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
                                 <div class="modal-dialog" role="document">
                                     <div class="modal-content">
                                         <div class="modal-header">
                                             <h4 class="modal-title" id="modalLabel">WARNING!</h4>
                                         </div>
                                         <div class="modal-body">DO YOU WANT TO DELETE ID_User <c:out value="${ground.ground_code}"/> ? </div>
                                         <div class="modal-footer">
                                             <button type="submit" class="btn btn-danger" style="width: 100px;">
                                                 <a href="/customer?action=delete&id=${customer.id}">YES </a>
                                             </button>
                                             <button type="button" class="btn btn-secondary" data-dismiss="modal" style="width: 100px">CLOSE</button>
                                         </div>
                                     </div>
                                 </div>
                             </div>
                         </div>


                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
        crossorigin="anonymous"></script>
<script type="text/javascript" src="https://cdn.datatables.net/v/bs4/dt-1.11.1/datatables.min.js"></script>

<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
<script>
    $(document).ready(function() {
        $('#example').DataTable( {
            "order": [[ 3, "desc" ]]
        } );
    } );
</script>
</html>
