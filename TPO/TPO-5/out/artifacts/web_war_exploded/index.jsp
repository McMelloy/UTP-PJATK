<%-- Created by IntelliJ IDEA. --%>
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
      padding-top: 2%;
      font-family: 'Raleway', sans-serif;
    }

    a {
      text-decoration: none;
    }

    #container {
      margin: auto;
      max-width: 320px;
    }

    .form-wrap {
      background-color: white;
      border: 3px solid;
      padding: 0 8%;
      padding-bottom: 20px;
    }

    .form-wrap h1,
    .form-wrap p {
      text-align: center;
    }

    .form-wrap .form-group label {
      display: block;
    }

    .form-wrap .form-group input {
      width: 100%;
      height: 25px;
      border: 2px solid;
      border-radius: 4px;
      margin-bottom: 15px;
    }

    .form-wrap button {
      display: block;
      width: 100%;
      padding: 10px;
      border: black 2px solid;
      border-radius: 4px;
      background-color: #002466c9;
      color: white;
      text-align: center;
    }

    .form-wrap button:hover {
      background-color: #062764c2;
      color: lightgrey;
      cursor: pointer;
    }

    .form-wrap .bottom-text {
      padding-top: 5px;
      font-size: smaller;
    }

    footer {
      text-align: center;
      color:white
    }

    footer a {
      color: #88aef7;
    }
  </style>
</head>
<body>
<div id="container">
  <div class="form-wrap">
    <h1>Sign In</h1>
    <p>And gain access to all your resources</p>
    <form action="http://localhost:8080/menu">
      <div class="form-group">
        <label for="login">Login</label>
        <input type="login" name="login" id="login" />
      </div>
      <div class="form-group">
        <label for="password">Password</label>
        <input type="password" name="password" id="password" />
      </div>
      <button formmethod="post" class="btn">Sign Up</button>
    </form>
  </div>
</div>
</body>
</html>
