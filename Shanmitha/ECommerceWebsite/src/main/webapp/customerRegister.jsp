<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Registration</title>
<!-- Add Bootstrap CDN -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <form action="CustomerRegisterServlet">
        <div class="form-group">
            <label for="fname">First Name:</label>
            <input type="text" class="form-control" name="fname" id="fname" placeholder="Enter your firstname">
        </div>
        <div class="form-group">
            <label for="lname">Last Name:</label>
            <input type="text" class="form-control" name="lname" id="lname" placeholder="Enter your lastname">
        </div>
        <div class="form-group">
            <label for="email">E-mail:</label>
            <input type="email" class="form-control" name="email" id="email" placeholder="Enter your E-mail">
        </div>
        <div class="form-group">
            <label for="pass">Password:</label>
            <input type="password" class="form-control" name="pass" id="pass" placeholder="Set your Password">
        </div>
        <div class="form-group">
            <label for="dob">DOB:</label>
            <input type="date" class="form-control" name="dob" id="dob" placeholder="DD-MM-YYYY">
        </div>
        <div class="form-group">
            <label>Gender:</label>
            <div class="form-check">
                <input type="radio" class="form-check-input" name="gender" id="male" value="Male">
                <label class="form-check-label" for="male">Male</label>
            </div>
            <div class="form-check">
                <input type="radio" class="form-check-input" name="gender" id="female" value="Female">
                <label class="form-check-label" for="female">Female</label>
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Register</button>
        <button type="reset" class="btn btn-secondary">Reset</button>
        <button type="submit" class="btn btn-success" name="Login">Login</button>
    </form>
</div>
</body>
</html>