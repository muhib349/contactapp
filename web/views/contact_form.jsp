<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: gazi_muhib
  Date: 8/26/17
  Time: 2:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Contact Form</title>
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
            <f:form action="/save_contact" modelAttribute="command">
                <table border="1">
                    <tr>
                        <td>Full Name</td>
                        <td><f:input path="name" /></td>
                    </tr>
                    <tr>
                        <td>Phone</td>
                        <td><f:input path="phone" /></td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td><f:input type="email" path="email" /></td>
                    </tr>
                    <tr>
                        <td>Address</td>
                        <td><f:textarea path="address" /></td>
                    </tr>
                    <tr>
                        <td>Remark</td>
                        <td><f:input path="remark" /></td>
                    </tr>
                    <tr>
                        <td align="center">
                            <button>Save</button>
                        </td>
                    </tr>

                </table>
            </f:form>
        </td>
    </tr>
    <tr>
        <td height="25px">
            <%--Footer --%>
        </td>
    </tr>
</table>
</body>
</html>
