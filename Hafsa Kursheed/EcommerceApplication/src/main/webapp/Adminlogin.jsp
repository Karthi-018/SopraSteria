<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Log in</title>
</head>
<body>
<center>
<h1>Login</h1><br><br>
<h3><%= request.getAttribute("msg")==null?"":request.getAttribute("msg") %></h3><br><br>

<form action="AdminLoginServlet"> 
	<label>Username: </label><input type="text" name="username" placeholder="Enter username"><br><br>
	<label>Password: </label><input type="password" name="pwd" placeholder ="Enter password"><br><br>
	<input type="submit" value="Log in"/>
</form>
</center>

</body>
</html>