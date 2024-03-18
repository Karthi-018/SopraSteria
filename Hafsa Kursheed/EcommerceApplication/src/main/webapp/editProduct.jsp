<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit</title>
</head>

<body>
<center>
	<%@ include file = "menubar.jsp" %>
	<h1>EDITING THE PRODUCT</h1><br>
	<h3>
	<%= request.getAttribute("msg")== null ?"":request.getAttribute("msg")%>
	</h3>


<form action = "editServlet">
	
	<input type = "number" name = "pid" value="<%= request.getAttribute("pid") %>" hidden="true"/><br><br>
	
	<label>Enter Product ID:</label>
	<input type = "number" name = "pid" placeholder ="Product ID" value="<%= request.getAttribute("pid") %>" disabled/><br><br>
	
	<label>Enter Product Name:</label>
	<input type="text" name="pname" placeholder = "Product Name" value="<%= request.getAttribute("pname") %>" disabled/><br><br>
	
	<label>Enter Product Description:</label>
	<input type="text" name="pdesc" placeholder = "Product Description" value="<%= request.getAttribute("pdesc") %>" disabled/><br><br>
	
	<label>Enter Product Price:</label>
	<input type="number" name="pprice" placeholder = "Product Price" value="<%= request.getAttribute("pprice") %>" required/><br><br>
	
	<label>Enter Product Quantity:</label>
	<input type="number" name="pquant" placeholder = "Product Quantity" value="<%= request.getAttribute("pquant") %>" required/><br><br>
	
<input type="submit" value="Edit Product"/>
</center>

</form>
</body>
</html>