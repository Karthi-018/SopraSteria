<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>
<form action="RegisterCustomer">
	<center><h1>Register</h1>
	<h3><%= request.getAttribute("msg")==null?"":request.getAttribute("msg") %></h3><br><br>
	<label>First Name: </label><input type="text" name="firstname" placeholder="Enter your First Name" required><br><br>
	
	<label>Last Name: </label><input type="text" name="lastname" placeholder="Enter your Last Name" required><br><br>
	
	<label>Email: </label><input type="text" name="email" placeholder="Enter your Email" required><br><br>
	
	<label>Password: </label><input type="password" name="pwd" placeholder="Enter your password" required><br><br>
	
	<label>Date of Birth: </label><input type="date" name="dob" placeholder="Enter your DOB" required><br><br>
	
	<label>Gender:</label>
	
	<input type="radio" name="gender" value="Male" required>
	<label>Male</label>
	
	<input type="radio" name="gender" value="Female" required>
	<label>Female</label><br><br>
	
	<input type="submit" value="Register">
	
	<input type="reset" value="Reset"><br><br>
	
	Already exists: <a href='Customerlogin.jsp'>Login</a>
	</center>
</form>
</body>
</html>