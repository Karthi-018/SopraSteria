<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Login Customer Page</h1>
<form action = "CustomerLogin">

<input type = "text" name = "customerName" value = "" placeholder = "Enter user name"/>
<br><br>
<input type = "password" name = "customerPass" value = "" placeholder = "Enter password">
<br><br>

<input type = "submit" name = "login" value = "LOGIN"/>
<input type = "reset" name = "reset" value = "RESET"/>

</form>
</body>
</html>