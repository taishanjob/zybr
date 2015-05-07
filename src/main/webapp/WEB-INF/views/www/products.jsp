<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>中宇博润-产品展示</title>
    <jsp:include page="include.jsp" />
</head>

<body id="page3" onload="new ElementMaxHeight();">
<!-- header -->
<jsp:include page="header.jsp"/>
<!-- content -->
<div id="content">
    <div class="container">
        <div class="wrapper">
            <div class="aside maxheight">
                <div class="indent1">
                    <h2>产品分类</h2>
                    <dl class="news">
                        <c:forEach items="${productTypeList}" var="item">
                            <dt><a href="/action/product/list?id=${item.id}">${item.name}</a></dt>
                        </c:forEach>
                    </dl>
                </div>
            </div>
            <div class="mainContent maxheight">
                <div class="indent">
                    <h2>${productType.name}</h2>
                    <!--<p>这里是分类简介</p>-->
                    <ul class="img-list">
                        <c:forEach items="${productList}" var="item">
                            <li>
                                <img src="${item.img}" alt="${item.name}" />
                                <h3><a target="_blank" href="/action/product/detail?id=${item.id}">${item.name}</a></h3>
                                ${item.introduction}
                            </li>
                        </c:forEach>
                    </ul>
                    <c:if test="${pageBean.total > pageBean.rows}">
                    <div class="pagebox">
                        <div class="paging">
                            <a title="上一页" class="previous" href="<c:choose><c:when test="${pageBean.previousPage == null}">javascript:void(0)</c:when><c:otherwise>?page=${pageBean.previousPage}&id=${productType.id}</c:otherwise></c:choose>"><span class="Bg"><b>&nbsp;</b></span></a>
                            <c:forEach var="i" begin="1" end="${(pageBean.total + pageBean.rows - 1) / pageBean.rows}" step="1">
                                <a <c:if test="${i == pageBean.page}" >class="cur"</c:if> href="?page=${i}&id=${productType.id}"><span class="Bg"><b>第${i}页</b></span></a>
                            </c:forEach>
                            <a title="下一页" class="nextpage" href="<c:choose><c:when test="${pageBean.nextPage == null}">javascript://</c:when><c:otherwise>?page=${pageBean.nextPage}&id=${productType.id}</c:otherwise></c:choose>"><span class="Bg"><b>&nbsp;</b></span></a>
                        </div>
                    </div>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- footer -->
<jsp:include page="footer.jsp"/>
</body>
</html>