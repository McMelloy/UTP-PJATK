<%--
  Created by IntelliJ IDEA.
  User: demet
  Date: 29.03.2020
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Addition</title>
</head>
<body>
    <h1>Well Hello There</h1>
    <%
        if (request.getAttribute("res") != null) {
            String a = String.valueOf(request.getAttribute("a"));
            String b = String.valueOf(request.getAttribute("b"));
            String res = String.valueOf(request.getAttribute("res"));
    %>

    <div><%= a%> + <%= b%> = <%= res%></div>

    <%
    } else {
    %>

    <div>Input error</div>

    <% } %>
</body>
</html>
