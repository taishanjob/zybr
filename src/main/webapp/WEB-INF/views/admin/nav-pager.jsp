<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<nav>
    <ul class="pager">
        <li class="previous<c:if test="${pageBean.previousPage == null}"> disabled</c:if>">
            <a href="<c:choose><c:when test="${pageBean.previousPage == null}">javascript://</c:when><c:otherwise>?page=${pageBean.previousPage}</c:otherwise></c:choose>"><span aria-hidden="true">&larr;</span> 上一页</a>
        </li>
        <li class="next<c:if test="${pageBean.nextPage == null}"> disabled</c:if>">
            <a href="<c:choose><c:when test="${pageBean.nextPage == null}">javascript://</c:when><c:otherwise>?page=${pageBean.nextPage}</c:otherwise></c:choose>">下一页 <span aria-hidden="true">&rarr;</span></a>
        </li>
    </ul>
</nav>
