<%--
  Created by IntelliJ IDEA.
  User: 28309
  Date: 2020/3/17
  Time: 22:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="#" method="post" id="inf">
        <div id="err"></div>
        <div>姓名：<input id="name" name="name"></div>
        <div>身份证：<input id="no" name="no"></div>
        <div><input type="submit" value="提交"></div>
    </form>
    <script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript">
        $("#inf").submit(function () {
            var regex = /^[\u4e00-\u9fa5]{2,8}$/;
            var regex1 = /^[1234568]\d{16}[0-9xX]$/;
            var name = document.getElementById("name").value;
            var no = document.getElementById("no").value;
            if(regex.test(name) == false || regex1.test(no) == false){
                if(regex.test(name) == false)
                    document.getElementById("err").innerHTML = "无效姓名";
                else
                    document.getElementById("err").innerHTML = "无效ID";
                return false;
            }
            else{
                alert("验证通过");
                return true;
            }
        });
    </script>
</body>
</html>
