<%@page import ="java.sql.ResultSet"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>User Application</h4>
 
<%
ResultSet resultSet = (ResultSet)request.getAttribute("resultSet");
if(resultSet!=null){
	out.println("<table border =\"1px\">"
    		+ "<thead><tr>\r\n"
			+ " <th>Name</th>\r\n"
			+ " <th>Email</th>\r\n"
			+ " <th>Password</th>\r\n"
			+ " <th>Status</th>\r\n"
			+ " <th>change</th>\r\n"
			+ "</tr> "
			+"</thead>"
			+"<tbody>");
while(resultSet.next()){
	out.println("<tr>\r\n"
			+ " <td>"+resultSet.getString(1)+"</td>\r\n"
			+ " <td>"+resultSet.getString(2)+"</td>\r\n"
			+ " <td>"+resultSet.getInt(3)+"</td>\r\n"
			+ " <td>"+resultSet.getString(4)+"</td>\r\n"
		    + " <td><form action=\"changeStatus\"><button type=\"submit\"name=\"change\" value=\""+resultSet.getString(2)+"\">Change</button></form></td>\r\n"
			+ "</tr>");
 
}
out.println("</tbody></table>");
}

%>
</body>
</html>