<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../util/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>类别管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/layui/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/layui_admin/layui/css/layui.css" media="all" />
    <link rel="stylesheet" href="${pageContext.request.contextPath }/layui_admin/css/font.css" media="all" />
    <link rel="stylesheet" href="${pageContext.request.contextPath }/layui_admin/css/user.css" media="all" />
</head>
<body class="childrenBody">
    <blockquote class="layui-elem-quote news_search">
        <div class="layui-inline">
            <div class="layui-input-inline">
                <input type="text" value="" placeholder="请输入类别ID或者类别名" class="layui-input search_input">
            </div>
            <a class="layui-btn search_btn"><i class="layui-icon layui-icon-search"></i>查询</a>
        </div>
        <div class="layui-inline">
            <a class="layui-btn layui-btn-normal usersAdd_btn"><i class="layui-icon layui-icon-add-1"></i>添加</a>
        </div>
        <div class="layui-inline">
        </div>
            <a class="layui-btn layui-btn-danger batchDel"><i class="layui-icon">&#xe640;</i>批量删除</a>
		<div class="layui-inline">
			<div class="layui-form-mid layui-word-aux">
				添加成功以后,当前页面可能数据过多无法显示,可以使用查询确认是否添加成功.</div>
		</div>
	</blockquote>
    <div class="layui-form news_list">
        <table class="layui-table">
            <colgroup>
                <col width="5%">
                <col width="40%">
                <col width="40%">
                <col width="15%">
            </colgroup>
            <thead>
                <tr>
                    <th><input type="checkbox" name="" lay-skin="primary" lay-filter="allChoose" id="allChoose"></th>
                    <th>类别ID</th>
                    <th>类别名</th>
                    <th>操作</th>
                </tr> 
            </thead>
            <tbody class="users_content"></tbody>
        </table>
    </div>
    <div id="page">
    </div>
    <script type="text/javascript" src="${pageContext.request.contextPath }/layui_admin/layui/layui.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/layui_admin/pageJs/TypeManage.js"></script>
</body>
</html>