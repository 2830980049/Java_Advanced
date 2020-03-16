<%--
  Created by IntelliJ IDEA.
  User: 28309
  Date: 2020/3/16
  Time: 22:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $.ajax({
                "url" : "http://localhost/Advanced_war/Channel_Servlet",
                "data" : {"level" : "1"},
                "dataType" : "json",
                "type" : "get",
                "success" : function(json) {
                    console.log(json);
                    for(var i = 0; i < json.length; i++){
                        var ch = json[i];
                        $("#lv1").append("<option value='"+ch.code+"'>" + ch.name + "</option>");
                    }
                 }
            });
        });

        $(function () {
            $("#lv1").change(function () {
                var parent = $(this).val();
                console.log(parent);
                $.ajax({
                    "url" : "http://localhost/Advanced_war/Channel_Servlet",
                    "data" : {"level" : "2","parent" : parent},
                    "dataType" : "json",
                    "type" : "get",
                    "success" : function (json) {
                        console.log(json);
                        //移除所有lv2下的原始option选项
                        $("#lv2 > option").remove();
                        for(var i = 0; i < json.length; i++){
                            $("#lv2").append("<option value='"+json[i].code+"'>"+json[i].name+"</option>")
                        }
                    }
                });
            });
        });

    </script>
</head>
<body>
    <select id="lv1" style="width: 200px;height: 30px;">
        <option selected="selected">请选择</option>
    </select>
    <select id="lv2" style="width: 200px;height: 30px;"></select>
</body>
</html>
