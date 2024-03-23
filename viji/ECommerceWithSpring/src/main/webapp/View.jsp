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
<jsp:include page="quant.jsp"/>
</head>
<body>
<c:set var="type" value="${type}"/> 
<c:choose>
<c:when test="${type=='Admin'}">
<center><%@ include file="header.jsp" %></center>
<c:set var="n" value="${flag}" ></c:set>
<c:choose>
<c:when test="${ n==true}">
<table>
<tr><th>PRODUCT ID</th>
<th>PRODUCT NAME</th>
<th>DESCRIPTION</th>
<th>PRICE</th>
<th>QUANTITY</th>
<th>ACTION</th></tr>
<c:forEach var="pr" items="${list}">
<tr><td>${pr.getId() }</td>
<td>${pr.getPname() }</td>
<td>${pr.getDescription() }</td>
<td>${pr.getPrice() }</td>
<td>${pr.getQuantity()}</td>
<td><form action='Delete' ><button name='delete' value='${pr.getId()}'>DELETE</button></form>
<form action='EditData' ><button name='edit' value='${pr.getId() }'>EDIT</button></form></td></tr>
</c:forEach>
</table>
</c:when>
<c:otherwise>
<h3>${msg}</h3>
</c:otherwise>
</c:choose>
</c:when>

<c:otherwise>
<center><%@ include file="CustomerHeader.jsp" %></center>
<c:set var="n" value="${flag}" ></c:set>
<c:choose>
<c:when test="${n==true}">
<table>
<tr><th>PRODUCT NAME</th>
<th>DESCRIPTION</th>
<th>PRICE</th>
<th>ACTION</th></tr>
<c:forEach var="pr" items="${list}">
<tr>
<td>${pr.getPname() }</td>
<td>${pr.getDescription() }</td>
<td>${pr.getPrice()}</td>
<td><form  action='buyProduct'>
<input type='number' name='buy' value='${pr.getId() }' hidden='true'/>
<input type='number' name='quantity' id="buy1"  hidden='true'/>
<button  onclick="getQuantity()">BUY</button></form>
<form action='AddToWishList' ><button name='wishList' value='${pr.getId() }'>ADD TO WISHLIST</button></form>
<form action='AddToCart' ><button name='cart' value='${pr.getId() }'>ADD TO CART</button></form></td></tr>
</c:forEach>
</table>
</c:when>
<c:otherwise>
<h3>${msg}</h3>
</c:otherwise>
</c:choose>
</c:otherwise>
</c:choose> 
</body>
</html>