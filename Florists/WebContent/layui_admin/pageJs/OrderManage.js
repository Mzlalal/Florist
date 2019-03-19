layui.config({
	base : "js/"
}).use(['form','layer','jquery','laypage'],function(){
	var form = layui.form(),
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		$ = layui.jquery;

	//加载页面数据
	var usersData = '';
	$.get("orderMange?method=loadAllOrdersByPage&currentPage=1", function(data){
        if (data == "login") {
            window.location.href='/login';
            return;
        }
		usersData = JSON.parse(data);
		//执行加载数据的方法
		usersList();
	})

	//查询
	$(".search_btn").click(function(){
		var userArray = [];
		var index = layer.msg('查询中，请稍候',{icon: 16,shade:0.8});
        setTimeout(function(){
        	$.ajax({
				url : "orderMange",
				type : "get",
				dataType : "json",
				data:{
					"method":"loadAllOrdersByPage",
					"userId":$(".search_input").val(),
					"userName":$(".search_input").val()
				},
				success : function(data){
					usersData = data;
	            	usersList(data);
				},
				error: function (data) {
					layer.msg('查询出错啦！',{icon: 16,time:2000,shade:0.8});
				}
			})
        	
            layer.close(index);
        },500);
	})

    //全选
	form.on('checkbox(allChoose)', function(data){
		var child = $(data.elem).parents('table').find('tbody input[type="checkbox"]:not([name="show"])');
		child.each(function(index, item){
			item.checked = data.elem.checked;
		});
		form.render('checkbox');
	});

	//通过判断文章是否全部选中来确定全选按钮是否选中
	form.on("checkbox(choose)",function(data){
		var child = $(data.elem).parents('table').find('tbody input[type="checkbox"]:not([name="show"])');
		var childChecked = $(data.elem).parents('table').find('tbody input[type="checkbox"]:not([name="show"]):checked')
		if(childChecked.length == child.length){
			$(data.elem).parents('table').find('thead input#allChoose').get(0).checked = true;
		}else{
			$(data.elem).parents('table').find('thead input#allChoose').get(0).checked = false;
		}
		form.render('checkbox');
	})

	//操作==编辑
	$("body").on("click",".users_edit",function(){  
		$.ajax({
            url:"orderMange",
            type:"get",
            data:{
                "method":"selectById",
                "id":$(this).attr("data-id")
            },
            async:false,
            success:function(data){
            	var index = layui.layer.open({
        			title : "修改订单",
        			type : 2,
        			content : "updateOrder",
        			success : function(layero, index){
        				data =  JSON.parse(data);
        				var body = layui.layer.getChildFrame('body', index);
        				console.log(data);
        				body.find("#orderId").val(data.orderId);
        				body.find("#finalPhone").val(data.finalPhone);
        				body.find("#finalAddress").val(data.finalAddress);
        				
        				layui.layer.tips('点击此处返回订单管理', '.layui-layer-setwin .layui-layer-close', {
        					tips: 3
        				});
        				$("#username").val(data.username);
        			}
        		})
        		//改变窗口大小时，重置弹窗的高度，防止超出可视区域（如F12调出debug的操作）
        		$(window).resize(function(){
        			layui.layer.full(index);
        		})
        		layui.layer.full(index);
            },
            error:function(data){
                layer.msg("查询用户失败!");
            }
        });;
	})

	$("body").on("click",".users_del",function(){  //删除
		var _this = $(this);
		var id = $(this).attr("data-id");
		layer.confirm('确定删除此订单？',{icon:3, title:'提示信息'},function(index){
			$.ajax({
			    url:"orderMange",
	            type:"post",
	            data:{
	                "method":"deleteOrderById",
	                "id":id
	            },
	            success:function(data){
	            	console.log(data);
	            	if (data > 0) {
	            		layer.msg("删除成功");
	            		_this.parents("tr").remove();
	            	} else {
	            		layer.msg("删除失败");
	            	}
	            },
	            error:function(){
	            	if (data <= 0) {
	            		layer.msg("删除失败");
	            	}
	            }
			})
			for(var i=0;i<usersData.length;i++){
				if(usersData[i].usersId == _this.attr("data-id")){
					usersData.splice(i,1);
					usersList(usersData);
				}
			}
			layer.close(index);
		});
	})

	function usersList(){
		//渲染数据
		function renderDate(data,curr){
            var dataHtml = '';
			currData = usersData.pageData;
			console.log(currData);
			if(currData.length != 0){
				for(var i=0;i<currData.length;i++){
					
					dataHtml += '<tr>'
			    	+  '<td><input type="checkbox" name="checked" lay-skin="primary" lay-filter="choose"></td>'
			    	+  '<td>'+currData[i].orderId+'</td>'
			    	+  '<td>'+currData[i].orderTitle+'</td>'
			    	+  '<td>'+currData[i].orderDate+'</td>'
			    	+  '<td>'+currData[i].finalPhone+'</td>'
			    	+  '<td>'+currData[i].finalAddress+'</td>'
			    	+  '<td>'
					+    '<a class="layui-btn layui-btn-mini users_edit" data-id="'+currData[i].orderId+'"><i class="layui-icon layui-icon-edit"></i> 编辑</a>'
					+    '<a class="layui-btn layui-btn-danger layui-btn-mini users_del" data-id="'+currData[i].orderId+'"><i class="layui-icon">&#xe640;</i> 删除</a>'
			        +  '</td>'
			    	+'</tr>';
				}
			}else{
				dataHtml = '<tr><td colspan="8">暂无数据</td></tr>';
			}
		    return dataHtml;
		}

		//分页
		var nums = 10; //每页出现的数据量
		laypage({
			cont : "page",
			pages : Math.ceil(usersData.length/nums),
			jump : function(obj){
				$(".users_content").html(renderDate(usersData,obj.curr));
				$('.users_list thead input[type="checkbox"]').prop("checked",false);
		    	form.render();
			}
		})
	}
        
})