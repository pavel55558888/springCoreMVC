<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: p-vik
  Date: 24.07.2024
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form action="/add" name="formAdd" method="post">
        <input type="text" placeholder="Имя" name="name">
        <form:errors path="name"/>
        <br>
        <input type="text" placeholder="Фамилия" name="surname">
        <br>
        <input type="text" placeholder="Департамент" name="department">
        <br>
        <input type="text" placeholder="Зарплата" name="salary">
        <br>
        <input type="text" placeholder="Номер" name="number">
        <br>
        <input type="text" placeholder="Почта" name="email">
        <br>
        <button>OK</button>
    </form>

</body>
</html>
