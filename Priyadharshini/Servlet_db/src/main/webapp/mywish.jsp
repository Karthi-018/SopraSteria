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
<%@ include file="customerlogin.jsp" %>
<h1>My Wishlist</h1>
<%=request.getAttribute("msg") %>
<% ResultSet rs = (ResultSet) request.getAttribute("rs"); 
if(rs!=null)
{%>
 <table border="1"><tr><th>product_name</th><th>product_price</th></tr>
 <% while(rs.next())
	 {
	 %>
	 <tr><td><%= rs.getString(1)%></td><td><%= rs.getInt(2) %></td>
	 <td>
                <form action='Buy'>
                    <button type="submit" name="buy" value="<%= rs.getString(1) %>">Buy</button>
                </form>
                <form action='AddToCart'>
                    <button type="submit" name="cart" value="<%= rs.getString(1) %>">AddtoCart</button>
                </form>
                <form action='Remove'>
                    <button type="submit" name="remove" value="<%= rs.getString(1) %>">Remove</button>
                </form>
            </td>
        </tr>
  <%} %>      

 </table>
<%} %>

</body>
</html>