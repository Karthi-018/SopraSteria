<%@page import ="java.sql.ResultSet"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>


<form action="finalbuy">

<label>PRODUCT :</label>
${product }<br><br>

<label>DESCRIPTION :</label>
${pDesc }<br><br>

<label>PRICE :</label>
${price }<br><br>

<lable>Quantity</lable>
  <input type="number" name="amt"><br>

<input type="hidden" name="buy" value="${proid }" ><br>
<input type="submit" value="buy"/><br>

</form>



<h2>${err}</h2>
</center>


</body>
</html>