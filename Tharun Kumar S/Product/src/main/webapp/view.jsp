<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
<center><%@include file="home.jsp"%></center>

<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="javax.servlet.ServletRequest" %>
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
    			+ "      <th scope=\"col\">Delete</th>\r\n"
    			+ "      <th scope=\"col\">Edit</th>\r\n"
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
    			+ "      <td><form action='delete' method='get'><button name='del' value="+rs.getInt(1)+">Delete</button></form>"
    			+ "      <td><form action='PreEdit' method='get'><button name='edit' value="+rs.getInt(1)+" >Edit</button></form>"
    			+ "    </tr>\r\n"
    			+ "  </tbody>\r\n");
	  }while(rs.next());
	}
	else{
		out.println("<h1>Noooooo</h1>");
	}

		}
	  %>
</body>
</html>