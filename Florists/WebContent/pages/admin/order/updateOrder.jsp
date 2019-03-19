<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/layui/css/layui.css" media="all">
<link rel="stylesheet" href="${pageContext.request.contextPath }/layui/css/base.css">
<script src="${pageContext.request.contextPath }/layui/layui.js"></script>
<script src="${pageContext.request.contextPath }/layui/jquery-3.2.1.js"></script>
<script src="${pageContext.request.contextPath }/layui/js/verify.js"></script>
</head>
<body style="background-color: #e2e2e2;">
	<div class="marginauto600">
		<!--注册-->
		<div class="layui-col-xs12 margintop20">
			<div class="layui-card">
				<div class="layui-card-header">修改订单</div>
				<div class="layui-card-body">
					<form class="layui-form" action="">

                        <input type="hidden" id="orderId" name="orderId" class="layui-input">
                    
						<div class="layui-form-item">
							<label class="layui-form-label">联系电话</label>
							<div class="layui-input-inline">
								<input type="text" id="finalPhone" name="finalPhone" lay-verify="required|phone" placeholder="请输入用户名联系电话"
									autocomplete="on" class="layui-input">
							</div>
						</div>

						<div class="layui-form-item">
							<label class="layui-form-label">收获地址</label>
							<div class="layui-input-block">
								<input type="text" name="finalAddress" id="finalAddress" required lay-verify="required"
									placeholder="请输入地址" autocomplete="on" class="layui-input">
							</div>
						</div>

						<div class="layui-form-item">
							<div class="layui-input-block">
								<button class="layui-btn layui-btn-radius" lay-submit lay-filter="submit">修改
								</button>
							</div>
						</div>
					</form>
				</div>
			</div>


		</div>
	</div>
	<script>
    layui.use(['form','laydate','element'], function(){
    	var element = layui.element;
        var form = layui.form;

        //自定义验证规则
        form.verify({
            phone:[/^((\+)?86|((\+)?86)?)0?1[3458]\d{9}$/,'手机号码格式不正确!']
        });
        
        //监听提交
        form.on('submit(submit)', function(data){
            data= data.field
	        $.ajax({
	            url:"orderMange",
	            type:"post",
	            data:{
	                "method":"updateOrderById",
	                "orderId":data.orderId,
	                "finalPhone":data.finalPhone,
	                "finalAddress":data.finalAddress
	            },
	            async:false,
	            success:function(data){
	            	console.log(data);
	                if(data.trim() == "true"){
	                   layer.msg("修改订单成功!");
	                } else {
	                   layer.msg("修改订单失败!");
	                }
	            },
	            error:function(data){
	                layer.msg("修改订单失败!");
	            }
	        });
            return false;
        });

        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#date' //指定元素
        });
    });

</script>
</body>
</html>