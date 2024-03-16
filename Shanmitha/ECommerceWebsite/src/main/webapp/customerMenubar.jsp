<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu</title>
<!-- Add Bootstrap CDN -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<style>
    body {
        background-color: #f8f9fa;
    }

    .menu-form {
        max-width: 400px;
        margin: 0 auto;
        padding: 20px;
        background-color: #fff;
        border-radius: 5px;
        box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.1);
    }
</style>
</head>
<body>
<div class="container">
    <div class="menu-form">
        <h3 class="text-center">Menu</h3>
        <form action="CustomerActionservlet">
            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-block" name="choice" value="Search">Search</button>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-block" name="choice" value="View">View</button>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-block" name="choice" value="Cart">Cart</button>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-block" name="choice" value="Wishlist">Wishlist</button>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-block" name="choice" value="Logout">Logout</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>