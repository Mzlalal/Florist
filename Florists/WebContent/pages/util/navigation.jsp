<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../util/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>导航栏</title>
<style type="text/css">
.h1font {
    color: white;
	font-weight: bold;
	font-size: 30px;
	line-height: 60px;
}
</style>
</head>

<body>
	<ul class="layui-nav layui-bg-green">
		<div class="layui-col-xs2">&nbsp;</div>
		<div class="layui-col-xs6">
			<a href="${pageContext.request.contextPath}/index">
				<h1 class="h1font">春溢</h1>
			</a>

		</div>
		<li class="layui-nav-item layui-this"><a href="javascript:;">关于我们</a>
			<dl class="layui-nav-child">
				<dd>
					<a href="">选项1</a>
				</dd>
				<dd>
					<a href="">选项2</a>
				</dd>
				<dd>
					<a href="">选项3</a>
				</dd>
			</dl></li>
		<li class="layui-nav-item"><a href="${pageContext.request.contextPath}/sellerRegister">加入我们</a></li>

		<c:choose>
			<c:when test="${user == null }">
				<li class="layui-nav-item"><a id="verifyLogin" href="login">登录</a></li>
			</c:when>
			<c:when test="${user != null }">
				<li class="layui-nav-item"><a href="javascript:;">${user.userName }</a>
					<dl class="layui-nav-child">
						<dd class="layui-this">
							<a href="javascript:;">信用分:${user.userCredit }</a>
						</dd>
						<dd>
							<a href="update">修改信息</a>
						</dd>
						<dd>
                            <a href="myShopCart">我的购物车</a>
                        </dd>
						<dd>
							<a href="myOrder">查看订单</a>
						</dd>
						<dd>
							<a href="userOperationServlet?method=userLogout">退出登录</a>
						</dd>
					</dl></li>
			</c:when>
		</c:choose>


	</ul>


</body>
</html>