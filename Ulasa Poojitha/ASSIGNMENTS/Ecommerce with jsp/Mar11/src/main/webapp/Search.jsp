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
<h1>Search the product</h1>
 
<form action="Search">
<label>Product_id</label>
<input type="text" name="pid" value=""placeholder="Enter product id"/>
<input type="submit" value="search"/><br><br>
<%



ResultSet resultSet = (ResultSet)request.getAttribute("resultSet");
out.println("<table border =\"1px\">"
		+ "<thead><tr>\r\n"
		+ " <th>Product Id</th>\r\n"
		+ " <th>Product Name</th>\r\n"
		+ " <th>Product Description</th>\r\n"
		+ " <th>Product Price</th>\r\n"
		+ " <th>Quantity</th>\r\n"
		+ "</tr> "
		+"</thead>"
		+"<tbody>");
if(resultSet!=null){
while(resultSet.next()){
   
    out.println("<tr>\r\n"
			+ " <td>"+resultSet.getInt(1)+"</td>\r\n"
			+ " <td>"+resultSet.getString(2)+"</td>\r\n"
			+ " <td>"+resultSet.getString(3)+"</td>\r\n"
			+ " <td>"+resultSet.getInt(4)+"</td>\r\n"
			+ " <td>"+resultSet.getInt(5)+"</td>\r\n"				
			+ "</tr>");

out.println("</tbody></table>");
}}
%>
</form>
</body>
</html>