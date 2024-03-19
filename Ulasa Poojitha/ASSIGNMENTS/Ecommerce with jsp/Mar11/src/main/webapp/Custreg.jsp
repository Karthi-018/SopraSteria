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
  <h1 style="test-align:center;">Customer Registration</h1>
  <%=request.getAttribute("msg")==null?"":request.getAttribute("msg") %>
  <form action="Custtable">
  <label>Customer Name</label>
<input type="text" name="cname" value=""placeholder="Enter your name"/><br><br>
<label>Email</label>
<input type="email" name="cemail" value=""placeholder="Enter your email"><br><br>
<label>Date of Birth</label>
<input type="date" name="cdob" value=""placeholder="Enter your DOB"><br><br>
<label>Password</label>
<input type="password" name="cpwd" value=""placeholder="Enter a Password"><br><br>
<input type="submit" name="option" value="Register">
  </form>
  </center>
</body>
</html>