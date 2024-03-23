<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Log In</h2>
<form action="adminValidation">
<label>Username:</label>
<input type="text" name="username"/><br><br>
<label>Password:</label>
<input type="password" name="pass" /><br><br>
<input type="submit" value="LOG IN" /><br><br>
<button type="submit" name="signup" formaction="SignUp.jsp" >SIGN UP</button>
</form>
</body>
</html>