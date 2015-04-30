<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<h1 class="page-header">消息管理</h1>
<div class="table-responsive">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>消息ID</th>
            <th>姓名</th>
            <th>公司</th>
            <th>邮箱</th>
            <th>电话</th>
            <th>消息内容</th>
            <th>创建时间</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="message" items="${messageList}">
            <tr>
                <td>${message.id}</td>
                <td>${message.name}</td>
                <td>${message.company}</td>
                <td>${message.email}</td>
                <td>${message.phone}</td>
                <td>${message.message}</td>
                <td><fmt:formatDate value="${message.createTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <c:import url="nav-pager.jsp"/>
</div>
