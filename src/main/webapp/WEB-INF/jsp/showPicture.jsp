<%--
  Created by IntelliJ IDEA.
  User: lizka
  Date: 04.11.2021
  Time: 21:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>show one picture</title>
</head>
<body>
<img src="data:image/png;base64,<%=request.getSession().getAttribute("picture")%>" height="800" width="1200">
</body>
</html>
