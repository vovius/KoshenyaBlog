<%--
  Created by IntelliJ IDEA.
  User: sony
  Date: 12/10/2016
  Time: 3:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login form</title>
</head>
<body>

<h3>Login with Username and Password</h3>
<form name='f' action='/koshenyablog/login' method='POST'>
    <table>
        <tr><td>User:</td><td><input type='text' name='username' value=''></td></tr>
        <tr><td>Password:</td><td><input type='password' name='password'/></td></tr>
        <tr><td colspan='2'><input name="submit" type="submit" value="Login"/></td></tr>
        <%--<input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}" />--%>
    </table>
</form>

</body>
</html>
