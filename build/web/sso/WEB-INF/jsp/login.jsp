<%--
  Created by IntelliJ IDEA.
  User: neroyang
  Date: 2017/3/6
  Time: 下午8:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>redirect</title>
    <meta charset="utf-8">
</head>
<body>

<input id="state" type="hidden" value="${result.state }">

<input id="msg" type="hidden" value="${result.msg }">

<input id="ticket" type="hidden" value="${result.data.token }">

<input id="feedBackUrl" type="hidden" value="${result.data.feedbackurl}">

<input id="appname" type="hidden" value="${result.data.appname}">

<input id="appavatar" type="hidden" value="${result.data.appavatar}">

<p id="tip" style="color: #ff0000;"></p>
<script>
    if(document.getElementById("state").value=="false"){

        document.getElementById("tip").innerText = document.getElementById("msg").value+",三秒后自动跳转至"+document.getElementById("appname").value;

        setTimeout(function () {

            window.location.href=document.getElementById("feedBackUrl").value;

        },3000);

    }else{

        window.location.href="http://portal.clickgwas.org?" +
            "ticket="+ document.getElementById("ticket").value+
            "&appname="+ document.getElementById("appname").value+
            "&appavatar="+document.getElementById("appavatar").value;
    }
</script>

</body>
</html>
