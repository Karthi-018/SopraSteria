<%@page import="java.util.ArrayList"%>
<%@page import="java.lang.*"%>
<%@page import="java.sql.*"%>
<%@page import="sopra.test.Product"%>
<%@page import="java.util.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products List</title>
</head>
<body>

<%@ include file = "menubar.jsp" %>



<%
	List<Product> list = new ArrayList<Product>();
	list = (List<Product>)request.getAttribute("msg");
	for(Product i: list)
	{
		out.print("Product ID : " + i.getPid() + " <br>");
		out.print("Product Name : " + i.getPname() + " <br>");
		out.print("Product Description : " + i.getPdesc() + " <br>");
		out.print("Product Price : " + i.getPrice() + " <br>");
		out.print("Product Quantity : " + i.getPquant() + "<form action = 'Delete'><button name ='pid' value='" + i.getPid() + "'>Delete</button></form> <br>");
	}

%>

</body>
</html>