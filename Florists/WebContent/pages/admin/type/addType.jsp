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
				<div class="layui-card-header">添加类别</div>
				<div class="layui-card-body">
					<form class="layui-form" action="">

						<div class="layui-form-item">
							<label class="layui-form-label">类别名</label>
							<div class="layui-input-inline">
								<input type="text" id="typename" name="typename" lay-verify="required" placeholder="请输入类别名"
									autocomplete="on" class="layui-input">
							</div>
							<div class="layui-form-mid layui-word-aux" id="name"></div>
						</div>

						<div class="layui-form-item">
							<div class="layui-input-block">
								<button class="layui-btn layui-btn-radius" lay-submit lay-filter="submit">添加
								</button>
								<input type="reset" class="layui-btn layui-btn-radius layui-btn layui-btn-radius-primary" />
							</div>
						</div>
					</form>
				</div>
			</div>


		</div>
	</div>
	<script>
    //Demo
    layui.use(['form','laydate','element'], function(){
    	var element = layui.element;
        var form = layui.form;

        //自定义验证规则
        form.verify({
         username:function(val){
            $("#name").html("")
            verifyUsername(val);
            return  $("#name").html();
         }
        });
        
        //监听提交
        form.on('submit(submit)', function(data){
            console.log(data.field);
            data= data.field
	        $.ajax({
	            url:"typeMange",
	            type:"post",
	            data:{
	                "method":"addType",
	                "typename":data.typename
	            },
	            async:false,
	            success:function(data){
	                console.log(data);
	                if(parseInt(data) > 0){
	                   layer.msg("添加类别成功!");
	                } else {
	                   layer.msg("添加类别失败!");
	                }
	            },
	            error:function(data){
	                layer.msg("添加类别失败!");
	            }
	        });
            return false;
        });

    });
    
    function verifyUsername(val){
    	$.ajax({
            url:"typeMange",
            type:"post",
            data:{
                "method":"typeExisted",
                "typename":val
            },
            async:false,
            success:function(data){
                console.log(data);
                if(data == "true"){
                	$("#name").html("类别名:"+val+" 已存在!");
                }
            },
            error:function(data){
                $("#name").html("类别名:"+val+" 已存在!");
            }
        });
    }
</script>
</body>
</html>