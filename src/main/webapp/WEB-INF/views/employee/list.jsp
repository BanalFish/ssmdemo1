<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 86155
  Date: 2021/8/15
  Time: 13:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/employee/input">新增</a>
    <table>
        <tr>
            <td>id</td>
            <td>姓名</td>
            <td>密码</td>
            <td>邮箱</td>
            <td>年龄</td>
            <td>管理者</td>
            <td>部门ID</td>
            <td>部门名称</td>
            <td>部门编号</td>
        </tr>

        <c:forEach items="${list}" var="emp">
            <tr>
                <td>${emp.id}</td>
                <td>${emp.name}</td>
                <td>${emp.password}</td>
                <td>${emp.email}</td>
                <td>${emp.age}</td>
                <td>${emp.admin}</td>
                <td>${emp.dept.id}</td>
                <td>${emp.dept.name}</td>
                <td>${emp.dept.sn}</td>
                <td>
                    <a href="/employee/delete?id=${emp.id}">删除</a>
                    <a href="/employee/input?id=${emp.id}">编辑</a>

                </td>
            </tr>

        </c:forEach>
    </table>

</body>
</html>
