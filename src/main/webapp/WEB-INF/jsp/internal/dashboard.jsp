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
                            <li id="user" class="active"><a href="${pageContext.request.contextPath}/internal/dashboard"><i class="fa fa-th-list"></i> Dashboard</a></li>
                            <li><a href="${pageContext.request.contextPath}/internal/verifyuserpage"><i
                                    class="fa fa-user"></i> Verify User</a></li>
                            <li><a href="${pageContext.request.contextPath}/internal/logout"><i
                                    class="fa fa-sign-out"></i> log Off</a></li>
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
        <div class="right_col" role="main" >
            <div class="col-sm-12">
                <div class="page-title">
                    <div class="title_left">
                        <h3><strong><i class="fa fa-user"></i> User Dashboard</strong></h3>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div id="mainContent" class="dashboard_graph">
                            <div class="row">
                                <div class="col-md-12 col-md-12">
                                    <div class="x_panel">
                                        <div class="x_title">
                                            <h2><i class="fa fa-th-list"></i> User Dashboard</h2>
                                            <div class="clearfix"></div>
                                        </div>
                                        <div class="x_content">
                                            <!-- top tiles -->
                                            <div class="row tile_count"  id="dashboard">
                                                <div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
                                                    <span class="count_top"><i class="fa fa-user"></i>Created Users</span>
                                                    <div class="count green">250</div>
                                                    <span class="count_bottom"><i class="green">4% </i> From last Week</span>
                                                </div>
                                                <div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
                                                    <span class="count_top"><i class="fa fa-user"></i> Rejected Creations</span>
                                                    <div class="count green">2100</div>
                                                    <span class="count_bottom"><i class="green"><i class="fa fa-sort-asc"></i>3% </i> From last Week</span>
                                                </div>
                                                <div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
                                                    <span class="count_top"><i class="fa fa-user"></i> Total Active Users</span>
                                                    <div class="count green">2,500</div>
                                                    <%--<span class="count_bottom"><i class="green"><i class="fa fa-sort-asc"></i>34% </i> From last Week</span>--%>
                                                </div>
                                            </div>
                                            <!-- /top tiles -->
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

</body>
</html>
