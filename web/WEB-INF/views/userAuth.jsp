<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ifactor
  Date: 25.11.2019
  Time: 18:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authorisation</title>
</head>

<body>

    <form action="/doLogin" method="post">
        <input type="text" name="login" id="login" />
        <input type="text" name="password" id="password" />
        <input type="submit" value="login" />
    </form>

</body>

</html>
