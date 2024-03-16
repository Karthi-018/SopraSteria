<%@page import="edu.servletTraining.ProductPojo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
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
<form  action ="Search.jsp">
<input type="text" name="search" placeholder="Enter product to search"/>
<input type="submit" value="search" name="act"/>
</form>
<table>
<tr><th>PRODUCT ID</th>
<th>PRODUCT NAME</th>
<th>DESCRIPTION</th>
<th>PRICE</th>
<th>QUANTITY</th></tr>
<c:forEach var="c" items="${rs.rows }">
<c:if test="${c.name eq param.search }">
<tr><td>${c.id }</td>
<td>${c.name }</td>
<td>${c.descript }</td>
<td>${c.price }</td>
<td>${c.quant}</td></tr>
</c:if>
</c:forEach>
</table>
</c:when>
<c:otherwise>
<center><%@ include file="CustomerHeader.jsp" %></center>
<form action ="Search.jsp">
<input type="text" name="search" placeholder="Enter product to search"/>
<input type="submit" value="search" name="act"/>
</form>
<table>
<tr><th>PRODUCT NAME</th>
<th>DESCRIPTION</th>
<th>PRICE</th></tr>
<c:forEach var="c" items="${rs.rows }">
<c:if test="${c.name eq param.search }">
<tr>
<td>${c.name }</td>
<td>${c.descript }</td>
<td>${c.price }</td></tr>
</c:if>
</c:forEach>
</table>
</c:otherwise>
</c:choose>
</body>
</html>