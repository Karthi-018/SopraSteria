<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ page import="java.sql.*" %>
    <%@ page import="javax.servlet.ServletRequest" %>
    <%@ page import=" edu.steria.training.SpringMVCDemo.*" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:set var="pr" value="${ pro}"/>
<form action="Edit" >
<label>Product Id:  </label>
<input type="text" name="id" value="${ pr.getId() }" hidden="true"/>
<input type="text" name="id" value="${pr.getId()}" disabled/><br><br>
<label>Product Name:  </label>
<input type="text" name="name"value="${pr.getPname() }" disabled/><br><br>
<label>Product Description: </label>
<input type="text" name="descp" value="${pr.getDescription() }" disabled/><br><br>
<label>Product Price: </label>
<input type="number" name="price" value="${pr.getPrice()}" min="50" required/><br><br>
<label>Product Quantity: </label>
<input type="number" name="quan" value="${pr.getQuantity() }" min="1" required/><br><br>
<input type="submit" value="Update" name="act"/>
</form>
</body>
</html>