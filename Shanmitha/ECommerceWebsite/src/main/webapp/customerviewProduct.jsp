<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
<%
ResultSet rs=(ResultSet)request.getAttribute("resultSet");
 
		out.println("<table>"
    	        + "<table class=\"table\">\r\n"
    			+ "  <thead>\r\n"
    			+ "    <tr>\r\n"
    			+ "      <th scope=\"col\">PID</th>\r\n"
    			+ "      <th scope=\"col\">Pname</th>\r\n"
    			+ "      <th scope=\"col\">Description</th>\r\n"
    			+ "      <th scope=\"col\">Price</th>\r\n"
    			+ "      <th scope=\"col\">Quantity</th>\r\n"
    			+ "      <th scope=\"col\">Buy</th>\r\n"
    			+ "    </tr>\r\n"
    			+ "  </thead>\r\n");
if(rs!=null)
		{
	if(rs.next()){
	  do{
		out.println("  <tbody>\r\n"
    			+ "    <tr>\r\n"
    			+ "      <th scope=\"row\">"+rs.getInt(1)+"</th>\r\n"
    			+ "      <td>"+rs.getString(2)+"</td>\r\n"
    			+ "      <td>"+rs.getString(3)+"</td>\r\n"
    			+ "      <td>"+rs.getInt(4)+"</td>\r\n"
    			+ "      <td>"+rs.getInt(5)+"</td>\r\n"
    			+ "      <td><form action='CustomerBuyServlet'><button name='buy' value="+rs.getInt(1)+">Buy</button></form>"
    			+ "    </tr>\r\n"
    			+ "  </tbody>\r\n");
	  }while(rs.next());
	}
		}
	  %>
 
</body>
</html>