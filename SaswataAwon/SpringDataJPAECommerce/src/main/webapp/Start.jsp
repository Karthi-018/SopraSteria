<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</head>
<body>

<br><br><br>
<center><h1 class="display-5">S-Karting</h1>
<p class="lead">
  Shop Smart!! Live Stylishly!!
</p>
</center>
<br><br><br>
<form action="choice" method="get">
<center>
<div class="col-12">
    <button type="submit" name="choice" value="admin" class="btn btn-primary btn-lg">Admin</button><br><br><br><br><br>
	<button type="submit" name="choice" value= "customer" class="btn btn-secondary btn-lg">Customer</button>
  </div>
</center>
</form>


</body>
</html>