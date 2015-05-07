<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<h1 class="page-header">产品管理</h1>
<h2 class="sub-header">
    <button type="button" class="btn btn-sm btn-primary js-click" data-url="/action/manage/product/input">新增</button>
</h2>
<div class="table-responsive">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>产品ID</th>
            <th>产品图片地址</th>
            <th>产品名</th>
            <th>产品描述</th>
            <th>产品参数</th>
            <th>产品分类</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="product" items="${productList}">
            <tr>
                <td>${product.id}</td>
                <td><img src="${product.img}" width="200"></td>
                <td>${product.name}</td>
                <td>${product.introduction}</td>
                <td>${product.parameter}</td>
                <td>${productTypeMap.get(product.productType).name}</td>
                <td>
                    <button type="button" class="btn btn-sm btn-primary js-click" data-url="/action/manage/product/input?id=${product.id}">编辑</button>
                    <!-- Button trigger modal -->
                    <button type="button" class="btn btn-sm btn-primary" data-toggle="modal" data-target="#confirmModal" data-url="/action/manage/product/delete?id=${product.id}">删除</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <c:import url="nav-pager.jsp"/>
</div>
