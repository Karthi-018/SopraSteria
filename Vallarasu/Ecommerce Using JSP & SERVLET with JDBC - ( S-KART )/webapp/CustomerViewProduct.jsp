<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.*"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>table, th, td {
  border: 1px solid;
}
</style>
<body>
<% ResultSet rs=(ResultSet)request.getAttribute("resultset"); 
		PrintWriter o=response.getWriter(); %>

<center><%@ include file="CustomerMenubar.jsp" %><br>
<h1>LIST OF PRODUCT</h1>
<% 
int temp=0;
	if(rs!=null)
	{	
		temp=1;
		
		while(rs.next())
		{
			if(temp==1)
			o.println("<center><br>"
					+ "<table style = 'border: 1px solid;'>"
					+"<tr>"
					+"<th>ProductID</th>"
					+"<th>ProductName</th>"
					+"<th>Price</th>"
					+"<th>Quantity</th>"
					+"<th></th>"
					+"<th></th>"
					+"<th></th>"
					+"</tr>");
	 		temp++;
	 		o.println("<tr>"
			+ "<td>"+ rs.getInt(1)+"</td>"
			+ "<td>"+ rs.getString(2)+" </td>"
			+ "<td>"+ rs.getInt(3)+"</td>"
			+ "<td>"+ rs.getInt(4)+"</td>"
			+ "<td><form action=\"Buy.jsp\" method=\"post\"><input type=\"hidden\" name=\"buypid\"value="+rs.getInt(1)+"><input type=\"hidden\" name=\"buypname\"value="+rs.getString(2)+">"
			+ "<input type=\"submit\"  value=\"BUY\"></form></td>"
			+ "<td><form action=\"CartQuantity.jsp\" method=\"post\"><input type=\"hidden\" name=\"cartpid\"value="+rs.getInt(1)+"><input type=\"hidden\" name=\"cartpname\"value="+rs.getString(2)+">"
			+ "<input type=\"submit\"  value=\"AddToCart\"></form></td>"		
			+ "<td><form action=\"WishListQuantity.jsp\" method=\"post\"><input type=\"hidden\" name=\"wishlistpid\"value="+rs.getInt(1)+"><input type=\"hidden\" name=\"wishlistpname\"value="+rs.getString(2)+">"
			+ "<input type=\"submit\" value=\"AddToWishList\"></form></td></tr>");
		}
		out.println("</table></center>");
		
		rs=null;
}
if(temp==1)
	{ 
		temp=0;
	%>
<h2 style="color:Red;">No Products Available</h2>

<%  } %>

<%= request.getAttribute("msg")==null?"":request.getAttribute("msg") %>
</center>
</body>
</html>