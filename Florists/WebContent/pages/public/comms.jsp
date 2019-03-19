<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../util/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更多商品</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/layui/css/layui.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/layui/css/base.css">
<script src="${pageContext.request.contextPath }/layui/layui.js"></script>
<script src="${pageContext.request.contextPath }/layui/jquery-3.2.1.js"></script>
<script src="${pageContext.request.contextPath }/layui/js/index.js"></script>
<script src="${pageContext.request.contextPath }/layui/js/shopCart.js"></script>
</head>
<body>
	<!-- 导航 -->
	<%@ include file="../util/navigation.jsp"%>

	<input type="hidden" id="path"
		value="${pageContext.request.contextPath }" />

	<div class="marginauto1200">


		<div class="layui-col-xs12">
			<div class="layui-card height120">
				<div class="layui-card-header">信息检索</div>
				<div class="layui-card-body">
					<div id="category">
						<a class="fontBlue" href="javascript:;">种类:</a>
					</div>
				</div>
			</div>
		</div>

		<!-- 信息 -->

		<c:forEach items="${pageBean.pageData }" var="pageData"
			varStatus="status">
			<div class="layui-col-xs12 margintop20">
				<div class="layui-col-xs9">
					<div class="layui-card height220">
						<div class="layui-card-header">
							<a class="fontBlue"
								href="${pageContext.request.contextPath }/flowerServlet?method=loadFlowerById&id=${pageData.flowerId} ">
								${pageData.flowerName } </a>
						</div>
						<div class="layui-card-body">${pageData.flowerDesc }</div>
						<div class="shopcar" data-no="${pageData.flowerId }">
							<span class="amount">库存:${pageData.flowerAmount }</span><i
								class="layui-icon layui-icon-cart-simple"></i> 添加到购物车
						</div>
					</div>
				</div>

				<div class="layui-col-xs3 height220">
					<div class="layui-card">
						<img
							src="${pageContext.request.contextPath }/layui/images/img/1.jpg" />
					</div>
				</div>

			</div>
		</c:forEach>


		<!-- 分页 -->
		<div id="page"></div>

	</div>

	<script type="text/javascript">
		// 开始加载
		$(function() {
			loadCategories();
		});
	</script>
	<script>
		layui.use([ 'element', 'laypage' ], function() {
			
			$(".shopcar").on('click', function() {
				console.log($(this).attr("data-no"));
				nowCommNum($(this).attr("data-no"));
			});
			
			var carousel = layui.carousel;
			var laypage = layui.laypage;

			//总页数大于页码总数
			laypage.render({
				elem : 'page',
				curr : '${currentPage }',
				count : '${pageBean.totalCount }' //数据总数
				,
				limit : 5,
				jump : function(obj, first) {
					console.log(obj);
					var url = location.href;

					// 判断是否有分页参数
					if (url.indexOf("&currentPage=")) {
						var arr = url.split("&currentPage=");
						url = arr[0];
					}
					url += "&currentPage=" + (obj.curr)
					console.log(url);
					if (!first) {
						location.href = url;
					}
				}
			});
		});
	</script>
</body>
</html>