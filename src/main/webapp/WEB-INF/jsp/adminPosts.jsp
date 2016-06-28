<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Administration of Koshenya Blog</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/jquery-ui.css" />" />
    <link rel="stylesheet" href="<c:url value="/resources/css/koshenya.css" />" />
    <script src="<c:url value="/resources/js/jquery.js" />" ></script>
    <script src="<c:url value="/resources/js/jquery-ui.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/adminPosts.js" />" ></script>

</head>
<body>

<div id="dialogCreatePost" title="Create new Post">
    <form method="post" enctype="multipart/form-data" action="savePostServlet" name="formCreatePost" id="formCreatePost">
        <fieldset>
            <input type="hidden" id="postId" name="postId"/>
            <input type="hidden" id="created" name="created" />
            <div>
                <input type="checkbox" id="isVisible" name="isVisible"/>
                <label for="isVisible">Visible</label>
            </div>
            <div>
                <label for="postHeader">Header</label>
                <input id="postHeader" name="postHeader" type="text" class="text ui-widget-content ui-corner-all" style="width:555px" /><br/>
            </div>
            <label for="postText">Text</label>
            <textarea name="postText" id="postText" class="text-area ui-widget-content ui-corner-all" style="width:555px;height:138px"></textarea>
            <label for="picture">Picture</label>
            <input type="file" name="picture" id="picture" value="Upload picture" class="text ui-widget-content ui-corner-all" style="width: 555px" onchange="readURL(this);">
            <img id="pictureFile" name="pictureFile" src="" width="100" height="100" />

            <!-- Allow form submission with keyboard without duplicating the dialog button -->
            <input type="submit" tabindex="-1" style="position:absolute; top:-1000px">
        </fieldset>
    </form>
</div>
<div id="divButtonCreatePost">
    <button id="createPost">Create new Post</button>
</div>
<div id="divPosts" title="Posts">
    <table id="tblPosts">
        <thead>
            <tr>
                <th>Image</th>
                <th>Id</th>
                <th>Created</th>
                <th>Changed</th>
                <th>Header</th>
                <th>Text</th>
                <th>Visible</th>
                <th/>
                <th/>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${messages}" var="message">
                <tr>
                    <td><img src='${"getPostFile/".concat(message.id)}' alt="image 1" width="100" height="100" /></td>
                    <td>${message.id}</td>
                    <td><fmt:formatDate type="both" value="${message.created}" pattern="dd-MM-yyyy HH:mm" /></td>
                    <td><fmt:formatDate type="both" value="${message.changed}" pattern="dd-MM-yyyy HH:mm" /></td>
                    <td>${message.header}</td>
                    <td>${message.text}</td>
                    <td align="center"><input type="checkbox" id="rowPostIsVisible" name="rowPostIsVisible" disabled
                            <c:if test="${message.visible}">checked</c:if>
                        />
                    </td>
                    <td><input type="button" value="Edit" class="editPost" /></td>
                    <td><input type="button" value="Delete" class="ui-button ui-widget ui-state-default ui-corner-all" /></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
