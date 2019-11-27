<%--
  Created by IntelliJ IDEA.
  User: ifactor
  Date: 27.11.2019
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UserIndex</title>
</head>
<body>
    <jsp:useBean id="name" scope="request" type="java.lang.String"/>
    <p>Hello, ${name}</p>
</body>
</html>
