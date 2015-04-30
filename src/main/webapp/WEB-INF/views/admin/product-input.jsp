<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link href="/js/kindeditor/themes/default/default.css" rel="stylesheet">
<script src="/js/kindeditor/kindeditor-all-min.js"></script>
<script src="/js/kindeditor/lang/zh_CN.js"></script>
<form class="form-horizontal" action="/action/manage/product/manage" method="post">
    <fieldset>
        <div id="legend">
            <legend>
                <c:choose>
                    <c:when test="${product == null}">
                        新增产品
                    </c:when>
                    <c:otherwise>
                        编辑产品
                    </c:otherwise>
                </c:choose>
            </legend>
        </div>
        <div class="control-group">
            <!-- Text input-->
            <label class="control-label" for="name">产品名</label>
            <div class="controls">
                <input placeholder="请输入产品名" id="name" name="name" class="input-xlarge" type="text">
            </div>
        </div>
        <div class="control-group">
            <!-- Select Multiple -->
            <label class="control-label" for="productType">产品分类</label>
            <div class="controls">
                <select class="input-xlarge" id="productType" name="productType">
                    <option>Enter</option>
                    <option>Your</option>
                    <option>Options</option>
                    <option>Here!</option>
                </select>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label">产品图片</label>
            <!-- Button -->
            <div class="controls">
                <div class="js-show-position"></div>
                <input type="hidden" name="img">
                <input id="js-img-upload-utton" type="button" value="上传" />
            </div>
        </div>
        <div class="control-group">
            <!-- Textarea -->
            <label class="control-label" for="introduction">简介</label>
            <div class="controls">
                <div class="textarea">
                    <textarea id="introduction" name="introduction" style="width:700px;height:200px;visibility:hidden;"></textarea>
                </div>
            </div>
        </div>
        <div class="control-group">
            <!-- Textarea -->
            <label class="control-label" for="parameter">参数</label>
            <div class="controls">
                <div class="textarea">
                    <textarea id="parameter" name="parameter" style="width:700px;height:200px;visibility:hidden;"></textarea>
                </div>
            </div>
        </div>
    </fieldset>
    <input type="hidden" name="id" value="${product.id}" >
    <button class="btn btn-sm btn-primary" type="submit">
        <c:choose>
            <c:when test="${product == null}">
                新增
            </c:when>
            <c:otherwise>
                编辑
            </c:otherwise>
        </c:choose>
    </button>
</form>
<script>
    var options = {
        onOpen: function() {
            KindEditor.create("#content", {
                width : '700px',
                height : '406px',
                urlType : 'domain',
                uploadJson : '$alias.pageUpload.format($captcha)',
                fileManagerJson : '$alias.pageFileManager.format()',
                allowFileManager : true,
                resizeType : 0
            });
        },
        onClose: function() {
            KindEditor.remove("#content");
        },
        sync: function() {
            KindEditor.sync("#content");
        }
    }
    var editor;
    KindEditor.ready(function(K) {
        var uploadbutton = K.uploadbutton({
            button : K('#js-img-upload-utton')[0],
            fieldName : 'imgFile',
            url : '/action/manage/product/upload',
            afterUpload : function(data) {
                var msg = data.msg[0];
                if (data.code === 1) {
                    $(".js-show-position").html("<img src='" + msg + "'>");
                } else {
                    alert(msg);
                }
            },
            afterError : function(str) {
                alert('自定义错误信息: ' + str);
            }
        });
        uploadbutton.fileBox.change(function() {
            uploadbutton.submit();
        });
        editor = K.create('textarea[name="introduction"],textarea[name="parameter"]', {
            resizeType : 0,
            allowPreviewEmoticons : false,
            allowImageUpload : false,
            items : [
                'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
                'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
                'insertunorderedlist', '|', 'emoticons', 'image', 'link']
        });
    });
</script>