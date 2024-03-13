<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center><%@include file= "index.jsp" %></center>
 <h3 style = "text-align:center;">Creating the product</h3>
 <%= request.getAttribute("msg")==null?"":request.getAttribute("msg") %>
 <center>
 <fieldset>
 <legend>Product</legend>
 <form action = "Create">
 <label>Product Id</label><br><input type = "number" name = "pid" required><br>
<label>Product Name</label><br><input type = "text" name = "pname" required><br>
<label>Product Desc</label><br><input type = "text" name = "pdesc" required><br>
<label>Product Quantity</label><br><input type = "number" name = "pquant" required><br>
<label>Product Price</label><br><input type = "number" name = "pprice" required><br><br>
<input type = "submit" name = "method" value = "Add">
<br>
 </form>
 </fieldset>
 </center>
</body>
</html>