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

    <script>
        // Create post dialog
        $(function() {
            var dialog, form;

            function addPost() {
                //dialog.find("form").submit();
                document.formCreatePost.submit();
                /*$("form#formCreatePost").submit(function(event) {
                    event.preventDefault();
                });*/
                dialog.dialog("close");
            }

            function getDialog() {
                var dialogEdit = $("#dialogCreatePost").dialog({
                    autoOpen: false,
                    height: 560,
                    width: 620,
                    modal: true,
                    buttons: {
                        "Save": addPost,
                        Cancel: function () {
                            dialogEdit.dialog("close");
                        }
                    },
                    open: function () {
                        //document.getElementById("postText").value = "123";
                    },
                    close: function () {
                        form[0].reset();
                        //allFields.removeClass("ui-state-error");
                    }
                });

                return dialogEdit;
            }

            dialog = getDialog();

            form = dialog.find("form").on("submit", function (event) {
                event.preventDefault();
            });

            $("#createPost").button().on("click", function () {
                $("#dialogCreatePost").dialog("option", "title", "Create post");
                document.getElementById("picture").value = '';
                document.getElementById("pictureFile").src = "";
                dialog.dialog("open");
            });

            $('.editPost').button().on('click', function() {
                $("#dialogCreatePost").dialog("option", "title", "Edit post");
                var rowCells = $(this).parent().parent().find('td');
                document.getElementById("postId").value = rowCells.eq(0).text();
                document.getElementById("created").value = rowCells.eq(1).text();
                document.getElementById("postHeader").value = rowCells.eq(3).text();
                document.getElementById("postText").value = rowCells.eq(4).text();
                document.getElementById("picture").value = '';
                document.getElementById("pictureFile").src = "getPostFile/" + rowCells.eq(1).text();
                dialog.dialog("open");
            });

        });

        // image refreshing
        function readURL(input) {
            if (input.files && input.files[0]) {
                var reader = new FileReader();

                reader.onload = function (e) {
                    $('#pictureFile').attr('src', e.target.result);
                };

                reader.readAsDataURL(input.files[0]);
            }
        };

    </script>
</head>
<body>

<div id="dialogCreatePost" title="Create new Post">
    <form method="post" enctype="multipart/form-data" action="savePostServlet" name="formCreatePost" id="formCreatePost">
        <fieldset>
            <input type="hidden" id="postId" name="postId"/>
            <input type="hidden" id="created" name="created">
            <label for="postHeader">Header</label>
            <input id="postHeader" name="postHeader" type="text" class="text ui-widget-content ui-corner-all" style="width:555px" /><br/>
            <label for="postText">Text</label>
            <textarea name="postText" id="postText" class="text ui-widget-content ui-corner-all" style="width:555px;height:138px"></textarea>
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
                    <td><input type="button" value="Edit" class="editPost" /></td>
                    <td><input type="button" value="Delete" class="ui-button ui-widget ui-state-default ui-corner-all" /></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
