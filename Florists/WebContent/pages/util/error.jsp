<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>错误</title>
    <style>
       
        .snowy-container {
          position: absolute;
          top: 50%;
          left: 50%;
          width: 100%;
          height: 100%;
          transform: translate(-50%, -50%);
          text-align: center;
          font-size: 200%;
          color: #fff;
          background: #607D8B;
          border-radius: 5px;
        }
        .snowy {
          position: absolute;
          width: 4px;
          height: 4px;
          border-radius:50%;
          top: 30%;
          left: 50%;
          background: #fff;
          border-radius: 50%;
          animation: snowy_rain 2s infinite linear;
        }
        .snowy:before {
          content: "";
          color: #333;
          position: absolute;
          height: 50px;
          width: 50px;
          top: 30px;
          left: -40px;
          background: #eee;
          transform: translate(-50%, -50%);
          border-radius: 50%;
          box-shadow:
            #eee 65px -15px 0 -5px,
            #eee 25px -25px,
            #eee 30px 10px,
            #eee 60px 15px 0 -10px,
            #eee 85px 5px 0 -5px;
          animation: cloudy 5s ease-in-out infinite;
        }
        .snowy:after {
          content: "";
          position: absolute;
          top: 120px;
          left: 50%;
          height: 15px;
          width: 120px;
          background: rgba(0, 0, 0, .5);
          border-radius: 50%;
          transform: translate(-50%, -50%);
          animation: cloudy_shadow 5s ease-in-out infinite;
        }
        @keyframes cloudy {
          50% {
            transform: translate(-50%, -70%);
          }
          100% {
            transform: translate(-50%, -50%);
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
        @keyframes snowy_rain {
          0% {
            box-shadow:
              rgba(255, 255, 255, 0) -10px 30px,
              rgba(255, 255, 255, 0) 40px 40px,
              rgba(255, 255, 255, .6) -50px 75px,
              rgba(255, 255, 255, .6) 55px 50px,
              rgba(255, 255, 255, .6) -18px 100px,
              rgba(255, 255, 255, .6) 12px 95px,
              rgba(255, 255, 255, .6) -31px 45px,
              rgba(255, 255, 255, .6) 30px 35px;
          }
          25% {
            box-shadow:
              rgba(255, 255, 255, .6) -10px 45px,
              rgba(255, 255, 255, .6) 40px 60px,
              rgba(255, 255, 255, .6) -50px 90px,
              rgba(255, 255, 255, .6) 55px 65px,
              rgba(255, 255, 255, 0) -18px 120px,
              rgba(255, 255, 255, 0) 12px 120px,
              rgba(255, 255, 255, .6) -31px 70px,
              rgba(255, 255, 255, .6) 30px 60px;
          }
          26% {
            box-shadow:
              rgba(255, 255, 255, .6) -10px 45px,
              rgba(255, 255, 255, .6) 40px 60px,
              rgba(255, 255, 255, .6) -50px 90px,
              rgba(255, 255, 255, .6) 55px 65px,
              rgba(255, 255, 255, 0) -18px 40px,
              rgba(255, 255, 255, 0) 12px 20px,
              rgba(255, 255, 255, .6) -31px 70px,
              rgba(255, 255, 255, .6) 30px 60px;
          }
          50% {
            box-shadow:
              rgba(255, 255, 255, .6) -10px 70px,
              rgba(255, 255, 255, .6) 40px 80px,
              rgba(255, 255, 255, 0) -50px 100px,
              rgba(255, 255, 255, .6) 55px 80px,
              rgba(255, 255, 255, .6) -18px 60px,
              rgba(255, 255, 255, .6) 12px 45px,
              rgba(255, 255, 255, .6) -31px 95px,
              rgba(255, 255, 255, .6) 30px 85px;
          }
          51% {
            box-shadow:
              rgba(255, 255, 255, .6) -10px 70px,
              rgba(255, 255, 255, .6) 40px 80px,
              rgba(255, 255, 255, 0) -50px 45px,
              rgba(255, 255, 255, .6) 55px 80px,
              rgba(255, 255, 255, .6) -18px 60px,
              rgba(255, 255, 255, .6) 12px 45px,
              rgba(255, 255, 255, .6) -31px 95px,
              rgba(255, 255, 255, .6) 30px 85px;
          }
          75% {
            box-shadow:
              rgba(255, 255, 255, .6) -10px 95px,
              rgba(255, 255, 255, .6) 40px 100px,
              rgba(255, 255, 255, .6) -50px 60px,
              rgba(255, 255, 255, 0) 55px 95px,
              rgba(255, 255, 255, .6) -18px 80px,
              rgba(255, 255, 255, .6) 12px 70px,
              rgba(255, 255, 255, 0) -31px 120px,
              rgba(255, 255, 255, 0) 30px 110px;
          }
          76% {
            box-shadow:
              rgba(255, 255, 255, .6) -10px 95px,
              rgba(255, 255, 255, .6) 40px 100px,
              rgba(255, 255, 255, .6) -50px 60px,
              rgba(255, 255, 255, 0) 55px 35px,
              rgba(255, 255, 255, .6) -18px 80px,
              rgba(255, 255, 255, .6) 12px 70px,
              rgba(255, 255, 255, 0) -31px 25px,
              rgba(255, 255, 255, 0) 30px 15px;
          }
          100% {
            box-shadow:
              rgba(255, 255, 255, 0) -10px 120px,
              rgba(255, 255, 255, 0) 40px 120px,
              rgba(255, 255, 255, .6) -50px 75px,
              rgba(255, 255, 255, .6) 55px 50px,
              rgba(255, 255, 255, .6) -18px 100px,
              rgba(255, 255, 255, .6) 12px 95px,
              rgba(255, 255, 255, .6) -31px 45px,
              rgba(255, 255, 255, .6) 30px 35px;
          }
        }
    </style>
</head>
<body>
    <hgroup class="snowy-container">
          <h1>页面不存在,三秒后跳转至首页…<a href="${pageContext.request.contextPath}/index">点击跳转</a></h1>
          <div class="snowy"></div>
    </hgroup>
</body>
<script type="text/javascript">

 setTimeout(function(){
	window.location.href="${pageContext.request.contextPath}/index";
}, 3000); 

</script>
</html>