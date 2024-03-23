<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
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
<tr><th>PRODUCT NAME</th>
<th>DESCRIPTION</th>
<th>PRICE</th>
<th>QUANTITY</th>
<th>ACTION</th></tr>
<c:forEach var="pr" items="${cart}">
<tr><td>${pr.getProductName() }</td>
<td>${pr.getDescrption() }</td>
<td>${pr.getPrice() }</td>
<td>${pr.getpQuantity() }
<td><form action='DeleteCart' ><button name='delete' value='${pr.getProductId() }'>DELETE</button></form>
<form  action='buyProduct'><input type="number" name="quantity" value='${pr.getpQuantity()}' hidden="true"/><button type="submit" name='buy' value='${pr.getProductId() }'>BUY</button></form>
<form action='AddToWhishlistAndDelete' ><button name='wishList' value='${pr.getProductId() }'>MOVE TO WISHLIST</button></form>
</td>
</tr>
</c:forEach>
</table>
</c:when>
<c:otherwise>
<h2>${msg}</h2>
</c:otherwise>
</c:choose>
</body>
</html>