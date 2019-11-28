<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UserIndex</title>
</head>
<body>
    <jsp:useBean id="name" scope="request" type="java.lang.String"/>
    <p>Hello, ${name}</p>
    <sec:authorize access="hasRole('ADMIN')">
        <br>
        <a href="/admin/all">Admin page</a>
    </sec:authorize>
</body>
</html>
