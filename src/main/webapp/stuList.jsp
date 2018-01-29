<%--
  Created by IntelliJ IDEA.
  User: Sukiy
  Date: 2018/1/28
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
</head>
<body>
<h2>学生列表</h2>
    <table id="mytab" border="1">
        <tr>
            <td>序号</td>
            <td>姓名</td>
            <td>年龄</td>
            <td>性别</td>
            <td>班级名称</td>
            <td>管理</td>
        </tr>
    </table>
</body>
</html>
<script type="text/javascript">
    /*异步查询出学生*/
    function loadData() {
        $("#mytab tr:not(:first)").remove();
        $.post("stuAction/findStuList","",function (data) {
            $.each(data,function (i,v) {
                var tr="<tr>";
                    tr+="<td>"+(i+1)+"</td>";
                    tr+="<td>"+v.sname+"</td>";
                    tr+="<td>"+v.sage+"</td>";
                    tr+="<td>"+v.sex+"</td>";
                    if ((v.cls) == null){
                        tr+="<td>未分配班级</td>";
                    }else {
                        tr+="<td>"+v.cls.cname+"</td>";
                    }
                    tr+="<td><a href='stuAction/toUpdate?sno="+v.sno+"'>修改</a>|<a href=''>删除</a></td>";
                    tr+="</tr>";
                $("#mytab").append(tr);
            });
        });
    }
    window.onload=loadData();

</script>
