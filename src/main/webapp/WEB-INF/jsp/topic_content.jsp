<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020/12/14
  Time: 21:35
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
<a href="javascript:history.back(-1)" class="easyui-linkbutton">返回上一页</a>
<h1>题目标题：${topic.topicTitle}</h1>
<h1>所属课程：${topic.topicCourse}</h1>
<h1>所属学期：${topic.topicSemester}</h1>
<h1>题目类别：${topic.topicType}</h1>
<h1>题目来源：${topic.topicSource}</h1>
<h1>整合课程：${topic.topicIntegratedCurriculum}</h1>
<h1>题目内容：${topic.topicContent}</h1>
<h1>题目要求：${topic.topicRequirements}</h1>
<h1>主要难点：${topic.topicMainDifficulties}</h1>

</body>
</html>
