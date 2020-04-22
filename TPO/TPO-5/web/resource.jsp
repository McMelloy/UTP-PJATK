<%@ page import="DTO.ResourceContent" %><%--
  Created by IntelliJ IDEA.
  User: demet
  Date: 13.04.2020
  Time: 15:36
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
            background-color: white;
            border: 3px solid;
            text-align: center;
        }

        .userarea{
            margin: auto;
            text-align: center;
        }

        button{
            background-color: white;
            border: none;
            text-decoration: none;
            color: cornflowerblue;
        }

        button:hover{
            cursor: pointer;
        }

        .userarea a{

            text-decoration: none;
            color: cornflowerblue;
        }

        #container {
            margin: auto;
            margin-top: 5px;
            max-width: 50%;
            background-color: white;
            border: 3px solid;
            text-align: center;
        }

        #container p {
            display: block;
            margin: 10px;
            padding: 5px;
            text-align: justify;
        }

        .return{
            text-align: right;
            margin-right: 10px;
            margin-bottom: 10px;
        }

    </style>
</head>
<body>
<header>
    <div class="userarea">
        <p>Hello, <%= ((ResourceContent)(request.getAttribute("Content"))).getName()%> <%= ((ResourceContent)(request.getAttribute("Content"))).getSurname()%>.</p>
        <form action="http://localhost:8080/index"><button type="submit">Log Out</button></form>
    </div>
</header>
<div id="container">
    <h1><%= ((ResourceContent)(request.getAttribute("Content"))).getResName()%></h1>
    <p> <%= ((ResourceContent)(request.getAttribute("Content"))).getResContent()%></p>
    <form class="return" action="http://localhost:8080/menu"><button type="submit">Return to Menu</button></form>
</div>
</body>
</html>
