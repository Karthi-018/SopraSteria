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

    .table-container {
        width: 80%;
        margin: 20px auto;
    }

    .table {
        width: 100%;
        border-collapse: collapse;
    }

    .table th, .table td {
        border: 1px solid #dee2e6;
        padding: 8px;
        text-align: left;
    }

    .table th {
        background-color: #007bff;
        color: #fff;
    }

    .validate-button, .invalidate-button {
        padding: 5px 10px;
        border: 1px solid #ccc; /* Remove blue border */
        border-radius: 3px;
        background-color: #fff; /* White background */
        color: #007bff; /* Blue text color */
        cursor: pointer;
    }

    .validate-button:hover, .invalidate-button:hover {
        background-color: #f8f9fa; /* Change hover background color */
        color: #0056b3; /* Change hover text color */
    }
</style>
</head>
<body>
<center><%@ include file="menubar.jsp" %></center>

<%
ResultSet rs=(ResultSet)request.getAttribute("resultSet");
ResultSet rs1=(ResultSet)request.getAttribute("resultSet1");
%>
 
<div class="table-container">
    <table class="table">
        <thead>
            <tr>
                <th scope="col">First Name</th>
                <th scope="col">Last Name</th>
                <th scope="col">D.O.B</th>
                <th scope="col">Gender</th>
                <th scope="col">Status</th>
                <th scope="col">Validation</th>
            </tr>
        </thead>
 
        <%
        if(rs!=null) {
            if(rs.next()) {
                do {
        %>
 
        <tbody>
            <tr>
                <td><%= rs.getString(2) %></td>
                <td><%= rs.getString(3) %></td>
                <td><%= rs.getString(6) %></td>
                <td><%= rs.getString(7) %></td>
                <td><p style="color:red;"><%= rs.getString(8) %></p></td>
                <td>
                    <form action='AdminValidationServlet'>
                        <button class='validate-button' name='validate' value="<%= rs.getString(4) %>">Validate</button>
                    </form>
                </td>
            </tr>
        </tbody>
 
        <%
                } while(rs.next());
            }
        }
        %>

        <%
        if(rs1!=null) {
            if(rs1.next()) {
                do {
        %>
 
        <tbody>
            <tr>
                <td><%= rs1.getString(2) %></td>
                <td><%= rs1.getString(3) %></td>
                <td><%= rs1.getString(6) %></td>
                <td><%= rs1.getString(7) %></td>
                <td><p style="color:green;"><%= rs1.getString(8) %></p></td>
                <td>
                    <form action='AdminInvalidationServlet'>
                        <button class='invalidate-button' name='invalidate' value="<%= rs1.getString(4) %>">Invalidate</button>
                    </form>
                </td>
            </tr>
        </tbody>
 
        <%
                } while(rs1.next());
            }
        }
        %>
    </table>
</div>
 
</body>
</html>