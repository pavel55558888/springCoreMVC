<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<%--
  Created by IntelliJ IDEA.
  User: p-vik
  Date: 24.07.2024
  Time: 0:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <tr>
            <th>Name</th>
            <th>Surname</th>
            <th>Department</th>
            <th>Salary</th>
            <th>Phone number</th>
            <th>Email</th>
            <th>Update</th>
            <th>Delete</th>
        </tr>
        <br><br>

        <c:forEach var="emp"  items="${allEmployee}">
            <tr>
                <tg>
                    ${emp.name}
                </tg>
                <tg>
                        ${emp.surname}
                </tg>
                <tg>
                        ${emp.department}
                </tg>
                <tg>
                        ${emp.salary}
                </tg>
                <tg>
                        ${emp.number}
                </tg>
                <tg>
                        ${emp.email}
                </tg>
                <tg>
                    <form action="/update/ + ${emp.id}" method="post">
                        <button>update</button>
                    </form>
                </tg>
                <tg>
                    <form action="/delete/ + ${emp.id}" method="post">
                        <button>delete</button>
                    </form>
                </tg>
            </tr>
            <br>
        </c:forEach>

    </table>
<a href="/add">Добавить</a>
</body>
</html>
