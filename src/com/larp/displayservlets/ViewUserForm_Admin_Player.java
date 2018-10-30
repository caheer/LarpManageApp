package com.larp.displayservlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.larp.ejbs.UserService;
import com.larp.models.AppUser;

/**
 * Servlet implementation class EditUser
 */
@WebServlet("/ViewUserForm_Admin_Player")
public class ViewUserForm_Admin_Player extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	UserService us;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewUserForm_Admin_Player() {
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

		try {
			Integer user_id = (Integer) session.getAttribute("user_id");
		} catch (NullPointerException e) {
			String message = "You are NOT LOGGED IN or have no access rights to this page...";
			request.setAttribute("message", message);
			RequestDispatcher view = request.getRequestDispatcher("login.jsp");
			view.forward(request, response);
		}

		Integer user_id = (Integer) session.getAttribute("user_id");

		String userstatus = (String) session.getAttribute("userstatus");
		AppUser u = us.getUser(String.valueOf(user_id));
		request.setAttribute("chosen_user", u);
		RequestDispatcher view = null;
		if (userstatus.equals("Admin")) {
			view = request.getRequestDispatcher("WEB-INF/views/view_user_admin.jsp");
		} else {
			view = request.getRequestDispatcher("WEB-INF/views/view_user_player.jsp");
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

	}

}
