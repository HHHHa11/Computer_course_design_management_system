<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020/12/25
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
    <script type="text/javascript">
        function chose() {
            var id = ${id6};
            $.messager.confirm("系统提示", "您确定要发布这条评论吗？", function (r) {
                if (r) {
                    // $.post("/student/topic/chosen/"+id , {}, function (result) {
                    //     if (result == "success") {
                    //         $("#topic_status").datagrid("reload");
                    //     } else {
                    //         $.messager.alert("系统提示", "选题失败！");
                    //     }
                    // });
                    // alert($("#topicComment").val())
                    // $("#topic_tontent_forstudent_form1").ajaxSubmit({
                    //     contentType:false,
                    //     processData:false,
                    //     success: function (result) {
                    //         if (result == "success") {
                    //             alert("选题成功!");
                    //             window.location.reload();
                    //
                    //         } else {
                    //             alert("选题失败!");
                    //         }
                    //     }
                    // })
                    $("#topic_tontent_forstudent_form1").form("submit", {
                        url: "/teacher/topic/guidanceinsert/${id6}",
                        onSubmit: function () {
                            return $(this).form("validate");
                        },
                        success: function (result) {
                            if (result == "success") {
                                alert("提交评论成功!");
                                window.location.reload();

                            } else if (result == "false") {
                                alert("评论不能为空!");
                            } else {
                                alert("提交评论失败!");
                            }
                        }
                    });
                }
            });


        }

    </script>
    <script>
        <%--init--%>
        $(function () {

            /*初始化*/
            // var page = 1;
            // var rows = 10;
            var isEnd = false;
            /*结束标志*/

            /*首次加载*/
            $.ajaxSettings.async = false;
            //获取文章列表
            $.post("/teacher/topic/guidanceinsertlist/" + ${id6}, {},
                function (data) {
                    var articles = data.rows;
                    var length = articles.length;
                    var result = '';
                    var total = data.total;

                    // if (page * rows >= total) {
                    //     isEnd = true;
                    // }

                    // if (mobileMatcher.matches) {
                    //     for (var i = 0; i < length; i++) {
                    //         var article = articles[i];
                    //         result += '<li>\n' +
                    //             '                    <div class="content">\n' +
                    //             '                        <a class="title" target="_blank"\n' +
                    //             '                           href="' + '/article/' + article.id + '.html">' + article.title + '</a>\n' +
                    //             '                        <p class="abstract">\n' + getSummary(article.summary, 48) +
                    //             '                        </p>\n' +
                    //             '                        <div class="meta">\n' +
                    //             '                            <span><i class="fa fa-comment-o"></i> ' + article.replyCount + '</span>\n' +
                    //             '                            <span><i class="fa fa-heart-o"></i> ' + article.likeCount + '</span>\n' +
                    //             '                            <span><i class="fa fa-eye"></i> ' + article.clickCount + '</span>\n' +
                    //             '                        </div>\n' +
                    //             '                    </div>\n' +
                    //             '                </li>';
                    //     }
                    // } else {
                    for (var i = 0; i < length; i++) {
                        var article = articles[i];
                        // if (article.blogImage == null || article.blogImage == "") {
                        //     result += '<li>\n' +
                        //         '                    <div class="content">\n' +
                        //         '                        <a class="title" target="_blank"\n' +
                        //         '                           href="' + '/article/' + article.id + '.html">' + article.title + '</a>\n' +
                        //         '                        <p class="abstract">\n' + article.summary +
                        //         '                        </p>\n' +
                        //         '                        <div class="meta">\n' +
                        //         '                            <span><i class="fa fa-comment-o"></i> ' + article.replyCount + '</span>\n' +
                        //         '                            <span><i class="fa fa-heart-o"></i> ' + article.likeCount + '</span>\n' +
                        //         '                            <span><i class="fa fa-eye"></i> ' + article.clickCount + '</span>\n' +
                        //         '                        </div>\n' +
                        //         '                    </div>\n' +
                        //         '                </li>';
                        // } else {
                        result += ' <div>'+'第'+ (i+1) +'次指导意见'+ '<br>'+ article.topicGuidance+'</div> ';
                        // '                    <a class="wrap-img" href="' + '/article/' + article.id + '.html" target="_blank">\n' +
                        // '                        <img src="' + article.blogImage + '">\n' +
                        // '                    </a>\n' +
                        // '                    <div class="content">\n' +
                        // '                        <a class="title" target="_blank" href="' + '/article/' + article.id + '.html">' + article.title + '</a>\n' +
                        // '                        <p class="abstract">\n' +
                        // '                            ' + article.summary + '\n' +
                        // '                        </p>\n' +
                        // '                        <div class="meta">\n' +
                        // '                            <span><i class="fa fa-comment-o"></i> ' + article.replyCount + '</span>\n' +
                        // '                            <span><i class="fa fa-heart-o"></i> ' + article.likeCount + '</span>\n' +
                        // '                            <span><i class="fa fa-eye"></i> ' + article.clickCount + ' </span>\n' +
                        // '                        </div>\n' +
                        // '                    </div>\n' +
                        // '                </li>';
                    }


                    $('.blog-list').append(result);

                }
                , "json");

            $.ajaxSettings.async = true;

            /*监听加载更多*/
            <%--$(window).scroll(function () {--%>
            <%--    if (isEnd == true) {--%>
            <%--        return;--%>
            <%--    }--%>

            <%--    // 当滚动到最底部以上100像素时， 加载新内容--%>
            <%--    // 核心代码--%>
            <%--    if ($(document).height() - $(this).scrollTop() - $(this).height() < 100) {--%>
            <%--        page++;--%>
            <%--        isEnd = addMore(page, rows, ${blogType}, ${title});--%>
            <%--    }--%>
            <%--});--%>


        });

    </script>


</head>
<body>
<a href="javascript:history.back(-1)" class="easyui-linkbutton">返回上一页</a>
<div class="blog-list"></div>
<form id="topic_tontent_forstudent_form1">

    <div>
        <textarea id="topicGuidance" name="topicGuidance" style="height:75px;width: 400px;"></textarea>
    </div>
    <a href="javascript:chose()" class="easyui-linkbutton">发布</a>

    <input type="hidden" id="id" name="id"/>
</form>





</body>
</html>
