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
                    <li id="user"><a href="${pageContext.request.contextPath}/admin/dashboard"><i
                            class="fa fa-th-list"></i> Dashboard</a></li>
                    <li class="active"><a href="${pageContext.request.contextPath}/admin/createuserpage"><i
                            class="fa fa-user"></i> Create User</a></li>
                    <li><a href="${pageContext.request.contextPath}/admin/rejectspage"><i
                            class="fa fa-user"></i> Rejected Users</a></li>
                    <li><a href="${pageContext.request.contextPath}/admin/logout"> <i
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
        <h3><strong><i class="fa fa-user"></i> Create User</strong></h3>
    </div>
</div>
<div class="row">
<div class="col-md-12 col-sm-12 col-xs-12">
<div id="mainContent" class="dashboard_graph">
<div class="row">
<div class="col-md-12 col-md-12">
<div class="x_panel">
<div class="x_title">
    <h2><i class="fa fa-th-list"></i> Create User</h2>
    <div class="clearfix"></div>
</div>
<div class="x_content">
<br/>
<div class="${messageclass}" id="message">
    <Strong>${message}</Strong>
</div>
<form method="POST"
action="${pageContext.request.contextPath}/admin/createuser"
class="form-horizontal form-label-left input_mask" name="rider"
id="rider">
<input type="hidden" name="id" value="${user.id}"/>
<div class="form-group">
    <label for="surname"
           class="control-label col-md-3 col-sm-3 col-xs-12">Surname</label>
    <div class="col-md-4 col-sm-4 col-xs-12 form-group has-feedback">
        <input type="text" name="surname"
               class="form-control has-feedback-left" id="surname"
               value="${user.surname}" required>
        <i class="fa fa-user form-control-feedback left"
           aria-hidden="true"></i>
    </div>
</div>


<div class="form-group">
    <label for="fname"
           class="control-label col-md-3 col-sm-3 col-xs-12">First
        Name</label>
    <div class="col-md-4 col-sm-4 col-xs-12 form-group has-feedback">
        <input type="text" name="fname"
               class="form-control has-feedback-left" id="fname"
               value="${user.fname}" required>
        <i class="fa fa-user form-control-feedback left"
           aria-hidden="true"></i>
    </div>
</div>

<div class="form-group">
    <label for="username"
           class="control-label col-md-3 col-sm-3 col-xs-12">Username</label>
    <div class="col-md-4 col-sm-4 col-xs-12 form-group has-feedback">
        <input type="text" name="username"
               class="form-control has-feedback-left" id="username"
               value="${user.username}" required>
        <i class="fa fa-user form-control-feedback left"
           aria-hidden="true"></i>
    </div>
</div>

<div class="form-group">
    <label for="email"
           class="control-label col-md-3 col-sm-3 col-xs-12">Email</label>
    <div class="col-md-4 col-sm-4 col-xs-12 form-group has-feedback">
        <input type="email" name="email"
               class="form-control has-feedback-left" id="email"
               required value="${user.email}">
        <i class="fa fa-envelope form-control-feedback left"
           aria-hidden="true"></i>
    </div>
</div>

<div class="form-group">
    <label for="phonenumber"
           class="control-label col-md-3 col-sm-3 col-xs-12">Phone
        Number</label>
    <div class="col-md-4 col-sm-4 col-xs-12 form-group has-feedback">
        <input type="text" name="phonenumber"
               class="form-control has-feedback-left" id="phonenumber"
               required value="${user.phonenumber}">
        <i class="fa fa-phone form-control-feedback left"
           aria-hidden="true"></i>
    </div>
</div>

<div class="form-group">
    <label for="role" class="control-label col-md-3 col-sm-3 col-xs-12">User
        Role</label>
    <div class="col-md-4 col-sm-4 col-xs-12 form-group has-feedback">
        <select type="select" name="role" class="form-control select"
                required id="role" tid="${user.roleId}">
            <option value="" selected>-------- Choose Role --------
            </option>
            <option value="ADMIN">ADMINISTRATOR</option>
            <option value="INPUTTER">INPUTTER</option>
            <option value="AUTHORIZER">AUTHORIZER</option>
            <option value="INTERNAL">INTERNAL COMPLIANCE</option>
            <option value="MANAGEMENT">MANAGEMENT</option>
            <option value="GENERATOR">CARD GENERATOR</option>
            <option value="AGENTS">ENFORCEMENT AGENTS</option>
        </select>
    </div>
</div>
<div class="form-group hide" id="centercontainer">
<label for="center"
       class="control-label col-md-3 col-sm-3 col-xs-12">Center</label>
<div class="col-md-4 col-sm-4 col-xs-12 form-group has-feedback">
<select type="select" name="center" class="form-control select"
id="center">
<option value="" selected>-------- Choose Center --------
</option>
<c:forEach var="center" items="${centers}">
    <option value="${center.id}">${center.centerName} , ${center.centerLocation}</option>
</c:forEach>
    </select>
    </div>
    </div>

    <div class="col-md-offset-4 col-md-6">
    <button type="submit" id="create" name="create"
    class="btn btn-info"><i
    class="glyphicon glyphicon-upload"></i> Create
    </button>
    <button class="btn btn-warning" type="reset"><i
    class="glyphicon glyphicon-refresh"></i> Reset
    </button>
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
    <script src="${pageContext.request.contextPath}/js/createuser.js"></script>
    </body>
    </html>
