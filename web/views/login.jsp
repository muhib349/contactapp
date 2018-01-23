<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: gazi_muhib
  Date: 7/29/17
  Time: 3:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link href="<c:url value="/resources/css/loginstyle.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/loginjquery.js" />"></script>
    <jsp:include page="include/menu.jsp"/>

</head>
<body>
<!--
    you can substitue the span of reauth email for a input with the email and
    include the remember me checkbox
    -->

<div class="container">
    <div class="card card-container">
        <!-- <img class="profile-img-card" src="//lh3.googleusercontent.com/-6V8xOA6M7BA/AAAAAAAAAAI/AAAAAAAAAAA/rzlHcD0KYwo/photo.jpg?sz=120" alt="" /> -->
        <img id="profile-img" class="profile-img-card" src="<c:url value="/resources/images/profilepic.png"/>" />
        <p id="profile-name" class="profile-name-card"></p>

        <form class="form-signin" action="/dashboard" method="post">
            <span id="reauth-email" class="reauth-email"></span>
            <input type="text" id="inputEmail" class="form-control" placeholder="Username" name="username" required autofocus>
            <input type="password" id="inputPassword" class="form-control" placeholder="Password" name="password" required>
            <div id="remember" class="checkbox">
                <label>
                  <!--  <input type="checkbox" value="remember-me"> Remember me -->
                    <a href="/registration-form">Create an Account</a>
                </label>
            </div>
            <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Sign in</button>
        </form><!-- /form -->
        <a href="#" class="forgot-password">
            Forgot the password?
        </a>
    </div><!-- /card-container -->
</div><!-- /container -->

</body>
</html>
