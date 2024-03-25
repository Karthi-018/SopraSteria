

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Buy</title>
</head>
<body>

<center>
<%@include file="custIndex.jsp" %></center><br>
<h3 style = "text-align:center;">Billing Page</h3><br><br>
<center>
<table class="table">
  <thead>
    <tr>
      <th scope="col">Product Name</th>
      <th scope="col">Price</th>
      <th scope="col">Confirm</th>
      <th scope="col">Quantity</th>
      <th scope="col">Buy</th>
      
    </tr>
  </thead>
  <tbody>
		<tr>
			
			<td>${products.getPname()}</td>
			<td>${products.getPprice()}</td>
			<form action="Buy2">
			<td><select name="confirm" class="form-select" aria-label="Default select example">
  				<option selected>Confirm</option>
 				 <option value="1">Yes</option>
  				<option value="2">No</option>
				</select>
			</td>
			<td>
				<input type="number" name="qty" placeholder="Enter quantity">
			</td>
			
			<td>
			<button type="submit" name="pid" value="${products.getPid()}" class="btn btn-secondary">Buy</button>
			</td>
			</form>
			
			
		</tr>
</tbody>
  
	
</center>
</table> 


</body>
</html>