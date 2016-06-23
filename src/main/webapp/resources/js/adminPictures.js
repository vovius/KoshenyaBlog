// clearing the dialog
$(document).ready(function(){
    document.getElementById("picture").value = '';
    document.getElementById("pictureFile").src = '';
});

// Create post dialog
$(function() {
    var dialog, form;

    function addImage() {
        document.formAddImage.submit();
        dialog.dialog("close");
    }

    function getDialog() {
        var dialogEdit = $("#dialogAddImage").dialog({
            autoOpen: false,
            height: 560,
            width: 620,
            modal: true,
            buttons: {
                "Save": addImage,
                "Cancel": function () {
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

    $("#addImage").button().on("click", function () {
        $("#dialogAddImage").dialog("option", "title", "Add image");
        document.getElementById("picture").value = '';
        document.getElementById("pictureFile").src = '';
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
}

