<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<%@page contentType="text/html;charset=UTF-8"%>

<script type="text/javascript" src="<c:url value="/resources/js/blogPost.js" />" ></script>

<div class="post_section">

    <span class="comment"><a href="fullpost.html">256</a></span>

    <h2>${message.header}</h2>

    <fmt:formatDate type="both" value="${message.created}" dateStyle="long" timeStyle="short" /> | <strong>Author:</strong> Koshenya | <strong>Category:</strong> <a href="#">Post</a>

    <img src='${"getPostFile/".concat(message.id)}' alt="image 1" width="430" height="300" />

    <p>${message.getProcessedText()}</p>

</div>
            
<div class="comment_tab">
    Comments
</div>
            
<div id="comment_section">
    ${message.commentsTreeHtml}
</div>
                
<div id="comment_form">
    <a name="c"></a>
    <h3>Leave a comment</h3>

    <form id="formAddComment" name="formAddComment" action="addComment" method="post">
        <input type="hidden" value="${message.id}" name="postId" />
        <input type="hidden" value="" name="parentCommentId" id="parentCommentId" />
        <div class="form_row">
            <label><strong>Name</strong> (required)</label>
            <br />
            <input type="text" name="name" />
        </div>
        <div class="form_row">
            <label><strong>Email</strong>  (required, will not be published)</label>
            <br />
            <input type="text" name="email" />
        </div>
        <div class="form_row">
            <label><strong>Comment</strong></label>
            <br />
            <textarea name="comment" rows="" cols=""></textarea>
        </div>
        <input type="submit" name="Submit" value="Submit" class="submit_btn" />
    </form>

</div>