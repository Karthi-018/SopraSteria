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
<c:set var="type" value="${type }"></c:set>
<c:choose>
<c:when test="${type=='Admin' }">
<center><%@ include file="header.jsp" %></center>
<form  action ="Search">
<input type="text" name="search" placeholder="Enter product to search"/>
<input type="submit" value="search" />
</form>
<c:set var="n" value="${flag}" ></c:set>
<c:choose>
<c:when test="${ n==true}">
<table>
<tr><th>PRODUCT ID</th>
<th>PRODUCT NAME</th>
<th>DESCRIPTION</th>
<th>PRICE</th>
<th>QUANTITY</th></tr>
<c:set var="pr" value="${res}" ></c:set>
<tr><td>${pr.getId()}</td>
<td>${pr.getPname() }</td>
<td>${pr.getDescription() }</td>
<td>${pr.getPrice() }</td>
<td>${pr.getQuantity()}</td></tr>
</table>
</c:when>
<c:otherwise>
<h3>${msg}</h3>
</c:otherwise>
</c:choose>
</c:when>
<c:otherwise>
<center><%@ include file="CustomerHeader.jsp" %></center>
<form action ="ProductSearch">
<input type="text" name="search" placeholder="Enter product to search"/>
<input type="submit" value="search" name="act"/>
</form>
<c:set var="n" value="${flag}" ></c:set>
<c:choose>
<c:when test="${ n==true}">
<table>
<tr><th>PRODUCT NAME</th>
<th>DESCRIPTION</th>
<th>PRICE</th></tr>
<c:set var="pr" value="${res}" ></c:set>
<tr>
<td>${pr.getPname() }</td>
<td>${pr.getDescription() }</td>
<td>${pr.getPrice() }</td></tr>
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