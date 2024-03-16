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
<c:set var="user" value='${ sessionScope.username}'/> 
<sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost:3306/ECommerce" user="root" password="root" />
<sql:query var="rs1" dataSource="${db }">
	select productdata.id,productdata.name,productdata.descript,productdata.price,cartlist.quantity from productdata join cartlist on productdata.id=cartlist.pid where cartlist.cemail= '${user}' ;
</sql:query>
<center><%@ include file="CustomerHeader.jsp" %></center>
<table>
<tr><th>PRODUCT NAME</th>
<th>DESCRIPTION</th>
<th>PRICE</th>
<th>QUANTITY</th>
<th>ACTION</th></tr>
<c:forEach var="c" items="${rs1.rows }">
<tr><td>${c.name }</td>
<td>${c.descript }</td>
<td>${c.price}</td> 
<td>${c.quantity }</td>
<td><form action='DeleteCartServlet' ><button name='delete' value='${c.id }'>DELETE</button></form>
<form action='BuyServlet' ><button name='buy' value='${c.id }'>BUY</button></form>
<form action='AddListDelete' ><button name='wishList' value='${c.id }'>MOVE TO WISHLIST</button></form>
</td>
</tr>
</c:forEach>
</table>
</body>
</html>