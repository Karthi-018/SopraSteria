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
<h3><%= request.getAttribute("msg")==null?"":request.getAttribute("msg") %></h3><br><br>
<h1>Login</h1>

<form action="CustomerLoginServlet"> 
	
	<label>Email Id: </label><input type="text" name="email" placeholder="Enter email id"><br><br>
	
	<label>Password: </label><input type="password" name="pwd" placeholder ="Enter password"><br><br>
	
	<input type="submit" value="Log in"/><br><br>
	
	New User: <a href='register.jsp'>Register</a>
	
</form>
</center>
</body>
</html>