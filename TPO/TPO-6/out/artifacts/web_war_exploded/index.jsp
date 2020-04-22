<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=windows-1250">
  <title>Task 3</title>
  <script type="text/javascript">
    function add(){
      var data = "a=" + encodeURIComponent(document.getElementById("a").value)
              + "&b="+encodeURIComponent(document.getElementById("b").value);
      if (typeof XMLHttpRequest != "undefined") {
        req = new XMLHttpRequest();
      } else if (window.ActiveXObject) {
        req = new ActiveXObject("Microsoft.XMLHTTP");
      }
      req.open("POST", "add", true);
      req.onreadystatechange = inserter;
      req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
      req.send(data);
    }

    function inserter() {
      if (req.readyState === 4) {
        if (req.status === 200) {
          var msg = req.responseText
          document.getElementById("result").value = msg
        }
      }
    }
  </script>
</head>
<body>
<h1>Input numbers</h1>
<form>
  <input onfocusout="add()" size="10" id="a">
  +
  <input onfocusout="add()" size="10" id="b">
  =
  <input size="10" id="result">
</form>
</body></html>
