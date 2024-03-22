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
<dialogue>
<fieldset>
<legend>Login</legend>
<form action="Custlogin" method="post">
<table>
<tr>
<td><label>Login:</label></td>
<td><input type="text" name="user"/><br><br></td>
</tr>
<tr>
<td><label>Password:</label></td>
<td><input type="password" name="passwrd"/><br><br></td>
</tr>
<tr>
<td><input type="submit" name="Submit" value="Submit"/></td>
</form>
<td><form action="CustReg" method='get'><button name='SignUp'>SignUp</button></form></td><br><br>
</tr>
</table>

</fieldset>
</dialogue>
 
 <h1 style="color: red;">${err}</h1>

 </center>

</body>
</html>