<%--
  Created by IntelliJ IDEA.
  User: neroyang
  Date: 2017/3/6
  Time: 下午8:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>redirect</title>
</head>
<body>

    <input id="state" type="hidden" value="${result.state }">

    <input id="msg" type="hidden" value="${result.msg }">

    <input id="ticket" type="hidden" value="${result.data.ticket }">

    <script>
        if(document.getElementById("state").value=="false"){

            alert(document.getElementById("msg").value);

        }else{

            window.location.href="http://sso.clickgwas.org?ticket="+document.getElementById("ticket").value;

        }
    </script>

</body>
</html>
