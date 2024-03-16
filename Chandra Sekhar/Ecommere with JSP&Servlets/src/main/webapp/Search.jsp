<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Products</title>
</head>
<body>
<%@ include file = "menubar.jsp" %>
<h2>Searching Page</h2>

${message }






<br><br>

<form action="SearchServlet">

<label>Enter the Product name to Search :</label>
<input type = "text" name = "sname" value = "" placeholder = "Proudect Name"/>
<br><br>

<input type = "submit" name = "ssub" value = "Submit"/>
<input type = "reset"  value = "reset"/>
</form>


</body>
</html>