<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<%@page contentType="text/html;charset=UTF-8"%>

<script type="text/javascript" src="<c:url value="/resources/js/blogPosts.js" />"></script>

<c:forEach items="${messages}" var="message">
    <c:if test="${message.visible}">
        <div class="post_section">

            <span class="comment"><a href="${'blogPost/'.concat(message.id)}">${message.comments.size()}</a></span>

            <h2><a href="${'blogPost/'.concat(message.id)}">${message.header}</a></h2>

            <fmt:formatDate type="both" value="${message.created}" dateStyle="long" timeStyle="short" /> | <strong>Author:</strong> Koshenya | <strong>Category:</strong> <a href="#">Post</a>

            <img src='${"getPostFile/".concat(message.id)}' alt="image 1" width="430" height="300" />

            <div id="blogPostsMessageText" name="blogPostsMessageText"><p>${message.getProcessedText()}</p></div>
            <a href="${'blogPost/'.concat(message.id)}">Читати далі...</a>

        </div>
    </c:if>
</c:forEach>

