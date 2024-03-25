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

<figure>
  <blockquote class="blockquote">
  <h1 class="display-4">Hello Customer,</h1>
  </blockquote>
  <figcaption class="blockquote-footer">
    Please Enter the Details
  </figcaption>
</figure>

<form class="row g-3" action="CustomerRegistration">
  <div class="col-md-6">
    <label for="inputEmail4" class="form-label">Email</label>
    <input type="email" name="email" class="form-control" id="inputEmail4">
  </div>
  <div class="col-md-6">
    <label for="inputPassword4" class="form-label">Password</label>
    <input type="password" name="password" class="form-control" id="inputPassword4">
  </div>
  
  <div class="row g-3">
  <div class="col">
    <input type="text" name="fname" class="form-control" placeholder="First name" aria-label="First name">
  </div>
  <div class="col">
    <input type="text" name="lname" class="form-control" placeholder="Last name" aria-label="Last name">
  </div>
</div>
  
  <div class="col-12">
    <label for="inputAddress" class="form-label">Address</label>
    <input type="text" class="form-control" id="inputAddress" placeholder="1234 Main St">
  </div>
  <div class="col-12">
    <label for="inputAddress2" class="form-label">Address 2</label>
    <input type="text" class="form-control" id="inputAddress2" placeholder="Apartment, studio, or floor">
  </div>
  <div class="col-md-6">
    <label for="inputCity" class="form-label">City</label>
    <input type="text" class="form-control" id="inputCity">
  </div>
  <div class="col-md-4">
    <label for="inputState" class="form-label">Gender</label>
    <select id="inputState" class="form-select">
      <option selected>Choose...</option>
      <option>Male</option>
      <option>Female</option>
      <option>Others</option>
    </select>
  </div>
  
  <div class="col-12">
    <button type="submit" class="btn btn-primary">Register</button>
  </div>
</form>

</body>
</html>