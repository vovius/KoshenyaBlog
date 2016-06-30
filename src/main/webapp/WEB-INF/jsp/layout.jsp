<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<%@page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Блог про кошенят</title>
<meta name="keywords" content="cat kitty blog" />
<meta name="description" content="Cat blog" />
<link href="<c:url value="/resources/css/templatemo_style.css"/>" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/s3slider.css" />" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/koshenya.css" />" rel="stylesheet" type="text/css" />
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

            <tiles:insertAttribute name="body" />

		</div>
    
  <div class="cleaner"></div>
  </div> 
    <!-- end of templatemo_main -->
  <div class="cleaner_h20"></div>
  
  	<div id="templatemo_footer">
    
		Copyright © 2016 <a href="#">Коханий чоловік</a> |
        <a href="http://www.koshenya.com" target="_parent">Lovely made</a> for <a href="http://www.koshenya.com" target="_parent">my Koshenya</a>
        
    </div>
  
    <div class="cleaner"></div>
</div> <!-- end of warpper -->

</body>
</html>