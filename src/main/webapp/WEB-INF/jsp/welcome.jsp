<%@ page import="edu.school_21.cinema.models.User" %>
<%@ page import="java.io.File" %>
<%@ page import="java.util.List" %>
<%@ page import="java.nio.file.Files" %>
<%@ page import="java.nio.file.Path" %>
<%@ page import="java.util.stream.Stream" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="edu.school_21.cinema.models.SignModel" %><%--
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
<% File pathToPic = (File)session.getAttribute("pathImages");%>
<%--<div class="col-sm-6 col-md-4">--%>
<%--    <img src="data:image/jpg;<%=user.getListOfImages().get(0)%>" height="1080px" width="1920px" />--%>
<%--    <img src="<%=image%>" height="1280px" width="960px"/>--%>
<%--</div>--%>
<table width="50%" border="1">
    <thead>
    <tr>
        <td>Date and time</td>
        <td>IP</td>
    </tr>
    </thead>
    <tbody>

    <% for (SignModel auth :user.getSignModels()) {%>
    <tr>
    <td><%=auth.getDate()%></td>
    <td><%=auth.getIp()%></td>
    </tr>
    <%}%>

    <br>
    </tbody>
</table>

<form enctype="multipart/form-data" action="/profile" method="post">

    <input type="file" name="file" size="100" />
    <input type="submit" value="Upload new Pic" />
    <br />

</form>
</body>

<% List<File> list = new ArrayList<>();
if (pathToPic != null){
    try (Stream<Path> paths = Files.walk(pathToPic.toPath())) {
        paths
                .map(file -> new File(String.valueOf(file)))
                .forEach(list::add);
    }
}%>
<table width="50%" border="1">
    <thead>
    <tr>
        <td>File name</td>
        <td>Size</td>
        <td>MIME</td>
    </tr>
    </thead>
    <tbody>

    <% if (list != null) { %>
    <% for (File file : list) {%>
    <tr>
        <td><a href="images/<%=file.getName()%>"><%=file.getName()%></a></td>
        <td><%=file.length()%></td>
        <td><%=Files.probeContentType(file.toPath())%></td>
    </tr>
    <%}%>
    <%}%>

    <br>
    </tbody>
</table>
</body>
</html>
