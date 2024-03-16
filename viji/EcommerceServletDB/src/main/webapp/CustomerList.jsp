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
<center><%@ include file="header.jsp" %></center>
<sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost:3306/ECommerce" user="root" password="root" />
<sql:query var="rs" dataSource="${db }">
	select * from customer;
</sql:query>
<table>
<tr>
<td>FIRST NAME</td>
<td>LAST NAME</td>
<td>EMAIL</td>
<td>DOB</td>
<td>GENDER</td>
<td>STATUS</td>
<td>ACTION</td>
</tr>
<c:forEach var="c" items="${rs.rows }">
<tr>
<td>${c.fname }</td>
<td>${c.lname }</td>
<td>${c.email }</td>
<td>${c.dob }</td>
<td>${c.gender }</td>
<td>${c.activeState }</td>
<c:choose>
<c:when test="${c.activeState=='inactive'}">
<td><form action='ActivateCustomerServlet' ><button name='username' value='${c.email }'>Activate</button></form></td>
</c:when>
<c:otherwise>
<td><form action='ActivateCustomerServlet' ><button name='username' value='${c.email }'>InActivate</button></form></td>
</c:otherwise>
</c:choose>
</tr>
</c:forEach>
</table>

</body>
</html>