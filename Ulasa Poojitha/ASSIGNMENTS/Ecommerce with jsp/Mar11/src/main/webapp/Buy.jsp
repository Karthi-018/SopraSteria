<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="Custactions.jsp" %>

<center>
<h1>Buying the product</h1>
<form action="Bought">
 
<label>PRODUCT :</label>
${pname }<br><br>
 
<label>DESCRIPTION :</label>
${desc}<br><br>
 
<label>PRICE :</label>
${price}<br><br>
 
<lable>Quantity</lable>
  <input type="number" name="amount"><br>
 
<input type="hidden" name="buy" value="${prid }" ><br>
<input type="submit" value="Buy"/><br>
 
</form>
 
 
 
<h2>${Sorry}</h2>
</center>
</body>
</html>