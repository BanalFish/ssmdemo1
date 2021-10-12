<%--
  Created by IntelliJ IDEA.
  User: 86155
  Date: 2021/8/15
  Time: 14:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/employee/insertOrUpdate" method="post">
        <input type="hidden" value="${emp.id}" name="id"/>
        姓名：<input type="text" value="${emp.name}" name="name"><br/>
        密码：<input type="text" value="${emp.password}" name="password"><br/>
        邮箱：<input type="text" value="${emp.email}" name="email"><br/>
        年龄：<input type="text" value="${emp.age}" name="age"><br/>
        管理者：<input type="text" value="${emp.admin}" name="admin"><br/>
        部门ID：<input type="text" value="${deptId}" name="deptId"><br/>
<%--        <input type="" value="${dept.name}" name="deptName"/>--%>
<%--        <input type="" value="${dept.sn}" name="deptSn"/>--%>
        <input type="submit" value="保存"/>
    </form>
</body>
</html>
