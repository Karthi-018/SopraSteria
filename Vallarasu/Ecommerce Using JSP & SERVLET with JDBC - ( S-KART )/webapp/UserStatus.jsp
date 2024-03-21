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

<center><%@ include file="AdminMenubar.jsp" %><br>
<h1>LIST OF USERS</h1>

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
					+"<th>UserName</th>"
					+"<th>Status</th>"
					+"<th></th>"
					+"<th></th>"
					+"</tr>");
	 		temp++;
	 		o.println("<tr>"
			+ "<td>"+ rs.getString(1)+"</td>"
			+ "<td>"+ rs.getString(2)+" </td>"
			+ "<td><form action=\"UserStatusServlet\" method=\"post\"><input type=\"hidden\" name=\"activate\"value="+rs.getString(1)+">"
			+ "<input type=\"submit\" name=\"status\" value=\"ACTIVATE\"></form></td>"
			+ "<td><form action=\"UserStatusServlet\" method=\"post\"><input type=\"hidden\" name=\"de-activate\"value="+rs.getString(1)+">"
			+ "<input type=\"submit\" name=\"status\" value=\"DE-ACTIVATE\"></form></td></tr>");
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