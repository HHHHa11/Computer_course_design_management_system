<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>发布题目页面</title>
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
    <script type="text/javascript">
        var editor;

        $(function () {
            editor = editormd("content-editormd", {
                width: "100%",
                height: 600,
                syncScrolling: "single",
                path: "/static/static-easyui/plugin/mdeditor/lib/",
                htmlDecode: "style,script,iframe",
                saveHTMLToTextarea: true,    // 保存 HTML 到 Textarea

                /**上传图片相关配置如下*/
                imageUpload: true,
                imageFormats: ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
                imageUploadURL: "/admin/uploadImg"

            });
        })

        function submitData() {
            var topicTitle = $("#topicTitle").val();
            var topicCourse = $("#topicCourse").combobox("getText");
            var topicSemester = $("#topicSemester").combobox("getText");
            var topicType = $("#topicType").combobox("getText");
            var topicSource = $("#topicSource").combobox("getText");
            var topicIntegratedCurriculum = $("#topicIntegratedCurriculum").val();
            var content = editor.getMarkdown();
            console.log(editor.getHTML());
            var summary = getSummary(editor.getHTML()).substring(0, 90) + "...";
            var topicRequirements = $("#topicRequirements").val();
            var topicMainDifficulties = $("#topicMainDifficulties").val();
            var id = ${id};

            if (topicTitle == null || topicTitle == '') {
                alert("请输入题目标题！");
            } else if (topicCourse == null || topicCourse == '') {
                alert("请选择课程类别！");
            } else if (topicSemester == null || topicSemester == '') {
                alert("请选择学期类别！");
            } else if (topicType == null || topicType == '') {
                alert("请选择题目类别！");
            } else if (topicSource == null || topicSource == '') {
                alert("请选择题目来源！");
            } else if (topicIntegratedCurriculum == null || topicIntegratedCurriculum == '') {
                alert("请输入整合课程！");
            } else if (content== null || content == '') {
                alert("请输入内容！");
            } else if (topicRequirements == null || topicRequirements == '') {
                alert("请输入题目要求！");
            } else if (topicMainDifficulties == null || topicMainDifficulties == '') {
                alert("请输入主要难点！");
            }
            else {
                $("#topicCourse").val(topicCourse);
                $("#topicSemester").val(topicSemester);
                $("#topicType").val(topicType);
                $("#topicSource").val(topicSource);
                //多写了一个隐藏的框进行数据的提交
                $("#topicContent").val(content);
                // $("#typeId").val(typeId);
                $("#id").val(id);
                $("#topicForm").ajaxSubmit({
                    type: "post",
                    url: "/teacher/topic/update",
                    contentType: false,
                    processData: false,
                    success: function (result) {
                        if (result == "success") {
                            alert("题目发布成功!");
                            resetValue();
                        } else {
                            alert("题目发布失败!");
                        }
                    }
                });
            }
        }

        // 重置数据
        function resetValue() {
            //将所有内容置空
            $("#topicTitle").val("");
            $("#topicCourse").combobox("setValue", "");
            $("#topicSemester").combobox("setValue", "");
            $("#topicType").combobox("setValue", "");
            $("#topicSource").combobox("setValue", "");
            $("#topicIntegratedCurriculum").val("");
            // $("#content-editormd-markdown-doc").html("lallalala");
            // console.log("content: " + $("#content-editormd-markdown-doc").html());
            console.log(editor.getHTML());
            editor.clear();
            $("#topicRequirements").val("");
            $("#topicMainDifficulties").val("");
        }

        function getSummary(html) {
            var str1 = html.replace(/<\/?.+?>/g, "");
            var str2 = str1.replace(/\s/g, "");
            return str2;
        }

    </script>

</head>
<body style="margin: 10px">
<div id="p" class="easyui-panel" title="编写题目" style="padding: 10px">
    <form id="topicForm" enctype="multipart/form-data">
        <table cellspacing="20px" width="100%">
            <tr>
                <td width="80px">题目标题：</td>
                <td><input type="text" id="topicTitle" name="topicTitle" style="width: 400px;" value="${topic.topicTitle}"/></td>
            </tr>
            <tr>
                <td>所属课程：</td>
                <td>
                    <select class="easyui-combobox" style="width: 154px" id="topicCourse" name="topicCourse"
                            editable="false"
                            panelHeight="auto">
                        <option value="">请选择课程类别...</option>
                        <c:forEach var="courseType" items="${courseTypeList }">
                            <option <c:if test="${topic.topicCourse == courseType.courseName}">selected="selected"</c:if>>${courseType.courseName}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>所属学期：</td>
                <td>
                    <select class="easyui-combobox" style="width: 154px" id="topicSemester" name="topicSemester"
                            editable="false"
                            panelHeight="auto">
                        <option value="">请选择学期...</option>
                        <c:forEach var="semesterType" items="${semesterTypeList }">
                            <option <c:if test="${topic.topicSemester == semesterType.semester}">selected="selected"</c:if>>${semesterType.semester}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>题目类别：</td>
                <td>
                    <select class="easyui-combobox" style="width: 154px" id="topicType" name="topicType"
                            editable="false"
                            panelHeight="auto">
                        <option value="">请选择题目类别...</option>
                        <option <c:if test="${topic.topicType == '应用研究'}">selected="selected"</c:if>>应用研究</option>
                        <option <c:if test="${topic.topicType == '其他'}">selected="selected"</c:if>>其他</option>
                        <option <c:if test="${topic.topicType == '软件设计'}">selected="selected"</c:if>>软件设计</option>
                        <option <c:if test="${topic.topicType == '艺术设计'}">selected="selected"</c:if>>艺术设计</option>
                        <option <c:if test="${topic.topicType == '工程设计'}">selected="selected"</c:if>>工程设计</option>
                        <option <c:if test="${topic.topicType == '实验研究'}">selected="selected"</c:if>>实验研究</option>
                        <option <c:if test="${topic.topicType == '理论研究'}">selected="selected"</c:if>>理论研究</option>
                    </select>
                </td>
            </tr>

            <tr>
                <td>题目来源：</td>
                <td>
                    <select class="easyui-combobox" style="width: 200px" id="topicSource" name="topicSource"
                            editable="false"
                            panelHeight="auto">
                        <option value="">请选择题目来源...</option>
                        <option <c:if test="${topic.topicSource == '学生社会调查'}">selected="selected"</c:if>>学生社会调查</option>
                        <option <c:if test="${topic.topicSource == '学生实验、实习、工程实践'}">selected="selected"</c:if>>学生实验、实习、工程实践</option>
                        <option <c:if test="${topic.topicSource == '教师社会调查'}">selected="selected"</c:if>>教师社会调查</option>
                        <option <c:if test="${topic.topicSource == '其他'}">selected="selected"</c:if>>其他</option>
                        <option <c:if test="${topic.topicSource == '教师实验、实习、工程实践'}">selected="selected"</c:if>>教师实验、实习、工程实践</option>
                        <option <c:if test="${topic.topicSource == '教师科研题'}">selected="selected"</c:if>>教师科研题</option>
                    </select>
                </td>
            </tr>

<%--            <tr>--%>
<%--                <td>任务书</td>--%>
<%--                <td><input type="file" id="imageFile" name="imageFile" style="width: 400px;"></td>--%>
<%--            </tr>--%>
            <tr>
                <td>整合课程<br>(至少6门)</td>
                <td>
<%--                    <input type="text" id="reprint" name="reprint" style="height:200px;width: 400px;">--%>
                    <textarea id="topicIntegratedCurriculum" name="topicIntegratedCurriculum" style="height:75px;width: 400px;" >${topic.topicIntegratedCurriculum}</textarea>
                </td>

            </tr>
<%--            <tr>--%>
<%--                <td>所属类别：</td>--%>
<%--                <td>--%>
<%--                    <select class="easyui-combobox" style="width: 154px" id="blogTypeId" name="blogTypeId"--%>
<%--                            editable="false"--%>
<%--                            panelHeight="auto">--%>
<%--                        <option value="">请选择题目类别...</option>--%>
<%--                        <c:forEach var="blogType" items="${blogTypeList }">--%>
<%--                            <option value="${blogType.id }" >${blogType.typeName}</option>--%>
<%--                        </c:forEach>--%>
<%--                    </select>--%>
<%--                </td>--%>
<%--            </tr>--%>
            <tr>
                <td valign="top">题目内容：</td>
                <td>
                    <div id="content-editormd" class="form-group" style="z-index: 10">
                        <textarea id="content-editormd-markdown-doc" style="display: none" >${topic.topicContent}</textarea>
                    </div>
                </td>
            </tr>
            <tr>
                <td>题目要求:</td>
                <td>
                    <%--                    <input type="text" id="reprint" name="reprint" style="height:200px;width: 400px;">--%>
                    <textarea id="topicRequirements" name="topicRequirements" style="height:75px;width: 400px;" >${topic.topicRequirements}</textarea>
                </td>

            </tr>
            <tr>
                <td>主要难点:</td>
                <td>
                    <%--                    <input type="text" id="reprint" name="reprint" style="height:200px;width: 400px;">--%>
                    <textarea id="topicMainDifficulties" name="topicMainDifficulties" style="height:75px;width: 400px;" >${topic.topicMainDifficulties}</textarea>
                </td>

            </tr>

            <tr>
                <%--对齐--%>
                <td></td>
                <td>
                    <a href="javascript:submitData()" class="easyui-linkbutton"
                       data-options="iconCls:'icon-submit'">发布题目</a>
                </td>
            </tr>
        </table>
        <input type="hidden" id="topicContent" name="topicContent"/>
        <input type="hidden" id="id" name="id"/>
    </form>
</div>

</body>
</html>