<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=request.getAttribute("msg") %>
<% ResultSet rs=(ResultSet)request.getAttribute("rs");
if(rs!=null)
{%>
 <table border="1">
    <tr>
        <th>firstname</th>
        <th>lastname</th>
        <th>email</th>
        <th>username</th>
        <th>pass</th>
        <th>phoneno</th>
        <th>status</th>
    </tr>
    <% while (rs.next()) { %>
        <tr>
            <td><%= rs.getString(1) %></td>
            <td><%= rs.getString(2) %></td>
            <td><%= rs.getString(3) %></td>
            <td><%= rs.getString(4) %></td>
            <td><%= rs.getString(5) %></td>
            <td><%= rs.getString(6) %></td>
            <td><%= rs.getString(7) %></td>
            <td>
                <form action='StatusValidate'>
                    <button type="submit" name="validate" value="<%= rs.getString(3) %>">Validate</button>
                </form>
            </td>
        </tr>
    <% } %>
</table>
   <% } %>

</body>
</html>