<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
</head>
<body>
<form action = "cusregister" method = "post">
<fieldset>
<legend>Registration</legend>
<label>First Name</label><br><input type = "text" name = "fname" placeholder = "Enter First Name" required><br><br>
<label>Last Name</label><br><input type = "text" name = "lname" placeholder = "Enter Last Name" required><br><br>
<label>Email</label><br><input type = "email" name = "uemail" placeholder = "Enter Email" required><br><br>
<label>Password</label><br><input type = "password" name = "passw" placeholder = "Enter Password" required><br><br>
<label>DOB</label><br><input type = "date" name = "dob"  required><br><br>
<label>Gender</label>
<input type="radio" id="add" name="gender" value="male" required>
  <label for="add">Male</label>
<input type="radio" id="sub" name="gender" value="female" required>
  <label for="sub">Female</label><br>
<br>
<input type = "submit"  name = "method" value = "Register">
</fieldset>
</form>


</body>
</html>