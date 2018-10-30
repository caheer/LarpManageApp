package com.larp.displayservlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShowAdminPanel
 */
@WebServlet("/ShowAdminPanel")
public class ShowAdminPanel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowAdminPanel() {
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

		HttpSession session = request.getSession();

		try {
			String userstatus = (String) session.getAttribute("userstatus");
			userstatus.equals("Admin");
		} catch (NullPointerException e) {
			String message = "You are NOT LOGGED IN or have no access rights to this page...";
			request.setAttribute("message", message);
			RequestDispatcher view = request.getRequestDispatcher("login.jsp");
			view.forward(request, response);
		}

		String userstatus = (String) session.getAttribute("userstatus");
		String message = null;
		RequestDispatcher view = null;

		if (userstatus.equals("Admin")) {
			view = request.getRequestDispatcher("WEB-INF/views/admin_panel.jsp");
		} else {
			view = request.getRequestDispatcher("login.jsp");
			message = "Unauthorized access!";
			request.setAttribute("message", message);
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
