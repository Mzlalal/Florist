<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>合作商家注册</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/layui/css/layui.css" media="all">
<link rel="stylesheet"href="${pageContext.request.contextPath }/layui/css/base.css">
<script src="${pageContext.request.contextPath }/layui/layui.js"></script>
<script src="${pageContext.request.contextPath }/layui/jquery-3.2.1.js"></script>
<script src="${pageContext.request.contextPath }/layui/js/verify.js"></script>
</head>
<body style="background-color: #e2e2e2;">

   <%@ include file="../util/navigation.jsp" %>
   
<div class="marginauto600">
  <!--注册-->
  <div class="layui-col-xs12 margintop20">
    <div class="layui-card">
      <div class="layui-card-header">合作商家注册</div>
      <div class="layui-card-body">
        <form class="layui-form" action="userOperationServlet">
        
          <input type="hidden" name="method" value="sellerRegister">
        
          <div class="layui-form-item">
            <label class="layui-form-label">商家名</label>
            <div class="layui-input-inline">
              <input type="text" id="username"  name="username" required  lay-verify="required|username" placeholder="请输入商家名" autocomplete="on" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux" id="name"></div>
          </div>

          <div class="layui-form-item">
            <label class="layui-form-label">密码</label>
            <div class="layui-input-inline">
              <input type="password" id="password" name="password" required lay-verify="password" placeholder="请输入密码" autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux" id="password"></div>
          </div>

          <div class="layui-form-item">
            <label class="layui-form-label">重复密码</label>
            <div class="layui-input-inline">
              <input type="password" name="rpassword" required lay-verify="rpassword" placeholder="请重复输入密码" autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux" id="rpassword"></div>
          </div>

          <div class="layui-form-item">
            <label class="layui-form-label">地址</label>
            <div class="layui-input-block">
              <input type="text" name="address" required  lay-verify="required" placeholder="请输入地址" autocomplete="on" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux" id="address"></div>
          </div>

          <div class="layui-form-item">
            <label class="layui-form-label">电话</label>
            <div class="layui-input-inline">
              <input type="text" name="phone" required  lay-verify="phone" placeholder="请输入电话号码" autocomplete="on" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux" id="phone"></div>
          </div>
          
          <div class="layui-form-item">
            <label class="layui-form-label">&nbsp;</label>
            <button type="button" class="layui-btn layui-btn-radius" id="upload">
			  <i class="layui-icon">&#xe67c;</i>上传图片
			</button>
          </div>
          
          <div class="layui-form-item">
            <label class="layui-form-label">&nbsp;</label>
            <div class="layui-input-block" id="imgsPreview" >
            </div>
          </div>

          <div class="layui-form-item">
            <div class="layui-input-block">
              <button class="layui-btn layui-btn-radius" id="submit" lay-submit lay-filter="submit">注册成为合作商家</button>
              <input type="reset" class="layui-btn layui-btn-radius layui-btn layui-btn-radius-primary"/>
            </div>
          </div>
        </form>

      </div>
    </div>


  </div>
</div>
<script>

    layui.use(['form','element','upload'], function(){
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
        	var temp = $("#imgsPreview").html().trim();
        	
        	if (temp == "") {
        	    layer.msg("图片必须上传!");
        		return false;
        	}
        	return true;
        });

        var upload = layui.upload;
        
        //执行实例
        upload.render({
        	  elem: '#upload'
        	  ,url: 'userOperationServlet?method=uploadImgs'
        	  ,auto: true 
        	  ,choose: function(obj){
        	    //将每次选择的文件追加到文件队列
        	    var files = obj.pushFile();
        	    
        	    //预读本地文件，如果是多文件，则会遍历。(不支持ie8/9)
        	    obj.preview(function(index, file, result){
        	      console.log(file); //得到文件对象
                  
        	    });
        	  },done:function(res,index,upload){
        		  console.log(res);
        		  var html = "";
        		  html += "<img style='width:100px;height:100px;' ";
        		  html += "onclick = 'openWindow(\"layui/images/seller/"+res.imgAdress+"\")'";
        		  html += "src='layui/images/seller/"+ res.imgAdress +"' /> ";
        		  $("#imgsPreview").append(html);
        	  },error: function(res,index,upload){
        		  console.log(res);
        	    }
        	});      
    });
</script>

<script type="text/javascript">
function openWindow(imgSrc){
    var photoShow = window.open("","photoShow","toolbar=0,status=0");
    photoShow.document.write("<style type=\"text/css\">body{margin:0px;}</style>");
    photoShow.document.write("<title>查看大图</title>");
    photoShow.document.write("<img src='"+imgSrc+"'/>");
}
</script>
</body>
</html>