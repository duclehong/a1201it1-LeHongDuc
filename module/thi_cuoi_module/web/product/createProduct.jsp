<%--
  Created by IntelliJ IDEA.
  User: duckbui
  Date: 9/8/2021
  Time: 6:44 PM
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


                        <form method="post">

                            <div class="form-group">
                                <label for="name">Name</label>
                                <input type="text" class="form-control" id="name" placeholder="Name Product" name="name">
                            </div>
                            <div class="form-group">
                                <label for="cost">Cost</label>
                                <input type="text" class="form-control" id="cost" placeholder="2000.000" name="cost">
                            </div>
                            <div class="form-group">
                                <label for="quantity">Quantity</label>
                                <input type="text" class="form-control" id="quantity" placeholder="" name="quantity">
                            </div>
                            <div class="form-group">
                                <label for="color">Color </label>
                                <input type="text" class="form-control" id="color" placeholder="" name="color">
                            </div>
                            <div class="form-group">
                                <label for="des">Description</label>
                                <input type="text" class="form-control" id="des" placeholder="" name="des">
                            </div>

                            <div class="form-group">
                                <label for="category">Category</label>
                                <select id="category" class="form-control" name="category">
                                    <option selected value="1">Phone</option>
                                    <option value="2">Televison</option>
                                    <option value="3">Air-conditioner</option>
                                    <option value="4">Washing machine</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <button type="submit" class="btn btn-primary">ADD</button>
                            </div>
                            <a href="product?action=product">List All Product</a>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
