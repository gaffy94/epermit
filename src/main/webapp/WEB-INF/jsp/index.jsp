<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>E-Permit </title>

    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet">
    <!-- Custom Theme Style -->
    <link href="${pageContext.request.contextPath}/css/custom.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet">
</head>

<body class="login">
<div>
    <a class="hiddenanchor" id="signup"></a>
    <a class="hiddenanchor" id="signin"></a>

    <div class="login_wrapper">

        <div class="animate form login_form">
            <section class="login_content">
                <form method="POST" action="/user/loginhandler">
                    <h1>Account Login</h1>
                    <div class="alert alert-danger alert-dismissable bottomspace hide" id="message" value="${message}">${message}</div>
                    <div>
                        <input type="text" class="form-control" placeholder="Username" required="" name="username"/>
                    </div>
                    <div>
                        <input type="password" class="form-control" placeholder="Password" required="" name="password"/>
                    </div>
                    <div>
                        <button class="btn btn-default submit" type="submit">Log in</button>
                        <%--<a class="reset_pass" href="#">Lost your password?</a>--%>
                    </div>

                    <div class="clearfix"></div>

                    <div class="separator">


                        <div class="clearfix"></div>
                        <br />

                        <div>

                        </div>
                    </div>
                </form>
            </section>
        </div>


    </div>
</div>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<!--Page Script-->
<script src="${pageContext.request.contextPath}/js/index.js"></script>
</body>
</html>
