<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ page import="javax.servlet.ServletRequest" %>
<%@ page import=" edu.steria.training.SpringMVCDemo.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>${msg}</h3>
<h2>Log In</h2>
<form action="Validation">
<label>Username:</label>
<input type="text" name="username"/><br><br>
<label>Password:</label>
<input type="password" name="pass" /><br><br>
<input type="submit" value="LOG IN" /><br><br>
<button formaction="Registration.jsp" type="submit" name="signup" >SIGN UP</button></form>
</form>
</body>
</html>