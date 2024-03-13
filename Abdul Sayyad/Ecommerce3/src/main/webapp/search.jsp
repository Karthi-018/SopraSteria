<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
<center><%@include file= "index.jsp" %></center>
 <h5 style = "text-align:center;">Searching the product</h5>
 <center>
  <%= request.getAttribute("msg")==null?"":request.getAttribute("msg") %>
 <form action = "Search">
<br><input type = "number" name = "pid" placeholder = "Enter product Id" required><br><br>
<input type = "submit" name = "method" value = "Search">
<br>
 </form>
 <table class="table">
  <thead>
    <tr>
      <th scope="col">Product Id</th>
      <th scope="col">Product Name</th>
      <th scope="col">Product Desc</th>
      <th scope="col">Product quant</th>
      <th scope="col">Product price</th>
      <th scope="col">Action</th>
      
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><%=request.getAttribute("pid")==null?"-":request.getAttribute("pid") %></td>
         <td><%=request.getAttribute("pname")==null?"-":request.getAttribute("pname") %></td>
         <td><%=request.getAttribute("pdesc")==null?"-":request.getAttribute("pdesc") %></td>
         <td><%=request.getAttribute("pquant")==null?"-":request.getAttribute("pquant") %></td>
         <td><%=request.getAttribute("pprice")==null?"-":request.getAttribute("pprice") %></td>
         <td><form action="Delete"><button name = "pid" value = "<%=request.getAttribute("pid")%>">Delete</button>
         </form><br><form action="Search2"><button name = "pid" value = "<%=request.getAttribute("pid")%>">Edit</button></form></td>
    </tr>
  </tbody>
</table>
 </center>
</body>
</html>