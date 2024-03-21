<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="java.sql.ResultSet" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
ResultSet rs=(ResultSet)request.getAttribute("result");

%>
<table border='1'><tr><th>customer_id</th><th>first_name</th><th>Last_name</th><th>email</th><th>status</th></tr>
<%while(rs.next()){ %>
<tr>           
            <td><%=rs.getInt(1)%></td>
            <td><%=rs.getString(2)%></td>
            <td><%=rs.getString(3)%></td>
            <td><%=rs.getString(4)%></td>
            <td><%=rs.getString(6)%></td>
</tr>
<%} %>            
</table>


</body>
</html>