<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>customer login/register</title>
</head>
<body>
<center>
 <form action="userLogin">
        <label for="userid">User ID:</label>
        <input type="text" id="userid" name="userid" required><br><br>
        
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>
        
        <input type="submit" value="login">
        
    </form>
    <form action="userRegister.jsp">
    <input type="submit" value="new user? register">
    </form>
    </center>

</body>
</html>