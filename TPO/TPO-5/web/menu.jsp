<%@ page import="DTO.MenuContent" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.stream.Collectors" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: demet
  Date: 13.04.2020
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Form Styling</title>
    <link
            href="https://fonts.googleapis.com/css?family=Raleway"
            rel="stylesheet"
    />
    <style>
        * {
            box-sizing: border-box;
            padding: 0;
        }

        body {
            background-color: #002466b2;
            font-family: 'Raleway', sans-serif;
        }

        header{
            margin: auto;
            padding: 5px;
            max-width: 50%;
            border: 3px solid;
            text-align: center;
            background-color: white;
        }

        .userarea{
            margin: auto;
            text-align: center;
        }

        .userarea button{
            background-color: white;
            border: none;
            text-decoration: none;
            color: cornflowerblue;
        }

        .userarea button:hover{
            cursor: pointer;
        }

        #container {
            margin: auto;
            margin-top: 5px;
            max-width: 50%;
            background-color: white;
            border: 3px solid;
            text-align: center;
        }

        .resource_form {
            display: block;
            margin: 10px;
            padding: 5px;
            text-decoration: none;
            border-bottom: black solid 2px;
        }

        .resource{
            background-color: white;
            border: none;
            font-size: 20px;
            color: #062764;
        }

        .resource:hover{
            cursor: pointer;
            color: orangered;
        }
        .hidden{
            display: none;
        }

    </style>
</head>
<body>
<header>
    <div class="userarea">
        <p>Hello, <%= ((MenuContent)(request.getAttribute("Content"))).getName()%> <%= ((MenuContent)(request.getAttribute("Content"))).getSurname()%>.</p>
        <form action="http://localhost:8080/index"><button type="submit">Log Out</button></form>
    </div>
</header>
<div id="container">
    <h1>Resources available:</h1>
    <%
        MenuContent content = (MenuContent)(request.getAttribute("Content"));
        List<Integer> ids = new ArrayList<>(content.getResources().keySet());
        for(Integer id: ids){
            String name = content.getResources().get(id);
            System.out.println("Id of resource "+id);
            out.println("<form method='post' action='http://localhost:8080/res' class=\"resource_form\">"
                    +"<input class='hidden' name=\"id\" value=\""+id+"\">"
                    +"<input class='resource' type='submit' value='"
                    +name+"'></form>");
        }
    %>
</div>
</body>
</html>
