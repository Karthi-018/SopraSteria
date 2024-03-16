<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="javax.servlet.ServletRequest" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center><%@ include file="customerMenubar.jsp" %></center>
<br>
<br>
<br>
<center>
<form action="CustomerSearchServlet" method="post">
<label>Name</label>
<input type = "text" name = "search"   placeholder = "Enter product name to search:">
<input type = "submit" value = "search" name="act"></form></center>
<% 

ResultSet rs = (ResultSet)request.getAttribute("resultSet"); 
if(rs!=null )
{
		out.println("<table>"
    	        + "<table class=\"table\">\r\n"
    			+ "  <thead>\r\n"
    			+ "    <tr>\r\n"
    			+ "      <th scope=\"col\">PID</th>\r\n"
    			+ "      <th scope=\"col\">Pname</th>\r\n"
    			+ "      <th scope=\"col\">Description</th>\r\n"
    			+ "      <th scope=\"col\">Price</th>\r\n"
    			+ "      <th scope=\"col\">Quantity</th>\r\n"
    			+ "    </tr>\r\n"
    			+ "  </thead>\r\n");

		out.println("  <tbody>\r\n"
    			+ "    <tr>\r\n"
    			+ "      <th scope=\"row\">"+rs.getLong(1)+"</th>\r\n"
    			+ "      <td>"+rs.getString(2)+"</td>\r\n"
    			+ "      <td>"+rs.getString(3)+"</td>\r\n"
    			+ "      <td>"+rs.getLong(4)+"</td>\r\n"
    			+ "      <td>"+rs.getLong(5)+"</td>\r\n"
    			+ "    </tr>\r\n"
    			+ "  </tbody>\r\n"
    			+ "</table>");
}
%>
</body>
</html>