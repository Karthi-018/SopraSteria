<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Log in</title>
</head>
<body>
<form action = "custregister" method = "post">
<fieldset>
<legend>Log In</legend>
<label>Email</label><br><input type = "email" name = "uemail" placeholder = "Enter Email" required><br><br>
<label>password</label><br><input type = "password" name = "pass" placeholder = "Enter password" required><br><br>
<input type = "submit" name= "method" value = "login">
</fieldset>
</form>
</body>
</html>