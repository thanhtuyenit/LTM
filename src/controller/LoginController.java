package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.UserBO;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	public LoginController() {
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
 		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(userBO.checkLogin(username, password) != null){
			//login success
			session.setAttribute("userInfor", userBO.checkLogin(username, password));
			response.sendRedirect(request.getContextPath()+"/index");
		}else{
			//username or password invalid
			response.sendRedirect(request.getContextPath()+"/show-login-fail?msg=0");
			return;
		}
	}

}
