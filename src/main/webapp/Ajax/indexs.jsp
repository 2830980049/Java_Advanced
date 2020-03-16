<%--
  Created by IntelliJ IDEA.
  User: 28309
  Date: 2020/3/16
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<input id="btnload" type="button" value="加载">
<div id="divContent"></div>
<script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
    $("#btnload").click(function () {
        //1.创建XmlHttpRequest对象
        var xmlhttp;
        if(window.XMLHttpRequest)
            xmlhttp = new XMLHttpRequest();
        else
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        console.log(xmlhttp);
        //2.发送Ajax请求
        xmlhttp.open("GET", "http://localhost/Advanced_war/Content_Servlet",true);
        xmlhttp.send();
        //3.处理服务器响应
        xmlhttp.onreadystatechange = function () {
            if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
                var t = xmlhttp.responseText;
                alert(t);
                document.getElementById("divContent").innerHTML = t;
            }
        }
    });
</script>
</body>
</html>
