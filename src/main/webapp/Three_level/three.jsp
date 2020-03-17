<%--
  Created by IntelliJ IDEA.
  User: 28309
  Date: 2020/3/17
  Time: 14:19
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
               "url" : "http://localhost/Advanced_war/second_Servlet",
               "data" : {"level":"one"},
               "type" : "post",
               "dataType" : "json",
               "success" : function (json) {
                   for(var i = 0; i < json.length; i++){
                       $("#lv1").append("<option value='"+json[i].id+"'>"+ json[i].name + "</option>");
                   }
               }
           });
           $("#lv1").click(function () {
               $("#lv3 > option").remove();
           });
        });

        $(function () {
            $("#lv1").click(function () {
                var st = $(this).val();
                $.ajax({
                    "url" : "http://localhost/Advanced_war/second_Servlet",
                    "data" : {"level" : "two","parent" : st},
                    "type" : "post",
                    "dataType" : "json",
                    "success" : function (json) {
                        $("#lv2 > option").remove();
                        for(var i = 0; i < json.length; i++)
                            $("#lv2").append("<option value='"+json[i].id+"'>" + json[i].name + "</option>");
                    }
                });
            });
        });
        
        $(function () {
           $("#lv2").click(function () {
              var no = $(this).val();
              $.ajax({
                 "url" : "http://localhost/Advanced_war/second_Servlet",
                 "data" : {"level" : "three","parent" : no},
                 "dataType" : "json",
                 "type" : "post",
                 "success" : function (json) {
                     $("#lv3 > option").remove();
                     for(var i = 0; i < json.length; i++){
                         $("#lv3").append("<option value='"+json[i].id+"'>"+json[i].name+"</option>");
                     }
                 } 
              });
           });
        });
    </script>
</head>
<body>
    <select id="lv1" style="width: 100px;height: 30px">
        <option selected="selected">请选择</option>
    </select>
    <select id="lv2" style="width: 100px;height: 30px"></select>
    <select id="lv3" style="width: 100px;height: 30px"></select>
</body>
</html>
