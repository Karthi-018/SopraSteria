<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
    <%@page import="edu.servletTraining.*" %>
<%@ page import="java.util.*" %>
<%@ page import="javax.servlet.ServletRequest" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="AfterEditServlet" >
<% ProductPojo p =(ProductPojo)request.getAttribute("result");%>
<label>Product Id:  </label>
<input type="text" name="id" value="<%=p.getId() %>" hidden="true"/>
<input type="text" name="id" value="<%=p.getId()%>" disabled/><br><br>
<label>Product Name:  </label>
<input type="text" name="name"value="<%=p.getName() %>" disabled/><br><br>
<label>Product Description: </label>
<input type="text" name="descp" value="<%=p.getDesc() %>" disabled/><br><br>
<label>Product Price: </label>
<input type="number" name="price" value="<%=p.getPrice()%>" min="50" required/><br><br>
<label>Product Quantity: </label>
<input type="number" name="quan" value="<%=p.getQuantity() %>" min="1" required/><br><br>
<input type="submit" value="update" name="act"/>
</form>
</body>
</html>