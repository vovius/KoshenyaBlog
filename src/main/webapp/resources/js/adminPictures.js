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

    // setting 'checked' property for the checkboxes once clicked
    $('.imageCheck').click(function() {
        this.setAttribute('checked',this.checked);
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

// delete selected images
function deleteSelectedImages(input) {
    var allCheckbox = $("#tblImages").find("[type=checkbox]");
    var checkedIds = new Array();
    $.each(allCheckbox, function(index, value) {
        if (value.checked) {
            console.log(value.value);
            checkedIds.push(parseInt(value.value));
        }
    });
    
    var data = JSON.stringify({
            imageIds: checkedIds
        });

    $.ajax({
        type: 'POST',
        url: 'adminPictures/deleteImages',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        data: data,
        success: function (data) {
            location.reload();
        }
    });

}
