<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2/19/2024
  Time: 10:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customer</title>

</head>

<body>
<h1>Customer List</h1>
<button id="btn"><a href="/customers?action=create">Create new customer</a></button>
<br>
<table border="1">
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Address</td>
        <td>Email</td>
        <td>Phone</td>
        <td>Province</td>
    </tr>
    <c:forEach items="${customer}" var="customer">
        <tr>
            <td>${customer.getId()}</td>
            <td>${customer.getName()}</td>
            <td>${customer.getAddress()}</td>
            <td>${customer.getEmail()}</td>
            <td>${customer.getPhone()}</td>
            <td>${customer.getProvince()}</td>

        </tr>
    </c:forEach>
</table>

</body>
</html>
