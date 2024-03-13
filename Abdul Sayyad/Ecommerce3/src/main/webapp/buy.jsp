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
<form action = "buy">
<label>Product Name</label><br><input type = "text" name = "pname" placeholder = "Enter Product Name" value = "<%=request.getParameter("pname")==null?"":request.getParameter("pname")%>" required><br><br>
<label>Enter Quantity</label><br><input type = "number" name = "pquant" placeholder = "Enter Quantity" required><br><br>
<input type = "submit" value = "buy">
</center>
</form>
</body>
</html>