<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ page import="java.sql.*" %>  
<%@ page import="java.util.*" %>
<%@ page import=" edu.steria.training.SpringMVCDemo.Model.*" %>
<%@ page import=" edu.steria.training.SpringMVCDemo.Service.*" %>
<%@ page import=" edu.steria.training.SpringMVCDemo.Controllers.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center><%@ include file="header.jsp" %></center>
<c:set var="n" value="${flag}" ></c:set>
<c:choose>
<c:when test="${n==true }">
<table>
<tr>
<td>FIRST NAME</td>
<td>LAST NAME</td>
<td>USER NAME</td>
<td>EMAIL</td>
<td>DOB</td>
<td>GENDER</td>
<td>STATUS</td>
<td>ACTION</td>
</tr>
<c:forEach var="lis" items="${list}" >
<tr>
<td>${lis.getFname()}</td>
<td>${lis.getLname() }</td>
<td>${lis.getUsername() }</td>
<td>${lis.getEmail() }</td>
<td>${lis.getDob() }</td>
<td>${lis.getGender() }</td>
<td>${lis.getStatus() }</td>
<c:choose>
<c:when test="${lis.getStatus()=='InActive'}">
<td><form action='ActivateCustomer' ><button name='username' value='${lis.getUsername() }'>Activate</button></form></td>
</c:when>
<c:otherwise>
<td><form action='ActivateCustomer' ><button name='username' value='${lis.getUsername() }'>InActivate</button></form></td>
</c:otherwise>
</c:choose>
</tr>
</c:forEach>
</table>
</c:when>
<c:otherwise>
<h3>${msg}</h3>
</c:otherwise>
</c:choose>
</body>
</html>