<%--
  Created by IntelliJ IDEA.
  User: 28309
  Date: 2020/3/17
  Time: 18:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="#" method="post" id="inf">
        <div id="err" style="color: red"></div>
        <div>
            姓名：<input id="name" name="name"/>
        </div>
        <div>
            身份证：<input id="no" name="no"/>
        </div>
        <div>
            <input type="submit" value="提交">
        </div>
    </form>
    <script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript">
        $("#inf").submit(function () {
            //JS中定义正则表达式 /正则表达式/
            var regex = /^[\u4e00-\u9fa5]{2,8}$/;
            var regex1 = /^[1234568]\d{16}[0-9xX]$/;
            var no = document.getElementById("no").value;
            var name = document.getElementById("name").value;
            if(regex.test(name) == false || regex1.test(no) == false) { //匹配返回true
                if(regex.test(name) == false)
                    document.getElementById("err").innerHTML = "无效姓名";
                else
                    document.getElementById("err").innerHTML = "无效身份证号";
                return false;
            }
            else{
                alert("验证通过！");
                return true;
            }
        });
    </script>
</body>
</html>
