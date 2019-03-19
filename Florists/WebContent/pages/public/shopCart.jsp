<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>春溢</title>
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

	<%@ include file="../util/navigation.jsp"%>

	<input type="hidden" id="path"
		value="${pageContext.request.contextPath }" />

	<div class="marginauto1200" id="context">

		<!-- 头部 -->
		<div class="layui-col-xs12">
			<div class="layui-card height120" style="height: 42px;">
				<div class="layui-card-header">
					<i class="layui-icon layui-icon-cart"></i> 我的购物车
				</div>
			</div>
		</div>

		<!-- 购物车信息 -->
		<div class="layui-col-xs12" id="flow"></div>
	</div>

	<script>
		layui.use([ 'element', 'flow' ], function() {

			var element = layui.element;
			//建造实例

			var flow = layui.flow;
			flow.load({
				elem : '#flow', //指定列表容器
				scrollElem : "#flow",
				isAuto : true,
				done : function(page, next) { //到达临界点（默认滚动触发），触发下一页

					var lis = [];

					//以jQuery的Ajax请求为例，请求下一页数据（注意：page是从2开始返回）
					$.ajax({
						url : "shopCartServlet",
						data : {
							method : "ajaxShopCartPage",
							currentPage : page
						},
						type : "POST",
						dataType : "json",
						success : function(data) {
							console.log(data);

							// 遍历数据
							layui.each(data.pageData, function(index, item) {
								lis.push(addShopCartHtml(item));
							});

							// 下一页
							next(lis.join(''), page < data.totalPage);
						},
						error : function(data) {
							location.href = data.responseText;
						}

					});

				},
				end : "到底啦…别扯了!",
			});
		});
	</script>

	<script type="text/javascript">
		setTimeout(function() {
			$(".shopcart").on('click', function() {
				var data_no = $(this).attr("data-no");
				nowCommNum(data_no);
			});

			$(".delete").on('click', function() {
				var delete_no = $(this).attr("delete-no");
				deleteCart(delete_no);
			});
		}, 1000);
	</script>
</body>
</html>