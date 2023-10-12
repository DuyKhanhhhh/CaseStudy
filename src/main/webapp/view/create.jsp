<%--
  Created by IntelliJ IDEA.
  User: titdzvl
  Date: 11/10/2023
  Time: 20:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<style>
    .box{
        width: 50%;
        height: 100%;
        margin: 0 auto;
    }
</style>
<body>
<a href="/product">
    <button type="button" class="btn btn-info">Back</button>
</a>
<form method="post">
    <h1 align="center" style="color: green">🛠Creat🛠</h1>
    <div class="box">
        <label class="form-label">Name Product</label>
        <input type="text" name="name" class="form-control" placeholder="Enter your Name Product">
        <label class="form-label">Price Product</label>
        <input type="text" name="price" class="form-control" placeholder="Enter your Price Product">
        <label class="form-label">Img Product</label>
        <input type="text" name="img" class="form-control" placeholder="Enter your URL Img Product">
        <input type="submit" class="btn btn-primary" value="Save">
    </div>

</form>
</body>
</html>
