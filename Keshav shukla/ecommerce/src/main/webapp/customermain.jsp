<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%= request.getAttribute("msg")==null?"":request.getAttribute("msg") %>
<form action="cusactivation">
<label><h3>User Id</h3></label>
<input type="text" name="username">
<label><h3>Password</h3></label>
<input type="password" name="pw"><br><br>
<button type="submit" name="login">login</button><br><br>
<a href="register.jsp">newuser?Register</a>
</form>

</body>
</html>