// $(function() {
//
//     $("#formAddComment").on('submit', function(action) {
//         window.alert("Here!");
//         event.preventDefault();
//        
//         document.formAddComment.submit();
//     });
// });

function commentReplyClick(commentId) {
    $("#parentCommentId").val(commentId);
}
