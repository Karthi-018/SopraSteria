<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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

    h1 {
        text-align: center;
    }

    form {
        width: 50%;
        margin: 0 auto;
        background-color: #fff;
        padding: 20px;
        border-radius: 5px;
        border: 1px solid #dee2e6;
    }

    label {
        display: block;
        margin-bottom: 5px;
    }

    input[type="number"],
    input[type="text"],
    input[type="submit"] {
        width: 100%;
        padding: 8px;
        margin-bottom: 10px;
        border: 1px solid #ccc;
        border-radius: 3px;
        box-sizing: border-box;
    }

    input[type="submit"] {
        background-color: #007bff;
        color: #fff;
        border: none;
        cursor: pointer;
    }

    input[type="submit"]:hover {
        background-color: #0056b3;
    }

    input[type="number"][disabled],
    input[type="text"][disabled] {
        background-color: #eee;
        cursor: not-allowed;
    }
</style>
</head>
<body>

<h1>Edit page</h1>
<br>
<form action="UpdateServlet">
<input type="number" name="id" value="<%= request.getAttribute("id") %>" hidden>
<label>Product ID</label>
<input type="number" name="id" value="<%= request.getAttribute("id") %>" disabled>
<br>
<label>Product Name</label>
<input type="text" name=name value="<%= request.getAttribute("name")%>" disabled>
<br>
<label>Product description</label>
<input type="text" name="desc" value="<%= request.getAttribute("desc") %>" disabled>
<br>
<label>Product price</label>
<input type="number" name="price" value="<%= request.getAttribute("price")%>">
<br>
<label>Product quantity</label>
<input type="number" name="quantity" value="<%= request.getAttribute("quantity")%>">
<br>

<input type="submit" name="Save" value="Save">
</form>
</body>
</html>