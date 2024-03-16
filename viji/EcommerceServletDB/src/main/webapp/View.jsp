<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
    <%@page import="edu.servletTraining.*" %>
<%@ page import="java.util.*" %>
<%@ page import="javax.servlet.ServletRequest" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost:3306/ECommerce" user="root" password="root" />
<sql:query var="rs" dataSource="${db }">
	select * from productData;
</sql:query>
<c:set var="type" value='${ sessionScope.type}'/>  
<c:choose>
<c:when test="${type=='admin'}">
<center><%@ include file="header.jsp" %></center>
<table>
<tr><th>PRODUCT ID</th>
<th>PRODUCT NAME</th>
<th>DESCRIPTION</th>
<th>PRICE</th>
<th>QUANTITY</th>
<th>ACTION</th></tr>
<c:forEach var="c" items="${rs.rows }">
<tr><td>${c.id }</td>
<td>${c.name }</td>
<td>${c.descript }</td>
<td>${c.price }</td>
<td>${c.quant}</td>
<td><form action='DeleteServlet' ><button name='delete' value='${c.id }'>DELETE</button></form>
<form action='EditServlet' ><button name='edit' value='${c.id }'>EDIT</button></form></td></tr>
</c:forEach>
</table>
</c:when>
<c:otherwise>
<center><%@ include file="CustomerHeader.jsp" %></center>
<table>
<tr><th>PRODUCT NAME</th>
<th>DESCRIPTION</th>
<th>PRICE</th>
<th>ACTION</th></tr>
<c:forEach var="c" items="${rs.rows }">
<tr><td>${c.name }</td>
<td>${c.descript }</td>
<td>${c.price }</td>
<td><form action='BuyServlet' ><button name='buy' value='${c.id }'>BUY</button></form>
<form action='WishListServlet' ><button name='wishList' value='${c.id }'>ADD TO WISHLIST</button></form>
<form action='CartServlet' ><button name='cart' value='${c.id }'>ADD TO CART</button></form></td></tr>
</c:forEach>
</table>
</c:otherwise>
</c:choose> 
</body>
</html>