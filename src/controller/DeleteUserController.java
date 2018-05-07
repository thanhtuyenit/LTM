package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.User;
import model.bo.UserBO;

public class DeleteUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteUserController() {
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
		int idUser = Integer.parseInt(request.getParameter("idUser"));
		if (idUser != 1 && session.getAttribute("userInfor") != null
				&& ((User) session.getAttribute("userInfor")).getRole() == 0) {

			if (userBO.deleteUser(idUser) != 0) {
				response.sendRedirect(request.getContextPath() + "/index?msg=3");
				return;
			} else {
				response.sendRedirect(request.getContextPath() + "/index?msg=0");
				return;
			}
		} else {
			response.sendRedirect(request.getContextPath() + "/index?msg=0");
			return;
		}
	}

}
