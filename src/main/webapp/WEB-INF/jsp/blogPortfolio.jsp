<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<%@page contentType="text/html;charset=UTF-8"%>

<h2>Галерея кошенят</h2>
<div id="gallery">
    <ul>
        <c:forEach items="${images}" var="image">
            <li>
                <div class="left">
                    <a href="" class="pirobox" title="Project 1"><img src="${image.picture}" alt="${image.id}" /></a>
                </div>
                <div class="right">
                    <%--<h5>Project 1</h5>--%>
                    <p>${image.description}</p>
                    <%--<div class="button"><a href="#">Visit site</a></div>--%>
                </div>
                <div class="cleaner"></div>
            </li>
        </c:forEach>



        <li>
            <div class="left">
                <a href="../../resources/images/gallery/image_01_b.jpg" class="pirobox" title="Project 1"><img src="../../resources/images/gallery/image_01.jpg" alt="1" /></a>
            </div>
            <div class="right">
                <h5>Project 1</h5>
                <p>Integer sed nisi sapien, ut gravida mauris. Validate <a href="http://validator.w3.org/check?uri=referer" rel="nofollow">XHTML</a> &amp; <a href="http://jigsaw.w3.org/css-validator/check/referer" rel="nofollow">CSS</a>.</p>
                <div class="button"><a href="#">Visit site</a></div>
            </div>
            <div class="cleaner"></div>
        </li>

        <li>
            <div class="left">
                <a href="../../resources/images/gallery/image_02_b.jpg" class="pirobox" title="Project 2"><img src="../../resources/images/gallery/image_02.jpg" alt="2" /></a>
            </div>
            <div class="right">
              <h5>Project 2</h5>
              <p>Mauris risus magna, blandit ac suscipit at, tristique id erat.</p>
                <div class="button"><a href="#">Visit site</a></div>
            </div>
            <div class="cleaner"></div>
        </li>

        <li>
            <div class="left">
                <a href="../../resources/images/gallery/image_03_b.jpg" class="pirobox" title="Project 3"><img src="../../resources/images/gallery/image_03.jpg" alt="3" /></a>
            </div>
            <div class="right">
                <h5>Project 3</h5>
              <p>Etiam eu ipsum a arcu sodales consequat sit amet at orci. Nulla in luctus elit.</p>
                <div class="button"><a href="#">Visit site</a></div>
          </div>
             <div class="cleaner"></div>
        </li>

        <li>
            <div class="left">
                <a href="../../resources/images/gallery/image_04_b.jpg" class="pirobox" title="Project 4"><img src="../../resources/images/gallery/image_04.jpg" alt="4" /></a>
            </div>
            <div class="right">
                <h5>Project 4</h5>
                <p>Divamus interdum, tortor at pellentesque pulvinar, diam quam blandit nulla.</p>
                <div class="button"><a href="#">Visit site</a></div>
            </div>
            <div class="cleaner"></div>
        </li>

        <li>
            <div class="left">
                <a href="../../resources/images/gallery/image_05_b.jpg" class="pirobox" title="Project 5"><img src="../../resources/images/gallery/image_05.jpg" alt="5" /></a>
            </div>
            <div class="right">
                <h5>Project 5</h5>
                <p>Divamus interdum, tortor at pellentesque pulvinar, diam quam blandit nulla.</p>
                <div class="button"><a href="#">Visit site</a></div>
            </div>
            <div class="cleaner"></div>
        </li>

        <li>
            <div class="left">
                <a href="../../resources/images/gallery/image_06_b.jpg" class="pirobox" title="Project 6"><img src="../../resources/images/gallery/image_06.jpg" alt="6" /></a>
            </div>
            <div class="right">
                <h5>Project 6</h5>
                <p>Divamus interdum, tortor at pellentesque pulvinar, diam quam blandit nulla.</p>
                <div class="button"><a href="#">Visit site</a></div>
            </div>
            <div class="cleaner"></div>
        </li>
    </ul>

</div>
