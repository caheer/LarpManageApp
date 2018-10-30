package com.larp.displayservlets;

import java.io.IOException;
import java.util.List;

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
import com.larp.security.LoginValidator;

/**
 * Servlet implementation class ShowUsers
 */
@WebServlet("/ShowPlayersAndLarpsAdminPanel")
public class ShowPlayersAndLarpsAdminPanel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	UserService us;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowPlayersAndLarpsAdminPanel() {
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
			List<AppUser> auList = (List<AppUser>) us.getUsers();
			request.setAttribute("user_list", auList);
			view = request.getRequestDispatcher("WEB-INF/views/manage_reg_userlist_admin.jsp");
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
		// doGet(request, response);
	}

}