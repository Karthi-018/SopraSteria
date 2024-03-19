<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.ResultSet" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
<center>
<%@ include file="Custactions.jsp" %><br><br>
<h1>Your Wishlist</h1>
<%ResultSet resultSet = (ResultSet)request.getAttribute("resultSet");

if(resultSet!=null){
	out.println("<table border =\"1px\">"
    		+ "<thead><tr>\r\n"
			+ " <th>Product Name</th>\r\n"
			+ " <th>Product Description</th>\r\n"
			+ " <th>Price</th>\r\n"
			+ " <th></th>\r\n"
			+ " <th></th>\r\n"
			+ "</tr> "
			+"</thead>"
			+"<tbody>");
while(resultSet.next()){
	out.println("<tr>\r\n"
			+ " <td>"+resultSet.getString(2)+"</td>\r\n"
			+ " <td>"+resultSet.getString(3)+"</td>\r\n"
			+ " <td>"+resultSet.getInt(4)+"</td>\r\n"	
			
		    + " <td><form action=\"Deletewish\"><button type=\"submit\"name=\"pid\" value=\""+resultSet.getInt(1)+"\">Remove</button></form></td>\r\n"
		    + " <td><form action=\"Wishtocart \"><button type=\"submit\"name=\"pid\" value=\""+resultSet.getInt(1)+"\">Move to Cart</button></form></td>\r\n"
			+ "</tr>");
}
out.println("</tbody></table>");
}
 
%><br><br>
</center>
</body>
</html>