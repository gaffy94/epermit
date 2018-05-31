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
                        <h3><strong><i class="fa fa-user"></i> Create Rider</strong></h3>
                    </div>
                </div>
                <%--start here--%>
                <form method="post" action="\inputter\createriderdetails">
                    <div class="row">
                        <div class="col-md-6 col-md-6">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2><i class="glyphicon glyphicon-qrcode"></i> User Unique Code</h2>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <strong>User Unique Code : ${uniqueid}</strong>
                                </div>
                            </div>
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2><i class="glyphicon glyphicon-th-list"></i> Personal Information</h2>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <br>
                                    <div class="form-horizontal form-label-left input_mask" name="rider" id="rider">
                                        <input type="hidden" value="${id}" name="id"/>
                                        <div class="form-group">
                                            <label for="firstname" class="control-label col-md-3 col-sm-3 col-xs-12">First
                                                Name</label>
                                            <div class="col-md-8 col-sm-6 col-xs-12 form-group has-feedback">
                                                <input name="firstname" class="form-control has-feedback-left"
                                                       id="firstname" placeholder="First Name" required="" type="text">
                                                <span class="fa fa-user form-control-feedback left"
                                                      aria-hidden="true"></span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="middlename" class="control-label col-md-3 col-sm-3 col-xs-12">Middle
                                                Name</label>
                                            <div class="col-md-8 col-sm-6 col-xs-12 form-group has-feedback">
                                                <input name="middlename" class="form-control has-feedback-left"
                                                       id="middlename" placeholder="Middle Name" required=""
                                                       type="text">
                                                <span class="fa fa-user form-control-feedback left"
                                                      aria-hidden="true"></span>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="surname"
                                                   class="control-label col-md-3 col-sm-3 col-xs-12">Surname</label>
                                            <div class="col-md-8 col-sm-6 col-xs-12 form-group has-feedback">
                                                <input name="surname" class="form-control has-feedback-left"
                                                       id="surname"
                                                       placeholder="Last Name" required="" type="text">
                                                <span class="fa fa-user form-control-feedback left"
                                                      aria-hidden="true"></span>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="gender" class="control-label col-md-3">Gender</label>
                                            <div class="col-md-8 col-sm-6 col-xs-12">
                                                <input class="radio-inline" name="gender" required=""
                                                       value="Male" type="radio"> Male
                                            </div>
                                            <div class="col-md-8 col-sm-6 col-xs-12">
                                                <input class="radio-inline" name="gender" id="gender" required=""
                                                       value="Female" type="radio"> Female
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="dob" class="control-label col-md-3 col-sm-3 col-xs-12">Date of
                                                Birth</label>
                                            <div class="col-md-8 col-sm-6 col-xs-12 form-group has-feedback">
                                                <input name="dob" class="form-control has-feedback-left" id="dob"
                                                       required="" type="date">
                                                <span class="fa fa-calendar form-control-feedback left"
                                                      aria-hidden="true"></span><br><br><br>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="email" class="control-label col-md-3 col-sm-3 col-xs-12">Email</label>
                                            <div class="col-md-8 col-sm-6 col-xs-12 form-group has-feedback">
                                                <input name="email" class="form-control has-feedback-left"
                                                       id="email" placeholder="Email" required=""
                                                       type="email">
                                                <span class="fa fa-user form-control-feedback left"
                                                      aria-hidden="true"></span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="phonenumber" class="control-label col-md-3 col-sm-3 col-xs-12">Phone Number</label>
                                            <div class="col-md-8 col-sm-6 col-xs-12 form-group has-feedback">
                                                <input name="phonenumber" class="form-control has-feedback-left"
                                                       id="phonenumber" placeholder="Phonenumber" required=""
                                                       type="text">
                                                <span class="fa fa-user form-control-feedback left"
                                                      aria-hidden="true"></span>
                                            </div>
                                        </div>

                                    </div>
                                </div>
                            </div>


                        </div>
                        <div class="col-md-6 col-md-6">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2><i class="glyphicon glyphicon-map-marker"></i> Geographic Information</h2>

                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <br>
                                    <div class="form-group">
                                        <label for="address"
                                               class="control-label col-md-3 col-sm-3 col-xs-12">Address</label>
                                        <div class="col-md-8 col-sm-6 col-xs-12 form-group has-feedback">
                                            <input name="address" class="form-control has-feedback-left"
                                                   id="address"
                                                   placeholder="Street/Area" required="" type="text">
                                            <span class="fa fa-edit form-control-feedback left"
                                                  aria-hidden="true"></span>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label for="country"
                                               class="control-label col-md-3 col-sm-3 col-xs-12">Country</label>
                                        <div class="col-md-8 col-sm-6 col-xs-12 form-group has-feedback">
                                            <select type="select" name="country" id="country"
                                                    class="form-control countrypicker" data-live-search="true"
                                                    data-default="Nigeria" data-flag="true" disabled>

                                            </select>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label for="state" class="control-label col-md-3 col-sm-3 col-xs-12">State
                                            of
                                            Origin</label>
                                        <div class="col-md-8 col-sm-6 col-xs-12 form-group has-feedback">
                                            <select type="text" name="state" class="form-control select" id="state"
                                                    required="">
                                                <option value="" selected="">-------- Choose State --------</option>
                                                <option value="Abia">Abia</option>
                                                <option value="Adamawa">Adamawa</option>
                                                <option value="Akwa Ibom<">Akwa Ibom</option>
                                                <option value="Anambra">Anambra</option>
                                                <option value="Bauchi">Bauchi</option>
                                                <option value="Bayelsa">Bayelsa</option>
                                                <option value="Benue">Benue</option>
                                                <option value="Cross River">Cross River</option>
                                                <option value="Delta">Delta</option>
                                                <option value="Ebonyi">Ebonyi</option>
                                                <option value="Edo">Edo</option>
                                                <option value="Ekiti">Ekiti</option>
                                                <option value="Enugu">Enugu</option>
                                                <option value="Federal Capital Territory">Federal Capital
                                                    Territory
                                                </option>
                                                <option value="Gombe">Gombe</option>
                                                <option value="Imo">Imo</option>
                                                <option value="Jigawa">Jigawa</option>
                                                <option value="Kaduna">Kaduna</option>
                                                <option value="Kano">Kano</option>
                                                <option value="Katsina">Katsina</option>
                                                <option value="Kebbi">Kebbi</option>
                                                <option value="Kogi">Kogi</option>
                                                <option value="Kwara">Kwara</option>
                                                <option value="Lagos">Lagos</option>
                                                <option value="Nasarawa">Nasarawa</option>
                                                <option value="Niger">Niger</option>&gt;
                                                <option value="Ogun">Ogun</option>
                                                <option value="Ondo">Ondo</option>
                                                <option value="Osun">Osun</option>
                                                <option value="Oyo">Oyo</option>
                                                <option value="Plateau">Plateau</option>
                                                <option value="Rivers">Rivers</option>
                                                <option value="Sokoto">Sokoto</option>
                                                <option value="Taraba">Taraba</option>
                                                <option value="Yobe">Yobe</option>
                                                <option value="Zamfara">Zamfara</option>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label for="lga" class="control-label col-md-3 col-sm-3 col-xs-12">Local
                                            Govt</label>
                                        <div class="col-md-8 col-sm-6 col-xs-12 form-group has-feedback">
                                            <select name="lga" class="form-control select" id="lga">
                                                <option value="" selected="">-------- Choose LGA --------</option>
                                                <option value="Aninri">Aninri</option>
                                                <option value="Agwu">Agwu</option>
                                                <option value="Enugu East">Enugu East</option>
                                                <option value="Enugu North">Enugu North</option>
                                                <option value="Enugu South">Enugu South</option>
                                                <option value="Ezeagu">Ezeagu</option>
                                                <option value="Igbo-efifi">Igbo-efifi</option>
                                                <option value="Igbo-eze South">Igbo-eze South</option>
                                                <option value="Igbo-eze North">Igbo-eze North</option>
                                                <option value="Isi Uzo">Isi Uzo</option>
                                                <option value="Nkanu East">Nkanu East</option>
                                                <option value="Nkanu West">Nkanu West</option>
                                                <option value="Nsukka">Nsukka</option>
                                                <option value="Orji River">Orji River</option>
                                                <option value="Udenu">Udenu</option>
                                                <option value="Udi">Udi</option>
                                                <option value="Uzo-uwani">Uzo-uwani</option>
                                            </select>
                                        </div>
                                    </div>

                                    <%--<div class="form-group">--%>
                                    <%--<label for="district" class="control-label col-md-3 col-sm-3 col-xs-12">Senatorial--%>
                                    <%--District</label>--%>
                                    <%--<div class="col-md-8 col-sm-6 col-xs-12 form-group has-feedback">--%>
                                    <%--<select type="select" name="district" class="form-control select" id="district"--%>
                                    <%--required="" disabled="disabled">--%>
                                    <%--<option value="" selected="">-------- Choose District --------</option>--%>
                                    <%--<option value="">Enugu East</option>--%>
                                    <%--<option value="">Enugu North</option>--%>
                                    <%--<option value="">Enugu West</option>--%>
                                    <%--<option value="">Ministry of Transport Enugu</option>--%>
                                    <%--</select>--%>
                                    <%--</div>--%>
                                    <%--</div>--%>

                                    <%--<div class="form-group">--%>
                                    <%--<label for="branch" class="control-label col-md-3 col-sm-3 col-xs-12">Riders--%>
                                    <%--Branch</label>--%>
                                    <%--<div class="col-md-8 col-sm-6 col-xs-12 form-group has-feedback">--%>
                                    <%--<select type="select" name="branch" class="form-control select" id="branch"--%>
                                    <%--required="" disabled="disabled">--%>
                                    <%--<option value="" selected="">-------- Choose Branch --------</option>--%>
                                    <%--<option value="">Branch</option>--%>
                                    <%--<option value="">Branch</option>--%>
                                    <%--<option value="">Branch</option>--%>
                                    <%--<option value="">Branch</option>--%>
                                    <%--</select>--%>
                                    <%--</div>--%>
                                    <%--</div>--%>

                                    <%--<div class="form-group">--%>
                                    <%--<label for="unit"--%>
                                    <%--class="control-label col-md-3 col-sm-3 col-xs-12">Unit/Ward</label>--%>
                                    <%--<div class="col-md-8 col-sm-6 col-xs-12 form-group has-feedback">--%>
                                    <%--<select type="select" name="unit" class="form-control select" id="unit"--%>
                                    <%--required="" disabled="disabled">--%>
                                    <%--<option value="" selected="">-------- Choose Unit/Ward --------</option>--%>
                                    <%--<option value="">Unit</option>--%>
                                    <%--<option value="">Unit</option>--%>
                                    <%--<option value="">Unit</option>--%>
                                    <%--<option value="">Unit</option>--%>
                                    <%--</select>--%>
                                    <%--</div>--%>
                                    <%--</div>--%>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12 col-md-12">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2><i class="glyphicon glyphicon-picture"></i> Biometric Information</h2>

                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <br>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <video id="screenshot-video" autoplay width="300" height="300"></video>
                                        </div>
                                        <div class="col-md-6">
                                            <img id="screenshot-img" width="250" height="300">
                                        </div>
                                    </div>
                                    <input type="hidden" name="image" id="userimg"/>

                                    <a id="screenshot-button" class="btn btn-default">Take screenshot</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">

                            <button class="btn btn-success btn-lg" type="submit"> Save</button>
                            <button class="btn btn-danger btn-lg" type="reset"> Reset</button>
                        </div>
                    </div>
                </form>

                <%--end here--%>
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
<%--<script src="${pageContext.request.contextPath}/js/countries.js"></script>--%>

<!-- Custom Theme Scripts -->
<script src="${pageContext.request.contextPath}/js/custom.js"></script>
<!--Page Script-->
<script src="${pageContext.request.contextPath}/js/createrider.js"></script>
<!--Page Script-->
<script src="${pageContext.request.contextPath}/js/image.js"></script>
</body>
</html>
