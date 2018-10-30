package com.larp.displayservlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.larp.security.LoginValidator;

/**
 * Servlet implementation class ManageUsersNewUserAdminPanel
 */
@WebServlet("/ManageUsersNewUserAdminPanel")
public class ManageUsersNewUserAdminPanel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManageUsersNewUserAdminPanel() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession(false);
		String userstatus = null;
		LoginValidator lv = new LoginValidator();
		RequestDispatcher view = null;

		try {
			userstatus = (String) session.getAttribute("userstatus");
		} catch (NullPointerException e) {
			String message = "You are NOT LOGGED IN or have no access rights to this page...";
			request.setAttribute("message", message);
			view = request.getRequestDispatcher("login.jsp");
		}

		if ((lv.isAdmin(session, userstatus)) == false) {
			String message = "You have no access rights to this page...";
			request.setAttribute("message", message);
			view = request.getRequestDispatcher("login.jsp");

		} else {
			view = request.getRequestDispatcher("WEB-INF/views/add_new_user_admin.jsp");
		}

		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
