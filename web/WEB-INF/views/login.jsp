<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>登陆</title>

    <!-- Bootstrap core CSS -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/css/signin.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="/js/html5shiv.min.js"></script>
    <script src="/js/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<div class="container">

    <c:if test="${resultMessage != null}">
        <div role="alert" class="alert alert-warning">
            <strong>警告!</strong> ${resultMessage.msg}
        </div>
    </c:if>
    <form class="form-signin" action="/action/manage/login" method="post">
        <h2 class="form-signin-heading">请登陆</h2>
        <label class="sr-only" for="username">账号</label>
        <input class="form-control" id="username" name="username" placeholder="请输入账号" required autofocus>
        <label class="sr-only" for="password">密码</label>
        <input class="form-control" id="password" name="password" type="password" placeholder="请输入密码" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登陆</button>
    </form>

</div> <!-- /container -->


<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
