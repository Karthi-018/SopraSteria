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
		PrintWriter o=response.getWriter();%>

<center><%@ include file="CustomerMenubar.jsp" %><br>
<h1>Bill</h1>
</center>
<% 
int temp=0;
int pid=0;
	if(rs!=null)
	{	
		temp=1;		
		while(rs.next())
		{
			if(temp==1)
			{
				o.println("<center><br>"
						+ "<table style = 'border: 1px solid;'>"
						+"<tr>"
						+"<th>ProductID</th>"
						+"<th>ProductName</th>"
						+"<th>Quantity</th>"
						+"<th>Total Cost</th>"
						+"</tr>");
		 		temp++;
		 		pid=rs.getInt(1);
			}
	 		o.println("<tr>"
			+ "<td>"+ rs.getInt(1)+"</td>"
			+ "<td>"+ rs.getString(2)+" </td>"
			+ "<td>"+ request.getAttribute("totalQuantity")+"</td>"
			+ "<td>"+ (rs.getInt(3))*(Integer.parseInt(request.getAttribute("totalQuantity").toString()))+"</td>"
			+ "</tr>");
		}
		out.println("</table></center>");
		
		rs=null;
}
if(temp==1)
	{ 
		temp=0;
	
		o.println("<center><h2 style=\"color:Red;\">No Products Available</h2></center>");
  } %>
  
<%if(request.getAttribute("msg")==null){ %>
<center>
		<form action="BillServlet" method="post">
		<input type="hidden" name="pid" value=<%=pid %>>
		<input type="hidden" name="pquantity" value=<%=Integer.parseInt(request.getAttribute("totalQuantity").toString())%>>
		<input type="submit" value="Pay">
		</form></center>
<% } %>

<center>
<%= request.getAttribute("msg")==null?"":request.getAttribute("msg") %>
</center>
</body>
</html>