<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center><%@include file= "adminmenu.jsp" %></center>
 <h3 style = "text-align:center;">Editing the product</h3>
 <center>
  <div class = "container"><div class = "col"> <%= request.getAttribute("msg")==null?"":request.getAttribute("msg") %></div></div>
 <fieldset>
 <legend>Product</legend>
 <form action = "Edit">
  <br><input type = "number" name = "pid" value="<%=request.getAttribute("pid") %>" required hidden="true"><br>
 <label>Product Id</label><br><input type = "number" name = "pid" value="<%=request.getAttribute("pid") %>" required disabled><br>
<label>Product Name</label><br><input type = "text" name = "pname" value="<%=request.getAttribute("pname") %>" required disabled><br>
<label>Product Desc</label><br><input type = "text" name = "pdesc" value="<%=request.getAttribute("pdesc") %>" required disabled><br>
<label>Product Quantity</label><br><input type = "number" name = "pquant" value="<%=request.getAttribute("pquant") %>" required><br>
<label>Product Price</label><br><input type = "number" name = "pprice" value="<%=request.getAttribute("pprice") %>" required><br><br>
<input type = "submit" name = "method" value = "Change">
<br>
 </form>
 </fieldset>
 </center>
</body>
</html>