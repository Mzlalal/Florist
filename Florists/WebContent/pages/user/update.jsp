<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../util/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/layui/css/layui.css" media="all">
<link rel="stylesheet"
    href="${pageContext.request.contextPath }/layui/css/base.css">
<script src="${pageContext.request.contextPath }/layui/layui.js"></script>
<script src="${pageContext.request.contextPath }/layui/jquery-3.2.1.js"></script>
<script src="${pageContext.request.contextPath }/layui/js/verify.js"></script>
</head>
<body>

   <%@ include file="../util/navigation.jsp" %>
   
<div class="marginauto600">
  <!--修改-->
  <div class="layui-col-xs12 margintop20">
    <div class="layui-card">
      <div class="layui-card-header">注册</div>
      <div class="layui-card-body">
        <form class="layui-form" action="userOperationServlet">
        
          <input type="hidden" name="method" value="userUpdate">
          <input type="hidden" id="rname" value="${user.userName }">
          <input type="hidden" name="userId" value="${user.userId }">
        
          <div class="layui-form-item">
            <label class="layui-form-label">用户名</label>
            <div class="layui-input-inline">
              <input value="${user.userName }" type="text" id="username"  name="username" required  lay-verify="username" placeholder="请输入用户名" autocomplete="on" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux" id="name"></div>
          </div>

          <div class="layui-form-item">
            <label class="layui-form-label">密码</label>
            <div class="layui-input-inline">
              <input value="${user.userPwd }" type="password" id="password" name="password" required lay-verify="password" placeholder="请输入密码" autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux" id="password"></div>
          </div>
          
        <div class="layui-form-item">
            <label class="layui-form-label">重复密码</label>
            <div class="layui-input-inline">
              <input value="${user.userPwd }" type="password" name="rpassword" required lay-verify="rpassword" placeholder="请重复输入密码" autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux" id="rpassword"></div>
          </div>
          
          <div class="layui-form-item">
            <label class="layui-form-label">性别</label>
            <div class="layui-input-block" >
              <input type="radio" name="sex" value="1" title="男" ${user.userSex == 1?"checked":"" }>
              <input type="radio" name="sex" value="2" title="女" ${user.userSex == 2?"checked":"" }>
              <input type="radio" name="sex" value="0" title="未知" ${user.userSex == 0?"checked":"" }>
            </div>
          </div>

          <div class="layui-form-item">
            <label class="layui-form-label">生日</label>
            <div class="layui-input-inline">
              <input value="${user.userBirth }" type="text" class="layui-input" name="birth" id="date" lay-verify="required" >
            </div>
          </div>

          <div class="layui-form-item">
            <label class="layui-form-label">地址</label>
            <div class="layui-input-block">
              <input value="${user.userAddress }" type="text" id="address" name="address" required  lay-verify="required" placeholder="请输入地址" autocomplete="on" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux" id="address"></div>
          </div>

          <div class="layui-form-item">
            <label class="layui-form-label">电话</label>
            <div class="layui-input-inline">
              <input value="${user.userPhone }" type="text" name="phone" required  lay-verify="required" placeholder="请输入电话号码" autocomplete="on" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux" id="phone"></div>
          </div>

          <div class="layui-form-item">
            <div class="layui-input-block">
              <button class="layui-btn layui-btn-radius" lay-submit lay-filter="submit">完成修改    </button>
              <input type="reset" class="layui-btn layui-btn-radius layui-btn layui-btn-radius-primary"/>
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
        	var old_name = $("#rname").val(); 
        	var new_name = $("#username").val();
        	
        	if (old_name != new_name) {
        		$("#name").html("")
                verifyUsername(val);
                return  $("#name").html();
        	}
        	
         },
         password: [/(.+){6,12}$/, '密码必须6到12位'],
         rpassword:function(val){
        	if (val != document.getElementById("password").value) {
        		   return "密码不一致!";
        	}
        }
        });
        
        //监听提交
        form.on('submit(submit)', function(data){
            return true;
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