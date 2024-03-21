<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="menu.jsp" %><br><br>
<form action="search">
<label>search</label>
<input type="number" name="pid" placeholder="enter the product id">
<input type="submit">


</form>
<% 
ResultSet rs=(ResultSet)request.getAttribute("rs"); 
if(rs!=null)
{
%>
<table border="1">
<tr><th>product_id</th><th>product_name</th><th>product_desc</th><th>product_quant</th><th>product_price</th></tr>
<%
while(rs.next())
{
%>
        <tr>
            <td><%=rs.getInt(1)%></td>
            <td><%=rs.getString(2)%></td>
            <td><%=rs.getString(3)%></td>
            <td><%=rs.getInt(4)%></td>
            <td><%=rs.getInt(5)%></td>
        </tr>
 <%} %> 
</table>
 <%} %>
</body>
</html>