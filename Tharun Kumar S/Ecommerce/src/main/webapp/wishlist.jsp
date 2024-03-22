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
<%@ page import="edu.sopra.training.Ecommerce.model.WishList" %>
<h1 style="color: red;">${err}</h1>
<%
boolean flag=true;
List<WishList> rs=(List<WishList>)request.getAttribute("list");%>
<h1>Hello.Here is Your WishList!!!</h1>

<table>
<table class="table">
<thead>
<tr>

<th scope="col">Product Name</th>
<th scope="col">Price</th>
<th scope="col">Add To Cart</th>
<th scope="col">Delete</th>


 </tr>
</thead>
<% 
if(rs!=null)
		{
	  for(WishList s:rs) { %>
<tbody>
 <tr>
<th scope="row"><%=s.getPname()%></th>
<td><%=s.getPrice()%></td>
<td><form action='MoveCart'><button name='id' value='<%= s.getPid()%>'>Move to Cart</button></form>
<td><form action='WishDelete'><button name='id' value='<%= s.getPid()%>'>Delete</button></form>

</tr>
</tbody>
	<%  }
		} %> 
</table>
</table>

</center>

<h1 style="color: green;">${move}</h1>

</body>
</html>