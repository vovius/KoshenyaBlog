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
            <input type="hidden" id="dialogImageId" name="dialogImageId" />
            <label for="dialogImageDescription">Description</label>
            <input id="dialogImageDescription" name="dialogImageDescription" type="text" class="text ui-widget-content ui-corner-all" style="width:555px" /><br/>
            <input type=hidden id="dialogImageCreated" name="dialogImageCreated" />
            <label for="dialogPicture">Image</label>
            <input type="file" name="dialogPicture" id="dialogPicture" value="Upload image" class="text ui-widget-content ui-corner-all" style="width: 555px" onchange="readURL(this);">
            <img id="dialogPictureFile" name="dialogPictureFile" src="" width="100" height="100" />

            <!-- Allow form submission with keyboard without duplicating the dialog button -->
            <input type="submit" tabindex="-1" style="position:absolute; top:-1000px">
        </fieldset>
    </form>
</div>
<div id="adminPicturesButtonsMenu">
    <input type="button" id="addImage" value="Add image" />
    <input type="button" id="deleteSelectedImages" class="ui-button ui-widget ui-state-default ui-corner-all" value="Delete selected" onclick="deleteSelectedImages(this);" />
</div>
<table id="tblImages">
    <tbody>
        <tr>
            <c:forEach items="${images}" var="image" varStatus="i">
                <td>
                    <table>
                        <tr id="imageEntity">
                            <td><input type="hidden" id="tblImageId" name="tblImageId" value="${image.id}" /></td>
                            <td><input type="hidden" id="tblImageDescription" name="tblImageDescription" value="${image.description}" /></td>
                            <td><input type="hidden" id="tblCreated" name="tblCreated" value="${image.created}" /></td>
                            <td valign="top"><input type="checkbox" id="${'imageCheck'.concat(image.id)}" value="${image.id}" class="imageCheck"/></td>
                            <td><label for="${'imageCheck'.concat(image.id)}"><img src='${"getImage/".concat(image.id)}' title="${'id: '.concat(image.id).concat(', ').concat(image.description).concat(', added: ').concat(image.created)}" width="100" height="100" class="editImage" /></label></td>
                        </tr>
                    </table>
                </td>
            </c:forEach>
        </tr>
    </tbody>
</table>
</body>
</html>
