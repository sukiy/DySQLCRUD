<%--
  Created by IntelliJ IDEA.
  User: Sukiy
  Date: 2018/1/26
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
</head>
<body>
<h2>添加学生</h2>
    <form id="frm">
        学生姓名：<input name="sname"><br>
        学生年龄：<input name="sage"><br>
        学生性别：<input type="radio" name="sex" value="男" checked />男
                 <input type="radio" name="sex" value="女" />女<br>
        所在班级：<select name="cls.cno" id="cname">
                    <option value="">请选择班级</option>
                 </select><br/>
        <input type="button" value="添加" id="btn">
    </form>
</body>
</html>
<script type="text/javascript">
    /*异步查询出班级*/
    $(function () {
        //取出所有可选的班级
        $("#cname option:not(:first)").remove();
        $.post("tbClassAction/findClsList","",function (data) {
            $.each(data,function (i,v) {
                var option="<option value='"+v.cno+"'>"+v.cname+"</option>";
                $("#cname").append(option);
            });
        });
    });

/************************************************************/
    $("#btn").click(function () {
        var trim=$("#frm").serialize();
        var frm=$("#frm");
        var f=frm[0];
        console.log(trim);
        $.ajax({
            url:"stuAction/addStu",
            type:"post",
            data: trim,
            timeout:3000,
            success:function (result) {
                alert("添加成功");
                f.reset();
            },
            error:function () {
                alert("添加失败");
            }
        });
    });
</script>
