<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v4.1.1">
    <title>Dashboard Template · Bootstrap</title>

    <link rel="canonical" href="/static/bootstrap-4.5.3-examples/dashboard/index.html">

    <!-- Bootstrap core CSS -->
    <link href="/static/bootstrap-4.5.3-examples/assets/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
        .button-style-for-light{
            width: 100%;
            text-align: left;

        }
    </style>
    <!-- Custom styles for this template -->
    <link href="/static/bootstrap-4.5.3-examples/dashboard/dashboard.css" rel="stylesheet">
    <script type="text/javascript">
        //登出操作
        function showsignoutmodal() {

            //这里将Modal连接/显示出来
            $("#logout").modal('show')
            //绑定Modal中提交键中的内容
            $('#btn_submit').click(function () {
                //如果触发了该按键则执行logout操作
                window.location.href = '/user/logout';

            })



        }
        //封裝好打開界面操作
        function opentable(url) {
            // $("#home")[0].innerHTML = "<iframe frameborder=0 scrolling='auto' style='width:100%;height:100%' src='/index'></iframe>"
            document.getElementById("home").innerHTML = "<iframe frameborder=0 scrolling='auto' style='width:100%;height:100%' src='/"+url+"'></iframe>"

        }






    </script>
</head>
<body>
<nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
    <a class="navbar-brand col-md-3 col-lg-2 mr-0 px-3" href="#">${user.name}</a>
    <button class="navbar-toggler position-absolute d-md-none collapsed" type="button" data-toggle="collapse"
            data-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <input class="form-control form-control-dark w-100" type="text" placeholder="Search" aria-label="Search">
    <ul class="navbar-nav px-3">
        <li class="nav-item text-nowrap">
            <a class="nav-link" href="javascript:showsignoutmodal()">安全退出</a>
        </li>
    </ul>
</nav>


<!-- Modal -->
<div class="modal fade" id="logout" data-backdrop="static" data-keyboard="false" tabindex="-1"
     aria-labelledby="logoutLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="staticBackdropLabel">系统提示</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                您确定要退出系统吗？
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" id="btn_submit">确定</button>
            </div>
        </div>
    </div>
</div>


<div class="container-fluid">
    <div class="row">
        <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
            <div class="sidebar-sticky pt-3">
                <%--       单击后的下弹框         --%>
                <div class="accordion" id="accordionExample">
                    <div class="card">
                        <div class="card-header" id="headingOne">
                            <h2 class="mb-0">
                                <button class="btn btn-link btn-block text-left" type="button" data-toggle="collapse"
                                        data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                    Collapsible Group Item #1
                                </button>
                            </h2>
                        </div>
                        <%--对于不需要一加载就显示的框来说--%>
                        <%--     class="collapse show"要变成class="collapse"--%>
                        <div id="collapseOne" class="collapse show" aria-labelledby="headingOne"
                             data-parent="#accordionExample">
                            <div class="card-body">
                                <div style="width:100%">
                                    <button type="button" class="btn btn-light button-style-for-light" onclick="opentable('semestermanage')" >
                                        <span data-feather="file"></span>
                                        学期管理
                                    </button><br>
                                    <button type="button" class="btn btn-light button-style-for-light" onclick="opentable('usermanage')">
                                        用户信息管理
                                    </button><br>
                                    <button type="button" class="btn btn-light button-style-for-light">Secondary</button><br>
                                    <button type="button" class="btn btn-light button-style-for-light">Secondary</button><br>
                                    <button type="button" class="btn btn-light button-style-for-light">Secondary</button>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="card">
                        <div class="card-header" id="headingTwo">
                            <h2 class="mb-0">
                                <button class="btn btn-link btn-block text-left collapsed" type="button"
                                        data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false"
                                        aria-controls="collapseTwo">
                                    Collapsible Group Item #2
                                </button>
                            </h2>
                        </div>
                        <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
                             data-parent="#accordionExample">
                            <div class="card-body">
                                <div style="width:100%">
                                    <button type="button" class="btn btn-light button-style-for-light">
                                        <span data-feather="file"></span>
                                        学期管理
                                    </button>
                                    <br>
                                    <button type="button" class="btn btn-light button-style-for-light">学生信息管理</button>
                                    <br>
                                    <button type="button" class="btn btn-light button-style-for-light">Secondary
                                    </button>
                                    <br>
                                    <button type="button" class="btn btn-light button-style-for-light">Secondary
                                    </button>
                                    <br>
                                    <button type="button" class="btn btn-light button-style-for-light">Secondary
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="card">
                        <div class="card-header" id="headingThree">
                            <h2 class="mb-0">
                                <button class="btn btn-link btn-block text-left collapsed" type="button"
                                        data-toggle="collapse" data-target="#collapseThree" aria-expanded="false"
                                        aria-controls="collapseThree">
                                    Collapsible Group Item #3
                                </button>
                            </h2>
                        </div>
                        <div id="collapseThree" class="collapse" aria-labelledby="headingThree"
                             data-parent="#accordionExample">
                            <div class="card-body">
                                <div style="width:100%">
                                    <button type="button" class="btn btn-light button-style-for-light">
                                        <span data-feather="file"></span>
                                        学期管理
                                    </button>
                                    <br>
                                    <button type="button" class="btn btn-light button-style-for-light">学生信息管理</button>
                                    <br>
                                    <button type="button" class="btn btn-light button-style-for-light">Secondary
                                    </button>
                                    <br>
                                    <button type="button" class="btn btn-light button-style-for-light">Secondary
                                    </button>
                                    <br>
                                    <button type="button" class="btn btn-light button-style-for-light">Secondary
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>


            </div>
        </nav>

        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
            <div style="height: 750px;width: 100%;" id="home">

            </div>


        </main>
    </div>
    <div
</div>
<script src="/static/js/jquery-3.5.1.slim.min.js"></script>
<script>window.jQuery || document.write('<script src="/static/bootstrap-4.5.3-examples/assets/js/vendor/jquery.slim.min.js"><\/script>')</script>
<script src="/static/bootstrap-4.5.3-examples/assets/dist/js/bootstrap.bundle.min.js"></script>
<script src="/static/js/feather.min.js"></script>
<script src="/static/js/Chart.min.js"></script>
<script src="/static/bootstrap-4.5.3-examples/dashboard/dashboard.js"></script>
</body>
</html>
