/**
 * Created by sony on 8/24/2016.
 */
function mainMenuProcessor() {
    var refs = $('#blogMenu').find('a');
    $.each(refs, function (index, value) {
        $(value).on('click', function () {
            $(this).addClass('current');
        });
    })
}
