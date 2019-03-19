// 首页js文件

function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]); return null;
}

function loadCategories() {
	$.ajax({
		url : "flowerTypeServlet",
		type : "post",
		data : {
			method : "ajaxFlowerTypes"
		},
		dataType : 'json',
		success : function(data) {
			console.log(data);
			for (var i = 0; i < data.length; i++) {
				addCategoryHtml(data[i]);
			}
		},
		error : function() {
			alert("服务器加载失败");
		}
	});
}

function loadFlowers() {
	$.ajax({
		url : "flowerServlet",
		type : "post",
		dataType : "json",
		async : false,
		data : {
			method : "ajaxFlowerPage",
			currentPage : "1"
		},
		success : function(data) {
			console.log(data);
			for (var i = 0; i < data.length; i++) {
				addFloewrHtml(data[i]);
			}
		},
		error : function() {
			alert("服务器加载失败");
		}
	});
}

function addFloewrHtml(data) {

	var html = '<div class="layui-col-xs12 margintop20">';
	html += '	<div class="layui-col-xs9">';
	html += '		<div class="layui-card height220">';
	html += '			<div class="layui-card-header">';
	html += '				<a class="fontBlue"';
	html += '					href="flowerServlet?method=loadFlowerById&id='+data.flowerId+'">'+data.flowerName+'</a><span';
	html += '					style="float: right">'+data.userName+'的小店</span>';
	html += '			</div>';
	html += '			<div class="layui-card-body">';
	html += '				<a href="flowerServlet?method=loadFlowerById&id='+data.flowerId+'">'+data.flowerDesc+'</a>';
	html += '			</div>';
	html += '			<div class="shopcar" data-no="'+data.flowerId+'">';
	html += '			<span class="price">价格:<b>'+data.flowerPrice+'</b></span>';
	html += '				<span class="amount">库存:'+data.flowerAmount+'</span><i';
	html += '					class="layui-icon layui-icon-cart-simple"></i> 添加到购物车';
	html += '			</div>';
	html += '		</div>';
	html += '	</div>';
	html += '	<div class="layui-col-xs3 height220">';
	html += '		<div class="layui-card">';
	html += '			<img src="'+data.flowerCover + '">';
	html += '		</div>';
	html += '	</div>';
	html += '</div>';

	return html;
}

function addShopCartHtml(data) {
	console.log((data.flowerPrice));
	console.log((data.carAmount));
	
	console.log((data.flowerPrice * data.carAmount));
	
	var html='<div class="layui-col-xs12 margintop20" data-no="'+data.flowerId+'">';
	html+='	<div class="layui-col-xs9">';
	html+='		<div class="layui-card height220">';
	html+='			<div class="layui-card-header">';
	html+='				<a class="fontBlue"';
	html+='					href="flowerServlet?method=loadFlowerById&id='+data.flowerId+'">'+data.flowerName+'</a><span';
	html+='					style="float: right">' + data.userName + '的小店</span>';
	html+='			</div>';
	html+='			<div class="layui-card-body">';
	html+='				<a';
	html+='					href="flowerServlet?method=loadFlowerById&id='+data.flowerId+'">'+ data.flowerDesc + '</a>';
	html+='			</div>';
	html+='			<div class="shopcart" data-no="'+data.flowerId+'">';
	html+='				<span class="amount">库存:'+ data.flowerAmount +'</span><span class="cartAmount">购物车数量:'+ data.carAmount + '</span>';
	html+= '			<span class="price">价格:<b>'+data.flowerPrice+'</b></span>';
	html+='				<i class="layui-icon layui-icon-cart-simple"></i> 修改数量';
	html+='				<span class="priceSum fontRed">价格:<b>'+ (data.flowerPrice * data.carAmount) +'</b></span>';
	html+='			</div>';
	html+='			<div class="delete" delete-no="'+data.flowerId+'"><i class="layui-icon layui-icon-delete"></i>删除</div>';
	html+='		</div>';
	html+='	</div>';
	html+='	<div class="layui-col-xs3 height220">';
	html+='		<div class="layui-card">';
	html+='			<img src="' + data.flowerCover + '">';
	html+='		</div>';
	html+='	</div>';
	html+='</div>';

	return html;
}

function addCategoryHtml(data) {

	var html = '';
	html += '<a class="fontBlue" target="_blank" href="flowerServlet?method=loadFlowerPage';
	html += '&typeId=' + data.typeId + '">' + data.typeName + '</a>';

	$("#category").append(html);
	return html;
}

function addOrderHtml(data) {
	var orderType = "直接购买";
	if (data.orderType == 0) {
		orderType = "租赁";
	}
	
	var html='<div class="layui-col-xs12 margintop20">';
	html+='	<div class="layui-card">';
	html+='		<div class="layui-card-header">';
	html+='			<a class="fontBlue"';
	html+='				href="orderDetailServlet?method=loadOrderDetailById&id='+ data.orderId + '"><i';
	html+='				class="layui-icon layui-icon-form"></i>订单日期：' +data.orderDate +' 订单名：'+ data.orderTitle +'</a><span';
	html+='				style="float: right">购买方式：' + orderType +' 收货地址：'+ data.finalAddress + ' <i';
	html+='				class="layui-icon layui-icon-cellphone"></i> 收货人电话号码:'+ data.finalPhone+'';
	html+='			</span>';
	html+='		</div>';
	html+='	</div>';
	html+='</div>';

	return html;
}