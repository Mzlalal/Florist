<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
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
				<div class="layui-card-header">修改用户信息</div>
				<div class="layui-card-body">
					<form class="layui-form" action="">

                        <input type="hidden" id="id" name="id" class="layui-input">
                    
						<div class="layui-form-item">
							<label class="layui-form-label">用户名</label>
							<div class="layui-input-inline">
								<input type="text" id="username" name="username" lay-verify="required|username" placeholder="请输入用户名"
									autocomplete="on" class="layui-input">
							</div>
							<div class="layui-form-mid layui-word-aux" id="name"></div>
						</div>

						<div class="layui-form-item">
							<label class="layui-form-label">密码</label>
							<div class="layui-input-inline">
								<input type="password" id="password" name="password" required lay-verify="password" placeholder="请输入密码" autocomplete="off"
									class="layui-input">
							</div>
							<div class="layui-form-mid layui-word-aux" id="password"></div>
						</div>

						<div class="layui-form-item">
							<label class="layui-form-label">生日</label>
							<div class="layui-input-inline">
								<input type="text" class="layui-input" name="birth" id="date"
									lay-verify="required">
							</div>
						</div>

						<div class="layui-form-item">
							<label class="layui-form-label">地址</label>
							<div class="layui-input-block">
								<input type="text" name="address" id="address" required lay-verify="required"
									placeholder="请输入地址" autocomplete="on" class="layui-input">
							</div>
							<div class="layui-form-mid layui-word-aux" id="address"></div>
						</div>

						<div class="layui-form-item">
							<label class="layui-form-label">电话</label>
							<div class="layui-input-inline">
								<input type="text" name="phone" id="phone" required lay-verify="phone"
									placeholder="请输入电话号码" autocomplete="on" class="layui-input">
							</div>
							<div class="layui-form-mid layui-word-aux" id="phone"></div>
						</div>
						
						<div class="layui-form-item">
                            <label class="layui-form-label">信用分</label>
                            <div class="layui-input-inline">
                                <input type="text" name="userCredit" id="userCredit" required
                                    placeholder="请输入信用分" autocomplete="on" class="layui-input">
                            </div>
                            <div class="layui-form-mid layui-word-aux" id="phone"></div>
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
         username:function(val){
        	$("#name").html("")
        	verifyUsername(val);
        	return  $("#name").html();
         },
         password: [/(.+){6,18}$/, '密码必须6到18位'],
         rpassword:function(val){
        	if (val != document.getElementById("password").value) {
        		   return "密码不一致!";
        	}
        },
        phone:[/^((\+)?86|((\+)?86)?)0?1[3458]\d{9}$/,'手机号码格式不正确!']
        });
        
        //监听提交
        form.on('submit(submit)', function(data){
            console.log(data.field);
            data= data.field
	        $.ajax({
	            url:"usersMange",
	            type:"post",
	            data:{
	                "method":"addUser",
	                "username":data.username,
	                "password":data.password,
	                "sex":data.sex,
	                "birth":data.birth,
	                "address":data.address,
	                "phone":data.phone
	            },
	            async:false,
	            success:function(data){
	                console.log(data);
	                if(parseInt(data) > 0){
	                   layer.msg("添加用户成功!");
	                } else {
	                   layer.msg("添加用户失败!");
	                }
	            },
	            error:function(data){
	                layer.msg("添加用户失败!");
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
    
    function verifyUsername(val){
    	$.ajax({
            url:"userOperationServlet",
            type:"post",
            data:{
                "method":"userExisted",
                "username":val
            },
            async:false,
            success:function(data){
                console.log(data);
                if(data == "error"){
                	$("#name").html("用户名:"+val+" 已存在!");
                }
            },
            error:function(data){
                $("#name").html("用户名:"+val+" 已存在!");
            }
        });
    }
</script>
</body>
</html>