<%--
  Created by IntelliJ IDEA.
  User: Sukiy
  Date: 2018/1/28
  Time: 20:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
 </head>
<body>
<h2>修改学生</h2>
<form id="frm">
             <input type="hidden" name="sno" value="${stu.sno}">
    学生姓名：<input name="sname" value="${stu.sname}"><br>
    学生年龄：<input name="sage" value="${stu.sage}"><br>
    学生性别：<input type="radio" name="sex" value="男"/>男
            <input type="radio" name="sex" value="女" />女<br>
    所在班级：<select name="cls.cno" id="cname">
                    <option value="">请选择班级</option>
            </select><br/>
    <input type="button" value="修改" id="btn">
</form>
</body>
</html>
<script type="text/javascript">
    /*绑定性别*/
    var s = document.getElementsByName("sex");
    var ms = "${stu.sex}";
    ms == '男' ? s[0].checked = true : s[1].checked = true;

    /*异步查询出班级*/
    $(function () {
        //取出所有可选的班级
        $("#cname option:not(:first)").remove();
        $.post("${pageContext.request.contextPath}/tbClassAction/findClsList","",function (data) {
             $.each(data,function (i,v) {
                var option="<option value='"+v.cno+"'>"+v.cname+"</option>";
                $("#cname").append(option);
            });
             /*绑定班级*/
            var opt = $("select[name='cls.cno'] option");
            var cls = "${stu.cls.cno}";
            for(var i=0; i < opt.length; i++){
                if(opt[i].value == cls){
                    opt[i].selected = true;
                }
            }
        });
    });
    
    /************************************************************************/
 
    /*异步修改学生*/
    $("#btn").click(function () {
        var trim=$("#frm").serialize();
        $.ajax({
            url:"${pageContext.request.contextPath}/stuAction/doUpdate",
            type:"post",
            data:trim,
            timeout:3000,
            success:function (result) {
                alert("修改成功");
                location.href="${pageContext.request.contextPath}/stuList.jsp";
            },
            error:function () {
                alert("修改失败");
            }
        });
    });
</script>
