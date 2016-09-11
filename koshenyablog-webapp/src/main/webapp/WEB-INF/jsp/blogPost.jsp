<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<%@page contentType="text/html;charset=UTF-8"%>

<script type="text/javascript" src="<c:url value="/resources/js/blogPost.js" />" ></script>

<script type="text/javascript">
    $(document).ready(function() {
        $.ajaxSetup({ cache: true });
        $.getScript('//connect.facebook.net/en_US/sdk.js', function(){
            FB.init({
                appId: 'koshenyablog-webapp',
                version: 'v2.7' // or v2.1, v2.2, v2.3, ...
            });
            $('#loginbutton, #feedbutton').removeAttr('disabled');
            FB.getLoginStatus(updateStatusCallback);
        });
    });
</script>

<div class="post_section">

    <span class="comment"><a href="fullpost.html">${message.comments.size()}</a></span>

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
    <h3>Залишити коментар</h3>

    <%--<div class="fb-login-button" data-max-rows="1" data-size="medium" data-show-faces="false" data-auto-logout-link="false"></div>--%>

    <form id="formAddComment" name="formAddComment" action="addComment" method="post">
        <input type="hidden" value="${message.id}" name="postId" />
        <input type="hidden" value="" name="parentCommentId" id="parentCommentId" />
        <div class="form_row">
            <label><strong>Ім'я</strong> (обов'язково)</label>
            <br />
            <input type="text" name="name" />
        </div>
        <div class="form_row">
            <label><strong>Email</strong>  (обов'язково, не буде показаний)</label>
            <br />
            <input type="text" name="email" />
        </div>
        <div class="form_row">
            <label><strong>Коментар</strong></label>
            <br />
            <textarea name="comment" rows="" cols=""></textarea>
        </div>
        <input type="submit" name="Submit" value="Submit" class="submit_btn" />
    </form>

</div>