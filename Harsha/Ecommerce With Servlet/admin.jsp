<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Login to the account</h1>
<%=request.getAttribute("msg") %>
<form action="Admin">
<input type="text" name="username" value="Enter the username"><br>
<input type="password" name="pass" value="Enter the password"><br>
<input type="submit" name="submit" value="Login">
</form>

</body>
</html>