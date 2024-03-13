<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
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
 <h3 style = "text-align:center;">Viewing the products</h3>
 <%! List<Integer> pids = new ArrayList<>(); List<String> pnames = new ArrayList<>();List<String> pdescs = new ArrayList<>();List<Integer> pquants = new ArrayList<>();List<Integer> pprices = new ArrayList<>(); %>
 <% pids = (ArrayList<Integer>)request.getAttribute("pids");%> 
<%   pnames = (ArrayList<String>)request.getAttribute("pnames");%>
  <%   pdescs = (ArrayList<String>)request.getAttribute("pdescs");%>
  <% pquants = (ArrayList<Integer>)request.getAttribute("pquants");%> 
  <% pprices = (ArrayList<Integer>)request.getAttribute("pprices");%> 
  <center>
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
   <%
   for(int i=0;i<pids.size();i++){
	   out.println("<tr>");
	   out.println("<td>"+pids.get(i)+"</td>");
	   out.println("<td>"+pnames.get(i)+"</td>");
	   out.println("<td>"+pdescs.get(i)+"</td>");
	   out.println("<td>"+pquants.get(i)+"</td>");
	   out.println("<td>"+pprices.get(i)+"</td>");
	   out.println("<td><form action = 'Delete'>");
	   out.println("<button name = 'pid' value = " + "'"+ pids.get(i)+"'"+ ">Delete</button><br></form>");
	   out.println("<form action = 'Search2'>");
	   out.println("<button name = 'pid' value = " + "'"+ pids.get(i)+"'"+ ">Edit</button><br></form></td>");
	   out.println("<tr>");
   }
   %>
  </tbody>
</table> 
</body>
</html>