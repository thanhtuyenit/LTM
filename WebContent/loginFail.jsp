<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Đăng nhập thất bại</title>
</head>
<body >
	<div align="center">
	<% if (request.getParameter("msg") != null) {
		int msg = 0;
		try {
			msg = Integer.parseInt(request.getParameter("msg"));
		} catch (Exception e) {
			msg = 0;
		}
		switch (msg) {
		case 0:
			out.print("<h4 style='color:red;font-style:italic'>Đăng nhập thất bại!</h4>");
			break;
		}
	}
%> 
<a href="<%=request.getContextPath()%>/show-register">Đăng ký tài khoản mới</a> <br>
<a href="<%=request.getContextPath()%>/show-login">Thử đăng nhập lại</a>
	</div>

</body>
</html>