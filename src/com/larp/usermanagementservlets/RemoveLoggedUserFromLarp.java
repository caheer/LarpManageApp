package com.larp.usermanagementservlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.larp.ejbs.LarpService;

/**
 * Servlet implementation class RemoveUserFromLarp
 */
@WebServlet("/RemoveLoggedUserFromLarp")
public class RemoveLoggedUserFromLarp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	LarpService ls;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RemoveLoggedUserFromLarp() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession(false);
		Integer user_id = (Integer) session.getAttribute("user_id");

		String uid = String.valueOf(user_id);
		String lid = request.getParameter("larp_id");

		ls.removeUserFromLarp(uid, lid);

		response.sendRedirect("ShowLarpsInLoggedUser");
	}

}
