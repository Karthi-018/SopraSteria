<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add elements</title>
</head>
<body>
<%@ include file = "menubar.jsp" %>

<h2>Creating Page</h2>
${ message}
${out }


<form action="CreateServlet">

<label>Product ID :</label>
<input type = "text" name = "pid" value = ""/>
<br><br>
<label>Product Name :</label>
<input type = "text" name = "pname" value = ""/>
<br><br>
<label>Product Description :</label>
<input type = "text" name = "pdesc" value = ""/>
<br><br>
<label>Product Price :</label>
<input type = "text" name = "pprice" value = ""/>
<br><br>
<label>Product Quantity :</label>
<input type = "text" name = "pquant" value = ""/>
<br><br>

<input type = "submit" name = "fsub" value = "Submit"/>
<input type = "reset"  value = "reset"/>
</form>

</body>
</html>