<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="col-sm-3 col-md-2 sidebar">
    <ul class="nav nav-sidebar">
        <li
            <c:if test="${nav_active == 'nav_active_message'}"> class="active"</c:if>
            ><a href="/action/manage/message">消息管理
            <c:if test="${nav_active == 'nav_active_message'}"><span class="sr-only">(current)</span></c:if>
        </a></li>
        <li
            <c:if test="${nav_active == 'nav_active_product'}"> class="active"</c:if>
            ><a href="/action/manage/product">产品管理
            <c:if test="${nav_active == 'nav_active_product'}"><span class="sr-only">(current)</span></c:if>
        </a></li>
        <li
            <c:if test="${nav_active == 'nav_active_product_type'}"> class="active"</c:if>
            ><a href="/action/manage/product/type">产品分类管理
            <c:if test="${nav_active == 'nav_active_product_type'}"><span class="sr-only">(current)</span></c:if>
        </a></li>
    </ul>
</div>