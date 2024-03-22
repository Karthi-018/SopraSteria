<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<fieldset>
<legend>Login</legend>
<form action="login" method="post">
<h1>${err}</h1>
<table>
<tr>
<td><label>Login:</label></td>
<td><input type="text" name="admin"/><br><br></td>
</tr>
<tr>
<td><label>Password:</label></td>
<td><input type="text" name="passwrd"/><br><br></td>
</tr>
<tr>
<td><input type="submit" name="Submit" value="Submit"/></td>
</form>
<br><br>
</tr>
</table>

</fieldset>

</center>


</body>
</html>

</body>
</html>