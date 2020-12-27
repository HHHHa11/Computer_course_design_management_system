<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020/12/27
  Time: 12:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css"
          href="/static/static-easyui/plugin/jeasyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css"
          href="/static/static-easyui/plugin/jeasyui/themes/icon.css">
    <link rel="stylesheet" type="text/css"
          href="/static/static-easyui/css/idea.css">
    <link rel="stylesheet" type="text/css"
          href="/static/static-easyui/plugin/mdeditor/css/editormd.min.css">
    <link rel="stylesheet" type="text/css"
          href="/static/static-easyui/css/customAdmin.css">


    <script type="text/javascript"
            src="/static/static-easyui/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript"
            src="/static/static-easyui/js/jquery.form.min.js"></script>
    <script type="text/javascript"
            src="/static/static-easyui/plugin/jeasyui/jquery.easyui.min.js"></script>
    <script type="text/javascript"
            src="/static/static-easyui/plugin/jeasyui/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript"
            src="/static/static-easyui/plugin/mdeditor/editormd.min.js"></script>
</head>
<body>
<div class="main">
    <ul class="accountBox">
        <li style="margin-top: 0;">
            <div class="left">姓名：</div>
            <div class="right">
                <input id="stu_name"
                       class="easyui-validatebox easyui-textbox textbox-f validatebox-text validatebox-disabled"
                       disabled="" style="display: none;"><span class="textbox textbox-disabled"
                                                                style="width: 248px;"><input id="_easyui_textbox_input1"
                                                                                             type="text"
                                                                                             class="textbox-text validatebox-text validatebox-disabled"
                                                                                             autocomplete="off"
                                                                                             tabindex="" disabled=""
                                                                                             placeholder=""
                                                                                             style="margin: 0px; padding-top: 0px; padding-bottom: 0px; height: 22px; line-height: 22px; width: 240px;"><input
                    type="hidden" class="textbox-value" disabled="" value=""></span>
            </div>
        </li>
        <li class="clearfix margt">
            <div class="left">学号：</div>
            <div class="right"><input id="stu_num" class="easyui-textbox textbox-f" disabled=""
                                      style="display: none;"><span class="textbox textbox-disabled"
                                                                   style="width: 248px;"><input
                    id="_easyui_textbox_input2" type="text" class="textbox-text validatebox-text validatebox-disabled"
                    autocomplete="off" tabindex="" disabled="" placeholder=""
                    style="margin: 0px; padding-top: 0px; padding-bottom: 0px; height: 22px; line-height: 22px; width: 240px;"><input
                    type="hidden" class="textbox-value" disabled="" value=""></span></div>
        </li>
        <li class="clearfix margt">
            <div class="left">院系：</div>
            <div class="right"><input id="stu_academy" class="easyui-textbox textbox-f" disabled=""
                                      style="display: none;"><span class="textbox textbox-disabled"
                                                                   style="width: 248px;"><input
                    id="_easyui_textbox_input3" type="text" class="textbox-text validatebox-text validatebox-disabled"
                    autocomplete="off" tabindex="" disabled="" placeholder=""
                    style="margin: 0px; padding-top: 0px; padding-bottom: 0px; height: 22px; line-height: 22px; width: 240px;"><input
                    type="hidden" class="textbox-value" disabled="" value=""></span></div>
        </li>
        <li class="clearfix margt">
            <div class="left">专业：</div>
            <div class="right"><input id="stu_special" class="easyui-textbox textbox-f" disabled=""
                                      style="display: none;"><span class="textbox textbox-disabled"
                                                                   style="width: 248px;"><input
                    id="_easyui_textbox_input4" type="text" class="textbox-text validatebox-text validatebox-disabled"
                    autocomplete="off" tabindex="" disabled="" placeholder=""
                    style="margin: 0px; padding-top: 0px; padding-bottom: 0px; height: 22px; line-height: 22px; width: 240px;"><input
                    type="hidden" class="textbox-value" disabled="" value=""></span></div>
        </li>
        <li class="clearfix margt">
            <div class="left"><i name="bjname">学生班级</i>：</div>
            <div class="right"><input id="stu_class" class="easyui-textbox textbox-f" disabled=""
                                      style="display: none;"><span class="textbox textbox-disabled"
                                                                   style="width: 248px;"><input
                    id="_easyui_textbox_input5" type="text" class="textbox-text validatebox-text validatebox-disabled"
                    autocomplete="off" tabindex="" disabled="" placeholder=""
                    style="margin: 0px; padding-top: 0px; padding-bottom: 0px; height: 22px; line-height: 22px; width: 240px;"><input
                    type="hidden" class="textbox-value" disabled="" value=""></span></div>
        </li>
        <!--<li class="clearfix margt">
    <div class="left">电话：</div>
    <div class="right"><input id="stu_phone" class="easyui-textbox" disabled="disabled" /></div>
</li>-->
        <li class="clearfix margt">
            <div class="left">性别：</div>
            <div class="right">
                <select id="stu_sex" class="easyui-combobox combobox-f combo-f textbox-f" editable="false"
                        data-options="panelHeight:'auto'" textboxname="dept" style="display: none;" comboname="dept">
                    <option value="-1">请选择</option>
                    <option value="0">男</option>
                    <option value="1">女</option>
                </select><span class="textbox combo" style="width: 248px;"><span
                    class="textbox-addon textbox-addon-right" style="right: 0px; top: 0px;"><a href="javascript:;"
                                                                                               class="textbox-icon combo-arrow"
                                                                                               icon-index="0"
                                                                                               tabindex="-1"
                                                                                               style="width: 26px; height: 22px;"></a></span><input
                    id="_easyui_textbox_input8" type="text" class="textbox-text validatebox-text validatebox-readonly"
                    autocomplete="off" tabindex="" readonly="" placeholder=""
                    style="margin: 0px 26px 0px 0px; padding-top: 0px; padding-bottom: 0px; height: 22px; line-height: 22px; width: 214px;"><input
                    type="hidden" class="textbox-value" name="dept" value="-1"></span>
            </div>
        </li>
        <li class="clearfix margt">
            <div class="left">邮箱：</div>
            <div class="right"><input id="stu_email" class="easyui-textbox textbox-f" style="display: none;"><span
                    class="textbox" style="width: 248px;"><input id="_easyui_textbox_input6" type="text"
                                                                 class="textbox-text validatebox-text textbox-prompt"
                                                                 autocomplete="off" tabindex="" placeholder=""
                                                                 style="margin: 0px; padding-top: 0px; padding-bottom: 0px; height: 22px; line-height: 22px; width: 240px;"><input
                    type="hidden" class="textbox-value" value=""></span></div>
        </li>
        <li class="clearfix margt">
            <div class="left">电子签名：</div>
            <div class="right">
                <p>
                    <input id="closeE-signature" type="radio" name="e-signature" value="0" checked="checked">
                    <label for="closeE-signature">不启用</label>
                </p>
                <p>
                    <input id="openE-signature" type="radio" name="e-signature" value="1">
                    <label for="openE-signature">
                        启用（启用并上传签名图片成功后，将在配置好“签名导出”的导出文档相应位置显示该签名图片；若学校配置的导出文档未配置“签名导出”，则导出文档内不显示该签名图片）
                    </label>
                </p>
                <div id="signatureBox" style="display: none;" class="margt">
                    <div class="clearfix">
                        <div class="f-left" style="width: 140px; text-align: right;">已上传的签名图片：</div>
                        <div class="f-left" style="width: 320px;">
                            <div id="signatureImg"><span class="txt_red"> 未上传</span></div>
                            <p class="margt">
                                <a id="clickListA" data-val="1" href="javascript:;" class="listA">点击上传电子签名</a>
                                <!--<a id="clickListB" href="javascript:;" class="listA margl">电子签名pc测试</a>-->
                                <!--<a data-val="1" href="javascript:;" class="listA margl" onclick="openframe('电子签名', 'User/signaure.html', false);">点击</a>-->
                                <span class="E-signature" style="display: inline;">
                                        <img class="weixinPng" src="../Themes/default/images/weixin.png" width="24"
                                             alt="Alternate Text">
                                        <span class="ewmBox">
                                            <span class="ewm" id="weixinEWM"
                                                  title="http://gdupt.co.cnki.net/User/ESignature.html?token=fbJ762NAfGuh/YR16oygoiOFeW4bI5u3gWItHTAJBvvxl4B8X3E4SRwJsuwHd60XY5fc+wyGuu4sYc69Hc7ZM16lMB33tmp7UV5ZDjIIgj0="><canvas
                                                    width="180" height="180"></canvas></span>
                                            <span class="txt">打开微信扫一扫二维码自定义电子签名，点击保存上传电子签名</span>
                                        </span>
                                    </span>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </li>
        <li class="clearfix margt">
            <div class="left">&nbsp;</div>
            <div class="right"><input class="formBtn" id="modify" type="button" name="name" value="确认修改" style=""></div>
        </li>
    </ul>
</div>
</body>
</html>
