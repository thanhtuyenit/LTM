<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../inc/checkLogin.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index</title>
</head>
<body>
	<%
		User userInfor = (User) session.getAttribute("userInfor");
	%>
	<h1>Chào, <%=userInfor.getUsername()%></h1>
	<h2>Chào mừng bạn đến với trang quản lý người dùng</h2>
	<form action="<%=request.getContextPath()%>/index" method="POST">
		<input type="search" placeholder="Nhập tên bạn muốn tìm kiếm" style="width: 30%; padding: 5px" name="keyword">
		<input type="submit" value="Tìm kiếm" style="padding: 5px">
	</form>
	<br>
	<%
		if(userInfor.getRole() == 0){
	%>
	<a href="<%=request.getContextPath()%>/show-register">Thêm</a>
	<%} %>
	<br>
	<br>
<% if (request.getParameter("msg") != null) {
		int msg = 0;
		try {
			msg = Integer.parseInt(request.getParameter("msg"));
		} catch (Exception e) {
			msg = 0;
		}
		switch (msg) {
		case 0:
			out.print("<h4 style='color:red;font-style:italic'>Lỗi thực thi!</h4>");
			break;
		case 1:
			out.print("<h4 style='font-style:italic'>Tạo mới tài khoản thành công!</h4>");
			break;
		case 2:
			out.print("<h4 style='font-style:italic'>Chỉnh sửa tài khoản thành công!</h4>");
			break;
		case 3:
			out.print("<h4 style='font-style:italic'>Xóa tài khoản thành công!</h4>");
			break;	
		}
	}
%> 
<%
if(request.getAttribute("listUser") != null){
	@SuppressWarnings (value="unchecked")
	ArrayList<User> listUser = (ArrayList<User>) request.getAttribute("listUser");
	if(listUser.size() > 0){
%>

	<table border="1" style="width: 100%">
		<tr>
			<th>STT</th>
			<th>Tên đăng nhập</th>
			<th>Họ tên</th>
			<th>Loại đăng nhập</th>
			<%
				if(userInfor.getRole() == 0){
			%>
			<th>Chức năng</th>
			<%} %>
		</tr>
		<%
					int i = 1;
					for(User objUser : listUser){
						String role = "user";
						if(objUser.getRole() == 0){
							role = "admin";
						}
		%>
		<tr>
			<td><%=i++%></td>
			<td><%=objUser.getUsername()%></td>
			<td><%=objUser.getFullName()%></td>
			<%
				
			%>
			<td><%=role%></td>
			<%
				if(userInfor.getRole() == 0){
			%>
			<td align="center">
				<a href="<%=request.getContextPath()%>/show-edit?idUser=<%=objUser.getIdUser()%>">Sửa</a>
				<%
					if(objUser.getIdUser() != 1){ 
				%>
				<a href="<%=request.getContextPath()%>/deleteUser?idUser=<%=objUser.getIdUser()%>" onclick="return confirm('Ban muon xoa user nay khong?')">Xóa</a>
				<%}%>
			</td>
			<%}%>
		</tr>
		<%} %>
	</table>
	<%}else{
		
	%>
		<span>Không có dữ liệu.</span>
	<%} }%>
	<br>
	<a href="<%=request.getContextPath()%>/logout">Logout</a>
</body>
</html>
