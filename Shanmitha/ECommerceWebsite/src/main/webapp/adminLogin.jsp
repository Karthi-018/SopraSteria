<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3><center>LOGIN</center></h3>
<center>
<form action="AdminLoginServlet" >
<label>USERNAME  </label>
<input type="text" placeholder="Enter Username" name="uname" required><br><br>
<label>PASSWORD  </label>
<input type="password" placeholder="Enter Password" name="psw" required><br><br>
<input type="submit"  value="login" name="login">
</form>
</center>
</body>
</html>