<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>春溢</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/layui/css/layui.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/layui/css/base.css">

<script src="${pageContext.request.contextPath }/layui/layui.js"></script>
<script src="${pageContext.request.contextPath }/layui/jquery-3.2.1.js"></script>
<script src="${pageContext.request.contextPath }/layui/js/index.js"></script>
<script src="${pageContext.request.contextPath }/layui/js/shopCart.js"></script>
</head>
<body>

	<%@ include file="../util/navigation.jsp"%>

	<input type="hidden" id="path" value="${pageContext.request.contextPath }" />

	<div class="marginauto1200" id="context">
		<!--图片轮播-->
		<div class="layui-col-xs12">
			<div class="layui-carousel" id="carousel">
				<div carousel-item>
					<div>
						<img src="${pageContext.request.contextPath }/layui/images/img/01.jpg" class="marginauto1200">
					</div>
					<div>
						<img src="${pageContext.request.contextPath }/layui/images/img/02.jpg" class="marginauto1200">
					</div>
					<div>
						<img src="${pageContext.request.contextPath }/layui/images/img/03.jpg" class="marginauto1200">
					</div>
					<div>
						<img src="${pageContext.request.contextPath }/layui/images/img/04.jpg" class="marginauto1200">
					</div>
					<div>
						<img src="${pageContext.request.contextPath }/layui/images/img/05.jpg" class="marginauto1200">
					</div>
				</div>
			</div>
		</div>

		<!-- 信息检索 -->
		<div class="layui-col-xs12">
			<div class="layui-card height120">
				<div class="layui-card-header">
					<i class="layui-icon layui-icon-search"></i>信息检索
				</div>
				<div class="layui-card-body">
					<div id="category">
						<a class="fontBlue" href="javascript:;">种类:</a>
					</div>
				</div>
			</div>
		</div>

		<!-- 花朵信息 -->
		<div class="layui-col-xs12" id="flow"></div>
	</div>

	<script>
        layui.use([ 'carousel', 'element', 'flow' ], function() {
            // 开始加载
            loadCategories();
            
            var element = layui.element;
            var carousel = layui.carousel;
            //建造实例
            carousel.render({
                elem : '#carousel',
                //设置容器宽度
                width : '100%',
                height : '280px',
                //始终显示箭头
                arrow : 'hover',
                //切换动画方式
                anim : 'fade'
            });
            

            var flow = layui.flow;
            flow.load({
                elem : '#flow', //指定列表容器
                scrollElem : "#context",
                isAuto:true,
                mb:100,
                done : function(page, next) { //到达临界点（默认滚动触发），触发下一页
                    
                    var lis = [];
                
                    //以jQuery的Ajax请求为例，请求下一页数据（注意：page是从2开始返回）
                    $.ajax({
                        url : "flowerServlet",
                        data : {
                            method:"ajaxFlowerPage",
                            currentPage : page
                        },
                        type : "POST",
                        dataType: "json",
                        success:function (data) {
                            console.log(data);
                            
                            // 遍历数据
                            layui.each(data.pageData, function(index, item) {
                                lis.push(addFloewrHtml(item));
                            });
                            
                            // 下一页
                            next(lis.join(''), page < data.totalPage);
                        }
                    
                    });
                    
                },
                end : "到底啦…别扯了!",
            }); 
            
        });
        
    </script>

	<script type="text/javascript">
	    setTimeout(function(){
	        $(".shopcar").on('click',function () {
	            nowCommNum($(this).attr("data-no"));
	        });
		}, 1000);
    </script>
</body>
</html>

