$(function() {
	layui.use('form', function() {
	});
});

function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]); return null;
}

// 验证登录
function verifyLogin() {
	if ($("#verifyLogin").html() == "登录") {
		location.href = "http://localhost:8080/Florists/login";
	}
};

// 获取商品信息
function nowCommNum(id,status) {
	// 验证登录
	verifyLogin();

	$.ajax({
		url : "flowerServlet",
		type : "post",
		data : {
			"method" : "ajaxFlowerAmount",
			"id" : id
		},
		success : function(data) {
			console.log(data);
			// 使用回调函数
			// 刷新商品库存
			refreshCommNum(data);
			// 添加购物车
			if (status == undefined) {
				promptComm(id, data);
			}
		},
		error : function() {
			layer.msg("添加到购物车失败");
		}
	});
};

function getAmount(id) {
	$.ajax({
		url : "flowerServlet",
		type : "post",
		async:false,
		data : {
			"method" : "ajaxFlowerAmount",
			"id" : id
		},
		success : function(data) {
			console.log(data);
			// 使用回调函数
			// 刷新商品库存
			refreshCommNum(data);
			// 添加购物车
			if (status == undefined) {
				promptComm(id, data);
			}
		},
		error : function() {
			layer.msg("添加到购物车失败");
		}
	});
};

// 刷新库存
function refreshCommNum(data) {
	$("#commNumber").html(data);
};

// 输入数量
function promptComm(id, data) {
	layer.prompt({
		title : '请输入数量:',
		formType : 3
	}, function(text, index) {
		layer.close(index);
		addCar(id, text, data);
	});
};

// 添加到购物车
function addCar(id, text, nowAmount) {

	text = parseInt(text);

	console.log("id:" + id + " text:" + text + " nowAmount:" + nowAmount);
	// 判断输入的数量是否正确
	if (text == "" || text == 0 || text == undefined
			|| typeof (text) != "number" || isNaN(text)) {
		layer.msg("请输入正确的数字…");
		return;
	}

	// 如果添加的数量大于商品的数量则添加失败
	if (text > parseInt(nowAmount)) {
		layer.msg("库存不足…添加到购物车失败…");
	} else {
		// 进入ajax添加到购物车
		$.ajax({
			url : "shopCartServlet",
			type : "post",
			data : {
				"method" : "ajaxAddToCart",
				"id" : id,
				"text" : text
			},
			success : function(data) {
				if (parseInt(data) > 0) {
					var div = $("div[data-no='" + id + "']");
					div.find("span.cartAmount")
							.html("购物车数量:" + data);
					layer.msg("添加到购物车成功…");
					var amount = div.find(".price b").html();
					amount = amount.split(":");
					div.find(".priceSum").html("价格:" + (data * amount[amount.length-1]));
				} else if (parseInt(data) == -1) {
					layer.msg("库存不足 … 添加到购物车失败…");
				} else {
					layer.msg("添加到购物车失败…");
				}
				;
			},
			error : function() {
				layer.msg("添加到购物车失败…");
			}
		});
	}

};

// 商品详情添加购物车
function detailAddCart(){
	// 获取花朵id
	var id = $("#flowerId").attr("data-no");
	
	// 获取当前花朵库存
	nowCommNum(id,1);
	var nowAmount = $("#commNumber").html();
	
	// 获取添加的数量
	
	var text = $("#amount").val();

	// 添加到购物车 
	addCar(id,text,nowAmount);
}

// 购物车删除
function deleteCart(id) {
	$.ajax({
		url : "shopCartServlet",
		type : "post",
		data : {
			"method":"ajaxDeleteShopCart",
			"id" : id
		},
		success : function(data) {
			console.log(data);
			if (data > 0) {
				layer.msg("购物车删除商品成功…");
				
				// 移除动画
				 $("div[data-no='"+id+"']").animate({
						opacity : 0
					}, 'normal', 'linear', function() {
						this.remove()
					});
			} else {
				layer.msg("购物车删除商品失败…");
			}

		},
		error : function() {
			layer.msg("购物车删除商品失败…");
		}
	});
};

