<%--
  Created by IntelliJ IDEA.
  User: gazi_muhib
  Date: 7/29/17
  Time: 5:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${sessionScope.logedUser.getName()} |Home</title>
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
            <%-- Page Content --%>
            <h2>${sessionScope.logedUser.getName()} Dashboard</h2>
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
