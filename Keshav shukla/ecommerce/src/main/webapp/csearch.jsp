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

<form action="custsearch">
<label>search</label>
<input type="text" name="pname" placeholder="enter the product name"><br><br>
<input type="submit">


</form>

<% ResultSet rs=(ResultSet)(request.getAttribute("rs")); 
if(rs.next())
{ %>

		<table border="1">
		<tr><th>product_id</th><th>product_name</th><th>product_desc</th><th>product_quant</th><th>product_price</th></tr>
		
		        <tr>
		            <td><%=rs.getInt(1)%></td>
		            <td><%=rs.getString(2)%></td>
		            <td><%=rs.getString(3)%></td>
		            <td><%=rs.getInt(4)%></td>
		            <td><%=rs.getInt(5)%></td>
		            <td><form action="Ccart"><button type="submit" name="cart" value="<%=rs.getInt(1)%>" >add to cart</button></form></td>
                    <td><form action="wishlist"><button type="submit" name="delete" value="">add to wishlist</button></form></td>
                     <td><form action="buy"><button type="submit" name="delete" value="">Buy Now</button></form></td>
		        </tr>
	</table>
	
	<% }else { %>
	    <%= "product not found" %>
	<% } %>	
</body>
</html>