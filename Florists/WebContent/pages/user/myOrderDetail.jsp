<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单详情</title>
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
					<i class="layui-icon layui-icon-cart"></i> 订单详情 ${detailInfo[0].orderDate }
				</div>
			</div>
		</div>

		<!-- 购物车信息 -->
		<div class="layui-col-xs12" id="flow">
			<c:forEach items="${detailInfo }" var="detail">

				<div class="layui-col-xs12 margintop20">
					<div class="layui-col-xs9">
						<div class="layui-card height220">
							<div class="layui-card-header">
								<a class="fontBlue"
									href="/Florists/flowerServlet?method=loadFlowerById&id=${detail.flowerId }">${detail.flowerName }</a><span
									style="float: right">${detail.sellerName }的小店</span>
							</div>
							<div class="layui-card-body">
								<a
									href="/Florists/flowerServlet?method=loadFlowerById&id=${detail.flowerId }">
									${detail.flowerDesc } </a>
							</div>
							<div class="shopcar">
								<span class="amount">数量:${detail.orderAmount }</span>
								<span class="price">价格:<b>${detail.orderAmount * detail.flowerPrice }</b></span>
							</div>
						</div>
					</div>
					<div class="layui-col-xs3 height220">
						<div class="layui-card">
							<img src="/Florists/layui/images/img/1.jpg">
						</div>
					</div>
				</div>

			</c:forEach>
		</div>
		
		<!-- 总价 -->
        <div class="layui-col-xs12">
            <div class="layui-card height120" style="height: 42px;">
                <div class="layui-card-header">
                    <i class="layui-icon layui-icon-cart"></i>订单总价:￥<b class="fontRed" id="priceSum">0</b>
                </div>
            </div>
        </div>
	</div>

	<script>
		layui.use([ 'element' ], function() {
			var element = layui.element;
		});
	</script>

	<script type="text/javascript">
        setTimeout(function(){
        	var arr = $(".price").find("b");
        	var priceSum = 0;
        	for (var i = 0; i < arr.length; i++) {
        		priceSum += parseInt(arr[i].innerText);
        	}
        	$("#priceSum").html(priceSum);
        }, 1000);
    </script>
</body>
</html>