
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</head>
<body>
<script type="text/javascript">	
	swal("Order Confirmed!!", "Thank You!!! Happy Shopping", "success").then(function() {window.location = "custIndex.jsp";});
</script>
</body>
</html>