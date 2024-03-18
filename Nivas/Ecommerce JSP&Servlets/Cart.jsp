<%@page import="java.util.ArrayList"%>
<%@page import="java.lang.*"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shopping Cart</title>
</head>
<body>

<%@ include file = "customerMenu.jsp" %>

<h2>You are now in your Cart</h2>
<h3>.....proceed to buy</h3>

<%
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","Root");
	PreparedStatement ps = con.prepareStatement("select * from cart");
	ResultSet rs = ps.executeQuery();
	while(rs.next())
	{
		out.println(rs.getInt(1) + "<br>");
		out.println(rs.getString(2) + "<br>");
		out.println(rs.getString(3) + "<br>");
		out.println(rs.getInt(4) + "<br><h3><form action = 'Buy'><button name ='buy' value='"+ rs.getInt(1) +"'>BUY</button></form></h3>");
		
	}

%>


</body>
</html>