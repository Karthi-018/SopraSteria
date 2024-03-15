<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="javax.servlet.ServletRequest" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center><%@ include file="menubar.jsp" %></center>
 
<%
ResultSet rs=(ResultSet)request.getAttribute("resultSet");
%>
 
<table class="table">
  <thead>
    <tr>
      <th scope="col">First Name</th>
      <th scope="col">Last Name</th>
      <th scope="col">D.O.B</th>
      <th scope="col">Gender</th>
      <th scope="col">Status</th>
    </tr>
  </thead>
 
<%
if(rs!=null) {
    if(rs.next()) {
        do {
%>
 
  <tbody>
    <tr>
      <td><%= rs.getString(2) %></td>
      <td><%= rs.getString(3) %></td>
      <td><%= rs.getString(6) %></td>
      <td><%= rs.getString(7) %></td>
      <td>
        <form action='AdminValidationServlet'>
          <button name='validate' value="<%= rs.getString(4) %>">Validate</button>
        </form>
      </td>
    </tr>
  </tbody>
 
<%
        } while(rs.next());
    }
}
%>
 
</table>
 
</body>
</html>