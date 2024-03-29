<%@ taglib prefix="dec" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title><dec:title default="Master-layout"/> </title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Bootstrap styles -->
    <link  href="<c:url value="/assets/user/css/bootstrap.css"/>" rel="stylesheet"/>

    <!-- Customize styles -->

    <link  href="<c:url value="/assets/user/style.css"/>" rel="stylesheet"/>
    <!-- font awesome styles -->

    <link  href="<c:url value="/assets/user/font-awesome/css/font-awesome.css"/>" rel="stylesheet"/>

    <!--[if IE 7]>

    <link  href="<c:url value="/assets/user/font-awesome/css/font-awesome-ie7.min.css"/>" rel="stylesheet"/>




    <![endif]-->

    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Favicons -->

    <link  href="<c:url value="/assets/user/ico/favicon.ico"/>" rel="stylesheet"/>
    <dec:head/>
</head>
<body>
<!--
	Upper Header Section
-->
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="topNav">
        <div class="container">
            <div class="alignR">
                <div class="pull-left socialNw">
                    <a href="#"><span class="icon-twitter"></span></a>
                    <a href="#"><span class="icon-facebook"></span></a>
                    <a href="#"><span class="icon-youtube"></span></a>
                    <a href="#"><span class="icon-tumblr"></span></a>
                </div>
                <a class="active" href="index.html"> <span class="icon-home"></span> Home</a>
                <a href="#"><span class="icon-user"></span> My Account</a>
                <a href="register.html"><span class="icon-edit"></span> Free Register </a>
                <a href="contact.html"><span class="icon-envelope"></span> Contact us</a>
                <a href="cart.html"><span class="icon-shopping-cart"></span> 2 Item(s) - <span class="badge badge-warning"> $448.42</span></a>
            </div>
        </div>
    </div>
</div>

<!--
Lower Header Section
-->
<div class="container">
    <div id="gototop"> </div>
    <%@include file="user/header.jsp"%>
    <!--
    Body Section
    -->
    <dec:body/>
    <!--
    Clients
    -->
    <%@include file="user/footer.jsp"%>
</div>


<div class="copyright">
    <div class="container">
        <p class="pull-right">
            <a href="#"><img src="<c:url value="/assets/user/img/maestro.png"/>" alt="payment"></a>
            <a href="#"><img src="<c:url value="/assets/user/img/mc.png"/>" alt="payment"></a>
            <a href="#"><img src="<c:url value="/assets/user/img/pp.png"/>" alt="payment"></a>
            <a href="#"><img src="<c:url value="/assets/user/img/visa.png"/>" alt="payment"></a>
            <a href="#"><img src="<c:url value="/assets/user/img/disc.png"/>" alt="payment"></a>
        </p>
        <span>Copyright &copy; 2013<br> bootstrap ecommerce shopping template</span>
    </div>
</div>
<a href="#" class="gotop"><i class="icon-double-angle-up"></i></a>
<!-- Placed at the end of the document so the pages load faster -->
<script src="<c:url value="/assets/user/js/jquery.js"/>"></script>



<script src="<c:url value="/assets/user/js/bootstrap.min.js"/>"></script>


<script src="<c:url value="/assets/user/js/jquery.easing-1.3.min.js"/>"></script>



<script src="<c:url value="/assets/user/js/jquery.scrollTo-1.4.3.1-min.js"/>"></script>


<script src="<c:url value="/assets/user/js/shop.js"/>"></script>

</body>
</html>

