<%@ page import="edu.school_21.cinema.models.User" %><%--
  Created by IntelliJ IDEA.
  User: lizka
  Date: 14.10.2021
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ include file="signIn.jsp" %>--%>
<html>
<head>
    <title>Profile</title>
</head>
<body>
<% User user = (User)request.getSession().getAttribute("user");%>
<%--<div class="col-sm-6 col-md-4">--%>
    <img src="data:image/jpg;<%=user.getListOfImages().get(0)%>" height="1080px" width="1920px" />
<%--</div>--%>
<%--<div class="col-sm-6 col-md-8">--%>
    <h4><%=user.getFirstName()%></h4>
<%--    <small><cite title="San Francisco, USA">San Francisco, USA <i class="glyphicon glyphicon-map-marker">--%>
<%--    </i></cite></small>--%>
<%--<h2>Welcome</h2>--%>
<%--<a>Its me</a><br/>--%>
<%--<% User user = (User)request.getSession().getAttribute("user");%>--%>
<%--<%=user.getFirstName()%>--%>
<%--<br/>--%>
<%--<img src="<%=user.getListOfImages().get(0)%>">--%>
</body>
</html>
