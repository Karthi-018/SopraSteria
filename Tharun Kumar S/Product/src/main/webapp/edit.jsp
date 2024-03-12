<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center><%@include file= "index.jsp" %></center>
<h3 style = "text-align:center;">Editing the product</h3>
<%= request.getAttribute("msg")==null?"":request.getAttribute("msg") %>

<form action = "Edit">
<br><input type = "number" name = "id" value="<%=request.getAttribute("eid") %>"hidden="true"><br>
<label>Product Id</label><br><input type = "number" name = "id" value="<%=request.getAttribute("eid") %>" required disabled><br>
<label>Product Name</label><br><input type = "text" name = "name" value="<%=request.getAttribute("name") %>" required disabled><br>
<label>Product Descp</label><br><input type = "text" name = "desc" value="<%=request.getAttribute("descp") %>" required disabled><br>
<label>Product Price</label><br><input type = "number" name = "price" value="<%=request.getAttribute("price") %>" required><br>
<label>Product Quantity</label><br><input type = "number" name = "quan" value="<%=request.getAttribute("quan") %>" required><br><br>
<input type = "submit" name = "method" value = "Update">
<br>
</form>



</body>
</html>