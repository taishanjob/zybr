<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<form action="/action/manage/product/type/manage" method="post">
    <h2>
    <c:choose>
        <c:when test="${productType == null}">
            新增产品分类
        </c:when>
        <c:otherwise>
            编辑产品分类
        </c:otherwise>
    </c:choose>
    </h2>
    <label class="sr-only" for="name">产品分类</label>
    <input id="name" name="name" value="${productType.name}" placeholder="请输入产品分类" required autofocus>
    <input type="hidden" name="id" value="${productType.id}" >
    <button class="btn btn-sm btn-primary" type="submit">
        <c:choose>
            <c:when test="${productType == null}">
                新增
            </c:when>
            <c:otherwise>
                编辑
            </c:otherwise>
        </c:choose>
    </button>
</form>
