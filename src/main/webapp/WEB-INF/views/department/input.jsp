<%--
  Created by IntelliJ IDEA.
  User: 86155
  Date: 2021/8/13
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/department/saveOrUpdate" method="post">
        <input type="hidden" value="${dept.id}" name="id"/>
        部门名称：<input type="text" value="${dept.name}" name="name"/><br/>
        部门编号：<input type="text" value="${dept.sn}" name="sn"/><br/>
        <input type="submit" value="保存"/>
    </form>

</body>
</html>
