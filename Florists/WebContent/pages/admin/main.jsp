<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>春溢管理平台</title>
	<meta name="renderer" content="webkit">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/layui/css/layui.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/layui_admin/layui/css/layui.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath }/layui_admin/css/font.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath }/layui_admin/css/main.css" />
</head>
<body class="main_body">
    <input id="lockPwd" type="hidden" value="${user.userPwd }">
    <div class="layui-layout layui-layout-admin">
        <!-- 顶部 -->
        <div class="layui-header header">
            <div class="layui-main">
                <a href="#" class="logo">春溢管理平台</a>

                <!-- 天气信息 -->
                <div class="weather" pc>
                    <div id="tp-weather-widget"></div>
                    <script>(function(T,h,i,n,k,P,a,g,e){g=function(){P=h.createElement(i);a=h.getElementsByTagName(i)[0];P.src=k;P.charset="utf-8";P.async=1;a.parentNode.insertBefore(P,a)};T["ThinkPageWeatherWidgetObject"]=n;T[n]||(T[n]=function(){(T[n].q=T[n].q||[]).push(arguments)});T[n].l=+new Date();if(T.attachEvent){T.attachEvent("onload",g)}else{T.addEventListener("load",g,false)}}(window,document,"script","tpwidget","//widget.seniverse.com/widget/chameleon.js"))</script>
                    <script>tpwidget("init", {
                        "flavor": "slim",
                        "location": "WX4FBXXFKE4F",
                        "geolocation": "disabled",
                        "language": "zh-chs",
                        "unit": "c",
                        "theme": "chameleon",
                        "container": "tp-weather-widget",
                        "bubble": "disabled",
                        "alarmType": "badge",
                        "color": "#FFFFFF",
                        "uid": "U9EC08A15F",
                        "hash": "14dff75e7253d3a8b9727522759f3455"
                    });
                    tpwidget("show");</script>
                </div>
                <!-- 顶部右侧菜单 -->
                <ul class="layui-nav top_menu">
                    <li class="layui-nav-item showNotice" id="showNotice" pc>
                        <a href="javascript:;"><i class="iconfont icon-gonggao"></i><cite>系统公告</cite></a>
                    </li>
                    <li class="layui-nav-item" mobile>
                        <a href="javascript:;" data-url="page/user/changePwd.html"><i class="iconfont icon-shezhi1" data-icon="icon-shezhi1"></i><cite>设置</cite></a>
                    </li>
                    <li class="layui-nav-item" mobile>
                        <a href="javascript:;"><i class="iconfont icon-loginout"></i> 退出</a>
                    </li>
                    <li class="layui-nav-item lockcms" pc>
                        <a href="javascript:;"><i class="iconfont icon-lock1"></i><cite>锁屏</cite></a>
                    </li>
                    <li class="layui-nav-item" pc>
                        <a href="javascript:;">
                            <cite>${user.userName }</cite>
                        </a>
                        <dl class="layui-nav-child">
                            <dd><a href="javascript:;" data-url="${pageContext.request.contextPath }/update"><i class="iconfont icon-zhanghu" data-icon="icon-zhanghu"></i><cite>个人资料</cite></a></dd>
                            <dd><a href="userOperationServlet?method=userLogout"><i class="iconfont icon-loginout"></i><cite>退出</cite></a></dd>
                        </dl>
                    </li>
                </ul>
            </div>
        </div>
        <!-- 左侧导航 -->
        <div class="layui-side layui-bg-black">
            <div class="user-photo">
                <a class="img" title="我的头像" ><img src="${pageContext.request.contextPath }/layui_admin/images/face.jpg"></a>
                <p>你好！<span class="userName">${user.userName }</span>, 欢迎登录</p>
            </div>
            <div class="navBar layui-side-scroll"></div>
        </div>
        <!-- 右侧内容 -->
        <div class="layui-body layui-form">
            <div class="layui-tab marg0" lay-filter="bodyTab">
                <ul class="layui-tab-title top_tab">
                    <li class="layui-this" lay-id=""><i class="iconfont icon-computer"></i> <cite>后台首页</cite></li>
                </ul>
                <div class="layui-tab-content clildFrame">
                    <div class="layui-tab-item layui-show">
                        <iframe src="mainWelcome"></iframe>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- 锁屏 -->
    <div class="admin-header-lock" id="lock-box" style="display: none;">
        <div class="admin-header-lock-img"><img src="${pageContext.request.contextPath }/layui_admin/images/face.jpg"/></div>
        <div class="admin-header-lock-name" id="lockUserName">${user.userName }</div>
        <div class="input_btn">
            <input type="password" class="admin-header-lock-input layui-input" placeholder="请输入密码解锁.." name="lockPwd" id="lockPwd" />
            <button class="layui-btn" id="unlock">解锁</button>
        </div>
    </div>
    <!-- 移动导航 -->
    <div class="site-tree-mobile layui-hide"><i class="layui-icon">&#xe602;</i></div>
    <div class="site-mobile-shade"></div>

    <script type="text/javascript" src="${pageContext.request.contextPath }/layui_admin/layui/layui.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/layui_admin/js/nav.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/layui_admin/js/leftNav.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/layui_admin/js/index.js"></script>
</body>
</html>