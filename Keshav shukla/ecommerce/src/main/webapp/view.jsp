<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import ="java.sql.ResultSet"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<label>"welcome to shukla kart"</label><br><br>

<%
ResultSet rs=(ResultSet)request.getAttribute("rs"); 
if(rs.next())
{
%>
<table border="1">
<tr><th>product_id</th><th>product_name</th><th>product_desc</th><th>product_quant</th><th>product_price</th><th>view_desc</th><th>Delete_desc</th></tr>
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
            <td><form action="editfetch"><button type="submit" name="edit1" value="<%=rs.getInt(1)%>">edit</button></form></td>
            <td><form action="delete"><button type="submit" name="delete1" value="<%=rs.getInt(1)%>">delete</button></form></td>
            
        </tr>
 <%}}
%> 

</table>





</body>
</html>