<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>成功</title>
    <style>
     .rainbow-container{
          position: absolute;
          top: 50%;
          left: 50%;
          width:100%;
          height:100%;
          transform: translate(-50%, -50%);
          text-align:center;
          font-size:200%;
          color:#fff;
          background:#F3D166;
          border-radius:5px;
        }
        .rainbow{
          position:absolute;
          top: 50%;
          left: 50%;
          transform: translate(-50%, -50%);
          height: 1px;width: 1px;
        }
        .rainbow:before{
          content:"";
          position:absolute;
          top: 50%;left: 50%;
          transform: translate(-50%, -50%) rotate(45deg);
          height: 70px;width: 70px;
          border-radius: 100px 0 0 0;
          box-shadow:
            #F44336 -2px -2px 0 1px,
            #FF9800 -4px -4px 0 3px,
            #FFEB3B -6px -6px 0 5px,
            #8BC34A -8px -8px 0 7px,
            #00BCD4 -10px -10px 0 9px,
            #2196F3 -12px -12px 0 11px,
            #9C27B0 -14px -14px 0 13px;
          animation: rainbow 5s ease-in-out infinite;
        }
        .rainbow:after{
          content: "";
          position: absolute;
          top: 70px;
          left: 50%;
          height: 15px;
          width: 120px;
          background: rgba(0, 0, 0, .5);
          border-radius: 50%;
          transform: translate(-50%, -50%);
          animation: cloudy_shadow 5s ease-in-out infinite;
        }
        @keyframes rainbow {
          50% {
            transform: translate(-50%, -55%) rotate(30deg);
          }
          100% {
            transform: translate(-50%, -50%) rotate(45deg);
          }
        }
        @keyframes cloudy_shadow {
          50% {
            transform: translate(-50%, -50%) scale(0.8);
            background: rgba(0, 0, 0, .2);
          }
          100% {
            transform: translate(-50%, -50%) scale(1);
            background: rgba(0, 0, 0, .5);
          }
        }
    </style>
</head>
<body>
    <hgroup class="rainbow-container">
          <h1>成功,三秒后跳转至首页…<a href="${pageContext.request.contextPath}/index">点击跳转</a></h1>
          <div class="rainbow"></div>
    </hgroup>
</body>
<script type="text/javascript">

 setTimeout(function(){
	window.location.href="${pageContext.request.contextPath}/index";
}, 3000); 

</script>
</html>