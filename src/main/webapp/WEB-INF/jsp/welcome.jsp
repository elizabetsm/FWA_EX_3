<%@ page import="edu.school_21.cinema.models.User" %>
<%@ page import="java.io.File" %>
<%@ page import="java.util.List" %>
<%@ page import="java.nio.file.Files" %>
<%@ page import="java.nio.file.Path" %>
<%@ page import="java.util.stream.Stream" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="edu.school_21.cinema.models.SignModel" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
</head>
<body>
<% User user = (User)request.getSession().getAttribute("user");%>
<% File pathToPic = (File)session.getAttribute("pathImages");%>
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


<% List<File> list = new ArrayList<>();
    List<File> newList = null;
if (pathToPic != null){
    try (Stream<Path> paths = Files.walk(pathToPic.toPath())) {
        paths
                .map(file -> new File(String.valueOf(file)))
                .forEach(list::add);
    }
    newList = list.subList(1, list.size());
}
%>
<table width="50%" border="1">
    <thead>
    <tr>
        <td>File name</td>
        <td>Size</td>
        <td>MIME</td>
    </tr>
    </thead>
    <tbody>

    <% if (newList != null) { %>
    <% for (File file : newList) {%>
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
