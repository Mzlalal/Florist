<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${flower.flowerName }</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/layui/css/layui.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/layui/css/base.css">
<script src="${pageContext.request.contextPath }/layui/layui.js"></script>
<script src="${pageContext.request.contextPath }/layui/jquery-3.2.1.js"></script>
<script src="${pageContext.request.contextPath }/layui/js/shopCart.js"></script>
<script src="${pageContext.request.contextPath }/layui/js/comms_detail.js"></script>
</head>
<body>
	<!-- 导航 -->
	<%@ include file="../util/navigation.jsp"%>

	<div class="marginauto1200">
		<!-- 图片轮播-->
		<div class="layui-col-xs6">
			<div class="layui-carousel" id="carousel">
				<div carousel-item>
					<div>
						<img
							src="${pageContext.request.contextPath }/layui/images/img/01.jpg"
							class="marginauto1200">
					</div>
					<div>
						<img
							src="${pageContext.request.contextPath }/layui/images/img/02.jpg"
							class="marginauto1200">
					</div>
					<div>
						<img
							src="${pageContext.request.contextPath }/layui/images/img/03.jpg"
							class="marginauto1200">
					</div>
					<div>
						<img
							src="${pageContext.request.contextPath }/layui/images/img/04.jpg"
							class="marginauto1200">
					</div>
					<div>
						<img
							src="${pageContext.request.contextPath }/layui/images/img/05.jpg"
							class="marginauto1200">
					</div>
				</div>
			</div>
		</div>

		<!--商品信息-->
		<div class="layui-col-xs6">
			<div class="layui-card height600">
				<div class="layui-card-header" id="flowerId" data-no="${param.id }">${flower.flowerName }</div>
				<div class="layui-card-body">
					<form class="layui-form" action="">
						<div class="layui-form-item">
							<label class="layui-form-label">标题</label>
							<div class="layui-input-inline">
								<label class="layui-form-label">${flower.flowerName }</label>
							</div>
						</div>

						<div class="layui-form-item">
							<label class="layui-form-label">描述</label>
							<div class="layui-input-block">
								<div class="heighi50overhidden" title="${flower.flowerDesc }">
									${flower.flowerDesc }</div>
								…
							</div>
						</div>

						<div class="layui-form-item">
							<label class="layui-form-label">价格</label>
							<div class="layui-input-inline">
								<label class="layui-form-label fontRed">${flower.flowerPrice }</label>
							</div>
						</div>

						<div class="layui-form-item">
							<label class="layui-form-label">库存</label>
							<div class="layui-input-inline">
								<label class="layui-form-label fontRed" id="commNumber">${flower.flowerAmount }</label>
							</div>
						</div>

						<div class="layui-form-item">
							<label class="layui-form-label">选择数量</label>
							<div class="layui-input-inline">
								<input type="text" id="amount" name="amount" required lay-verify="required"
									placeholder="请输入数量" class="layui-input" value="1">
							</div>
							<div class="layui-form-mid layui-word-aux" id="rpassword"></div>
						</div>

						<div class="layui-form-item">
							<label class="layui-form-label">购买方式</label>
							<div class="layui-input-block">
								<input type="radio" name="type" value="1" title="租赁" checked>
								<input type="radio" name="type" value="2" title="购买">
							</div>
						</div>

						<div class="layui-form-item">
							<label class="layui-form-label">地址</label>
							<div class="layui-input-block">
								<input type="text" name="address" value="${user.userAddress }"
									required lay-verify="required" placeholder="请先登录"
									autocomplete="on" class="layui-input">
							</div>
						</div>

						<div class="layui-form-item">
							<label class="layui-form-label">电话</label>
							<div class="layui-input-inline">
								<input type="text" name="phone" value="${user.userPhone }"
									required lay-verify="required" placeholder="请先登录"
									autocomplete="on" class="layui-input">
							</div>
						</div>

						<div class="layui-form-item">
							<div class="layui-input-block">
								<a class="layui-btn layui-btn-radius" onclick="detailAddCart();">加入购物车</a>
								<button class="layui-btn layui-btn-radius ${flower.flowerAmount<=0?'layui-btn-disabled':'' }" 
								lay-submit lay-filter="submit" ${flower.flowerAmount<=0?'disabled':'' }>立即购买</button>
							</div>
						</div>
					</form>

				</div>
			</div>
		</div>

	</div>
	<!-- 条目中可以是任意内容，如：<img src=""> -->
	<script>
		layui.use([ 'form', 'carousel', 'element' ], function() {
			var element = layui.element;
			var form = layui.form;
			var carousel = layui.carousel;
			//建造实例
			
			loadCartNum(getQueryString("id"));
			
			carousel.render({
				elem : '#carousel'
				,width : '100%'
				,height : '600px'//设置容器宽度
				,arrow : 'hover' //显示箭头
				,anim : 'fade' //切换动画方式
			});

			//监听提交
			form.on('submit(submit)', function(data) {
				data = data.field;
				
				// 生成订单
				createOrder(data);

				return false;
			});
		});
		
		
	</script>
</body>
</html>