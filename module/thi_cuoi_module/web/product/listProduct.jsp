<%--
  Created by IntelliJ IDEA.
  User: duckbui
  Date: 9/8/2021
  Time: 6:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/static/listProduct.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
          crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs4/dt-1.11.1/datatables.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body >
<div align="center container w-75 p3">
    <div class="container pt-4 ">
        <div class="row">
            <div class="col-sm-4">
                <form class="form-inline" method="get" action="/product">
                    <input type="hidden" id="action1" name="action" value="find">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="findId">
                    <button type="submit" class="btn btn-outline-primary"> Find By Cost</button>
                </form>
            </div>
            <div class="col-sm-4">
                <form class="form-inline" method="get" action="/product">
                    <input type="hidden" id="action2" name="action" value="find">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="findId">
                    <button type="submit" class="btn btn-outline-primary"> Find By ID</button>
                </form>
            </div>
            <div class="col-sm-4">
                <form class="form-inline" method="get" action="/product">
                    <input type="hidden" id="action3" name="action" value="find">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="findId">
                    <button type="submit" class="btn btn-outline-primary"> Find By ID</button>
                </form>
            </div>
            <div class="col-sm-4">
                <form class="form-inline" method="get" action="/product">
                    <input type="hidden" id="action4" name="action" value="find">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="findId">
                    <button type="submit" class="btn btn-outline-primary"> Find By ID</button>
                </form>
            </div>
            <div class="col-sm-4">
                <form class="form-inline" method="get" action="/product">
                    <input type="hidden" id="action" name="action" value="find">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="findId">
                    <button type="submit" class="btn btn-outline-primary"> Find By ID</button>
                </form>
            </div>

            <div class="col-sm">
                <a href="${pageContext.request.contextPath}/product">
                    <button type="button " class="btn btn-outline-info">List All Product</button>
                </a>
            </div>
            <div class="col-sm">
                <a href="/product?action=create">
                    <button type="button o" class="btn btn-outline-info">Create Product</button></a>
            </div>
        </div>
    </div>
    <table class="table table-striped" id="example">
        <thead>
        <tr>
            <th>ID</th>
            <th>Product Name</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Color</th>
            <th>Category</th>
            <th>Actions</th>
        </tr>
        </thead>
        <c:forEach var="product" items="${listProducts}">
            <tr>
                <td><c:out value="${product.id}"/></td>
                <td><c:out value="${product.name}"/></td>
                <td><c:out value="${product.cost}"/></td>
                <td><c:out value="${product.quantity}"/></td>
                <td><c:out value="${product.color}"/></td>
                <td><c:out value="${product.category}"/></td>
                <td>
                    <div class="container-fluid">

                        <button class="btn btn-warning" style="width: 100px;">
                            <a href="${pageContext.request.contextPath}/product?action=edit&id=${product.id}">Edit </a>
                        </button>

                        <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#flipFlop${product.id}" style="width: 90px;">
                            <a class="abc">DELETE</a>
                        </button>

                        <!-- The modal -->
                        <div class="modal fade" id="flipFlop${product.id}" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h4 class="modal-title" id="d">WARNING!</h4>
                                    </div>
                                    <div class="modal-body">DO YOU WANT TO DELETE ID_Product <c:out value="${product.id}"/> ? </div>
                                    <div class="modal-footer">
                                        <button type="submit" class="btn btn-danger" style="width: 100px;">
                                            <a href="${pageContext.request.contextPath}/product?action=delete&id=${product.id}">Delete </a>
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
    <div class="alert alert-primary" role="alert">
            <c:out value="${alert}"/>
    </div>
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

