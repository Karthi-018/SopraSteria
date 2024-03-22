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
<center><%@include file="custhome.jsp"%></center>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="edu.sopra.training.Ecommerce.model.Cart_1" %>
<h1 style="color: red;">${err}</h1>
<%
boolean flag=true;
List<Cart_1> rs=(List<Cart_1>)request.getAttribute("list");%>
<h1>Hello.Here is Your Cart!!!</h1>

<table>
<table class="table">
<thead>
<tr>

<th scope="col">Product Name</th>
<th scope="col">Description</th>
<th scope="col">Quantity</th>
<th scope="col">Price</th>
<th scope="col">Add To Cart</th>
<th scope="col">Delete</th>
<th scope="col">Buy</th>

 </tr>
</thead>
<% 
if(rs!=null)
		{
	  for(Cart_1 s:rs) { %>
<tbody>
 <tr>
<th scope="row"><%=s.getPname()%></th>
<td><%=s.getDescp()%></td>
<td><%=s.getQuant()%></td>
<td><%=s.getPrice()%></td>
<td><form action='EditCartQuantity'><button name='id' value='<%= s.getPid()%>'>Edit Quantity</button></form>
<td><form action='CartDelete'><button name='id' value='<%= s.getPid()%>'>Delete</button></form>
<td><form action='CartBuy' method="post"><button name='id' value='<%= s.getPid()%>'>Buy</button></form>
</tr>
</tbody>
	<%  }
		} %> 
</table>
</table>

</center>

<h1 style="color: green;">${buy}</h1>

</body>
</html>