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

    <link rel="stylesheet" type="text/css" href="/static/css/ace.min.css">


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
    <script type="text/javascript">
        function chose(){
            var id = ${ids};
            $.messager.confirm("系统提示", "您确定要选择这个题目吗？", function (r) {
                if (r) {
                    // $.post("/student/topic/chosen/"+id , {}, function (result) {
                    //     if (result == "success") {
                    //         $("#topic_status").datagrid("reload");
                    //     } else {
                    //         $.messager.alert("系统提示", "选题失败！");
                    //     }
                    // });
                    $("#topic_tontent_forstudent_form").ajaxSubmit({
                        type:"post",
                        url:"/student/topic/chosen/"+id,
                        contentType:false,
                        processData:false,
                        success: function (result) {
                            if (result == "success") {
                                document.getElementById("topic_status").innerHTML = "题目状态：chosen";
                                alert("选题成功!");

                            } else {
                                alert("选题失败!");
                            }
                        }
                    })
                }
            });


        }

    </script>
</head>
<body>
<form id="topic_tontent_forstudent_form">
    <a href="javascript:history.back(-1)" class="easyui-linkbutton">返回上一页</a>
<%--    <div>题目标题：${topic.topicTitle}</div>--%>
<%--    <div>所属课程：${topic.topicCourse}</div>--%>
<%--    <div>所属学期：${topic.topicSemester}</div>--%>
<%--    <div>题目类别：${topic.topicType}</div>--%>
<%--    <div>题目来源：${topic.topicSource}</div>--%>
<%--    <div>整合课程：${topic.topicIntegratedCurriculum}</div>--%>
<%--    <div>题目内容：${topic.topicContent}</div>--%>
<%--    <div>题目要求：${topic.topicRequirements}</div>--%>
<%--    <div>主要难点：${topic.topicMainDifficulties}</div>--%>
<%--    <div id="topic_status">题目状态：${topic.topicStatus}</div>--%>
    <div class="profile-user-info profile-user-info-striped">
        <div class="profile-info-row">
            <div class="profile-info-name">题目标题</div>

            <div class="profile-info-value">
                <span class="editable" id="username">${topic.topicTitle}</span>
            </div>
        </div>

        <div class="profile-info-row">
            <div class="profile-info-name">所属课程</div>

            <div class="profile-info-value">
                <span class="editable" id="country">${topic.topicCourse}</span>
            </div>
        </div>

        <div class="profile-info-row">
            <div class="profile-info-name">所属学期</div>

            <div class="profile-info-value">
                <span class="editable" id="age">${topic.topicSemester}</span>
            </div>
        </div>

        <div class="profile-info-row">
            <div class="profile-info-name">题目类别</div>

            <div class="profile-info-value">
                <span class="editable" id="signup">${topic.topicType}</span>
            </div>
        </div>

        <div class="profile-info-row">
            <div class="profile-info-name">题目来源</div>

            <div class="profile-info-value">
                <span class="editable" id="login">${topic.topicSource}</span>
            </div>
        </div>

        <div class="profile-info-row">
            <div class="profile-info-name">整合课程</div>

            <div class="profile-info-value">
                <span class="editable" id="about">${topic.topicIntegratedCurriculum}</span>
            </div>
        </div>

        <div class="profile-info-row">
            <div class="profile-info-name">题目内容</div>

            <div class="profile-info-value">
                <span class="editable" id="about1">${topic.topicContent}</span>
            </div>
        </div>

        <div class="profile-info-row">
            <div class="profile-info-name">题目要求</div>

            <div class="profile-info-value">
                <span class="editable" id="about2">${topic.topicRequirements}</span>
            </div>
        </div>

        <div class="profile-info-row">
            <div class="profile-info-name">主要难点</div>

            <div class="profile-info-value">
                <span class="editable" id="about3">${topic.topicMainDifficulties}</span>
            </div>
        </div>

        <div class="profile-info-row">
            <div class="profile-info-name">题目状态</div>

            <div class="profile-info-value">
                <span class="editable" id="about4">${topic.topicStatus}</span>
            </div>
        </div>


    </div>
    <a href="javascript:chose()" class="easyui-linkbutton">确认选题</a>
    <input type="hidden" id="id" name="id"/>



</form>





</body>
</html>
