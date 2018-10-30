package com.larp.larpmanagementservlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.larp.ejbs.LarpService;
import com.larp.models.AppUser;
import com.larp.models.Larp;

/**
 * Servlet implementation class ShowUsersInLarp
 */
@WebServlet("/ShowUsersInLarpsAdmin")
public class ShowUsersInLarpsAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	LarpService ls;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowUsersInLarpsAdmin() {
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
		RequestDispatcher view = request.getRequestDispatcher("ShowLarpsAndPlayersAdminPanel");

		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String message = null;

		Integer chosen_larp_id = null;

		try {
			chosen_larp_id = Integer.parseInt(request.getParameter("chosen_l_id"));
		} catch (NullPointerException e) {
			response.sendRedirect("ShowLarpsAndPlayersAdminPanel");
			return;
		} catch (NumberFormatException e) {
			response.sendRedirect("ShowLarpsAndPlayersAdminPanel");
			return;
		}

		chosen_larp_id = Integer.parseInt(request.getParameter("chosen_l_id"));

		List<AppUser> users_in_larp_list = (List<AppUser>) ls.getUsersInLarp(chosen_larp_id);

		Larp larp = ls.getLarp(String.valueOf(chosen_larp_id));

		message = "USERS REGISTERED FOR LARP: " + larp.getLarpTitle();

		request.setAttribute("message", message);

		request.setAttribute("users_in_larp_list", users_in_larp_list);

		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/manage_reg_larplist_admin.jsp");

		view.forward(request, response);
	}

}
