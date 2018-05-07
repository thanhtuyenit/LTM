<%@page import="model.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Đăng ký tài khoản</title>
<link href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
<%
	int role = 1;
	User userInfor = new User();
	if(session.getAttribute("userInfor") != null){
		userInfor = (User) session.getAttribute("userInfor");
		role = 0;
	}
%>
<% if (request.getParameter("msg") != null) {
		int msg = 0;
		try {
			msg = Integer.parseInt(request.getParameter("msg"));
		} catch (Exception e) {
			msg = 0;
		}
		switch (msg) {
		case 0:
			out.print("<h4 style='color:red;font-style:italic'>Tạo mới tài khoản thất bại. Vui lòng thử lại!</h4>");
			break;
	}}
%> 
<form action="<%=request.getContextPath()%>/register" method="post" id="formSignin">
<h1>Đăng ký tài khoản mới</h1>
	<table>
		<tr>
			<th align="left">Tên đăng nhập</th>
			<td>
				<input type="text" name="username" style="margin-left: 30px;">
			</td>
		</tr>
		<tr>
			<th align="left" >Mật khẩu</th>
			<td>
				<input type="password" name="password" id="password" style="margin-left: 30px;">
			</td>
		</tr>
		<tr>
			<th align="left">Nhập lại mật khẩu</th>
			<td>
				<input type="password" name="rePassword" style="margin-left: 30px;">
			</td>
		</tr>
		<%
			if(role == 0){
		%>
			<tr>
				<th align="left">Loại đăng nhập</th>
				<td>
					<select name="role" style="margin-left: 30px;">
						<option value="1">user</option>
						<option value="0">admin</option>
					</select>
				</td>
			</tr>
		<%} %>
		<tr>
			<th align="left">Họ và tên</th>
			<td>
				<input type="text" name="fullname" style="margin-left: 30px;">
			</td>
		</tr>
		<tr>
			<th></th>
			<td align="center"><input type="submit" value="Đăng ký"></td>
		</tr>
	</table>
</form>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.12.3.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/validate.js"></script>
</body>
</html>