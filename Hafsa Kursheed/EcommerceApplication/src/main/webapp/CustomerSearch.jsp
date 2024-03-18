<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
table, th, td {
  border: 1px solid black;
}
</style>
<title>Search</title>
</head>
<body>
<center>

	<%@ include file = "Customermenubar.jsp" %>
	<br><br>
	<h1>SEARCH THE PRODUCT</h1>
	<form action="CustomerSearchServlet">
	
		<label>Enter Product Name to Search:</label><br><br>
		
		<input type="text" name="searchprod" placeholder="Product Name">
		
		<input type="submit" name="Search">
		
	</form>

	
<% 
			String msg = request.getAttribute("msg")== null? "":request.getAttribute("msg").toString(); 
			ResultSet rs = (ResultSet)(request.getAttribute("result"));
			if(msg.equals("exists"))
			{ 
%>
				<h3>PRODUCTS ARE</h3>
				<table>
				<tr>
					<th>PRODUCT NAME</th>
					<th>ADD TO WISHLIST</th>
					<th>ADD TO CART</th>
					<th>BUY PRODUCT</th>
					</tr>

				<% do{ %>
					<tr>
					<td><a href='ProductDetailsServlet?prodid=<%= rs.getInt(1)%>'><%=rs.getString(2)%></a></td>
					<!--  <td><form action ='ProductDetailsServlet'>
					<button type='submit' name='pname' value="<%=rs.getInt(1)%>"><%=rs.getString(2) %></button>
					</form></td>-->
					
					<td><form action ='AddWishlistServlet'>
					<button type='submit' name='wishprod' value="<%=rs.getInt(1)%>">Add</button>
					</form></td>
					
					<td><form action ='AddCartServlet'>
					<button type='submit' name='cartprod' value="<%=rs.getInt(1)%>">Add</button></form></td>
					
					<td><form action ='BuyProduct.jsp'>
					<button type='submit' name='buyprod' value="(<%=rs.getInt(1)%>+':'+<%=rs.getString(2)%>)">Buy</button>
					</form></td>
					</tr>
				<%  }	
				while(rs.next()); %>
				</table>

		<% 	}
			else if(msg.equals("notexists"))
			{ %>
			
				<h3>NO SUCH PRODUCT IS AVAILABLE</h3>
			<% }%>

</center>

</body>
</html>