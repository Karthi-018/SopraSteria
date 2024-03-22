<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
<center><%@include file= "adminmenu.jsp" %></center>
<%! List<String> list = new ArrayList<>(); List<String> list1 = new ArrayList<>(); List<String> list2 = new ArrayList<>(); %>
 <% list = (ArrayList<String>)request.getAttribute("emaillist");%>
  <% list1 = (ArrayList<String>)request.getAttribute("emaillist1");%>
    <% list2 = (ArrayList<String>)request.getAttribute("emaillist2");%>
  
 
  <center>
  <table class="table">
  <thead>
    <tr>
      <th scope="col">Customer Email</th>
            <th scope = "col"> Status</th>
      
      <th scope = "col"> Action</th>
     
    </tr>
  </thead>
   <tbody>
   <%
   for(int i=0;i<list.size();i++){
	   out.println("<tr>");
	   out.println("<td>"+list.get(i)+"</td>");
	   out.println("<td style = 'color:blue'>New User</td>");
	   out.println("<td><form action = 'approvelogin'>");
	   out.println("<button  class='btn btn-primary' name = 'email' value = " + "'"+ list.get(i)+"'"+ ">Activate</button><br></form></td>");
   }
   for(int i=0;i<list1.size();i++){
	   out.println("<tr>");
	   out.println("<td>"+list1.get(i)+"</td>");
	   out.println("<td style = 'color:green' >Active</td>");
	   out.println("<td><form action = 'disapprovelogin'>");
	   out.println("<button class='btn btn-primary' name = 'email' value = " + "'"+ list1.get(i)+"'"+ ">De-Activate</button><br></form></td>");
   }
   for(int i=0;i<list2.size();i++){
	   out.println("<tr>");
	   out.println("<td>"+list2.get(i)+"</td>");
	   out.println("<td style = 'color:red'>In-Active</td>");
	   out.println("<td><form action = 'approvelogin'>");
	   out.println("<button  class='btn btn-primary' name = 'email' value = " + "'"+ list2.get(i)+"'"+ ">Activate</button><br></form></td>");
	   out.println("</tr>");

   }
  
   %>
  </tbody>

</center>  

</body>
</html>