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
<title>Wishlist</title>
</head>
<body>

<%@ include file = "customerMenu.jsp" %>

<h2>You are now in your WishList</h2>

<%
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","Root");
	PreparedStatement ps = con.prepareStatement("select * from wishlist");
	ResultSet rs = ps.executeQuery();
	while(rs.next())
	{
		out.println(rs.getInt(1) + "<br>");
		out.println(rs.getString(2) + "<br>");
		out.println(rs.getString(3) + "<br>");
		out.println(rs.getInt(4) + "<br><h3><form action = 'Cart'><button name ='pid' value='" + rs.getInt(1) + "'>ADD TO CART</button></form></h3>");
		
	}

%>

</body>
</html>