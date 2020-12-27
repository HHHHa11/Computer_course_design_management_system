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

        function formatTitle(val, row) {
            return "<a target='_self' style='text-decoration:none' href='/articlechoose/" + row.id + "'>" + val + "</a>"
        }

        function searchBlog() {
            // alert($("#s_title").val())
            $("#dg").datagrid('load', {
                "topicTitle": "et"
            });
        }

        function deleteBlog() {
            var selectedRows = $("#dg").datagrid("getSelections");
            if (selectedRows.length == 0) {
                $.messager.alert("系统提示", "请选择要删除的数据！");
                return;
            }
            var strIds = [];
            for (var i = 0; i < selectedRows.length; i++) {
                strIds.push(selectedRows[i].id);
            }
            var ids = strIds.join(",");
            $.messager.confirm("系统提示", "您确定要删除这<font color=red>" + selectedRows.length + "</font>条数据吗？", function (r) {
                if (r) {
                    $.post("${pageContext.request.contextPath}/admin/blog/delete/" + ids, {}, function (result) {
                        if (result == "success") {
                            $.messager.alert("系统提示", "数据已成功删除！");
                            $("#dg").datagrid("reload");
                        } else {
                            $.messager.alert("系统提示", "数据删除失败！");
                        }
                    });
                }
            });
        }


        function openBlogModifyTab() {
            var selectedRows = $("#dg").datagrid("getSelections");
            if (selectedRows.length != 1) {
                $.messager.alert("系统提示", "请选择一个要修改的博客！");
                return;
            }
            var row = selectedRows[0];
            window.parent.openTab('修改博客', 'modifyBlog/' + row.id, 'icon-writeblog');
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
<%--    <div>--%>
<%--        <a href="javascript:openBlogModifyTab()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>--%>
<%--        <a href="javascript:deleteBlog()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>--%>
<%--    </div>--%>
    <div>
<%--        &nbsp;标题：&nbsp;<input type="text" id="s_title" size="20" onkeydown="if(event.keyCode==13) searchBlog()"/>--%>
<%--        <a href="javascript:searchBlog()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>--%>
    </div>
</div>
</body>
</html>