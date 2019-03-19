<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/layui/css/layui.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/layui/css/base.css">
<script src="${pageContext.request.contextPath }/layui/layui.js"></script>
<script src="${pageContext.request.contextPath }/layui/jquery-3.2.1.js"></script>

</head>

<script>
     //更换验证码
    function anotherImg() {
        var obj = document.getElementById("codeImg");
        obj.src = "pages/util/rand.jsp?rnd=" + Math.random();
    }

     $(function(){
    	 var bakeUrl = "${bakeUrl}";
    	 console.log(bakeUrl);
    	 if (bakeUrl == "") {
    		 var temp = document.referrer;
             var arr = temp.split("/");
             $("#bakeUrl").val("/"+arr[arr.length-1]);
    	 }
     })
</script>

<body>

	<%@ include file="../util/navigation.jsp"%>

	<!--登录-->
	<div class="marginauto600">
		<div class="layui-col-xs12">
			<div class="layui-card">
				<div class="layui-card-header">登录</div>
				<div class="layui-card-body">
					<form class="layui-form" action="userOperationServlet" method = "POST">

						<input type="hidden" name="method" value="userLogin"/>

                        <input type="hidden" name="bakeUrl" id="bakeUrl" value="${bakeUrl }" />

						<div class="layui-form-item">
							<label class="layui-form-label">用户名</label>
							<div class="layui-input-inline">
								<input type="text" name="username" required
									lay-verify="required" placeholder="请输入用户名" autocomplete="on"
									class="layui-input" value="${username }">
							</div>
							<div class="layui-form-mid layui-word-aux" id="name">
								<span style="color: red;">${msg }</span>
							</div>
						</div>

						<div class="layui-form-item">
							<label class="layui-form-label">密码</label>
							<div class="layui-input-inline">
								<input type="password" name="password" required
									lay-verify="required" placeholder="请输入密码" autocomplete="off"
									class="layui-input">
							</div>
							<div class="layui-form-mid layui-word-aux" id="pwd"></div>
						</div>

						<div class="layui-form-item">
							<label class="layui-form-label">验证码</label>
							<div class="layui-input-inline">
								<input type="text" name="code" required lay-verify="required"
									placeholder="请输入验证码" autocomplete="off" class="layui-input">
							</div>
							<div class="layui-word-aux" style="padding: 0px;">
								<img id="codeImg" align="middle" height="36px"
									src="pages/util/rand.jsp" style="cursor: pointer;"
									onClick="anotherImg();" title="点击刷新" />
							</div>
						</div>

						<div class="layui-form-item">
							<div class="layui-input-block">
								<button class="layui-btn layui-btn-radius" lay-submit lay-filter="submit">立即登录</button>
								<button type="reset" class="layui-btn layui-btn-radius layui-btn layui-btn-radius-primary">重置</button>
							</div>
						</div>

						<div class="layui-form-item">
							<div class="layui-input-block">
								<a href="${pageContext.request.contextPath }/register"
									class="fontBlue">还没有账户?注册一个</a>
							</div>
						</div>

					</form>

				</div>
			</div>


		</div>
	</div>
	<script>
    layui.use(['form','element'], function(){
    	var element = layui.element;
        var form = layui.form;

        //监听提交
        form.on('submit(submit)', function(data){
            return true;
        });
    });
</script>
</body>