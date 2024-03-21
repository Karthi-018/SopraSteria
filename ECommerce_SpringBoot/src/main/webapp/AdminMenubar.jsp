<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f8f9fa;
    }

    form {
        width: 50%;
        margin: 0 auto;
        background-color: #fff;
        padding: 20px;
        border-radius: 5px;
        border: 1px solid #dee2e6;
        text-align: center;
    }

    input[type="submit"] {
        padding: 10px;
        margin: 5px;
        border: 1px solid #007bff;
        border-radius: 3px;
        background-color: #007bff;
        color: #fff;
        cursor: pointer;
    }

    input[type="submit"]:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>

<form action="AdminMenubar">
    <input type="submit" name="choice" value="Create">
    <input type="submit" name="choice" value="Search">
    <input type="submit" name="choice" value="View">
    <input type="submit" name="choice" value="ValidateCustomer">
    <input type="submit" name="choice" value="Logout">
</form>

</body>
</html>