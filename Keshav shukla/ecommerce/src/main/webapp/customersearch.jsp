<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%= request.getAttribute("msg")==null?"":request.getAttribute("msg") %>
	<form action="custsearch">
<label>search</label>
<input type="text" name="pname" placeholder="enter the product name"><br><br>
<input type="submit">


</form>

	

</body>
</html>