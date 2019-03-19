function verifyUsername(val) {
	$.ajax({
		url : "userOperationServlet?method=userExisted&username=" + val,
		type : "post",
		async : false,
		success : function(data) {
			console.log(data);
			if (data == "error") {
				$("#name").html("用户名:" + val + " 已存在");
			}
		},
		error : function(data) {
			$("#name").html("用户名:" + val + " 已存在");
		}
	});
}