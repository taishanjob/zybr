<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<h1 class="page-header">产品分类管理</h1>
<h2 class="sub-header">
    <button type="button" class="btn btn-sm btn-primary js-click" data-url="/action/manage/product/type/input">新增</button>
</h2>
<div class="table-responsive">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>产品分类ID</th>
            <th>产品分类名</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="productType" items="${productTypeList}">
            <tr>
                <td>${productType.id}</td>
                <td>${productType.name}</td>
                <td>
                    <button type="button" class="btn btn-sm btn-primary js-click" data-url="/action/manage/product/type/input?id=${productType.id}">编辑</button>
                    <!-- Button trigger modal -->
                    <button type="button" class="btn btn-sm btn-primary" data-toggle="modal" data-target="#confirmModal" data-url="/action/manage/product/type/delete?id=${productType.id}">删除</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <c:import url="nav-pager.jsp"/>
</div>
