<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 style="color: green; text-align: center;">${msg}</h1>

<h1>Enter student Details</h1>
<form action="Create">
<input type="text" name="sname" placeholder="Enter name" >
<input type="number" name="marks" placeholder="Enter marks">
<input type="submit">
</form>

</body>
</html>