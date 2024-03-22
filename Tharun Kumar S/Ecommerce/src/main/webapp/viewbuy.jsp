<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center><%@include file= "custindex.jsp" %></center>
<h3 style = "text-align:center;">Editing the product</h3>

<%@ page import="java.util.*" %>
<%@ page import="edu.sopra.training.Ecommerce.model.Product_2" %>
<% Product_2 p=(Product_2)request.getAttribute("product"); %>

<form action ="ViewBuy" method="post">
<br><input type = "number" name = "id" value="<%=(int)p.getPid()%>"hidden="true"><br>
<label>Product Id</label><br><input type = "number" name = "id" value="<%=(int)p.getPid()%>" required disabled><br>
<label>Product Name</label><br><input type = "text" name = "pname" value="<%=p.getPname()%>" required disabled><br>
<label>Product Descp</label><br><input type = "text" name = "descp" value="<%=p.getDescp()%>" required disabled><br>
<label>Product Quantity</label><br><input type = "number" name = "quan" value="1" required min='1' max='<%=(int)p.getQuan()%>'><br><br>
<input type = "submit" name="method" value ="Buy">
<br>
</form>
<h1 style="color: red;">${err}</h1>

</body>
</html>