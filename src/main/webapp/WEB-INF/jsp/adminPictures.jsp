<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>adminPictures</title>

    <link rel="stylesheet" href="<c:url value="/resources/css/jquery-ui.css" />" />
    <link rel="stylesheet" href="<c:url value="/resources/css/koshenya.css" />" />
    <script src="<c:url value="/resources/js/jquery.js" />" ></script>
    <script src="<c:url value="/resources/js/jquery-ui.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/adminPictures.js" />" ></script>

</head>
<body>
<div id="dialogAddImage" title="Add new Image">
    <form method="post" enctype="multipart/form-data" action="addImageServlet" name="formAddImage" id="formAddImage">
        <fieldset>
            <label for="imageDescription">Description</label>
            <input id="imageDescription" name="imageDescription" type="text" class="text ui-widget-content ui-corner-all" style="width:555px" /><br/>
            <label for="picture">Image</label>
            <input type="file" name="picture" id="picture" value="Upload image" class="text ui-widget-content ui-corner-all" style="width: 555px" onchange="readURL(this);">
            <img id="pictureFile" name="pictureFile" src="" width="100" height="100" />

            <!-- Allow form submission with keyboard without duplicating the dialog button -->
            <input type="submit" tabindex="-1" style="position:absolute; top:-1000px">
        </fieldset>
    </form>
</div>
<button id="addImage">Add image</button>
<table id="tblImages">
    <tbody>
        <tr>
            <c:forEach items="${images}" var="image" varStatus="i">
                <td><img src='${"getImage/".concat(image.id)}' title="${image.description.concat(", added: ").concat(image.created)}" width="100" height="100" /></td>
            </c:forEach>
        </tr>
    </tbody>
</table>
</body>
</html>
