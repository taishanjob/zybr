<%@page contentType="text/html; charset=utf-8"%>
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
                <div class="indent">
                    <h2>联系方式</h2>
                    <dl class="news">
                        <dt><a href="#">联系人：</a></dt>
                        <dd>水哥.</dd>
                        <dt><a href="#">电话：</a></dt>
                        <dd>4000-447-119</dd>
                        <dt><a href="#">手机：</a></dt>
                        <dd>010-186-0113-9131</dd>
                        <dt><a href="#">邮编：</a></dt>
                        <dd>100070</dd>
                        <dt><a href="#">地址：</a></dt>
                        <dd>北京市海淀区西直门.</dd>
                    </dl>
                </div>
            </div>
            <div class="mainContent maxheight">
                <div class="indent">
                    <h2>在线留言</h2>

                    <form id="contacts-form" action="" method="post">
                        <fieldset>
                            <div class="field">
                                <label>姓名:</label>
                                <input type="text" value=""/>
                            </div>
                            <div class="field">
                                <label>邮箱:</label>
                                <input type="text" value=""/>
                            </div>
                            <div class="field">
                                <label>联系方式:</label>
                                <input type="text" value=""/>
                            </div>
                            <div class="field">
                                <label>留言内容:</label>
                                <textarea cols="1" rows="1"></textarea>
                            </div>
                            <div class="alignright"><a href="#"
                                                       onclick="document.getElementById('contacts-form').submit()">发送</a></div>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- footer -->
<div id="footer">
    <div class="bg">
        <div class="container">
            <div class="indent">
                Copyright - Type in your name here - Collect from <a href="http://www.17sucai.com/"
                                                                     title="17素材网">17素材网</a></div>
            <br/>

        </div>
    </div>
</div>
</div>
<script type="text/javascript"> Cufon.now(); </script>
</body>
</html>