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

<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="edu.sopra.training.Ecommerce.model.Cust_2"%>
<%List<Cust_2> rs=(List<Cust_2>)request.getAttribute("list");%>

<table class="table">
<thead>
<tr>
<th scope="col">User_name</th>
<th scope="col">Status</th>
<th scope="col">Access/Edit</th>
</tr>
</thead>

<% if (!rs.isEmpty()){

for(Cust_2 s:rs){

 if(s.getStatus().equals("New")){%>
 
 <tbody>
 <tr>
<td><%=s.getUserName()%></td>
<td><%=s.getStatus()%></td>
<td><form action='CustAcc' method='post'><button name='status' value="<%=s.getUserName()%>" >Activate</button></form>
</tr>
</tbody>
<% } 
 else if(s.getStatus().equals("De-Active")){ %>
 
 <tbody>
 <tr>
<td><%=s.getUserName()%></td>
<td><%=s.getStatus()%></td>
<td><form action='CustAcc' method='post'><button name='status' value="<%=s.getUserName()%>" >Activate</button></form>
</tr>
</tbody>
<% } 
else{ %>
 <tbody>
 <tr>
<td><%=s.getUserName()%></td>
<td><%=s.getStatus()%></td>
<td><form action='CustAcc' method='post'><button name='status' value="<%=s.getUserName()%>" >De-Activate</button></form>
</tr>
</tbody>
<% }
}
}%>
</table>
</body>
</html>














