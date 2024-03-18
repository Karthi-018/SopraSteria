<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
</head>
<body>
<%
	ServletContext c =getServletContext(); 
	String cname = (c.getAttribute("cName").toString());
%>
<center>
	<h1>Hi <%= cname %>, Welcome To Ecommerce Application</h1>
	<%@ include file = "Customermenubar.jsp" %>
</center>
</body>
</html>