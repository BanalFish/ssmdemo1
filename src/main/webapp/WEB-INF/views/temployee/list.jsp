<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 86155
  Date: 2021/8/16
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/temployee/list" method="post">
    <input type="hidden" name="currentPage" id="currentPageNum" value="1">
关键字：<input type="text" name="keyword" value="${qo.keyword}"/>
部门:<select name="deptId">
    <option value="-1">全部</option>
    <c:forEach items="${deptList}" var="dept">
        <option value="${dept.id}" ${dept.id==qo.deptId? 'selected':''}>${dept.name}</option>
    </c:forEach>
</select>
<input type="submit" value="查询"/>

</form>
<table>
    <tr>
        <td>id</td>
        <td>姓名</td>
        <td>密码</td>
        <td>邮箱</td>
        <td>年龄</td>
        <td>部门ID</td>
        <td>部门名称</td>
    </tr>

    <c:forEach items="${list.data}" var="emp">
        <tr>
            <td>${emp.id}</td>
            <td>${emp.name}</td>
            <td>${emp.password}</td>
            <td>${emp.email}</td>
            <td>${emp.age}</td>
            <td>${emp.dept.id}</td>
            <td>${emp.dept.name}</td>
            <td>
                <a href="/employee/delete?id=${emp.id}">删除</a>
                <a href="/employee/input?id=${emp.id}">编辑</a>

            </td>
        </tr>
    </c:forEach>

    <tr align="center">
        <td colspan="9">
        <a href="javascript:void(0)" onclick="goPage(1)">首页</a>
        <a href="javascript:void(0)" onclick="goPage(${list.prevPage})">上一页</a>
        <a href="javascript:void(0)" onclick="goPage(${list.nextPage})">下一页</a>
        <a href="javascript:void(0)" onclick="goPage(${list.totalPage})">尾页</a>
    </td>
    </tr>
</table>

<script type="text/javascript">
    function goPage(currentPage){
        document.getElementById("currentPageNum").value=currentPage;
        document.forms[0].submit();
    }
</script>

</body>
</html>
