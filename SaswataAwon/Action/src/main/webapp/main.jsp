<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>S-Karting</title>
</head>
<body>
<% String msg=request.getAttribute("msg").toString(); %>
<%=msg %>
<center>
<h1 class="display-4">Welcome To S-Karting</h1>
<h1 class="display-6">Mr. Admin</h1><br><br> 

<%@include file="menubar.jsp" %>
</center>

</body>
</html>