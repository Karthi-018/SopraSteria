<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 
<h1>Edit page</h1>
<br>
<form action="UpdateServlet">
<input type="number" name="id" value="<%= request.getAttribute("id") %>" Hidden="true">
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
<input type="number" name="price" value="<%= request.getAttribute("price")%>" >
<br>
<label>Product quantity</label>
<input type="number" name="quantity" value="<%= request.getAttribute("quantity")%>">
<br>
 
<input type="submit" name="Save" value="Save">
</form>
</body>
</html>