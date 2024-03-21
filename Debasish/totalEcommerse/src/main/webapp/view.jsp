<%@page import ="java.sql.ResultSet"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<%@ include file="userMenubar.jsp" %>
<br><br>
  
<%
ResultSet resultSet = (ResultSet)request.getAttribute("resultSet");
if(resultSet!=null){
	out.println("<table border =\"1px\">"
    		+ "<thead><tr>\r\n"
			+ " <th>Product Id</th>\r\n"
			+ " <th>Product Name</th>\r\n"
			+ " <th>Product Description</th>\r\n"
			+ " <th>Quantity</th>\r\n"
			+ " <th>Price</th>\r\n"
			+ " <th>Action</th>\r\n"
			+ " <th>CART</th>\r\n"
			+ " <th>WISHLIST</th>\r\n"
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
		    + " <td><form action=\"buy\"><button type=\"submit\"name=\"buy\" value=\""+resultSet.getInt(1)+"\">BUY</button></form></td>\r\n"
		    + " <td><form action=\"cart\"><button type=\"submit\"name=\"cart\" value=\""+resultSet.getInt(1)+"\">CART</button></form></td>\r\n"
		    + " <td><form action=\"wish\"><button type=\"submit\"name=\"wish\" value=\""+resultSet.getInt(1)+"\">WISHLIST</button></form></td>\r\n"
			+ "</tr>");
}
out.println("</tbody></table>");
}

%>
</center>
</body>
</html>