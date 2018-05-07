package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.User;
import model.bo.UserBO;

public class ShowEditUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public ShowEditUserController() {
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
		int idUser;
		System.out.println("hihi");
		try {
			idUser = Integer.parseInt(request.getParameter("idUser"));
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath() + "/index?msg=0");
			return;
		}
		System.out.println("id" + idUser);
		HttpSession session = request.getSession();
		if (session.getAttribute("userInfor") != null && ((User) session.getAttribute("userInfor")).getRole() == 0) {
			request.setAttribute("objUserEdit", userBO.findByIdUser(idUser));
			RequestDispatcher rd = request.getRequestDispatcher("/editUser.jsp");
			rd.forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath() + "/index?msg=0");
			return;
		}

	}

}
