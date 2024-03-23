<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ page import="java.sql.*" %>
    
<%@ page import="java.util.*" %>
<%@ page import="javax.servlet.ServletRequest" %>
<%@ page import=" edu.steria.training.SpringMVCDemo.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center><%@ include file="CustomerHeader.jsp" %></center>
<c:set var="n" value="${flag}"/>
<c:choose>
<c:when test="${n=='true' }">
<table>
<tr>
<th>PRODUCT NAME</th>
<th>DESCRIPTION</th>
<th>PRICE</th>
<th>ACTION</th></tr>
<c:forEach var="c" items="${wish}">
<tr><td>${c.getPname()}</td>
<td>${c.getDescription()}</td>
<td>${c.getPrice()}</td> 
<td><form action='DeleteWishList' ><button name='delete' value='${c.getId()}'>DELETE</button></form>
<form action='AddToCartAndDelete' ><button name='cart' value='${c.getId()}'>MOVE TO CART</button></form>
</td>
</tr>
</c:forEach>
</table>
</c:when>
<c:otherwise>
<h2>${msg }</h2>
</c:otherwise>
</c:choose>
</body>
</html>