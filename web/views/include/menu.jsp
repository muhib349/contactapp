<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: gazi_muhib
  Date: 8/19/17
  Time: 12:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <c:url var="url_logout" value="/logout" />
    <c:url var="user_dash" value="/user/dashboard"/>
    <c:url var="cform" value="/contact_form"/>
    <c:url var="clist" value="/contact_list"/>
</head>
<body>
<%--User Menu--%>
<c:if test="${sessionScope.role==2}">
    <a href="${user_dash}">Home</a>|<a href="${cform}">Add Contact</a>|<a href="${clist}">View Contact</a>|<a href="${url_logout}">Logout</a>
</c:if>
<%--Admin Menu--%>
<c:if test="${sessionScope.role==1}">
    <a href="#">Home</a>|<a href="#">Update User</a>|<a href="#">View User List</a>|<a href="${url_logout}">Logout</a>
</c:if>
<c:if test="${param.acc != null}">
    <p>duplicate user registration</p>
</c:if>

<c:if test="${param.res !=null }">
    <script type="text/javascript">
            alert("You Are Successfully Registered!!Please Login...");
    </script>
</c:if>

<c:if test="${param.res2 !=null }">
    <script type="text/javascript">
        alert("You Are Successfully Logged out!!Please Login...");
    </script>
</c:if>

</body>
</html>
