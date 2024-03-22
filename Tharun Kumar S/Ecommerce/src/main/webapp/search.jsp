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
<center><%@include file="home.jsp"%></center>
<form action="Search" method="post">
<input type="text" name="pname" placeholder="Enter product to search"/>
<input type="submit" value="search"/>
</form>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="edu.sopra.training.Ecommerce.model.Product_2" %>
<h1>${pfounf}</h1>
<h1 style="color: red;">${pnotFound}</h1>
<%
boolean flag=true;
List<Product_2> rs=(List<Product_2>)request.getAttribute("list");%>

<table>
<table class="table">
<thead>
<tr>
<th scope="col">PID</th>
<th scope="col">Pname</th>
<th scope="col">Description</th>
<th scope="col">Quantity</th>
<th scope="col">Price</th>
 </tr>
</thead>
<% 
if(rs!=null)
		{
	  for(Product_2 s:rs) { %>
<tbody>
 <tr>
<th scope="row"><%=s.getPid()%></th>
<td><%=s.getPname()%></td>
<td><%=s.getDescp()%></td>
<td><%=s.getQuan()%></td>
<td><%=s.getPrice()%></td>
</tr>
</tbody>
	<%  }
		} %> 
</table>
</table>

</body>
</html>