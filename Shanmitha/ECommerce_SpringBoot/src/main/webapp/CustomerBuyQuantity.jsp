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
    }
    form {
        margin-top: 50px;
    }
    input[type="text"] {
        padding: 10px;
        font-size: 16px;
        border: 1px solid #ccc;
        border-radius: 5px;
        width: 200px;
    }
    button {
        padding: 10px 20px;
        font-size: 16px;
        background-color:  #007bff;
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }
    button:hover {
        background-color: #45a049;
    }
</style>
</head>
<body>
<center>
<form action="BuyQuantity">
    <input type="text" name="quantity" placeholder="Enter quantity">
    <button type="submit">BUY</button>
</form>
</center>
</body>
</html>