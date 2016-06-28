// Create post dialog
$(function() {
    var dialog, form;

    function addPost() {
        document.formCreatePost.submit();
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
        document.getElementById("postId").value = rowCells.eq(1).text();
        document.getElementById("created").value = rowCells.eq(2).text();
        document.getElementById("postHeader").value = rowCells.eq(4).text();
        document.getElementById("postText").value = rowCells.eq(5).text();
        document.getElementById("picture").value = '';
        document.getElementById("pictureFile").src = "getPostFile/" + rowCells.eq(1).text();
        $(rowCells).find('#rowPostIsVisible').each(function () {
           if ($(this).attr('checked') != undefined)
               document.getElementById("isVisible").setAttribute("checked","");
            else
               document.getElementById("isVisible").removeAttribute("checked");
        });
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

