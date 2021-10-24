<%@ page import="edu.school_21.cinema.models.User" %><%--
  Created by IntelliJ IDEA.
  User: lizka
  Date: 19.10.2021
  Time: 21:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<hr/>

<h3>Login Form</h3>
<br/>
<form action="loginprocess.jsp" method="post">
    Email:<input type="text" name="email"/><br/><br/>
    Password:<input type="password" name="password"/><br/><br/>
    <input type="submit" value="login"/>"
</form>
</body>
</html>
