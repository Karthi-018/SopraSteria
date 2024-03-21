<%@page import ="java.sql.ResultSet"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@ include file="Menubar.jsp" %>
<h4>Listing the products</h4>
 
<%
ResultSet resultSet = (ResultSet)request.getAttribute("resultSet");
if(resultSet!=null){
	out.println("<table border =\"1px\">"
    		+ "<thead><tr>\r\n"
			+ " <th>Product Id</th>\r\n"
			+ " <th>Product Name</th>\r\n"
			+ " <th>Product Description</th>\r\n"
			+ " <th>Quantity</th>\r\n"
			+ " <th>Product Price</th>\r\n"
			+ " <th>Delete</th>\r\n"
			+ " <th>Edit</th>\r\n"
			+ "</tr> "
			+"</thead>"
			+"<tbody>");
while(resultSet.next()){
	out.println("<tr>\r\n"
			+ " <td>"+resultSet.getInt(1)+"</td>\r\n"
			+ " <td>"+resultSet.getString(2)+"</td>\r\n"
			+ " <td>"+resultSet.getString(3)+"</td>\r\n"
			+ " <td>"+resultSet.getInt(4)+"</td>\r\n"
			+ " <td>"+resultSet.getInt(5)+"</td>\r\n"	
		    + " <td><form action=\"Delete\"><button type=\"submit\"name=\"delete\" value=\""+resultSet.getInt(1)+"\">DELETE</button></form></td>\r\n"
		    + " <td><form action=\"Editsearch\"><button type=\"submit\"name=\"edit\" value=\""+resultSet.getInt(1)+"\">EDIT</button></form></td>\r\n"
			+ "</tr>");
 
}
out.println("</tbody></table>");
}

%>

</body>

</body>
</html>