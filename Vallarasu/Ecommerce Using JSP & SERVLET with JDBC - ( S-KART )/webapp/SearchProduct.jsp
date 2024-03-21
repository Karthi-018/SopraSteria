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
<style>table, th, td {
  border: 1px solid;
}
</style>
</head>
<body>
<center><%@ include file="AdminMenubar.jsp" %><br>
<h1>SEARCH THE PRODUCT</h1>
<fieldset style="width:500px;">
<legend>Product</legend>
<form action="SearchServlet" method="post">
<table>
	<tr>
		<td><input type="text" name="search" value="" placeholder="Enter the product Name"></td>
		<td><input type="Submit" value="Search"></td>
	</tr>
</table>
</form>
</fieldset></center>
<br><br>
<% ResultSet rs=(ResultSet)request.getAttribute("resultset"); 
		PrintWriter o=response.getWriter();
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
					+"</tr>");
	 		temp++;
	 		o.println("<tr>"
			+ "<td>"+ rs.getInt(1)+"</td>"
			+ "<td>"+ rs.getString(2)+" </td>"
			+ "<td>"+ rs.getInt(3)+"</td>"
			+ "<td>"+ rs.getInt(4)+"</td></tr>");
		}
		out.println("</table></center>");
		
		rs=null;
}
	if(temp>1)
	{ 
		temp=0;
	%>
	<center><h2 style="color:Green;">The Product is Available</h2></center>
<%	}
	else if(temp==1)
	{ 
		temp=0;
	%>
	<center><h2 style="color:Red;">The Product is Not Available</h2></center>	
<%  } %>


<!--  < %= request.getAttribute("msg")==null?"":request.getAttribute("msg") %>-->


</body>
</html>