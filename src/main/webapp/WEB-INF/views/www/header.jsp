<%@page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="header">
    <div class="bg">
        <div class="container">
            <div class="row-1">
                <div class="wrapper">
                    <div class="fleft"><h1>北京中宇博润国际科技有限公司</h1></div>
                    <ul class="top-links">
                        <li class="first"><a href="index.html" class="home"></a></li>
                        <li><a href="contactus.html" class="mail"></a></li>
                    </ul>
                </div>
            </div>
            <div class="row-2">
                <!-- .nav -->
                <ul class="nav">
                    <li>
                        <c:choose>
                            <c:when  test="${source == 'index'}">
                                <a href="${ctx}/index.jsp" class="current">首页</a>
                            </c:when>
                            <c:otherwise>
                                <a href="${ctx}/index.jsp">首页</a>
                            </c:otherwise>
                        </c:choose>
                    </li>
                    <li>
                        <c:choose>
                            <c:when  test="${source == 'products'}">
                                <a href="${ctx}/products.jsp" class="current">产品展示</a>
                            </c:when>
                            <c:otherwise>
                                <a href="${ctx}/products.jsp">产品展示</a>
                            </c:otherwise>
                        </c:choose>
                    </li>
                    <li>
                        <c:choose>
                            <c:when  test="${source == 'recruitment'}">
                                <a href="${ctx}/recruitment.jsp" class="current">招贤纳士</a>
                            </c:when>
                            <c:otherwise>
                                <a href="${ctx}/recruitment.jsp">招贤纳士</a>
                            </c:otherwise>
                        </c:choose>
                    </li>
                    <li>
                        <c:choose>
                            <c:when  test="${source == 'contactus'}">
                                <a href="${ctx}/contactus.jsp" class="current">联系我们</a>
                            </c:when>
                            <c:otherwise>
                                <a href="${ctx}/contactus.jsp">联系我们</a>
                            </c:otherwise>
                        </c:choose>
                    </li>
                </ul>
                <!-- /.nav -->
            </div>
            <div class="row-3">
                <p>尖端技术知识<br/><br/>良好的销售和服务支持<br/><br/>优质的产品和有竞争力的价格</p>

                <h1>产品搜索</h1><br/>

                <form action="" id="search-form">
                    <fieldset><input type="text" class="text" value=""/><input type="submit" class="submit" value=""/>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>
</div>