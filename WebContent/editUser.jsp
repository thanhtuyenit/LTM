<%@page import="model.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../inc/checkLogin.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Chỉnh sửa thông tin người dùng</title>
<link href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
<%
	User userInfor = (User) session.getAttribute("userInfor");
%>
<%
	if(request.getParameter("msg") != null){
		int msg = Integer.parseInt(request.getParameter("msg"));
		if(msg == 0)	
%>
	<h4 style='color:red;font-style:italic'>Chỉnh sửa thất bại!. Vui lòng thử lại!</h4>
	<%}%>
	<%
	if(request.getAttribute("objUserEdit") != null){
		User objUserEdit = (User) request.getAttribute("objUserEdit");
%>
<form action="<%=request.getContextPath()%>/editUser?idUser=<%=objUserEdit.getIdUser()%>" method="post" id="formEditUser">

<h1>Chỉnh sửa thông tin</h1>
	<table>
		<tr>
			<th align="left">Tên đăng nhập</th>
			<td>
				<input disabled="disabled" type="text" name="username" style="margin-left: 30px;" value="<%=objUserEdit.getUsername()%>">
			</td>
		</tr>
		
		<tr>
			<th align="left" >Mật khẩu hiện tại:</th>
			<td>
				<input type="password" name="nowPassword" style="margin-left: 30px;">
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
			if(objUserEdit.getIdUser() != 1){
		%>
		<tr>
				<th align="left">Loại đăng nhập</th>
				<%
					String selectedUser = null;
					String selectedAdmin = null;
					if(objUserEdit.getRole() == 0){
						selectedAdmin ="selected=\"selected\"";
					}else{
						selectedUser ="selected=\"selected\"";
					}
				%>
				<td>
					<select name="role" style="margin-left: 30px;">
						<option value="1" <%=selectedUser%> >user</option>
						<option value="0" <%=selectedAdmin%> >admin</option>
					</select>
				</td>
		</tr>
		<%}%>
		<tr>
			<th align="left">Họ và tên</th>
			<td>
				<input value="<%=objUserEdit.getFullName()%>" type="text" name="fullname" style="margin-left: 30px;">
			</td>
		</tr>
		<tr>
			<th></th>
			<td align="center"><input type="submit" value="Chỉnh sửa"></td>
		</tr>
	</table>
	<%} %>
</form>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.12.3.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/validate.js"></script>
</body>
</html>