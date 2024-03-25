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
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
  	<a class="navbar-brand" href="#">
      <img height="50px" width="70px" src="logo.png" class="d-inline-block align-text-top">
    </a>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <form style="padding-right: 10px;" action="home">
        <button type="submit" class="btn btn-outline-primary">Home</button>
        </form>
        <form style="padding-right: 10px;" action="Create">
        <button type="submit" class="btn btn-outline-danger">Create</button>
        </form>
        <form style="padding-right: 10px;" action="View">
        <button type="submit" class="btn btn-outline-warning">View</button>
        </form>
        <form style="padding-right: 10px;" action="CustomerList">
        <button type="submit" class="btn btn-outline-success">CustomerList</button>
        </form>
        
        <form style="padding-left: 100px;" action="Search" class="d-flex" role="search">
        <input class="form-control me-2" type="search" name="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
      
      <form style="padding-left: 200px;" action="Start.jsp">
        <button type="submit" class="btn btn-outline-secondary">LogOut</button>
        </form>
       
      </ul>
    </div>
  </div>
</nav><br><br><br><br>
<center>
	<h1 class="display-4">${msg1}</h1>
	<h1 class="display-5">${msg2}</h1>
	<button type="button" class="btn btn-outline-danger display-1"><h1 class="display-1"> ${nopro}</h1></button>
	
</center>
</body>
</html>