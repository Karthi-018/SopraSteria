<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

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
<center>
<h1>Welcome to E-Kart</h1>

<form action="login">
	<label>USERNAME</label>
	<input type = "text" name = "name" placeholder="Enter username"><br><br>
	<label>PASSWORD</label>
	<input type = "text" name = "psw" placeholder="Enter password"><br><br>
  <input type="submit"><br><br>
  <h3>${invalid} </h3>
</form>
</center>
</body>
</html>