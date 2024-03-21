<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center><%@ include file="CustomerMenubar.jsp" %><br>
<h2>How Many Quantity Do you Want to Add??</h2><br>
<br>
<form action="WishListServlet" method="post">
<input type="hidden" name="pid" value="<%= Integer.parseInt(request.getParameter("wishlistpid"))%>">
<table>
<tr><td><label>ProductName</label></td><td><input type="text" name="pname" value="<%= request.getParameter("wishlistpname")%>" Disabled></td></tr>
<tr><td><label>Quantity</label></td><td><input type="number" name="pquantity" value=""></td></tr>
</table>
<input type="submit" value="Add to Cart">
</form>
</center>

</body>
</html>