
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2/19/2024
  Time: 1:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Create new customer</title>
</head>
<body>
<button><a href="/customers">Back to customer list</a></button>
<form method="post">
<h3>Create new customer</h3>
<fieldset>
<legend>Customer information</legend>
    <input type="text" placeholder="nhap ten" name="name"> <br>
    <input type="text" placeholder="nhap dia chi" name="address"> <br>
    <input type="text" placeholder="nhap email" name="email"> <br>
    <input type="text" placeholder="nhap so dien thoai" name="phone"> <br>
    <select name="province" id="province">
        <c:forEach items="${provinceList}" var="p">
            <option value="${p.id}">${p.name}</option>
        </c:forEach>

    </select>
    <br>
    <button type="submit">Create</button>

</fieldset>

</form>

</body>
</html>
