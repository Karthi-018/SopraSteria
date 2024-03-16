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
	select id,name,descript,price from productData join wishlist on productData.id=wishlist.pid where cemail= '${user}' ;
</sql:query>
<center><%@ include file="CustomerHeader.jsp" %></center>
<table>
<tr>
<th>PRODUCT NAME</th>
<th>DESCRIPTION</th>
<th>PRICE</th>
<th>ACTION</th></tr>
<c:forEach var="c" items="${rs1.rows }">
<tr><td>${c.name }</td>
<td>${c.descript }</td>
<td>${c.price}</td> 
<td><form action='DeleteListServlet' ><button name='delete' value='${c.id }'>DELETE</button></form>
<form action='AddCartDelete' ><button name='cart' value='${c.id }'>MOVE TO CART</button></form>
</td>
</tr>
</c:forEach>
</table>
</body>
</html>