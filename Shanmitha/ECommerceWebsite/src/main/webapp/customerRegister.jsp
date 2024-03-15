
<!--<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<form action="CustomerRegisterServlet">
<h3><center>REGISTER</center></h3>
<label>Enter Name:  </label>
<input type="text" placeholder="Enter name" name="name"/><br><br>
<label>Create password:  </label>
<input type="password" placeholder="Enter password" name="psw"/><br><br>
<label>Confirm password: </label>
<input type="password" placeholder="Repeat password" name="psw-repeat"/><br><br>

<input type="submit" value="Submit" name="Submit"/>
<input type="reset" value="Reset"/>
<input type="submit" value="Login" name="Login"/><br><br>
</form>

</center>
</body>
</html>-->




<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="CustomerRegisterServlet">
<label>First Name:</label>
<input type="text" name="fname" placeholder="Enter your firstname"/><br><br>
<label>Last Name:</label>
<input type="text" name="lname" placeholder="Enter your lastname"/><br><br>
<label>E-mail:</label>
<input type="email" name="email" placeholder="Enter your E-mail"/><br><br>
<label>Password:</label>
<input type="password" name="pass" placeholder="Set your Password"/><br><br>
<label>DOB:</label>
<input type="date" name="dob" placeholder="DD-MM-YYYY"><br><br>
<label>Gender:</label>
<input type="radio" name="gender" value="Male"/>
<label>Male</label>
<input type="radio" name="gender" value="Female"/>
<label>Female</label><br><br>
<input type="submit" value="Register"/>
<input type="reset" value="Reset"/>
<input type="submit" value="Login" name="Login"/><br><br>
</form>
</body>
</html>