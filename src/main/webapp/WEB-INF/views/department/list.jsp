<%--
  Created by IntelliJ IDEA.
  User: 86155
  Date: 2021/8/13
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

<html>
<head>
    <title>Title</title>
    <script src="/static/jquery-3.4.1.min.js"></script>
</head>
<body>
<a href="/department/input">新增</a>
    <table>
        <tr>
            <td>id </td>
            <td>部门名称 </td>
            <td>部门编号 </td>
            <td>操作</td>
        </tr>

        <c:forEach items="${list}" var="dept">
            <tr>
                <td>${dept.id}</td>
                <td>${dept.name}</td>
                <td>${dept.sn}</td>
                <td>
                    <a href="javascript:void(0)" class="delete">删除</a>

<%--                    <a href="/department/delete?id=${dept.id}">删除</a>--%>
                    <a href="/department/input?id=${dept.id}">编辑</a>
                </td>
            </tr>
        </c:forEach>


    </table>

<script type="text/javascript">
    $(function (){
        $(".delete").click(function (){
            var trNode=$(this).closest("tr");
            var deptId=trNode.find("td").first().text();
            $.ajax({
                url:"/department/delete",
                data:{"id":deptId},
                type:"get",
                dataType:"json",
                //http code 200
                success:function (res) {
                    console.log(res);
                    console.log(res.msg);
                    var result=res.success;
                    if(result){
                        trNode.remove();
                    }
                },
                error:function () {
                    alert("请求失败");
                }

            });
        });
    })
</script>



</body>
</html>
