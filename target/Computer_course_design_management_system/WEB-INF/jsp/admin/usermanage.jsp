<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户信息管理页面</title>
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

        function deleteUser() {
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
                    $.post("/admin/user/delete/" + ids, {}, function (result) {
                        if (result == "success") {
                            $("#dg").datagrid("reload");
                        } else {
                            $.messager.alert("系统提示", "数据删除失败！");
                        }
                    });
                }
            });
        }

        function openUserAddDialog() {
            $("#dlg").dialog("open").dialog("setTitle", "添加用户信息");
            url = "/admin/user/insert";
        }

        function openUserModifyDialog() {
            var selectedRows = $("#dg").datagrid("getSelections");
            if (selectedRows.length != 1) {
                $.messager.alert("系统提示", "请选择一条要编辑的数据！");
                return;
            }
            var row = selectedRows[0];
            $("#dlg").dialog("open").dialog("setTitle", "编辑用户信息");
            $("#fm").form("load", row);
            url = "/admin/user/update/" + row.id;
        }

        function saveUser() {
            $("#fm").form("submit", {
                url: url,
                onSubmit: function () {
                    return $(this).form("validate");
                },
                success: function (result) {
                    // var result = eval('(' + result + ')');
                    if (result == "success") {
                        $.messager.alert("系统提示", "保存成功！");
                        resetValue();
                        $("#dlg").dialog("close");
                        $("#dg").datagrid("reload");
                    } else {
                        $.messager.alert("系统提示", "保存失败！");
                        return;
                    }
                }
            });
        }

        function resetValue() {
            $("#typeName").val("");
            $("#orderNo").val("");
        }

        function closeUserDialog() {
            $("#dlg").dialog("close");
            resetValue();
        }
        function batchaddUser() {
            $("#dlg1").dialog("open").dialog("setTitle", "批量添加用户信息");

        }
    </script>
</head>
<body style="margin: 1px">
<table id="dg" title="用户信息管理" class="easyui-datagrid"
       fitColumns="true" pagination="true" rownumbers="true"
       url="/admin/user/list" fit="true" toolbar="#tb">
    <thead>
    <tr>
        <th field="cb" checkbox="true" align="center"></th>
        <th field="id" width="5" align="center">编号</th>
        <th field="name" width="5" align="center">姓名</th>
        <th field="studentNumber" width="10" align="center">学号</th>
        <th field="classes" width="15" align="center">班级</th>
        <th field="gender" width="5" align="center">性别</th>
        <th field="email" width="10" align="center">邮箱</th>
        <th field="username" width="10" align="center">用户名</th>
        <th field="password" width="10" align="center">密码</th>
        <th field="identity" width="15" align="center">身份</th>

    </tr>
    </thead>
</table>
<div id="tb">
    <div>
        <a href="javascript:openUserAddDialog()" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
        <a href="javascript:openUserModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit"
           plain="true">修改</a>
        <a href="javascript:deleteUser()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
        <a href="javascript:batchaddUser()" class="easyui-linkbutton"iconCls="icon-add" plain="true">批量增加</a>
    </div>
</div>


<div id="dlg" class="easyui-dialog" style="width:500px;height:400px;padding: 10px 20px"
     closed="true" buttons="#dlg-buttons">

    <form id="fm" method="post">
        <table cellspacing="8px">
            <tr>
                <td>姓名</td>
                <td><input type="text" id="name" name="name" class="easyui-validatebox" required="true"/></td>
            </tr>
            <tr>
                <td>学号</td>
                <td><input type="text" id="studentNumber" name="studentNumber" class="easyui-validatebox" required="true"/></td>
            </tr>
            <tr>
                <td>班级</td>
                <td><input type="text" id="classes" name="classes" class="easyui-validatebox" required="true"/></td>
            </tr>
            <tr>
                <td>性别</td>
                <td><input type="text" id="gender" name="gender" class="easyui-validatebox" required="true"/></td>
            </tr>
            <tr>
                <td>邮箱</td>
                <td><input type="text" id="email" name="email" class="easyui-validatebox" required="true"/></td>
            </tr>
            <tr>
                <td>用户名</td>
                <td><input type="text" id="username" name="username" class="easyui-validatebox" required="true"/></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="text" id="password" name="password" class="easyui-validatebox" required="true"/></td>
            </tr>
            <tr>
                <td>身份</td>
                <td><input type="text" id="identity" name="identity" class="easyui-validatebox" required="true"/></td>
            </tr>
            <%--一个表单下，如果只有一个文本框时，按下回车将会触发表单的提交事件，加上hiddentext可以防止提交--%>
            <input id="hiddenText" type="text" style="display:none"/>
        </table>
    </form>



</div>

<div id="dlg1" class="easyui-dialog" style="width:500px;height:180px;padding: 10px 20px"
     closed="true" >
    <div>
        <form id="form_excel" name="form_excel" action="/admin/user/DoExcel" method="post"
              enctype="multipart/form-data">
            请选择相应的Excel文件<br>
            <input type="file" id="file_excel" name="file_excel"/><br>
            <input type="submit"/>
        </form>

    </div>

</div>


<div id="dlg-buttons">
    <a href="javascript:saveUser()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
    <a href="javascript:closeUserDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
</div>
</body>
</html>