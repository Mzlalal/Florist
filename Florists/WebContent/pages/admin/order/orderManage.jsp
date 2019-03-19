<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../util/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>商家管理</title>
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
                <input type="text" value="" placeholder="请输入订单ID或订单名" class="layui-input search_input">
            </div>
            <a class="layui-btn search_btn"><i class="layui-icon layui-icon-search"></i>查询</a>
        </div>
        <div class="layui-inline">
        </div>
            <a class="layui-btn layui-btn-danger batchDel"><i class="layui-icon">&#xe640;</i>批量删除</a>
	</blockquote>
    <div class="layui-form news_list">
        <table class="layui-table">
            <colgroup>
                <col width="5%">
                <col width="5%">
                <col width="15%">
                <col width="20%">
                <col width="15%">
                <col width="30%">
                <col width="15%">
            </colgroup>
            <thead>
                <tr>
                    <th><input type="checkbox" name="" lay-skin="primary" lay-filter="allChoose" id="allChoose"></th>
                    <th>订单ID</th>
                    <th>订单名</th>
                    <th>订单创建日期</th>
                    <th>收货电话</th>
                    <th>收货地址</th>
                    <th>操作</th>
                </tr> 
            </thead>
            <tbody class="users_content"></tbody>
        </table>
    </div>
    <div id="page">
    </div>
    <script type="text/javascript" src="${pageContext.request.contextPath }/layui_admin/layui/layui.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/layui_admin/pageJs/OrderManage.js"></script>
</body>
</html>