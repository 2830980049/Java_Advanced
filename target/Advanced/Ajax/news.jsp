<%--
  Created by IntelliJ IDEA.
  User: 28309
  Date: 2020/3/16
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div id="container">

    </div>
    <script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript">
        var xmlhttp;
        if(window.XMLHttpRequest)
            xmlhttp = new XMLHttpRequest();
        else
            xmlhttp = new ActiveXObject("Mircosoft.XMLHTTP");

        xmlhttp.open("GET","http://localhost/Advanced_war/News_Servlet",true);
        xmlhttp.send();

        xmlhttp.onreadystatechange = function () {
            if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
                var text = xmlhttp.responseText;

                var json = JSON.parse(text);

                var html = "";
                for(var i = 0; i < json.length; i++){
                    var news = json[i];
                    html =  html + "<h1>" + news.title + "</h1>";
                    html =  html + "<h2>" + news.date + "&nbsp"+ news.source +"</h2>";
                    html = html + "<hr/>"
                }
                document.getElementById("container").innerHTML = html;
            }
        }

    </script>
</body>
</html>
