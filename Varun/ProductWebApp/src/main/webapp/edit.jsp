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
<label>Product ID</label>
<input type="number" name="pid" value="<%= request.getAttribute("pid").toString() %>" hidden="true">
<br>
<label>Product ID</label>
<input type="number" name="pid" value="<%= request.getAttribute("pid").toString() %>" disabled>
<br>
<label>Product Name</label>
<input type="text" name=pname value="<%= request.getAttribute("pname").toString() %>" disabled>
<br>
<label>Product description</label>
<input type="text" name="pdesc" value="<%= request.getAttribute("pdesc").toString() %>" disabled>
<br>
<label>Product price</label>
<input type="number" name="pprice" value="<%= request.getAttribute("pprice").toString() %>" >
<br>
<label>Product quantity</label>
<input type="number" name="pquantity" value="<%= request.getAttribute("pquantity").toString() %>">
<br>

<input type="submit" name="Save" value="Save">
</form>
</body>
</html>