<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Clean Blog Template</title>
<meta name="keywords" content="clean blog template, html css layout" />
<meta name="description" content="Clean Blog Template is provided by templatemo.com" />
<link href="<c:url value="/resources/css/templatemo_style.css"/>" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/s3slider.css" />" rel="stylesheet" type="text/css" />
<!-- JavaScripts-->
<script type="text/javascript" src="<c:url value="/resources/js/jquery.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/s3Slider.js" />"></script>
<script type="text/javascript">
    $(document).ready(function() {
        $('#slider').s3Slider({
            timeOut: 1600
        });
    });
</script>

</head>
<body>

<div id="templatemo_wrapper">

	<div id="templatemo_menu">
                
        <ul>
            <li><a href="index.html" class="current">Blog</a></li>
            <li><a href="portfolio.html">Portfolio</a></li>
            <li><a href="about.html">About Us</a></li>
            <li><a href="contact.html">Contact</a></li>
        </ul>	
    
    </div> <!-- end of templatemo_menu -->

    <div id="templatemo_left_column">
    
        <div id="templatemo_header">
        
            <div id="site_title">
                <h1><a href="http://www.templatemo.com" target="_parent">Блог про <strong>кошенят</strong><span>Найкращіх створінь у світі</span></a></h1>
            </div><!-- end of site_title -->
            
        </div> <!-- end of header -->


        <%--<div id="templatemo_sidebar">--%>
    	<%----%>
            <%--<div id="templatemo_rss">--%>
            <%----%>
                <%--<a href="#">SUBSCRIBE NOW <br /><span>to our rss feed</span></a>--%>
                <%----%>
            <%--</div>--%>
            <%----%>
            <%--<h4>Categories</h4>--%>
            <%--<ul class="templatemo_list">--%>
                <%--<li><a href="http://www.templatemo.com/page/1" target="_parent">Curabitur sed</a></li>--%>
                <%--<li><a href="http://www.templatemo.com/page/2" target="_parent">Praesent adipiscing</a></li>--%>
                <%--<li><a href="http://www.templatemo.com/page/3" target="_parent">Duis sed justo</a></li>--%>
                <%--<li><a href="http://www.templatemo.com/page/4" target="_parent">Mauris vulputate</a></li>--%>
                <%--<li><a href="#">Nam auctor</a></li>--%>
                <%--<li><a href="#">Aliquam quam</a></li>--%>
            <%--</ul>--%>
            <%----%>
            <%--<div class="cleaner_h40"></div>--%>
            <%----%>
            <%--<h4>Friends</h4>--%>
            <%--<ul class="templatemo_list">--%>
                <%--<li><a href="http://www.templatemo.com" target="_parent">Free CSS Templates</a></li>--%>
                <%--<li><a href="http://www.flashmo.com" target="_parent">Flash Templates</a></li>--%>
                <%--<li><a href="http://www.flashmo.com/store" target="_parent">Premium Themes</a></li>--%>
                <%--<li><a href="http://www.webdesignmo.com/blog" target="_parent">Web Design Blog</a></li>--%>
                <%--<li><a href="http://www.koflash.com" target="_parent">Flash Web Gallery</a></li>--%>
                <%--<li><a href="#">Curabitur sed lacinia</a></li>--%>
                <%--<li><a href="#">Vestibulum laoreet tincidunt</a></li>--%>
                <%--<li><a href="#">Nullam nec mi enim</a></li>--%>
                <%--<li><a href="#">Aliquam quam nulla</a></li>--%>
                <%--<li><a href="#">Curabitur non felis massa</a></li>--%>
            <%--</ul>--%>
            <%----%>
        <%--</div> <!-- end of templatemo_sidebar -->--%>

    </div> <!-- end of templatemo_left_column -->
    
    <div id="templatemo_right_column">
    
    	<div id="featured_project">
            <div id="slider">
                <ul id="sliderContent">
                    <li class="sliderImage">
                        <a href=""><img src="<c:url value="/resources/images/slider/1.jpg" />" alt="1" /></a>
                        <%--<span class="top"><strong>Project 1</strong><br />Suspendisse turpis arcu, dignissim ac laoreet a, condimentum in massa.</span>--%>
                        <span />
                    </li>
                    <li class="sliderImage">
                        <a href=""><img src="<c:url value="/resources/images/slider/2.jpg" />" alt="2" /></a>
                        <%--<span class="bottom"><strong>Project 2</strong><br />uisque eget elit quis augue pharetra feugiat.</span>--%>
                        <span />
                    </li>
                    <li class="sliderImage">
                        <img src="<c:url value="/resources/images/slider/3.jpg" />" alt="3" />
                        <%--<span class="left"><strong>Project 3</strong><br />Sed et quam vitae ipsum vulputate varius vitae semper nunc.</span>--%>
                        <span />
                    </li>
                    <li class="sliderImage">
                        <img src="<c:url value="/resources/images/slider/4.jpg" />" alt="4" />
                        <%--<span class="right"><strong>Project 4</strong><br />Lorem ipsum dolor sit amet, consectetur adipiscing elit.</span>--%>
                        <span />
                    </li>
                    <li class="clear sliderImage"></li>
                </ul>
            </div>
        </div>
        
        <div id="templatemo_main">

            <c:forEach items="${messages}" var="message">
                <div class="post_section">

                    <span class="comment"><a href="blog_post.html">128</a></span>

                    <h2><a href="blog_post.html">${message.header}</a></h2>

                    <fmt:formatDate type="both" value="${message.created}" dateStyle="long" timeStyle="short" /> | <strong>Author:</strong> Koshenya | <strong>Category:</strong> <a href="#">Post</a>

                    <img src='${"getPostFile/".concat(message.id)}' alt="image 1" width="430" height="100" />

                    <p>${message.text}</p>
                    <a href="blog_post.html">Continue reading...</a>

                </div>
            </c:forEach>
            <div class="post_section">
            
                <span class="comment"><a href="blog_post.html">128</a></span>
            
                <h2><a href="blog_post.html">Aliquam lorem ante dapibus</a></h2>
    
            	December 28, 2048 | <strong>Author:</strong> John | <strong>Category:</strong> <a href="#">Freebies</a>
                
                <img src="<c:url value="/resources/images/templatemo_image_01.jpg" />" alt="image 1" />
                
                <p>Clean Blog is a <a href="http://www.templatemo.com" target="_parent">Free HTML-CSS Template</a> provided by <a href="#">templatemo.com</a> for everyone. Validate <a href="http://validator.w3.org/check?uri=referer" rel="nofollow">XHTML</a> &amp; <a href="http://jigsaw.w3.org/css-validator/check/referer" rel="nofollow">CSS</a>. Donec enim enim, imperdiet quis, mollis a, elementum a, diam. Lorem ipsum  dolor sit amet, consectetur adipiscing elit. Nulla et nunc commodo ante ornare imperdiet.</p>
              <a href="blog_post.html">Continue reading...</a>
                
            </div>
                
            <div class="post_section">
                    
                <span class="comment"><a href="blog_post.html">256</a></span>
            
                <h2><a href="blog_post.html">Lorem ipsum dolor sit amet</a></h2>
                
                December 24, 2048 | <strong>Author:</strong> Steve | <strong>Category:</strong> <a href="#">Web Design</a>
                
                <img src="<c:url value="/resources/images/templatemo_image_02.jpg" />" alt="image 2" />
                
                <p>Credits go to <a href="http://www.smashingmagazine.com/2008/09/23/practika-a-free-icon-set/" target="_blank">Smashing Magazine</a> for icons, <a href="http://www.photovaco.com" target="_blank">Free photos</a> for photos, and <a href="http://www.serie3.info/s3slider/" target="_blank">Serie3</a> for the slider. Ut nec vestibulum odio. Vivamus vitae nibh eu sem malesuada rutrum et sit amet magna. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.</p>
              <a href="blog_post.html">Continue reading...</a>
            
            </div>
		</div>
    
  <div class="cleaner"></div>
  </div> 
    <!-- end of templatemo_main -->
  <div class="cleaner_h20"></div>
  
  	<div id="templatemo_footer">
    
		Copyright © 2048 <a href="#">Your Company Name</a> | 
        <a href="http://www.iwebsitetemplate.com" target="_parent">Website Templates</a> by <a href="http://www.templatemo.com" target="_parent">Free CSS Templates</a>
        
    </div>
  
    <div class="cleaner"></div>
</div> <!-- end of warpper -->

</body>
</html>