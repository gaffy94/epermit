<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
    <!-- Datatables -->
    <link href="${pageContext.request.contextPath}/css/dataTables.bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/buttons.bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/fixedHeader.bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/responsive.bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/scroller.bootstrap.min.css" rel="stylesheet">

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
                            <li><a href="${pageContext.request.contextPath}/authorizer/dashboard"><i
                                    class="fa fa-th-list"></i> Dashboard</a></li>
                            <li><a href="${pageContext.request.contextPath}/authorizer/verifyriderpage"> <i
                                    class="fa fa-user"></i> Verify Rider</a></li>
                            <li><a href="${pageContext.request.contextPath}/authorizer/logout"> <i
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
        <div class="right_col" role="main">
            <div class="col-sm-12">
                <div class="page-title">
                    <div class="title_left">
                        <h3><strong><i class="fa fa-user"></i>Verify Created Riders</strong></h3>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div id="mainContent" class="dashboard_graph">
                            <div class="row">
                                <div class="col-md-12 col-md-12">
                                    <div class="x_panel">
                                        <div class="x_title">
                                            <h2><i class="fa fa-th-list"></i>Verify Created Riders</h2>
                                            <div class="clearfix"></div>
                                        </div>
                                        <div class="x_content">
                                            <br/>
                                            <div id="table-wrapper">

                                                <table id="datatable-buttons"
                                                       class="table table-striped table-bordered">
                                                    <thead>
                                                    <tr>
                                                        <th>Rider ID</th>
                                                        <th>Rider Surname</th>
                                                        <th>Rider First Name</th>
                                                        <th>Rider Other Names</th>
                                                        <th>Rider Gender</th>
                                                        <th>Rider DOB</th>
                                                        <th>Rider Phone Number</th>
                                                        <th>Rider Email</th>
                                                        <th>Rider Address</th>
                                                        <th>Rider State of Origin</th>
                                                        <th>Rider LGA</th>
                                                        <th>Rider Center</th>
                                                        <th>Rider Image</th>
                                                        <th>Vehicle Unique ID</th>
                                                        <th>Vehicle type</th>
                                                        <th>Vehicle Manufaturer Name</th>
                                                        <th>Vehicle Model</th>
                                                        <th>Vehicle Chassis Number</th>
                                                        <th>Vehicle Engine Number</th>
                                                        <th>Vehicle Plate Number</th>
                                                        <th>Vehicle Registered By</th>
                                                        <th>Vehicle Registration Date</th>
                                                        <th>Created By</th>
                                                        <th>Creation Date</th>


                                                    </tr>
                                                    </thead>
                                                    <tfoot>
                                                    <tr>
                                                        <th>Rider ID</th>
                                                        <th>Rider Surname</th>
                                                        <th>Rider First Name</th>
                                                        <th>Rider Other Names</th>
                                                        <th>Rider Gender</th>
                                                        <th>Rider DOB</th>
                                                        <th>Rider Phone Number</th>
                                                        <th>Rider Email</th>
                                                        <th>Rider Address</th>
                                                        <th>Rider State of Origin</th>
                                                        <th>Rider LGA</th>
                                                        <th>Rider Center</th>
                                                        <th>Rider Image</th>
                                                        <th>Vehicle Unique ID</th>
                                                        <th>Vehicle type</th>
                                                        <th>Vehicle Manufaturer Name</th>
                                                        <th>Vehicle Model</th>
                                                        <th>Vehicle Chassis Number</th>
                                                        <th>Vehicle Engine Number</th>
                                                        <th>Vehicle Plate Number</th>
                                                        <th>Vehicle Registered By</th>
                                                        <th>Vehicle Registration Date</th>
                                                        <th>Created By</th>
                                                        <th>Creation Date</th>


                                                    </tr>
                                                    </tfoot>
                                                    <tbody>

                                                    <c:forEach var="user" items="${users}">
                                                        <tr>
                                                            <td>${user.riderUniqueCode}</td>
                                                            <td>${user.riderSurname}</td>
                                                            <td>${user.riderFirstname}</td>
                                                            <td>${user.riderOtherNames}</td>
                                                            <td>${user.riderGender}</td>
                                                            <td>${user.riderDateOfBirth}</td>
                                                            <td>${user.riderPhonenumber} </td>
                                                            <td>${user.riderEmail}</td>
                                                            <td>${user.riderAddress}</td>
                                                            <td>${user.riderStateOfOrigin}</td>
                                                            <td>${user.riderLocalGovt}</td>
                                                            <td>${user.center.centerName}, ${user.center.centerLocation} </td>
                                                            <td><img src="${user.riderImageData}" class="img img-responsive"/></td>
                                                            <td>${user.vehicleDetails.vehicleUniqueId}</td>
                                                            <td>${user.vehicleDetails.vehicleType}</td>
                                                            <td>${user.vehicleDetails.vehicleManufacturerName}</td>
                                                            <td>${user.vehicleDetails.vehicleModel}</td>
                                                            <td>${user.vehicleDetails.vehicleChassisNumber}</td>
                                                            <td>${user.vehicleDetails.vehicleEngineNumber}</td>
                                                            <td>${user.vehicleDetails.vehiclePlateNumber}</td>
                                                            <td>${user.vehicleDetails.vehicleRegisteredBy}</td>
                                                            <td>${user.vehicleDetails.vehicleRegistrationDate}</td>
                                                            <td>${user.riderRegisteredBy}</td>
                                                            <td>${user.riderRegistrationDate}</td>
                                                        </tr>
                                                    </c:forEach>
                                                    </tbody>
                                                </table>
                                            </div>

                                        </div>
                                    </div>
                                </div>
                            </div>
                            <br/>
                        </div>
                        <div class="col-md-12" align="center" style="margin-top:10px">
                            <button id="button" class="btn-lg btn btn-danger">Verify Selected</button>
                            <button id="buttonreject" class="btn-lg btn btn-danger">Reject Selected</button>
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
<script src="${pageContext.request.contextPath}/js/dataTables.bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/dataTables.buttons.min.js"></script>
<script src="${pageContext.request.contextPath}/js/buttons.bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/buttons.flash.min.js"></script>
<script src="${pageContext.request.contextPath}/js/buttons.html5.min.js"></script>
<script src="${pageContext.request.contextPath}/js/buttons.print.min.js"></script>
<script src="${pageContext.request.contextPath}/js/dataTables.fixedHeader.min.js"></script>
<script src="${pageContext.request.contextPath}/js/dataTables.keyTable.min.js"></script>
<script src="${pageContext.request.contextPath}/js/dataTables.responsive.min.js"></script>
<script src="${pageContext.request.contextPath}/js/responsive.bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/js/dataTables.scroller.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jszip.min.js"></script>
<script src="${pageContext.request.contextPath}/js/pdfmake.min.js"></script>
<script src="${pageContext.request.contextPath}/js/vfs_fonts.js"></script>
<!-- FastClick -->
<script src="${pageContext.request.contextPath}/js/fastclick.js"></script>
<!-- NProgress -->
<script src="${pageContext.request.contextPath}/js/nprogress.js"></script>
<!-- bootstrap-progressbar -->
<script src="${pageContext.request.contextPath}/js/bootstrap-progressbar.min.js"></script>
<!-- Custom Theme Scripts -->
<script src="${pageContext.request.contextPath}/js/custom.js"></script>
<!--Page Script-->
<script src="${pageContext.request.contextPath}/js/verifyrider.js"></script>
</body>
</html>
