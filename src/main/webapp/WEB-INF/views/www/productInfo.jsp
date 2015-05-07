<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>中宇博润-产品详情-${product.name}</title>
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
                <c:if test="${product != null}">
                <table width="100%">
                    <tr>
                        <td style="padding: 10px 0;text-align: center;">
                            <div class="product">
                                <h2>产品图片</h2>
                                <img src="${product.img}" alt="${product.name}" />
                                <h3><a href="#">${product.name}</a></h3>
                            </div>
                        </td>
                    </tr>
                    <tr class="maxheight">
                        <td>
                            <div class="productInfo maxheight">
                                <!-----------------------------                 产品简介                                  ----------------------------------->
                                <h2>产品简介</h2>
                                ${product.introduction}
                                <!-----------------------------                 技术参数                                  ----------------------------------->
                                <br/><br/><h2>技术参数</h2>
                                ${product.parameter}
                                <br/><br/><a target="_blank" href="${ctx}/contactus.jsp">联系我们</a>
                            </div>
                        </td>
                    </tr>
                </table>
                </c:if>
            </div>
        </div>
    </div>
</div>
<!-- footer -->
<jsp:include page="footer.jsp"/>
</body>
</html>