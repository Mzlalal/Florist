$(function() {
	layui.use('form', function() {
	});
});
//购物车查询数量
function loadCartNum(id) {
	$.ajax({
		url : "shopCartServlet",
		type : "post",
		data : {
			"method":"ajaxShopCartNum",
			"id" : id
		},
		success : function(data) {
			console.log(data);
			if (data > 0) {
				$("#amount").val(data);
			}
		},
		error : function() {
			layer.msg("商品购物车数量加载失败");
		}
	});
};

// 生成订单
function createOrder(data) {
	// 获取id
    var id = $("#flowerId").attr("data-no");
    
    // 获取日期
    var date = new Date();
    var nowDate = "";
    nowDate += date.getFullYear()+"-";
    nowDate += date.getMonth() + 1 +"-";
    
    if (date.getDate() < 10) {
        nowDate += '0'+date.getDate();
    }else {
        nowDate += date.getDate();
    }
    nowDate += "  "+ (date.getHours()+1) +"时";
    nowDate += date.getMinutes() +"分";
    nowDate += date.getSeconds() +"秒";
    
    // 获取标题
    var orderTitle = $("#flowerId").html();
    
    $.ajax({
        url:"orderServlet",
        type:"post",
        data : {
            method : "ajaxCreateOrder",
            orderType : data.type,
            flowerId : id,
            orderDate : nowDate,
            orderTitle : orderTitle,
            amount : data.amount,
            address : data.address,
            phone : data.phone
        },
        success : function(data) {
            console.log(data);
            if (data > 0) {
                layer.msg("购买成功!");
            } else {
                layer.msg("购买失败,等待刷新库存!");
                // 刷新库存
                getAmount(id);
            }
        },
        error : function(data) {
            location.href = data.responseText;
        }
    });
};