<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</head>
<body>
<% String msg=request.getAttribute("msg").toString();%>
<%=msg %>
<br><br><br><br><br><br><br>
<center><h1 class="display-4">Dear Customer,</h1></center><br><br>


<form action="LogReg" method="get">
<center>
<div class="col-12">
    <button type="submit" name="choice" value="login" class="btn btn-primary btn-lg">Login</button><br><br><br><br><br>
	<button type="submit" name="choice" value= "register" class="btn btn-secondary btn-lg">Register</button>
  </div>
</center>
</form>

</body>
</html>