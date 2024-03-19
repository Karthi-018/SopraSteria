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
<%@ include file="Menubar.jsp" %>
<center>
<h1 style="test-align:center;">Customers List</h1>
<form>
<%
ResultSet resultSet = (ResultSet)request.getAttribute("resultSet");
if(resultSet!=null){
    out.println("<table border =\"1px\">"
    		+ "<thead><tr>\r\n"
    	    + " <th>Customer id</th>\r\n"
			+ " <th>Customer Name</th>\r\n"
			+ " <th>Email</th>\r\n"
			+ " <th>DOB</th>\r\n"
			
		    + " <th>Status</th>\r\n"
			+ "</tr> "
			+"</thead>"
			+"<tbody>");
while(resultSet.next())
{

    out.println("<tr>\r\n"
    		+ " <td>"+resultSet.getInt(1)+"</td>\r\n"
			+ " <td>"+resultSet.getString(2)+"</td>\r\n"
			+ " <td>"+resultSet.getString(3)+"</td>\r\n"
			+ " <td>"+resultSet.getString(4)+"</td>\r\n"
				
			+ " <td>"+resultSet.getString(6)+"</td>\r\n");
    if(resultSet.getString(6).equals("Inactive"))
    {
		out.println("<td><form action=\"UserStatus\"><button type=\"submit\"name=\"status\" value=\""+resultSet.getString(3)+"\">Activate</button></form></td>\r\n");
    }
    else
    {
    	out.println("<td><form action=\"UserStatus\"><button type=\"submit\"name=\"status\" value=\""+resultSet.getString(3)+"\">In-activate</button></form></td>\r\n");
    }
	    
	out.println("</tr>");


}
out.println("</tbody></table>");
}
%>
</form>
</center>
</body>
</html>