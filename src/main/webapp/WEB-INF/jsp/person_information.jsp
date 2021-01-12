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
    <svg class="bi bi-chevron-right" width="32" height="32" viewBox="0 0 20 20" fill="currentColor"
         xmlns="http://www.w3.org/2000/svg">
        <path fill-rule="evenodd"
              d="M6.646 3.646a.5.5 0 01.708 0l6 6a.5.5 0 010 .708l-6 6a.5.5 0 01-.708-.708L12.293 10 6.646 4.354a.5.5 0 010-.708z"/>
    </svg>
    <a width="32" height="50" style="text-align: center">个人基本信息</a>
    <div class="right" style="height: 30px">
        姓名：
        <input
                type="" class="textbox-icon-readonly" disabled="" value="${user.name}">
    </div>

    <div class="right" style="height: 30px">
        学号：
        <input
                type="" class="textbox-icon-readonly" disabled="" value="${user.studentNumber}">
    </div>


    <div class="right" style="height: 30px">
        专业及班级：
        <input
                type="" class="textbox-icon-readonly" disabled="" value="${user.classes}">
    </div>

        <!--<li class="clearfix margt">
    <div class="left">电话：</div>
    <div class="right"><input id="stu_phone" class="easyui-textbox" disabled="disabled" /></div>
-->

    <div class="right" style="height: 30px">
        性别：
        <input
                type="" class="textbox-icon-readonly" disabled="" value="${user.gender}">
    </div>


    <div class="right" style="height: 30px">
        邮箱：
        <input
                type="" class="textbox-icon-readonly" disabled="" value="${user.email}">
    </div>

</div>
</body>
</html>