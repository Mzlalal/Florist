<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>MainWelcome</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <style>
        .sun{
          position: absolute;
          top: 50%;
          left: 50%;
          width:100%;
          height:100%;
          transform: translate(-50%, -50%);
          text-align:center;
          font-size:200%;
          color:#fff;
          background:#0BF;
          border-radius:5px;
        }
        .sun:before{
          content:"";
          position: absolute;
          width: 80px;height: 80px;
          left: 50%;top: 50%;
          transform: translate(-50%, -50%);
          border-radius:50%;
          background:rgba(255, 238, 68, 1);
          box-shadow: 0 0 0 15px rgba(255,255,0,0.2),0 0 15px #fff;
          z-index:-10;
        }
        .sun:after{
          content:"";
          position: absolute;
          top: 50%;left: 50%;
          height: 160px;
          width: 160px;
          transform: translate(-50%, -50%) rotate(30deg);
          z-index:-100;
          background-image:
          -webkit-linear-gradient(top,rgba(255,255,255,0) 0%, rgba(255,255,255,0.8) 50%, rgba(255,255,255,0) 100%),
          -webkit-linear-gradient(left,rgba(255,255,255,0) 0%, rgba(255,255,255,0.8) 50%, rgba(255,255,255,0) 100%);
          background-size: 20px 100%, 100% 20px;
          background-repeat: no-repeat;
          background-position: center center, center center;
          animation:sunRotate 10s linear infinite;
        }
        @keyframes sunRotate{
          0%{
            transform: translate(-50%, -50%) rotate(30deg);
          }
          100%{
            transform: translate(-50%, -50%) rotate(390deg);
          }
        }
      
      </style>
  </head>
  
  <body>
        <hgroup class="sun">
          <h1>欢迎来到花卉商城管理平台！</h1>
        </hgroup>
  </body>
</html>
