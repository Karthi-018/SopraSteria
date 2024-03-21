<%@page import ="java.sql.ResultSet"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Editing the product</h1>
<%
ResultSet resultSet = (ResultSet)request.getAttribute("resultSet");
if(resultSet!=null && resultSet.next()) {
%>
<form action="finalUpdate">
<label>Product_id</label>
<input type="text" name="pid" value="<%= resultSet.getInt(1) %>"placeholder="Enter product id"/ disable><br><br>
<label>Product_name</label>
<input type="text" name="pname" value="<%= resultSet.getString(2)%>"placeholder="Enter product name" disable><br><br>
<label>Product_description</label>
<input type="text" name="pdesc" value="<%= resultSet.getString(3)%>"placeholder="Enter product description" disable><br><br>
<label>Product_quantity</label>
<input type="text" name="pqty" value="<%= resultSet.getInt(4)%>"placeholder="Enter quantity"><br><br>
<label>Product_price</label>
<input type="text" name="pprice" value="<%= resultSet.getInt(5)%>"placeholder="Enter product price"><br><br>
<input type="submit" name="add" value="add">
</form>
<% } %>

</body>
</html>