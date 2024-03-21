<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=request.getAttribute("msg") %>
<h1>Logging in as Customer</h1>
<form action="LoginValidate">
<input type="text" name="username" value="username"><br>
<input type="email" name="email" value="mail"><br>
<input type="password" name="password" value="password"><br>
<input type="submit" name="submit" value="Login">
</form>
</body>
</html>