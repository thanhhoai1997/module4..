<%@ include file="/common/taglib.jsp" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 12/1/2023
  Time: 5:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Trang Chu</title>
    <!-- Bootstrap core CSS -->

    <link href="<c:url value='/template/web/vendor/bootstrap/css/bootstrap.min.css'/> " rel="stylesheet"  >

    <!-- Custom styles for this template -->


    <link href="<c:url value='/template/web/css/small-business.css'/> " rel="stylesheet"  >

</head>
<body>
<!-- Navigation -->
<%@ include file="/common/web/header.jsp" %>
<!-- Page Content -->
<dec:body/>
<!-- /.container -->
<%@ include file="/common/web/footer.jsp" %>
<!-- Footer -->


<!-- Bootstrap core JavaScript -->

<script src="<c:url value='/template/web/vendor/jquery/jquery.min.js'/>"></script>

<script src="<c:url value='/template/web/vendor/bootstrap/js/bootstrap.bundle.min.js'/>"></script>


</body>
</html>
