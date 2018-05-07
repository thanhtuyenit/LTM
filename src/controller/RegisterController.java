package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.User;
import model.bo.UserBO;

public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public RegisterController() {
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
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String fullName = request.getParameter("fullname");
		HttpSession session = request.getSession();
		int role = 1;
		if(session.getAttribute("userInfor") != null) {
			role = Integer.parseInt(request.getParameter("role"));
		}
		User objUser = new User(0, username, password, fullName,role);
		System.out.println(objUser.toString());
		
		if(userBO.checkUsername(username) == null && userBO.addUser(objUser) != 0) {
				//not existed yet
				// success
				if(session.getAttribute("userInfor") != null) {
					response.sendRedirect(request.getContextPath()+"/index?msg=1");
				}else {
					response.sendRedirect(request.getContextPath() + "/show-login?msg=1");
				}
		} else {
			// fail
			response.sendRedirect(request.getContextPath() + "/show-register?msg=0");
		}
	}

}
