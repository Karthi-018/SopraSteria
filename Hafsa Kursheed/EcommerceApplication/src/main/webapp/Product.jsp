<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product</title>
</head>
<body>
<center>
<h1>PRODUCT DETAILS</h1>
</center>
<h3>PRODUCT NAME: </h3>
<%= request.getAttribute("pname") %>
<br><br>
<b><h3>PRODUCT DESCRIPTION: </h3></b>
<%= request.getAttribute("pdesc") %>
<br><br>
<h3>PRODUCT PRICE: </h3>
<%= request.getAttribute("pprice") %>
<%	String product = request.getAttribute("pid")+":"+request.getAttribute("pname"); %>
<br><br><br><br>

<form action ='AddWishlistServlet'>
	<button type='submit' name='wishprod' value="<%= request.getAttribute("pid")%>">Add To WishList</button>
</form>
<br>
<form action ='AddCartServlet'>
	<button type='submit' name='cartprod' value="<%= request.getAttribute("pid")%>">Add To Cart</button>
</form>
<br>
<form action ='BuyProduct.jsp'>
<button type='submit' name='buyprod' value="<%=product%>">Buy Product</button>
</form>
<br>
</body>
</html>