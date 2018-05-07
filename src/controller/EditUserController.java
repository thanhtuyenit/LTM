package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.User;
import model.bo.UserBO;

public class EditUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditUserController() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserBO userBO = new UserBO();
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		if (session.getAttribute("userInfor") != null && ((User) session.getAttribute("userInfor")).getRole() == 0) {  
			String fullName = request.getParameter("fullname");
			String nowPassword = request.getParameter("nowPassword");
			String password = request.getParameter("password");
			int idUser = Integer.parseInt(request.getParameter("idUser"));
			int role = Integer.parseInt(request.getParameter("role"));
			if (password.equals("")) {
				// not change password
				// use old password
				password = userBO.findByIdUser(idUser).getPassword();
			} else {
				// change password
				if (!nowPassword.equals(userBO.findByIdUser(idUser).getPassword())) {
					// error - password of user login incorrect
					response.sendRedirect(request.getContextPath() + "/show-edit?idUser=" + idUser+"&msg=0");
					return;
				}
			}
			User objUser = new User(idUser, "", password, fullName, role);
			if (userBO.editUser(objUser) != 0) {
				response.sendRedirect(request.getContextPath() + "/index?msg=2");
				return;
			} else {
				response.sendRedirect(request.getContextPath() + "/index?msg=0");
				return;
			}
		}else {
			response.sendRedirect(request.getContextPath() + "/index?msg=0");
			return;
		}
	}

}
