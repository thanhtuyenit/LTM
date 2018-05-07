$(document).ready(function() {
	$("#formSignin").validate({
		rules : {
			"username" : {
				required : true,
				minlength : 3,
				maxlength : 40
			},

			"password" : {
				required : true,
				minlength : 3,
				maxlength : 40
			},

			"rePassword" : {
				required : true,
				equalTo : "#password",
			},
		},
		messages : {
			"username" : {
				required : "Nhập tên đăng nhập!",
				minlength : "Tên đăng nhập quá ngắn!",
				maxlength : "Tên đăng nhập quá dài!"
			},
			"password" : {
				required : "Nhập vào mật khẩu!",
				minlength : "Mật khẩu quá ngắn!",
				maxlength : "Mật khẩu quá dài!"
			},

			"rePassword" : {
				required : "Nhập mật khẩu xác nhận!",
				equalTo : "Mật khẩu xác nhận phải trùng với mật khẩu đã nhập!",
			},
		}
	});
});

$(document).ready(function() {
	$("#formEditUser").validate({
		rules : {
			
			"nowPassword" : {
				minlength : 3,
				maxlength : 40
			},
			"password" : {
				minlength : 3,
				maxlength : 40
			},

			"rePassword" : {
				equalTo : "#password",
			},
		},
		messages : {
			"nowPassword" : {
				minlength : "Mật khẩu hiện tại quá ngắn!",
				maxlength : "Mật khẩu hiện tại quá dài!"
			},
			"password" : {
				minlength : "Mật khẩu quá ngắn!",
				maxlength : "Mật khẩu quá dài!"
			},

			"rePassword" : {
				equalTo : "Mật khẩu xác nhận phải trùng với mật khẩu đã nhập!",
			},
		}
	});
});