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
{ %>
	<table border="1">
	<tr>
		<th>product name</th>
		<th>product desc</th>
		<th>product quantity</th>
		<th>product price</th>
		<th>Remove from cart</th>
		<th>Move To Wishlist</th>
	</tr>
	<%do
	{ %>
		
	
	<tr>
		<td><%=rs.getString(1)%></td>
		<td><%=rs.getString(2) %></td>
		<td><%=rs.getString(3) %></td>
		<td><%=rs.getString(4) %></td>
		
		<td><form action="editfetch"><button type="submit" name="edit1" value="<%=rs.getString(1)%>">Remove</button></form></td>
        <td><form action="wishlistmain"><button type="submit" name="wish" value="<%=rs.getString(1)%>">Move</button></form></td>
            </tr>
		
	<%}while(rs.next());%>
	</table>
	<%} %>
	
</body>
</html>
