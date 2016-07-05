<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<%@page contentType="text/html;charset=UTF-8"%>

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
    <%--<table id="commentsTable" >--%>
        <%--<c:forEach items="${message.commentsAsFlatTree}" var="comment">--%>
            <%--<tr data-tt-id="${comment.id}" <c:if test="${comment.parentComment != null}">data-tt-parent-id="${comment.parentComment.id}"</c:if>>--%>
                <%--<td>${comment.text}--%>
                    <%--<div class="comment_box commentbox1">--%>

                        <%--<div class="gravatar">--%>
                            <%--<img src="../../resources/images/avator.png" alt="author" />--%>
                        <%--</div>--%>

                        <%--<div class="comment_text">--%>
                            <%--<div class="comment_author">Koshenya<span class="date"><fmt:formatDate type="both" value="${comment.created}" pattern="dd-MM-yyyy" /></span><span class="time"><fmt:formatDate type="both" value="${comment.created}" pattern="HH:mm" /></span></div>--%>
                            <%--<p>${comment.text}</p>--%>
                            <%--<div class="reply"><a href="#">Reply</a></div>--%>
                        <%--</div>--%>
                        <%--<div class="cleaner"></div>--%>
                    <%--</div>--%>
                <%--</td>--%>
            <%--</tr>--%>

        <%--</c:forEach>--%>
    <%--</table>--%>

    <%--<ol class="comments first_level">--%>
        <%--<li>--%>
            <%--<div class="comment_box commentbox1">--%>

                <%--<div class="gravatar">--%>
                    <%--<img src="../../resources/images/avator.png" alt="author" />--%>
                <%--</div>--%>

                <%--<div class="comment_text">--%>
                    <%--<div class="comment_author">Steve<span class="date">December 10, 2048</span><span class="time">12:30 AM</span></div>--%>
                    <%--<p>Phasellus mattis tellus eu risusLorem ipsum dolor sit amet, consectetur adipiscing elit.</p>--%>
                  <%--<div class="reply"><a href="#">Reply</a></div>--%>
                <%--</div>--%>
                <%--<div class="cleaner"></div>--%>
            <%--</div>--%>

        <%--</li>--%>

        <%--<li>--%>
            <%--<ol class="comments">--%>
                <%--<li>--%>
                    <%--<div class="comment_box commentbox2">--%>

                    <%--<div class="gravatar">--%>
                    <%--<img src="../../resources/images/avator.png" alt="author 2" />--%>
                    <%--</div>--%>
                    <%--<div class="comment_text">--%>
                    <%--<div class="comment_author">Ethan<span class="date">December 14, 2048</span><span class="time">10:20 AM</span></div>--%>
                    <%--<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. </p>--%>
                    <%--<div class="reply"><a href="#">Reply</a></div>--%>
                    <%--</div>--%>

                    <%--<div class="cleaner"></div>--%>
                    <%--</div>--%>
                <%--</li>--%>

                <%--<li>--%>
                    <%--<ol class="comments">--%>
                        <%--<li>--%>
                            <%--<div class="comment_box commentbox1">--%>
                                <%--<div class="gravatar">--%>
                                    <%--<img src="../../resources/images/avator.png" alt="author 3" />--%>
                                <%--</div>--%>
                                <%--<div class="comment_text">--%>
                                    <%--<div class="comment_author">Walker<span class="date">December 18, 2048</span><span class="time">11:45 PM</span></div>--%>
                                    <%--<p>Donec nunc neque, pulvinar a, vestibulum eget, luctus id, orci.   Pellentesque elementum enim a augue. Donec in nisi. <a href="#">Etiam sit amet turpis</a>.</p>--%>
                                  <%--<div class="reply"><a href="#">Reply</a></div>--%>
                                <%--</div>--%>

                                <%--<div class="cleaner"></div>--%>
                            <%--</div>--%>
                        <%--</li>--%>
                    <%--</ol>--%>
                <%--</li>--%>
            <%--</ol>--%>

        <%--</li>--%>

        <%--<li>--%>
            <%--<div class="comment_box commentbox2">--%>


                <%--<div class="gravatar">--%>
                    <%--<img src="../../resources/images/avator.png" alt="author 4" />--%>
                <%--</div>--%>
                <%--<div class="comment_text">--%>
                    <%--<div class="comment_author">Steve<span class="date">December 24, 2048</span><span class="time">10:55 AM</span></div>--%>
                    <%--<p>Nam sodales, pede vel dapibus lobortis, ipsum diam molestie risus, a vulputate risus nisl pulvinar lacus.</p>--%>
                  <%--<div class="reply"><a href="#">Reply</a></div>--%>
                <%--</div>--%>

                <%--<div class="cleaner"></div>--%>
            <%--</div>--%>


        <%--</li>--%>

        <%--<li>--%>
            <%--<div class="comment_box commentbox1">--%>

                <%--<div class="gravatar">--%>
                    <%--<img src="../../resources/images/avator.png" alt="author 5" />--%>
                <%--</div>--%>
                <%--<div class="comment_text">--%>
                    <%--<div class="comment_author">Gates<span class="date">December 28, 2048</span><span class="time">12:00 PM</span></div>--%>
                    <%--<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus dictum ornare nulla ac laoreet.</p>--%>
                  <%--<div class="reply"><a href="#">Reply</a></div>--%>
                <%--</div>--%>

                <%--<div class="cleaner"></div>--%>
            <%--</div>--%>


        <%--</li>--%>

    <%--</ol>--%>
</div>
                
<div id="comment_form">
    <h3>Leave a comment</h3>

    <form action="#" method="post">
        <div class="form_row">
            <label><strong>Name</strong> (required)</label>
            <br />
            <input type="text" name="name" />
        </div>
        <div class="form_row">
            <label><strong>Email</strong>  (required, will not be published)</label>
            <br />
            <input type="text" name="name" />
        </div>
        <div class="form_row">
            <label><strong>Comment</strong></label>
            <br />
            <textarea  name="comment" rows="" cols=""></textarea>
        </div>
        <input type="submit" name="Submit" value="Submit" class="submit_btn" />
    </form>

</div>