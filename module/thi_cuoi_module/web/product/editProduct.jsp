<%--
  Created by IntelliJ IDEA.
  User: duckbui
  Date: 9/8/2021
  Time: 7:08 PM
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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body style="background-color: #8fc4b7;">
<div align="center pt-4">
    <div class="container py-5 ">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-lg-8 col-xl-6">
                <div class="card rounded-3">
                    <div class="card-body p-4 p-md-5">

                        <form method="post">

                            <div class="form-group">
                                <label for="name">Name</label>
                                <input type="text" class="form-control" id="name"  name="name" value="<c:out value='${product.name}' />">
                            </div>
                            <div class="form-group">
                                <label for="cost">Cost</label>
                                <input type="text" class="form-control" id="cost"  name="cost" value="<c:out value='${product.cost}' />">
                            </div>
                            <div class="form-group">
                                <label for="quantity">Quantity</label>
                                <input type="text" class="form-control" id="quantity"  name="quantity" value="<c:out value='${product.quantity}' />">
                            </div>
                            <div class="form-group">
                                <label for="color">Color</label>
                                <input type="text" class="form-control" id="color"  name="color" value="<c:out value='${product.color}' />">
                            </div>
                            <div class="form-group">
                                <label for="des">Description</label>
                                <input type="text" class="form-control" id="des"  name="des" value="<c:out value='${product.des}' />">
                            </div>

                            <div class="form-group">
                                <label for="category">Category</label>
                                <select id="category" class="form-control" name="category" >
                                    <option selected value="<c:out value='${product.category}' />">
                                        <c:choose>
                                            <c:when test = "${product.category == 1}">
                                                Phone
                                            </c:when>

                                            <c:when test = "${product.category == 2}">
                                                Televison
                                            </c:when>

                                            <c:when test = "${product.category == 3}">
                                                Air-conditioner
                                            </c:when>

                                            <c:when test = "${product.category == 4}">
                                                Washing machine
                                            </c:when>
                                        </c:choose>
                                    </option>
                                    <option value="1">Phone</option>
                                    <option value="2">Televison</option>
                                    <option value="3">Air-conditioner</option>
                                    <option value="4">Washing machine</option>
                                </select>
                            </div>

                            <div class="form-group">
                                <button type="submit" class="btn btn-primary">ADD</button>
                            </div>
                            <div class="form-group">
                                <a href="product?action=product">List All Product</a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
