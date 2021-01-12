<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>班级信息管理页面</title>
    <link rel="stylesheet" type="text/css"
          href="/static/static-easyui/plugin/jeasyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css"
          href="/static/static-easyui/plugin/jeasyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="/static/static-easyui/css/customAdmin.css">
    <script type="text/javascript"
            src="/static/static-easyui/plugin/jeasyui/jquery.min.js"></script>
    <script type="text/javascript"
            src="/static/static-easyui/plugin/jeasyui/jquery.easyui.min.js"></script>
    <script type="text/javascript"
            src="/static/static-easyui/plugin/jeasyui/locale/easyui-lang-zh_CN.js"></script>


    <script type="text/javascript">

        var url;

        function searchBlog() {
            $("#dg").datagrid('load', {
                "topic_title": $("#s_title").val()
            });
        }

        // function deleteTopic() {
        //     var selectedRows = $("#dg").datagrid("getSelections");
        //     if (selectedRows.length == 0) {
        //         $.messager.alert("系统提示", "请选择要删除的数据！");
        //         return;
        //     }
        //     var strIds = [];
        //     for (var i = 0; i < selectedRows.length; i++) {
        //         strIds.push(selectedRows[i].id);
        //     }
        //     var ids = strIds.join(",");
        //     $.messager.confirm("系统提示", "您确定要删除这<font color=red>" + selectedRows.length + "</font>条数据吗？", function (r) {
        //         if (r) {
        //             $.post("/teacher/topic/delete/" + ids, {}, function (result) {
        //                 if (result == "success") {
        //                     $("#dg").datagrid("reload");
        //                 } else {
        //                     $.messager.alert("系统提示", "数据删除失败！");
        //                 }
        //             });
        //         }
        //     });
        // }

        // function openTopicModifyDialog() {
        //     var selectedRows = $("#dg").datagrid("getSelections");
        //     if (selectedRows.length != 1) {
        //         $.messager.alert("系统提示", "请选择一条要编辑的数据！");
        //         return;
        //     }
        //     var row = selectedRows[0];
        //     window.parent.opentable('teacher/topic/modifyTopic/'+row.id)
        // }

        // function saveTopic() {
        //     $("#fm").form("submit", {
        //         url: url,
        //         onSubmit: function () {
        //             return $(this).form("validate");
        //         },
        //         success: function (result) {
        //             // var result = eval('(' + result + ')');
        //             if (result == "success") {
        //                 $.messager.alert("系统提示", "保存成功！");
        //                 resetValue();
        //                 $("#dlg").dialog("close");
        //                 $("#dg").datagrid("reload");
        //             } else {
        //                 $.messager.alert("系统提示", "保存失败！");
        //                 return;
        //             }
        //         }
        //     });
        // }

        // function resetValue() {
        //     $("#typeName").val("");
        //     $("#orderNo").val("");
        // }

        // function closeTopicDialog() {
        //     $("#dlg").dialog("close");
        //     resetValue();
        // }

        // function batchaddTopic() {
        //     $("#dlg1").dialog("open").dialog("setTitle", "批量添加班级信息信息");
        //
        // }

        //这是一个带选题功能的页面
        function formatTitle(val, row) {
            return "<a target='_self' style='text-decoration:none' href='/articlechoose/" + row.id + "'>" + val + "</a>"
        }
    </script>
</head>
<body style="margin: 1px">
<table id="dg" title="选题" class="easyui-datagrid"
       fitColumns="true" pagination="true" rownumbers="true"
       url="/student/topic/list" fit="true" toolbar="#tb">
    <thead>
    <tr>
        <th field="cb" checkbox="true" align="center"></th>
        <th field="id" width="20" align="center">编号</th>
        <th field="topicTitle" width="100" align="center" formatter="formatTitle">题目标题</th>
        <th field="topicCourse" width="100" align="center">所属课程</th>
        <th field="topicSemester" width="100" align="center">所属学期</th>
        <th field="topicType" width="100" align="center">题目类别</th>
        <th field="topicSource" width="100" align="center">题目来源</th>
        <th field="topicStatus" width="100" align="center">题目状态</th>
        <th field="teacherName" width="100" align="center">发布老师</th>

    </tr>
    </thead>
</table>
<div id="tb">
    <div>
        <%--        <a href="javascript:openTopicModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit"--%>
        <%--           plain="true">修改</a>--%>
        <%--        <a href="javascript:deleteTopic()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>--%>
        <%--        <a href="javascript:batchaddTopic()" class="easyui-linkbutton" iconCls="icon-add" plain="true">批量增加</a>--%>
        <div>
            &nbsp;标题：&nbsp;<input type="text" id="s_title" size="20" onkeydown="if(event.keyCode==13) searchBlog()"/>
            <a href="javascript:searchBlog()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
        </div>
    </div>
</div>


<div id="dlg" class="easyui-dialog" style="width:500px;height:180px;padding: 10px 20px"
     closed="true" buttons="#dlg-buttons">

    <form id="fm" method="post">
        <table cellspacing="8px">
            <tr>
                <td>班级信息名称：</td>
                <td><input type="text" id="className" name="className" class="easyui-validatebox" required="true"/></td>
            </tr>
            <%--一个表单下，如果只有一个文本框时，按下回车将会触发表单的提交事件，加上hiddentext可以防止提交--%>
            <input id="hiddenText" type="text" style="display:none"/>
        </table>
    </form>


</div>

<div id="dlg1" class="easyui-dialog" style="width:500px;height:180px;padding: 10px 20px"
     closed="true">
    <div>
        <form id="form_excel" name="form_excel" action="/teacher/topic/DoExcel" method="post"
              enctype="multipart/form-data">
            请选择相应的Excel文件<br>
            <input type="file" id="file_excel" name="file_excel"/><br>
            <input type="submit"/>
        </form>

    </div>

</div>


<%--<div id="dlg-buttons">--%>
<%--    <a href="javascript:saveTopic()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>--%>
<%--    <a href="javascript:closeTopicDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>--%>
<%--</div>--%>
</body>
</html>