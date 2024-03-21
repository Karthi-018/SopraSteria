<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
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

<center><%@ include file="AdminMenubar.jsp" %><br>
<h1>LIST OF PRODUCT</h1>
<% 
if(rs==null){
%>
<form action="ViewServlet" method="post">
<input type="Submit" value="Click here to view product list">
</form>
<%} %>

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
					+"</tr>");
	 		temp++;
	 		o.println("<tr>"
			+ "<td>"+ rs.getInt(1)+"</td>"
			+ "<td>"+ rs.getString(2)+" </td>"
			+ "<td>"+ rs.getInt(3)+"</td>"
			+ "<td>"+ rs.getInt(4)+"</td>"
			+ "<td><form action=\"EditServlet\" method=\"post\"><input type=\"hidden\" name=\"edit\"value="+rs.getInt(1)+">"
			+ "<input type=\"submit\" value=\"Edit\"></form></td>"
			+ "<td><form action=\"DeleteServlet\" method=\"post\"><input type=\"hidden\" name=\"del\"value="+rs.getInt(1)+">"
			+ "<input type=\"submit\" value=\"Delete\"></form></td></tr>");
		}
		out.println("</table></center>");
		
		rs=null;
}
if(temp==1)
	{ 
		temp=0;
	%>
	<center><h2 style="color:Red;">No Products Available</h2></center>	

<%  } %>

<%= request.getAttribute("msg")==null?"":request.getAttribute("msg") %>
</body>
</html>