<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<center>
<h1>Register</h1>
<fieldset style="width:150px;">
<legend>Register</legend>
<form action="RegisterServlet" method="post">
<table>
<tr><td><label>UserName</label></td><td><input type="text" name="uname" value=""></td></tr>
<tr><td><label>Password</label></td><td><input type="text" name="password" value=""></td></tr>
</table>
<input type="Submit" name="" value="SignUp">
<input type="Reset"><br>
<a href="Login.jsp">Login.</a>
</form>
</fieldset>
<%= request.getAttribute("msg")==null?"":request.getAttribute("msg") %>
</center>


</body>
</html>