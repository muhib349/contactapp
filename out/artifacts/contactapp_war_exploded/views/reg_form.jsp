<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: gazi_muhib
  Date: 8/3/17
  Time: 1:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration Form</title>
</head>
<body>
<table border="2" width="80%" align="center">
    <tr>
        <td height="80px">
            <%--Header Area --%>
            <jsp:include page="include/header.jsp"/>
        </td>
    </tr>
    <tr>
        <td height=50px">
            <%--Menu Area --%>
            <jsp:include page="include/menu.jsp"/>
        </td>
    </tr>

    <tr>
        <td height="400px">
            <f:form action="/register" modelAttribute="userinfo">
                <table border="1">
                    <tr>
                        <td>Full Name</td>
                        <td><f:input path="user.name" /></td>
                    </tr>
                    </br>
                    <tr>
                        <td>Phone</td>
                        <td><f:input path="user.phone" /></td>
                    </tr>
                    </br>
                    <tr>
                        <td>Email</td>
                        <td><f:input type="email" path="user.email" /></td>
                    </tr>
                    </br>
                    <tr>
                        <td>Address</td>
                        <td><f:textarea path="user.address" /></td>
                    </tr>
                    </br>
                    <tr>
                        <td>Username</td>
                        <td><f:input path="user.login_name" /></td>
                    </tr>
                    </br>
                    <tr>
                        <td>Password</td>
                        <td><f:input type="password" path="user.password" /></td>

                    </tr>
                    </br>
                    <tr>
                        <td align="center">
                            <button>Submit</button>
                        </td>
                    </tr>

                </table>
            </f:form>
        </td>
    </tr>
    <tr>
        <td height="25px">
            <%--Footer --%>
            @copyright <a href="#">gazi_muhib</a>
        </td>
    </tr>
</table>

</body>

</html>
