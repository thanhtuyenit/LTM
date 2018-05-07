<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
<a href="<%=request.getContextPath()%>/show-register">Đăng ký tài khoản mới</a>
<% if (request.getParameter("msg") != null) {
		int msg = 0;
		try {
			msg = Integer.parseInt(request.getParameter("msg"));
		} catch (Exception e) {
			msg = 0;
		}
		switch (msg) {
		case 0:
			out.print("<h4 style='color:red;font-style:italic'>Sai tên đăng nhập hoặc mật khẩu!</h4>");
			break;
		case 1:
			out.print("<h4 style='font-style:italic'>Tạo mới tài khoản thành công.Đăng nhập để tiếp tục!</h4>");
			break;
		}
	}
%> 
<form action="<%=request.getContextPath()%>/login" method="post">
<h1>Đăng nhập</h1>
	<table>
		<tr>
			<th align="left">Tên đăng nhập</th>
			<td>
				<input type="text" name="username" style="margin-left: 30px;">
			</td>
		</tr>
		<tr>
			<th align="left">Mật khẩu</th>
			<td>
				<input type="password" name="password" style="margin-left: 30px;">
			</td>
		</tr>
		<tr>
			<th></th>
			<td align="center"><input type="submit" value="Đăng nhập"></td>
		</tr>
	</table>
</form>

</body>
</html>