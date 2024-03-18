<%@page import="edu.sopra.training.SpringBootMVC.model.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<thead>
<tr>
<th>Student ID</th>
<th>Student Name</th>
<th>Student Marks</th>
</tr>
</thead>
<tbody>
<% List<Student> students = (List<Student>)request.getAttribute("students");
	for(Student s : students){
%>
<tr>
<td><%= s.getSid() %></td>
<td><%= s.getSname() %></td>
<td><%= s.getMarks() %></td>
</tr>
<% } %>


</tbody>
</table>



</body>
</html>