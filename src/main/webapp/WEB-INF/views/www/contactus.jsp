<%@page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>中宇博润-联系我们</title>
    <jsp:include page="include.jsp" />
</head>

<body id="page5" onload="new ElementMaxHeight();">
<!-- header -->
<jsp:include page="header.jsp"/>
<!-- content -->
<div id="content">
    <div class="container">
        <div class="wrapper">
            <div class="aside">
                <jsp:include page="nav_contact.jsp"/>
            </div>
            <div class="mainContent maxheight">
                <div class="indent">
                    <h2>在线留言</h2>
                    <c:if test="${resultMessage != null}">
                        <div style="background-color: #fcf8e3; padding: 5px; margin: 5px 0; color: #f00;">
                            <c:choose>
                                <c:when test="${resultMessage.code == 1}">
                                    <strong>提示!</strong>
                                </c:when>
                                <c:otherwise>
                                    <strong>警告!</strong>
                                </c:otherwise>
                            </c:choose>
                             ${resultMessage.msg}
                        </div>
                    </c:if>
                    <form id="contacts-form" action="${pageContext.request.contextPath}/action/manage/contactus" method="post">
                        <fieldset>
                            <div class="field">
                                <label>姓名:</label>
                                <input name="name" type="text" value=""/>
                            </div>
                            <div class="field">
                                <label>公司:</label>
                                <input name="company" type="text" value=""/>
                            </div>
                            <div class="field">
                                <label>邮箱:</label>
                                <input name="email" type="text" value=""/>
                            </div>
                            <div class="field">
                                <label>联系方式:</label>
                                <input name="phone" type="text" value=""/>
                            </div>
                            <div class="field">
                                <label>留言内容:</label>
                                <textarea name="message" cols="1" rows="1"></textarea>
                            </div>
                            <div class="alignright"><a href="javascript://"
                                                       onclick="document.getElementById('contacts-form').submit()">发送</a></div>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- footer -->
<jsp:include page="footer.jsp"/>
</body>
</html>