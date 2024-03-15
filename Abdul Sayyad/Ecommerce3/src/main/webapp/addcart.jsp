<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center><%@include file= "cusmenu.jsp" %>
 <%= request.getAttribute("msg")==null?"":request.getAttribute("msg") %>
<form action = "addcart">
<input type = "number" name = "pid" placeholder = "Enter Product Name" value = "<%=request.getParameter("pid")==null?"":request.getParameter("pid")%>" hidden = "true"><br><br>
<label>Enter Quantity</label><br><input type = "number" name = "pquant" placeholder = "Enter Quantity" required><br><br>
<input type = "submit" value = "Add to Cart">
</center>
</form>
</body>
</html>