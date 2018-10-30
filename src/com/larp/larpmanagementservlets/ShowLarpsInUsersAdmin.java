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
import com.larp.ejbs.UserService;
import com.larp.models.AppUser;
import com.larp.models.Larp;

/**
 * Servlet implementation class ShowLarpsInUser
 */
@WebServlet("/ShowLarpsInUsersAdmin")
public class ShowLarpsInUsersAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	UserService us;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowLarpsInUsersAdmin() {
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
		RequestDispatcher view = request.getRequestDispatcher("/ShowPlayersAndLarpsAdminPanel");

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

		Integer chosen_user_id = null;

		try {
			chosen_user_id = Integer.parseInt(request.getParameter("chosen_u_id"));
		} catch (NullPointerException e) {
			response.sendRedirect("ShowPlayersAndLarpsAdminPanel");
			return;
		} catch (NumberFormatException e) {
			response.sendRedirect("ShowPlayersAndLarpsAdminPanel");
			return;
		}

		chosen_user_id = Integer.parseInt(request.getParameter("chosen_u_id"));

		List<Larp> larps_in_users_list = (List<Larp>) us.getLarpsInUser(chosen_user_id);

		AppUser u = us.getUser(String.valueOf(chosen_user_id));

		message = "LARPS FOR USER: " + u.getFirstName() + " " + u.getLastName() + " " + "NICKNAME: " + u.getNickname();

		request.setAttribute("message", message);

		request.setAttribute("larps_in_users_list", larps_in_users_list);

		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/manage_reg_userlist_admin.jsp");

		view.forward(request, response);

	}

}
