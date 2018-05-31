<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="images/favicon.ico" type="image/ico"/>
    <title> ePermit </title>
    <!-- Bootstrap -->
    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="${pageContext.request.contextPath}/css/nprogress.css" rel="stylesheet">
    <!-- bootstrap-progressbar -->
    <link href="${pageContext.request.contextPath}/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
    <%--<!-- JQVMap -->--%>
    <%--<link href="${pageContext.request.contextPath}/css/jqvmap.min.css" rel="stylesheet"/>--%>
    <%--<!-- bootstrap-daterangepicker -->--%>
    <%--<link href="${pageContext.request.contextPath}/css/daterangepicker.css" rel="stylesheet">--%>

    <!-- Custom Theme Style -->
    <link href="${pageContext.request.contextPath}/css/custom.min.css" rel="stylesheet">

    <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet">
</head>

<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <div class="col-md-3 left_col">
            <div class="left_col scroll-view">
                <div class="navbar nav_title" style="border: 0;">
                    <a href="#" class="site_title"><i class="fa fa-taxi"></i> Riders ePermit <span></span></a>
                </div>

                <!-- menu profile quick info -->
                <div class="profile clearfix">
                    <div class="profile_pic">
                        <img src="${pageContext.request.contextPath}/img/img.jpg" alt="..."
                             class="img-circle profile_img">
                    </div>
                    <div class="profile_info">
                        <span>Welcome,</span>
                        <h2>${userDetails.surname}, ${userDetails.fname} </h2>
                    </div>
                </div>
                <!-- /menu profile quick info -->

                <br/>

                <!-- sidebar menu -->
                <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
                    <div class="menu_section">
                        <h3>Role: ${userDetails.roleId}</h3>
                        <hr>
                        <ul class="nav side-menu">
                            <li id="user" class="active"><a href="${pageContext.request.contextPath}/inputter/dashboard"><i class="fa fa-th-list"></i> Dashboard</a></li>
                            <li><a href="${pageContext.request.contextPath}/inputter/createriderdetailspage"><i
                                    class="fa fa-user"></i> Create Rider Details</a></li>
                            <li><a href="${pageContext.request.contextPath}/inputter/rejectspage"><i
                                    class="fa fa-user"></i>Rejected Creations </a></li>
                            <li><a href="${pageContext.request.contextPath}/inputter/continueregistration"><i
                                    class="fa fa-user"></i> Continue Registration</a></li>
                            <li><a href="${pageContext.request.contextPath}/inputter/logout"> <i
                                    class="fa fa-sign-out"></i> Log Off</a></li>
                        </ul>
                    </div>

                </div>
                <!-- /sidebar menu -->

                <!-- /menu footer buttons -->

                <!-- /menu footer buttons -->
            </div>
        </div>

        <!-- top navigation -->

        <!-- /top navigation -->

        <!-- page content -->
        <div class="right_col" role="main">
            <div class="col-sm-12">
                <div class="page-title">
                    <div class="title_left">
                        <h3><strong><i class="fa fa-user"></i>Resume Rider Registration</strong></h3>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div id="mainContent" class="dashboard_graph">
                            <div class="row">
                                <div class="col-md-12 col-md-12">
                                    <div class="x_panel">
                                        <div class="x_title">
                                            <h2><i class="fa fa-user"></i> Input User Unique ID </h2>
                                            <div class="clearfix"></div>
                                        </div>
                                        <div class="x_content">
                                            <br/>
                                            <div class="${messageclass}" id="message">
                                                <Strong>${message}</Strong>
                                            </div>
                                            <form method="post" action="${pageContext.request.contextPath}/inputter/continuereg" class="form-horizontal form-label-left input_mask" name="rider" id="rider">

                                                <div class="form-group">
                                                    <label for="uniqueid" class="control-label col-md-3 col-sm-3 col-xs-12">Unique Rider ID</label>
                                                    <div class="col-md-4 col-sm-4 col-xs-12 form-group has-feedback">
                                                        <input type="text" name="uniqueid" class="form-control has-feedback-left" id="uniqueid" placeholder="Enter Rider Unique ID" required>
                                                        <span class="fa fa-user form-control-feedback left" aria-hidden="true"></span>
                                                    </div>
                                                </div>

                                                <div class="col-md-offset-3 col-md-6">
                                                    <button type="submit" id="verify" class="btn btn-info"><i class="glyphicon glyphicon-search"></i> Verify</button>
                                                    <button class="btn btn-warning" type="reset"><i class="glyphicon glyphicon-refresh"></i> Reset</button>
                                                    <br /><br />
                                                </div>

                                            </form>


                                        </div>
                                    </div>
                                </div>
                            </div>
                            <br/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
<!-- Datatables -->
<script src="${pageContext.request.contextPath}/js/jquery.dataTables.min.js"></script>
<!-- FastClick -->
<script src="${pageContext.request.contextPath}/js/fastclick.js"></script>
<!-- NProgress -->
<script src="${pageContext.request.contextPath}/js/nprogress.js"></script>
<!-- Chart.js -->
<script src="${pageContext.request.contextPath}/js/Chart.min.js"></script>
<!-- gauge.js -->
<script src="${pageContext.request.contextPath}/js/gauge.min.js"></script>
<!-- bootstrap-progressbar -->
<script src="${pageContext.request.contextPath}/js/bootstrap-progressbar.min.js"></script>
<!-- JQVMap -->
<script src="${pageContext.request.contextPath}/js/jquery.vmap.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.vmap.world.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.vmap.sampledata.js"></script>
<!-- bootstrap-daterangepicker -->
<script src="${pageContext.request.contextPath}/js/moment.js"></script>
<script src="${pageContext.request.contextPath}/js/daterangepicker.js"></script>
<script src="${pageContext.request.contextPath}/js/countrypicker.js"></script>
<script src="${pageContext.request.contextPath}/js/countries.js"></script>

<!-- Custom Theme Scripts -->
<script src="${pageContext.request.contextPath}/js/custom.js"></script>
<!--Page Script-->
</body>
</html>
