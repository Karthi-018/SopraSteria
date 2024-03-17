<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MenuBar</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</head>
<body>


<form action="action">
<div style= "height: 38px; width: 129px" class="input-group flex-nowrap">
  <span class="input-group-text" id="addon-wrapping">@</span>
  <input type="submit" name="choice" value="create" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="addon-wrapping">
</div>
<div style="height: 38px; width: 129px" class="input-group flex-nowrap">
  <span class="input-group-text" id="addon-wrapping">@</span>
  <input type="submit" name="choice" value="search" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="addon-wrapping">
</div>
<div style="height: 38px; width: 129px" class="input-group flex-nowrap">
  <span class="input-group-text" id="addon-wrapping">@</span>
  <input type="submit" name="choice" value="list" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="addon-wrapping">
</div><br>

<button type="Submit" name="choice" value="LogOut" Style="align-items: baseline; ;" class="btn btn-secondary btn-lg">Log Out</button>


<!-- <input type="submit" name="choice" value="create"/>
<input type="submit" name="choice" value="search"/>
<input type="submit" name="choice" value="list"/> -->
</form> 
</body>
</html>