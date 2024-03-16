<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
<style>
    body {
        font-family: Arial, sans-serif;
    }

    h3 {
        text-align: center;
        color: #333; /* Dark gray text color */
    }

    form {
        margin: 0 auto; /* Center the form horizontally */
        max-width: 300px; /* Limit the width of the form */
    }

    label {
        display: block;
        margin-bottom: 10px; /* Add some space between label and input */
    }

    input[type="text"],
    input[type="password"] {
        width: 100%;
        padding: 8px;
        margin-bottom: 10px; /* Add some space between inputs */
        box-sizing: border-box; /* Include padding and border in element's total width and height */
    }

    input[type="submit"] {
        width: 100%;
        padding: 10px;
        background-color: #007bff; /* Blue button color */
        color: #fff; /* White text color */
        border: none;
        border-radius: 5px;
        cursor: pointer;
        transition: background-color 0.3s ease; /* Smooth transition for hover effect */
    }

    input[type="submit"]:hover {
        background-color: #0056b3; /* Darker blue color on hover */
    }
</style>
</head>
<body>
<h3>LOGIN</h3>
<form action="AdminLoginServlet">
    <label for="uname">USERNAME</label>
    <input type="text" id="uname" placeholder="Enter Username" name="uname" required><br>

    <label for="psw">PASSWORD</label>
    <input type="password" id="psw" placeholder="Enter Password" name="psw" required><br>

    <input type="submit" value="Login" name="login">
</form>
</body>
</html>