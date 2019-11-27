<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UserAdd</title>
</head>
<body>

<form action="/admin/add/" method="post">
    <label>
        Login
        <input type="text" name="login"/>
    </label>
    <br>
    <label>
        Name
        <input type="text" name="name"/>
    </label>
    <br>
    <label>
        Password
        <input type="text" name="password"/>
    </label>
    <br>
    <label>
        Role
        <select name="role">
            <option value="ROLE_USER" selected>USER</option>
            <option value="ROLE_ADMIN">ADMIN</option>
        </select>
    </label>
    <input type="submit" value="addUser">
</form>

</body>
</html>