<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="javax.servlet.ServletRequest" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f8f9fa;
    }

    table {
        width: 80%;
        margin: 20px auto;
        border-collapse: collapse;
    }

    th, td {
        border: 1px solid #dee2e6;
        padding: 8px;
        text-align: left;
    }

    th {
        background-color: #007bff; /* Blue background for headers */
        color: #fff;
    }

    .delete-button, .edit-button {
        padding: 5px 10px;
        border: 1px solid #ccc; /* Remove blue border */
        border-radius: 3px;
        background-color: #fff; /* White background */
        color: #007bff; /* Blue text color */
        cursor: pointer;
    }

    .delete-button:hover, .edit-button:hover {
        background-color: #f8f9fa; /* Change hover background color */
        color: #0056b3; /* Change hover text color */
    }
</style>
</head>
<body>
<center><%@ include file="menubar.jsp" %></center>
 
<%
ResultSet rs=(ResultSet)request.getAttribute("resultSet");
 
        out.println("<table>"
                    + "<thead>"
                    + "    <tr>"
                    + "      <th scope=\"col\">Product ID</th>"
                    + "      <th scope=\"col\">Product Name</th>"
                    + "      <th scope=\"col\">Description</th>"
                    + "      <th scope=\"col\">Price</th>"
                    + "      <th scope=\"col\">Quantity</th>"
                    + "      <th scope=\"col\">Delete</th>"
                    + "      <th scope=\"col\">Edit</th>"
                    + "    </tr>"
                    + "  </thead>");
if(rs!=null) {
    if(rs.next()) {
        do {
            out.println("  <tbody>"
                        + "    <tr>"
                        + "      <th scope=\"row\">" + rs.getInt(1) + "</th>"
                        + "      <td>" + rs.getString(2) + "</td>"
                        + "      <td>" + rs.getString(3) + "</td>"
                        + "      <td>" + rs.getInt(4) + "</td>"
                        + "      <td>" + rs.getInt(5) + "</td>"
                        + "      <td><form action='DeleteServlet'><button class='delete-button' name='del' value=" + rs.getInt(1) + ">Delete</button></form></td>"
                        + "      <td><form action='EditServlet'><button class='edit-button' name='edit' value=" + rs.getInt(1) + ">Edit</button></form></td>"
                        + "    </tr>"
                        + "  </tbody>");
        } while(rs.next());
    }
}
%>
 
</body>
</html>