<%--
  Created by IntelliJ IDEA.
  User: lizka
  Date: 19.10.2021
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="loginprocess.jsp">
    Phone:<input type="text" name="phoneNum" /><br/>
    Password:<input type="text" name="pass" /><br/>
    <input type="submit" value="log In" />
    <a href="/sign">or sing up</a>
</form>
</body>
</html>
