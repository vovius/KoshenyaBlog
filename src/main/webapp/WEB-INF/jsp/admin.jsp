<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="/resources/css/koshenya.css" />" rel="stylesheet" type="text/css" />
    <title>Admin Panel</title>

    <script type="text/javascript">
        function openAdminURL(url, name) {
            window.open(url, name);
        }
    </script>

</head>
<body>

<div id="adminMenu" align="center">
    <table>
        <tr>
            <td><button onclick="openAdminURL('adminPosts','adminPosts')"><img src="<c:url value="/resources/images/Blog-Post.jpg" />" alt="Blog posts" /></button></td>
            <td><button onclick="openAdminURL('adminPictures','adminPictures')"><img src="<c:url value="/resources/images/anicons-background-f.jpg" />" alt="Blog images" /></button></td>
        </tr>

    </table>
</div>

</body>
</html>
