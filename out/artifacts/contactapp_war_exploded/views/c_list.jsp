<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: gazi_muhib
  Date: 8/26/17
  Time: 4:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Contact List</title>
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
            <h3>Contact List</h3>
            <c:if test="${param.act eq 'saved'}">
                <p>Contact is Successfully added!!</p>
            </c:if>

            <c:if test="${param.act eq 'del'}">
                <p>Contact is Successfully Deleted!!</p>
            </c:if>

            <table border="1">
                <tr>
                    <th>Serial</th>
                    <th>ContactId</th>
                    <th>Name</th>
                    <th>Phone</th>
                    <th>Email</th>
                    <th>Address</th>
                    <th>Remark</th>
                    <th>Action</th>
                </tr>
                <c:if test="${empty contactList}">
                    <tr>
                        <p>No Contact Record Present For You!!Add Your Contact</p>
                    </tr>
                </c:if>
                <c:forEach var="con" items="${contactList}" varStatus="step">
                    <tr>
                        <td>${step.count}</td>
                        <td>${con.contact_id}</td>
                        <td>${con.name}</td>
                        <td>${con.phone}</td>
                        <td>${con.email}</td>
                        <td>${con.address}</td>
                        <td>${con.remark}</td>

                        <c:url var="delete" value="/delete_contact">
                            <c:param name="contactId" value="${con.contact_id}"/>
                        </c:url>

                        <c:url var="edit" value="#">
                            <c:param name="contact" value="${con}"/>
                        </c:url>

                        <td>Edit|<a href="${delete}">Delete</a></td>
                    </tr>
                </c:forEach>
            </table>
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
