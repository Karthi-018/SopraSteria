<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="edu.sopra.training.SpringBootMVC.model.Customer" %>
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
<center><%@ include file="AdminMenubar.jsp" %></center>

<%
List<Customer> activeCustomers = (List<Customer>)request.getAttribute("activeCustomers");
List<Customer> inactiveCustomers = (List<Customer>)request.getAttribute("inactiveCustomers");
List<Customer> NewCustomers = (List<Customer>)request.getAttribute("NewCustomers");

%>
 
<div class="table-container">
    <table class="table">
        <thead>
            <tr>
                <th scope="col">First Name</th>
                <th scope="col">Last Name</th>
                <th scope="col">D.O.B</th>
                <th scope="col">email</th>
                <th scope="col">Status</th>
                <th scope="col">Validation</th>
            </tr>
        </thead>
         <%
        for(Customer c : NewCustomers){
        %>
        <tbody>
            <tr>
                <td><%= c.getFname() %></td>
                <td><%= c.getLname() %></td>
                <td><%= c.getDob() %></td>
                <td><%= c.getEmail() %></td>
                <td><p style="color:blue;"><%= c.getStatus() %></p></td>
                <td>
                    <form action='AdminValidation'>
                        <button class='validate-button' name='validate' value="<%= c.getCustId() %>">Validate</button>
                    </form>
                </td>
            </tr>
        </tbody>
 
        <%
        }
        %>
        <%
        for(Customer c:activeCustomers){
        %>
 
        <tbody>
            <tr>
                <td><%= c.getFname() %></td>
                <td><%= c.getLname() %></td>
                <td><%= c.getDob() %></td>
                <td><%= c.getEmail() %></td>
                <td><p style="color:green;"><%= c.getStatus() %></p></td>
                <td>
                    <form action='AdminInvalidation'>
                        <button class='invalidate-button' name='invalidate' value="<%= c.getCustId() %>">Invalidate</button>
                    </form>
                </td>
            </tr>
        </tbody>
 
        <%
        }
        %>
        
         <%
        for(Customer c:inactiveCustomers){
        %>
 
        <tbody>
            <tr>
                <td><%= c.getFname() %></td>
                <td><%= c.getLname() %></td>
                <td><%= c.getDob() %></td>
                <td><%= c.getEmail() %></td>
                <td><p style="color:red;"><%= c.getStatus() %></p></td>
                <td>
                    <form action='AdminValidation'>
                        <button class='validate-button' name='validate' value="<%= c.getCustId() %>">Validate</button>
                    </form>
                </td>
            </tr>
        </tbody>
 
        <%
        }
        %>
    </table>
</div>
 
</body>
</html>