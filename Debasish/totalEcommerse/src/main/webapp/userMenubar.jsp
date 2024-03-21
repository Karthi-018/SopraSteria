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
<h3 style="test-align: center;">
Welcome User
</h3>
<form action="./userActionServlet" method="get">
<input type="submit" name="option" value="view">
<input type="submit" name="option" value="search">
<input type="submit" name="option" value="cart">
<input type="submit" name="option" value="wishlist">

</form>
</center>

</body>
</html>