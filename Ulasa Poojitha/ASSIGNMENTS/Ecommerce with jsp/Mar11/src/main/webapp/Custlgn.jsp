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
  <h1 style="test-align:center;">Customer Login</h1>
   <%=request.getAttribute("msg")==null?"":request.getAttribute("msg") %>
   
 <form action="Custaccess">
  <label>Username</label>
  <input type="text" name="cuname" value=""placeholder="Enter Username:"/><br><br>
  <label>Password</label>
  <input type="password" name="cpwd" value=""placeholder="Enter password:"><br><br>
  <input type="submit" name="in" value="Login">
</form>
</center>
</body>
</html>