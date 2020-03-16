<%--
  Created by IntelliJ IDEA.
  User: 28309
  Date: 2020/3/16
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
            var st = "UZI";
            var no = "asda";
           $.ajax({
              "url" : "http://localhost/Advanced_war/News_Servlet",
               "type" : "get",
               "data" : {"t":st,"abc":no},
               "dataType" : "json",
               "success" : function (json) {
                   console.log(json);
                   for(var i = 0; i < json.length; i++){
                       $("#container").append(json[i].title);
                   }
               },
               "error" : function (xmlhttp,errorText) {
                   console.log(xmlhttp);
                   console.log(errorText);
                   if(xmlhttp.status == "405")
                       alert("无效请求");
                   else if(xmlhttp.status = "404")
                       alert("未找到URL资源");
                   else
                       alert("产生异常，请联系管理员");
               }
           });
        });
    </script>
</head>
<body>
    <div id="container">

    </div>
</body>
</html>
